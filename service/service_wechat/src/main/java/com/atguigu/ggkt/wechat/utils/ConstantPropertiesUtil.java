package com.atguigu.ggkt.wechat.utils;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author 29375-wjr
 * @Package: com.atguigu.ggkt.wechat.utils
 * @ClassName: ConstantPropertiesUtil
 * @create 2022-08-09 13:39
 * @Description:
 */
@Component
public class ConstantPropertiesUtil implements InitializingBean {

    @Value("${wechat.mpAppId}")
    private String appid;

    @Value("${wechat.mpAppSecret}")
    private String appsecret;

    public static String ACCESS_KEY_ID;
    public static String ACCESS_KEY_SECRET;

    @Override
    public void afterPropertiesSet() throws Exception {
        ACCESS_KEY_ID = appid;
        ACCESS_KEY_SECRET = appsecret;
    }
}
