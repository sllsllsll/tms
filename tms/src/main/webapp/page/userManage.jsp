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
    $(function () {

    });
   function jifang() {
       //echarts写的快状图
       require.config({
           paths : {
               echarts :'http://echarts.baidu.com/build/dist'
           }
       });
       // 使用
       require([ 'echarts', 'echarts/chart/treemap' // 使用柱状图就加载bar模块，按需加载
       ], drewEcharts);
       function drewEcharts(ec) {
           var myCheck = ec.init(document.getElementById("main"));

           myCheck.on('click', function (param){
               var name=param.name;
               if(name=="四机房"){
                   $("#dlg").dialog("open").dialog("setTitle","修改密码");
               }else if(name=="五机房"){
                   $("#dlg").dialog("open").dialog("setTitle","修改密码");
               }else if(name=="六机房"){
                   $("#dlg").dialog("open").dialog("setTitle","修改密码");
               }else if(name=="七机房"){
                   $("#dlg").dialog("open").dialog("setTitle","修改密码");
               }else if(name=="二楼三教室"){
                   $("#dlg").dialog("open").dialog("setTitle","修改密码");
               }else if(name=="二楼四教室"){
                   $("#dlg").dialog("open").dialog("setTitle","修改密码");
               }
           });


           option = {
               tooltip : {
                   trigger: 'item',
                   formatter: "{b}: {c}"
               },
			   /* toolbox: {
				show : true,
				feature : {
				mark : {show: true},
				dataView : {show: true, readOnly: false},
				restore : {show: true},
				saveAsImage : {show: true}
				}
				},*/
               calculable : false,
               series : [
                   {
                       type:'treemap',
                       itemStyle: {
                           normal: {
                               label: {
                                   show: true,
                                   formatter: "{b}"
                               },
                               borderWidth: 1,
                               borderColor: '#ccc'
                           },
                           emphasis: {
                               label: {
                                   show: true
                               },
                               color: '#cc99cc',
                               borderWidth: 3,
                               borderColor: '#996699'
                           }
                       },
                       data:[
                           {
                               name: '四机房',
                               itemStyle: {
                                   normal: {
                                       color: '#99ccff',
                                   }
                               },
                               value: 5
                           },
                           {
                               name: '五机房',
                               itemStyle: {
                                   normal: {
                                       color: '#99ccff',
                                   }
                               },
                               value:5
                           },
                           {
                               name: '六机房',
                               itemStyle: {
                                   normal: {
                                       color: '#99ccff',
                                   }
                               },
                               value: 5
                           }
                           ,
                           {
                               name: '七机房',
                               itemStyle: {
                                   normal: {
                                       color: '#99ccff',
                                   }
                               },
                               value:5

                           },
                           {
                               name: '二楼三教室',
                               itemStyle: {
                                   normal: {
                                       color: '#99ccff',
                                   }
                               },
                               value:5
                           },
                           {
                               name: '二楼四教室',
                               itemStyle: {
                                   normal: {
                                       color: '#99ccff',
                                   }
                               },
                               value: 5
                           }
                       ]
                   }
               ]
           };

           myCheck.setOption(option);
       };
   }

</script>
</head>
<body style="margin: 1px">
<%--<table id="dg" title="用户管理" class="easyui-datagrid"
  fitColumns="true" pagination="true" rownumbers="true"
  url="${pageContext.request.contextPath}/user/userPage.action" fit="true" toolbar="#tb">
 <thead>
 	<tr>
 		<th field="cb" checkbox="true" align="center"></th>
 		<th field="id" width="80" align="center">用户名</th>
 		<th field="password" width="80" align="center">密码</th>
 		<th field="firstName" width="50" align="center">姓</th>
 		<th field="lastName" width="50" align="center">名</th>
 		<th field="email" width="100" align="center">邮箱</th>
 	</tr>
 </thead>
</table>
<div id="tb">
 <div>
	<a href="javascript:openUserAddDiglog()" class="easyui-linkbutton" iconCls="icon-add" plain="true">添加</a>
	<a href="javascript:openUserModifyDiglog()" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a>
	<a href="javascript:deleteUser()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
 </div>
 <div>
 	&nbsp;用户名&nbsp;<input type="text" id="s_id" size="20" onkeydown="if(event.keyCode==13) searchUser()"/>
 	<a href="javascript:searchUser()" class="easyui-linkbutton" iconCls="icon-search" plain="true">搜索</a>
 </div>
</div>

<div id="dlg" class="easyui-dialog" style="width: 620px;height: 250px;padding: 10px 20px" closed="true" buttons="#dlg-buttons">
 
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

<input  id="groupId" name="groupId" class="easyui-combobox" data-options="panelHeight:'auto',valueField:'dicid',textField:'dicname',url:'${pageContext.request.contextPath}/selectDicname'" value="请选择"/>
<a onclick="jifang()" class="easyui-linkbutton" data-options="iconCls:'icon-add'">任务设定</a>
<div class="map"  id="main" style="width: 600px;height:400px;"></div>
<div id="dlg" class="easyui-dialog" style="width: 400px;height: 250px;padding: 10px 20px" closed="true" buttons="#dlg-buttons">

	<form id="fm" method="post">
		<table cellpadding="8px">
			<tr>
				<td>用户名：</td>
				<td>
					<input type="text" id="userId" name="userId" readonly="readonly" value="${currentMemberShip.user.id }" style="width: 200px"/>
				</td>
			</tr>
			<tr>
				<td>原密码：</td>
				<td>
					<input type="password" id="oldPassword" name="oldPassword" class="easyui-validatebox" required="true" style="width: 200px"/>
				</td>
			</tr>
			<tr>
				<td>新密码：</td>
				<td>
					<input type="password" id="newPassword" name="newPassword" class="easyui-validatebox" required="true" style="width: 200px"/>
				</td>
			</tr>
			<tr>
				<td>用户名：</td>
				<td>
					<input type="password" id="newPassword2" name="newPassword2" class="easyui-validatebox" required="true" style="width: 200px"/>
				</td>
			</tr>
		</table>
	</form>

</div>

</body>
</html>