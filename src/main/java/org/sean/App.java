package org.sean;

import org.sean.bean.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ca = new ClassPathXmlApplicationContext("classpath:spring-ioc.xml");
        User user = (User) ca.getBean("user");
        System.out.println(user.toString());
    }
}
