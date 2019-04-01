package cn.it.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/responseDemo3")
public class ResponseDemo3设置字符集 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("DEMO3被访问了");
        /*
        // 0 设置流的编码  默认ISO-8859-1
        resp.setCharacterEncoding("utf-8");
        // 0.5 告诉浏览器消息体数据的编码。建议浏览器使用该编码
        resp.setHeader("content-type","text/html;charset=utf-8"); // 有这句可以省略不写 resp.setCharacterEncoding("utf-8");
        */

        // 提供了简单方式设置编码 注意获取流之前设置
        resp.setContentType("text/html;charset=utf-8");

        // 1. 获取字符输出流
        PrintWriter pw = resp.getWriter();
        // 2. 输出数据
        pw.write("<h1>你好hello</h1>");
        // 浏览器打开时候 localhost/web004/responseDemo3
        // 按浏览器当前操作系统的默认字符集来解析 如果 window 则是gbk
        // PrintWriter pw = resp.getWriter(); 是 tomcat给的 tomcat的代码谁写的 ==》外国人 它们的编码 ISO-8859-1
        // 设置流的默认编码

    }
}

