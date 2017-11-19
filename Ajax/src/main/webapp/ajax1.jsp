<%--
  Created by IntelliJ IDEA.
  User: linlin
  Date: 2017/10/13
  Time: 19:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%--导入Struts2标签库--%>
<%@taglib uri="/struts-tags" prefix="s"%><html>
<head>
    <title>Title</title>
    <script type="text/javascript">
function checkUser() {
    var values=document.getElementById("username").value;
    var url="AjaxServlet";
    var xhr;//能力检测
    if(window.XMLHttpRequest){
        //非IE
        xhr=new XMLHttpRequest();
    }else{
        //IE
        xhr=new ActiveXObject("Microsoft.XMLHTTP");
    }
    //建立请求
    xhr.open("get",url,true);
    xhr.onreadystatechange=function () {
        if(xhr.readyState==4&&xhr.status==200){
            //客户端成功接收数据Date
var content=xhr.responseText;
document.getElementById("msg").innerText=content;
        }
    }
    xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    xhr.send("name="+values);
}

    </script>
</head>
<body>
<input id="username" name="username" onblur="checkUser()"/>
<span id="msg"></span>
<input name="userpwd"/>
</body>
</html>
