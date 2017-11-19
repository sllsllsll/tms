<%--
  Created by IntelliJ IDEA.
  User: linlin
  Date: 2017/10/13
  Time: 11:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>系统登录</title>
</head>
<body>
<h1>系统登录</h1>
<form action="/welcome" method="post">
    账号：<input name="account_number"/><br/>
    密码：<input name="password"/><br/>
<input type="submit" value="提交 "/>
</form>
</body>
</html>
