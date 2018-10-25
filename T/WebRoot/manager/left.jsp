<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="js/jquery.js"></script>

<script type="text/javascript">
$(function(){	
	//导航切换
	$(".menuson li").click(function(){
		$(".menuson li.active").removeClass("active")
		$(this).addClass("active");
	});
	
	$('.title').click(function(){
		var $ul = $(this).next('ul');
		$('dd').find('ul').slideUp();
		if($ul.is(':visible')){
			$(this).next('ul').slideUp();
		}else{
			$(this).next('ul').slideDown();
		}
	});
})	
</script>


</head>

<body style="background:#f0f9fd;">
	<div class="lefttop"><span></span></div>
    
    <dl class="leftmenu">
        
    <dd>
    <div class="title">
    <span><img src="images/leftico01.png" /></span>管理信息
    </div>
    	<ul class="menuson">
        <li class="active"><cite></cite><a href="index.jsp" target="rightFrame">首页模版</a><i></i></li>
        <li><cite></cite><a href="ListNews?op=listNews" target="rightFrame">新闻列表</a><i></i></li>
        <li><cite></cite><a href="ListClass?op=listClass" target="rightFrame">新闻分类</a><i></i></li>
        <li><cite></cite><a href="ListNews?op=preAdd" target="rightFrame">新增新闻</a><i></i></li>
        <li><cite></cite><a href="ListClass?op=add" target="rightFrame">新增分类</a><i></i></li>
        <li><cite></cite><a href="ListManager?op=listManager" target="rightFrame">管理员管理</a><i></i></li>
        <li><cite></cite><a href="ListUser?op=listUser" target="rightFrame">用户管理</a><i></i></li>
        </ul>    
    </dd>
        
    </dl>
</body>
</html>
