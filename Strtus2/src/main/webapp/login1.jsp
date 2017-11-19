<%--
  Created by IntelliJ IDEA.
  User: linlin
  Date: 2017/10/2
  Time: 23:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" isELIgnored="false" %>
<%--导入Struts2标签库--%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Struts</title>
</head>
<body>

<h2>login1.jsp</h2>
<s:property value="info.uname"/><hr/>
<s:property value="addresss.street"/>
<s:iterator value="list">
    <s:property value="uname"></s:property>
</s:iterator>
<hr/>
<c:forEach items="${list}" var="item">
    ${item.uname}
</c:forEach>
--------------------------------------------
<s:iterator value="list">
    <s:property value="uname"></s:property>
</s:iterator>
------------
****************************************************
<s:property value="mydate"/>
<s:date name="mydate" format="yyyy年MM月dd日"/>
<s:debug></s:debug>
</body>
</html>
