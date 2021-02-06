<%@page import="com.stone.teleFee.utils.CookieEncryptTool"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
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
<title>登录——电信资费系统</title>
<link href="css/login.css" type="text/css" rel="stylesheet" />
<script type="text/javascript">
	function validate() {
		var phone = document.getElementById("phone");
		var password = document.getElementById("password");
		if (phone.value == "") {
			alert("手机号不能为空！");
			phone.focus();
			return false;
		}
		if (password.value == "") {
			alert("密码不能为空！");
			password.focus();
			return false;
		}
		return true;
	}
</script>
</head>
<body>
<%
String userPhone = "";
String userPassword = "";
// 从客户端读取Cookie
Cookie[] cookies = request.getCookies();  
if (cookies != null) {  
  for (Cookie cookie : cookies) {  
    if ("COOKIE_APPLICANTPHONE".equals(cookie.getName())) {  
    	// 解密获取存储在Cookie中的用户手机号
    	userPhone = CookieEncryptTool.decodeBase64(cookie.getValue());
    }  
    if ("COOKIE_APPLICANTPWD".equals(cookie.getName())) {  
    	// 解密获取存储在Cookie中的用户登录密码
      userPassword = CookieEncryptTool.decodeBase64(cookie.getValue());  
    }  
  }
}
%>
<%
		HttpSession sess = request.getSession();
		String message = (String)sess.getAttribute("message");
	
	if(message == "" || message == null){
		%>
 
		<%
	}else{
		%>
			 <script type="text/javascript">
					alert("<%=message %>");
			 </script>
		<%
		sess.setAttribute("message", "");
	}
 %>
<!-- 网站公共头部 -->
	<jsp:include page="top.jsp"></jsp:include>
	
	<div class="content" >
			<div class="page_name">登    录</div>
			<div class="login_content">
			<!-- 登陆表单开始 -->
				<form action="${pageContext.request.contextPath }/UserLoginServlet" method="post" onsubmit="return validate();">
					<div class="login_l">
						<p class="font14" style="color:gray">使用手机号登录</p>
						<div class="span1">
							<label class="tn-form-label">手机号:</label>
							<input class="tn_textbox" type="text" name="phone" id="phone" value="<%=userPhone%>">
						</div>
						<div class="span1">
							<label class="tn-form-label">密码:</label>
							<input class="tn_textbox" type="password" name="password" id="password" value="<%=userPassword%>">
						</div>
						<div class="tn_form_row_button">
							<div class="span1">
								<input type="submit" name="submit" id="submit" class="tn-button-text" value="登 录">
								<span class="it-register-text">
								<input
								checked="checked" name="rememberMe" id="rememberMe"
								class="tn-checkbox" type="checkbox" value="true"> <label
								for="RememberPassword" style="color: gray"> 记住密码</label></span>
							</div>
						</div>
					</div>
				</form>
				<!-- 表单结束 -->
				
				<div class="login_r">
				<p align="center">
					<b>还没有帐号？</b><a href="${pageContext.request.contextPath}/register.jsp">快速注册</a>
				</p>
				<div class="clear"></div>
			</div>
			<div class="clear"></div>
			</div>
	</div>
	<!-- 网站公共尾部 -->
	<iframe src="foot.html" width="100%" height="150" scrolling="no"
		frameborder="0"></iframe>
</body>
</html>