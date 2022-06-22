package com.kou.controller;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 拦截所有请求,解析请求进行具体的请求派发
 *
 * @author KouChaoJie
 * @since: 2022/6/22 16:28
 */
@WebServlet("/")
@Slf4j
public class DispatcherServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("当前请求路径:{}", req.getServletPath());
        log.info("当前请求方法:{}", req.getMethod());
    }
}
