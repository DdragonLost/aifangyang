package com.aifangyang.aifangyangcore.controller.system;

import com.aifangyang.aifangyangcore.model.system.request.User;
import com.aifangyang.aifangyangcore.service.LoginService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * demo
 * @author aifangyang
 */
@RestController
@RequestMapping("system")
@Slf4j
@Api(value="用户相关接口")
public class LoginController
{
    @Autowired
    private LoginService loginService;

    /**
     * check user info
     * @param user userInfo get
     * @return is user info current
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public String helloWord(User user)
    {
        log.info("current user:"+user.getUserName()+" ,password is :"+ user.getPassWord());
        log.error("here is a test for log recording");
        boolean isExisits = loginService.isUserExists(user);
        if (isExisits){
            return "Welcome to our system:"+user.getUserName();
        }
        return "user info is error.";
    }
}
