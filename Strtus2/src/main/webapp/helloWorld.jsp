<%--
  Created by IntelliJ IDEA.
  User: linlin
  Date: 2017/10/2
  Time: 12:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%--导入Struts2标签库--%>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
    <title>HelloWorld</title>
</head>
<body>
<div>
    <h1>
Struts2的第一个入门案例

    </h1>
    <h1>

        <%--显示Struts2 Action 中message的属性内容--%>
        <s:property value="message"/>
    </h1>

</div>
<hr/>
<div>
    <form action="helloWorld" method="post">
        请输入你的姓名：
        <input name="uname"/>
        <input type="submit" value="提交"/>
    </form>
</div>

</body>
</html>
