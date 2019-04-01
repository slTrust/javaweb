package cn.it.web.servlet;

        import javax.servlet.ServletException;
        import javax.servlet.ServletOutputStream;
        import javax.servlet.annotation.WebServlet;
        import javax.servlet.http.HttpServlet;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import java.io.IOException;
        import java.io.PrintWriter;

@WebServlet("/responseDemo4")
public class ResponseDemo4字节流与编码设置 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=utf-8");
        // 1. 获取字节输出流
        ServletOutputStream sos = resp.getOutputStream();
        // 2. 输出数据 中文也会牵扯到字符集问题
        sos.write("<h1>你好hello</h1>".getBytes("utf-8"));
        // sos.write("<h1>你好hello</h1>".getBytes("GBK")); // 乱码


    }
}

