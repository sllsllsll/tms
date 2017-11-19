<%--
  Created by IntelliJ IDEA.
  User: linlin
  Date: 2017/10/10
  Time: 19:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" isELIgnored="false" %>
<%--导入Struts2标签库--%>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
    <title>SSH整合</title>
</head>
<body>
<h1>SSH第一次整合</h1>
<form action="addStockAction" method="post" >
 名字 <input name="sname"/><br/>
 股数   <input name="scount"/><br/>
<input type="submit" value="提交"/>
</form>
<br/>
<table>
    <tr>
        <td>sid</td>
        <td>sname</td>
        <td>count</td>
        <td>操作1</td>
        <td>操作2</td>
    </tr>
    <a href="ListStockAction">显示列表</a>
    <c:forEach items="${list}" var="item">
        <tr>
            <td >${item.sid}</td>
            <td>${item.sname}</td>
            <td>${item.count}</td>
            <td><a href="/listdel?deptno=${item.deptno}">删除</a></td>
            <td><a href="/listfind?deptno=${item.deptno}">修改</a></td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
