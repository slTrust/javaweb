package cn.itcast.filter;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*") // 访问所有资源之前都会执行该 过滤器
public class FilterDemo2生命周期 implements Filter{
    /*
    *  服务器启动后，创建 Filter对象 然后调用 init方法
    *  加载资源
    * */
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init filter");
    }

    /*
    * 每一次请求被拦截资源时，会执行
    * */
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 请求之前
        // 对 request 对象请求消息的增强
        System.out.println("filterDemo2执行了");

        // 放行
        filterChain.doFilter(servletRequest,servletResponse);

        // 响应之后
        // 对 response对象响应消息的增强
        System.out.println("filterDemo2响应回来了");
    }

    /*服务器正常关闭，创建 Filter对象 然后调用 destroy方法
    *释放资源
    * */
    public void destroy() {
        System.out.println("destroy filters");
    }
}
