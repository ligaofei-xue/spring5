package com.ligaofei.domain;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

public class Video {

    private int id;

    private String title;

    private List<String> chapterList;


    private Map<Integer,String> videoMap;


    /**
     * 类的构造函数重写的时候，一定要保留空构造函数！！！
     * spring重写对象构造函数的时候一定要明显的把空构造函数保留
     * 没有明显的写出来空构造函数，他就会消失，这是javase的语言。
     * 如果不写出来，使用set方法注入才可以正常运行，多数情况下都是使用普通set方法注入的。
     */
    public Video(){

    }

    public Video(String title){
        System.out.println("video 带参数构造函数被调用");
        this.title = title;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        System.out.println("Video setId方法被调用");
        this.id = id;
    }

    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {

        System.out.println("Video setTitle方法被调用");
        this.title = title;
    }

    public List<String> getChapterList() {
        return chapterList;
    }

    public void setChapterList(List<String> chapterList) {
        this.chapterList = chapterList;
    }

    public Map<Integer, String> getVideoMap() {
        return videoMap;
    }

    public void setVideoMap(Map<Integer, String> videoMap) {
        this.videoMap = videoMap;
    }
}
