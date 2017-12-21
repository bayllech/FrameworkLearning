package cn.bayllech.project;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.Iterator;
import java.util.Set;

/**
 * @Author bei.qi
 * @Description
 * @Date 2017-12-21 10:48
 */
public class RedisTest {
    
    @Test
    public void connectRedis() {
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("aliyun");
        System.out.println("连接成功");
        //查看服务是否运行
        System.out.println("服务正在运行: "+jedis.ping());
        
/*        jedis.set("runoobkey", "www.runoob.com");
        // 获取存储的数据并输出
        System.out.println("redis 存储的字符串为: "+ jedis.get("runoobkey"));*/

        //存储数据到列表中
/*        jedis.lpush("site-list", "Runoob");
        jedis.lpush("site-list", "Google");
        jedis.lpush("site-list", "Taobao");
        // 获取存储的数据并输出
        List<String> list = jedis.lrange("site-list", 0 ,2);
        for(int i=0,length=list.size(); i<length; i++) {
            System.out.println("列表项为: "+list.get(i));
        }*/
    
        // 获取数据并输出
        Set<String> keys = jedis.keys("*");
        Iterator<String> it=keys.iterator() ;
        while(it.hasNext()){
            String key = it.next();
            System.out.println(key);
        }


    }
}
