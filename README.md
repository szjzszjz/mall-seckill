# mall-seckill
java 高并发商城秒杀  
```text
主要学习内容：  
大并发的情况下  
如何利用缓存  
如何使用异步  
如何编写优雅的代码  
```
## 结束点介绍：  
![技术点]()  
## 秒杀  
![秒杀]()  
### 课程内容：  
* #### 第一章：项目框架搭建  
springboot环境搭建  
集成thymeleaf,Result结果封装  
集成mybatis+druid  `(项目中已利用Mybatis-Plus替换Mybatis 实现快速便捷开发)`  
集成Jedis + Redis安装 + 通用缓存key封装  
* #### 第二章：实现登录功能  
数据库设计  
明文密码两次MD5处理  
JSR303参数校验 + 全局异常处理器  
分布式session  
* #### 第三章：实现秒杀功能  
数据库设计  
商品列表页  
商品详情页  
订单详情页  
* #### 第四章：JMeter压测  
JMeter入门  
自定义变量模拟多用户  
JMeter命令行使用  
springBoot打war包  
* #### 第五章：页面优化技术  
页面缓存 + url缓存 + 对象缓存  
页面静态化 + 前后端分离  
静态资源优化  
CDM优化  
* #### 第六章：接口优化  
RabbitMQ安装与springboot集成  
访问NGINX水平扩展  
Redis预减库存减少数据库访问  
内存标记减少Redis访问  
RabbitMQ队列缓存，异步下单，增强用户体验  
* #### 第七章：安全优化  
秒杀接口地址隐藏  
数学公式验证码  
接口防刷  

### * Redis相关内容  
在CentOS7下安装Redis，安装完成之后，远程连接时会爆出如下异常:  
```text
Failed connecting to host 192.168.xx.xxx:6379 
```  
`解决办法：`[Failed connecting to host](http://note.youdao.com/noteshare?id=e227923eecab339849433cdd85bed0ab&sub=71D9867DA224496E98C7ED45AB5C7CEA) (附：[CentOS 7 对外开放Redis的端口](http://note.youdao.com/noteshare?id=325a578ad7a25d9b0f4253b1adbc4e00&sub=107E607FBAD3496C94388353DFDD9F31))

### * Mybatis-Plus相关内容  
[Mybatis-plus 官网](https://mybatis.plus/guide/#%E7%89%B9%E6%80%A7)  
[MyBatis-Plus入门(慕课网视频教程)](https://www.imooc.com/learn/1130)  
[Mybatis-Plus学习demo](https://github.com/szjzszjz/Mybatis-Plus-Study)  

