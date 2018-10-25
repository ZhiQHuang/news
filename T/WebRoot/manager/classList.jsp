<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />

    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/modernizr.min.js"></script>
    <script type="text/javascript" src="../jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="../jquery.jsort.0.4.js"></script>
    <script type="text/javascript">                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    
             function delete1(id){
                $.post(
                    "ListClass?op=delete",
                    { classId:id },/*向服务器提交的数据{数据名：数据值}*/
                     function(data){
                     alert(data);
                     window.location.reload(true); 
}//服务器执行完毕，请求成功，执行该函数，该函数的参数代表服务器响应的数据
);
}
 </script>

</head>


<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">新闻分类的管理</a></li>
    <li><a href="#">列表</a></li>
    </ul>
    </div>
    

    <table class="filetable">
    
    <thead>
    	<tr>
    	<th width="1%"></th>
    	<th width="6%">序号</th>
        <th width="10%">名称</th>
        <th width="6%">类型</th>
        <th width="6%">操作</th>
        
        
        </tr>    	
    </thead>
    
    <tbody>
   
      <c:forEach items="${page.records}" var="admins" varStatus="status">
    	<tr>
    	<td >
        <input name="id[]" value="${admins.classId }"  type="checkbox" /></td>
       
       
        <td>${admins.classId}</td>
        <td>${admins.content}</td>
        <td>${admins.type}</td>
        <td>
        <a href="javascript:delete1(${admins.classId})">删除</a>
        <a href="addClass.jsp">添加</a>
        </td>
        
        </tr>
        </c:forEach>

    </tbody>
    
    </table>
     <jsp:include page="../common/page.jsp"></jsp:include>
</body>
</html>
