package org.sean.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Man implements InitializingBean, DisposableBean {
    private String id;
    private String name;

    public void init() {
        System.out.println("init go go go");
    }

    public void destoryByConfig() {
        System.out.println("destory go go go");
    }

    @Override
    public String toString() {
        return "Man{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public Man() {
        System.out.println("man加载");
    }

    public Man(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("populate结束" + "id=" + id + "name=" + name);
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destory之前" + "id=" + id + "name=" + name);
    }
}
