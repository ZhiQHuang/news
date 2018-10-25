<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>注册</title>
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery.min.js"></script>
<!-- Custom Theme files -->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<!-- Custom Theme files -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Express News Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- for bootstrap working -->
	<script type="text/javascript" src="js/bootstrap.js"></script>
<!-- //for bootstrap working -->
<!-- web-fonts -->
<link href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic' rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Varela+Round' rel='stylesheet' type='text/css'>

<script type="text/javascript" src="jquery-1.11.1.min.js"></script>
<script src="js/responsiveslides.min.js"></script>
<script type="text/javascript" src="jquery.validate.js"></script>
	<script>
		$(function () {
		  $("#slider").responsiveSlides({
			auto: true,
			nav: true,
			speed: 500,
			namespace: "callbacks",
			pager: true
		  });
		});
	</script>
	<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
<!--/script-->
<script type="text/javascript">
			jQuery(document).ready(function($) {
				$(".scroll").click(function(event){		
					event.preventDefault();
					$('html,body').animate({scrollTop:$(this.hash).offset().top},900);
				});
			});
			
			function checkName(){
				var username=$("#username").val();
				$.post("Front?op=checkName",{"username":username},
						function(data){
							$("#checkResult").html(data);
						});
			}
			
			$().ready(function(){
				$("#regform1").validate({
					rules:{
						username:{required:true,rangelength:[6,12]},
						password:{required:true,rangelength:[6,12]},
						repassword:{required:true,rangelength:[6,12]},
						question:{required:true},
						answer:{required:true},
						emailAddr:{required:true,email:true},
						qq:{required:true,digits:true},
						vericode:{required:true}
					},
					messages:{
						username:{required:"请输入用户名",
							rangelength:$.validator.format("请输入一个长度介于{0}和{1}之间的用户名")},
						password:{required:"请输入密码",
							rangelength:$.validator.format("请输入一个长度介于{0}和{1}之间的密码")},
						repassword:{required:"请输入确认密码",
							rangelength:$.validator.format("请输入一个长度介于{0}和{1}之间的确认密码"),
							equalTo:"请输入与密码相同的值"},
						question:{required:"请输入密码提示问题"},
						answer:{required:"请输入密码提示答案"},
						emailAddr:{required:"请输入电子邮件",email:"请输入正确的电子邮件地址"},
						qq:{required:"请输入qq号",digits:"请输入正确的QQ号"},
						vericode:{required:"请输入验证码"}
					},
					submitHandler:function(form){
						form.submit();
					}
				});
			});
			
			function refresh(){
				var src=$("#img1").attr("src");
				$("#img1").attr("src",src+"?"+new Date());
			}
</script>
</head>
<body>
	<!-- header-section-starts-here -->
	<div class="header">
		<div class="header-top">
			<div class="wrap">
				<div class="top-menu">
					<ul>
						<li><a href="Front?op=main">首页</a></li>
						<li><a href="about.jsp">关于我们</a></li>
						<li><a href="privacy-policy.jsp">隐私条款</a></li>
						<li><a href="contact.jsp">联系我们</a></li>
					</ul>
				</div>
				<div class="num">
					<p> 联系电话 : 032 2352 782</p>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
		<div class="header-bottom">
			<div class="logo text-center">
				<a href="Front?op=main"><img src="images/logo.jpg" alt="" /></a>
			</div>
			<div class="navigation">
				<nav class="navbar navbar-default" role="navigation">
		   <div class="wrap">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				
			</div>
			<!--/.navbar-header-->
		
			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li class="active"><a href="Front?op=main">首页</a></li>
            		<li><a href="Front?op=listByClass&classId=1">JavaWeb</a><li>
            		<li><a href="Front?op=listByClass&classId=2">物联网</a><li>
            		<li><a href="Front?op=listByClass&classId=3">Android</a><li>
            		<li><a href="Front?op=listByClass&classId=4">数据库</a><li>
            		<li><a href="Front?op=listByClass&classId=5">系统网络安全</a><li>
            		<li><a href="Front?op=listByClass&classId=6">Web前端</a><li>
					<div class="clearfix"></div>
				</ul>
				<div class="search">
					<!-- start search-->
				    <div class="search-box">
					    			<div id="sb-search" class="sb-search">
										<form action="Front?op=query" method="post">
											<input class="sb-search-input" type="text" name="q" size="10" id="searchfield" title="searchfield" />
											<input class="sb-search-submit" type="submit" value="" alt="Search" id="searchbutton" value="thissite">
											<span class="sb-icon-search"></span>
										</form>
									</div>
				   				 </div>

					<!-- search-scripts -->
					<script src="js/classie.js"></script>
					<script src="js/uisearch.js"></script>
						<script>
							new UISearch( document.getElementById( 'sb-search' ) );
						</script>
					<!-- //search-scripts -->
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
			<!--/.navbar-collapse-->
	 <!--/.navbar-->
			</div>
		</nav>
		</div>
	</div>
	<!-- header-section-ends-here -->
	<div class="wrap">
		<div class="move-text">
			<div class="breaking_news">
				<h2>爆 炸 新 闻</h2>
			</div>
			<div class="marquee">
				<div class="marquee1"><a class="breaking" href="Front?op=displayNews&newsId=121">>>谈一谈反范式设计下简单高效的冗余数据刷新思路1</a></div>
				<div class="marquee2"><a class="breaking" href="Front?op=displayNews&newsId=107">>>Java实现二叉树和常见的排序</a></div>
				<div class="clearfix"></div>
			</div>
			<div class="clearfix"></div>
			<script type="text/javascript" src="js/jquery.marquee.min.js"></script>
			<script>
			  $('.marquee').marquee({ pauseOnHover: true });
			  //@ sourceURL=pen.js
			</script>
		</div>
	</div>
	<!-- content-section-starts-here -->
	<div class="main-body">
		<div class="wrap">
		<ol class="breadcrumb">
			  <li><a href="index.html">Home</a></li>
			  <li class="active">注册</li>
			</ol>
			<!-- 注册start -->
			<div class="col-md-8 content-left">
			<div class="articles sports">
					<header>
						<h3 class="title-head">注册</h3>
					</header>
					 <div class="article">
						 <div id="templatemo_newsletter_section">
             			 <form method="post" action="Front?op=regist" style="font-size: 13px" id="regform1">
                        
                        <div class="form_row">
                        <label>用户名</label>
                        <input class="inputfield" name="username" type="text" id="username" 
                        	onblur="javascript:checkName()" />
                        <br/>
                        <div id="checkResult" style="color:red"></div>
                        <br/>
                        <label>密码</label>
                        <input class="inputfield" name="password" type="password" id="password"/><br/><br/>
                         <label>确认密码</label>
                        <input class="inputfield" name="repassword" type="password" id="repassword"/><br/><br/>
                        <label>性别</label>
                        <select class="inputfield" name="sex" style="font-size: 13px">
                        	<option value="男">男</option>
                        	<option value="女">女</option>
                        </select>
                         <br/><br/>
                         <label>密码提示问题</label>
                        <input class="inputfield" name="question" type="text" id="question"/><br/><br/>
                         <label>密码提示答案</label>
                        <input class="inputfield" name="answer" type="text" id="answer"/><br/><br/>
                         <label>电子邮件地址</label>
                        <input class="inputfield" name="emailAddr" type="text" id="emailAddr"/><br/><br/>
                         <label>QQ</label>
                        <input class="inputfield" name="qq" type="text" id="qq"/><br/><br/>
                        <label></label>
                        <img alt="" src="VerifyCode" id="img1" onclick="javascript:refresh()">
                        <label>验证码</label>
                        <input class="inputfield" name="vericode" type="text" id="vericode"/><br/><br/>
                        </div>
                        
                       <input class="button" type="submit" name="Submit" value="注册" />&nbsp;&nbsp;
                       <input class="button" type="reset" name="reset" value="重置" />
                       <br/><br/>
                                                                    
                       </form>
			  		   </div>    
				  </div> 
		</div>
		</div>
			
			<!-- 注册end -->
			
			<div class="col-md-4 side-bar">
			<div class="first_half">
				
				
				<jsp:include page="prelogin.jsp"></jsp:include>
				

				<jsp:include page="class.jsp"></jsp:include>
				
				
			</div>
					 
					<div class="clearfix"></div>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
	<!-- content-section-ends-here -->
	<!-- footer-section-starts-here -->
	<div class="footer">
		<div class="footer-top">
			<div class="wrap">
				<div class="col-md-3 col-xs-6 col-sm-4 footer-grid">
					<h4 class="footer-head">About Us</h4>
					<p>It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout.</p>
					<p>The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here.</p>
				</div>
				<div class="col-md-2 col-xs-6 col-sm-2 footer-grid">
					<h4 class="footer-head">Categories</h4>
					<ul class="cat">
						<li><a href="business.html">Business</a></li>
						<li><a href="technology.html">Technology</a></li>
						<li><a href="entertainment.html">Entertainment</a></li>
						<li><a href="sports.html">Sports</a></li>
						<li><a href="shortcodes.html">Health</a></li>
						<li><a href="fashion.html">Fashion</a></li>
					</ul>
				</div>
				<div class="col-md-4 col-xs-6 col-sm-6 footer-grid">
					<h4 class="footer-head">Flickr Feed</h4>
					<ul class="flickr">
						<li><a href="#"><img src="images/bus4.jpg"></a></li>
						<li><a href="#"><img src="images/bus2.jpg"></a></li>
						<li><a href="#"><img src="images/bus3.jpg"></a></li>
						<li><a href="#"><img src="images/tec4.jpg"></a></li>
						<li><a href="#"><img src="images/tec2.jpg"></a></li>
						<li><a href="#"><img src="images/tec3.jpg"></a></li>
						<li><a href="#"><img src="images/bus2.jpg"></a></li>
						<li><a href="#"><img src="images/bus3.jpg"></a></li>
						<div class="clearfix"></div>
					</ul>
				</div>
				<div class="col-md-3 col-xs-12 footer-grid">
					<h4 class="footer-head">Contact Us</h4>
					<span class="hq">Our headquaters</span>
					<address>
						<ul class="location">
							<li><span class="glyphicon glyphicon-map-marker"></span></li>
							<li>CENTER FOR FINANCIAL ASSISTANCE TO DEPOSED NIGERIAN ROYALTY</li>
							<div class="clearfix"></div>
						</ul>	
						<ul class="location">
							<li><span class="glyphicon glyphicon-earphone"></span></li>
							<li>+0 561 111 235</li>
							<div class="clearfix"></div>
						</ul>	
						<ul class="location">
							<li><span class="glyphicon glyphicon-envelope"></span></li>
							<li><a href="mailto:info@example.com">mail@example.com</a></li>
							<div class="clearfix"></div>
						</ul>						
					</address>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
		<div class="footer-bottom">
			<div class="wrap">
				<div class="copyrights col-md-6">
					<p>Copyright &copy; 2015.Company name All rights reserved.<a target="_blank" href="http://www.cssmoban.com/">&#x7F51;&#x9875;&#x6A21;&#x677F;</a></p>
				</div>
				<div class="footer-social-icons col-md-6">
					<ul>
						<li><a class="facebook" href="#"></a></li>
						<li><a class="twitter" href="#"></a></li>
						<li><a class="flickr" href="#"></a></li>
						<li><a class="googleplus" href="#"></a></li>
						<li><a class="dribbble" href="#"></a></li>
					</ul>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<!-- footer-section-ends-here -->
	<script type="text/javascript">
		$(document).ready(function() {
				/*
				var defaults = {
				containerID: 'toTop', // fading element id
				containerHoverID: 'toTopHover', // fading element hover id
				scrollSpeed: 1200,
				easingType: 'linear' 
				};
				*/
		$().UItoTop({ easingType: 'easeOutQuart' });
});
</script>
<a href="#to-top" id="toTop" style="display: block;"> <span id="toTopHover" style="opacity: 1;"> </span></a>
<!---->
</body>
</html>