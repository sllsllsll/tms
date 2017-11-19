<%--
  Created by IntelliJ IDEA.
  User: linlin
  Date: 2017/10/9
  Time: 11:36
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java"
%>
<%@ page import="cn.happy.hibernate10opensessioninview.biz.HibernateBiz"%>
<%@ page import="cn.happy.hibernate10opensessioninview.Student" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    HibernateBiz biz=new HibernateBiz();
    Student stu=(Student) biz.get(Student.class,1);
    System.out.println(stu.getStuname());
%>
</body>
</html>
