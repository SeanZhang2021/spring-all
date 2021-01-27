package org.sean.service;

import org.springframework.stereotype.Service;

@Service
public class CommonOneImpl implements Common<CommonOneImpl> {
    @Override
    public CommonOneImpl getThis() {
        System.out.println("build commOne");
        return new CommonOneImpl();
    }
}
