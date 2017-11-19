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
    <title>显示所有的城区</title>
    <script  src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script type="text/javascript">

        window.onload=function showtable(){
            var tablename=document.getElementById("mytable");
            var li=tablename.getElementsByTagName("tr");
            for (var i=0;i<=li.length;i++){
                if (i%2==0){
                    li[i].style.backgroundColor="pink";
                }else li[i].style.backgroundColor="#FFFFFF";
            }
        }
    </script>

</head>
<body>

<h1>体检系统</h1>

<form method="post" action="<%=path%>/Peitem">

  <%--  <select name="itemnamess">
        <c:forEach items="${list1}" var="item">
        <option value="${item.typeid}">${item.typename}</option>
        </c:forEach>
    </select>--%>
      <select name="itemnamess">
          <c:forEach items="${list13}" var="item">
              <option>${item.typename}</option>
          </c:forEach>
      </select>
    <input type="submit"/>
</form>

<table id="mytable">
    <tr>
        <td>项目名称</td>
        <td>所属类别</td>
        <td>是否必查</td>
        <td>参考值</td>
        <td>价格</td>
        <td>说明</td>
        <td>操作</td>

    </tr>
    <c:forEach items="${list2}" var="item">
        <tr>
            <td >${item.itemname}</td>
            <td>${item.typename}</td>
            <c:if test="${item.necessary eq 1}">
               <td>是</td>
            </c:if>
            <c:if test="${item.necessary eq 0}">
                <td>否</td>
            </c:if>
            <td>${item.ref}</td>
            <td>${item.price}</td>
            <td>${item.info}</td>
            <td><a href="listfindBy?itemid=${item.itemid}">修改</a></td>
        </tr>
    </c:forEach>

</table>













</body>
</html>
