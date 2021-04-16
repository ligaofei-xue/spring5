package com.ligaofei.service;


import com.ligaofei.domain.Video;

public interface VideoService {

    int save(Video video);

    Video findById(int id);

}
