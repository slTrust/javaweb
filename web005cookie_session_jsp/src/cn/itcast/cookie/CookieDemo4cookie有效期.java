package cn.itcast.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
* Cookie 快速入门
* */
@WebServlet("/cookieDemo4")
public class CookieDemo4cookie有效期 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1 创建Cookie对象
        Cookie cookie = new Cookie("msg","hello");
        // 2 设置存活时间
        // cookie.setMaxAge(30); // 30秒后自动删除
        // cookie.setMaxAge(-1); // 负数是默认值 关闭浏览器就删除
        cookie.setMaxAge(0); // 删除 cookie
        // 3 发送 Cookie
        response.addCookie(cookie);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
