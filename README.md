# WeeklyPlanning
每周计划

### 第一周 2019-09-23 -- 2019-09-29
1. spring boot 捕获全局异常
2. spring boot 缓存 cache
3. spring boot druid 数据库连接池 入门
4. restful api
5. token 机制防止重复提交
6. 设计模式：责任链模式
7. 缓存 spring cache 复习
### 第二周
1. Swagger 文档
2. Springboot 权限控制Shiro
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
#### Representational State Transfer
RESTful架构应该遵循统一接口原则，统一接口包含了一组受限的预定义的操作，不论什么样的资源，都是通过使用相同的接口进行资源的访问。接口应该使用标准的HTTP方法如GET，PUT和POST，并遵循这些方法的语义。
##### RESTful API 注意
当你理解后，要按照这思路去建立以后的项目，而不是随意定义接口。这样有助于提升。
##### GET
1. 安全且幂等
2. 获取表示
3. 变更时获取表示（缓存）
##### POST
1. 不安全且不幂等
2. 使用服务端管理的（自动产生）的实例号创建资源
3. 创建子资源
4. 部分更新资源
5. 如果没有被修改，则不过更新资源（乐观锁）
##### PUT
1. 不安全但幂等
2. 用客户端管理的实例号创建一个资源
3. 通过替换的方式更新资源
4. 如果未被修改，则更新资源（乐观锁)
##### DELETE
1. 不安全但幂等
2. 删除资源
##### uri规范
1. 使用名词。如 managed-devices/{device-id}
2. http method对应不同的请求动作 GET：查询操作，POST：新增操作，PUT 更新操作，PATCH 部分更新，DELETE 删除操作
3. 使用连字符-而不是_来提高URI的可读性
4. 在URI中使用小写字母
5. URI版本控制（推荐）http://api.example.com/v1
6. 正确使用状态码
##### 注解
1. @GetMapping
2. @PostMapping
3. @PutMapping
4. method = DELETE
5. @PathVariable：用于获取URL中的参数：一般{ }中的变量名与方法中的形参名一致(可以不加@PathVariable注解)
6. @RequestBody POST方式进行提交
##### 示例
1. [优秀例子](https://hacpai.com/article/1546930788518#toc_h2_13)
2. [Github 的 Restful HTTP API 设计分解](https://hacpai.com/article/1569208733756)
##### 思路
1. 新建项目 web，restrepo
2. 配置 server:servlet:context-path: /api
3. controller 配置版本号
4. curd
5. HTTP状态码 统一接口返回实体
6. 统一异常
##### 其他
1. 幂等性 一次和多次请求某一个资源对于资源本身应该具有同样的结果
2. jpa
3. rest-api 类图
#### token 机制防止重复提交
为了防止重复提交，使用redis进行效验。
##### Scheduling
查询文章，看到了，定时，再次加上定时功能。

注解
1. @EnableScheduling
2. @Scheduled(cron="xxx")
定时参数存放数据库
1. 继承SchedulingConfigurer
2. 重写configureTasks()
3. ScheduledTaskRegistrar增加addTriggerTask  CronTrigger
4. corn表达式，可以直接网上查

##### 幂等性
1. pom web，test，jpa，jedis，lombok，mysql，aop，apache工具包commons-lang3
2. 启动类
3. 配置类：1.redis配置，使用jedis客户端 2. 继承WebMvcConfigurationSupport，将拦截器加上
4. 工具类：uuid生成token，redis工具类
5. 自定义注解，如果方法加了注解就代表要验证
6. 拦截器，其实可以使用aop进行验证的。拦截器，判断方法，里面有无token，没有拦截，有进行验证
7. 返回实体，定义返回实体类，id，code，data
8. 返回实体的枚举，统一管理返回值
9. 自定义异常，处理service的异常
10. 捕获全局异常类
##### 其他
1. redisson的使用
2. Interceptor 拦截器，预处理回调方法，后处理回调方法，整个请求处理完毕回调方法
3. StrBuilder
4. spring boot 启动周期
5. HandlerMethod
6. 常量类里面可以使用多个interface区分类别调用的时候常量实体.接口.常量名
7. common-lang3 apach工具类，uuid就是类里面的方法
#### idea注释模版
我用的idea是免费的社区版，不支持spring创建项目。创建springboot时，要么maven，要么用官网的脚手架工具。
模版是经常要用的，这里收集一下常用模版.
1. 类，类名，描述，作者，时间，版本
2. 方法，方法名，入参，回参，描述，作者，时间

#### druid 多数据源
1. 准备工作，2个数据库，每个数据各有1张表
2. appliaction文件分别配置数据库1，数据库2的基本信息
3. 分别编写druidconfig
4. 扫描不同的mapper，创建不同的datasource
5. 其他分层照常编写

##### 其他
1. ConfigurationProperties
#### Swagger
在实际项目中，几乎没有使用过。
##### 基本配置
1. 引入swagger和ui
2. 配置config，返回docket
##### 高级配置
1. 控制器类 @Api （tags = "", description=""）
2. 接口方法 @ApiOperation 注解来展开对接口的描述
3. 实体 @ApiModel 和 @ApiModelProperty
4. ApiInfo 文档的其他信息
##### 接口过滤
1. @ApiIgnore，在方法上增加
2. apis()：这种方式我们可以通过指定包名的方式，让 Swagger 只去某些包下面扫描。
3. paths()：这种方式可以通过筛选 API 的 url 来进行过滤。

#### Shiro
关于权限控制这块，有Shiro和spring security，其实，每次用的时候，都需要百度一下用法，这次，通过事例，记录使用思路。
1. 引入依赖，shiro-spring，shiro-redis
2. 其他依赖 aop，redis-reactive
3. 自定义Realm，继承AuthorizingRealm，实现下面2个方法
4. doGetAuthenticationInfo 身份认证 （主要是在登录时的逻辑处理）。获取用户信息，与数据库验证
5. doGetAuthorizationInfo：登陆认证成功后的处理 ex: 赋予角色和权限。获取用户信息，从数据库拿到角色和菜单
4. 配置shiro
##### 其他
1. 响应式的redis spring-boot-starter-data-redis-reactive
2. RedisSessionDAO shiro将session保存到redis
3. SecurityUtils

#### MyBatis-Plus
笔者官网先来一遍
1. schema，data 配置无效
2. mybatisplus配置mapperscan，扫描到包（com.sun.test.mapper）
##### 封装类
###### DAO[Mapper CRUD 接口](https://mp.baomidou.com/guide/crud-interface.html#mapper-crud-%E6%8E%A5%E5%8F%A3)
###### service[Service CRUD 接口](https://mp.baomidou.com/guide/crud-interface.html#service-crud-%E6%8E%A5%E5%8F%A3)
###### 条件构造器
##### 思路
1. 引入pom，mp依赖mp，代码生成器单独引入
2. 编写yml，配置数据库，mp需要加上mapper.xml的扫描地址
3. 编写config，增加mapperscan
4. 定义实体类
4. dao 继承 basedao

#### WebFlux
##### Reactor
1. Flux
表示的是包含 0 到 N 个元素的异步序列。在该序列中可以包含三种不同类型的消息通知：正常的包含元素的消息、序列结束的消息和序列出错的消息。当消息通知产生时，订阅者中对应的方法 onNext(), onComplete()和 onError()会被调用。
2. Mono
表示的是包含 0 或者 1 个元素的异步序列。该序列中同样可以包含与 Flux 相同的三种类型的消息通知。
##### spring-boot-starter-webflux
在实际项目中，很少用到，但是为了学习这种编程的方式。就行java8的stream一样，如果熟练使用，那学习spark，flink那些算子就很简单了。
###### hello word
1. 引入pom依赖
2. 编写application，与正常一样
3. 一下2个步骤都是简要步骤，api和编程规范还需要多熟悉。如果不熟悉，那3，4这两步只是虚的。
3. 编写Router，在router调用hanlder。RouterFunction<ServerResponse>
4. 编写handler，返回helloworld。Mono<ServerResponse>（ServerResponse.状态.contentType,方法）
###### Moon Flux
1. Mono和Flux都是Publisher发布者
2. 对于 Subscriber 和 Subcription 这两个接口 Reactor 必然也有相应的实现
3. 反应式编程框架主要采用了观察者模式
4. Reactive Streams 是规范，Reactor 实现了 Reactive Streams。Web Flux 以 Reactor 为基础，实现 Web 领域的反应式编程框架
##### 其他
1. @Builder(toBuilder = true)  UserInfo userInfo = UserInfo.builder().name("zzl").build();
