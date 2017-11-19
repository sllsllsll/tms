<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: linlin
  Date: 2017/10/22
  Time: 9:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<s:form action="UserAction" method="post">
    <s:textfield name="user.name" ></s:textfield>
    <s:textfield name="user.pwd" ></s:textfield>
    <s:submit value="提交"/>
</s:form>
</body>
</html>
