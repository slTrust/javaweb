<%--
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <%
    // servlet 里的 service方法
    /*
    * 三个内置对象
    * request
    * response
    * out:可以将数据输出到页面上（字符输出流） 和 request.getWriter() 类似
    *   out.write()和 response.getWrite()的区别
    * */
  %>
  <%-- response.getWriter() 会优先于 out.write()输出到页面
    当我们请求jsp页面的时候， jsp里面有两个输出流 response.getWriter 和 out.write 它们都有各自的缓冲区
    当tomcat给客户端做出响应的之前 tomcat 会去先找 response缓冲区 然后再去找 out的缓冲区
    所以
    response.getWriter()永远在 out.write()之前

    结论 尽量使用 out.write 来输出内容
  --%>
  <% response.getWriter().write("response.getWriter"); %>
  <% out.write("out.write()");%>
  <%
    System.out.println("hello.jsp");
    int i = 5;
  %>
  <%!
    int i = 3; // 类的成员变量，会存在线程安全问题
  %>

  <%-- 输出语句 --%>
  <%=
    "HELLO"
  %>

  <h1>h1~ jsp!</h1>
  </body>
</html>
