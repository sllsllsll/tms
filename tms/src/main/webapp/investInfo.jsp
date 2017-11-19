<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springsecurity.org/jsp" prefix="security" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport"
          content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no"/>
    <title>投资咨询</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="css/market-banner.css"/>
    <link rel="stylesheet" type="text/css" href="css/headerAndFooter.css"/>
    <link rel="stylesheet" type="text/css" href="css/reset.css"/>
    <link rel="stylesheet" type="text/css" href="css/common.css"/>
    <link rel="stylesheet" href="css/investInfo.css"/>
    <script src="http://libs.useso.com/js/html5shiv/3.7/html5shiv.min.js"></script>
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

    <script type="text/javascript" src="${pageContext.request.contextPath}/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/ueditor/ueditor.all.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/ueditor/themes/default/css/ueditor.css">
    <script type="text/javascript" charset="utf-8"
            src="${pageContext.request.contextPath}/ueditor/lang/zh-cn/zh-cn.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/ueditor/themes/default/css/ueditor.css">
    <link href="${pageContext.request.contextPath}/shuanchuan/css/common.css" type="text/css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/shuanchuan/css/index.css" type="text/css" rel="stylesheet">
    <script type="text/javascript">
        function pid(parentcode) {
            alert('11');
            alert(parentcode)
            $.ajax({
                type: "post",
                url: "${pageContext.request.contextPath}/ListNewPid?parentcode=" + row.parentcode,
                success: function (data) {
                    $('#userid').val(data.userid);
                }
            })

        }

    </script>
</head>
<body>
<!--顶部-->
<div class="container-fluid">
    <div class="row">
        <div class="col-md-12 top">
            <div class="container">
                <div class="row">
                    <div class="col-md-6">
                        <span id="welcome">您好，欢迎您进入中国木材大数据平台</span>
                        <span id="loginOrRes"><a href="login.html">登陆</a> / <a href="register.html">注册</a></span>
                    </div>
                    <div class="col-md-6 padding-right">
                        <ul id="topUL">
                            <li><a href="">设为首页</a><span id="lines">|</span></li>
                            <li><a href="">收藏此页</a><span id="line">|</span></li>
                            <li><a href="">联系我们</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<!--logo-->
<div class="container logoDiv">
    <div class="row">
        <div class="col-sm-4 col-md-4 padding-left">
            <img src="images/index/logo_06.png" id="logo"/>
        </div>
        <div class="col-sm-7 col-md-7 col-md-offset-1 padding-right">
            <div class="col-md-7 search">
                <div class="input-group">
                    <span class="input-group-addon"><img src="images/index/search_12.png"/></span>
                    <input type="text" class="form-control" id="searchText" aria-describedby="inputGroupSuccess1Status">
                    <button class="btn btn-default list-inline border-radius" id="searchBtn" type="button">搜索</button>
                </div>
            </div>
            <div class="col-md-5 padding-right">
                <p class="text-right telText bold font-family">全国服务电话:</p>
                <p class="text-right tel bold font-family">400-1234-1234</p>
            </div>
        </div>
    </div>
</div>

<!--导航-->
<div class="container">
    <div class="row">
        <div class="col-sm-12 col-md-12 padding-left padding-right">
            <nav class="navbar navbar-inverse navbar-static-top">
                <div class="container">
                    <div id="navbar" class="collapse navbar-collapse">
                        <ul id="tt" class="nav navbar-nav font-family">
                            <c:forEach items="${list}" var="items">
                                <li><a onclick="pid('${items.syscode}')">${items.columnname}</a></li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>
            </nav>
        </div>
    </div>
</div>

<!--面包屑-->
<div class="container">
    <div class="row">
        <div class="col-md-12 padding-left">
            <span id="addressSpan">您所在的位置是：<a href="index.html">首页</a>&nbsp;>&nbsp;<a
                    href="investInfo.html">投资咨询</a></span>
        </div>
    </div>
</div>

<!--投资咨询-->
<div class="container margin-top-30">
    <div class="row">
        <div class="col-sm-9 col-md-9 padding-left">
            <div class="invest-img">
                <img src="images/investInfo/banner.jpg"/>
            </div>
        </div>
        <div class="col-sm-3 col-md-3 padding-right padding-left">
            <div class="serve-pt border1">
                <p class="pt-title">服务咨询平台</p>
                <ul>
                    <li class="icon-1">客服：400-1234-1324</li>
                    <li class="icon-2">传真：400-1234-1324</li>
                    <li class="icon-3">联系人：张小姐</li>
                    <li class="icon-4">邮箱：zikoo@zikoo.com</li>
                    <li class="icon-5">地址：北京市朝阳区朝阳路5号</li>
                    <li class="icon-6">邮编：100000</li>
                </ul>
            </div>
        </div>
    </div>
</div>

<!--企业战略咨询、企业管理咨询-->
<div class="container">
    <div class="row margin-top-20">
        <div class="col-sm-12 col-md-12 padding-left padding-right">
            <!--企业战略咨询-->
            <div class="col-sm-12 col-md-6 padding-left padding-right">
                <div class="content-state height-280">

                    <div class="content-news-title">
                        <div class="col-sm-6 col-md-6 padding-left">
									 <span id="invest-title2" class="bold">
										<a href="investInfo-plann.html">企业战略咨询</a>
									</span>
                        </div>
                    </div>
                    <div class="content-state-con">
                        <div class="row">
                            <div class="col-sm-12 col-md-12">

                                <div class="content-market-con-up">
                                    <div class="col-sm-3 col-md-3">
                                        <img src="images/other/pic_07.png" id="smallImg1"/>
                                    </div>
                                    <div class="col-sm-9 col-md-9 marketCon padding-right">
                                        <h4 class="font-family">2006年中国木材进出口深度分析报告</h4>
                                        <p id="content-market-con-p9">
                                            本报告隶属《中国机电工业深度分析报告》行业发展与市场评估系列。此系列报告严格按国民经济行业分类GB/T4754-2003标准划分行业，包含金属制品，
                                        </p>

                                        <p id="checkAll-market7"><a
                                                href="investInfo-plann-more.html">[&nbsp;查看全文&nbsp;]</a></p>
                                    </div>
                                </div>

                                <div class="content-state-con-down">
                                    <div class="col-sm-12 col-md-12 padding-left">
                                        <ul class="padding-top">
                                            <li><img src="images/index/dott_03.png"/><a href="newsDetails.html">青岛发布规划:5年内将建成全国领先智慧城市</a>
                                            </li>
                                            <li><img src="images/index/dott_03.png"/><a href="newsDetails.html">青岛发布规划:5年内将建成全国领先智慧城市</a>
                                            </li>
                                            <li><img src="images/index/dott_03.png"/><a href="newsDetails.html">2016-2021年中国镀膜系统用的激光自动消颗粒装置行业发展分析及投资潜力研究</a>
                                            </li>
                                            <li><img src="images/index/dott_03.png"/><a href="newsDetails.html">2016-2021年中国镀膜系统用的激光自动消颗粒装置行业发展分析及投资潜力研究</a>
                                            </li>
                                        </ul>
                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>

                </div>
            </div>

        </div>
    </div>

</div>

<!--友情链接-->
<div class="container">
    <div class="row">
        <div class="col-md-12 padding-left padding-right">
            <div class="content-friend-link">
						<span id="linkTxt">
							友情链接：
						</span>
                <ul>
                    <a href="">
                        <li>木材大数据平台</li>
                    </a>
                    <a href="">
                        <li>木材大数据平台</li>
                    </a>
                    <a href="">
                        <li>木材大数据平台</li>
                    </a>
                    <a href="">
                        <li>木材大数据平台</li>
                    </a>
                    <a href="">
                        <li>木材大数据平台</li>
                    </a>
                    <a href="">
                        <li>木材大数据平台</li>
                    </a>
                    <a href="">
                        <li>木材大数据平台</li>
                    </a>
                    <a href="">
                        <li>木材大数据平台</li>
                    </a>
                    <a href="">
                        <li>木材大数据平台</li>
                    </a>
                    <a href="">
                        <li>木材大数据平台</li>
                    </a>
                </ul>
            </div>
        </div>
    </div>
</div>

<!--底部-->
<div class="container-fluid">
    <div class="row footer">
        <div class="col-md-12 ">
            <ul>
                <li><a href="">关于我们</a><span id="shu1">|</span></li>
                <li><a href="">业务体系</a><span id="shu2">|</span></li>
                <li><a href="">企业动态</a><span id="shu3">|</span></li>
                <li><a href="">联系我们</a><span id="shu4">|</span></li>
                <li><a href="">法律声明</a><span id="shu5">|</span></li>
                <li><a href="">服务协议</a><span id="shu6">|</span></li>
                <li><a href="">Investor Relations</a><span id="shu7">|</span></li>
                <li><a href="">用户体验中心</a><span id="shu8">|</span></li>
                <li><a href="">关于会员</a><span id="shu9">|</span></li>
                <li><a href="">我要提意见</a></li>
            </ul>
        </div>
        <div class="row address">
            CopyRight © 2000-2015 BitAuto,All Rights Reserved. 版权所有 北京国数源科技有限公司
        </div>
        <div class="row telphone">
            咨询热线：4000-168-168 (每天9:00—17:30，法定节日休息）
        </div>
        <img src="images/index/rcode_03.png" id="rcode"/>
    </div>
</div>

</body>
<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
<script src="js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>

</html>