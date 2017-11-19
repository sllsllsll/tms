
<%--
  Created by IntelliJ IDEA.
  User: linlin
  Date: 2017/10/21
  Time: 21:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
    <title>HelloWorld</title>
</head>
<body>
<h1>HelloWorld!!</h1>
<hr/>
<h1><s:property value="message"/> </h1>

<hr/>

<form action="he" method="post">
    <input name="name" type="text"/>
    <input type="submit"/>
</form>
</body>
</html>
