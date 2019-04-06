## 概念模型

- 依赖管理
- 一键构建

### 依赖管理

- 项目对象模型
- 依赖管理模型

> #### 项目自身信息

- 项目依赖的jar包信息
- 运行环境信息：比如 jdk,tomcat

pom.xml

```
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<groupId>cn.itcast.maven</groupId>
	<artifactId>maven-helloworld</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<packaging>war</packaging>
	<name>第一个maven工程</name>
	<description>第一个maven工程</description>
	
	<!-- 添加servlet-api，jsp-api -->
	<dependencies>
		<dependency>
			<groupId>junit</groupId>
			<artifactId>junit</artifactId>
			<version>4.9</version>
			<scope>test</scope>
		</dependency>


		<dependency>
			<groupId>javax.servlet.jsp</groupId>
			<artifactId>jsp-api</artifactId>
			<version>2.0</version>
			<scope>provided</scope>
		</dependency>
		<dependency>
			<groupId>javax.servlet</groupId>
			<artifactId>servlet-api</artifactId>
			<version>2.5</version>
			<scope>provided</scope>
		</dependency>
	</dependencies>
	<build>
		<!-- 配置了很多插件 -->
		<plugins>
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-compiler-plugin</artifactId>
				<configuration>
					<source>1.7</source>
					<target>1.7</target>
					<encoding>UTF-8</encoding>
				</configuration>
			</plugin>
		<plugin>
                <groupId>org.apache.tomcat.maven</groupId>
                <artifactId>tomcat7-maven-plugin</artifactId>
                <version>2.1</version>
                <configuration>
                    <port>9090</port>
                    <path>/mgr</path>
                    <uriEncoding>UTF-8</uriEncoding>
                    <server>tomcat7</server>
                </configuration>
            </plugin>

		</plugins>
	</build>
</project>
```

> #### 依赖管理模型

- 坐标里它有三个指向
    1. local 本地仓库
    2. b2b 远程仓库
    3. 中央仓库
```
<dependency>
    <!-- 组织名称 -->
    <groupId>javax.servlet.jsp</groupId>
    <!-- 项目名 -->
    <artifactId>jsp-api</artifactId>
    <!-- 版本号 -->
    <version>2.0</version>
    <scope>provided</scope>
</dependency>
```

### 一键构建

默认生命周期
```
compile test package install deploy
每一个构建项目的命令都对应 maven底层的一个插件
```