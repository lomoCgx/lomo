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
<link rel="stylesheet" type="text/css" href="<%=basePath %>js/bootstrap/dist/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="<%=basePath %>js/bootstrap/dist/css/bootstrap-theme.min.css">
<link rel="stylesheet" type="text/css" href="<%=basePath %>js/validate/dist/jquery.validate.min.css">
<script type="text/javascript" src="<%=basePath %>js/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath %>js/bootstrap/dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=basePath %>js/validate/dist/jquery.validate.min.js"></script>
<script type="text/javascript" src="<%=basePath %>js/validate/dist/additional-methods.min.js"></script>
<script type="text/javascript" src="<%=basePath %>js/validate/dist/localization/messages_zh.min.js"></script>

<title>Insert title here</title>
</head>
<body>
	<div class="jumbotron">
		<div class="container">
			<h1>Hello, world!</h1>
			<p>...</p>
			<p>
				<a class="btn btn-primary btn-lg" href="#" role="button">Learn
					more</a>
			</p>
		</div>
	</div>
</body>
</html>