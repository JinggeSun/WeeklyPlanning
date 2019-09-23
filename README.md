# WeeklyPlanning
每周计划

### 第一周 2019-09-23 -- 2019-09-29
1. spring boot 捕获全局异常
2. spring boot 缓存 ehcache
3. spring boot 缓存 redis
4. restful api
5. token 机制防止重复提交
6. 设计模式：责任链模式
7. 数据分析：世界杯数据分析
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
