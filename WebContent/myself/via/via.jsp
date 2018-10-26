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
<title>上传头像</title>
<link type="text/css" rel="stylesheet" href="myself/via/css/css.css">
<script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
<script src="myself/via/js/js.js"></script>
</head>
<body>
<div id="addCommodityIndex">
	<a href="myself/mycenter.jsp#" class="guanbi-i">
        <img class="img" src="myself/img/popup_guanbi.png">
    </a>
    <div id="preview">
        <a href="myself/mycenter.jsp#">
        	<img id="imghead"  src="myself/img/photo_icon.png" onclick="$('#previewImg').click();">
        </a>
    </div>
    <form action="UserPhoto" name="myform" method="post" enctype="multipart/form-data">
        <input type="file" onchange="previewImage(this)" style="display: none;" 
        	id="previewImg" name="myfile" required>
        <div class="tijiao">
            <a href="myself/via/via.jsp#" class="tijiao-a">
                <input type="submit" value="更换头像">
            </a>
        </div>
    </form>
</div>
</body>
</html>