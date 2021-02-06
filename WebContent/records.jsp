<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.stone.teleFee.*" %>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	// 获得请求的绝对地址
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>消费记录</title>
<link href="css/base.css" type="text/css" rel="stylesheet" />
<link href="css/index.css" type="text/css" rel="stylesheet" />
<link href="css/index_1.css" type="text/css" rel="stylesheet"/>
</head>
<body>
<!-- 网站公共头文件 -->
	<jsp:include page="top.jsp"></jsp:include>

	<!-- 消费记录展示 -->
	<jsp:include page='${"RecordServlet"}'>
		<jsp:param value="pageList" name="type"/>
		<jsp:param value="${param.pageNo }" name="pageNo"/>
	</jsp:include>


	<!-- 网站公共尾部 -->
	<iframe src="foot.html" width="100%" height="150" scrolling="no"
		frameborder="0"></iframe>
</body>
</html>