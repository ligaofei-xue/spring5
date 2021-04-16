package com.ligaofei.proxy;

/**
 * 动态代理和静态代理测试类
 * 动态代理与静态代理相比较，最大的好处是接口中声明的所有方法都被转移到调用处理器一个集中的方法中处理，解耦和易维护
 *
 * 两种动态代理的区别：
 * JDK动态代理：要求目标对象实现一个接口，但是有时候目标对象只是一个单独的对象,并没有实现任何的接口,这个时候就可以用CGLib动态代理
 * CGLib动态代理,它是在内存中构建一个子类对象从而实现对目标对象功能的扩展
 * JDK动态代理是自带的，CGlib需要引入第三方包
 * CGLib动态代理基于继承来实现代理，所以无法对final类、private方法和static方法实现代理
 *
 * Spring AOP中的代理使用的默认策略：
 * 如果目标对象实现了接口，则默认采用JDK动态代理
 * 如果目标对象没有实现接口，则采用CgLib进行动态代理
 * 如果目标对象实现了接扣，程序里面依旧可以指定使用CGlib动态代理
 */
public class ProxyTest {

    public static void main(String [] args){

        //正常调用是new实例调用方法
//        PayService payService = new PayServiceImpl();
//        payService.callback("absdfwr2332");

        //静态代理
//     PayService payService = new StaticProxyPayServiceImpl(new PayServiceImpl());
//     payService.save(234,4232);
//     payService.callback("3r23423423");


        //JDK动态代理
//        JdkProxy jdkProxy = new JdkProxy();
//        //获取代理类对象
//        PayService payServiceProxy = (PayService)jdkProxy.newProxyInstance(new PayServiceImpl());
//        //调用目标方法
//        payServiceProxy.callback("dsfsdfdsfew");
//        payServiceProxy.save(23,42423);


        //CGlib动态代理
        CglibProxy cglibProxy = new CglibProxy();
        PayService payService  = (PayService) cglibProxy.newProxyInstance(new PayServiceImpl());
        //调用目标方法
        payService.callback("f2323dfrv3f23");
        payService.save(23,42423);
    }


}
