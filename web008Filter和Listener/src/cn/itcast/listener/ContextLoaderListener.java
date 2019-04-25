package cn.itcast.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/*
* 在 web.xml里配置
* */

// 还可以注解配置
//@WebListener
public class ContextLoaderListener implements ServletContextListener{
    /*
    * 监听 ServeltContext对象 创建的。 ServletContext 对象服务器启动后自动创建
    * 服务器启动后自动调用
    * */
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        // 加载资源文件
        //1 获取 servletContext 对象
        ServletContext servletContex = servletContextEvent.getServletContext();
        //2 加载资源文件  这个 key 就是 定义在web.xml里的 context-param
        String contextConfigLocation = servletContex.getInitParameter("contextConfigLocation");
        //3 获取真实路径
        String realPath = servletContex.getRealPath(contextConfigLocation);

        // 4 加载进内存
        try {
            FileInputStream fis = new FileInputStream(realPath);
            System.out.println(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("ServletContext对象被创建了");
    }

    /*
    * 在服务器正常关闭后自动调用
    *  ServeltContext对象 被销毁。
    * */
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

        System.out.println("ServletContext对象被销毁了");
    }
}
