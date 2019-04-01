package com.it.web.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/*
@WebServlet("资源路径")  不需要包含虚拟目录
@WebServlet(urlPatterns = "/demo3")
如果只有一个路径
@WebServlet(value="/demo3")
或者
@WebServlet("/demo3")
*/

@WebServlet(urlPatterns = "/demo3")
public class ServletDemo3 implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("servlet3.0注解配置，再也不用去web.xml里写 配置了");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
