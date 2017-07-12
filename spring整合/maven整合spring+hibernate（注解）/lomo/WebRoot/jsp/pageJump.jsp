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
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<%=basePath %>js/bootstrap/dist/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="<%=basePath %>js/bootstrap/dist/css/bootstrap-theme.min.css">
<link rel="stylesheet" type="text/css" href="<%=basePath %>js/validate/dist/jquery.validate.min.css">
<script type="text/javascript" src="<%=basePath %>js/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath %>js/bootstrap/dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=basePath %>js/validate/dist/jquery.validate.min.js"></script>
<script type="text/javascript" src="<%=basePath %>js/validate/dist/additional-methods.min.js"></script>
<script type="text/javascript" src="<%=basePath %>js/validate/dist/localization/messages_zh.min.js"></script>
<style type="text/css">
.css1{background: rgba(90, 8, 8, 0.2);width:400px;margin:100px auto;}
</style>
<script type="text/javascript">     
function countDown(secs,surl){     
 //alert(surl);     
 var jumpTo = document.getElementById('jumpTo');
 jumpTo.innerHTML=secs;  
 if(--secs>0){     
     setTimeout("countDown("+secs+",'"+surl+"')",1000);     
     }     
 else{       
     location.href=surl;     
     }     
 }     
</script> 
</head>
</head>
<body>
<div class="container center-block">
		<div class="css1 row">
		<p class="text-muted" style="font-size: 30px;">登入成功，点击跳转：</p>
			
			<button type="button" class="btn btn-success">Success</button><br>
			<span id="jumpTo">5</span>秒后自动跳转到主页
            <script type="text/javascript">countDown(5,'main.action');</script>
			
		</div>

</div>


</body>
</html>