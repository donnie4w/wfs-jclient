# wfs-jclient

###### WFS的JAVA实现访问接口

------------
maven 

    <dependency>    
        <groupId>io.github.donnie4w</groupId>    
        <artifactId>wfs-jclient</artifactId>    
        <version>1.0.1</version>
    </dependency>
------------

创建wfsclient实例对象

    public WfsClient newClient() throws WfsException {
        WfsClient wc = new WfsClient();
        boolean ok = wc.newConnect(false, "127.0.0.1", 6802, "admin", "123");
        if (!ok) {
            System.out.println("connect failed");
            return null;
        }
        return wc;
    }

参数说明：wc.newConnect(false, "127.0.0.1", 6802, "admin", "123")
1. 第一个参数：是否TLS
2. 第二个参数：wfs thrift 服务ip或域名
3. 第三个参数：端口
4. 第四个参数：后台用户名
5. 第五个参数：后台密码

------------
上传文件

    public void append() throws WfsException, IOException {
        String dir = System.getProperty("user.dir") + "/src/test/java/io/github/donnie4w/wfs/test/";
        WfsClient wc = newClient();
        WfsFile wf = new WfsFile();
        wf.setName("test/java/1.jpeg");
        wf.setData(Files.readAllBytes(Paths.get(dir + "1.jpeg")));
        wc.append(wf);
    }

拉取 文件

    public void get() throws WfsException {
        WfsClient wc = newClient();
        WfsData wd = wc.get("test/java/1.jpeg");
        System.out.println(wd.getData() == null ? "data is null" : wd.getData().length);
    }

删除文件

    public void delete() throws WfsException {
        WfsClient wc = newClient();
        WfsAck wa = wc.delete("test/java/1.jpeg");
        System.out.println(wa.ok);
        if (!wa.ok) {
            System.out.println(wa.getError().getInfo());
        }
    }
