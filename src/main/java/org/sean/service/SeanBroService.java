package org.sean.service;

import org.springframework.stereotype.Service;

@Service
public class SeanBroService implements IService {
    public SeanBroService(){
        System.out.println("SeanBroService的空构造函数被调用了");
    }
    public void doBroService() {
        System.out.println("SeanBroService done");
    }
}
