import java.io.File;
import java.io.FileInputStream;

import com.wfs.client.WfsClient;
import com.wfs.client.WfsException;

/**
 * Project Name:wfs-jclient
 * File Name:ClientTest.java
 * Package Name:
 * Date:2017年4月14日下午1:52:27
 * Copyright (c) 2017, donnie4w@gmail.com All Rights Reserved.
 *
 */

/**
 * ClassName:ClientTest <br/>
 * Date: 2017年4月14日 下午1:52:27 <br/>
 * 
 * @author dong
 * @version
 * @since JDK 1.7
 * @desc
 */
public class ClientTest {

	public static void wfsPost() throws Exception {
		File f = new File("C:/Users/dong/Desktop/wfs/1.jpg");
		FileInputStream fis = new FileInputStream(f);
		byte[] bs = new byte[(int) f.length()];
		fis.read(bs);
		WfsClient wc = new WfsClient("http://127.0.0.1:3434/thrift");
		wc.wfsPost(bs, "100.jpg", "jpg");
	}

	public static void wfsRead() throws WfsException {
		WfsClient wc = new WfsClient("http://127.0.0.1:3434/thrift");
		byte[] bs = wc.wfsRead("100.jpg");
		System.out.println(bs.length);
	}

	public static void main(String[] args) throws Exception {
		wfsPost();
		wfsRead();
	}

}
