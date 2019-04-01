package com.it.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

/*
在 get  tomcat8 已将get方式乱码问题解决了
在 post 会乱码 如中文数据
    解决 request.setCharacterEncoding
*/
@WebServlet("/demo08")
public class Servlet08charset extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        onSubmit(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        onSubmit(req,resp);
    }

    void onSubmit(HttpServletRequest req, HttpServletResponse resp){
        // name=123
        // 获取指定的参数值
        String name = req.getParameter("name");
        System.out.println("name:"+ name);
        // ?hobby=xx&&hobby=yy
        // 获取复选框这类值的参数值 是一个数组
        String[] hobbys = req.getParameterValues("hobby");
        for (String hobby: hobbys) {
            System.out.println(hobby);
        }
        // 获取所有的请求参数名称
        Enumeration<String> parameterNames = req.getParameterNames();
        while(parameterNames.hasMoreElements()){
            String name2 = parameterNames.nextElement();
            System.out.println("-----------");
            System.out.println(name2);
            String value = req.getParameter(name2);
            System.out.println(value);
            System.out.println("-----------");
        }


        // 获取所有请求参数  k/v形式
        Map<String,String[]> parameterMap = req.getParameterMap();
        // 遍历
        Set<String> keyset = parameterMap.keySet();
        for (String name3:keyset) {
            String[] values = parameterMap.get(name3);
            System.out.println("map-------------name");
            System.out.println(name3);
            for (String value3:values) {
                System.out.println(value3);
            }
        }
    }
}
