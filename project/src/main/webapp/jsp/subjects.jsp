
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/jquery-1.8.0.min.js"></script>
    <script type="text/javascript">
        /*$(document).ready(function(){
            //查找偶数的tr不要第一行，然后改变样式
            $("tr td:even").not(":first").css("background-color","#eee");
        });*/
        /*window.onload=function() {
            var rows = document.getElementsByTagName("tr td");
            for (var i = 0; i < rows.length; i++) {
                if (i % 2 == 0 && i != 0) {
                    rows[i].style.backgroundColor = "#eee";
                }
            }
        }*/
    </script>
    <style type="text/css">
        .even { background : white;}

        .odd { background : pink;}
    </style>
</head>
<body>
<div align="center" id="stulists">
    <h1>全部主题 》》</h1>
    <table>
        <tr>
            <td align="center">序号</td>
            <td align="center">主题</td>
            <td align="center">投票/查看</td>
            <td align="center">创建时间</td>
        </tr>
        <c:forEach var="item" items="${list}"  varStatus="status">

            <c:if test="${status.index%2==1}">
                <tr class="odd"><%--奇数行--%>
                    <td>${item.id}</td>
                    <td><a href="${pageContext.request.contextPath}/getViewsubjects?id=${item.id}">${item.title}</a></td>
                    <td>${item.totalvotes}/${item.viewtimes}</td>
                    <td><fmt:formatDate value="${item.createdate}" pattern="yyyy-MM-dd"/></td>

                </tr>
            </c:if>
            <c:if test="${status.index%2==0}">
                <tr class="even"><%--偶数行--%>
                    <td>${item.id}</td>
                    <td><a href="${pageContext.request.contextPath}/getViewsubjects?id=${item.id}">${item.title}</a></td>
                    <td>${item.totalvotes}/${item.viewtimes}</td>
                    <td><fmt:formatDate value="${item.createdate}" pattern="yyyy-MM-dd"/></td>
                </tr>
            </c:if>

            <%--<tr>
                <td>${item.id}</td>
                <td><a href="">${item.title}</a></td>
                <td>${item.totalvotes}/${item.viewtimes}</td>
                <td><fmt:formatDate value="${item.createdate}" pattern="yyyy-MM-dd"/></td>
            </tr>--%>
        </c:forEach>
    </table>
</div>
</body>
</html>
