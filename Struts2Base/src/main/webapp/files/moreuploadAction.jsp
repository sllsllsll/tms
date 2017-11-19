<%--
  Created by IntelliJ IDEA.
  User: linlin
  Date: 2017/11/5
  Time: 16:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<s:form action="moreuploadAction" enctype="multipart/form-data" method="post">
    <s:file name="upload" label="选择文件"/><br/>
    <s:file name="upload" label="选择文件"/><br/>
    <s:submit name="submit" value="文件上传"/>
</s:form>
</body>
</html>
