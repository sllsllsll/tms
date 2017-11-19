<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: linlin
  Date: 2017/10/8
  Time: 18:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>url</title>
    <script>
        var html="alert('ok');";
        eval(html);

    </script>
</head>
<body>
<s:set name="mypath" value="'http://s.bdqn.cn/index.shtml'"></s:set>
<s:url value="%{#mypath}"/>

<s:debug></s:debug>
</body>
</html>
