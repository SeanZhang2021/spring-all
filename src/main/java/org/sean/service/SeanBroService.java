package org.sean.service;

import org.springframework.stereotype.Service;

@Service
public class SeanBroService implements IService {
    public void doBroService() {
        System.out.println("seanBroService done");
    }
}
