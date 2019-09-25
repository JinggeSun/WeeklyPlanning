# WeeklyPlanning
每周计划

### 第一周 2019-09-23 -- 2019-09-29
1. spring boot 捕获全局异常
2. spring boot 缓存 cache
3. spring boot druid 数据库连接池 入门
4. restful api
5. token 机制防止重复提交
6. 缓存 spring cache 复习
7. 设计模式：责任链模式
#### 捕获全局异常
##### 思路
1. 新建一个捕获全局的类，每个方法实现捕获异常的逻辑。
2. 新建自己的自定义异常类
3. 返回实体建立，标准接口
4. 定义枚举，主要方便管理返回数据
5. 定义返回接口的工具类（将返回实体，转化json）
##### 知识
1. 当接口返回值可能会有不同类型的时候，使用object类。建议使用result实力类，内有code，msg，data。封装成功和失败的返回工具类
2. @controlleradvice，@RestControllerAdvice, @exceptionhandler
3. 自定义异常 继承runtimeexception
4. 使用枚举建立统一管理的异常返回信息
5. 异常。当程序出现异常的时候，通过这些异常能够迅速定位出现问题的原因
  1. 算数异常类：ArithmeticExecption
  2. 空指针异常类型：NullPointerException
  3. 类型强制转换类型：ClassCastException
  4. 数组负下标异常：NegativeArrayException
  5. 数组下标越界异常：ArrayIndexOutOfBoundsException
  6. 违背安全原则异常：SecturityException
  7. 文件已结束异常：EOFException
  8. 文件未找到异常：FileNotFoundException
  9. 字符串转换为数字异常：NumberFormatException
  10. 操作数据库异常：SQLException
  11. 输入输出异常：IOException
  12. 方法未找到异常：NoSuchMethodException
  13. 下标越界异常：IndexOutOfBoundsExecption
  14. 系统异常：SystemException
  15. 创建一个大小为负数的数组错误异常：NegativeArraySizeException
  16. 数据格式异常：NumberFormatException
  17. 安全异常：SecurityException
  18. 不支持的操作异常：UnsupportedOperationException
##### 其他
1. 枚举
2. 继承 super() 指向自己超（父）类对象的一个指针，而这个超类指的是离自己最近的一个父类

#### spring boot 缓存 cache
本来打算使用redis和encache分别作为1天，但是看了一篇公众号的文章，很受启发。所以作为一篇文章。
##### 原本思路
1. 使用jedis作为redis客户端，编写config
2. 编写redisUtil工具类，实现基本的查询，验证，增加等功能
3. 在serive中使用redisUtil
4. 原则：
  1. 查询：先查redis，再数据库
  2. 增，删，改，先数据库，再redis
##### encache

##### 练习
1. redisCache 使用原本的思路. 缓存基本靠redis的工具类
2. redisCache 配置，使用jedis，但是jedis只是作为连接使用，操作是redistemplate
3. cachemanager 使用cachemanager管理
4. 使用encache作为缓存客户端

##### 学习高级缓存客户端
采用redis作为缓存客户端，之前打算使用jedis作为连接客户端，这里使用lettuce作为客户端。
1. 可以自定义缓存客户端
2. 配置key和value
3. 使用时无差别
##### 其他
1. 阻塞客户端jedis
2. @Primary注解
3. lettuce
4. 下载redis，make，src/redis-server
5. 	yml 文件中自定义参数解析对象 @ConfigurationProperties(prefix="spring.redis.pool")
6. 工厂模式
7. cachemanager
#### druid连接池
Druid是Java语言中最好的数据库连接池。Druid能够提供强大的监控和扩展功能。其他数据库连接池还有C3P0。
##### 传统思路
1. 引入sql连接
2. 配置数据库4项，驱动，连接地址，用户名，密码
3. 使用mybatis 进行 curd
##### durid
1. [druid-spring-boot-starter](https://github.com/alibaba/druid/tree/master/druid-spring-boot-starter) 配合Springboot的配置文件，可以直接使用
2. [druid](https://github.com/alibaba/druid/wiki/%E5%B8%B8%E8%A7%81%E9%97%AE%E9%A2%98) 配置好配置文件后，需要在config中设置
3. 使用druid-spring-boot-start 开发，参照官网。
4. 多数据源  未实现，没看懂如何调用。
5. 监控
6. demo，官网的例子很好，可以参考。
##### 思路
1. 引入pom druid-spring-boot-starter，数据库驱动
2. 配置数据库4项
3. 其他配置项
4. 编写servert，并在启动类扫描，可以进入druid的web监控页面
5. 多数据源
6. Spring Boot 2.X 版本不再支持配置继承，多数据源的话每个数据源的所有配置都需要单独配置，否则配置不会生效
##### 其他
1. apache druid
##### 未完成
1. druid 多数据源
2. 监控web端
3. 配置参数的意义
