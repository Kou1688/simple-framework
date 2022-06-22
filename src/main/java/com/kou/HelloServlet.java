package com.kou;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author KouChaoJie
 * @since: 2022/6/14 16:00
 */
@WebServlet("/hello")
@Slf4j
public class HelloServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        log.info("初始化servlet.....");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("调用service,调用请求....");
        doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = "第一个类Spring简易框架";
        log.info("name is:{}", name);
        req.setAttribute("name", name);
        req.getRequestDispatcher("/WEB-INF/jsp/hello.jsp").forward(req, resp);
    }

    @Override
    public void destroy() {
        log.info("销毁servlet....");
    }

}
