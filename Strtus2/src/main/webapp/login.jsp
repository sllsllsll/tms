<%--
  Created by IntelliJ IDEA.
  User: linlin
  Date: 2017/10/2
  Time: 12:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%--导入Struts2标签库--%>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
    <title>HelloWorld</title>
</head>
<body>
<h1>用户登录</h1>
<hr/>
<%--<div>
    <form action="login" method="post"></br>

       用户名： <input name="uname"/></br>
        密码：<input name="password"/></br>
        <input type="submit" value="提交"/>
    </form>
</div>--%>
<div>
    <s:fielderror/><%--输出校验信息--%>
</div>
<s:form action="login">
       <s:textfield name="uname"/>
    </br>
    <s:password name="password"/>
    </br>
    <s:submit value="登录"/>
    </br>
</s:form>
</body>
</html>
