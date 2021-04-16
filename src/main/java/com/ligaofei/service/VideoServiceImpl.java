package com.ligaofei.service;


import com.ligaofei.domain.Video;

public class VideoServiceImpl implements VideoService {

    public int save(Video video) {
        System.out.println("保存video");
        return 1;
    }

    public Video findById(int id) {
        System.out.println("根据id找视频");
        return new Video();
    }
}
