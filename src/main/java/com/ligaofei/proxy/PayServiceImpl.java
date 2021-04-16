package com.ligaofei.proxy;

public class PayServiceImpl implements PayService {

    public String callback(String outTradeNo) {
        System.out.println("目标类 PayServiceImpl 回调 方法 callback");
        return outTradeNo;

    }

    public int save(int userId, int productId) {
        System.out.println("目标类 PayServiceImpl 回调 方法 save");
        return productId;
    }
}
