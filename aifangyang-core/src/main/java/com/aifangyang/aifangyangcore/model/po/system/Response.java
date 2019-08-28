package com.aifangyang.aifangyangcore.model.po.system;

import lombok.Data;

@Data
public class Response {
    private String status;
    private String message;
    private DataEntity dataEntity;
}
