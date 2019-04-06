### maven

管理jar包的工具

> 我们之前的web demo都是放在 WEB-INF的lib下 然后 add library

如果有多个项目，那么就会很浪费磁盘空间

> #### maven的作用

##### 依赖管理: maven工程对 jar包的管理过程。

- jar包不放在项目里(jar包的坐标对应仓库里的jar包)
- 放在一个jar包的仓库

#### 项目的一键构建

- 我们不再使用本地安装的tomcat,而是使用maven自身集成的tomcat来完成项目的上线流程
    ```
    编译
    测试
    运行
    打包
    安装
    部署
    ```
- 一个传统的maven项目
    ```
    maven-helloworld
    
    -src
    -target
    -.classpath
    -.project
    -.tern-project
    -pom.xml
    
    进入该项目的目录
    运行 mvn tomcat:run 项目就自己运行起来了
    ```
    
#### 安装maven

- http://archive.apache.org/dist/maven/maven-3/
- 我的是 apache-maven-3.5.2 解压到一个目录里(最好不要有中文路径)
- 我的win10目录在 /d/maven/apache-maven-3.5.2
    ```
    - bin 里面有非常重要的 mvn命令
    - boot maven自身运行所需的加载器
    - conf  里面有个非常重要的配置文件 settings.xml
    - lib  maven自身运行所依赖的jar包 如 tomcat
    ```
> 配置maven环境变量

- 复制你刚刚的解压路径 如：/d/maven/apache-maven-3.5.2
- 点击我的电脑-->右键属性-->高级系统设置-->环境变量
    ```
    系统变量中 点击新建
        变量名 MAVEN_HOME
        变量值 /d/maven/apache-maven-3.5.2
        点击确定
        
        继续选择系统变量里的 Path 点击编辑--》 新建
            %MAVEN_HOME%\bin
            确定
    需要注意的是 maven运行依赖于 JAVA_HOME
    所以必须确保我们的环境里有 JAVA_HOME
    ```
- 验证maven是否配置成功
    ```
    打开 cmd
    输入 mvn -v 如果出现版本号 说明成功
    ```
    
#### maven仓库的种类和关系

- 本地仓库
- 远程仓库 或者也叫私服(公司局域网)
- 中央仓库(里面有几乎所有的jar包)

一个maven工程里并没有 jar包 而是放了所需的jar坐标

在运行的时候，通过本地jar包的坐标去仓库里找对应的jar包

> 配置本地 maven jar包的目录

- 在你的maven安装目录的 conf/settings.xml里
    ```
    Default:${user.home}/.m2/repository
    这里也就是 系统盘用户目录下/.m2/repository
    
    由于window系统盘比较宝贵 我们一般会修改一个其他的目录
    如 D:\maven\maven_repository
    <localRepository>D:\maven\maven_repository</localRepository> 
    ```
- 在第一次运行maven项目时候
    1. 去pom.xml里找 依赖的jar坐标
    2. 去本地maven仓库找 jar包
    3. 如果本地没有且机子是联网的，
    那么maven就会去找一个 中央仓库的地方 直接下载jar包
    
    如果公司有自己的 远程仓库就会先去远程仓库找jar包
    如果公司的仓库里没有，它就会去中央仓库下载jar包
    
    远程仓库不仅可以从中央仓库下载也支持本地仓库上传

#### maven标准目录结构

- 核心代码部分
- 配置文件部分
- 测试代码部分
- 测试配置文件

```

maven java项目名
    src/main/java 目录 核心代码部分
    src/main/resources 配置文件部分
    src/test/java 目录 测试代码部分
    src/test/resources 测试配置文件
    
maven javaweb项目
    src/main/java 目录 核心代码部分
    src/main/resources 配置文件部分
    src/test/java 目录 测试代码部分
    src/test/resources 测试配置文件
    src/main/webapp 页面资源 js html css
```