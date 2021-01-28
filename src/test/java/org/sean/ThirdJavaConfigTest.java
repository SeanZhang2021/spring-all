package org.sean;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.Before;
import org.junit.Test;
import org.sean.bean.ImportPersonOne;
import org.sean.bean.ImportPersonThree;
import org.sean.bean.ImportPersonTwo;
import org.sean.bean.ImportTest;
import org.sean.config.IocConfig;
import org.sean.controller.SeanAnnoController;
import org.sean.controller.SeanController;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.Connection;
import java.sql.SQLException;

public class ThirdJavaConfigTest {
    AnnotationConfigApplicationContext app;

    @Before
    public void init() {
        //通过配置类来加载
        app = new AnnotationConfigApplicationContext(IocConfig.class);

    }

    @Test
    public void test1() {
        SeanController bean = app.getBean(SeanController.class);
        bean.control();
    }

    @Test
    public void test_config_bean_datasource() throws SQLException {
        DruidDataSource bean = app.getBean(DruidDataSource.class);
        bean.init();
        Connection c = bean.getConnection();
        System.out.println("Catalog->" + c.getCatalog());
        app.close();
    }

    @Test
    public void test_config_bean_cnstract_component() throws SQLException {
        //以下申明在代码中也有提到，这个和源码中populateBean那里有关系
        //下面的生命周期都是构造函数执行完之后才做的事情,只是顺序有些意思
        //init：PostConstruct->InitializingBean->initMethod
        //destroy:preDestroy->DisposableBean->destroyMethod
        SeanAnnoController bean1 = app.getBean(SeanAnnoController.class);
        SeanAnnoController bean2 = (SeanAnnoController) app.getBean("lifeCycleController");
        SeanAnnoController bean3 = (SeanAnnoController) app.getBean("seanAnnoController");
        System.out.println(bean1);
        System.out.println(bean2);
        System.out.println(bean3);
        app.close();
    }

    @Test
    public void test_import() {
        System.out.println("start import");
        Object obj = app.getBean("obj");
        System.out.println(obj);
        System.out.println("mid import");
        ImportTest importTest = app.getBean(ImportTest.class);
        System.out.println("next import");
        importTest.importTest();
        System.out.println("finally import");
    }

    @Test
    public void test_import_selector() {
        System.out.println("start test import selector");
        //此时用类或者类的完整限定名获取
        ImportPersonOne obj1 = app.getBean(ImportPersonOne.class);
        System.out.println("import selector import[0]:" + obj1.getName());
        ImportPersonTwo obj2 = app.getBean(ImportPersonTwo.class);
        System.out.println("import selector import[1]:" + obj2.getName());
        ImportPersonOne obj3 = (ImportPersonOne) app.getBean("org.sean.bean.ImportPersonOne");
        System.out.println("import selector import[0] using all name:" + obj3.getName());
        ImportPersonThree obj4 = (ImportPersonThree) app.getBean("importPersonThree");
        System.out.println("import selector import[2] using beanDefinition:" + obj4.getName());
    }
}
