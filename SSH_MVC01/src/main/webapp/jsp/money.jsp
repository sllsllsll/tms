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
<h1>转账操作</h1>
<form action="/update" method="post">
    转入账户：<input name="account_number"/>
    转入 金额：<input name="balance"/>
<input type="submit" value="确认转账"/>
</form>
</body>
</html>
