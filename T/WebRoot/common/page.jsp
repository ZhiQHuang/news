<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
第<i class="blue">${page.pageNumber}</i>页/共<i class="blue">${page.totalPageNum}</i>页&nbsp;&nbsp;
<a href="${pageContext.request.contextPath}${page.url}&num=${page.prePageNumber}" >上一页</a>
<a href="${pageContext.request.contextPath}${page.url}&num=${page.nextPageNumber}">下一页</a>