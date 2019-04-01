package cn.itcast.web.servlet;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 设置编码
        req.setCharacterEncoding("utf-8");
        /*
        // 2. 获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        // 3. 封装user对象
        User loginUses = new User();
        loginUses.setUsername(username);
        loginUses.setPassword(password);
        */

        // 2. 使用BeanUtils 封装数据
        Map<String,String[]> map = req.getParameterMap();
        // 3. 创建User
        User loginUses = new User();
        try {
            // 将 map里的数据封装到 user对象里
            BeanUtils.populate(loginUses,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        // 4. 调用 UserDao的login方法
        UserDao dao = new UserDao();
        User user =dao.login(loginUses);
        // 5. 判断user是否为空
        if(user == null){
            req.getRequestDispatcher("/failServlet").forward(req,resp);
        }else{
            // 存储数据
            req.setAttribute("user",user);
            // 转发
            req.getRequestDispatcher("/successServlet").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
