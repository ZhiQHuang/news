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
                    "listManager?op=delete",
                    { adminId:id },/*向服务器提交的数据{数据名：数据值}*/
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
    <li><a href="computer.jsp">管理员的管理</a></li>
    <li><a href="#">列表</a></li>
    </ul>
    </div>
    
    
    <table class="filetable">
    
    <thead>
    	<tr>
    	<th width="1%"></th>
    	<th width="3%">序号</th>
        <th width="8%">普通管理员姓名</th>
        <th width="6%">密码</th>
        <th width="10%">上次登录时间</th>
        <th width="6%">上次登录Ip</th>
        <th width="5%">类型</th>
        <th width="8%">修改</th>
        
        </tr>    	
    </thead>
    
    <tbody>
   
      <c:forEach items="${page.records}" var="admins" varStatus="status">
    	<tr>
    	<td >
        <input name="id[]" value="${admins.adminId }"  type="checkbox" /></td>
       
        <td id="adminId" name="adminId">${admins.adminId}</td>
        <td>${admins.username}</td>
        <td>${admins.password}</td>
        <td>${admins.lastLogin}</td>
        <td class="tdlast">${admins.lastLoginIP}</td>
        <td>${admins.type}</td>
        <td>
        <a href="javascript:delete1(${admins.adminId})">删除</a>
        <a href="addManager.jsp">增加</a>
        </td>
        
        </tr>
        </c:forEach>

    </tbody>
   
    
    
    
    </table>
     <jsp:include page="../common/page.jsp"></jsp:include>
</body>
</html>
