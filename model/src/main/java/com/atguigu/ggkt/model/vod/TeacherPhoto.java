package com.atguigu.ggkt.model.vod;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 29375-wjr
 * @Package: com.atguigu.ggkt.model.vod
 * @ClassName: TeacherPhoto
 * @create 2022-08-01 10:31
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "TeacherPhoto")
@TableName("teacher_photo")
public class TeacherPhoto {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "Id")
    @TableField("id")
    @TableId(type = IdType.AUTO)
    private Long id;


    @ApiModelProperty(value = "图片")
    @TableField("photo")
    private byte[] photo;

    @ApiModelProperty(value = "UUID")
    @TableField("uuid")
    private String uuid;

}
