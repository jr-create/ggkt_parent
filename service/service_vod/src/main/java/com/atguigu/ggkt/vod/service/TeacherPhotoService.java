package com.atguigu.ggkt.vod.service;

import com.atguigu.ggkt.model.vod.TeacherPhoto;
import com.atguigu.ggkt.vod.mapper.TeacherPhotoMapper;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author wjr
 * @since 2022-08-01
 */
public interface TeacherPhotoService extends IService<TeacherPhoto> {
    TeacherPhotoMapper getBaseMapper();

    void removeVideo(String uuid);
}
