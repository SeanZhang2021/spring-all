package org.sean.service;

import org.sean.bean.Bro;
import org.springframework.stereotype.Service;

@Service
public class SeanBroService implements IService {
    public SeanBroService() {
        System.out.println("SeanBroService的空构造函数被调用了");
    }

    public void doBroService() {
        System.out.println("SeanBroService done");
    }

    public Bro doBroServiceAndReturn(String name) throws Exception {
        System.out.println("occur network broken");
        Thread.sleep(1000);
        try {
            throw new Exception("something wrong!");
        } catch (Exception e) {
            System.out.println("SeanBroService inner exception:" + e);
        }
        if ("rockman".equals(name)) {
            throw new Exception("rockman is coming!");
        }
        Bro bro = new Bro(name);
        System.out.println("SeanBroService done! and Return Bro!");
        return bro;
    }
}
