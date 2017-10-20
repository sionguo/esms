# esms
电子商城系统
# 项目描述

---- 

esms电子商城是b2c模式的电子购物商城系统。其实现的主要功能有：登录、注册、商品管理、订单管理、商品上传、账户管理等。

----

# 开发环境

----

-  eclipse 
-  maven 
-  Tomcat7.0 
-  mysql5.7

----

# 依赖

----

- jdk 1.8
- spring-mvc 3.2.8 
- mysql-connetor 5.1.40 
- commons-dpcp 1.4
- commons-fileupload 1.3.3
- jackson 2.8.5
- dom4j 1.6.1
- mail 1.50-b01
- commons-codec 1.8

----

# 使用

----

1. 用sql文件夹下的文件初始化数据库
2. 配置Tomcat服务器中的server.xml文件，在其中加入  <Context path="/img" docBase="C:\image"></Context>，并更改为你的图片存储路径
3. 配置resource文件夹下的esms.xml文件，将路径修改为你需要的路径

---- 

