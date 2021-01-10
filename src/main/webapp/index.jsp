<%--
  Created by IntelliJ IDEA.
  User: lijx33137
  Date: 2020/12/21
  Time: 19:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme() + "://" + request.getServerName()+":"+request.getServerPort()
    +request.getContextPath()+"/";
%>
<html>
<head>
    <title>功能入口</title>
    <base href="<%=basePath%>"/>
</head>
<body>
    <p>一个拦截器</p>
    <form action="some.do" method="post">
        姓名：<input type="text" name="name"/><br>
        年龄：<input type="text" name="age"/><br>
        <input type="submit" value="提交请求"/>
    </form>
</body>
</html>
