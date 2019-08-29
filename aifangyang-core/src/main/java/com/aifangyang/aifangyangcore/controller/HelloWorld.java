package com.aifangyang.aifangyangcore.controller;

import com.aifangyang.aifangyangcore.Exception.ServiceException;
import com.aifangyang.aifangyangcore.model.SysEnums;
import com.aifangyang.aifangyangcore.model.po.system.DataEntity;
import com.aifangyang.aifangyangcore.model.po.system.Response;
import com.aifangyang.aifangyangcore.model.po.system.UserPo;
import com.aifangyang.aifangyangcore.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * demo
 * @author aifangyang
 */
@RestController
@Slf4j
public class HelloWorld
{
    @Autowired
    private LoginService loginService;

    @RequestMapping("/")
    public Response helloWord()
    {
        DataEntity dataEntity = new DataEntity();
        // 获取所有用户
        List<UserPo> userPoList = loginService.selectAll();
        dataEntity.setData(userPoList);
        Response response = new Response();
        response.setStatus(SysEnums.OK);
        response.setDataEntity(dataEntity);
        return response;
    }

    @RequestMapping("/exception01")
    public Response exception01() throws ServiceException {
        throw new ServiceException("业务异常，ID不能唯为空");
    }

    @RequestMapping("/exception02")
    public Response exception02() throws Exception {
        throw new Exception("系统异常，请联系程序员～");
    }
}
