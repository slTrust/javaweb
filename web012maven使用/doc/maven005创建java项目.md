### 使用骨架创建 java项目

1. create project
2. 选择 maven
3. 勾中 craete from archetype 从骨架创建
4. 从骨架里选择 quickstart (JAVA工程的骨架) --> next
5. 输入相关信息
    ```
    GroupId (公司组织名称): com.itheima
    ArtifactId(项目名称): maven_java

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
                -java
                    -com.itheima
                        -App
        -test
            -java
                -com.itheima
                    -AppTest
    ```

    - 如果我们需要配置文件,则需要手动把目录结构补齐
        ```
        -|src/main目录上 右键 Directory 输入 resources 点击 ok
        此时这个目录并不会识别为一个资源文件
        我们要右键此目录 resources
            mark directory as
                选择 Resources Root

        如果test目录里也需要 资源目录则同上
        ```
> 默认idea不帮我们创建 maven标准目录 我们需要手动补齐 

### 不用骨架创建 java项目 (推荐使用)

1. 打开idea 选择create new project
2. 选择 maven 不勾中 creata from archetype 点击 next
3. 输入项目信息
    ```
    groupid:  com.itheima
    artifactid:maven_java002
    ```
4. 确定 maven信息 就是选择好你本地安装的maven --> next
5. 项目名称和 项目位置  Finish 就好
    ```
    此时会生产一个项目
    maven_java
        -src
            -main
                -java
                -resources
        -test
            -java
    ```