package com.atguigu.ggkt.user.mapper;

import com.atguigu.ggkt.model.user.UserInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author wjr
 * @since 2022-08-07
 */
@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {

}
