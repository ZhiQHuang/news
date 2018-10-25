<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>

</head>


<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    </ul>
    </div>
    
    <div class="mainindex">
    
    
    <div class="welinfo">
    <span><img src="images/sun.png" alt="天气" /></span>
    <b>您好，欢迎使用信息管理系统</b>
    </div>
    
    <div class="xline"></div>
    <div class="box"></div>
    
    <div class="welinfo">
    <span><img src="images/dp.png" alt="提醒" /></span>
    <b>信息管理系统使用指南</b>
    </div>
    
    <ul class="infolist">
    <li><span>您可以快速进行文章发布管理操作</span><a class="ibtn" href="ListNews?op=preAdd">发布或管理文章</a></li>
    <li><span>您可以进行密码修改</span><a class="ibtn" href="changePassword.jsp">账户管理</a></li>
    </ul>
    
    <div class="xline"></div>
    
    <div class="info"><b>系统设置</b></div>
    
    <ul class="umlist">
    <li><a href="ListManager?op=list">管理员的管理</a></li>
    <li><a href="ListUser?op=main">新闻用户的管理</a></li>
    <li><a href="ListClass?op=list">新闻分类的管理</a></li>    
    </ul>
    
    
    </div>
</body>
</html>
