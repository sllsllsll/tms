<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: linlin
  Date: 2017/10/14
  Time: 16:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>国际化</title>
</head>
<body>
<s:fielderror/>
<form action="LoginAction" method="post">
    <table>
        <tr>
            <td><s:text name="name"/></td>
            <td><input name="uname"/></td>
        </tr>
        <tr>
            <td><s:text name="pwd"/></td>
            <td><input name="upwd"/></td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="提交">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
