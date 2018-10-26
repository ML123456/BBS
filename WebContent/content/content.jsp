<%@page import="service.UserDaoTest"%>
<%@page import="service.PinglunDaoTest"%>
<%@page import="entity.User"%>
<%@page import="service.ViaDaoTest"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="service.FatieDaoTest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>内容</title>
<link href="Head/images/favicon.ico" mce_href="Head/images/favicon.ico" rel='icon' type='image/x-icon'/>

<!------------------------------------修饰内容的css和分页的js--------------------------------------------->
<script type="text/javascript" language="javascript">
	window.onload = function() {
		page = new Page(6, 'table1', 'group_one');
	};
</script>
<link rel="stylesheet" type="text/css" href="content/css/css.css" />
<script type="text/javascript" src="content/js/js.js"></script>
<!---------------------------------修饰内容的css和分页的js--end------------------------------------------->

<!----------------------------------------------评论-------------------------------------------------->	
<script type="text/javascript" src="Head/login/js/jquery-3.2.1.js"></script>
<link type="text/css" rel="stylesheet" href="content/css/pinglun.css" />
<!--------------------------------------------评论-end------------------------------------------------>	

</head>
<!-- 调用FatieDaoTest.FatieQuery()方法获得所有发帖表信息，将其结果保存到list中 -->
<c:set var="list" scope="session" value="${FatieDaoTest.FatieQuery()}"/>

<body style="background-color:#f3f3f3;">
	<div class="all">
		<div class="content">
			<div class="left">
				<table id="table1">
					<tbody id="group_one">
					<!-- 遍历list -->
					<%-- <c:forEach items="${list}" var="list" begin="0" end="${fn:length(list)-1}"> --%>
					<c:forEach items="${list}" var="list">
						<tr style="height: auto">
							<td class="left-td-top">
								<div class="div-head">
									<span style="opacity: 0.5;">热门内容，来自：阅读</span>
                                	<span style="opacity: 0.5;position: relative;left: 360px">${list["time"]}</span>
								</div>
								<div class="div-namelogo">
								
								<!-- 调用ViaDaoTest.query(int userid)方法 获得对应的头像信息，将其保存在map中-->
								<c:set var="map" scope="session" value="${ViaDaoTest.query(list[\"userid\"])}"/>
								<!-- 获取map中的属性 -->
								<c:set var="str" scope="session" value="uploda/${map[\"photo\"]}"/>
								<!-- 获取list中的属性 -->
								<c:set var="str2" scope="session" value="uploda_Fatie/${list[\"photo\"]}"/>
								<c:set var="userid_others" scope="session" value="${list[\"userid\"]}"/>
								<c:set var="username" scope="session" value="${list[\"username\"]}"/>
								<c:set var="titles" scope="session" value="${list[\"titles\"]}"/>
								<c:set var="fcontent" scope="session" value="${list[\"fcontent\"]}"/>
								
								<!-- 判断str是否等于“uploda/” -->
								<c:if test="${str==\"uploda/\"}">
									<a href="#"><img class="img" src="content/img/name-logo.png"
										alt="用户头像" /></a>
								</c:if>
								<c:if test="${str!=\"uploda/\"}">
									<a href="others/others.jsp?uid=${userid_others}">
										<img class="img" src="${str}" alt="用户头像" />
									</a>
								</c:if>
								</div>
								<div class="div-name">
									<a href="others/others.jsp?uid=${userid_others}">
										<span class="yansebianhuan">${username}</span>
									</a>
								</div>
								<div class="div-title">
									<a href="#"><span class="yansebianhuan">${titles}</span></a>
								</div>
								<div class="div-content-icon">
									<a href="#"><img class="img" src="${str2}"
										alt="内容配图" /></a>
								</div>
								<div class="div-content">
									<span>
										${fcontent}
									 </span>
								</div>
								<div class="div-tail">
									<a href="#" class="yansebianhuan">987条评论</a>&nbsp;&nbsp;&nbsp;
									<a href="#" class="yansebianhuan">分享</a>&nbsp;&nbsp;&nbsp; 
									<a href="#" class="yansebianhuan">收藏</a>&nbsp;&nbsp;&nbsp; 
									<a href="#" class="yansebianhuan">举报</a>
								</div>
								<!-- 如果表达式的值为 true 则执行其主体内容。 -->
								<c:if test="${!empty user}">
									<form action="PinglunAdd">
										<div class="pinglun">
											<div class="input">
												<input type="hidden" name="userid" value="${user.userid}">
												<input type="hidden" name="byid" value="${list.fid}">
											    <input type="text" class="input-pinglun" name="pinglun_m" placeholder="写下你的评论..." required>
											</div>
											<div class="button">
											    <a href="index.jsp#">
											    	<span>
											    		<input type="submit" value="评论">
											    	</span>
											    </a>
											</div>
										</div>
									</form>
								</c:if>
								
								<c:set var="byid" scope="session" value="${list[\"fid\"]}"/>
								<!-- 调用PinglunDaoTest.PinglunQuery(int byid)方法获取到该帖子下的所有的评论，保存到list_p中 -->
								<c:set var="list_p" scope="session" value="${PinglunDaoTest.PinglunQuery(byid)}"/>
								
								<!-- 遍历list_p -->
								<%-- <c:forEach items="${list_p}" var="list_p" begin="0" end="${fn:length(list)-1}"> --%>
								<c:forEach items="${list_p}" var="list_p">
									<c:set var="userid_others" scope="session" value="${list_p[\"userid\"]}"/>
									<!-- 调用UserDaoTest.query(int userid)方法获取每一条评论对应的用户信息，保存到map2中。 -->
									<c:set var="map2" scope="session" value="${UserDaoTest.query(userid_others)}"/>
									<c:if test="${!empty map2}">
										<hr class="p-hr"/>
										<div class="p-xianshi">
											<p class="p1">
												<a href="others/others.jsp?uid=${userid_others}">${map2["name"]}</a>
											</p>
											<p class="p2">${list_p["pcontent"]}</p>
										</div>
										<br>
									</c:if>
								</c:forEach>
							</td>
						</tr>
						<tr style="height: auto">
                        	<td class="left-td-botton"></td>
                    	</tr>
					</c:forEach>
					</tbody>
				</table>
				<span id="s"></span>
				<table align="center" class="last-fenye">
					<tr>
						<td>
							<a href="index.jsp#" onclick="page.firstPage();" class="yanselast">首页</a>
							&nbsp;
						</td>
						<td>
							<a href="index.jsp#" onclick="page.prePage();" class="yanselast">上一页</a>
							&nbsp;
						</td>
						<td>
							<input type="text" id="seek" style="width: 25px;" />
							<a href="index.jsp#"
								onclick="page.aimPage(document.getElementById('seek').value-1);"
								class="yanselast">搜索</a>
							&nbsp;
						</td>
						<td>
							<a href="index.jsp#" onclick="page.nextPage();" class="yanselast">下一页</a>
							&nbsp;
						</td>
						<td>
							<a href="index.jsp#" onclick="page.lastPage();" class="yanselast">尾页</a>
						</td>
					</tr>
				</table>
				<br><br>
			</div>
		</div>
	</div>
</body>
</html>