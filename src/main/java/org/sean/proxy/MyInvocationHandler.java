package org.sean.proxy;

import org.sean.bean.Man;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

/**
 * 公共的jdk动态代理生成方法
 */
public class MyInvocationHandler implements InvocationHandler {

    private Object target;

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理对象已创建成功，进入调用代理对象环节-------->");
        List<Object> params = null;
        if (args != null) {
            params = Arrays.asList(args);
        }
        System.out.println("方法:" + method.getName() + " " + "参数:" + params);
        Object result = method.invoke(target, args);
        System.out.println("返回值是:" + result);
        System.out.println("线程:" + Thread.currentThread().getName());
        //切记返回的是被代理类的方法执行结果，不能自己篡改
        return result;
    }
}
