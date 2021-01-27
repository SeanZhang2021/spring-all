package org.sean.dao;

import org.sean.service.SeanService;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

@Repository
@DependsOn("seanDao")
@Lazy
public class SeanBroDao implements Dao {
    private String daoName;

    public SeanBroDao() {
        System.out.println("BroDao的空构造方法被调用了");
    }

    public String getDaoName() {
        return daoName;
    }

    public void setDaoName(String daoName) {
        this.daoName = daoName;
    }

    @Override
    public String getDaoId() {
        return "bro dao";
    }
}
