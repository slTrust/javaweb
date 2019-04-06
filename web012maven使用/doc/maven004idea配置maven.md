### 首先安装maven工具包

```
mvn -v 
正常 则继续 反之回去看第一个
```
### 打开 IDEA

1. 点击 file===> settings
2. 搜索输入 maven
3. 在 maven home directory 里选择你本地maven目录
4. 在 user settings file  选择你本地 maven的conf下的 settings.xml 
5. 点击Runner 
   参数输入 -DarchetypeCatalog=internal
   这个是保证没联网的情况下 能正常构建 maven项目