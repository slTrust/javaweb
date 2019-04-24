package cn.itcast.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
* 假设在一个tomcat服务器中，部署了多个web项目，那么在这些web项目中cookie能不能共享？
    * 默认情况下cookie不能共享
    * setPath(String path):设置cookie的获取范围。默认情况下，设置当前的虚拟目录
        * 如果要共享，则可以将path设置为"/"
*
* 假设我们有两个 javaweb项目 也就是 两个虚拟目录
* 如 /aaa 和 /bbb
*
* */
@WebServlet("/cookieDemo6")
public class CookieDemo6cookie同服务器下共享 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie = new Cookie("msg","你好");
        // cookie.setPath("/web004"); 默认设置为 当前web项目的虚拟目录

        // 让当前服务器下部署的所有项目 共享 cookie信息
        cookie.setPath("/"); // 设置当前cookie的范围为 当前服务器的根路径下面
        // 那么 tomcat下 如果有 /web001  和 /web004 的虚拟目录项目
        // 如果 cookie.setPath("/") 设置为根路径
        // 那么 假设 /web004 设置了 cookie
        // /web001也可以访问到 cookie
        response.addCookie(cookie);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}