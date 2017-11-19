<%--
  Created by IntelliJ IDEA.
  User: linlin
  Date: 2017/10/8
  Time: 15:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Struts2文件上传</title>
</head>
<body>
<s:form action="moreuploadtwo"  enctype="multipart/form-data" method="POST">
    <s:file name="upload" label="选择文件"/>
    <s:file name="upload" label="选择文件"/>
    <s:submit name="submit" value="文件上传"/>
</s:form>
</body>
</html>
