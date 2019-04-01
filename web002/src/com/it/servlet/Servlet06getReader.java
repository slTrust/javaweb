package com.it.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/demo06")
public class Servlet06getReader extends HttpServlet {
    // getReader 为 post才可以
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 获取字符流
        BufferedReader br = req.getReader();
        // 2. 读取数据
        String line = null;
        while( (line = br.readLine()) !=null ){
            System.out.println(line);
        }
    }
}
