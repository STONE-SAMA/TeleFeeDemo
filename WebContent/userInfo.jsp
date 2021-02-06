<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>更改用户信息</title>
<link href="css/base.css" type="text/css" rel="stylesheet" />
<link href="css/info.css" type="text/css" rel="stylesheet" />
</head>
<body>
<jsp:include page="top.jsp"></jsp:include>
		<!-- 从request对象中获取一个JavaBean对象 -->
		<jsp:useBean id="basicinfo"
		class="com.stone.teleFee.beans.User" scope="request"></jsp:useBean>
		
		<div class="resume_con">
			<!-- tab 设置 -->
			<div class="user_operate">
				<ul style="float:left">
					<li><a href="UserInfoServlet?type=select">我的个人信息</a></li>
				</ul>
				<div class="clear"></div>
			</div>
			
			<!-- 主体 -->
			<div class="resume_main">
				<!-- left -->
				<div class="resume_left">
					<div class="resume_title">基本信息</div>		
					<div class="btn">
						<a href="UserInfoServlet?type=updateSelect">修改</a>
					</div>
				</div>
				<div class="all_resume">
					<div class="table_style">
						<table width="300" border="0" cellpadding="3" cellspacing="1" bgcolor="#EEEEEE">
							<tr>
								<td width="200" align="left" bgcolor="#F8F8F8"
									style="color: gray;">姓名：${userinfo.userName }</td>
								<td bgcolor="#F8F8F8"></td>
							</tr>
						</table>
						
						<div class="he"></div>
						<table width="300" border="0" cellpadding="3" cellspacing="1"
							bgcolor="#EEEEEE">
							<tr>
								<td width="200" align="left" bgcolor="#F8F8F8"
									style="color: gray;">手机号：${userinfo.userPhone }</td>
								<td bgcolor="#F8F8F8"></td>
							</tr>
						</table>
						
						<div class="he"></div>
						<table width="300" border="0" cellpadding="3" cellspacing="1"
							bgcolor="#EEEEEE">
							<tr>
								<td width="300" align="left" bgcolor="#F8F8F8"
									style="color: gray;">身份证号：${userinfo.idCARD }</td>
								<td bgcolor="#F8F8F8"></td>
							</tr>
						</table>
						
					</div>
				</div>
			</div>
			
		</div>
	
<!-- 网站公共尾部 -->
<iframe src="foot.html" width="100%" height="150" scrolling="no"
		frameborder="0"></iframe>
</body>
</html>