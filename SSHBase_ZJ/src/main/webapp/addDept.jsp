<%--
  Created by IntelliJ IDEA.
  User: linlin
  Date: 2017/10/10
  Time: 19:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" isELIgnored="false" %>
<%--导入Struts2标签库--%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>SSH整合</title>
</head>
<body>
<h1>SSH第一次整合</h1>
<form action="/add" method="post">
    名字 :<input name="dept.deptname"/><br/>
    <input type="submit" value="提交"/>
</form>
<br/>

<table>
    <tr>
        <td>id</td>
        <td>部门名称</td>
    </tr>
    <c:forEach items="${Deptlist}" var="item">
    <tr>
      <td>${item.deptno}</td>
        <td>${item.deptname}</td>
    </tr>
    </c:forEach>
</table>

<a href="/del?deptno=16">删除</a>
</body>
</html>
