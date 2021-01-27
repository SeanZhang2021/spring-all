package org.sean.service;

import org.springframework.stereotype.Service;

@Service
public class CommonTwoImpl implements Common<CommonTwoImpl> {
    @Override
    public CommonTwoImpl getThis() {
        System.out.println("build common two");
        return new CommonTwoImpl();
    }
}
