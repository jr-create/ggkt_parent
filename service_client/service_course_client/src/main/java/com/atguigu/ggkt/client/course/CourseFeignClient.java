package com.atguigu.ggkt.client.course;

import com.atguigu.ggkt.model.vod.Course;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author 29375-wjr
 * @Package: com.atguigu.ggkt.client.course.client
 * @ClassName: CourseFeignClient
 * @create 2022-08-11 19:53
 * @Description:
 */
@FeignClient(value = "service-vod")
public interface CourseFeignClient {

    @ApiOperation("根据关键字查询课程")
    @GetMapping("/api/vod/course/inner/findByKeyword/{keyword}")
    List<Course> findByKeyword(@PathVariable String keyword);
}
