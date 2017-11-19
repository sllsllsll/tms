<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: linlin/
  Date: 2017/10/16
  Time: 13:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>修改页面</title>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/updates?itemid=${listone.itemid}">
    项目名称： <input name="itemname" value="${listone.itemname}"/><br/>
   所属类别: <input name="typename" value="${listone.typename}"/><br/>

    是否必查: <input name="necessary" value="${listone.necessary}"/><br/>
    <%-- <c:if test="${listone.necessary eq 1}">
    <input name="necessary" value="是"/><br/>
    </c:if>
    <c:if test="${listone.necessary eq 0}">
        <input name="necessary" value="否"/><br/>
    </c:if>--%>
    参考值:<input name="ref" value="${listone.ref}"/><br/>
    价格:<input name="price" value="${listone.price}"/><br/>
    说明:<input name="info" value="${listone.info}"/><br/>
    <br/>
    <input type="submit" value="修改"/>
</form>
</body>
</html>
