<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/26
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆</title>
</head>
<body>
<div>
    <form id="fm" action="${pageContext.request.contextPath}/login" method="post">
        <input id="username" name="username" type="text"><br/>
        <input id="password" name="password" type="password">
        <input type="submit" value="提交">
    </form>
</div>
</body>
</html>
