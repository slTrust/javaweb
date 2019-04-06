### 进入项目里的demo目录下的

> 在 maven-helloworld 目录下

- ### mvn clean 清楚他人编译信息
    ```
    此时 maven-helloworld里的 target 目录不见了
    
    将编译好的 项目中的信息删掉
    
    接手他人编译后的项目，第一次就该运行 mvn clean 删除他人本地编译信息
    ```
- ### mvn compile 编译
    ```
    编译 
    此时 刚刚被删除的 target 目录又出现了
    
    将 项目中 src/main下的代码进行编译
    ```
- ### mvn test 测试
    ```
    此时 target里多一个 test-classes 目录
    
    这里就是 src/test下的java 文件
    
    那么 mvn test 会不会编译 src/main下的 java代码呢？
    
    答案是会的
    答案是会的
    答案是会的
    ```
- ### mvn package 打包
    ```
    包含 mvn test 的操作
    同时 把项目打包成 war包
    ```
- ### mvn install 安装
    ```
    我们继续 mvn clean 清除 target目录
    
    然后 mvn install 此时 不仅包含了 mvn package的所有操作
    
    还把这个包安装在 本地仓库
    D:\maven\maven_repository\cn
    这个就是我刚才的项目
    ```
    
### maven 生命周期

```
默认生命周期
--------------------------
compile  编译

test     测试

package  打包

install  安装

deploy   发布

-------------------------------
后面的命令都会把前面的命令执行一次

清理生命周期
clean 清除编译信息
```