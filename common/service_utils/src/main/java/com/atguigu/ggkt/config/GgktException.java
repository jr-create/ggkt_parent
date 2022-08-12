package com.atguigu.ggkt.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 29375-wjr
 * @Package: com.atguigu.ggkt.config
 * @ClassName: GgktException
 * @create 2022-07-03 13:39
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GgktException extends RuntimeException {
    private Integer code;
    private String msg;
}
