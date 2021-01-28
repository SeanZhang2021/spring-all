package org.sean.controller;

import org.sean.service.Common;
import org.sean.service.CommonOneImpl;
import org.sean.service.IService;
import org.sean.service.SeanBroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
public class SeanController {
    @Autowired
    //可以利用范型注入，公共增删改查的范型方法
            Common<CommonOneImpl> common;

    SeanBroService seanBroService;

    //@Resource是JDK中的注解，而autoWired是Spring的注
    //Resource优先根据名字匹配，而autowired优先根据类型匹配
    //@Resource

    public void control() {
        System.out.println("sean control!");
        common.getThis();
    }

    public void controlSeanBroService() {
        seanBroService.doBroService();
    }

    @Autowired
    //该种方法是利用形参注入的，过程也是先看类型在看name，加qualifier也可以
    public void createUserService(@Qualifier("seanBroService") IService seanBroService) {
        this.seanBroService = (SeanBroService) seanBroService;
    }
}
