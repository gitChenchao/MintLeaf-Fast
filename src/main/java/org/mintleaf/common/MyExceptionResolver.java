package org.mintleaf.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class MyExceptionResolver implements HandlerExceptionResolver{

    @Override
    public ModelAndView resolveException(HttpServletRequest request,HttpServletResponse response, Object handler, Exception ex) {
        //如果是shiro无权操作，因为shiro 在操作auno等一部分不进行转发至无权限url
        if(ex instanceof UnauthorizedException){
            ModelAndView mv = new ModelAndView("/403.html");
            return mv;
        }
        ex.printStackTrace();
        ModelAndView mv = new ModelAndView("/403.html");
        mv.addObject("exception", ex.toString().replaceAll("\n", "<br/>"));
        return mv;
    }
}
