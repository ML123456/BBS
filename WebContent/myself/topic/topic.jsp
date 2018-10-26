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
<title>发帖</title>
<link rel="stylesheet" rel="stylesheet" href="myself/topic/css/styles.css" >
<script type="text/javascript" src="myself/edit/js/jquery-3.2.1.js"></script>

<script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
<script src="myself/topic/js/js.js"></script>

</head>
<body>
<div class="b-body">
    <div align="center" class="f-center">
        <div class="img">
            <a href="myself/mycenter.jsp#" class="f-guanbi">
                <img src="myself/topic/images/popup_guanbi.png"/>
            </a>
        </div>
    <table border="1" width="47%" height="250" style="border-width: 0px;">
        <tr>
            <td style="border-style: none; border-width: medium">
                <form class="contact_form" action="FatieAdd" name="contact_form" method="post" enctype="multipart/form-data">
                    <ul>
                        <li>
                             <h2>发帖</h2>
                             <span class="required_notification">* 表示必填项</span>
                        </li>
                        <li>
                            <label for="titles">标题:</label>
                            <input type="text" name="titles" maxlength="26" placeholder="标题(不得多于26个文字)" required />
                        </li>
                        <li>
                            <label for="fcontent">内容:</label>
                            <textarea name="fcontent" cols="40" rows="10" placeholder="内容" required ></textarea>
                        </li>
                        <li>
                            <label for="img">图片（<span style="color: red;">必选项</span>）:</label>
                            <div id="f_preview">
                                <a href="myself/mycenter.jsp#">
                                    <img id="f_imghead" src="myself/topic/images/photo_icon.png" onclick="$('#f_previewImg').click();">
                                </a>
                            </div>
                            <input type="file" onchange="f_previewImage(this)" style="display: none;" id="f_previewImg" name="previewImg" required>
                        </li>
                        <li>
                            <button class="submit" type="submit">发帖</button>
                            <button class="submit" type="reset">清空</button>
                        </li>
                    </ul>
                </form>
            </td>
        </tr>
    </table>
    </div>
</div>
</body>
</html>