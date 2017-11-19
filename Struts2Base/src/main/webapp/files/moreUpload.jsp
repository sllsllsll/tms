<%--
  Created by IntelliJ IDEA.
  User: linlin
  Date: 2017/11/5
  Time: 16:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<s:iterator value="uploadFileName">
    文件:<s:property/> <br/>
</s:iterator>
<s:iterator value="uploadContentType">
    文件类型:<s:property/> <br/>
</s:iterator>
</body>
</html>
