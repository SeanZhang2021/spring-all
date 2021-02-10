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
    /**
     * @Transactional最好加在方法上
     *
     * 1>>isolation ：设置事务的隔离级别 1：读已提交 2：可重复读 3：顺序读
     * mysql默认是可重复读， oracle默认是读已提交，但它不支持可重复读
     * 所以实际情况下，都是默认的。否则就是顺序读了。
     *
     * 1：隔离级别：read committed
     * 事务只能读已经提交的，否则会产生脏读的问题
     * 解决方案：读已提交
     *
     * 2：隔离级别：read repeatable
     * 一个事务期间内，同一行数据必须读到相同的值，使用事务期间，禁止其他事务对这个字段更新。
     * 解决方案：
     * 行锁：
     * 读锁：
     * 写锁：
     *
     * 3：隔离级别：serializable
     * 一个事务期间内，同一个数据表不能发生变化
     * 表锁
     *
     * 为了防止同一时间内，多个线程对相同的数据（对象，变量）读写操作，产生并发问题
     *
     * 2>>propagation：事务的传播行为
     *  事务嵌套：
     *  service调用service会造成事务嵌套。
     *
     *  -------------|外部不存在事务|外部存在事务           |使用范围
     *  required(默认)|开启新事务   |使用外部事务           |增删改查
     *  supports     |不开启新事务  |融合到外部事务         |查询
     *  requires_new |开启新事务    |挂起外部事务，开启新事务，要保证父方法和子方法不在一个类里面 |适用于内部事务和外部事务没有业务关联，可自行提交，即使别的方法回滚，例：记录数据库中的日志
     *  -----------------------------------------------------------------------------------------------------------------
     *
     * 3>>timeout：事务超出指定执行时长后自动终止并回滚，单位是秒。
     * 请求一个事务方法，最长能等待的秒数，防止加锁时，其他事务等待时间过长。
     *
     * 其他的不常用
     *
     * noRollbackFor：哪些异常不回滚
     * noRollbackClassName：填写的参数是全类名时不回滚
     * rollbackFor:哪些异常需要回滚
     * rollbackClassName：填写的参数是全类名时回滚
     * readOnly：设置事务是否为只读事务
     *
     *
     */
    public void transfer() {
        tuhaoDao.save(24, "zhang", 25);
        int i = 1 / 0;
        tuhaoDao.save(26, "sean", 25);
    }


}
