# spring-all
工作一年后的总结,持续更新，spring90%功能都在这里了
第一阶段：spring
第二阶段：springboot
第三阶段：常用第三方框架
第四阶段：将一些不常用的，github上其他的优秀代码收集一些集成进来

spring整体介绍：
从接口的层面来讲：spring顶层定义了BeanFactory，EnvironmentCapable，ApplicationEventPublisher，MessageSource和ResourceLoader一共5个接口，其中最主要的是第一个和最后一个，中间的都是辅助功能。所以，后面出现了ApplicationContext接口将前4个组合了起来，这样就描述好了应用上下文的功能，确实，应用相关的东西实现这几个就够用了。但光是可以生产bean实例还不够用。此时spring团队应该是想到了对容器的声明周期进行维护，所以通过组合接口的方式，将closeable的接口和Application一起合并到了configurableApplicationContext里面，至此基本应用层面接口定义结束。现在该实现了，应用上下文要实现，还需要依赖ResourceLoader的功能，注意他们没有将接口继续杂糅，而是在实现层面用了组合的概念，这样一个bean的上下文工厂就做好了。但是这个工厂现在不能注册bean定义，所以又额外加了一个registry的接口，将这个接口统一由GenericApplicationContext实现，为什么呢？因为这个抽象类里已有实现了的资源加载器，能加载bean定义，同时由registry注册beanDefinition。至此，完整的功能就实现了，但是随着项目的推进，现在注解的应用使代码更加简洁，可读性高，于是又专门加了一个AnnationConfigRegistry来通过注解注册bean定义，所以又封了一层，将通用应用上下文和注解注册接口在实现层面又组合到了一起。可以看到，在实现层面通常是一继承一实现，spring并没有做太多的接口合并，这恰恰反映了类的单一职责的设计模式。
