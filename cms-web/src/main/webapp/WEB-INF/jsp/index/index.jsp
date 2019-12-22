<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>欢迎访问${baseInfo.name }</title>

    <meta name="description" content="java攻城狮资源分享">
    <meta name="author" content="pandaxu">
 	<link rel="stylesheet" href="http://apps.bdimg.com/libs/bootstrap/3.3.0/css/bootstrap.min.css">
   	 <link href="<%=request.getContextPath() %>/resources/css/index/bootstrap.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/resources/css/index/style.css" rel="stylesheet">
  	<script src="<%=request.getContextPath() %>/resources/js/jquery.min.js"></script>
    <script src="<%=request.getContextPath() %>/resources/js/bootstrap.min.js"></script>
    <script src="<%=request.getContextPath() %>/resources/js/scripts.js"></script>
   
  </head>
  <body>

 	<jsp:include page="/jsp/template/top1.jsp"/>	
	<jsp:include page="/jsp/template/body.jsp"/>
	<jsp:include page="/jsp/template/bottom.jsp"/>

  
  </body>
</html>