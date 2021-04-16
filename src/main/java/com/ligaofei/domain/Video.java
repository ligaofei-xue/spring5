package com.ligaofei.domain;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;
import java.util.Map;
@Component
//@Scope("prototype")//bean作用范围注解，prototype是多例，默认是单例的，不用加这个注解
@Scope
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
        System.out.println("video 空构造函数被调用");
    }

    public Video(String title){
        System.out.println("video 带参数构造函数被调用");
        this.title = title;
    }
    @PostConstruct//注解方式初始化，相当于XML配置的init-method
    public void init(){
        System.out.println("video类 init 方法被调用");
    }

    @PreDestroy//注解方式销毁，相当于XML配置的destroy-method
    public void destroy(){
        System.out.println("video类 destroy 方法被调用");
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
