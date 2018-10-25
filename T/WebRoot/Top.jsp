<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
					<c:forEach items="${classList }" var="c">
            			<li><a href="Front?op=listByClass&classId=${c.classId }">${c.content }</a><li>
            		</c:forEach>
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