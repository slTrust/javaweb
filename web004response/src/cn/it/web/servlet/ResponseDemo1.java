package cn.it.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
* 重定向
*
* */
@WebServlet("/responseDemo1")
public class ResponseDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 访问 /responseDemo1 自动跳转到 /responseDemo2
        System.out.println("DEMO1被访问了");
        /*
        //1 设置状态码 302
        resp.setStatus(302);
        //2 设置响应头 location
        resp.setHeader("location","/web004/responseDemo2");
        */

        // 简化版本重定向
        resp.sendRedirect("/web004/responseDemo2");
    }
}

