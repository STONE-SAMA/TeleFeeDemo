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
<title>Insert title here</title>
<link href="css/base.css" type="text/css" rel="stylesheet" />
<link href="css/setmeallist.css" type="text/css" rel="stylesheet" />
<link href="css/bill1.css" type="text/css" rel="stylesheet" />
</head>
<body>
<jsp:include page="top.jsp"></jsp:include>
	
		<c:forEach items="${pagination.pageData}" var="bill">
			<div class="box">
				<div class="inner1">
					<div class="bill_name">消费手机号：${bill.phone}</div>
					<div class="bill_name">消费金额：${bill.money}元</div>
					<div class="bill_name">消费时间：${bill.time}</div>
				</div>
				<div class="inner2">
					<div class="bill_shuoming">${bill.note}</div>
				</div>
				<div class="inner3">
					<div class="pic"><img src="images/bill.jpg" style="width:200px;height:200px;"/></div>
				</div>
			</div>
			<br>
		</c:forEach>
    
       <div class="page01">
	   <div class="page02">&nbsp;</div>
	   <div class="page03"><a href="records.jsp?type=pageList&pageNo=1">首页 </a></div>
	   <c:if test="${pagination.hasPreviousPage}">
	   	<div class="page03">
	   	<a href='records.jsp?type=pageList&pageNo=${pagination.pageNo-1}'>上一页 </a></div>
	   </c:if>
	   <c:if test="${pagination.hasNextPage}">
	   	<div class="page03"><a href="records.jsp?type=pageList&pageNo=${pagination.pageNo+1}">下一页 </a></div>
	   </c:if>
	   <div class="page03"><a href="records.jsp?type=pageList&pageNo=${pagination.totalPages}">尾页</a></div>
	   <div class="page03">当前是第${pagination.pageNo}页，共${pagination.totalPages}页</div>
   	</div>
</body>
</html>