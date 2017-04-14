/**
 * Project Name:wfs-jclient
 * File Name:Client.java
 * Package Name:com.wfs.client
 * Date:2017年4月6日下午3:15:20
 * Copyright (c) 2017, donnie4w@gmail.com All Rights Reserved.
 *
 */

package com.wfs.client;

import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.THttpClient;
import org.apache.thrift.transport.TTransport;

import com.wfs.protocol.IWfs;
import com.wfs.protocol.WfsFile;

/**
 * ClassName:Client <br/>
 * Date: 2017年4月6日 下午3:15:20 <br/>
 * 
 * @author dong
 * @version
 * @since JDK 1.7
 * @desc
 */
public class WfsClient {
	private String url;
	private int readTimeout = 30000;
	private int connectionTimeout = 30000;

	public WfsClient(String url) {
		this.url = url;
	}

	public WfsClient(String url, int readTimeout, int connectionTimeout) {
		this.url = url;
		this.readTimeout = readTimeout;
		this.connectionTimeout = connectionTimeout;

	}

	public TTransport getTTransport() throws WfsException {
		try {
			THttpClient tc = new THttpClient(url);
			tc.setReadTimeout(readTimeout);
			tc.setConnectTimeout(connectionTimeout);
			return (TTransport) tc;
		} catch (Exception e) {
			throw new WfsException(e);
		}
	}

	public void wfsPost(byte[] bs, String name, String fileType) throws WfsException {
		TTransport tt = null;
		try {
			tt = getTTransport();
			TProtocol protocol = new TCompactProtocol(tt);
			IWfs.Client tc = new IWfs.Client(protocol);
			tt.open();
			WfsFile wf = new WfsFile();
			wf.setFileBody(bs);
			wf.setFileType(fileType);
			wf.setName(name);
			tc.wfsPost(wf);
		} catch (Exception e) {
			throw new WfsException(e);
		} finally {
			if (tt != null) {
				tt.close();
			}
		}
	}

	public byte[] wfsRead(String name) throws WfsException {
		TTransport tt = null;
		try {
			tt = getTTransport();
			TProtocol protocol = new TCompactProtocol(tt);
			IWfs.Client tc = new IWfs.Client(protocol);
			tt.open();
			WfsFile wf = tc.wfsRead(name);
			return wf.getFileBody();
		} catch (Exception e) {
			throw new WfsException(e);
		} finally {
			if (tt != null) {
				tt.close();
			}
		}
	}

	public void wfsDel(String name) throws WfsException {
		TTransport tt = null;
		try {
			tt = getTTransport();
			TProtocol protocol = new TCompactProtocol(tt);
			IWfs.Client tc = new IWfs.Client(protocol);
			tt.open();
			tc.wfsDel(name);
		} catch (Exception e) {
			throw new WfsException(e);
		} finally {
			if (tt != null) {
				tt.close();
			}
		}
	}

}
