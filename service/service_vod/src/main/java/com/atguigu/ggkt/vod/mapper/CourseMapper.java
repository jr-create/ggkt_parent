package com.atguigu.ggkt.vod.mapper;

import com.atguigu.ggkt.model.vod.Course;
import com.atguigu.ggkt.vo.vod.CoursePublishVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 课程 Mapper 接口
 * </p>
 *
 * @author wjr
 * @since 2022-07-22
 */
@Repository
public interface CourseMapper extends BaseMapper<Course> {
    //根据id获取课程发布信息
    CoursePublishVo selectCoursePublishVoById(Long id);
}
