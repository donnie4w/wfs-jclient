# wfs-jclient
**WFS的JAVA实现访问接口**


------------
上传文件

    获取wfs客户端实例：
	WfsClient wc = new WfsClient("http://127.0.0.1:3434/thrift")
	//读取文件
	File f = new File("1.jpg");
	FileInputStream fis = new FileInputStream(f);
	byte[] bs = new byte[(int) f.length()];
	fis.read(bs);
	//上传 文件bytes, 文件名
    wc.wfsPost(bs, "100.jpg", "jpg");
	//相当于：curl -F "file=@1.jpg" "http://127.0.0.1:3434/u/100.jpg"
	//1.jpg 是本地文件，100.jpg是上传到服务自定义的文件名，
	//也可以：
	wc.wfsPost(bs, "fff/ggg/1.jpg", "");
	//访问则为：http://127.0.0.1:3434/r/fff/ggg/1.jpg
	
拉取 文件

	byte[] bs = wc.wfsGet("100.jpg");
	//相当于：http://127.0.0.1:3434/r/22.jpg
	byte[] bs = wc.wfsGet("fff/ggg/22.jpg");
	//相当于：http://127.0.0.1:3434/r/fff/ggg/22.jpg

删除文件

	 wc.wfsDel("100.jpg");
	//相当于curl -X DELETE "http://127.0.0.1:3434/d/100.jpg"

具体参考 项目测试用例

