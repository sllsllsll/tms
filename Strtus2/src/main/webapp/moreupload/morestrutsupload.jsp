<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: linlin
  Date: 2017/10/8
  Time: 15:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>多文件上传页面显示</title>
</head>
<body>
<s:iterator value="uploadFileName" var="file">
文件：<s:property value="file"></s:property>
</s:iterator>

<s:iterator value="uploadContentType" var="type">
    文件类型：<s:property value="type"></s:property>
</s:iterator>
<c:forEach var="item" items="${uploadFileName}">
    <img alt="go" src="upload/${item}"/>
</c:forEach>

<s:iterator var="filename" value="uploadFileName">
    <img alt="go" src="upload/<s:property value="filename"/>
</s:iterator>
</body>
</html>
