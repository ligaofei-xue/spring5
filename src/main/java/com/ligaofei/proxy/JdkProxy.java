package com.ligaofei.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * AOP常见的实现的策略JDK动态代理
 * 在程序运行时，运用反射机制动态创建而成，无需手动编写代码
 * JDK动态代理与静态代理一样，目标类需要实现一个代理接口,再通过代理对象调用目标方法
 *
 */
public class JdkProxy implements InvocationHandler {

    //目标类
    private Object targetObject;

    //获取代理对象
    public Object newProxyInstance(Object targetObject){
        this. targetObject = targetObject;

        //绑定关系，也就是和具体的哪个实现类关联(通过反射实现)
        return  Proxy.newProxyInstance(targetObject.getClass().getClassLoader(),
                targetObject.getClass().getInterfaces(),this);
    }


    /**
     * Object proxy:被代理的对象
     * Method method:要调用的方法
     * Object[] args:方法调用时所需要参数
     */
    public Object invoke(Object proxy, Method method, Object[] args) {

        Object result = null;
        try{
            System.out.println("通过JDK动态代理调用 "+method.getName() +", 打印日志 begin");
            result = method.invoke(targetObject,args);
            System.out.println("通过JDK动态代理调用 "+method.getName() +", 打印日志 end");
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
