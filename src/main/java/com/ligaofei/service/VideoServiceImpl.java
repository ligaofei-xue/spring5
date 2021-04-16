package com.ligaofei.service;


import com.ligaofei.config.CustomConfig;
import com.ligaofei.dao.VideoDao;
import com.ligaofei.domain.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

//@Component("videoService")//不加"videoService"的话bean的名字是首字母小写videoServiceImpl
@Service("videoService")
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoDao videoDao;

    @Autowired
    private CustomConfig customConfig;

    public int save(Video video) {
        System.out.println("保存video");
        return 1;
    }

    public Video findById(int id) {
        System.out.println("根据id找视频");
        videoDao.test();
        System.out.println(customConfig.getHost());

        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new Video();
    }
}
