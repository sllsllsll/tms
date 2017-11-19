<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Struts2文件上传页面</title>
</head>
<body>
文件是: <s:property value="uploadFileName"></s:property><br/>
文件类型：<s:property value="uploadContentType"></s:property><br/>
</body>
</html>