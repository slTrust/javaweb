#### 打开idea

1. create new project
2. 不选择骨架直接创建 next
3. groupId : cn.itcast     ArtifactId : maven_mysql
4. next
5. finish
6.  创建实体类的包 src/main/java 下 new package com.itcast.domain
    创建一个实体类
    ```
    public class Province{
        private int id;
        private String name;
        // 快捷键生产 get/set
    }
    ```
7. 因为连接mysql所以肯定有 数据库连接的包
    ```
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>5.1.6</version>
        <scope>runtime</scope>
    </dependency>
    ```