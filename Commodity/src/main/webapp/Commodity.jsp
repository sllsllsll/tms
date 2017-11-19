<%--
  Created by IntelliJ IDEA.
  User: linlin
  Date: 2017/10/17
  Time: 17:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>商品出库</title>

    <script  src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script type="text/javascript">

    function a() {


    }
    </script>

</head>
<body>
<h1>商品出库</h1>
<form method="post" action="<%=path%>/toadd">
   出库商品：<select name="productid">
        <option>----请选择出库商品----</option>
        <c:forEach items="${prolist}" var="item">
            <option value="${item.id}">${item.productname}</option>
        </c:forEach>
    </select><br/>
    <br>
    商品数量：<input  name="quantity"/><br/>
    <br>
    经 办 人： <input name="handler"/><br/>
    <br/>
    <input type="submit" value="提交"/>
</form>


</body>
</html>
