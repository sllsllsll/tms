
<%--
  Created by IntelliJ IDEA.
  User: linlin
  Date: 2017/10/8
  Time: 17:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" isELIgnored="false" %>
<%--导入Struts2标签库--%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>UiTag</title>
</head>
<body>
<h2>UiTag</h2>

<s:set name="list" value="{'ACCP','Benet','XSH'}" scope="session"></s:set>
<s:set name="map" value="#{'OrginalA':'ACCP','OrginalB':'Benet','Master':'XSH'}"></s:set>
<s:property value="#map['Master']"></s:property>

<s:iterator value="#map" var="item">
    <s:property value="#item.key"/>
 <br/>
    <s:property value="#item.value"/>
</s:iterator>
---------------------------------------------------------
<s:iterator value="#session.list">
    <s:property/>
</s:iterator>


<s:debug></s:debug>
</body>
</html>
