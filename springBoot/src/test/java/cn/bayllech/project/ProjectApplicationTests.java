package cn.bayllech.project;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectApplicationTests {

	@Test
	public void contextLoads() {
		/*JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxTotal(10);
		config.setMaxIdle(5);
		JedisPool jedisPool = new JedisPool(config,"106.15.224.201",6379,10000);
		Jedis jedis = jedisPool.getResource();
		jedis.set("name", "aliRedis");
		String name = jedis.get("name");
		System.out.println(name);
		jedis.close();*/
	}

}
