<%@page import="entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!--------------绝对路径--------------->
<% 
	String path = request.getContextPath(); 
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
%> 
<!--------------绝对路径-end--------------->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<base href="<%=basePath%>">
	<title>论坛头部</title>
	<meta name="description" content="Free Responsive Html5 Css3 Templates Designed by Kimmy | zerotheme.com">
	<meta name="author" content="sc.chinaz.com">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    
    <!-- CSS================================================== -->
  	<link rel="stylesheet" href="Head/css/zerogrid.css">
	<link rel="stylesheet" href="Head/css/style.css">
	<link rel="stylesheet" href="Head/css/css.css">
    <link rel="stylesheet" href="Head/css/responsive.css">
	
	<link href="Head/images/favicon.ico" mce_href="Head/images/favicon.ico" rel='icon' type='image/x-icon'/>

</head>
<body>

<div class="wrap-body">
<!----------------------------Header------------------------------------>
<header>
	<div class="wrap-header zerogrid">
		<div id="logo"><a href="index.jsp"><img src="Head/images/logo.png"/></a></div>
		<nav>
			<div class="wrap-nav">
				<div class="menu">
					<ul>
						<li><a href="index.jsp">首页</a></li>
						<li><a href="index.jsp#">个人</a></li>
						<li><a href="index.jsp#">关于</a></li>
						<li><a href="index.jsp#">联系</a></li>
						
						<c:if test="${empty user}">
							<li><a href="index.jsp#" class="tc">登录</a></li>
						</c:if>
						<c:if test="${!empty user}">
							<li class="menu1">
							<a href="#">${user.getName()}</a>
							 <ul class="menu2">
				                <li class="list2"><a href="myself/mycenter.jsp">个人主页</a></li>
				                <li class="list2"><a href="Exit">退出</a></li>
				            </ul>	
							</li>
						</c:if>
					</ul>
				</div>
			</div>
		</nav>
	</div>
</header>
<!----------------------------Header-end------------------------------------>

<!----------------------- 登录、注册 ------------------------------->
<jsp:include page="../Head/login/login.jsp"></jsp:include>
<script type="text/javascript" src="Head/login/js/js.js"></script>
<!----------------------- 登录、注册-end ------------------------------->

</div>
</body>
</html>