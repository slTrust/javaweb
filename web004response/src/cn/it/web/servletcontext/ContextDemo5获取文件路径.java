package cn.it.web.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/servletContextDemo5")
public class ContextDemo5获取文件路径 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletContext context = this.getServletContext();
        /*
        * src/a.txt
        * web/b.txt
        * web/WEB-INF/c.txt
        * */
        // 获取文件的服务器路径
        String realPath = context.getRealPath("/b.txt");
        // 获取 web目录下资源访问
        System.out.println(realPath); // D:\javawebDemo\web\out\artifacts\web004response_war_exploded\b.txt

        // 获取WEB-INF 下资源
        String realPath2 = context.getRealPath("/WEB-INF/c.txt"); // WEB-INF目录下的资源访问
        System.out.println(realPath2);

        // 获取 src目录下资源
        // 还可以通过 classLoader获取 但是只能获取  src下的真实目录 无法获取web目录下的资源
        String realPath3 = context.getRealPath("/WEB-INF/classes/a.txt");
        System.out.println(realPath3);


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}


