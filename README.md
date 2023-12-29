# boot3

#### 介绍
springboot3.0.0  

#### 软件架构
1. springboot3.1.5 
2. mysql8.0.20 
3. redis 
4. tk.mapper 
5. jdk17 sa-token


#### 使用说明
1.  application.yml 中active 对应使用的配置文件
2.  controller 正确返回同意封装RestResult
3.  resources/generator/generatorConfig.xml 文件为数据库单标自动生成文件地址
4.  conf/filter :使用sa-token 记性拦截过滤
5.  conf/redis : 添加了redis的配置并提供了redisService方便存储
6.  conf/listener : 添加了redis 过期事件的监听
7.  conf/exception: 添加了全局统一异常处理
8.  conf/tk : 添加动态表名的实现

#### 部署相关
1. docker 目录添加了服务器利用docker-compose 部署文件的相应配置文件
2. docker命令: docker-compose up 启动服务 docker-compose down 关闭服务
