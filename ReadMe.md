#### main
1. settings.gradle 构建了整个项目结构
2. build.gradle 载入了整个项目的通用结构

#### spring-cloud-eureka 
   注册中心的高可用和安全访问
1. Eureka项目的resources下新建三个配置文件，互相注册
2. 开发环境中，通过指定不同的配置文件，启动三个不同的EurekaServer。
    --spring.profiles.active=s1
3. 安全访问需要通过用户名和密码才能访问到注册中心。
   各个配置文件中加入用户名和密码配置。
   需要加入@EnableWebSecurity注解，并且关闭csrf注册。
   可以创建一个类WebSecurityConfig来处理。
4. 登录任一个地址检测是否互相注册成功

#### eureka-productor-customer
   一个Eureka+2个Productor+1个Customer构成的生产消费模式。演示使用Feign实现负载均衡、Hystrix实现服务熔断
1. 使用同样的方法启动2个Productor
2. 在customer中配置Feign和Hystrix来实现负载均衡和服务熔断。需要创建interface来使用Feign，实现上述接口的类来进行熔断。
3. 访问customer中的controller，调用到productor中的方法，通过打印发现两个productor交替被调用。
4. 关闭一个prodctor后，调用都指向另外一个productor。两个productor都关闭之后，熔断函数被调用。
5. 重新打开productor之后，需要等待一段时间才能访问。

#### hystrix-dashboard-turbine
   HystrixDashboard做单体监控，Turbine汇总所有的监控 
1. 参考文档https://www.cnblogs.com/sxdcgaq8080/p/9935557.html
2. 在Customer里加入dashboard监控。
* build.gradle 加入依赖
* 主函数中加入@EnableHystrixDashboard 、@EnableCircuitBreaker
* 加入一个配置类，添加hystrix.stream节点
* 访问customer服务：localhost:33333/hystrix
* 在页面中的输入框中输入 localhost:33333/hystrix.stream
* 向Customer微服务发送请求之后，会有数据更新。

