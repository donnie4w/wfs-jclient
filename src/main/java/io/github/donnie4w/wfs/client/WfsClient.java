/**
 * Copyright 2023 wfs Author. All Rights Reserved.
 * email: donnie4w@gmail.com
 * https://githuc.com/donnie4w/wfs
 * https://githuc.com/donnie4w/wfs-jclient
 */

package io.github.donnie4w.wfs.client;

import io.github.donnie4w.wfs.stub.*;
import org.apache.thrift.TConfiguration;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

import javax.net.ssl.*;
import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;

public class WfsClient {

    public final static Logger logger = Logger.getLogger("WfsClient");
    public TConfiguration tc = new TConfiguration();
    private TTransport transport;
    private WfsIface.Client conn;
    private String host;
    private int port;
    private boolean tls;
    private String name;
    private String pwd;
    private final AtomicInteger connId = new AtomicInteger(0);
    private final AtomicInteger pingNum = new AtomicInteger(0);
    private int connectTimeout = 10 * 1000;
    private int socketTimeout = 60 * 1000;

    public WfsClient() {
    }

    public WfsClient(int connectTimeout, int socketTimeout) {
        this.connectTimeout = connectTimeout;
        this.socketTimeout = socketTimeout;
    }

    private WfsAck connect(boolean tls, String host, int port, String name, String pwd) throws WfsException{
        try {
            this.tls = tls;
            this.host = host;
            this.port = port;
            this.name = name;
            this.pwd = pwd;
            if (tls) {
                X509TrustManager xtm = new X509TrustManager() {
                    public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                    }

                    public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                    }

                    public X509Certificate[] getAcceptedIssuers() {
                        return null;
                    }
                };
                SSLContext ctx = SSLContext.getInstance("TLSv1.2");
                ctx.init(null, new TrustManager[]{xtm}, null);
                SSLSocket socket = (SSLSocket) ctx.getSocketFactory().createSocket(host, port);
                TSocket ts = new TSocket(socket);
                ts.setConnectTimeout(this.connectTimeout);
                ts.setSocketTimeout(this.socketTimeout);
                transport = ts;
            } else {
                transport = new TSocket(this.tc, host, port, this.socketTimeout, this.connectTimeout);
            }
            if (!transport.isOpen()) {
                transport.open();
            }
            TProtocol protocol = new TCompactProtocol(transport);
            this.conn = new WfsIface.Client(protocol);
            this.pingNum.set(0);
            WfsAuth wa = new WfsAuth();
            wa.setName(name);
            wa.setPwd(pwd);
            return this.auth(wa);


        } catch (Exception e) {
            throw new  WfsException(e);
        }
    }


    private WfsAck connectByPem(boolean tls, String host, int port, String name, String pwd) throws WfsException {
        try {
            this.tls = tls;
            this.host = host;
            this.port = port;
            this.name = name;
            this.pwd = pwd;

            if (tls) {
                KeyStore trustStore  = KeyStore.getInstance(KeyStore.getDefaultType());
                trustStore.load(new FileInputStream("trusted_certs.pem"), "CA.PASSWORD".toCharArray());

                TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                tmf.init(trustStore);

                X509TrustManager x509Tm = null;
                for (TrustManager tm : tmf.getTrustManagers()) {
                    if (tm instanceof X509TrustManager) {
                        x509Tm = (X509TrustManager) tm;
                        break;
                    }
                }

                if (x509Tm == null) {
                    throw new IllegalStateException("No X509TrustManager found");
                }

                SSLContext sslContext = SSLContext.getInstance("TLSv1.2");
                sslContext.init(null, new TrustManager[]{x509Tm}, null);
                SSLSocketFactory sf = sslContext.getSocketFactory();
                SSLSocket socket = (SSLSocket) sf.createSocket(host, port);

                TSocket ts = new TSocket(socket);
                ts.setConnectTimeout(this.connectTimeout);
                ts.setSocketTimeout(this.socketTimeout);
                transport = ts;
            } else {
                transport = new TSocket(this.tc, host, port, this.socketTimeout, this.connectTimeout);
            }

            if (!transport.isOpen()) {
                transport.open();
            }

            TProtocol protocol = new TCompactProtocol(transport);
            this.conn = new WfsIface.Client(protocol);
            this.pingNum.set(0);
            WfsAuth wa = new WfsAuth();
            wa.setName(name);
            wa.setPwd(pwd);
            return this.auth(wa);

        } catch (Exception e) {
            throw new WfsException(e);
        }
    }

    public synchronized byte ping() throws TException {
        return this.conn.Ping();
    }

    public synchronized WfsAck auth(WfsAuth wa) throws TException {
        return this.conn.Auth(wa);
    }

    public synchronized void close() {
        connId.incrementAndGet();
        if (this.transport != null) {
            this.transport.close();
        }
    }

    public boolean newConnect(boolean tls, String host, int port, String name, String pwd) throws WfsException {
        int i = connId.incrementAndGet();
        WfsAck ack = this.connect(tls, host, port, name, pwd);
        if (!ack.ok) {
            logger.warning("connect failed:" + ack.error.getInfo());
            return false;
        }
        new Thread(() -> {
            while (i == connId.get()) {
                try {
                    Thread.sleep(3000);
                    this.pingNum.incrementAndGet();
                    if (this.ping() == 1) {
                        this.pingNum.decrementAndGet();
                    }
                } catch (Exception e) {
                }
                if (this.pingNum.get() > 5 && i == connId.get()) {
                    this.reconnect();
                }
            }
        }).start();
        return  true;
    }

    public void reconnect() {
        try {
            if (this.transport != null) {
                this.transport.close();
            }
            logger.info("reconnect");
            this.connect(this.tls, this.host, this.port, this.name, this.pwd);
        } catch (Exception e) {
        }
    }

    public synchronized WfsAck append(WfsFile wf) throws WfsException {
        try {
            return this.conn.Append(wf);
        } catch (TException e) {
            throw new WfsException(e);
        }
    }

    public synchronized WfsAck delete(String path) throws WfsException {
        try {
            return this.conn.Delete(path);
        } catch (TException e) {
            throw new WfsException(e);
        }
    }

    public synchronized WfsData get(String path) throws WfsException {
        try {
            return this.conn.Get(path);
        } catch (TException e) {
            throw new WfsException(e);
        }
    }
}
