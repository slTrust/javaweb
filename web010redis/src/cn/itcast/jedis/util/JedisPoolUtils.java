package cn.itcast.jedis.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/*
* JedisPool 工具类
*   加载配置文件，配置连接参数
*   提供连接的方法
* */
public class JedisPoolUtils {
    /*
    * */
    private static JedisPool jedisPool;

    static {
        // 读取配置
        InputStream is = JedisPoolUtils.class.getClassLoader().getResourceAsStream("jedis.properties");
        // 创建 Properties 对象
        Properties pro = new Properties();
        try {
            pro.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 获取数据，设置到 JedisPoolConfig 中
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(Integer.parseInt(pro.getProperty("maxTotal")));
        config.setMaxIdle(Integer.parseInt(pro.getProperty("maxIdle")));
        // 初始化 JedisPool
        jedisPool = new JedisPool(config,pro.getProperty("host"), Integer.parseInt(pro.getProperty("port")));
    }

    public static Jedis getJedis(){
        return jedisPool.getResource();
    }

}
