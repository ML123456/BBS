<%@page import="service.PinglunDaoTest"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="service.FatieDaoTest"%>
<%@page import="service.UserDaoTest"%>
<%@page import="java.util.Map"%>
<%@page import="service.ViaDaoTest"%>
<%@page import="entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
    
<% 
	String path = request.getContextPath(); 
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>他人主页</title>
<link href="Head/images/favicon.ico" mce_href="Head/images/favicon.ico" rel='icon' type='image/x-icon'/>
<link type="text/css" rel="stylesheet" href="others/css/css.css">
</head>
<body>
<div class="u-main">
<jsp:include page="../Head/head.jsp"></jsp:include>
    <div class="u-top">
        <div class="u-img">
            <img src="others/img/beijing.jpg"/>
        </div>
        <div class="u-myself">
            <div class="left">
                <div class="img">
	                <div>
	                <!-- 调用ViaDaoTest.query(int userid)方法获取到该登录用户的头像信息，保存到map中。查询头像信息 -->
	                <c:set var="map" scope="session" value="${ViaDaoTest.query(param.uid)}"/>
	                <c:set var="str" scope="session" value="uploda/${map[\"photo\"]}"/>
	                
	                <c:if test="${str==\"uploda/\"}">
                		<a href="myself/mycenter.jsp#" class="tou-xiang"><img src="others/img/touxiang.jpeg"/></a>
                	</c:if>
                	<c:if test="${str!=\"uploda/\"}">
                		<a href="myself/mycenter.jsp#" class="tou-xiang"><img src="${str}"/></a>
                	</c:if>
	                </div>
                </div>
            </div>
            
            <!-- 调用UserDaoTest.query(int userid)方法获取到登录用户的个人信息，保存到map2中。查询用户信息 -->
            <c:set var="map2" scope="session" value="${UserDaoTest.query(param.uid)}"/>
            <div class="right">
                <div class="zuo">
                    <div>
                        <p class="p1">
                            <span class="span-1">${map2["name"]}</span>
                            <span class="span-1-1">克己复礼</span>
                        </p>
                        <p class="p2">
                            <span class="span-2">居住地</span>
                            <span class="span-2-2">${map2["family"]}</span>
                        </p>
                        <p class="p3">
                            <span class="span-3">个人简介</span>
                            <span class="span">${map2["intro"]}</span>
                        </p>
                        <p class="p4">
                            <span class="span-4">电子邮件</span>
                            <span class="span">${map2["email"]}</span>
                        </p>
                        <p class="p5">
                            <span class="span-5">所在行业</span>
                            <span class="span">计算机软件</span>
                        </p>
                    </div>
                </div>
            </div>
        </div>

        <div class="u-botton">
            <div class="u-tiezi">
	            <div>
	            	<span>下面是他的动态↓</span>
	            </div>
            </div>
            <!-- 调用FatieDaoTest.QueryId(userid)方法获取到该登录用户发过的所有的帖子，保存到lis中。查询该用户发帖信息 -->
            <c:set var="list" scope="session" value="${FatieDaoTest.QueryId(param.uid)}"/>
            <!-- 遍历list -->
            <c:forEach items="${list}" var="list">
            <!-- 获取list中的属性 -->
            	<c:set var="str2" scope="session" value="uploda_Fatie/${list[\"photo\"]}"/>
            	<c:set var="fid" scope="session" value="${list[\"fid\"]}"/>
            	<c:set var="titles" scope="session" value="${list[\"titles\"]}"/>
            	<c:set var="time" scope="session" value="${list[\"time\"]}"/>
            	<c:set var="fcontent" scope="session" value="${list[\"fcontent\"]}"/>
	            <div class="u-suibi">
	                <div class="shang-1">
	                    <span class="span-1">${titles}</span>
	                </div>
	                <div class="shang-2">
	                	<span class="span-2">${time}</span>
	                </div>
	                <div class="zhong">
	                    <span>${fcontent}</span>
	                </div>
	                <div class="img">
	                	<img alt="" src="${str2}"/>
	                </div>
	            </div>
	        
	        	<!-- 调用PinglunDaoTest.PinglunQuery(int byid)方法获取到该帖子下的所有的评论，保存到list_p中 -->
		        <c:set var="list_p" scope="session" value="${PinglunDaoTest.PinglunQuery(fid)}"/>
		        <!-- 遍历list_p -->
		        <c:forEach items="${list_p}" var="list_p">
		        	<c:set var="userid" scope="session" value="${list_p[\"userid\"]}"/>
		        	<!-- 调用UserDaoTest.query(int userid)方法获取到每一个评论对应的用户信息，保存到map2中 -->
					<c:set var="map3" scope="session" value="${UserDaoTest.query(userid)}"/>
					<c:if test="${!empty map3}">
						<!-- 获取map3中的（用户）属性 -->
						<c:set var="userid_others" scope="session" value="${map3[\"userid\"]}"/>
						<c:set var="name" scope="session" value="${map3[\"name\"]}"/>
						<!-- 获取list_p中的（评论）属性 -->
						<c:set var="pcontent" scope="session" value="${list_p[\"pcontent\"]}"/>
						<c:set var="pid" scope="session" value="${list_p[\"pid\"]}"/>
						<hr class="myself-hr">
						<div class="myself-p">
							<p class="name">
								<a href="others/others.jsp?uid=${userid_others}">${name}</a>
							</p>
							<p class="pcontent">${pcontent}</p>
						</div>
					</c:if>
				</c:forEach>
	            <hr class="f-hr"/>
            </c:forEach>
            <br>
        </div>
    </div>
</div>
</body>
</html>