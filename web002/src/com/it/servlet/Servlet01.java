package com.it.servlet;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/*
GenericServlet 将Servlet接口其他方法做了默认空实现，只将 service方法作为抽象
虽然很方便，但是平时我们不用这个类 我们使用HttpServlet
*/
@WebServlet("/demo01")
public class Servlet01 extends GenericServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("demo01");
    }
}
