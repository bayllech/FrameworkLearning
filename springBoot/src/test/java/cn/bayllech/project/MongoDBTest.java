package cn.bayllech.project;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.junit.Test;

/**
 * @Author bei.qi
 * @Description
 * @Date 2017-12-15 9:00
 */
public class MongoDBTest {
    
    
    @Test
    public void jdbcTest(){
        try{
            // 连接到 mongodb 服务
            MongoClient mongoClient = new MongoClient( "aliyun" , 27017 );
            
            // 连接到数据库
            MongoDatabase mongoDatabase = mongoClient.getDatabase("test");
            System.out.println("Connect to mongodb-test successfully");
            
        }catch(Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
    }
}
