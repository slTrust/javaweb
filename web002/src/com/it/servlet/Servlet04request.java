package com.it.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/demo04")
public class Servlet04request extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("打印request");
        // org.apache.catalina.connector.RequestFacade@5d870245
        System.out.println(req);
        // GET  /web002/demo04?name=zhangsan HTTP 1.1

        /*
        * 重点掌握
        *  getContextPath() 获取虚拟目录
        *
        *  getRequestURI() 获取 uri、
        * */

        // 请求方式 getMethod()
        System.out.println(req.getMethod()); // GET

        // 获取虚拟目录 getContextPath()
        System.out.println(req.getContextPath()); // web002

        // 获取Servlet的路径  getServletPath()
        System.out.println(req.getServletPath()); // /demo04

        // 获取get方式的请求参数 name=zhangsan
        System.out.println("queryString");
        System.out.println(req.getQueryString()); //

        // 获取请求 uri
        System.out.println("uri");
        System.out.println(req.getRequestURI()); // /web002/demo04

        // 获取请求 url
        System.out.println("url");
        System.out.println(req.getRequestURL()); // http://localhost/web002/demo04

        // 获取协议和版本
        System.out.println(req.getProtocol());

        // 获取客户机 的 IP
        System.out.println(req.getRemoteAddr());
    }
}
