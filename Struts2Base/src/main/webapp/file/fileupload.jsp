<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Struts2文件上传</title>
</head>
<body>
<s:form action="uploadAction" enctype="multipart/form-data" method="post">
    <s:file name="upload" label="选择文件"/><br/>
    <s:submit name="submit" value="文件上传"/>
</s:form>
</body>
</html>
