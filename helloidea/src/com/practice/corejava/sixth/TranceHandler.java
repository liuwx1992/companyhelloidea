package com.practice.corejava.sixth;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @Description:
 * @Author: liuweixin
 * @Date: 2019/3/18
 * @Time: 22:45
 */
public class TranceHandler implements InvocationHandler {

    private Object target;

    public TranceHandler(Object target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {



        return method.invoke(target,args);
    }
}
