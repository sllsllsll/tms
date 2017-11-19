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
    <title>Success2</title>
</head>
<body>

<s:property value="name"/>
<s:property value="age"/>
<s:date name="birth"/>
</body>
</html>
