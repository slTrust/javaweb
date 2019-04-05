## redis案例

- 页面访问省份选择
- 省份json来自servlet, servlet调用 service 方法返回结果
- service去连接数据库
- 连接过程中 查看是否有redis 缓存

### 1.初始化数据库

```
CREATE DATABASE db3; -- 创建数据库
USE db3; 			   -- 使用数据库
CREATE TABLE province(   -- 创建表
	id INT PRIMARY KEY AUTO_INCREMENT,
	NAME VARCHAR(20) NOT NULL
	
);
-- 插入数据
INSERT INTO province VALUES(NULL,'北京');
INSERT INTO province VALUES(NULL,'上海');
INSERT INTO province VALUES(NULL,'广州');
INSERT INTO province VALUES(NULL,'陕西');
```

### 2.引入jar包

已经引入在 WEB-INF/lib下

### 3.新建数据库实体类

cn.itcast.domain/Province

```
package cn.itcast.domain;

public class Province {

    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
```

### 4.新建Dao 定义接口

cn.itcast.dao/ProvinceDao

```
package cn.itcast.dao;

import cn.itcast.domain.Province;

import java.util.List;

public interface ProvinceDao {

    public List<Province> findAll();
}

```

### 5.写实现类

cn.itcast.dao.impl/ProvinceDaoImpl

```
package cn.itcast.dao.impl;

import cn.itcast.dao.ProvinceDao;
import cn.itcast.domain.Province;
import cn.itcast.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ProvinceDaoImpl implements ProvinceDao {

    //1.声明成员变量 jdbctemplement
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Province> findAll() {
        return null;
    }
}

```

### 6.定义service 接口

cn.itcast.service/ProvinceService

```
package cn.itcast.service;

import cn.itcast.domain.Province;

import java.util.List;

public interface ProvinceService {

    public List<Province> findAll();

    public String findAllJson();
}

```

### 7. service实现类 impl

cn.itcast.service.impl/ProvinceServiceImpl

```
package cn.itcast.service.impl;

import cn.itcast.dao.ProvinceDao;
import cn.itcast.dao.impl.ProvinceDaoImpl;
import cn.itcast.domain.Province;
import cn.itcast.jedis.util.JedisPoolUtils;
import cn.itcast.service.ProvinceService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import redis.clients.jedis.Jedis;

import java.util.List;

public class ProvinceServiceImpl implements ProvinceService {

    @Override
    public List<Province> findAll() {
        return null;
    }
}

```
