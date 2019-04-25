package cn.itcast.filter;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

// @WebFilter("/*") // 访问所有资源之前都会执行该 过滤器
/*
查看 WebFilter源码 里面有一个 urlPatterns 默认是空的

*/
// 还可以在 web.xml里配置
/*
 <filter>
        <filter-name>demo1</filter-name>
        <filter-class>cn.itcast.filter.FilterDemo1</filter-class>
    </filter>
    <filter-mapping>
        <filter-name>demo1</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>
*/
public class FilterDemo1 implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 请求之前
        // 对 request 对象请求消息的增强
        System.out.println("filterDemo1执行了");

        // 放行 filterChain.doFilter(servletRequest,servletResponse);


        // 响应之后
        // 对 response对象响应消息的增强
        System.out.println("响应回来了");
    }

    @Override
    public void destroy() {

    }
}
