package org.sean.service.impl;

import org.sean.bean.Tuhao;
import org.sean.dao.ITuhaoDao;
import org.sean.service.ITuhaoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TuhaoServiceImpl implements ITuhaoService {
    private ITuhaoDao tuhaoDao;

    public TuhaoServiceImpl(ITuhaoDao tuhaoDao) {
        this.tuhaoDao = tuhaoDao;
    }

    @Override
    public Tuhao getTuhao() {
        return tuhaoDao.queryTuhao();
    }

    @Transactional
    @Override
    public void transfer() {
        tuhaoDao.save(24, "zhang", 25);
        int i = 1 / 0;
        tuhaoDao.save(26, "sean", 25);
    }


}
