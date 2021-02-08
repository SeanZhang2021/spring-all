package org.sean.tx;

/**
 * 把一组业务当作一个业务来做，就是事务
 *
 * 这里就是用到了spring的数据访问整合模块，
 * jdbc，orm，transactions
 * 事务四大特性：ACID
 * A：要么都成功，要么都失败
 * C：能量守恒，开始与结束的约束一致
 * I：并发状态下，事务的隔离级别
 * D：保存即永久保存
 *
 * Spring的声明式事务将编程式事务的代码从业务方法中抽取了出来，利用了aop的特性，将事务代码作为切面，模式化了。
 * https://www.cnblogs.com/ooo0/p/11029612.html
 * 上面这个哥们儿写的还可以
 *
 * 第一步：创建transactionManager
 * 第二步：将数据源绑定到事务中
 * 第三步：开启事务管理（xml中的tx-driven，javaConfig中的EnableTransactionManagement）
 *
 * Transactional注解可以标注在类和方法上，方法上优先
 * 建议将此注解标注在业务逻辑层上，在该层才有多个dao方法调用
 *
 *
 */
public class TransactionConfig {

}
