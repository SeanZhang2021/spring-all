package org.sean;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.Assert;
import org.junit.Test;
import org.sean.bean.Tuhao;
import org.sean.service.ITuhaoService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class JdbcTest {
    private static final AnnotationConfigApplicationContext ca = new AnnotationConfigApplicationContext("org.sean");

    @Test
    public void test01() {
        DruidDataSource dataSource = ca.getBean(DruidDataSource.class);
        System.out.println(dataSource.getUsername());
    }

    @Test
    public void test02() {
        JdbcTemplate jdbcTemplate = ca.getBean(JdbcTemplate.class);
        Long count = jdbcTemplate.queryForObject("select count(1) from test_inno_index", Long.class);
        System.out.println(count);
    }

    @Test
    public void test03() {
        JdbcTemplate jdbcTemplate = ca.getBean(JdbcTemplate.class);
        Tuhao tuhao = jdbcTemplate.queryForObject("select name,age from test_inno_index where id=1",
                (resultSet, i) -> {
                    Tuhao tuhao1 = new Tuhao();
                    tuhao1.setName(resultSet.getString("name"));
                    tuhao1.setAge(resultSet.getInt("age"));
                    return tuhao1;
                });
        System.out.println(tuhao);

    }

    @Test
    public void test04() {
        JdbcTemplate jdbcTemplate = ca.getBean(JdbcTemplate.class);
        List<Tuhao> tuhaos = jdbcTemplate.query("select name,age from test_inno_index",
                (resultSet, i) -> {
                    Tuhao tuhao1 = new Tuhao();
                    tuhao1.setName(resultSet.getString("name"));
                    tuhao1.setAge(resultSet.getInt("age"));
                    return tuhao1;
                });
        System.out.println(tuhaos);

    }

    @Test
    public void test05() {
        JdbcTemplate jdbcTemplate = ca.getBean(JdbcTemplate.class);
        jdbcTemplate.update("update test_inno_index set name='2',age=3 where id=9 ");
    }

    @Test
    public void test06() {
        JdbcTemplate jdbcTemplate = ca.getBean(JdbcTemplate.class);
        jdbcTemplate.update("insert into test_inno_index (name,age) values ( '3',4 )");
    }

    @Test
    public void test07() {
        JdbcTemplate jdbcTemplate = ca.getBean(JdbcTemplate.class);
        jdbcTemplate.update("delete from test_inno_index where id=8");
    }

    @Test
    public void test08() {
        ITuhaoService tuhaoService = ca.getBean(ITuhaoService.class);
        Assert.assertEquals("zhang", tuhaoService.getTuhao().getName());
    }

    @Test
    public void test09() {
        ITuhaoService tuhaoService = ca.getBean(ITuhaoService.class);
        tuhaoService.transfer();
    }
}