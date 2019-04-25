package cn.itcast.filter;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@WebFilter("/*") // 访问所有资源之前都会执行该 过滤器
//@WebFilter("/index.jsp") // 具体资源路径 只有访问 index.jsp时候才会拦截
//@WebFilter("/user/*") // 访问 /user/ 下所有 资源时 被执行
@WebFilter("*.jsp") // 后缀名拦截
public class FilterDemo3拦截路径 implements Filter{

    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("filterDemo3执行了");

        // 放行
        filterChain.doFilter(servletRequest,servletResponse);

        System.out.println("filterDemo3响应回来了");
    }

    public void destroy() {
        System.out.println("destroy filters");
    }
}



