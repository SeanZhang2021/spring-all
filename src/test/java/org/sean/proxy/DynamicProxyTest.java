package org.sean.proxy;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class DynamicProxyTest {

    @Test
    public void testJdkDynamicProxy1() {
        /**
         * ClassLoader loader:类加载器，通常指定的被代理类的接口的类加载器
         * interfaces:通常指定被代理类的接口的类型
         * InvocationHandler 委托执行的处理类(可用lambda方法代替，被代理类的所有方法都要经过这个方法处理)
         */
        Caculator target = new Caculator();
        ClassLoader classLoader = ICaculator.class.getClassLoader();
        Class<?>[] interfaces = new Class[]{ICaculator.class};
        InvocationHandler invocationHandler = new MyInvocationHandler(target);
        ICaculator proxyCaculator = (ICaculator) Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
        System.out.println(proxyCaculator.getClass());
        System.out.println(proxyCaculator.add(1, 1));
    }

    @Test
    public void testJdkDynamicProxy2() {
        /**
         * ClassLoader loader:类加载器，通常指定的被代理类的接口的类加载器
         * interfaces:通常指定被代理类的接口的类型
         * InvocationHandler 委托执行的处理类(可用lambda方法代替，被代理类的所有方法都要经过这个方法处理)
         */
        SomeService target = new SomeService();
        ClassLoader classLoader = ISomeService.class.getClassLoader();
        Class<?>[] interfaces = new Class[]{ISomeService.class};
        InvocationHandler invocationHandler = new MyInvocationHandler(target);
        ISomeService proxyCaculator = (ISomeService) Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
        System.out.println(proxyCaculator.getClass());
        System.out.println(proxyCaculator.doSomeService("zhangzhang"));
    }

    @Test
    public void testJdkDynamicProxy3() {
        /**
         * ClassLoader loader:类加载器，通常指定的被代理类的接口的类加载器
         * interfaces:通常指定被代理类的接口的类型
         * InvocationHandler 委托执行的处理类(可用lambda方法代替，被代理类的所有方法都要经过这个方法处理)
         */
        SomeService target = new SomeService();
        ClassLoader classLoader = ISomeService.class.getClassLoader();
        Class<?>[] interfaces = new Class[]{ISomeService.class};
        InvocationHandler invocationHandler = new MyInvocationHandler(target);
        ISomeService proxyCaculator = (ISomeService) Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
        System.out.println(proxyCaculator.getClass());
        System.out.println(proxyCaculator.doSomeProviderService());
    }

    @Test
    public void testJdkDynamicProxy4() {
        /**
         * ClassLoader loader:类加载器，通常指定的被代理类的接口的类加载器
         * interfaces:通常指定被代理类的接口的类型
         * InvocationHandler 委托执行的处理类(可用lambda方法代替，被代理类的所有方法都要经过这个方法处理)
         */
        ISomeService someService = (ISomeService) ProxyFactory.createProxy(new SomeService(), ISomeService.class);
        System.out.println(someService.getClass());
        System.out.println(someService.doSomeProviderService());
    }

}
