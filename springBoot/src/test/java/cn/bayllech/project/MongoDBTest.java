package cn.bayllech.project;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author bei.qi
 * @Description
 * @Date 2017-12-15 9:00
 */
public class MongoDBTest {
    
    MongoCollection<Document> collection = null;
    
    @Before
    public void jdbcTest() {
        // 连接到 mongodb 服务
        MongoClient mongoClient = new MongoClient("aliyun", 27017);
        
        // 连接到数据库
        MongoDatabase mongoDatabase = mongoClient.getDatabase("test");
        System.out.println("Connect to mongodb-test successfully");

       /* mongoDatabase.createCollection("javaCol");
        System.out.println("集合创建成功");*/
        
        collection = mongoDatabase.getCollection("collection");
        System.out.println("集合 collection 选择成功");
        
    }
    
    @After
    public void findAll() {
        //检索所有文档
        /**
         * 1. 获取迭代器FindIterable<Document>
         * 2. 获取游标MongoCursor<Document>
         * 3. 通过游标遍历检索出的文档集合
         * */
        FindIterable findIterable = collection.find();
        MongoCursor<Document> cursor = findIterable.iterator();
        while (cursor.hasNext()) {
            System.out.println(cursor.next());
        }
        
    }
    
    @Test
    public void insert() {
        //插入文档
        /**
         * 1. 创建文档 org.bson.Document 参数为key-value的格式
         * 2. 创建文档集合List<Document>
         * 3. 将文档集合插入数据库集合中 mongoCollection.insertMany(List<Document>) 插入单个文档可以用 mongoCollection.insertOne(Document)
         * */
        Document document = new Document("title", "mongodb-java")
                .append("description", "database")
                .append("likes", 100)
                .append("by", "Fly");
    
        List<Document> documents = new ArrayList<Document>();
        documents.add(document);
        
        collection.insertMany(documents);
        System.out.println("文档插入成功");
    }
    
    
    @Test
    public void update() {
        collection.updateMany(Filters.eq("title", "MongoDB 教程"), new Document("$set",new Document("title","MongoDB")));
    }
    
    @Test
    public void delete() {
        collection.deleteOne(Filters.eq("title", "mongodb-java"));
    }
    
    
    
    
}
