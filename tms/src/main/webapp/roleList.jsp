<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>角色管理</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/icon.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
    window.onload=function () {
        init();
    };
    function init() {
        $('#test').datagrid({
            title:'角色管理',
            iconCls:'icon-save',
            fit:true,
            nowrap: true,
            striped: true,
            url:'${pageContext.request.contextPath}/role/RoleList?roleName='+$("[name=userName]").val(),
            sortName: 'code',
            sortOrder: 'desc',
            idField:'code',
			pageSize:2,
            pageList: [2, 5,10, 15, 20],
            frozenColumns:[[
				{field:'ck',checkbox:true},
                {title:'角色编码',field:'rid',width:80,sortable:true}
            ]],
            columns:[[
                {field:'rolename',title:'角色名称',width:200},
                {field:'action',title:'操作',width:200, formatter: formatAction 	}
            ]],
            pagination:true, //研究：rows: 每页显示的数据量 page:第几页
            rownumbers:true,
            singleSelect:true,
            fitColumns:true,
            toolbar:[{
                text:'添加角色',
                iconCls:'icon-add',
                handler:function(){
                    open1();
                }
            }]
        });
    }

	function searchTask(){
		$("#dg").datagrid('load',{
			"s_name":$("#s_name").val()
		});
	}
	function formatAction(val,row){
		return "<a href='javascript:openListActionDialog("+row.id+")'>分配权限</a>";
	}
		function openListActionDialog(taskId){
            row=$('#test').datagrid('getSelected');

$("#tt").tree({
    url:'${pageContext.request.contextPath}/user/getAllMenusJson',
    animage:true,
    checkbox:true,
    loadFilter:
    function (data) {
        change(data);
        $.each(data,function (i,v) {
            v.iconCls="icon-folder";
        })
        return data;
    },
    onLoadSuccess:function () {
    /*    var node=$('#tt').tree('find',1);
        $('#tt').tree('check',node.target);*/
        $.ajax({
            type: "post",
            url: "${pageContext.request.contextPath}/user/getPrivilegeJson",
            data:{"rid":row['rid']},
            dataType: "json",
            success: function(data){
                $.each(data,function (i,dom) {
                    var checkedNode = $('#tt').tree('find', dom.id);
                    $('#tt').tree('check', checkedNode.target);
                });
            }
        });
    }
});

		$("#dlg3").dialog("open").dialog("setTitle","分配权限");
	}

	$(function(){

    });
    function getdate(data){
        if(!data.length){
            if(data.children){
                change(data.children);
            }
        }else{
            $.each(data,function (i,v){
                change(v);
            });
        }
    }
    function change(data){
        if(!data.length){
            data.text=data.name;
            if(data.children){
                change(data.children);
            }
        }else{
            $.each(data,function (i,v){
                change(v);
            });
        }
    }


    function getChecked(){
        var nodes = $('#tt').tree('getChecked');
        var s = '';
        for(var i=0; i<nodes.length;i++){
            if (s != '') s += ',';
            s += nodes[i].id;
        }
        $.ajax({
            type: "post",
            url: "${pageContext.request.contextPath}/user/savePrivilege",
            data:{"rid":row['rid'],"s":s},
            success:function () {
            }
        })
    }
</script>
</head>
<body style="margin: 1px">
<table id="test">
</table>

<div id="dlg3" class="easyui-dialog" style="width: 750px;height: 350px;padding: 10px 20px" closed="true" >

 分配权限：
    <ul id="tt"></ul>.
    <a href="#" class="easyui-linkbutton" onclick="getChecked()">保存权限</a>
</div>

</body>
</html>