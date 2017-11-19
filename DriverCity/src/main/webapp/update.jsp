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
<form method="post" action="${pageContext.request.contextPath}/updates?id=${listone.id}">
    部门名称： <input name="name" value="${listone.name}"/>
    <input name="cityAreaId" value="${listone.cityAreaId}"/>
    <input name="address" value="${listone.address}"/>
    <input name="phone" value="${listone.phone}"/>
    <br/>
    <input type="submit" value="修改"/>
</form>
</body>
</html>
