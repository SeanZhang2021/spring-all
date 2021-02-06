package org.sean.service;

import org.springframework.stereotype.Service;

@Service
public class SpecialService implements ICuoService {

    @Override
    public String cuo(Integer money) {
        System.out.println("specialService on flight!特殊餐食");
        return "special meal!";
    }
}
