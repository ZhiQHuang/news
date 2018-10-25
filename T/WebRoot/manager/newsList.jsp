<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>新闻网站列表</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/modernizr.min.js"></script>
<script type="text/javascript" src="../jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="../jquery.jsort.0.4.js"></script>


<script type="text/javascript">
$(document).ready(function(){
  $(".click").click(function(){
  $(".tip").fadeIn(200);
  });
  
  $(".tiptop a").click(function(){
  $(".tip").fadeOut(200);
});

  $(".sure").click(function(){
  $(".tip").fadeOut(100);
});

  $(".cancel").click(function(){
  $(".tip").fadeOut(100);
});

});

function updateOrd(){
    $(".tablelist tbody").jSort({
        sort_by: 'td.title',
        item: 'tr',
        order: 'desc'
    });
}

 function delete1(id){
     $.post(
         "ListNews?op=delete",
         {newsId:id},
         function(data){
             alert(data);
             window.location.reload(true);
         }
     );
 }
 
 function batchDel(){
     var delIds = new Array();
     $("input:checked").each(function(){
         delIds.push($(this).val());
     });
     $.post(
         "ListNews?op=batchDel",
         {newsIds:delIds},
         function(data){
             alert(data);
             window.location.reload(true);
         }
     );
 }
</script>


</head>


<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">数据表</a></li>
    <li><a href="#">基本内容</a></li>
    </ul>
    </div>
    
    <div class="rightinfo">
    
    <div class="tools">
    
    	<ul class="toolbar">
        <li class="click"><span><img src="images/t01.png" /></span>添加</li>
        <li class="click"><span><img src="images/t02.png" /></span>修改</li>
        <li><a href="javascript:batchDel()"><span><img src="images/t03.png" /></span>删除</a></li>
        <li><span><img src="images/t04.png" /></span>统计</li>
        <li><a id="updateOrd" href="javascript:updateOrd()">&nbsp;&nbsp;&nbsp;更新排序</a></li>
        </ul>
        
    
    </div>
    <div style="position:absolute; top:53px; left:500px">
    	<form action="ListNews?op=query1" method="post">
			<input type="text" name="q" size="10" id="searchfield" title="searchfield" 
				style="font-size:14px; height:24px; width:150px;border-radius:3px; border:1px solid #c8cccf; color:#6a6f77;"
			 />
			<input type="submit" value="search" alt="Search" id="searchbutton" 
				style="height: 23px; width: 50px"
			/>
		</form>
    </div>
    
    
    
    <table class="tablelist">
    	<thead>
    	<tr>
        <th><input name="" type="checkbox" value="" checked="checked"/></th>
        <th>ID<i class="sort"><img src="images/px.gif" /></i></th>
        <th>标题</th>
        <th>作者</th>
        <th>编辑</th>
        <th>点击</th>
        <th>更新时间</th>
        <th>操作</th>
        </tr>
        </thead>
        <tbody>
        	<c:forEach items="${page.records}" var="news" varStatus="status">
            	<tr>
                <td class="tc"><input name="id[]" value="${news.newsId }" type="checkbox" /></td>
                <td class="title">${status.index+1}</td>
                <td>${news.headTitle }</td>
                <td>${news.author }</td>
                <td>${news.editor }</td>
                <td>${news.hits }</td>
                <td>${news.newsTime }</td>
                <td>
                    <a class="tablelink" href="ListNews?op=preAdd">添加</a>
                	<a class="tablelink" href="ListNews?op=preEdit&newsId=${news.newsId}">修改</a>
                    <a class="tablelink" href="javascript:delete1(${news.newsId })">删除</a>
                    <a class="tablelink" href="ListNews?op=preVerify&newsId=${news.newsId}">审核新闻</a>
                </td>
                </tr>
        	</c:forEach>       
        </tbody>
    </table>
    
   
    <div class="pagin">
    	 <jsp:include page="../common/page.jsp"></jsp:include>
    </div>
    
    
    <div class="tip">
    	<div class="tiptop"><span>提示信息</span><a></a></div>
        
      <div class="tipinfo">
        <span><img src="images/ticon.png" /></span>
        <div class="tipright">
        <p>是否确认对信息的修改 ？</p>
        <cite>如果是请点击确定按钮 ，否则请点取消。</cite>
        </div>
        </div>
        
        <div class="tipbtn">
        
       
       
         <input class="sure" name="" type="button"  value="确定" onclick="javascript:location='ListNews?op=preAdd'" /> &nbsp;
      <input class="sure" name="" type="button"  value="取消"  />
        </div>
    
    </div>
    
    
    
    
    </div>
    
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>
</body>
</html>
