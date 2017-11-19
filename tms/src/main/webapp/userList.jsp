<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>用户管理</title>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/icon.css">
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.min.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript">
        window.onload = function () {
            $('#dlg').dialog('close');
            $('#deleRole').dialog('close');
            init();
        };
        function init() {
            $('#dataGrid').datagrid({
                title: '用户管理',
                iconCls: 'icon-save',
                fit: true,
                nowrap: true,
                striped: true,
                url: '${pageContext.request.contextPath}/user/UserInfoList?userName=' + $("[name=userName]").val(),
                sortName: 'code',
                sortOrder: 'desc',
                idField: 'code',
                pageSize: 2,
                pageList: [2, 5, 10, 15, 20],
                frozenColumns: [[
                    {field: 'ck', checkbox: true},
                    {title: '用户编码', field: 'userid', width: 80, sortable: true}
                ]],
                columns: [[
                    {field: 'username', title: '用户名称', width: 200},
                    {field: 'action', title: '操作', width: 200, formatter: formatAction}
                ]],

                pagination: true, //研究：rows: 每页显示的数据量 page:第几页
                rownumbers: true,
                fitColumns: true,
                toolbar: [{
                    text: '添加用户',
                    iconCls: 'icon-add',
                    handler: function () {
                        $('#dlg').dialog('open');
                    }
                }]
            });
        }

    function searchTask() {
         $("#dg").datagrid('load', {
         "s_name": $("#s_name").val()
         });
         }
         function formatAction(val, row) {
         return "<a href='javascript:openListActionDialog(" + row.id + ")'>分配角色</a>";
         }
         function openListActionDialog(taskId) {
         $("#dg3").datagrid("load", {
         taskId: taskId
         });

             var row = $('#dataGrid').datagrid('getSelected');
             if(row==null){
                 $.messager.confirm('提示','请选择一个管理员!');
                 return;
             }
             if (row){
                 $.ajax({
                     type:"post",
                     url:"/user/douserInfoByUserId?userid="+row.userid,
                     success:function (data) {
                         $('#userid').val(data.userid);
                     }
                 })
                 $('#addadmin').combobox({
                     url:'/role/findAllRoles',
                     editable:false,
                     valueField:'rid',
                     textField:'rolename'
                 });
             }
         $("#dlg3").dialog("open").dialog("setTitle", "分配角色");
         }

        //添加角色
        function commitAddRole() {
            $.ajax({
                type:"post",
                url:"/user/checkUserRoleIsExist",
                data:{"userid":$("#userid").val(),"roleid":$("#addadmin").combobox("getValue")},
                success:function (data) {
                    alert(data);
                    if(data=="f"){
                        $.messager.confirm("提示","该角色已经存在！");
                    }else{
                        $.ajax({
                            type:"post",
                            url:"/role/addRoleForUser",
                            data:{"userid":$("#userid").val(),"roleid":$("#addadmin").combobox("getValue")},
                            success:function (data) {
                                if(data=='y'){
                                    window.location.href="/userList.jsp";
                                }
                            }
                        })
                    }
                }
            })
        }
    </script>
</head>
<body style="margin: 1px">
<%--<table id="test">
</table>--%>

<div id="dlg3" class="easyui-dialog" style="width: 750px;height: 350px;padding: 10px 20px" closed="true">

    <label><h3 style="margin-left: 130px">角色管理</h3></label>
    <form id="ff"  method="post">
        <input id="userid" type="text" name="userid" style="display: none"/>
        <table cellpadding="5">
            <tr>
                <td>添加角色:</td>
                <td>
                    <select id="addadmin" class="easyui-combobox" name="rolename" style="width: 200px">
                        <option value="请选择"></option>
                    </select></td>
            </tr>
            <tr>
                <td><input type="button" value="添加" onclick="commitAddRole()"></td>
            </tr>
        </table>
    </form>
</div>
<div style="position: absolute;width: 100%;height: 100%;z-index: -1;left: 0;top: 0">
    <table  id="dataGrid" style="width:100%"></table>
    <%--添加角色弹框--%>
  <%--  <div id="dlg" class="easyui-dialog" title="角色分配" data-options="iconCls:'icon-save'" style="width:350px;height:180px;padding:10px" >
        <label><h3 style="margin-left: 130px">角色管理</h3></label>
        <form id="ff"  method="post">
            <input id="userid" type="text" name="userid" style="display: none"/>
            <table cellpadding="5">
                <tr>
                    <td>添加角色:</td>
                    <td>
                        <select id="addadmin" class="easyui-combobox" name="rolename" style="width: 200px">
                        <option value="请选择"></option>
                    </select></td>
                </tr>
                <tr>
                    <td><input type="button" value="添加" onclick="commitAddRole()"></td>
                </tr>
            </table>
        </form>
    </div>--%>

  <%--  &lt;%&ndash;删除角色dialog&ndash;%&gt;
    <div id="deleRole" class="easyui-dialog" title="角色分配" data-options="iconCls:'icon-save'" style="width:350px;height:180px;padding:10px" >
        <label><h3 style="margin-left: 130px">角色管理</h3></label>
        <form id="dd" action="" method="post">
            <input id="deleuserid" type="text" name="deleuserid" style="display: none"/>
            <table cellpadding="5">
                <tr>
                    <td>删除角色:</td>
                    <td><select id="deleadmin" class="easyui-combobox" name="rolename" style="width: 200px">
                        <option value="请选择"></option>
                    </select></td>
                </tr>
                <tr>
                    <td><input type="button" value="删除" onclick="commitDeleRole()"></td>
                </tr>
            </table>

        </form>
    </div>
--%>

</div>

</body>
</html>