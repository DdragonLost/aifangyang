package com.aifangyang.aifangyangcore.controller;

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
public class HelloWorld
{
    @RequestMapping(value = "/hello/{userName}",method = RequestMethod.GET)
    @ResponseBody
    public String helloWord(@PathVariable(value="userName") String userName,String passWord){
        return "Welcome to our system:"+userName;
    }
}
