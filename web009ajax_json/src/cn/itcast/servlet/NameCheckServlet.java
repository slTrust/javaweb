package cn.itcast.servlet;


import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/nameCheck")
public class NameCheckServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1 获取用户名
        String username = req.getParameter("username");

        // 2 调用service 判断用户名是否存在
        // 服务器返回 json数据
        /*
        *  {"userExsit":true,"msg":"用户名已存在"}
        *  {"userExsit":false,"msg":"用户名可用"}
        * */
        // 设置响应的数据格式为 josn 字符编码为 utf-8
        resp.setContentType("application/json;charset=utf-8");
        Map<String,Object> map = new HashMap<>();
        if("tom".equals(username)){
            // 存在
            map.put("userExsit",true);
            map.put("msg","用户名已存在");
        }else{
            map.put("userExsit",false);
            map.put("msg","用户名可用");
        }

        // 将 map转换为 json
        ObjectMapper mapper = new ObjectMapper();
        // 将数据传递给客户端
        mapper.writeValue(resp.getWriter(),map);
    }
}
