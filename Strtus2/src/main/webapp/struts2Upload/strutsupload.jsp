<%@ taglib prefix="s" uri="/struts-tags" %>
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
    <title>文件上传页面显示</title>
</head>
<body>
文件是：<s:property value="uploadFileName"></s:property>
文件类型：<s:property value="uploadContentType"></s:property>

<img alt="go" src="/upload/${uploadFileName}"/>
</body>
</html>
