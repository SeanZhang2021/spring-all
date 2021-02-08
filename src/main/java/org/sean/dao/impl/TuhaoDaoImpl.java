package org.sean.dao.impl;

import org.sean.bean.Tuhao;
import org.sean.dao.ITuhaoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;


@Repository
public class TuhaoDaoImpl implements ITuhaoDao {

    /**
     * jdbcTemplate的最佳实践，
     * 避免同一线程的多个dao使用一个jdbcTemplate而导致数据混乱？？？
     */
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDatasource(DataSource datasource) {
        this.jdbcTemplate = new JdbcTemplate(datasource);
    }

    public Tuhao queryTuhao() {
        Tuhao tuhao = jdbcTemplate.queryForObject("select name,age from test_inno_index where id=1",
                (resultSet, i) -> {
                    Tuhao tuhao1 = new Tuhao();
                    tuhao1.setName(resultSet.getString("name"));
                    tuhao1.setAge(resultSet.getInt("age"));
                    return tuhao1;
                });
        return tuhao;
    }

    @Override
    public void save(int age, String oriName, int oriAge) {
        Object[] objects = new Object[3];
        objects[0] = age;
        objects[1] = oriName;
        objects[2] = oriAge;
        jdbcTemplate.update("update test_inno_index set age=? where name=?and age=?", objects);
    }


}
