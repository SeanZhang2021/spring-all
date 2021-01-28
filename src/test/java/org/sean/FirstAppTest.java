package org.sean;

import static org.junit.Assert.assertTrue;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.Before;
import org.junit.Test;
import org.sean.bean.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Unit test for simple App.
 */
public class FirstAppTest {
    ClassPathXmlApplicationContext app;

    @Before
    public void init() {
        app = new ClassPathXmlApplicationContext("classpath:spring-ioc.xml");
    }

    @Test
    public void test_applicationcontext() {
        System.out.println("制造user");
        User user = (User) app.getBean("user");

        System.out.println(user.toString());
        user = (User) app.getBean("u");

        System.out.println(user);
        System.out.println(app.getBeanDefinitionNames().length);
    }

    @Test
    public void test_dependency_inject1() {
        //基于setter方法注入
        User user = (User) app.getBean("user2");
        System.out.println(user.toString());
    }

    @Test
    public void test_dependency_inject2() {
        //基于构造方法注入
        User user = (User) app.getBean("user3");
        System.out.println(user.toString());
    }

    @Test
    public void test_dependency_inject3() {
        //复杂的关系
        Person user = (Person) app.getBean("person");
        System.out.println(user.toString());
    }

    @Test
    public void test_dependency_inject4() {
        //懒加载
        System.out.println("初始化完毕");
        Role user = (Role) app.getBean("role2");
        user = (Role) app.getBean("role2");
        user = (Role) app.getBean("role2");
        System.out.println(user.toString());
    }

    @Test
    public void test_dependency_inject5() {
        //工厂方法
        System.out.println("初始化完毕");
        Student user = (Student) app.getBean("student");
        System.out.println(user.toString());
    }

    @Test
    public void test_dependency_inject6() {
        //实例化工厂bean
        System.out.println("初始化完毕");
        Student user = (Student) app.getBean("student2");
        System.out.println(user.toString());
    }

    @Test
    public void test_dependency_inject7() {
        //自动注入byType Name
        System.out.println("初始化完毕");
        Husband user = (Husband) app.getBean("husband");
        System.out.println(user.toString());
    }

    @Test
    public void test_dependency_inject8() {
        //构造器自动注入
        System.out.println("初始化完毕");
        Husband user = (Husband) app.getBean("husband2");
        System.out.println(user.toString());
    }

    @Test
    public void test_life_cycle() {
        //构造器自动注入
        System.out.println("初始化完毕");
        Man user = (Man) app.getBean("man");
        System.out.println(user.toString());
        app.close();
    }

    @Test
    public void test_3rd_part() {
        //构造器自动注入
        System.out.println("初始化完毕");
        DruidDataSource user = (DruidDataSource) app.getBean("dataSource");
        System.out.println(user.getMaxActive());
        try {
            Connection connection = user.getConnection();
            System.out.println(connection.getTransactionIsolation());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void test_spel() {
        //构造器自动注入
        System.out.println("初始化完毕");
        SpelBean user = (SpelBean) app.getBean("spelBean");
        System.out.println(user.toString());
        app.close();
    }
}
