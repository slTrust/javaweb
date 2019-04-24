package cn.itcast.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
* 不同的tomcat服务器间cookie共享问题？
    * setDomain(String path):如果设置一级域名相同，那么多个服务器之间cookie可以共享
        * setDomain(".baidu.com"),那么tieba.baidu.com和news.baidu.com中cookie可以共享
*/
@WebServlet("/cookieDemo7")
public class CookieDemo7cookie不同服务器器共享 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie = new Cookie("msg","你好");

        // 不同服务器 cookie 的共享 设置它们的一级域名 ，那么就可以实现共享
        /*
        * 如 tieba.baidu.com 和 news.baidu.com 中 cookie可以共享
        * */
        cookie.setDomain(".baidu.com");
        response.addCookie(cookie);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
