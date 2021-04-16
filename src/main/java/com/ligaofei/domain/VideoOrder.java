package com.ligaofei.domain;

import org.springframework.beans.factory.annotation.Autowired;

public class VideoOrder {

    private int id;

    //订单号
    private String outTradeNo;

    private Video video;



    public VideoOrder(){
        System.out.println("VideoOrder空构造函数被调用");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        System.out.println("videoOrder setVideo方法被调用");
        this.video = video;
    }
}
