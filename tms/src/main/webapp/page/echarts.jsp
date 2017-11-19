<%@ page pageEncoding="utf-8" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>超市账单管理系统</title>
    <script src="http://echarts.baidu.com/build/dist/echarts.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jQuery1.11.1.js"></script>
    <script type="text/javascript">
       require.config({
            paths : {
                echarts :'http://echarts.baidu.com/build/dist'
            }
        });
        // 使用
        require([ 'echarts', 'echarts/chart/bar','echarts/chart/line' // 使用柱状图就加载bar模块，按需加载
        ], drewEcharts);
        function drewEcharts(ec) {
            var myCheck = ec.init(document.getElementById("main"));
            option = {
                title : {
                    text: '期望薪资',
                },
                tooltip : {
                    trigger: 'axis',
                    axisPointer : { // 坐标轴指示器，坐标轴触发有效
                        type :"shadow" // 默认为直线，可选为：'line' | 'shadow'
                    }
                },
                legend: {
                    data:['未来的薪资走向']
                },
                toolbox: {
                    show : true,
                    feature : {
                        /*辅助线*/
                        mark : {show: true},
                        /*数据视图*/
                        dataView : {show: true, readOnly: false},
                        /*视图切换*/
                        magicType : {show: true, type: ['line', 'bar']},
                        /*刷新按钮*/
                        restore : {show: true},
                        /*保存为图片*/
                        saveAsImage : {show: true}
                    }
                },
                xAxis : [
                    {
                        type : 'category',
                        /*坐标轴两边留白策略，类目轴和非类目轴的设置和表现不一样。*/
                        boundaryGap : true,
                        data : (function() {
                            var arr = [];
                            $.ajax({
                                type : "post",
                                async : false, //同步执行
                                url : "${pageContext.request.contextPath}/select",
                                dataType : "json", //返回数据形式为json
                                success : function(data) {
                                    if (data!=null) {
                                        for ( var i = 0; i < data.length; i++) {
                                            arr.push(data[i].name);
                                        }
                                    }

                                },

                            });
                            return arr;
                        })()
                    }
                ],
                yAxis : [
                    {
                        type : 'value',
                        /*y轴坐标轴刻度显示*/
                        axisLabel : {
                            formatter: '{value} °C'
                        }
                    }
                ],
                series : [
                    {
                        name:'薪资',
                        type:'line',
                        data : (function() {
                            var arr = [];
                            $.ajax({
                                type : "post",
                                async : false, //同步执行
                                url : "${pageContext.request.contextPath}/select",
                                data : {},
                                dataType : "json", //返回数据形式为json
                                success : function(result) {
                                    if (result) {
                                        for ( var i = 0; i < result.length; i++) {
                                            console.log(result[i].num);
                                            arr.push(result[i].num);
                                        }
                                    }
                                },

                            });
                            return arr;
                        })(),
                        /*图表标注。*/
                        markPoint : {
                            data : [
                                {type : 'max', name: '最大值'},
                                {type : 'min', name: '最小值'}
                            ]
                        },
                        /*图表标线。*/
                        markLine : {
                            data : [
                                {type : 'average', name: '平均值'}
                            ]
                        }
                    }]
            };
          myCheck.setOption(option);
        }
    </script>
</head>
<body>
<div id="main" style="width: 600px;height:400px;"></div>
</body>
</html>