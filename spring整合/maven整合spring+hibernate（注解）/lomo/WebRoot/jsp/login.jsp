<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登入首页</title>
<link rel="stylesheet" type="text/css" href="<%=basePath %>js/bootstrap/dist/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="<%=basePath %>js/bootstrap/dist/css/bootstrap-theme.min.css">
<link rel="stylesheet" type="text/css" href="<%=basePath %>js/validate/dist/jquery.validate.min.css">

<script type="text/javascript" src="<%=basePath %>js/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath %>js/bootstrap/dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=basePath %>js/validate/dist/jquery.validate.min.js"></script>
<script type="text/javascript" src="<%=basePath %>js/validate/dist/additional-methods.min.js"></script>
<script type="text/javascript" src="<%=basePath %>js/validate/dist/localization/messages_zh.min.js"></script>


<style type="text/css">
body{
   background: url("<%=basePath %>image/4.jpg") no-repeat;background-size: cover;font-size: 16px;
}
.form{background: rgba(255,255,255,0.2);width:400px;margin:100px auto;}
#login_form{display: block;}
#register_form{display: none;}
.fa{display: inline-block;top: 27px;left: 6px;position: relative;color: #ccc;}
input[type="text"],input[type="password"]{padding-left:26px;}
.checkbox{padding-left:21px;}
label.error{background:url("<%=basePath %>js/validate/dist/images/unchecked.gif") no-repeat 0;padding-top: 4px;}
</style>



<script type="text/javascript">

   $(function(){
	   $("#register_btn").click(function(){
		   $("#login_form").css("display","none");
		   $("#register_form").css("display","block");
		   $("#div_login_form").css("display","none");
		   $("#div_register_form").css("display","block");
	   });
	   $("#back_btn").click(function(){
		   $("#login_form").css("display","block");
		   $("#register_form").css("display","none");
		   $("#div_login_form").css("display","none");
		   $("#div_register_form").css("display","block");
	   });
	   
	   
	$("#login_form").validate({

			rules : {
				username : {
					required : true,
					remote : {
						url : "isExistUsername.action",
						type : "get",
						cache : false,
						dataType : "json",
						data : {
							username : function() {
								return $("#username").val();
							}
						}
					}
				},
				password : {
					required : true,
					minlength : 6
				}
			},
			message : {
				username : {
					username : "请输入姓名",
					remote: "该用户名已经存在"
				},
				password : {
					required : "请输入密码",
					minlength : $.validator.format("密码不能少于{0}个字符")
				}
			}
		});

		$("#register_form").validate({
			rules : {
				username : {
					required : true,
					remote : {
						url : "isExistUsername.action",
						type : "get",
						cache : false,
						dataType : "json",
						data : {
							username : function() {
								return $("#register_username").val();
							}
						}
					}
				},
				password : {
					required : true,
					minlength : 6
				},
				password : {
					equalTo : "#register_password"
				},
				email : {
					required : true,
					email : true
				}
			},
			messages : {
				username : {
					username : "请输入姓名",
					remote: "该用户名已经存在"
				},
				password : {
					required : "请输入密码",
					minlength : $.validator.format("密码不能小于{0}个字 符")
				},
				rpassword : {
					equalTo : "两次密码不一样"
				},
				email : {
					required : "请输入邮箱",
					email : "请输入有效邮箱"
				}
			}
		});

		//自定义一个验证方法
		/* $.validator.addMethod("formula", //验证方法名称
		function(value, element, param) {//验证规则
			return value == eval(param);
		}, '请正确输入数学公式计算后的结果'//验证提示信息
		); */

	})
</script>


</head>
<body>
<div class="container">
		<div class="form row" id="div_login_form">
			<form class="form-horizontal col-sm-offset-3 col-md-offset-3" action="login.action" method="post" id="login_form">
				<h3 class="form-title">登入用户</h3>
				<div class="col-sm-9 col-md-9">
					<div class="form-group">
						<i class="fa fa-user fa-lg"></i>
						<input class="form-control required" type="text" placeholder="用户名" name="username" autofocus="autofocus" maxlength="20"/>
					</div>
					<div class="form-group">
							<i class="fa fa-lock fa-lg"></i>
							<input class="form-control required" type="password" placeholder="密码" name="password" maxlength="8"/>
					</div>
					<div class="form-group">
						<label class="checkbox">
							<input type="checkbox" name="remember" value="1"/> 记住密码
						</label>
						<hr />
						<a href="javascript:;" id="register_btn" class="">创建用户</a>
					</div>
					<div class="form-group">
						<input type="submit" class="btn btn-success pull-right" value="登入 "/>   
					</div>
					
				</div>
				
			</form>
			
		</div>

		<div class="form row" id="div_register_form">
			<form class="form-horizontal col-sm-offset-3 col-md-offset-3" id="register_form" action="register.action" method="post">
				<h3 class="form-title">注册用户</h3>
				<div class="col-sm-9 col-md-9">
					<div class="form-group">
						<i class="fa fa-user fa-lg"></i>
						<input class="form-control required" type="text" placeholder="用户名" name="username" id="register_username" autofocus="autofocus"/>
					</div>
					<div class="form-group">
							<i class="fa fa-lock fa-lg"></i>
							<input class="form-control required" type="password" placeholder="密码" id="register_password" name="password"/>
					</div>
					<div class="form-group">
							<i class="fa fa-check fa-lg"></i>
							<input class="form-control required" type="password" placeholder="重新输入密码" name="rpassword"/>
					</div>
					<div class="form-group">
							<i class="fa fa-envelope fa-lg"></i>
							<input class="form-control eamil" type="text" placeholder="邮箱" name="email"/>
					</div>
					<div class="form-group">
						<input type="submit" class="btn btn-success pull-right" value="注册 "/>
						<input type="submit" class="btn btn-info pull-left" id="back_btn" value="返回"/>
					</div>
				</div>
			</form>
		</div>
</div>
</body>
</html>