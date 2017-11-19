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



<%--
<table>
    <tr>
        <td>id</td>
        <td>部门名称</td>
    </tr>
    <c:forEach items="${delist}" var="item">
        <tr>
            <td>${item.deptno}</td>
            <td>${item.deptname}</td>
        </tr>
    </c:forEach>
</table>
--%>


<table>
    <tr>

        <td>部门名称</td>
    </tr>

        <tr>
         <td>
<s:property value="depts"></s:property>
             <s:iterator value="#depts">
                 <s:property value=""></s:property>
             </s:iterator></td>

        </tr>

</table>
</body>
</html>
