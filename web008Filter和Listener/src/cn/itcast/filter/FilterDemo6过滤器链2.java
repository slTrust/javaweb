package cn.itcast.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*")
public class FilterDemo6过滤器链2 implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("filterDemo6执行了");
        // 放行
        filterChain.doFilter(servletRequest,servletResponse);

        // 响应之后
        System.out.println("filterDemo6响应回来了");
    }

    @Override
    public void destroy() {

    }
}
