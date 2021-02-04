package org.sean.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ProxyFactory {

    public static Object createProxy(Object target, Class<?> inter) {
        ClassLoader classLoader = target.getClass().getClassLoader();
        Class<?>[] interfaces = new Class[]{inter};
        InvocationHandler invocationHandler = new MyInvocationHandler(target);
        return Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
    }
}
