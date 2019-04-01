package com.it.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 演示请求转发
// 从 a 跳转到 b
/*
请求转发的特点
    地址栏不变化 http://localhost:8080/demo09_01
    服务器内部资源跳转的方式 不能访问 www.baidu.com
    转发是一次请求  浏览器 netweork 里看请求 只有一次

共享数据
    转发之前
    转发过程中使用的是同一个request对象 所以可以共享数据
    1. a servlet里 setAttribute(String name,Object object)
    2. b servlet里 getAttribute(String name)
    3. 还可以 removeAttribute(String name)
*/
@WebServlet("/demo09_01")
public class Servlet09_01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/demo09_02");
        requestDispatcher.forward(req,resp);
        */
        System.out.println("demo09_01。。，。。");
        req.setAttribute("msg","aaaa");
        req.getRequestDispatcher("/demo09_02").forward(req,resp);

    }
}
