<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: linlin
  Date: 2017/10/22
  Time: 9:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>OGNL</title>
</head>
<body>
<h1>OGNL</h1>
<h1><s:property value="info"></s:property> </h1>

<%--<s:property value="#list"></s:property>
<s:iterator value="#list">
<s:property></s:property>
</s:iterator>--%>


<s:property value="#request.request"></s:property>
<s:debug></s:debug>

</body>
</html>
