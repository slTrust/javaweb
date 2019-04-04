package cn.it.web.servletcontext;

        import javax.servlet.ServletContext;
        import javax.servlet.ServletException;
        import javax.servlet.annotation.WebServlet;
        import javax.servlet.http.HttpServlet;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import java.io.IOException;

@WebServlet("/servletContextDemo3")
public class ContextDemo3域对象共享数据 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletContext context = this.getServletContext();
        // 设置数据
        context.setAttribute("msg","haha");

        // 访问 servletContextDemo3 时 设置了 域对象 msg
        // 当 访问 servletContextDemo4 时 可以获取 域对象 msg
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
