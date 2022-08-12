package com.atguigu.ggkt.vod.service.impl;

import com.atguigu.ggkt.model.vod.TeacherPhoto;
import com.atguigu.ggkt.vod.mapper.TeacherPhotoMapper;
import com.atguigu.ggkt.vod.service.TeacherPhotoService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author wjr
 * @since 2022-08-01
 */
@Service
public class TeacherPhotoServiceImpl extends ServiceImpl<TeacherPhotoMapper, TeacherPhoto> implements TeacherPhotoService {

    @Override
    public TeacherPhotoMapper getBaseMapper() {
        return this.baseMapper;
    }

    @Override
    public void removeVideo(String uuid) {
        QueryWrapper<TeacherPhoto> wrapper = new QueryWrapper<>();
        wrapper.eq("uuid", uuid);
        baseMapper.delete(wrapper);
    }
}
