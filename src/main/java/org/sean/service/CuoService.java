package org.sean.service;

import org.sean.anno.Logger;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class CuoService implements ICuoService {
    @Override
    @Logger(name = "cuo")
    public String cuo(Integer money) {
        if (money > 10) {
            return "much ni";
        }
        return null;
    }
}
