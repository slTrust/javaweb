package cn.itcast.test;

import cn.itcast.domain.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class JacksonTest {
    // java对象转 JSON
    @Test
    public void test1() throws Exception {
        //1 创建 Person对象
        Person p = new Person();
        p.setName("张三");
        p.setAge(18);
        p.setGender("男");

        //2 创建 Jackson 的核心对象 ObjectMapper
        ObjectMapper mapper = new ObjectMapper();
        //3 转换
        /*
        * 转换方法
        *   writeValue(参数1,obj):
        *       参数1：
        *           File:将 obj 转换为 JSON字符串，并保存到指定的文件中
        *           Writer: 将 obj对象转换为JSON字符串，并将json数据填充到字符输出流中
        *           OutputStream:将对象转换为JSON 字符串，并将 数据填充到 字节输出流中
        *   writeValueAsString(obj) 将对象转为json字符串
        *
        * */
        String json = mapper.writeValueAsString(p);
        System.out.println(json);
        // {"name":"张三","age":18,"gender":"男"}
        // 将数据关联到文件中
        mapper.writeValue(new File("d://a.txt"),p);
    }

    /*
    * Jackson注解
    * @JsonIgnore 排除属性
    * @JsonFormat 属性值格式化
    * */
    @Test
    public void test2() throws Exception {
        // 1 创建Person对象
        Person p = new Person();
        p.setName("张三");
        p.setAge(18);
        p.setGender("男");
        p.setBirthDay(new Date());

        // 2 转换
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(p);
        // 如果不加注解 转换日期 那么格式就是 时间戳
        System.out.println(json);// {"name":"张三","age":18,"gender":"男","birthDay":1556202102172}
    }


    /*
    * 复杂java对象转换
    * Map
    * */
    @Test
    public void test3() throws Exception {
        // 1 创建Person对象
        Person p1 = new Person();
        p1.setName("张三");
        p1.setAge(18);
        p1.setGender("男");
        p1.setBirthDay(new Date());

        Person p2 = new Person();
        p2.setName("李四");
        p2.setAge(8);
        p2.setGender("男");
        p2.setBirthDay(new Date());

        Person p3 = new Person();
        p3.setName("王五");
        p3.setAge(22);
        p3.setGender("男");
        p3.setBirthDay(new Date());

        // 创建 List
        List<Person> list = new ArrayList<Person>();
        list.add(p1);
        list.add(p2);
        list.add(p3);

        // 2 转换
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(list);
        System.out.println(json);
    }

    /*
    * 复杂java对象转换
    * Map
    * */
    @Test
    public void test4() throws Exception {
        // 1 创建Person对象
        Person p1 = new Person();
        p1.setName("张三");
        p1.setAge(18);
        p1.setGender("男");
        p1.setBirthDay(new Date());

        Person p2 = new Person();
        p2.setName("李四");
        p2.setAge(8);
        p2.setGender("男");
        p2.setBirthDay(new Date());

        Person p3 = new Person();
        p3.setName("王五");
        p3.setAge(22);
        p3.setGender("男");
        p3.setBirthDay(new Date());

        // 创建 Map
        Map<String,Person> map = new HashMap<String,Person>();
        map.put("id_001",p1);
        map.put("id_002",p1);
        map.put("id_003",p1);

        // 2 转换
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(map);
        System.out.println(json);
    }

    /*
    * json转 java对象
    * */
    @Test
    public void test5() throws Exception {
        // 1 创建 json
        String json = "{\"gender\":\"男\",\"name\":\"张三\",\"age\":18}";

        // 2 创建 mapper
        ObjectMapper mapper = new ObjectMapper();
        // 3 转换
        Person p = mapper.readValue(json,Person.class);
        System.out.println(p);
    }

}
