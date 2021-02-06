<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.stone.teleFee.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<title>电信资费</title>
<script src="js/jquery-3.3.1.js"></script>
<link href="css/base.css" type="text/css" rel="stylesheet" />
<link href="css/index.css" type="text/css" rel="stylesheet" />
<link href="css/index_1.css" type="text/css" rel="stylesheet"/>
</head>
<body class="tn-page-bg">
	<!-- 网站公共头文件 -->
	<jsp:include page="top.jsp"></jsp:include>



	<ul class="head1">
		<li class="padding">
			<ul class="suspend">
				<li class="suspendbg1">
					<a href="changePassword.jsp">更改密码</a>
				</li>
				<li class="suspendbg1">
					<a href="records.jsp">消费记录</a>
				</li>
				<li class="suspendbg1">
					<p>当前用户：${login_phone }</p>
				</li>
				<li class="suspendbg1">
					<p>账户余额：${user_money }</p>
				</li>
				<li class="suspendbg1">
					<p>当前套餐：${user_combo }</p>
				</li>
			</ul>
		</li>
	</ul>
	

	<!-- 套餐列表展示 -->
	<jsp:include page='${"ComboServlet"}'>
		<jsp:param value="pageList" name="type"/>
		<jsp:param value="${param.pageNo}" name="pageNo"/>
	</jsp:include>


	<!-- 网站公共尾部 -->
	<iframe src="foot.html" width="100%" height="150" scrolling="no"
		frameborder="0"></iframe>
</body>
</html>