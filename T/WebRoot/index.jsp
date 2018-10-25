<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<title>新闻首页</title>
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
<script type="application/x-javascript">
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
</script>
<!-- for bootstrap working -->
<script type="text/javascript" src="js/bootstrap.js"></script>
<!-- //for bootstrap working -->
<!-- web-fonts -->
<link href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic'
	rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Varela+Round'
	rel='stylesheet' type='text/css'>
<script src="js/responsiveslides.min.js"></script>
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
<!--/script-->
<script type="text/javascript">
	jQuery(document).ready(function($) {
		$(".scroll").click(function(event) {
			event.preventDefault();
			$('html,body').animate({
				scrollTop : $(this.hash).offset().top
			}, 900);
		});
	});
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
				<div class="marquee1">
					<a class="breaking" href="Front?op=displayNews&newsId=${recentNews[0].newsId}">>>${recentNews[0].headTitle}</a>
				</div>
				<div class="marquee2">
					<a class="breaking" href="Front?op=displayNews&newsId=${newsList1[0].newsId}">>>${newsList1[0].headTitle }</a>
				</div>
				<div class="clearfix"></div>
			</div>
			<div class="clearfix"></div>
			<script type="text/javascript" src="js/jquery.marquee.min.js"></script>
			<script>
				$('.marquee').marquee({
					pauseOnHover : true
				});
				//@ sourceURL=pen.js
			</script>
		</div>
	</div>
	
	<!-- content-section-starts-here -->
	<div class="main-body">
		<div class="wrap">
			<div class="col-md-8 content-left">
				<div class="slider">
					<div class="callbacks_wrap">
							<img src="images/${topNews.pictures}" alt="image" width="839px" height="450px" /><br />
                    		<div class="caption">
                    			<a href="Front?op=displayNews&newsId=${topNews.newsId}">${topNews.headTitle}</a>
                    		</div>
					</div>
				</div>
				<div class="articles">
					<header>
						<h3 class="title-head">最新新闻</h3>
					</header>
					<c:forEach items="${recentNews}" var="rNews">
					<div class="article">
						<div class="article-left">
							<a href="Front?op=displayNews&newsId=${rNews.newsId}">
								<img src="images/${rNews.pictures}" alt="image" width="400px" height="200px" />
							</a>
						</div>
						<div class="article-right">
							<div class="article-title">
								<a class="title" href="Front?op=displayNews&newsId=${rNews.newsId}">
								${rNews.headTitle}</a>
							</div>
							<div class="article-text">
								<p>${rNews.content}...</p>
								<a href="Front?op=displayNews&newsId=${rNews.newsId}">
								<img src="images/more.png" alt="" /></a>
								<div class="clearfix"></div>
							</div>
						</div>
						<div class="clearfix"></div>
					</div>
					</c:forEach>
					
				</div>
				
				<div class="sports-top">
					<div class="s-grid-left">
						<div class="cricket">
							<header>
								<h3 class="title-head">${newsList1[0].className }</h3>
							</header>
						
							<div class="c-sports-main">
								<div class="c-image">
									<a href="Front?op=displayNews&newsId=${newsList1[0].newsId }">
									<img src="images/${newsList1[0].pictures }" alt="image" width="200px" height="158px"/></a>
								</div>
								<div class="c-text">
									<a class="power" href="Front?op=displayNews&newsId=${newsList1[0].newsId }">
									${newsList1[0].headTitle }</a>
									<a class="reu" href="Front?op=displayNews&newsId=${newsList1[0].newsId }">
									<img src="images/more.png" alt="" /></a>
									<div class="clearfix"></div>
								</div>
								<div class="clearfix"></div>
							</div>
							
                    		<c:forEach items="${newsList1 }" var="news1" begin="1">
								<div class="s-grid-small">
									<div class="sc-image">
										<a href="Front?op=displayNews&newsId=${news1.newsId }">
										<img src="images/${news1.pictures }" alt="" width="120px" height="110px" /></a>
									</div>
								<div class="sc-text">
									<a class="power" href="Front?op=displayNews&newsId=${news1.newsId }">
									${news1.headTitle }</a>
									<a class="reu" href="Front?op=displayNews&newsId=${news1.newsId }">
									<img src="images/more.png" alt="" /></a>
									<div class="clearfix"></div>
								</div>
								<div class="clearfix"></div>
							</div>
						</c:forEach>
						</div>
					</div>
					<div class="s-grid-right">
						<div class="cricket">
							<header>
								<h3 class="title-popular">${newsLista[0].className }</h3>
							</header>
							<div class="c-sports-main">
								<div class="c-image">
									<a href="Front?op=displayNews&newsId=${newsLista[0].newsId }">
									<img src="images/${newsLista[0].pictures }" alt="image" width="200px" height="158px" /></a>
								</div>
								<div class="c-text">
									<a class="power" href="Front?op=displayNews&newsId=${newsLista[0].newsId }">
									${newsLista[0].headTitle }</a>
									<a class="reu" href="Front?op=displayNews&newsId=${newsLista[0].newsId }">
									<img src="images/more.png" alt="" /></a>
									<div class="clearfix"></div>
								</div>
								<div class="clearfix"></div>
							</div>
							<c:forEach items="${newsLista }" var="newsa" begin="1">
							<div class="s-grid-small">
								<div class="sc-image">
									<a href="Front?op=displayNews&newsId=${newsa.newsId }">
										<img src="images/${newsa.pictures }" alt="img" width="120px" height="110px" /></a>
								</div>
								<div class="sc-text">
									<a class="power" href="Front?op=displayNews&newsId=${newsa.newsId }">
									${newsa.headTitle }</a>
									<a class="reu" href="Front?op=displayNews&newsId=${newsa.newsId }"><img
										src="images/more.png" alt="" /></a>
									<div class="clearfix"></div>
								</div>
								<div class="clearfix"></div>
							</div>
							</c:forEach>
							
						</div>
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
			<div class="col-md-4 side-bar">
				<div class="first_half">
				
				
					<jsp:include page="prelogin.jsp"></jsp:include>
					
					
					<jsp:include page="class.jsp"></jsp:include>
					

					<div class="side-bar-articles">
						<div class="side-bar-article">
							<a href="single.html"><img src="images/sai.jpg" alt="" /></a>
							<div class="side-bar-article-title">
								<a href="single.html">Contrary to popular belief, Lorem
									Ipsum is not simply random text</a>
							</div>
						</div>
						<div class="side-bar-article">
							<a href="single.html"><img src="images/sai2.jpg" alt="" /></a>
							<div class="side-bar-article-title">
								<a href="single.html">There are many variations of passages
									of Lorem</a>
							</div>
						</div>
						<div class="side-bar-article">
							<a href="single.html"><img src="images/sai3.jpg" alt="" /></a>
							<div class="side-bar-article-title">
								<a href="single.html">Sed ut perspiciatis unde omnis iste
									natus error sit voluptatem</a>
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
							<a class="tag1" href="single.html">At vero eos</a> <a
								class="tag2" href="single.html">doloremque</a> <a class="tag3"
								href="single.html">On the other</a> <a class="tag4"
								href="single.html">pain was</a> <a class="tag5"
								href="single.html">rationally encounter</a> <a class="tag6"
								href="single.html">praesentium voluptatum</a> <a class="tag7"
								href="single.html">est, omnis</a> <a class="tag8"
								href="single.html">who are so beguiled</a> <a class="tag9"
								href="single.html">when nothing</a> <a class="tag10"
								href="single.html">owing to the</a> <a class="tag11"
								href="single.html">pains to avoid</a> <a class="tag12"
								href="single.html">tempora incidunt</a> <a class="tag13"
								href="single.html">pursues or desires</a> <a class="tag14"
								href="single.html">Bonorum et</a> <a class="tag15"
								href="single.html">written by Cicero</a> <a class="tag16"
								href="single.html">Ipsum passage</a> <a class="tag17"
								href="single.html">exercitationem ullam</a> <a class="tag18"
								href="single.html">mistaken idea</a> <a class="tag19"
								href="single.html">ducimus qui</a> <a class="tag20"
								href="single.html">holds in these</a>
						</p>
					</div>
					<div class="popular-news">
						<header>
							<h3 class="title-popular">popular News</h3>
						</header>
						<div class="popular-grids">
							<div class="popular-grid">
								<a href="single.html"><img src="images/popular-4.jpg" alt="" /></a>
								<a class="title" href="single.html">It is a long established
									fact that a reader will be distracted</a>
								<p>
									On Aug 31, 2015 <a class="span_link" href="#"><span
										class="glyphicon glyphicon-comment"></span>0 </a><a
										class="span_link" href="#"><span
										class="glyphicon glyphicon-eye-open"></span>250 </a><a
										class="span_link" href="#"><span
										class="glyphicon glyphicon-thumbs-up"></span>68</a>
								</p>
							</div>
							<div class="popular-grid">
								<a href="single.html"><img src="images/popular-1.jpg" alt="" /></a>
								<a class="title" href="single.html">It is a long established
									fact that a reader will be distracted</a>
								<p>
									On Mar 14, 2015 <a class="span_link" href="#"><span
										class="glyphicon glyphicon-comment"></span>0 </a><a
										class="span_link" href="#"><span
										class="glyphicon glyphicon-eye-open"></span>250 </a><a
										class="span_link" href="#"><span
										class="glyphicon glyphicon-thumbs-up"></span>68</a>
								</p>
							</div>
							
						</div>
					</div>
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
					<p>It is a long established fact that a reader will be
						distracted by the readable content of a page when looking at its
						layout.</p>
					<p>The point of using Lorem Ipsum is that it has a more-or-less
						normal distribution of letters, as opposed to using 'Content here.</p>
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
							<li>CENTER FOR FINANCIAL ASSISTANCE TO DEPOSED NIGERIAN
								ROYALTY</li>
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
					<p>
						Copyright &copy; 2015.Company name All rights reserved.<a
							target="_blank" href="http://www.cssmoban.com/">&#x7F51;&#x9875;&#x6A21;&#x677F;</a>
					</p>
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
			$().UItoTop({
				easingType : 'easeOutQuart'
			});
		});
	</script>
	<a href="#to-top" id="toTop" style="display: block;"> <span
		id="toTopHover" style="opacity: 1;"> </span></a>
	<!---->
</body>
</html>