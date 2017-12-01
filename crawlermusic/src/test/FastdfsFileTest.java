import org.apache.commons.io.IOUtils;
import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @Author bei.qi
 * @Description
 * @Date 2017-11-30 18:54
 */
public class FastdfsFileTest {
    @Test
    public void uploadFile() throws IOException, MyException {
        Properties properties = new Properties();
        properties.setProperty(ClientGlobal.PROP_KEY_TRACKER_SERVERS,"106.15.224.201:22122");
        //初始化配置
        ClientGlobal.initByProperties(properties);
        
        TrackerClient client = new TrackerClient();
        TrackerServer trackerServer = client.getConnection();
        //存储服务器的客户端
        StorageClient storageClient = new StorageClient(trackerServer,null);
        
        InputStream inputStream = new FileInputStream("D:/1.png");
        byte[] bytes = IOUtils.toByteArray(inputStream);
        
        String[] results = storageClient.upload_file(bytes,"png",null);
        for(String str : results) {
            System.out.println(str);
        }
        
        inputStream.close();
    }
    
    @Test
    public void downloadFile() throws IOException, MyException {
        Properties properties = new Properties();
        properties.setProperty(ClientGlobal.PROP_KEY_TRACKER_SERVERS,"106.15.224.201:22122");
        //初始化配置
        ClientGlobal.initByProperties(properties);
        
        TrackerClient client = new TrackerClient();
        TrackerServer trackerServer = client.getConnection();
        //存储服务器的客户端
        StorageClient storageClient = new StorageClient(trackerServer,null);
        
        byte[] bytes = storageClient.download_file("group1","M00/00/00/rBPua1of9zCAZIJSAABdrZgsqUU432_big.jpg");
        
        FileOutputStream outputStream = new FileOutputStream("D:/new.jpg");
        outputStream.write(bytes,0,bytes.length);
        outputStream.flush();
        outputStream.close();
    }
    
    
}
