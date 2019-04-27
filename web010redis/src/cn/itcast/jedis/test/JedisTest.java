package cn.itcast.jedis.test;

import cn.itcast.jedis.util.JedisPoolUtils;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.List;
import java.util.Map;
import java.util.Set;

/*jedis的测试类
* */
public class JedisTest {

    /*
    * jedis 入门
    * */
    @Test
    public void test1(){
        // 1. 获取连接
        Jedis jedis =new Jedis("localhost",6379);
        // 2. 操作
        jedis.set("name","zhangsan");
        // 3. 关闭连接
        jedis.close();

    }

    /*
    *  string 数据类型操作
    * */
    @Test
    public void test2(){
        // 1. 获取连接
        // Jedis jedis =new Jedis("localhost",6379);
        // 如果空参数 ，则默认值为 "localhost",6379
        Jedis jedis =new Jedis();

        // 2. 存
        jedis.set("name","zhangsan");

        // 3. 获取
        String name = jedis.get("name");
        System.out.println(name);

        // 可以使用setex() 存储指定过期时间的 key value
        // 将 k/v格式如   {"activecode":"hehe"} 存入 redis 并且 20秒后自动删除该 键值对
        // 一般用来存 激活码
        jedis.setex("activecode",20,"hehe");

        // 4. 关闭连接
        jedis.close();

    }

    /*
   *  hash 数据类型操作
   * */
    @Test
    public void test3(){
        // 1. 获取连接
        Jedis jedis =new Jedis();
        // 2. 操作
        jedis.hset("user","name","多隆");
        jedis.hset("user","age","60");
        jedis.hset("user","gender","male");

        // 3. 获取
        String name = jedis.hget("user","name");
        String age = jedis.hget("user","age");
        String gender = jedis.hget("user","gender");
        System.out.println("name:" + name +",age:" + age + ",gender:" + gender );

        // 3.1 获取 hash的所有map中的数据
        Map<String,String> userInfo = jedis.hgetAll("user");

        Set<String> keySet = userInfo.keySet();
        for (String key:keySet) {
            // 获取 value
            String value = userInfo.get(key);
            System.out.println(key + ":" + value);
        }
        // 4. 关闭连接
        jedis.close();
    }

    /*
    *  list 数据类型操作
    * */
    @Test
    public void test4(){
        // 1. 获取连接
        Jedis jedis =new Jedis();

        // 2. 存
        jedis.lpush("mylist","a","b","c"); // 从左边存
        // c b a
        jedis.rpush("mylist","1","2","3"); // 从左边存
        // c b a 1 2 3

        // 3. 范围获取
        List<String> mylist= jedis.lrange("mylist",0,-1);
        System.out.println(mylist);

        // 3.2 list 弹出
        String element1 = jedis.lpop("mylist");
        System.out.println(element1);

        String element2 = jedis.rpop("mylist");
        System.out.println(element2);

        // 4. 关闭连接
        jedis.close();

    }

    /*
   *  set 数据类型操作
   * */
    @Test
    public void test5(){
        // 1. 获取连接
        Jedis jedis =new Jedis();

        // 2. 存
        jedis.sadd("myset","java","javascript","python","mysql");

        // 3. 获取
        Set<String > myset = jedis.smembers("myset");
        System.out.println(myset);
        // 4. 关闭连接
        jedis.close();
    }

    /*
   *  sortedset 数据类型操作
   * */
    @Test
    public void test6(){
        // 1. 获取连接
        Jedis jedis =new Jedis();

        // 2. 存
        jedis.zadd("mysortedset",30,"亚瑟");
        jedis.zadd("mysortedset",20,"小乔");
        jedis.zadd("mysortedset",500,"孙悟空");
        // 3. 获取
        Set<String> mysortedset = jedis.zrange("mysortedset",0,-1);

        System.out.println(mysortedset);

        // 4. 关闭连接
        jedis.close();

    }

    /*
   *  jedis 连接池使用
   * */
    @Test
    public void test7(){
        // 0. 创建一个配置对象
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(50);
        config.setMaxIdle(10);

        // 1. 创建连接池对象
        JedisPool jedisPool = new JedisPool(config,"localhost",6379);
        // 2. 获取连接
        Jedis jedis = jedisPool.getResource();

        // 3. 存
        jedis.set("name","zhangsan");

        // 4. 获取
        String name = jedis.get("name");
        System.out.println(name);

        // 5. 关闭 归还到连接池中
        jedis.close();
    }

    /*
   *  jedis 连接池工具类使用
   * */
    @Test
    public void test8(){
        // 通过工具类获取
        Jedis jedis = JedisPoolUtils.getJedis();

        jedis.set("hello","world");

        System.out.println(jedis.get("hello"));
        jedis.close();
    }


}
