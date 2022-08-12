package com.atguigu.ggkt.activity.config;

/**
 * @author 29375-wjr
 * @Package: com.atguigu.ggkt.order.config
 * @ClassName: OrderConfig
 * @create 2022-08-06 13:49
 * @Description:
 */

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置类
 */
@Configuration
@MapperScan("com.atguigu.ggkt.activity.mapper")
public class ActivityConfig {
    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
