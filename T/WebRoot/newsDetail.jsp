<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>新闻详情</title>
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
<script src="js/responsiveslides.min.js"></script>
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
				$("addComment").click(function(event){		
					event.preventDefault();
					$('html,body').animate({scrollTop:$(this.hash).offset().top},900);
				});
			});
</script>

<script type="text/javascript">
			$().ready(function() {
			
				setInterval(auto(),1000);//每隔一秒钟自动执行auto方法

			});

			function showComment() {
				$("#addComment").show();
			}
			
			function auto(){
				//从服务器获取该新闻的最新的评论列表，在页面下方显示
				//1、获取当前页面的新闻newsId
				var newsId=${news.newsId};
				var notes=$("#notes");//将原有评论内容清空
				notes.empty();
				//2、访问服务器，获取该新闻的最新的评论列表
				$.post("Front?op=getNotes",{"newsId":newsId},
						function(data){
						//3、更新页面的评论列表内容
						//data是服务器返回的数据List，所以需要对List遍历
						//每一条评论，构建一个页面元素div，加入到notes
						//each函数的第一个参数就是要遍历的数组
						//each函数的第二个参数就是要对数组的每一个元素进行的操作
						$.each(eval(data),function(i,n){
						var tempDiv=$("<div></div>");
						tempDiv.html("评论人："+n.username+"<br/>评论时间："+n.time+
						"<br/>评论内容："+n.content+"<br/><br/>");
						notes.append(tempDiv);
						});
						},"json");
				}
			
			function addNote(){
				//获取当前页面的新闻的newsId
				var newsId=${news.newsId };
				//获取用户在comment表单域输入的内容
				var content=$("#comment").val();
				//向服务器提交Ajax请求
				$.post("Front?op=addNote",
				{"newsId":newsId,"content":content},
				function(data){
				//3、服务器请求成功，在页面输出请求结果
				alert(data);//弹出服务器返回的结果
				auto();//再加载评论列表，保证新添加的评论在评论列表中
				$("#comment").val("");
				//将comment表单域原先输入的内容清空，方便用户再发表新的评论
				});
				}
</script>
</head>
<body>
	<!-- header-section-starts-here -->
	<jsp:include page="Top.jsp"></jsp:include>
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
			  <li><a href="index.html">首页</a></li>
			  <li class="active">${news.className }</li>
			</ol>
			<div class="single-page">
			<div class="col-md-2 share_grid">
				<h3>SHARE</h3>
				<ul>
					<li>
						<a href="#">
							<i class="facebook"></i>
							<div class="views">
								<span>SHARE</span>
								<label>180</label>	
							</div>			
							<div class="clearfix"></div>
						</a>
					</li>
					<li>
						<a href="#">
							<i class="twitter"></i>
							<div class="views">
								<span>TWEET</span>
								<label>355</label>	
							</div>			
							<div class="clearfix"></div>				
						</a>
					</li>
					<li>
						<a href="#">
							<i class="linkedin"></i>
							<div class="views">
								<span>SHARES</span>
								<label>28</label>	
							</div>			
							<div class="clearfix"></div>								
						</a>
					</li>
					<li>
						<a href="#">
							<i class="pinterest"></i>
							<div class="views">
								<span>PIN</span>
								<label>16</label>	
							</div>			
							<div class="clearfix"></div>				
						</a>
					</li>
					<li>
						<a href="#">
							<i class="email"></i>
							<div class="views">
								<span>Email</span>	
							</div>			
							<div class="clearfix"></div>			
						</a>
					</li>
				</ul>
			</div>	
			<div class="col-md-6 content-left single-post">
				<div class="blog-posts">
			<img src="images/${news.pictures }" alt="image" />
			<h3 class="post">${news.headTitle }</h3>
			<p>  编辑： <a href="#"><span>${news.editor}</span></a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    	分类：<a href="#"><span>${news.className }</span></a><br /></p> 
                    <p>时间：<span class="updatedtime">${news.time }</span></p> 
                    <p>点击率：<span class="updatedtime">${news.hits }</span></p>
				<div class="last-article">
					<p class="artext">${news.content}</p>
					<ul class="categories">
						<li><a href="#">Markets</a></li>
						<li><a href="#">Business</a></li>
						<li><a href="#">Sport</a></li>
						<li><a href="#">Special reports</a></li>
						<li><a href="#">Culture</a></li>
					</ul>
					<div class="clearfix"></div>
					<!--related-posts-->
				<div class="row related-posts">
					<h4>Articles You May Like</h4>
					<div class="col-xs-6 col-md-3 related-grids">
						<a href="single.html" class="thumbnail">
							<img src="images/f2.jpg" alt=""/>
						</a>
						<h5><a href="single.html">Lorem Ipsum is simply</a></h5>
					</div>	
					<div class="col-xs-6 col-md-3 related-grids">
						<a href="single.html" class="thumbnail">
							<img src="images/f1.jpg" alt=""/>
						</a>
						<h5><a href="single.html">Lorem Ipsum is simply</a></h5>
					</div>
					<div class="col-xs-6 col-md-3 related-grids">
						<a href="single.html" class="thumbnail">
							<img src="images/f3.jpg" alt=""/>
						</a>
						<h5><a href="single.html">Lorem Ipsum is simply</a></h5>
					</div>
					<div class="col-xs-6 col-md-3 related-grids">
						<a href="single.html" class="thumbnail">
							<img src="images/f6.jpg" alt=""/>
						</a>
						<h5><a href="single.html">Lorem Ipsum is simply</a></h5>
					</div>					
				</div>
				<!--//related-posts-->

				<div class="response">
					<h4>评论</h4>
					<h5> <a href="javascript:showComment()">发表评论</a></h5>
					<div id="notes"></div>
					<hr/>                 
                  <div id="addComment" >
                                     发表评论：<br/><textarea name="content" id="comment" rows="5" cols="50" ></textarea><br/>
                  <input type="button" value="发评论" style="font-size: 12px"
                  onclick="javascrept:addNote()" /><br/><br/>
                                    还未登录？请先登录！
                   <a href="#login">登录</a><br/>
                  </div>
					
				</div>	
				
				<div class="clearfix"></div>
			</div>
		</div>

				</div>
			<div class="col-md-4 side-bar">
			<div class="first_half">
				<div class="categories">
					<header>
						<h3 class="side-title-head">分类</h3>
					</header>
					<ul>
						<c:forEach items="${classList }" var="c">
            				<li><a href="Front?op=listByClass&classId=${c.classId }">${c.content }</a><li>
            			</c:forEach>
					</ul>
				</div>
				
				
				<jsp:include page="prelogin.jsp"></jsp:include>
				
				
				<jsp:include page="class.jsp"></jsp:include>
				
				
					 <div class="side-bar-articles">
						<div class="side-bar-article">
							<a href="single.html"><img src="images/sai.jpg" alt="" /></a>
							<div class="side-bar-article-title">
								<a href="single.html">Contrary to popular belief, Lorem Ipsum is not simply random text</a>
							</div>
						</div>
						<div class="side-bar-article">
							<a href="single.html"><img src="images/sai2.jpg" alt="" /></a>
							<div class="side-bar-article-title">
								<a href="single.html">There are many variations of passages of Lorem</a>
							</div>
						</div>
						<div class="side-bar-article">
							<a href="single.html"><img src="images/sai3.jpg" alt="" /></a>
							<div class="side-bar-article-title">
								<a href="single.html">Sed ut perspiciatis unde omnis iste natus error sit voluptatem</a>
							</div>
						</div>
					 </div>
					  </div>
					 <div class="secound_half">
					 <div class="tags">
						<header>
							<h3 class="title-head">Tags</h3>
						</header>
						<p>
						<a class="tag1" href="single.html">At vero eos</a>
						<a class="tag2" href="single.html">doloremque</a>
						<a class="tag3" href="single.html">On the other</a>
						<a class="tag4" href="single.html">pain was</a>
						<a class="tag5" href="single.html">rationally encounter</a>
						<a class="tag6" href="single.html">praesentium voluptatum</a>
						<a class="tag7" href="single.html">est, omnis</a>
						<a class="tag8" href="single.html">who are so beguiled</a>
						<a class="tag9" href="single.html">when nothing</a>
						<a class="tag10" href="single.html">owing to the</a>
						<a class="tag11" href="single.html">pains to avoid</a>
						<a class="tag12" href="single.html">tempora incidunt</a>
						<a class="tag13" href="single.html">pursues or desires</a>
						<a class="tag14" href="single.html">Bonorum et</a>
						<a class="tag15" href="single.html">written by Cicero</a>
						<a class="tag16" href="single.html">Ipsum passage</a>
						<a class="tag17" href="single.html">exercitationem ullam</a>
						<a class="tag18" href="single.html">mistaken idea</a>
						<a class="tag19" href="single.html">ducimus qui</a>
						<a class="tag20" href="single.html">holds in these</a>
						</p>
					 </div>					 
					 <div class="popular-news">
						<header>
							<h3 class="title-popular">popular News</h3>
						</header>
						<div class="popular-grids">
							<div class="popular-grid">
								<a href="single.html"><img src="images/popular-4.jpg" alt="" /></a>
								<a class="title" href="single.html">It is a long established fact that a reader will be distracted</a>
								<p>On Aug 31, 2015 <a class="span_link" href="#"><span class="glyphicon glyphicon-comment"></span>0 </a><a class="span_link" href="#"><span class="glyphicon glyphicon-eye-open"></span>250 </a><a class="span_link" href="#"><span class="glyphicon glyphicon-thumbs-up"></span>68</a></p>
							</div>
							<div class="popular-grid">
								<a href="single.html"><img src="images/popular-3.jpg" alt="" /></a>
								<a class="title" href="single.html">It is a long established fact that a reader will be distracted</a>
								<p>On Mar 14, 2015 <a class="span_link" href="#"><span class="glyphicon glyphicon-comment"></span>0 </a><a class="span_link" href="#"><span class="glyphicon glyphicon-eye-open"></span>250 </a><a class="span_link" href="#"><span class="glyphicon glyphicon-thumbs-up"></span>68</a></p>
							</div>
						</div>
					</div>
					</div>
					<div class="clearfix"></div>
			</div>
			<div class="clearfix"></div>
		</div>
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
				wrapID: 'toTop', // fading element id
				wrapHoverID: 'toTopHover', // fading element hover id
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