package cn.it.web.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/checkCodeServlet")
public class CheckCodeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int width = 100;
        int height = 50;
        //1. 内存里创建一个图片
        BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);

        //2. 美化图片
        Graphics g = image.getGraphics();// 画笔对象
        g.setColor(Color.PINK); // 画笔颜色设置
        g.fillRect(0,0,width,height);
        // 画边框
        g.setColor(Color.BLUE);
        g.drawRect(0,0,width-1,height-1);

        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        // 生成随机角标
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            int index = random.nextInt(str.length());
            // 获取字符
            char ch = str.charAt(index); //随机字符
            // 写验证码
            g.drawString(ch+"",width/5*i,height/2);
        }

        // 干扰线
        g.setColor(Color.GREEN);
        for (int i = 0; i < 10 ; i++) {
            int x1 = random.nextInt(width);
            int y1 = random.nextInt(height);
            int x2 = random.nextInt(width);
            int y2 = random.nextInt(height);

            g.drawLine(x1,y1,x2,y2);
        }

        //3. 将图片输出到页面展示
        ImageIO.write(image,"jpg",resp.getOutputStream());
    }
}
