package cn.bayllech.util;

/**
 * @Author bei.qi
 * @Date 2017-08-29 14:15
 */
import java.io.File;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient1;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;

public class FastdfsUtil {
    private static TrackerClient trackerClient = null;
    private static TrackerServer trackerServer = null;
    private static StorageServer storageServer = null;
    private static StorageClient1 storageClient = null;
    private static String conf = null;

    public FastdfsUtil() {
    }

    public static void setConf(String conf) {
        conf = conf;
    }

    private static void init() {
        try {
            ClientGlobal.init(conf);
            trackerClient = new TrackerClient();
            trackerServer = trackerClient.getConnection();
            storageServer = null;
            storageClient = new StorageClient1(trackerServer, storageServer);
        } catch (Exception var1) {
            var1.printStackTrace();
        }

    }

    public static String getConf() {
        return conf;
    }

    public static String upload(File file) {
        if (file == null) {
            throw new RuntimeException("fastdfs文件上传失败:文件不存在");
        } else if (!file.exists()) {
            throw new RuntimeException("fastdfs文件上传失败:文件不存在");
        } else {
            if (storageClient == null) {
                init();
            }

            try {
                String result = storageClient.upload_file1(file.getPath(), (String)null, (NameValuePair[])null);
                return result;
            } catch (Exception var2) {
                throw new RuntimeException("上次文件失败：" + var2.getMessage(), var2);
            }
        }
    }

    public static String upload(byte[] bytes, String fileName, long fileSize) {
        if (storageClient == null) {
            init();
        }

        try {
            NameValuePair[] metaList = new NameValuePair[]{new NameValuePair("fileName", fileName), new NameValuePair("fileExtName", getExtName(fileName)), new NameValuePair("fileLength", String.valueOf(fileSize))};
            return "/" + storageClient.upload_file1(bytes, getExtName(fileName), metaList);
        } catch (Exception var5) {
            throw new RuntimeException("上传文件失败", var5);
        }
    }

    private static String getExtName(String fileName) {
        if (fileName.isEmpty()) {
            return "null";
        } else if (fileName.contains(".")) {
            try {
                return fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
            } catch (Exception var2) {
                return "null";
            }
        } else {
            return "null";
        }
    }
}
