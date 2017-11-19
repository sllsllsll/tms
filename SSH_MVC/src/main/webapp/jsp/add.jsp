
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>添加部门</title>
</head>
<body>
   <form method="post" action="/adds">
      部门名称： <input name="deptname"/>
       <input type="submit" value="添加"/>
   </form>
   <br/>
<table>
    <tr>
        <td>部门id</td>
        <td>部门名称</td>
        <td>操作1</td>
        <td>操作2</td>
    </tr>
   <a href="/listadd">显示列表</a>
      <c:forEach items="${listdept}" var="item">
          <tr>
           <td >${item.deptno}</td>
           <td>${item.deptname}</td>
              <td><a href="/listdel?deptno=${item.deptno}">删除</a></td>
              <td><a href="/listfind?deptno=${item.deptno}">修改</a></td>
       </tr>
   </c:forEach>

</table>
</body>
</html>
