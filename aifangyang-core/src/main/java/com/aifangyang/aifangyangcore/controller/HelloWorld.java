package com.aifangyang.aifangyangcore.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * demo
 * @author aifangyang
 */
@RestController
@RequestMapping("test")
@Slf4j
public class HelloWorld
{
    @RequestMapping(value = "/hello/{userName}",method = RequestMethod.GET)
    @ResponseBody
    public String helloWord(@PathVariable(value="userName") String userName,String passWord)
    {
        log.info("current user:"+userName+" ,password is :"+ passWord);
        log.error("here is a test for log recording");
        return "Welcome to our system:"+userName;
    }
}
