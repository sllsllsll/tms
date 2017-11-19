<%--
  Created by IntelliJ IDEA.
  User: linlin
  Date: 2017/10/17
  Time: 17:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>显示所有的城区</title>
</head>
<body>
<table>
    <tr>
        <td>城区id</td>
        <td>城区名称</td>
    </tr>
    <c:forEach items="${list}" var="item">
        <tr>
            <td >${item.id}</td>
            <td>${item.name}</td>
        </tr>
    </c:forEach>
</table>

<form method="post" action="<%=path%>/listByName">
    <input  name="name"/>
    <input type="submit" value="提交"/>
</form>

<table>
    <tr>
        <td>城区名称</td>
    </tr>
    <c:forEach items="${listByName}" var="item">
        <tr>
            <td>${item.name}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
