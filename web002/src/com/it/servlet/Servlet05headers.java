package com.it.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/demo05")
public class Servlet05headers extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // getHeader(String name) 获取名字对应的值
        System.out.println("获取请求头");
        System.out.println(req.getHeader("accept"));

        System.out.println("获取所有请求头信息");
        // getHeaderNames() 获取所有请求头名称
        Enumeration<String> headers = req.getHeaderNames();
        // 遍历
        while (headers.hasMoreElements()){
            // 根据名称获取请求头的值
            String name = headers.nextElement();
            String value = req.getHeader(name);
            System.out.println(name + "----" + value);
        }

    }
}
