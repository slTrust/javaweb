package com.it.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 演示请求转发
// 从 a 跳转到 b
@WebServlet("/demo09_02")
public class Servlet09_02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String msg = (String) req.getAttribute("msg");

        // 移除键值对
        req.removeAttribute("msg");
        System.out.println(msg);
        System.out.println("demo09_02。。，。。");
    }
}
