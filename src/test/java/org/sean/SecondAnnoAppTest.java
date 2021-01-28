package org.sean;

import org.junit.Before;
import org.junit.Test;
import org.sean.bean.NameValue;
import org.sean.controller.SeanController;
import org.sean.dao.SeanDao;
import org.sean.service.CommonOneImpl;
import org.sean.service.SeanBroService;
import org.sean.service.SeanService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SecondAnnoAppTest {
    ClassPathXmlApplicationContext app;

    @Before
    public void init() {
        app = new ClassPathXmlApplicationContext("classpath:spring-anno.xml");
    }

    @Test
    public void test_scan() {
        //测试注解扫描
        SeanDao bean = app.getBean(SeanDao.class);
        System.out.println(bean);
    }

    @Test
    public void test_value() {
        //测试注解扫描
        NameValue bean = app.getBean(NameValue.class);
        System.out.println(bean.getName());
    }

    @Test
    public void test_service() {
        //测试注解扫描
        SeanService bean = app.getBean(SeanService.class);
        bean.doService();
    }

    @Test
    public void test_common_one_two() {
        //测试注解扫描
        SeanController bean = app.getBean(SeanController.class);
        bean.control();
        bean.controlSeanBroService();
    }

    @Test
    public void test_lazy() {
        //测试注解扫描
        SeanBroService bean = app.getBean(SeanBroService.class);
        bean.doBroService();
        app.close();
    }
}
