<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: linlin/
  Date: 2017/10/16
  Time: 13:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>修改页面</title>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/updates?deptno=${listone.deptno}">
    部门名称： <input name="deptname" value="${listone.deptname}"/>
    <br/>
    <input type="submit" value="修改"/>
</form>
</body>
</html>
