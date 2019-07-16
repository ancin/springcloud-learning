# springcloud-learning

# Eureka注册中心
 Eureka是一个Netflix开元的服务发现组件,本身是一个基于REST的服务。它包含Server和Client两部分。
 
 服务注册 每个微服务应用在启动时都会向注册中心登记自己的信息（名称、地址、端口等）；
 服务发现 Eureka注册中心中的每个应用都会在本地缓存一份Eureka中所有微服务的信息，客户端调用时，可以通过应用名称找到具体的应用地址进行调用；
 # Config配置中心
 Config用来为分布式系统中的基础设施和微服务应用提供集中化的外部配置支持， 它分为服务端与客户端两个部分。。
 服务端也称为分布式配置中心， 它是一个独立的微服务应用， 用来连接配置仓库并为客户端提供获取配置信息、加密／解密信息等访问接口；
 客户端则是微服务架构中的各个微服务应用或基础设施， 它们通过指定的配置中心来管理应用资源与业务相关的配置内容，并在启动的时候从配置中心获取和加载配置信息。
 # 服务提供者
 <dependency>
 		<groupId>org.springframework.boot</groupId>
 		<artifactId>spring-boot-starter-actuator</artifactId>
 	</dependency>
 	<dependency>
    		<groupId>org.springframework.cloud</groupId>
    		<artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
    	</dependency>
    	
