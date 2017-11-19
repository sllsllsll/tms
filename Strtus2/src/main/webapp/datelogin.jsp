<%--
  Created by IntelliJ IDEA.
  User: linlin
  Date: 2017/10/13
  Time: 19:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%--导入Struts2标签库--%>
<%@taglib uri="/struts-tags" prefix="s"%><html>
<head>
    <title>Title</title>
</head>
<body>
<s:form action="regist" method="post" validate="true">
   <s:textfield name="users.uname" label="用户名"></s:textfield>
    <s:password  name="users.upwd" label="密码"></s:password>
    <s:submit value="注册"></s:submit>
</s:form>
</body>
</html>
