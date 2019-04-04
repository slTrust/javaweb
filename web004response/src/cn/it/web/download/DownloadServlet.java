package cn.it.web.download;

import cn.it.web.utils.DownLoadUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/downloadServlet")
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1 获取文件名称
        String filename =  req.getParameter("filename");
        // 2 字节输入流加载文件进内存
        // 2.1 找到文件服务器路径
        ServletContext context = this.getServletContext();
        String realPath = context.getRealPath("/img/" + filename);
        // 2.2 字节流关联
        FileInputStream fis = new FileInputStream(realPath);


        // 解决中文文件名乱码问题
        // 3.3 获取user-agent头
        String agent = req.getHeader("user-agent");
        // 3.4 使用工具类方法编码文件名即可
        filename = DownLoadUtils.getFileName(agent,filename);

        // 3 设置response的响应头
        //3.1 响应头类型 content-type
        String mimeType = context.getMimeType(filename);
        resp.setHeader("content-type",mimeType);
        //3.2响应头打开方式 content-disposition
        resp.setHeader("content-disposition","attachment;filename=" + filename);



        // 4 将输入流数据写出到输出流
        ServletOutputStream sos = resp.getOutputStream();
        byte[] buff = new byte[1024 * 8]; // 字节数组缓冲区
        int len = 0;
        while((len = fis.read(buff))!= -1){
            sos.write(buff,0,len);
        }

        fis.close();

    }
}
