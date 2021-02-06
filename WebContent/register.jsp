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
<title>注册--电信资费系统</title>
<link href="css/register.css" type="text/css" rel="stylesheet"/>
<script src="js/jquery-3.3.1.js"></script>
<script type="text/javascript">
var xhr = false;
function createXHR() {
	try {
		xhr = new XMLHttpRequest();
	} catch (e) {
		try {
			xhr = new ActiveXObject("Microsoft.XMLHTTP");
		} catch (e1) {
			xhr = false;
		}
	}
	if (!xhr)
		alert("初始化XMLHttpRequest对象失败！");
}


function ajaxValidate(phoneObj){
	createXHR();
	var url = "UserRegisterServlet";
	var content = "type=phoneAjaxValidate&phone=" + phoneObj.value;
	xhr.open("POST", url, true);
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			document.getElementById("phoneValidate").innerHTML = xhr.responseText;
		}
	};
	
}
	<!-- 注册的form表单提交前的,验证校验的js代码 -->

	function checkUserphone() {
        //1.获取手机号值
		var phone = $("#phone").val();
		//2.定义正则
		//var reg_phone = /^(13[0-9]|14[5|7]|15[0|1|2|3|4|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\d{8}$/;
		var reg_phone = /^[1](([3][0-9])|([4][5-9])|([5][0-3,5-9])|([6][5,6])|([7][0-8])|([8][0-9])|([9][1,8,9]))[0-9]{8}$/;
		//3.判断，给出提示信息
	    var flag = reg_phone.test(phone);
	    if(flag){
	        //手机号合法
            $("#phone").css("border","1px solid green");
		}else{
	        //手机号非法,加一个红色边框
			$("#phone").css("border","1px solid red");
			 
			
		}
	    
        return flag;
    }

    //校验密码
    function checkPassword() {
        //1.获取密码值
        var password = $("#password").val();
        //2.定义正则
        var reg_password = /^[a-zA-Z0-9]\w{5,17}$/;

        //3.判断，给出提示信息
        var flag = reg_password.test(password);
        if(flag){
            //密码合法
            $("#password").css("border","1px solid green");
        }else{
            //密码非法,加一个红色边框
            $("#password").css("border","1px solid red");
            $("#errorMsg").text("密码输入不合法，长度6到18位");
			
        }

        return flag;
    }

    
    function checkAgree(){
    	//1.获取是否同意
    	var agree = document.getElementById("agree");
    	var flag = true;
    	if(!agree.checked){
    		flag = false;
    		$("#errorMsg").text("请先同意服务条款");
		
    	}
    	return flag;
    }
    
    <!-- 注册的form表单提交前的,验证邮箱,密码校验的js代码 -->
	function validate() {
		if(checkUserphone() && checkPassword() && checkName() && checkIdcards() && checkAgree() ){
		    //校验通过,发送ajax请求，提交表单的数据
		    return true;
		    }else{
		    	return false;
		    } 
	}
	$(function(){
		//当某一个组件有焦点是，调用对应的提示
		$("#phone").focus(function() {
			$("#errorMsg").text("手机号格式，长度11位");
		});
        $("#password").focus(function() {
			$("#errorMsg").text("密码首位字母，长度6到18位");
		});

		//当某一个组件失去焦点是，调用对应的校验方法
		$("#phone").blur(checkUserphone);
        $("#password").blur(checkPassword);
      //获取表单对象，提交表单校验
        $("#registerForm").submit(function(){
            //调用校验用户名的方法
            return checkUserphone() && checkPassword() && checkAgree();
        })
	})



	//服务条款的显示跟隐藏
	function showdiv() {
		document.getElementById("bg").style.display = "block";
		document.getElementById("show").style.display = "block";
	}
	function hidediv() {
		document.getElementById("bg").style.display = "none";
		document.getElementById("show").style.display = "none";
	}
	//验证码的更换
	function changeValidateCode() {
		document.getElementById("validateCode").src = "ValidateCodeServlet?rand="
				+ Math.random();
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
	
	<!-- 注册部分开始 -->
	<div class="content">
		<div class="page_name">注册</div>
		<div class="login_content">
			<form action="UserRegisterServlet" method="post" onsubmit="return validate();">
				<div class="login_l">
					<div class="span1">
						<label class="tn-form-label">手机号：</label> 
						<input class="tn-textbox" type="text" name="phone" id="phone" onblur="ajaxValidate(this)">
						<label style="color: red" id="phoneValidate"></label>	
					</div>
					<div class="span1">
						<label class="tn-form-label">用户名：</label> 
						<input class="tn-textbox" type="text" name="name" id="name">
					</div>
					<div class="span1">
						<label class="tn-form-label">密码：</label> 
						<input class="tn-textbox" type="password" name="password" id="password">
					</div>
					<!-- 验证码相关的东西 -->
					<div class="span1">
						<label class="tn-form-label">验证码：</label> <input
							class="tn-textbox-long" type="text" name="verifyCode"> <span>
							<img src="ValidateCodeServlet"
							id="validateCode" title="点击换一换" onclick="changeValidateCode()">
							<a href="javascript:changeValidateCode();">看不清？</a>
						</span>
					</div>
					<!-- 注册功能 -->
					<div class="tn-form-row-button">  
						<div class="span1">
							<input name="submit" type="submit" class="tn-button-text"
								value="立即注册">
							<p class="it-register-text">
								<input name="agree" id="agree" class="tn-checkbox"
									checked="checked" type="checkbox"> <label>同意本站服务条款</label>
								<a href="javascript:showdiv();">查看</a>
							</p>
						</div>
					</div>
					<div class="clear"></div>
				</div>
			</form>
			<div class="login_r">
				<p align="center">
					<br> <b>已有帐号？</b><a href="login.jsp">登录</a>
				</p>
			</div>
		</div>
	</div>
	<!-- 注册部分结束 -->
	
	<!-- 服务条款部分开始 -->
	<div id="bg"></div>
	<div  id="show">
		<div style="text-align:center">
			服务条款<br />欢迎加入电信资费系统。<br />所有用户，只要进入电信资费系统注册，即被视为已经阅读、理解并同意本协议的以下各项条款。
		</div>
		免责条款：<br />第一条
		用户在本站登记的简历信息，必须完整、正确。出于遵守国家相关法规的前提，我们有权在不经用户准许的情况下删除其在本站所登记的信息。<br />第二条
		用户必须同意使用本站仅用于合法的目的。<br />第三条
		本站如因系统维护或升级而需暂停服务时，将事先公告。若因线路及非本公司控制范围外的硬件故障或其它不可抗力而导致暂停服务，于暂停服务期间造成的一切不便与损失，本站不负任何责任。<br />第四条
		本站使用者因为违反本声明的规定而触犯中华人民共和国法律的，一切后果自己负责，本站不承担任何责任。<br />第五条
		凡以任何方式登录本站或直接、间接使用本站的资料者，视为自愿接受本站声明的约束。本声明未涉及的问题参见国家有关法律法规，当本声明与国家法律法规冲突时，以国家法律法规为准。
		<div style="text-align:center">
			<input type="button" onclick="javascript:hidediv()"
				class="tn-button-text" value="我明白了">
		</div>
	</div>
	<!-- 服务条款部分结束 -->
	
	<!-- 网站公共尾部 -->
	<iframe src="foot.html" width="100%" height="150" scrolling="no"
		frameborder="0"></iframe>

</body>
</html>