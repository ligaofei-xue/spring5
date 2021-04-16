package com.ligaofei.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * AOP的实现策略之CGLib动态代理
 * 在程序运行时，运用反射机制动态创建而成，无需手动编写代码
 * CgLib动态代理的原理是对指定的业务类生成一个子类，并覆盖其中的业务方法来实现代理
 */
public class CglibProxy  implements MethodInterceptor {

    //目标类
    private Object targetObject;

    //绑定关系
    public Object newProxyInstance(Object targetObject){
        this.targetObject = targetObject;
        Enhancer enhancer = new Enhancer();
        //设置代理类的父类（目标类）
        enhancer.setSuperclass(this.targetObject.getClass());
        //设置回调函数
        enhancer.setCallback(this);
        //创建子类（代理对象）
        return enhancer.create();
    }

    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        Object result = null;
        try{
            System.out.println("通过CGLIB动态代理调用 "+method.getName() +", 打印日志 begin");
            result = methodProxy.invokeSuper(o,args);
            System.out.println("通过CGLIB动态代理调用 "+method.getName() +", 打印日志 begin");
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }


}
