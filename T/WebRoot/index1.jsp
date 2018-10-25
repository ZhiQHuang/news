<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>网站首页</title>
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
				$(".scroll").click(function(event){		
					event.preventDefault();
					$('html,body').animate({scrollTop:$(this.hash).offset().top},900);
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
				<div class="marquee1"><a class="breaking" href="single.jsp">>>${recentNews[0].headTitle}</a></div>
				<div class="marquee2"><a class="breaking" href="single.jsp">>>${recentNews[0].headTitle}</a></div>
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
    <div class="copyrights">Collect from <a href="http://www.cssmoban.com/" >ä¼ä¸ç½ç«æ¨¡æ¿</a></div>
	<!-- content-section-starts-here -->
	<div class="main-body">
		<div class="wrap">
			<div class="col-md-8 content-left">
				<div class="slider">
					<div class="callbacks_wrap">
						<ul class="rslides" id="slider">
						<!-- 
						<c:forEach items="${recentNews }" var="rNews" begin="0">
							<li>
								<img src="images/${rNews.pictures}" alt="image" width="824px" height="442px">
								<div class="caption">
									<a href="#">${rNews.headTitle}</a>
								</div>
							</li>
						</c:forEach>
						-->
							<li>
								<img src="images/2.jpg" alt="">
								<div class="caption">
									<a href="single.jsp">Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque</a>
								</div>
							</li>
							<li>
								<img src="images/1.jpg" alt="">
								<div class="caption">
									<a href="single.jsp">At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium</a>
								</div>
							</li>
							 
						</ul>
					</div>
				</div>
				<div class="articles">
					<header>
						<h3 class="title-head">All around the world</h3>
					</header>
					<div class="article">
						<div class="article-left">
							<a href="single.jsp"><img src="images/article1.jpg"></a>
						</div>
						<div class="article-right">
							<div class="article-title">
								<p>On Feb 25, 2015 <a class="span_link" href="#"><span class="glyphicon glyphicon-comment"></span>0 </a><a class="span_link" href="#"><span class="glyphicon glyphicon-eye-open"></span>104 </a><a class="span_link" href="#"><span class="glyphicon glyphicon-thumbs-up"></span>52</a></p>
								<a class="title" href="single.jsp"> The section of the mass media industry that focuses on presenting</a>
							</div>
							<div class="article-text">
								<p>The standard chunk of Lorem Ipsum used since the 1500s. Sections 1.10.32 and 1.10.33 from "de Finibus Bonorum et Malorum" exact original.....</p>
								<a href="single.jsp"><img src="images/more.png" alt="" /></a>
								<div class="clearfix"></div>
							</div>
						</div>
						<div class="clearfix"></div>
					</div>
					<div class="article">
						<div class="article-left">
							<iframe width="100%" src="http://www.cssmoban.com/" frameborder="0" allowfullscreen></iframe>
						</div>
						<div class="article-right">
							<div class="article-title">
								<p>On Apr 11, 2015 <a class="span_link" href="#"><span class="glyphicon glyphicon-comment"></span>2 </a><a class="span_link" href="#"><span class="glyphicon glyphicon-eye-open"></span>54 </a><a class="span_link" href="#"><span class="glyphicon glyphicon-thumbs-up"></span>18</a></p>
								<a class="title" href="single.jsp">Contrary to popular belief, Lorem Ipsum is not simply random</a>
							</div>
							<div class="article-text">
								<p>It is a long established fact that a reader will be distracted by the readable.....</p>
								<a href="single.jsp"><img src="images/more.png" alt="" /></a>
								<div class="clearfix"></div>
							</div>
						</div>
						<div class="clearfix"></div>
					</div>
					<div class="article">
						<div class="article-left">
							<a href="single.jsp"><img src="images/article3.jpg"></a>
						</div>
						<div class="article-right">
							<div class="article-title">
								<p>On Jun 21, 2015 <a class="span_link" href="#"><span class="glyphicon glyphicon-comment"></span>0 </a><a class="span_link" href="#"><span class="glyphicon glyphicon-eye-open"></span>181 </a><a class="span_link" href="#"><span class="glyphicon glyphicon-thumbs-up"></span>89</a></p>
								<a class="title" href="single.jsp">There are many variations that focuses on presenting</a>
							</div>
							<div class="article-text">
								<p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam.....</p>
								<a href="single.jsp"><img src="images/more.png" alt="" /></a>
								<div class="clearfix"></div>
							</div>
						</div>
						<div class="clearfix"></div>
					</div>
					<div class="article">
						<div class="article-left">
							<a href="single.jsp"><img src="images/article4.jpg"></a>
						</div>
						<div class="article-right">
							<div class="article-title">
								<p>On Jan 17, 2015 <a class="span_link" href="#"><span class="glyphicon glyphicon-comment"></span>1 </a><a class="span_link" href="#"><span class="glyphicon glyphicon-eye-open"></span>144 </a><a class="span_link" href="#"><span class="glyphicon glyphicon-thumbs-up"></span>74</a></p>
								<a class="title" href="single.jsp">Lorem ipsum dolor sit amet, consectetur adipiscing elit</a>
							</div>
							<div class="article-text">
								<p>But I must explain to you how all this mistaken idea of denouncing pleasure and praising pain was born.....</p>
								<a href="single.jsp"><img src="images/more.png" alt="" /></a>
								<div class="clearfix"></div>
							</div>
						</div>
						<div class="clearfix"></div>
					</div>
					<div class="article">
						<div class="article-left">
							<iframe width="100%" src="http://www.cssmoban.com/" frameborder="0" allowfullscreen></iframe>
						</div>
						<div class="article-right">
							<div class="article-title">
								<p>On Mar 14, 2015 <a class="span_link" href="#"><span class="glyphicon glyphicon-comment"></span>0 </a><a class="span_link" href="#"><span class="glyphicon glyphicon-eye-open"></span>250 </a><a class="span_link" href="#"><span class="glyphicon glyphicon-thumbs-up"></span>68</a></p>
								<a class="title" href="single.jsp">On the other hand, we denounce with righteous indignation</a>
							</div>
							<div class="article-text">
								<p>It is a long established fact that a reader will be distracted by the readable.....</p>
								<a href="single.jsp"><img src="images/more.png" alt="" /></a>
								<div class="clearfix"></div>
							</div>
						</div>
						<div class="clearfix"></div>
					</div>
				</div>
				<div class="life-style">
					<header>
						<h3 class="title-head">Life Style</h3>
					</header>
					<div class="life-style-grids">
						<div class="life-style-left-grid">
							<a href="single.jsp"><img src="images/l1.jpg" alt="" /></a>
							<a class="title" href="single.jsp">It is a long established fact that a reader will be distracted.</a>
						</div>
						<div class="life-style-right-grid">
							<a href="single.jsp"><img src="images/l2.jpg" alt="" /></a>
							<a class="title" href="single.jsp">There are many variations of passages of Lorem Ipsum available.</a>
						</div>
						<div class="clearfix"></div>
					</div>
					<div class="life-style-grids">
						<div class="life-style-left-grid">
							<a href="single.jsp"><img src="images/l3.jpg" alt="" /></a>
							<a class="title" href="single.jsp">Contrary to popular belief, Lorem Ipsum is not simply random text.</a>
						</div>
						<div class="life-style-right-grid">
							<a href="single.jsp"><img src="images/l4.jpg" alt="" /></a>
							<a class="title" href="single.jsp">Sed ut perspiciatis unde omnis iste natus error sit voluptatem.</a>
						</div>
						<div class="clearfix"></div>
					</div>
				</div>
					<div class="sports-top">
							<div class="s-grid-left">
								<div class="cricket">
									<header>
										<h3 class="title-head">Business</h3>
									</header>
									<div class="c-sports-main">
											<div class="c-image">
												<a href="single.jsp"><img src="images/bus1.jpg" alt="" /></a>
											</div>
											<div class="c-text">
												<h6>Lorem Ipsum</h6>
												<a class="power" href="single.jsp">It is a long established fact that a reader</a>
												<p class="date">On Feb 25, 2015</p>
												<a class="reu" href="single.jsp"><img src="images/more.png" alt="" /></a>
												<div class="clearfix"></div>
											</div>
											<div class="clearfix"></div>
										</div>
										<div class="s-grid-small">
											<div class="sc-image">
												<a href="single.jsp"><img src="images/bus2.jpg" alt="" /></a>
											</div>
										<div class="sc-text">
											<h6>Lorem Ipsum</h6>
											<a class="power" href="single.jsp">It is a long established fact that a reader</a>
											<p class="date">On Mar 21, 2015</p>
											<a class="reu" href="single.jsp"><img src="images/more.png" alt="" /></a>
												<div class="clearfix"></div>
										</div>
										<div class="clearfix"></div>
										</div>
										<div class="s-grid-small">
											<div class="sc-image">
												<a href="single.jsp"><img src="images/bus3.jpg" alt="" /></a>
											</div>
										<div class="sc-text">
											<h6>Lorem Ipsum</h6>
											<a class="power" href="single.jsp">It is a long established fact that a reader</a>
											<p class="date">On Jan 25, 2015</p>
											<a class="reu" href="single.jsp"><img src="images/more.png" alt="" /></a>
												<div class="clearfix"></div>
										</div>
										<div class="clearfix"></div>
										</div>
										<div class="s-grid-small">
											<div class="sc-image">
												<a href="single.jsp"><img src="images/bus4.jpg" alt="" /></a>
											</div>
										<div class="sc-text">
											<h6>Lorem Ipsum</h6>
											<a class="power" href="single.jsp">It is a long established fact that a reader</a>
											<p class="date">On Jul 19, 2015</p>
											<a class="reu" href="single.jsp"><img src="images/more.png" alt="" /></a>
												<div class="clearfix"></div>
										</div>
										<div class="clearfix"></div>
										</div>
									</div>
								</div>
							<div class="s-grid-right">
								<div class="cricket">
									<header>
										<h3 class="title-popular">Technology</h3>
									</header>
									<div class="c-sports-main">
											<div class="c-image">
												<a href="single.jsp"><img src="images/tec1.jpg" alt="" /></a>
											</div>
											<div class="c-text">
												<h6>Lorem Ipsum</h6>
												<a class="power" href="single.jsp">It is a long established fact that a reader</a>
												<p class="date">On Apr 22, 2015</p>
												<a class="reu" href="single.jsp"><img src="images/more.png" alt="" /></a>
												<div class="clearfix"></div>
											</div>
											<div class="clearfix"></div>
										</div>
										<div class="s-grid-small">
											<div class="sc-image">
												<a href="single.jsp"><img src="images/tec2.jpg" alt="" /></a>
											</div>
										<div class="sc-text">
											<h6>Lorem Ipsum</h6>
											<a class="power" href="single.jsp">It is a long established fact that a reader</a>
											<p class="date">On Jan 19, 2015</p>
											<a class="reu" href="single.jsp"><img src="images/more.png" alt="" /></a>
												<div class="clearfix"></div>
										</div>
										<div class="clearfix"></div>
										</div>
										<div class="s-grid-small">
											<div class="sc-image">
												<a href="single.jsp"><img src="images/tec3.jpg" alt="" /></a>
											</div>
										<div class="sc-text">
											<h6>Lorem Ipsum</h6>
											<a class="power" href="single.jsp">It is a long established fact that a reader</a>
											<p class="date">On Jun 25, 2015</p>
											<a class="reu" href="single.jsp"><img src="images/more.png" alt="" /></a>
												<div class="clearfix"></div>
										</div>
										<div class="clearfix"></div>
										</div>
										<div class="s-grid-small">
											<div class="sc-image">
												<a href="single.jsp"><img src="images/tec4.jpg" alt="" /></a>
											</div>
										<div class="sc-text">
											<h6>Lorem Ipsum</h6>
											<a class="power" href="single.jsp">It is a long established fact that a reader</a>
											<p class="date">On Jul 19, 2015</p>
											<a class="reu" href="single.jsp"><img src="images/more.png" alt="" /></a>
												<div class="clearfix"></div>
										</div>
										<div class="clearfix"></div>
										</div>
									</div>
								</div>
								<div class="clearfix"></div>
							</div>
				</div>
			<div class="col-md-4 side-bar">
			<div class="first_half">
			
			
				<jsp:include page="prelogin.jsp"></jsp:include>
				
				
				<div class="list_vertical">
		         	 	<section class="accordation_menu">
						  <div>
						    <input id="label-1" name="lida" type="radio" checked/>
						   <label for="label-1" id="item1"><i class="ferme"> </i>Popular Posts<i class="icon-plus-sign i-right1"></i><i class="icon-minus-sign i-right2"></i></label>
						    <div class="content" id="a1">
						    	<div class="scrollbar" id="style-2">
								 <div class="force-overflow">
									<div class="popular-post-grids">
										<div class="popular-post-grid">
											<div class="post-img">
												<a href="single.jsp"><img src="images/bus2.jpg" alt="" /></a>
											</div>
											<div class="post-text">
												<a class="pp-title" href="single.jsp"> The section of the mass media industry</a>
												<p>On Feb 25 <a class="span_link" href="#"><span class="glyphicon glyphicon-comment"></span>3 </a><a class="span_link" href="#"><span class="glyphicon glyphicon-eye-open"></span>56 </a></p>
											</div>
											<div class="clearfix"></div>
										</div>
										<div class="popular-post-grid">
											<div class="post-img">
												<a href="single.jsp"><img src="images/bus1.jpg" alt="" /></a>
											</div>
											<div class="post-text">
												<a class="pp-title" href="single.jsp"> Lorem Ipsum is simply dummy text printing</a>
												<p>On Apr 14 <a class="span_link" href="#"><span class="glyphicon glyphicon-comment"></span>2 </a><a class="span_link" href="#"><span class="glyphicon glyphicon-eye-open"></span>56 </a></p>
											</div>
											<div class="clearfix"></div>
										</div>
										<div class="popular-post-grid">
											<div class="post-img">
												<a href="single.jsp"><img src="images/bus3.jpg" alt="" /></a>
											</div>
											<div class="post-text">
												<a class="pp-title" href="single.jsp">There are many variations of Lorem</a>
												<p>On Jun 25 <a class="span_link" href="#"><span class="glyphicon glyphicon-comment"></span>0 </a><a class="span_link" href="#"><span class="glyphicon glyphicon-eye-open"></span>56 </a></p>
											</div>
											<div class="clearfix"></div>
										</div>
										<div class="popular-post-grid">
											<div class="post-img">
												<a href="single.jsp"><img src="images/bus4.jpg" alt="" /></a>
											</div>
											<div class="post-text">
												<a class="pp-title" href="single.jsp">Sed ut perspiciatis unde omnis iste natus</a>
												<p>On Jan 25 <a class="span_link" href="#"><span class="glyphicon glyphicon-comment"></span>1 </a><a class="span_link" href="#"><span class="glyphicon glyphicon-eye-open"></span>56 </a></p>
											</div>
											<div class="clearfix"></div>
										</div>
									</div>
									</div>
                                </div>
                              </div>
						  </div>
						  <div>
						    <input id="label-2" name="lida" type="radio"/>
						    <label for="label-2" id="item2"><i class="icon-leaf" id="i2"></i>Recent Posts<i class="icon-plus-sign i-right1"></i><i class="icon-minus-sign i-right2"></i></label>
						    <div class="content" id="a2">
						       <div class="scrollbar" id="style-2">
								   <div class="force-overflow">
									<div class="popular-post-grids">
											<div class="popular-post-grid">
												<div class="post-img">
													<a href="single.jsp"><img src="images/tec2.jpg" alt="" /></a>
												</div>
												<div class="post-text">
													<a class="pp-title" href="single.jsp"> The section of the mass media industry</a>
													<p>On Feb 25 <a class="span_link" href="#"><span class="glyphicon glyphicon-comment"></span>3 </a><a class="span_link" href="#"><span class="glyphicon glyphicon-eye-open"></span>56 </a></p>
												</div>
												<div class="clearfix"></div>
											</div>
											<div class="popular-post-grid">
												<div class="post-img">
													<a href="single.jsp"><img src="images/tec1.jpg" alt="" /></a>
												</div>
												<div class="post-text">
													<a class="pp-title" href="single.jsp"> Lorem Ipsum is simply dummy text printing</a>
													<p>On Apr 14 <a class="span_link" href="#"><span class="glyphicon glyphicon-comment"></span>2 </a><a class="span_link" href="#"><span class="glyphicon glyphicon-eye-open"></span>56 </a></p>
												</div>
												<div class="clearfix"></div>
											</div>
											<div class="popular-post-grid">
												<div class="post-img">
													<a href="single.jsp"><img src="images/tec3.jpg" alt="" /></a>
												</div>
												<div class="post-text">
													<a class="pp-title" href="single.jsp">There are many variations of Lorem</a>
													<p>On Jun 25 <a class="span_link" href="#"><span class="glyphicon glyphicon-comment"></span>0 </a><a class="span_link" href="#"><span class="glyphicon glyphicon-eye-open"></span>56 </a></p>
												</div>
												<div class="clearfix"></div>
											</div>
											<div class="popular-post-grid">
												<div class="post-img">
													<a href="single.jsp"><img src="images/tec4.jpg" alt="" /></a>
												</div>
												<div class="post-text">
													<a class="pp-title" href="single.jsp">Sed ut perspiciatis unde omnis iste natus</a>
													<p>On Jan 25 <a class="span_link" href="#"><span class="glyphicon glyphicon-comment"></span>1 </a><a class="span_link" href="#"><span class="glyphicon glyphicon-eye-open"></span>56 </a></p>
												</div>
												<div class="clearfix"></div>
											</div>
										</div>
									</div>
								</div>
						    </div>
						  </div>
						  <div>
						    <input id="label-3" name="lida" type="radio"/>
						    <label for="label-3" id="item3"><i class="icon-trophy" id="i3"></i>Comments<i class="icon-plus-sign i-right1"></i><i class="icon-minus-sign i-right2"></i></label>
						    <div class="content" id="a3">
						       <div class="scrollbar" id="style-2">
							    <div class="force-overflow">
								 <div class="response">
						<div class="media response-info">
							<div class="media-left response-text-left">
								<a href="#">
									<img class="media-object" src="images/icon1.png" alt="" />
								</a>
								<h5><a href="#">Username</a></h5>
							</div>
							<div class="media-body response-text-right">
								<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit,There are many variations of passages of Lorem Ipsum available, 
									sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
								<ul>
									<li>MARCH 21, 2015</li>
									<li><a href="single.jsp">Reply</a></li>
								</ul>
							</div>
							<div class="clearfix"> </div>
						</div>
						<div class="media response-info">
							<div class="media-left response-text-left">
								<a href="#">
									<img class="media-object" src="images/icon1.png" alt="" />
								</a>
								<h5><a href="#">Username</a></h5>
							</div>
							<div class="media-body response-text-right">
								<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit,There are many variations of passages of Lorem Ipsum available, 
									sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
								<ul>
									<li>MARCH 26, 2015</li>
									<li><a href="single.jsp">Reply</a></li>
								</ul>		
							</div>
							<div class="clearfix"> </div>
						</div>
						<div class="media response-info">
							<div class="media-left response-text-left">
								<a href="#">
									<img class="media-object" src="images/icon1.png" alt="" />
								</a>
								<h5><a href="#">Username</a></h5>
							</div>
							<div class="media-body response-text-right">
								<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit,There are many variations of passages of Lorem Ipsum available, 
									sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
								<ul>
									<li>MAY 25, 2015</li>
									<li><a href="single.jsp">Reply</a></li>
								</ul>		
							</div>
							<div class="clearfix"> </div>
						</div>
						<div class="media response-info">
							<div class="media-left response-text-left">
								<a href="#">
									<img class="media-object" src="images/icon1.png" alt="" />
								</a>
								<h5><a href="#">Username</a></h5>
							</div>
							<div class="media-body response-text-right">
								<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit,There are many variations of passages of Lorem Ipsum available, 
									sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
								<ul>
									<li>FEB 13, 2015</li>
									<li><a href="single.jsp">Reply</a></li>
								</ul>		
							</div>
							<div class="clearfix"> </div>
						</div>
						<div class="media response-info">
							<div class="media-left response-text-left">
								<a href="#">
									<img class="media-object" src="images/icon1.png" alt="" />
								</a>
								<h5><a href="#">Username</a></h5>
							</div>
							<div class="media-body response-text-right">
								<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit,There are many variations of passages of Lorem Ipsum available, 
									sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
								<ul>
									<li>JAN 28, 2015</li>
									<li><a href="single.jsp">Reply</a></li>
								</ul>		
							</div>
							<div class="clearfix"> </div>
						</div>
						<div class="media response-info">
							<div class="media-left response-text-left">
								<a href="#">
									<img class="media-object" src="images/icon1.png" alt="" />
								</a>
								<h5><a href="#">Username</a></h5>
							</div>
							<div class="media-body response-text-right">
								<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit,There are many variations of passages of Lorem Ipsum available, 
									sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
								<ul>
									<li>APR 18, 2015</li>
									<li><a href="single.jsp">Reply</a></li>
								</ul>		
							</div>
							<div class="clearfix"> </div>
						</div>
						<div class="media response-info">
							<div class="media-left response-text-left">
								<a href="#">
									<img class="media-object" src="images/icon1.png" alt="" />
								</a>
								<h5><a href="#">Username</a></h5>
							</div>
							<div class="media-body response-text-right">
								<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit,There are many variations of passages of Lorem Ipsum available, 
									sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
								<ul>
									<li>DEC 25, 2014</li>
									<li><a href="single.jsp">Reply</a></li>
								</ul>		
							</div>
							<div class="clearfix"> </div>
						</div>
					</div>
					</div>

                                </div>
						    </div>
						  </div>
						</section>
					 </div>
					 <div class="side-bar-articles">
						<div class="side-bar-article">
							<a href="single.jsp"><img src="images/sai.jpg" alt="" /></a>
							<div class="side-bar-article-title">
								<a href="single.jsp">Contrary to popular belief, Lorem Ipsum is not simply random text</a>
							</div>
						</div>
						<div class="side-bar-article">
							<a href="single.jsp"><img src="images/sai2.jpg" alt="" /></a>
							<div class="side-bar-article-title">
								<a href="single.jsp">There are many variations of passages of Lorem</a>
							</div>
						</div>
						<div class="side-bar-article">
							<a href="single.jsp"><img src="images/sai3.jpg" alt="" /></a>
							<div class="side-bar-article-title">
								<a href="single.jsp">Sed ut perspiciatis unde omnis iste natus error sit voluptatem</a>
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
						<a class="tag1" href="single.jsp">At vero eos</a>
						<a class="tag2" href="single.jsp">doloremque</a>
						<a class="tag3" href="single.jsp">On the other</a>
						<a class="tag4" href="single.jsp">pain was</a>
						<a class="tag5" href="single.jsp">rationally encounter</a>
						<a class="tag6" href="single.jsp">praesentium voluptatum</a>
						<a class="tag7" href="single.jsp">est, omnis</a>
						<a class="tag8" href="single.jsp">who are so beguiled</a>
						<a class="tag9" href="single.jsp">when nothing</a>
						<a class="tag10" href="single.jsp">owing to the</a>
						<a class="tag11" href="single.jsp">pains to avoid</a>
						<a class="tag12" href="single.jsp">tempora incidunt</a>
						<a class="tag13" href="single.jsp">pursues or desires</a>
						<a class="tag14" href="single.jsp">Bonorum et</a>
						<a class="tag15" href="single.jsp">written by Cicero</a>
						<a class="tag16" href="single.jsp">Ipsum passage</a>
						<a class="tag17" href="single.jsp">exercitationem ullam</a>
						<a class="tag18" href="single.jsp">mistaken idea</a>
						<a class="tag19" href="single.jsp">ducimus qui</a>
						<a class="tag20" href="single.jsp">holds in these</a>
						</p>
					 </div>					 
					 <div class="popular-news">
						<header>
							<h3 class="title-popular">popular News</h3>
						</header>
						<div class="popular-grids">
							<div class="popular-grid">
								<a href="single.jsp"><img src="images/popular-4.jpg" alt="" /></a>
								<a class="title" href="single.jsp">It is a long established fact that a reader will be distracted</a>
								<p>On Aug 31, 2015 <a class="span_link" href="#"><span class="glyphicon glyphicon-comment"></span>0 </a><a class="span_link" href="#"><span class="glyphicon glyphicon-eye-open"></span>250 </a><a class="span_link" href="#"><span class="glyphicon glyphicon-thumbs-up"></span>68</a></p>
							</div>
							<div class="popular-grid">
								<a href="single.jsp"><img src="images/popular-1.jpg" alt="" /></a>
								<a class="title" href="single.jsp">It is a long established fact that a reader will be distracted</a>
								<p>On Mar 14, 2015 <a class="span_link" href="#"><span class="glyphicon glyphicon-comment"></span>0 </a><a class="span_link" href="#"><span class="glyphicon glyphicon-eye-open"></span>250 </a><a class="span_link" href="#"><span class="glyphicon glyphicon-thumbs-up"></span>68</a></p>
							</div>
							<div class="popular-grid">
								<iframe width="100%" src="http://www.cssmoban.com/" frameborder="0" allowfullscreen></iframe>
								<a class="title" href="single.jsp">Aishwarya Rai Bachchan's Latest SHOCKING News For Ex Salman Khan</a>
								<p>On Mar 14, 2015 <a class="span_link" href="#"><span class="glyphicon glyphicon-comment"></span>0 </a><a class="span_link" href="#"><span class="glyphicon glyphicon-eye-open"></span>250 </a><a class="span_link" href="#"><span class="glyphicon glyphicon-thumbs-up"></span>68</a></p>
							</div>
							<div class="popular-grid">
								<a href="single.jsp"><img src="images/popular-3.jpg" alt="" /></a>
								<a class="title" href="single.jsp">It is a long established fact that a reader will be distracted</a>
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
						<li><a href="business.jsp">Business</a></li>
						<li><a href="technology.jsp">Technology</a></li>
						<li><a href="entertainment.jsp">Entertainment</a></li>
						<li><a href="sports.jsp">Sports</a></li>
						<li><a href="shortcodes.jsp">Health</a></li>
						<li><a href="fashion.jsp">Fashion</a></li>
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