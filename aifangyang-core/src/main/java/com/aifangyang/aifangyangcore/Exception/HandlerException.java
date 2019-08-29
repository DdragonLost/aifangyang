package com.aifangyang.aifangyangcore.Exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
// 异常以Json格式返回 等同 ExceptionHandler + ResponseBody 注解
// @RestControllerAdvice
public class HandlerException {

    /**
     * 自定义业务异常映射，返回JSON格式提示
     * @param request 请求
     * @param e 异常
     * @return 自定义异常返回
     */
    @ExceptionHandler(value = ServiceException.class)
    @ResponseBody
    public ReturnException handler01 (HttpServletRequest request,ServiceException e){
        ReturnException returnException = new ReturnException();
        returnException.setCode(600);
        returnException.setMsg(e.getMessage());
        returnException.setUrl(String.valueOf(request.getRequestURL()));
        return returnException;
    }


    /**
     * 服务异常
     * @param request 请求
     * @param e 异常
     * @return 跳转指定页面
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ReturnException handler02 (HttpServletRequest request,Exception e){
        ReturnException returnException = new ReturnException();
        returnException.setCode(400);
        returnException.setMsg(e.getMessage());
        returnException.setUrl(String.valueOf(request.getRequestURL()));
        return returnException;
    }
}
