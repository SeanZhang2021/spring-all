package org.sean.service;

import org.sean.dao.Dao;
import org.sean.dao.SeanDao;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("seanService")
public class SeanService implements IService, DisposableBean, InitializingBean {

    /**
     * @Autowired 加在字段上，默认根据类型自动装配，如果发现了匹配到多个（仅发生在继承或实现了接口的情况下）
     * </p>就根据字段名字匹配，名字没有匹配到才报错
     */
    @Autowired
    //qualifier可以用来改beanName
    //@Qualifier("seanDao")
    private Dao seanDao;

    public SeanService() {
        System.out.println("SeanService 空构造方法被调用了");
    }

//    public SeanService(SeanDao seanDao) {
//        System.out.println("SeanService的有参构造方法被调用了");
//        this.seanDaoI = seanDao;
//    }

    public void doService() {
        seanDao.getDaoId();
    }

    public Dao getSeanDao() {
        return seanDao;
    }

    //    @Autowired
    public void setSeanDao(Dao seanDao) {
        this.seanDao = seanDao;
        System.out.println("seanDao通过Setter方法注入了seanService中");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("SeanService disposeable destory");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("SeanService afterPropertiesSet");
    }
}
