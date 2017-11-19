<%--
  Created by IntelliJ IDEA.
  User: linlin
  Date: 2017/10/2
  Time: 23:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%--导入Struts2标签库--%>
<%@taglib uri="/struts-tags" prefix="s"%>

<html>
<head>
    <title>Success1</title>
</head>
<body>
<s:fielderror/>

<form action="stuAction" method="post">
   name: <input name="name"/><br/>
  age:  <input name="age"/><br/>
   date: <input name="birth"/><br/>
    <input type="submit"/>
</form>
</body>
</html>
