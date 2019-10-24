package demo;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class JedisTest {
	
	@Test
	public void testJedis(){
		//建对象；
		Jedis jedis = new Jedis("10.198.1.5", 6379);
		Map<String, Double> d = new HashMap<String, Double>() ;
		d.put("aaa", 1D);
		d.put("bbb", 1D);
		d.put("ccc", 1D);
		//调用jedis方法，方法的名称和reids一致;
		//jedis.set( "a" , "b");
		//String bs = jedis.get("a");
		//jedis.sadd("remark", "aaa","bbb","ccc"); //一次性插入多条数据;
		jedis.zadd("zsettest", d);
		//System.out.println(bs);
		//关闭jedis
		jedis.close();
	}
	
	/**
	 * 使用连接池
	 */
	@Test
	public void testJedisPool(){
		//建对象；
		JedisPool jedisPool = new JedisPool("10.198.1.7", 6379);
		Jedis jedis = jedisPool.getResource();
		//jedis.lpush("teacherid", "q" , "w" , "e" , "r");
		jedis.hset("lin", 1+"", "nihao");
		String bs = jedis.hget("lin", 1+"");
		System.out.println(bs);
		//关闭jedis
		jedis.close();
		
	}
}
