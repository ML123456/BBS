<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% 
	String path = request.getContextPath(); 
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录、注册</title>
<!--------------login--------------->
<link type="text/css" rel="stylesheet" href="Head/login/css/style.css" />
<script type="text/javascript" src="Head/login/js/jquery-3.2.1.js"></script>
<!--------------login-end--------------->

<!---------------------------- 验证码 ------------------------------>
<script type="text/javascript">
	function reloadcode(){
		var verify = document.getElementById("code-img");
		verify.setAttribute("src","Head/makeCertPic.jsp?it="+Math.random());
	}
	function reloadcode2(){
		var verify2 = document.getElementById("code-img-r");
		verify2.setAttribute("src","Head/makeCertPic.jsp?it="+Math.random());
	}
</script>
<!---------------------------- 验证码-end ------------------------------>
</head>
<body>
<!--------------login--------------->
<div class="gray"></div>

<div class="popup" id="popup-r">

	<div class="top_nav" id='top_nav-r'>
		<div align="center">
			<i></i>
			<span>登录账号</span>
			<a class="guanbi"></a>
		</div>
	</div>

	<div class="min">
		<div class="tc_login">
			<div class="right">
				<form action="LoginServlet" method="get" name="form_login">
					<div>
						<i class="icon-mobile-phone"></i>
						<input type="text" name="name" id="name" required="required" placeholder="用户名" autocomplete="off" class="input_yh">
						<input type="password" name="pass" id="pass" required="required" placeholder="密码" autocomplete="off" class="input_mm">
						<input type="text" name="code" id="code" required="required" placeholder="验证码" autocomplete="off" class="input_co">
						<dd><img src="Head/makeCertPic.jsp" id="code-img" onclick="reloadcode()" alt="看不清楚，换一张"/></dd>
					</div>
					<div align="center">
						<input type="submit" class="button" value="登录">
					</div>
				</form>
			</div>
			<dd>
				<div align="center"><a href="index.jsp#" class="rc">立即注册</a></div>
			</dd>
		</div>
	</div>
</div>

<!--------------login-end--------------->

<!--------------register--------------->
<div class="gray-r"></div>

<div class="popup-r" id="popup">

	<div class="top_nav" id='top_nav'>
		<div align="center">
			<i></i>
			<span>注册账号</span>
			<a class="guanbi"></a>
		</div>
	</div>

	<div class="min">
		<div class="tc_login">
			<div class="right">
				<form action="LoginServlet" method="get" name="form_login">
					<div>
						<i class="icon-mobile-phone"></i>
						<input type="text" name="name" id="name-r" required="required" placeholder="用户名" autocomplete="off" class="input_yh">
						<input type="password" name="pass" id="pass-r" required="required" placeholder="密码" autocomplete="off" class="input_mm">
						<input type="password" name="qr_pass" id="qr-pass-r" required="required" placeholder="确认密码" autocomplete="off" class="input_qm">
						<input type="text" name="code" id="code-r" required="required" placeholder="验证码" autocomplete="off" class="input_co">
						<dd><img src="Head/makeCertPic.jsp" id="code-img-r" onclick="reloadcode2()" alt="看不清楚，换一张"/></dd>
					</div>
					<div align="center">
						<input type="submit" class="button" title="Sign In" value="注册">
					</div>
				</form>
			</div>
			<dd>
				<div align="center" class="register"><a href="index.jsp#" id="register" class="tc">登录</a></div>
			</dd>
		</div>
	</div>
</div>
<!--------------register-end--------------->
</body>
</html>