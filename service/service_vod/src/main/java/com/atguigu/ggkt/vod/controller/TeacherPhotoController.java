package com.atguigu.ggkt.vod.controller;


import com.atguigu.ggkt.config.Result;
import com.atguigu.ggkt.model.vod.Subject;
import com.atguigu.ggkt.model.vod.TeacherPhoto;
import com.atguigu.ggkt.vod.service.TeacherPhotoService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author wjr
 * @since 2022-08-01
 */
@Api(tags = "文件上传接口")
@RestController
@RequestMapping("/admin/vod/file")
// @CrossOrigin //跨域问题
public class TeacherPhotoController {


    @Autowired
    private TeacherPhotoService teacherPhotoService;

    /**
     * 文件上传
     */
    @ApiOperation(value = "文件上传")
    @PostMapping(path = "upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Result upload(
            @ApiParam(name = "file", value = "文件", required = true)
            @RequestParam("file") MultipartFile file) throws IOException {
        byte[] imgbytes = file.getBytes();
        String uuid = UUID.randomUUID().toString();
        teacherPhotoService.save(new TeacherPhoto(1L, imgbytes, uuid));
        return Result.ok("http://localhost:8301/admin/vod/file/download/" + uuid).message("成功");
    }

    @ApiOperation(value = "文件下载")
    @GetMapping("download/{uuid}")
    public Result downloadImg(HttpServletResponse response, @PathVariable String uuid) throws IOException {
        QueryWrapper<TeacherPhoto> wrapper = new QueryWrapper<>();
        wrapper.eq("uuid", uuid);
        TeacherPhoto teacherPhoto = teacherPhotoService.getBaseMapper().selectOne(wrapper);
        ServletOutputStream out = response.getOutputStream();
        out.write(teacherPhoto.getPhoto());
        out.close();
        return Result.ok(null).message("成功");
    }

    //删除视频
    @DeleteMapping("remove/{uuid}")
    public Result removeVideo(@PathVariable String uuid) {
        teacherPhotoService.removeVideo(uuid);
        return Result.ok(null).message("成功");
    }
}

