package org.sean.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Repository
@Primary//设置主要的Dao，优先级会高
public class SeanDao implements Dao {
    private String dapId;

    @PostConstruct
    public void constructAfter() {
        System.out.println("constructAfter");
    }

    @PreDestroy
    public void destoryByAnno() {
        System.out.println("destoryByAnno");
    }

    public SeanDao() {
        System.out.println("SeanDao的空构造方法被调用了");
    }

    public String getDaoId() {
        System.out.println("查询数据库");
        return dapId;
    }

    public void setDaoId(String dapId) {
        this.dapId = dapId;
    }
}
