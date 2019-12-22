<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/admin/main.css"/>
<!-- 新建<script>标签引入模块化单文件echarts.js -->
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/echarts-2.2.7/build/dist/echarts.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/core/jquery.cms.core.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/admin/main.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/admin/inc.js"></script>
<script type="text/javascript">
 // 路径配置
        require.config({
            paths: {
                echarts: 'resources/echarts-2.2.7/build/dist'
            }
        });
        
       
        // 使用
         require(
            [
                'echarts',
                'echarts/chart/bar', // 使用柱状图就加载bar模块，按需加载
                'echarts/chart/line',
                'echarts/chart/chord',
                'echarts/chart/eventRiver',
                'echarts/chart/force',
                'echarts/chart/funnel',
                'echarts/chart/gauge',
                'echarts/chart/heatmap',
                'echarts/chart/k',
                'echarts/chart/map',
                'echarts/chart/pie',
                'echarts/chart/radar',
                'echarts/chart/scatter',
                'echarts/chart/tree',
                'echarts/chart/treemap',
                'echarts/chart/venn',
                'echarts/chart/wordCloud' 
            ],
             function (ec) {
                // 基于准备好的dom，初始化echarts图表
               var  myChart= ec.init(document.getElementById("lastweekreport")); 
           	  	myChart.showLoading({  
                	text : "图表数据正在努力加载..."  
           		 });  
                var  option;
                $.ajax({
        		type: "POST",
   				url: $(ctx).val()+"/getlastweekdata",
   				dataType:"json",
   				success: function(data){
   				  myChart.setOption(data); 
   				},
   				error:function(){
   					alert("获取图表数据出错啦.....");
   				}
        		
        	});
                // 为echarts对象加载数据 
                //myChart.setOption(option); 
               myChart.hideLoading();  
            });
        
</script>
</head>
<body>
<input type="hidden" id="ctx" value="<%=request.getContextPath() %>"/>
<div id="content">
	<h3 class="admin_link_bar">
		<jsp:include page="inc.jsp"></jsp:include>
	</h3>
	<div id="lastweekreport" style="width: 600px;height: 400px;margin-top: 20px;margin-left: 100px;"></div>
</div>
</body>
</html>