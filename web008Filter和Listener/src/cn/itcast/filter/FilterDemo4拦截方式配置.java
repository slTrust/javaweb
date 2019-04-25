package cn.itcast.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

// 浏览器直接请求index.jsp时 被执行   默认配置
//@WebFilter(value="/index.jsp",dispatcherTypes = DispatcherType.REQUEST)

//  浏览器直接请求或者转发访问 index.jsp时 被执行
@WebFilter(value="/index.jsp",dispatcherTypes = {DispatcherType.REQUEST,DispatcherType.FORWARD})
public class FilterDemo4拦截方式配置 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("filterDemo4");
    }

    @Override
    public void destroy() {

    }
}
