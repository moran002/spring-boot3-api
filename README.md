# boot3

#### 介绍
springboot3.0.0  

#### 软件架构
springboot3.0.0 mysql8 redis tk.mapper jdk17


#### 使用说明

1.  application.yml 中active 对应使用的配置文件
2.  controller 正确返回同意封装RestResult
3.  resources/generator/generatorConfig.xml 文件为数据库单标自动生成文件地址

#### 部署相关
1. docker 目录添加了服务器利用docker-compose 部署文件的相应配置文件
2. docker命令: docker-compose up 启动服务 docker-compose down 关闭服务
