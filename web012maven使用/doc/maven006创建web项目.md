### 使用骨架创建 javaweb项目

1. create project
2. 选择 maven
3. 勾中 craete from archetype 从骨架创建
4. 从骨架里选择 webapp (JAVA_web工程的骨架) --> next
5. 输入相关信息
    ```
    GroupId (公司组织名称): com.itheima
    ArtifactId(项目名称): maven_web

    点击next
    ```
6. 确定 maven信息 就是选择好你本地安装的maven --> next
7. 项目名称和 项目位置  Finish 就好
    ```
    如果是第一次创建 就会很慢，因为会从网上下载 骨架所需的jar包和插件
    
    此时会生产一个项目
    maven_java
        -src
            -main
                -webapp
                    -WEB-INF
                    -index.jsp
    ```

    - 如果我们需要手动补齐一些目录
        ```
        -|src/main目录上 右键 Directory 输入 java 点击 ok
            此时 在 src/main/java上右键 make directory as 选择sources root
        ```

> 默认idea不帮我们创建 maven标准目录 我们需要手动补齐 

#### 把包变成资源包

在上面的基础上。

> 一些细节问题

- 在 src/main/web目录右键可以创建 jsp 文件，而在 src/main/java下右键就不行
    ```
    IDEA 内部其实对每个目录放置的文件是有要求的

    如果我们就要在 src/main/java下创建 jsp怎么办？
        - 点击 左上角 file 选择 project structure
        - 选择 modules
            此时就会显示我们刚刚创建的项目 
            maven_web
                -web

        - 右侧里有一个 web resource directories
        - 选择加号 然后选择你的目录 点击ok
        - 点击 ok
        - 此时就可以在 src/main/java下创建 jsp了

    但是不推荐

    ```

#### 一个踩了2小时的坑

maven3.5、jdk9构建java项目没问题,但是构建 webapp死活失败

- 答案就是把 jdk9换成8

#### servlet实例

在上面的项目基础上

- src/main/java下建立 目录 cn.itcast.servlet
    ```
    MyServlet.class

    public class MyServlet extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            doPost(req,resp);
        }

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            req.getRequestDispatcher("/hello.jsp").forward(req,resp);
        }
    }
    ```
    ```
    web.xml里的配置
    <servlet>
        <servlet-name>MyServlet</servlet-name>
        <servlet-class>cn.itcast.MyServlet</servlet-class>
    </servlet>
    <servlet-mapping>
        <servlet-name>MyServlet</servlet-name>
        <url-pattern>/</url-pattern>
    </servlet-mapping>
    ```
- 新建 MyServlet 然后 extend HttpServlet 然后add 对应的依赖在 pom.xml里
    ```
    <dependency>
      <groupId>javax.servlet</groupId>
      <artifactId>servlet-api</artifactId>
      <version>2.5</version>
    </dependency>

    <dependency>
      <groupId>javax.servlet.jsp</groupId>
      <artifactId>jsp-api</artifactId>
      <version>2.0</version>
    </dependency>
    ```
- 如果不知道jar包版本 就去浏览器搜索 maven中央仓库 
    - 选择你需要的库 如 servlet
    - 选择一个版本
    - 会提供给你对应的 坐标 复制即可

- 点击右边的 maven 标签 点击 Lifecycle 双击 clean
- 如何运行 tomcat呢
- 点击 有 "m" 字母的按钮 输入 tomcat:run 点击执行
- 此时访问 它启动后的网址 访问我们的 servlet结果报错

#### 为什么报错

包错信息里说 MyServlet 不能被识别为一个 Servlet

> 因为 maven有一个功能为 一件构建

- 意味着不再使用本地安装的tomcat,而是使用maven自身提供的 tomcat插件进行构建
- 此时你可以去你本地tomcat的lib里 有两个包
    - jsp-api.jar
    - servlet-api.jar
    - 这个都是你导入项目 pom.xml里的包
    - 此时有两套包 相互冲突

> ####解决方案

让pom.xml里的包在写代码的时候起作用，不再运行tomcat的时候起作用

```
<!-- 添加 scope 的-->
<dependency>
    <groupId>javax.servlet</groupId>
    <artifactId>servlet-api</artifactId>
    <version>2.5</version>
    <scope>provided</scope>
</dependency>

<!-- 添加 scope 的-->
<dependency>
    <groupId>javax.servlet.jsp</groupId>
    <artifactId>jsp-api</artifactId>
    <version>2.0</version>
    <scope>provided</scope>
</dependency>
```

再次运行 tomcat:run

> #### 即使这样改了环境一致了还是有问题。

#### 建议不要用默认的tomcat,使用 maven的 tomcat7插件就可以跑通
#### 建议不要用默认的tomcat,使用 maven的 tomcat7插件就可以跑通
#### 建议不要用默认的tomcat,使用 maven的 tomcat7插件就可以跑通

```
<build>
    <plugins>
        <plugin>
            <groupId>org.apache.tomcat.maven</groupId>
            <artifactId>tomcat7-maven-plugin</artifactId>
            <version>2.2</version>
            <configuration>
                <port>8888</port>
            </configuration>
        </plugin>
    </plugins>
</build>
```

> #### 记不住版本和插件怎么办

- 添加自定义模板

1. 选择 settings
2. 搜索 live 出现一个 Live Templates
3. 点击加号 建议选一个组 Template Group 输入 组名 custom 然后 ok
4. 选中你新建的组 custom ，在这个组上面点击 加号
5. 选择Live Template
6. 输入你的快捷键名在 Abbreviation: 如 tomcat7
    ```
    在Template里输入
        <plugin>
            <groupId>org.apache.tomcat.maven</groupId>
            <artifactId>tomcat7-maven-plugin</artifactId>
            <version>2.2</version>
            <configuration>
                <port>8888</port>
            </configuration>
        </plugin>

    点击 define 选择 xml
    ```
7. 点击 apply 然后 ok


- 添加maven编译插件

```
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-compiler-plugin</artifactId>
    <configuration>
        <target>1.8</target>
        <source>1.8</source>
        <encoding>UTF-8</encoding>
    </configuration>
</plugin>
```
    