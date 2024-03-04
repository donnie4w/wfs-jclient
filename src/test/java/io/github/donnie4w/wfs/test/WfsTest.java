package io.github.donnie4w.wfs.test;

import io.github.donnie4w.wfs.client.WfsClient;
import io.github.donnie4w.wfs.client.WfsException;
import io.github.donnie4w.wfs.stub.WfsAck;
import io.github.donnie4w.wfs.stub.WfsData;
import io.github.donnie4w.wfs.stub.WfsFile;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

public class WfsTest {

    public WfsClient newClient() throws WfsException {
        WfsClient wc = new WfsClient();
        boolean ok = wc.newConnect(false, "127.0.0.1", 6802, "admin", "123");
        if (!ok) {
            System.out.println("connect failed");
            return null;
        }
        return wc;
    }

    @Test
    public void append() throws WfsException, IOException {
        String dir = System.getProperty("user.dir") + "/src/test/java/io/github/donnie4w/wfs/test/";
        WfsClient wc = newClient();
        WfsFile wf = new WfsFile();
        wf.setName("test/java/1.jpeg");
        wf.setData(Files.readAllBytes(Paths.get(dir + "1.jpeg")));
        wc.append(wf);
    }

    @Test
    public void delete() throws WfsException {
        WfsClient wc = newClient();
        WfsAck wa = wc.delete("test/java/1.jpeg");
        System.out.println(wa.ok);
        if (!wa.ok) {
            System.out.println(wa.getError().getInfo());
        }
    }

    @Test
    public void get() throws WfsException {
        WfsClient wc = newClient();
        WfsData wd = wc.get("test/java/1.jpeg");
        System.out.println(wd.getData() == null ? "data is null" : wd.getData().length);
    }

}
