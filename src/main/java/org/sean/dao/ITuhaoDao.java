package org.sean.dao;

import org.sean.bean.Tuhao;

public interface ITuhaoDao {
    Tuhao queryTuhao();

    void save(int age, String oriName, int oriAge);
}
