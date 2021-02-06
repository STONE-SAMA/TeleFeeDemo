<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.stone.teleFee.beans.Info"%>
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
<title>电信资费系统</title>
<link href="css/base.css" type="text/css" rel="stylesheet" />
<base href="<%=basePath%>">
</head>
<body>
<div class="head">
		<div class="head_area">
			<div class="head_nav">
				<ul>
					<li><img src="images/nav_inc1.png" /><a href="index.jsp">首页</a></li>
					<li><img src="images/nav_inc2.png" /><a href="#">更多信息</a></li>
					<li><img src="images/nav_inc3.png" /><a href="#">关于我们</a></li>
				</ul>
			</div>
			<div class="head_user">
				<%
					if (session.getAttribute("SESSION_USER") == null) {
				%>
					<a href="login.jsp" target="_parent"><span class="type1">登录</span></a>
					<a href="register.jsp" target="_parent"><span class="type1">注册</span></a>
				<%
					} else {
				%>
				<a href="UserInfoServlet?type=select">${sessionScope.SESSION_USER.userPhone}</a>&nbsp;&nbsp;
				<a href="UserLogoutServlet">退出</a>
				<%
					}
				%>
			</div>
			<div class="clear"></div>
		</div>
	</div>
</body>
</html>