package com.aifangyang.aifangyangcore.model.po.system;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "SYS_USER")
@Data
public class UserPo {
    @Id //这是一个主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)//自增主键
    private Integer id;

    @Column(name = "USER_NAME",length = 255) //这是和数据表对应的一个列
    private String userName;

    @Column(name = "PASS_WORD",length = 255) //这是和数据表对应的一个列
    private String passWord;

    @Column(name = "REMARK",length = 255) //这是和数据表对应的一个列
    private String remark;

    @Column(name = "ADD_TIME",length = 255) //这是和数据表对应的一个列
    private Date addTime;

    @Column(name = "UPDATE_TIME",length = 255) //这是和数据表对应的一个列
    private Date updateTime;

    @Column(name = "IS_DELETE",length = 1) //这是和数据表对应的一个列
    private String isDelete;
}
