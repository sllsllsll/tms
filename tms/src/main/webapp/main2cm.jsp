<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springsecurity.org/jsp" prefix="security"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>内容发布</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/icon.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>

    <script type="text/javascript" src="${pageContext.request.contextPath}/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/ueditor/ueditor.all.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/ueditor/themes/default/css/ueditor.css">
    <script type="text/javascript" charset="utf-8"
            src="${pageContext.request.contextPath}/ueditor/lang/zh-cn/zh-cn.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/ueditor/themes/default/css/ueditor.css">
    <link href="${pageContext.request.contextPath}/shuanchuan/css/common.css" type="text/css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/shuanchuan/css/index.css" type="text/css" rel="stylesheet">

    <script type="text/javascript">
        Date.prototype.Format = function(fmt)
        { //author: meizz
            var o = {
                "M+" : this.getMonth()+1,                 //月份
                "d+" : this.getDate(),                    //日
                "h+" : this.getHours(),                   //小时
                "m+" : this.getMinutes(),                 //分
                "s+" : this.getSeconds(),                 //秒
                "q+" : Math.floor((this.getMonth()+3)/3), //季度
                "S"  : this.getMilliseconds()             //毫秒
            };
            if(/(y+)/.test(fmt))
                fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));
            for(var k in o)
                if(new RegExp("("+ k +")").test(fmt))
                    fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));
            return fmt;
        }

        window.onload=function () {
            init();
        };
       /* $(function () {*/
        function init() {
            $("#tt").tree({
                url: '${pageContext.request.contextPath}/user/cmList',
                animate: true,
                cascadeCheck: false,
                loadFilter :
                    function(data) {
                        change(data);
                        //图标的设定
                        $.each(data,function (i,v){
                            v.iconCls="icon-folder";
                        });
                        return data;
                    },
                onDblClick: function (checkNode) {
                    showcontent(checkNode.id);
                }
            });
        };
        function change(data){
            if(!data.length){
                data.id=data.syscode;
                data.text=data.columnname;
                if(data.children){
                    change(data.children);
                }
            }else{
                $.each(data,function (i,v){
                    change(v);
                });
            }
        }
        function showcontent(ccode) {
            $("#tb").datagrid({
                iconCls:'icon-save',
                url: '${pageContext.request.contextPath}/user/LimitLsitNew?ccode='+ ccode,
                sortOrder: 'desc',
                idField:'code',
                pagination:true,
                pageSize:2,
                pageList: [2, 5,10, 15, 20],
                singleSelect:true,
                fitColumns:true,
                frozenColumns:[[
                    {field:'ck',checkbox:false},
                    {title:'标题',field:'ntitle',width:80,sortable:true}
                ]],
                columns: [[
                    {field: 'nid', title: '编号', width: 120},
                    {field: 'ntitle', title: '标题', width: 120},
                    {field: 'cmColumn', title: '栏目', width: 120, align: 'right',formatter: function(value,row,index){return value.columnname;}},
                    {field: 'djid', title: '点击数', width: 120, align: 'right'},
                    {field: 'start', title: '状态', width: 120, align: 'right'},
                    {field: 'user', title: '创建者', width: 120, align: 'right',formatter: function(value,row,index){return value.username;}},
                    {field: 'updateTime', title: '更新时间', width: 120, align: 'right',formatter: function(value,row,index){
                        return new Date(value).Format("yyyy-MM-dd hh:mm:ss");}},
                    {field: 'action', title: '操作', width: 60,  align: 'right', formatter: formatAction},
                    {field: 'action2', title: '操作2', width: 60,  align: 'right', formatter: formatActions}
                ]],

                toolbar:[{
                    text:'标题',

                    iconCls:'icon-add'
                },{
                }]
            });

        }

        function formatAction(val, row) {
            return "<a href='javascript:openListActionDialog(" + row.nid + ")'>删除</a>";
        }

        function formatActions(val, row) {
            return "<a href='javascript:openListActionDialogs(" + row.nid + ")'>修改</a>";
        }
        function openListActionDialog(nid) {

            location.href="${pageContext.request.contextPath}/user/delNews?nid="+nid;
        }
        function openListActionDialogs(nid) {

            location.href="${pageContext.request.contextPath}/user/ByNewsIdd?nid="+nid;
        }



        function searchTask(){
            $("#dg").datagrid('load',{
                "s_name":$("#s_name").val()
            });
        }




        function showcontentlike(ccode) {
            $("#tb").datagrid({
                iconCls:'icon-save',
                url: '${pageContext.request.contextPath}/user/LimitLsitNew?ccode='+ ccode,
                sortOrder: 'desc',
                idField:'code',
                pagination:true,
                pageSize:2,
                pageList: [2, 5,10, 15, 20],
                singleSelect:true,
                fitColumns:true,
                frozenColumns:[[
                    {field:'ck',checkbox:false}
                ]],
                columns: [[
                    {field: 'nid', title: '编号', width: 120},
                    {field: 'ntitle', title: '标题', width: 120},
                    {field: 'cmColumn', title: '栏目', width: 120, align: 'right',formatter: function(value,row,index){return value.columnname;}},
                    {field: 'djid', title: '点击数', width: 120, align: 'right'},
                    {field: 'start', title: '状态', width: 120, align: 'right'},
                    {field: 'user', title: '创建者', width: 120, align: 'right',formatter: function(value,row,index){return value.username;}},
                    {field: 'updateTime', title: '更新时间', width: 120, align: 'right',formatter: function(value,row,index){
                        return new Date(value).Format("yyyy-MM-dd hh:mm:ss");}},
                    {field: 'action', title: '操作', width: 60,  align: 'right', formatter: formatActions}
                ]],

                toolbar:[{
                    text:'标题',

                    iconCls:'icon-add'
                },{

                }]
            });

        }


        function newEqument() {
            $('#dlg').dialog('open').dialog('center').dialog('setTitle', '添加新闻');
            /*在弹框出来 时候我们把栏目的  树显示出来
            * 便于我们添加数据
            * */
            $("#tts").tree({
                url:'${pageContext.request.contextPath}/user/cmList',
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
                onDblClick: function (checkNode) {
                    showcontentadd(checkNode.id);
                }
            });

            $('#fm').form('clear');
        }

        function showcontentadd(ccode) {
            $("#dd").append('<input name="ccode" type="text" value='+ccode+'>');
            $('#dg3s').dialog('close').dialog('center').dialog('setTitle', '选择栏目');


        }
        function  hh() {
            $('#dg3s').dialog('open').dialog('center').dialog('setTitle', '选择栏目');
            $('#fm').form('clear');
        }
        function saveEqument(){
            location.href="${pageContext.request.contextPath}/user/addNews";
        }

        UE.getEditor("contents");
    </script>
    <html>
    <head>
        <title>栏目管理菜单</title>
    </head>
<body>
<div id="dg3" class="easyui-layout" style="width:1200px;height:800px;">
    <div region="west" split="true" title="默认站点" style="width:150px;">


        <ul id="tt">
        </ul>
    </div>
    <div id="content" region="center" title="" style="padding:5px;">
        <div>

                <form method="post" action="${pageContext.request.contextPath }/user/ListNewListLike">
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <span>标题：</span>
                    <input name="ntitles" class="input-text" type="text" >
  <%--                  <input type="hidden" name="pageIndex" value="1"/>--%>
              <input type="button" value="查询" class="button border-blue" id="select">
                    <a href="javascript:resetValue()"><button>重置</button></a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <span>状态：</span>
                    <input type="radio" name="start" value="0">发布
                    <input type="radio" name="start" value="1">审核
                    <input type="radio" name="start" value="2">驳回
                    <input type="radio" name="start" value="3">删除
                    <input type="radio" name="start" value="4">草稿
                </form>


        </div>
        <table id="tb" align="center" pagination="true">
            <input type="button" value="添加" class="button border-blue" onclick="newEqument()">
        </table>

    </div>
</div>
<%-- 弹窗  Start--%>
<div id="dlg" class="easyui-dialog" style="width:700px;height:600px;padding:10px 20px"
     closed="true" buttons="#dlg-buttons">
    <div class="ftitle" ><h2>添加新闻</h2></div>
    <form id="fm" enctype="multipart/form-data"  action="${pageContext.request.contextPath}/user/addNews" method="post" novalidate>
        <div class="fitem">
            <label>标         题:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
                <input id="Eq_Number" name="ntitle" class="easyui-textbox" required="true">
        </div>
        <br/>
        <div class="fitem">
            <label>栏         目:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>

          <input type="button" value="添加栏目" class="button border-blue" onclick="hh()">
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <div id="dd"></div>
        </div>
        <br/>
        <div class="fitem">
            <label>点击次数:</label>
            <input id="Eq_Name" name="djid"  class="easyui-textbox" required="true">
        </div>
        <br/>
        <div class="fitem">
            <label>状         态:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
            <select name="start"  >
                <option value="0">----请选择状态----</option>
                <option value="1">发布</option>
                <option value="2">审核</option>
                <option value="3">驳回</option>
                <option value="4">删除</option>
                <option value="5">草稿</option>
            </select><br/>
        </div>
        <br/>
        <div class="fitem">
            <td colspan="2"></td>
        </div>
            <div class="fitem">
            <td></td>
            <td><textarea id="contents"
                          name="Description"
                          style="width: 600px;height:200px">
                 </textarea></td>

            </div>
       <%-- <div class="fitem">
            <label>创   建   者:&nbsp;&nbsp;</label>
            <input name="createId" class="easyui-textbox" required="true">
        </div>--%>
        <br/>
        <label>新闻图一:</label>

<%--        <section class=" img-section">
            <div class="z_photo upimg-div clear">
                <section class="z_file fl">
                    <img  src="${pageContext.request.contextPath}/shuanchuan/img/a11.png"
                          class="add-img">
                    <input type="file"  l id="file" class="file"
                           accept="image/jpg,image/jpeg,image/png,image/bmp"/>
                    <input name="attachs" type="hidden"/>
                </section>
            </div>
        </section>
        <aside class="mask works-mask">
            <div class="mask-content">
                <p class="del-p ">您确定要删除作品图片吗？</p>
                <p class="check-p"><span class="del-com wsdel-ok">确定</span><span class="wsdel-no">取消</span>
                </p>
            </div>
        </aside>--%>
    <input type="file" id="onePicPath" name="attachs" />

        <br/>
        <br/>
        <label>新闻图二:</label>

      <input type="file" id="twoPicPath" name="attachs" />

        <br/>
        <br/>
        <input class="easyui-linkbutton c6" iconCls="icon-ok"  style="width:90px" type="submit" value="添加"/>
    </form>
</div>
<div id="dlg3" class="easyui-dialog" style="width: 750px;height: 350px;padding: 10px 20px" closed="true" >
<div id="dlg-buttons">
    <a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="saveEqument()" style="width:90px">保存</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')" style="width:90px">重置</a>
</div>
</div>
<script src="${pageContext.request.contextPath}/shuanchuan/js/imgUp.js"></script>
<%-- 弹窗  End --%>

    <div id="dg3s" class="easyui-dialog" style="width:500px;height:450px;padding:10px 20px" closed="true" buttons="#dlg-buttons">
        <ul id="tts"  name="ccode"></ul>
    </div>
    <div id="dg3s" class="easyui-dialog" style="width: 750px;height: 350px;padding: 10px 20px" closed="true" />

</body>

</html>
