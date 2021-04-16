package com.ligaofei.proxy;

/**
 * 静态代理(代理是AOP中最核心的)
 * 由程序创建或特定工具自动生成源代码，在程序运行前，代理类的.class文件就已经存在
 * 通过将目标类与代理类实现同一个接口，让代理类持有真实类对象，然后在代理类方法中调用真实类方法，
 * 在调用真实类方法的前后添加我们所需要的功能扩展代码来达到增强的目的
 * A -> B -> C
 *
 * 优点
 * 代理使客户端不需要知道实现类是什么，怎么做的，而客户端只需知道代理即可
 * 方便增加功能，拓展业务逻辑
 *
 * 缺点
 * 代理类中出现大量冗余的代码，非常不利于扩展和维护
 * 如果接口增加一个方法，除了所有实现类需要实现这个方法外，所有代理类也需要实现此方法。增加了代码维护的复杂度
 */
public class StaticProxyPayServiceImpl implements PayService {

    private PayService payService;

    public  StaticProxyPayServiceImpl(PayService payService){
        this.payService = payService;
    }

    public String callback(String outTradeNo) {
        System.out.println("StaticProxyPayServiceImpl callback begin");
        String result = payService.callback(outTradeNo);
        System.out.println("StaticProxyPayServiceImpl callback end");
        return result;
    }

    public int save(int userId, int productId) {
        System.out.println("StaticProxyPayServiceImpl save begin");
        int id = payService.save(userId, productId);
        System.out.println("StaticProxyPayServiceImpl save end");
        return id;
    }
}
