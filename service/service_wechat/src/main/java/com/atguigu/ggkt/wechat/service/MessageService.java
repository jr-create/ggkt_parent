package com.atguigu.ggkt.wechat.service;

import java.util.Map;

/**
 * @author 29375-wjr
 * @Package: com.atguigu.ggkt.wechat.service
 * @ClassName: MessageService
 * @create 2022-08-11 20:01
 * @Description:
 */
public interface MessageService {
    //接收消息
    String receiveMessage(Map<String, String> param);
}
