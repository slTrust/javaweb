package com.it.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


//@WebServlet({"/demo03","/demo003","/demo0003"}) // 匹配多个
//@WebServlet("/user/demo03") // 两层路径
//@WebServlet("/user/*") // 两层路径 任意匹配
//@WebServlet("/*") //  任意匹配 优先级最低

@WebServlet("*.do") // 前面不能有 “ / ” 匹配 任意.do 路径
public class Servlet03 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("do get demo03");
    }
}
