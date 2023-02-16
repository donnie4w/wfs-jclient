import java.io.File;
import java.io.FileInputStream;

import com.wfs.client.WfsClient;
import com.wfs.client.WfsException;

/**
 * Project Name:wfs-jclient
 * File Name:ClientTest.java
 * Package Name:
 * Date:2017��4��14������1:52:27
 * Copyright (c) 2017, donnie4w@gmail.com All Rights Reserved.
 *
 */

/**
 * ClassName:ClientTest <br/>
 * Date: 2017��4��14�� ����1:52:27 <br/>
 * 
 * @author dong
 * @version
 * @since JDK 1.7
 * @desc
 */
public class ClientTest {

	public static void wfsPostFile() throws Exception {
		File f = new File("1.jpg");
		FileInputStream fis = new FileInputStream(f);
		byte[] bs = new byte[(int) f.length()];
		fis.read(bs);
		WfsClient wc = new WfsClient("http://127.0.0.1:3434/thrift");
		wc.wfsPost(bs, "100.jpg", "jpg");
		wc.Close();
	}

	public static void wfsGetFile() throws WfsException {
		WfsClient wc = new WfsClient("http://127.0.0.1:3434/thrift");
		byte[] bs = wc.wfsGet("100.jpg");
		System.out.println(bs.length);
		wc.Close();
	}

	public static void wfsDelFile() throws WfsException {
		WfsClient wc = new WfsClient("http://127.0.0.1:3434/thrift");
		wc.wfsDel("100.jpg");
		wc.Close();
	}

	public static void main(String[] args) throws Exception {
		wfsPostFile();
		wfsGetFile();
		wfsDelFile();
	}

}
