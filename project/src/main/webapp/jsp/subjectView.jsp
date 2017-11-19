
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div align="center" id="stulists">
   <%-- <h1>全部主题 》》</h1>
    <table>
        <tr>
            <td align="center">序号</td>
            <td align="center">主题</td>
            <td align="center">投票/查看</td>
            <td align="center">创建时间</td>
        </tr>
        <c:forEach var="item" items="${list}"  varStatus="status">
            <tr>
                <td>${item.id}</td>
                <td><a href="">${item.title}</a></td>
                <td>${item.totalvotes}/${item.viewtimes}</td>
                <td><fmt:formatDate value="${item.createdate}" pattern="yyyy-MM-dd"/></td>
            </tr>
        </c:forEach>
    </table>--%>
           <h1>${subject.title}</h1>
           <h1>${subject.viewtimes}次查看,共有${subject.totalvotes}人投票</h1>

       <form action="${pageContext.request.contextPath}/updateOption" method="post">
           <table border="1px">
               <c:forEach var="item" items="${subject.options }">
                   <tr>
                       <td><input type="radio" name="subId" value="${item.id }">${item.optcontent }     ${item.vote }票  ${item.vote/subject.totalvotes*100 }%</td>
                   </tr>

               </c:forEach>
               <tr>
                   <td><input type="hidden" name="id" value="${subject.id }"></td>
               </tr>

           </table>
           <a href=""><input type="submit" value="我要投票"></a><a href="${pageContext.request.contextPath}/getAllsubjects">返回首页</a>
       </form>
</div>
</body>
</html>
