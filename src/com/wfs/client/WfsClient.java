/**
 * Project Name:wfs-jclient
 * File Name:Client.java
 * Package Name:com.wfs.client
 * Date:2017��4��6������3:15:20
 * Copyright (c) 2017, donnie4w@gmail.com All Rights Reserved.
 *
 */

package com.wfs.client;

import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.THttpClient;
import org.apache.thrift.transport.TTransport;

import com.wfs.protocol.IWfs;
import com.wfs.protocol.WfsAck;
import com.wfs.protocol.WfsFile;

/**
 * ClassName:Client <br/>
 * Date: 2017��4��6�� ����3:15:20 <br/>
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
	private TTransport tt;
	private IWfs.Client client;
	
	public WfsClient(String url) throws WfsException {
		this.url = url;
		conn();
	}

	public WfsClient(String url, int readTimeout, int connectionTimeout)throws WfsException {
		this.url = url;
		this.readTimeout = readTimeout;
		this.connectionTimeout = connectionTimeout;
		conn();
	}
	
	private void conn() throws WfsException{
		try {
			tt = getTTransport();
			TProtocol protocol = new TCompactProtocol(tt);
			client = new IWfs.Client(protocol);
			tt.open();
		} catch (Exception e) {
			throw new WfsException(e);
		} 
	} 

	private TTransport getTTransport() throws WfsException {
		try {
			THttpClient tc = new THttpClient(url);
			tc.setReadTimeout(readTimeout);
			tc.setConnectTimeout(connectionTimeout);
			return (TTransport) tc;
		} catch (Exception e) {
			throw new WfsException(e);
		}
	}
	
	public void Close() {
		if (tt!=null) {
			tt.close();
		}
	}

	public void wfsPost(byte[] bs, String name, String fileType) throws WfsException {
		try {
			WfsFile wf = new WfsFile();
			wf.setFileBody(bs);
			wf.setFileType(fileType);
			wf.setName(name);
			client.wfsPost(wf);
		} catch (Exception e) {
			throw new WfsException(e);
		} 

	}

	public byte[] wfsGet(String name) throws WfsException {
		try {
			WfsFile wf = client.wfsRead(name);
			return wf.getFileBody();
		} catch (Exception e) {
			throw new WfsException(e);
		} 
	}

	public WfsAck wfsDel(String name) throws WfsException {
		WfsAck wa = null;
		try {
			wa=client.wfsDel(name);
		} catch (Exception e) {
			throw new WfsException(e);
		} 
		return wa;
	}

}
