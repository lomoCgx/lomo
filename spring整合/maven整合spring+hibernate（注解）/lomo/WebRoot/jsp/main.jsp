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
<link rel="stylesheet" type="text/css" href="<%=basePath %>js/zTree/css/zTreeStyle/metro.css">
<script type="text/javascript" src="<%=basePath %>js/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath %>js/bootstrap/dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=basePath %>js/validate/dist/jquery.validate.min.js"></script>
<script type="text/javascript" src="<%=basePath %>js/validate/dist/additional-methods.min.js"></script>
<script type="text/javascript" src="<%=basePath %>js/validate/dist/localization/messages_zh.min.js"></script>
<script type="text/javascript" src="<%=basePath %>js/zTree/js/jquery.ztree.all-3.5.min.js"></script>

<title>Insert title here</title>
</head>
<body>

<nav class="navbar navbar-default navbar-fixed-top" >
  <div class="container" style="padding-bottom: 0px;">
   <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">Brand</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">Link <span class="sr-only">(current)</span></a></li>
        <li><a href="#">Link</a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">Action</a></li>
            <li><a href="#">Another action</a></li>
            <li><a href="#">Something else here</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">Separated link</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">One more separated link</a></li>
          </ul>
        </li>
      </ul>
      <form class="navbar-form navbar-left">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Search">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
      </form>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#">Link</a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">Action</a></li>
            <li><a href="#">Another action</a></li>
            <li><a href="#">Something else here</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">Separated link</a></li>
          </ul>
        </li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div>
</nav>

<div class="container-fluid">
    <div class="row" style="padding-top: 60px;">
  <div class="col-md-2" style="background-color: aliceblue;height: 550px;">
       
       <!-- 初始化树状结构 -->					
					<div class="input-group input-group-sm">
      <input type="text" class="form-control" placeholder="Search for...">
      <span class="input-group-btn">
        <button class="btn btn-default" type="button">Go!</button>
      </span>
    </div><!-- /input-group -->
       <div id="menuTree" class="ztree" style="padding:5px 0px;"></div>
					<script type="text/javascript">
					$(document).ready(function() {
						
						var setting = {
							data: {
								simpleData: {
									enable: true
								}
							}
						};
						
						var zNodes = [
				         	{id:1, pId:0, name: "例子页面",open:true},
				         	{id:12, pId:1, name: "树类测试",url:'<%=basePath %>tree/show.action',target:'mainFrame'},
				         	{id:13, pId:1, name: "列表页",url:'${ctx }/demo/list',target:'mainFrame'},
				         	{id:14, pId:1, name: "树结构",url:'${ctx }/demo/tree',target:'mainFrame'},
				         	{id:15, pId:1, name: "表单验证",url:'${ctx }/demo/formvalidator',target:'mainFrame'},
				         	{id:17, pId:1, name: "表单验证DATE-RULE",url:'${ctx }/demo/daterulevalidator',target:'mainFrame'},
				         	{id:16, pId:1, name: "图表",url:'${ctx }/demo/echart',target:'mainFrame'},
				         	{id:18, pId:1, name: "直接返回JSON",url:'${ctx }/demo/jsonbody',target:'mainFrame'},
				         	{id:19, pId:1, name: "文件上传",url:'${ctx }/demo/tofileuploader',target:'mainFrame'},
				         	{id:20, pId:1, name: "GRID组件",url:'${ctx }/grid/xmlgrid',target:'mainFrame'},
				         	{id:11, pId:1, name: "增删改查示例",url:'${ctx }/subsys/crud/list',target:'mainFrame'},
				         	
				         	{id:2, pId:0, name: "产品价格中心",open:true},
				         	{id:22, pId:2, name: "产品简码维护",url:'${ctx }/ppc/productsname/list',target:'mainFrame'},
				         	{id:23, pId:2, name: "可售卖产品维护",url:'${ctx }/ppc/product/list',target:'mainFrame'},
				         	{id:24, pId:2, name: "产品分类维护",url:'${ctx }/ppc/productcategary/list',target:'mainFrame'},
				         	{id:26, pId:2, name: "邮资套维护",url:'${ctx }/ppc/postagesuite/list',target:'mainFrame'},
				         	{id:27, pId:2, name: "产品信息查询",url:'${ctx}/ppc/productquery/list',target:'mainFrame'},
				         	{id:28, pId:2, name: "计费区维护",url:'${ctx }/ppc/feearea/list',target:'mainFrame'},
				         	{id:29, pId:2, name: "通达区维护",url:'${ctx }/ppc/coverage/list',target:'mainFrame'},
				         	{id:210, pId:2, name: "营销资费维护",url:'${ctx }/ppc/marketing/list',target:'mainFrame'}
				         ];
						
						$.fn.zTree.init($("#menuTree"), setting, zNodes);
					});
					</script>
					
					<!-- 初始化树状结构结束 -->
					
				
				
  </div>
  <div class="col-md-10" style="height: 550px;padding-left: 5px;padding-right: 5px;">
  <iframe id="mainFrame" name="mainFrame" src="<%=basePath %>jsp/welcome.jsp" style="overflow:visible;" scrolling="yes" frameborder="no" width="100%" height="550"></iframe>
  </div>
</div>
</div>

</body>
</html>