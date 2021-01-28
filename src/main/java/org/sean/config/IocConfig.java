package org.sean.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.sean.bean.ImportTest;
import org.sean.controller.SeanAnnoController;
import org.sean.service.SeanBroService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

/**
 * spring2.5开始可以用注解注入属性
 * spring3.0开始出现了下面的javaConfig方式,此时还可以用xml来配置一部分属性
 * spring4.0开始支持springboot1.0，springboot完全使用javaConfig，至此javaConfig完全吸收xml的功能
 */
//标识配置类，替代XML的方式来装载spring上下文
//Configuration也是拓展了component，说明component是基础
@Configuration
@ComponentScan(basePackages = "org.sean")
//也可以获取properties，说明config是完全可以替代xml的
//然后就可以配合@Valule来获取属性资源了
@PropertySource("classpath:db.properties")
//比标签的import的可用性更强的@import
//@Import(IocBaseConfig.class)
//1.可以引入多个外部配置,annotation的语法能识别一个和多个，利用{}
//2.下面利用import导入了importTest类，结果很明显，import导入的类，注册的顺序要在其他方式之后
//3.ImportSelector的方式在BaseImportConfig里面,他可以根据类的完整限定名注册多个bean
//4.可以实现ImportBeanDefinitionRegistrar。
@Import({IocBaseConfig.class, ImportTest.class})
public class IocConfig {
    @Value("${password}")
    private String password;

    //     <bean class="com.alibaba.druid.pool.DruidDataSource" id="dataSource">
//        <property name="username" value="${username}"></property>
//        <property name="password" value="${password}"></property>
//        <property name="driverClassName" value="${driverClassName}"></property>
//        <property name="url" value="${url}"></property>
//    </bean>
    @Bean
    public DruidDataSource dataSource() {
        /**
         * 可以从xml看到，property是setter注入，所以下面可以自行set
         * 此时，beanType是返回类型，而beanName是方法名
         */
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUsername("root");
        druidDataSource.setPassword(password);
        druidDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        druidDataSource.setUrl("jdbc:mysql://172.16.182.137:3306/eva");
        return druidDataSource;
    }

    // <bean class="org.sean.bean.Man" id="man" init-method="init" destroy-method="destoryByConfig"></bean>
    @Bean(name = {"lifeCycleController", "seanAnnoController"}, initMethod = "initMethod", destroyMethod = "destroyMethod")
    //Component是将类交给Spring了，这个是我们自己实例化好以后直接给它对象,也就是说，自动扫描扫描的是类，spring自己去实例化
    //先调用@Bean的，Component的就不调用创建了
    //Bean注册的是实例，其他方式注册的是类
    //如果要依赖别的方式注入的外部bean，那么通过形参的类型和名字依赖
    //注入本配置类的Bean同理,也可直接调用方法自动注入
    SeanAnnoController seanAnnoController(SeanBroService seanBroService) {
        System.out.println("SeanAnnoController的@Bean声明式注入容器形式");
        seanBroService.doBroService();
        System.out.println("get " + sObject());
        return new SeanAnnoController();
    }

    @Bean
    String sObject() {
        return new String("innner @Bean inject");
    }

}
