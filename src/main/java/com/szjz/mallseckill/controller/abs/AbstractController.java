package com.szjz.mallseckill.controller.abs;

import com.szjz.mallseckill.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * author:szjz
 * date:2019/7/24
 * <p>
 * The top level parent class of all controllers
 */

@Slf4j
public abstract class AbstractController<T> extends Result {

    protected HttpServletRequest getHttpServletRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

    protected HttpServletResponse getHttpServletResponse() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
    }

    protected Session getSession() {
        Subject subject = SecurityUtils.getSubject();
        return subject.getSession();
    }

    protected T getLoginUser() {
        Subject subject = SecurityUtils.getSubject();
        log.info("subject: {}", subject.toString());
        T t = (T) subject.getPrincipal();
        return t;
    }



}
