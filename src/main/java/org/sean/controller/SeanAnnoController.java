package org.sean.controller;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Controller
public class SeanAnnoController implements InitializingBean, DisposableBean {

    public SeanAnnoController() {
        System.out.println(this.getClass() + "->" + "SeanAnnoController 无参构造函数");
    }

    //下面的生命周期都是构造函数执行完之后才做的事情,只是顺序有些意思
    //init：PostConstruct->InitializingBean->initMethod
    //destroy:preDestroy->DisposableBean->destroyMethod
    @PostConstruct
    public void postConstruct() {
        System.out.println(this.getClass() + "->" + "postConstruct init");

    }

    @PreDestroy
    public void preDestroy() {
        System.out.println(this.getClass() + "->" + "preDestroy destroy");

    }

    public void initMethod() {
        System.out.println(this.getClass() + "->" + "initMethod init");

    }

    public void destroyMethod() {
        System.out.println(this.getClass() + "->" + "destoryMethod destroy");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println(this.getClass() + "->" + "DisposableBean destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(this.getClass() + "->" + "InitializingBean init");
    }
}
