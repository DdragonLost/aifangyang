package com.aifangyang.aifangyangcore.Exception;

import lombok.Data;

@Data
public class ReturnException {
    // 响应码
    private Integer code;
    // 异常描述
    private String msg;
    // 请求的Url
    private String url;
}
