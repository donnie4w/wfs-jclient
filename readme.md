wfs的thrift java实现访问接口   <p/> 
  WfsPost()        //上传文件  <p/>
  wfsRead()        //拉取文件  <p/>
  wfsDel()         //删除文件  <p/>


WfsClient wc = new WfsClient("http://127.0.0.1:3434/thrift");
wc.wfsPost(bs, "100.jpg", "jpg");		
				
byte[] bs = wc.wfsRead("100.jpg");
	
	