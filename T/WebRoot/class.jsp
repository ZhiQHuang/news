<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
					<div class="list_vertical">
						<section class="accordation_menu">
						<c:forEach items="${classList }" var="c11" begin="2" varStatus="sta">
							<div>
								<input id="label-${sta.index-1}" name="lida" type="radio" checked /> <label
									for="label-${sta.index-1}" id="item${sta.index-1}"><i class="ferme"> </i>
									${c11.content }<i class="icon-plus-sign i-right1"></i><i
									class="icon-minus-sign i-right2"></i></label>
								<div class="content" id="a${sta.index-1}">
									<div class="scrollbar" id="style-2">
										<div class="force-overflow">
											<div class="popular-post-grids">
											<c:forEach items="${newsList2 }" var="l2" varStatus="sta1">
												<div class="popular-post-grid" id="${l2[sta1.index].className }">
												<c:forEach items="${l2 }"  var="news2">
													<div>
													<div class="post-img">
														<a href="Front?op=displayNews&newsId=${news2.newsId}"><img src="images/${news2.pictures}"
															alt="" /></a>
													</div>
													<div class="post-text">
														<a class="pp-title" href="Front?op=displayNews&newsId=${news2.newsId}">${news2.headTitle}</a>
													</div>
													<div class="clearfix"></div>
													</div>
													</c:forEach>
												</div>
											</c:forEach>
											
											</div>
										</div>
									</div>
								</div>
							</div>
                    	
                    	</c:forEach>
						
						</section>
					</div> 