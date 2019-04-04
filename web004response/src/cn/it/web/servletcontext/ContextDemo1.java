package cn.it.web.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/servletContextDemo1")
public class ContextDemo1 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // servletContext 获取
        /*
        1. 通过 request
        req.getServletContext();
        2. 通过HttpServlet
        this.getServletContext()
        */

        // 1. request获取
        ServletContext context1 = req.getServletContext();
        // 2. 通过HttpServlet 获取
        ServletContext context2 = this.getServletContext();

        System.out.println( context1 == context2);  // true

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
