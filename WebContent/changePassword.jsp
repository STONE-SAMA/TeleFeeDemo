<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改密码</title>
<script src="js/jquery-3.3.1.js"></script>
<link href="css/register.css" type="text/css" rel="stylesheet"/>
<script type="text/javascript">
	function checkForm(form){
		if(form.pwd1.value != "" && form.pwd1.value == form.pwd2.value) {
            if(form.pwd1.value.length < 6) {
                alert("错误：密码必须至少包含六个字符！");
                form.pwd1.focus();
                return false;
            }
            re = /[0-9]/;
            if(!re.test(form.pwd1.value)) {
                alert("错误：密码必须包含至少一个数字（0至9）！");
                form.pwd1.focus();
                return false;
            }
        } else {
            alert("错误：请检查并确认您输入的密码是否一致！");
            form.pwd1.focus();
            return false;
        }
		
		return true;
	}
</script>

</head>
<body>
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
	
	<form action="${pageContext.request.contextPath }/changePassServlet" method="post" onsubmit="return checkForm(this);">
		<div class="content">
			<p>&nbsp;&nbsp;&nbsp;&nbsp;原密码：<input type="password" name="oldPass"><p>		
			<p>&nbsp;&nbsp;&nbsp;&nbsp;新密码：<input type="password" name="pwd1"></p>
			<p>&nbsp;确认密码：<input type="password" name="pwd2"></p>
			<p>&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="修改密码"></p>
		</div>
	</form>
 
 <!-- 网站公共尾部 -->
	<iframe src="foot.html" width="100%" height="150" scrolling="no"
		frameborder="0"></iframe>
</body>
</html>