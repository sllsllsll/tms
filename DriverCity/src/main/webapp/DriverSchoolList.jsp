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
        <td>驾校id</td>
        <td>驾校名称</td>
        <td>城区id</td>
        <td>驾校地址</td>
        <td>驾校电话</td>
        <td>操作</td>

    </tr>
    <c:forEach items="${listDr}" var="item">
        <tr>
            <td >${item.id}</td>
            <td>${item.name}</td>
            <td>${item.cityAreaId}</td>
            <td>${item.address}</td>
            <td>${item.phone}</td>
            <td><a href="listfindBy?id=${item.id}">修改</a></td>
        </tr>
    </c:forEach>

</table>
<form method="post" action="/listfind">
    <input name="id"/>
    <input type="submit"/>
</form>

<a>${listone.name}</a>
</body>
</html>
