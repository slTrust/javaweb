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