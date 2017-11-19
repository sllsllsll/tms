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
<%--<form action="addStock" method="post" >
 名字 <input name="sname"/><br/>
 股数   <input name="scount"/><br/>
<input type="submit" value="提交"/>
</form>--%>

<s:form action="addStock" method="post" namespace="/" theme="simple">
 名字 <s:textfield name="sname"/><br/>
 股数   <s:textfield name="scount"/><br/>
    <s:submit  value="提交"/>

</s:form>
<s:form action="delStock" method="post" namespace="/" theme="simple">
    <s:submit  value="删除"/>
</s:form>

</body>
</html>
