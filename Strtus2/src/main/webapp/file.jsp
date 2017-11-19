<%--
  Created by IntelliJ IDEA.
  User: linlin
  Date: 2017/10/8
  Time: 14:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Servlet文件上传</title>
</head>
<body>
<form action="FileUpLoad" enctype="multipart/form-data" method="post">
    用户名：<input type="text" name="username"/><br/>
    上传文件1：<input type="file" name="file1"/><br/>
    上传文件2：<input type="file" name="file2"/><br/>
    <input type="submit" value="提交"/><br/>


</form>
</body>
</html>
