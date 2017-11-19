<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<h2>登录</h2>
<s:form method="POST" action="login">
    请输入用户名： <s:textfield  name="user.username"></s:textfield> <br/>
    <s:textfield name="user.password"></s:textfield><br/>
    <s:submit value="登陆"></s:submit>
</s:form>
</body>
</html>
