package org.sean.service;

import org.sean.bean.Tuhao;
import org.springframework.transaction.annotation.Transactional;

public interface ITuhaoService {
    Tuhao getTuhao();

    @Transactional
    void transfer();
}
