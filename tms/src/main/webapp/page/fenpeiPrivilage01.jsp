<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户管理</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/icon.css">
	<script src="http://echarts.baidu.com/build/dist/echarts.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jQuery1.11.1.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jQuery1.11.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
    function formatAction(value,row) {
		return  "<a href='javascript:yhli("+row.userid+")'>分配权限</a>"
    }

    function yhli(id) {

        $.ajax({
            url:"${pageContext.request.contextPath}/selectallprivilage",
            type:"post",
            dataType:"JSON",
            success:function (data) {
                if($("#fm ul").length>0){
                    $("#fm").html(null);
                }
                var html="";
                html+="<ul>";
                $.each(data,function (i, dom) {

                    html+="<li>"+dom.name+"<input type='checkbox'/></li>";
                    $.each(dom.chirdern,function (i,item) {
                        html+="<ul><li>"+item.name+"<input type='checkbox'/></li></ul>";
                    });

                });
                html+="</ul>";
                $("#fm").append(html);
            }
        });
        $("#dlg").dialog("open");

    }
</script>
</head>
<body style="margin: 1px">

<table id="dg" title="用户管理" class="easyui-datagrid"
	   fitColumns="true" pagination="true" rownumbers="true"
	   url="${pageContext.request.contextPath}/selectallrole" fit="true" toolbar="#tb">
	<thead id="ths">

	<tr>
		<th field="cb" checkbox="true" align="center"></th>
		<th field="id" width="20" align="center">角色编码</th>
		<th field="rolename" width="80" align="center">角色名</th>
		<th field="action" width="80" align="center" formatter="formatAction">操作</th>
	</tr>
	</thead>
	<div>
		<a href="javascript:openUserAddDiglog()" class="easyui-linkbutton" iconCls="icon-add" plain="true">添加</a>
		<a href="javascript:openUserModifyDiglog()" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a>
		<a href="javascript:deleteUser()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
	</div>
</table>

<%--
<div id="tb">


</div>

<div id="dlg" class="easyui-dialog" style="width: 620px;height: 250px;padding: 10px 20px" closed="true" buttons="#dlg 2uttons">

 	<form id="fm" method="post">
 		<table cellpadding="8px">
 			<tr>
 				<td>用户名：</td>
 				<td>
 					<input type="text" id="id" name="id" class="easyui-validatebox" required="true"/>
 				</td>
 				<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
 				<td>密码：</td>
 				<td>
 					<input type="text" id="password" name="password" class="easyui-validatebox" required="true"/>
 				</td>
 			</tr>
 			<tr>
 				<td>姓：</td>
 				<td>
 					<input type="text" id="firstName" name="firstName" class="easyui-validatebox" required="true"/>
 				</td>
 				<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
 				<td>名：</td>
 				<td>
 					<input type="text" id="lastName" name="lastName" class="easyui-validatebox" required="true"/>
 				</td>
 			</tr>
 			<tr>
 				<td>邮箱：</td>
 				<td colspan="4">
 					<input type="text" style="width: 200px" id="email" name="email" class="easyui-validatebox" validType="email" required="true"/>
 					<input type="hidden" id="flag" name="flag"/>
 				</td>
 			</tr>
 		</table>
 	</form>

</div>

<div id="dlg-buttons">
	<a href="javascript:checkData()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
	<a href="javascript:closeUserDialog()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
</div>--%>
<h2>设置教员所在班级</h2>
<div style="margin:20px 0"></div>

<%--<div id="yhgl" class="easyui-tabs" style="width: 400px;height: 250px;padding: 10px 20px" closed="true" buttons="#dlg-buttons">
	<table cellpadding="8px">
		<tr>
			<td>用户名</td>
			<td>分配权限</td>
		</tr>
		<tr>
            <tbody id="list-content"></tbody>
		</tr>
	</table>
</div>--%>
<div id="dlg" class="easyui-dialog" style="width: 400px;height: 250px;padding: 10px 20px" closed="true" buttons="#dlg-buttons">

    <form id="fm" method="post">

    </form>

</div>
</body>
</html>