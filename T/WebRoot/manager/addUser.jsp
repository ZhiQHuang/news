<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <title>新闻网站后台管理</title>
    <link rel="stylesheet" type="text/css" href="css/common.css"/>
    <link rel="stylesheet" type="text/css" href="css/main.css"/>
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/modernizr.min.js"></script>
    <script type="text/javascript" src="../jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="../jquery.jsort.0.4.js"></script>
    <script type="text/javascript">
             function delete1(id){
                $.post(
                    "listUser?op=delete",
                    { userId:id },/*向服务器提交的数据{数据名：数据值}*/
                     function(data){
                     alert(data);
                     window.location.reload(true); 
}//服务器执行完毕，请求成功，执行该函数，该函数的参数代表服务器响应的数据
);
}
 </script>
    <script type="text/javascript" src="js/libs/modernizr.min.js"></script>
</head>
<body>

<div class="container clearfix">
    
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="/jscss/admin/design/">首页</a>
            <span class="crumb-step">&gt;</span><a class="crumb-name" href="/jscss/admin/design/">新闻分类信息管理</a><span class="crumb-step">&gt;</span><span>新增新闻类型</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
                <form action="addUser" method="post" id="myform" name="myform">
                    <table class="insert-tab" width="100%">
                        <tbody>
                            <tr>
                                <th><i class="require-red">*</i>用户姓名：</th>
                                <td>
                                    <input class="common-text required" id="username" name="username" size="50" type="text">
                                </td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>用户密码：</th>
                                <td>
                                    <input class="common-text required" id="password" name="password" size="50" type="text">
                                </td>
                            </tr>
                             <tr>
                                <th><i class="require-red">*</i>性别：</th>
                                <td>
                                    <input class="common-text required" id="sex" name="sex" size="50" type="text">
                                </td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>问题：</th>
                                <td>
                                    <input class="common-text required" id="question" name="question" size="50" type="text">
                                </td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>答案：</th>
                                <td>
                                    <input class="common-text required" id="answer" name="answer" size="50" type="text">
                                </td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>Email：</th>
                                <td>
                                    <input class="common-text required" id="emailAddr" name="emailAddr" size="50" type="text">
                                </td>
                            </tr>
                           <tr>
                                <th><i class="require-red">*</i>QQ：</th>
                                <td>
                                    <input class="common-text required" id="qq" name="qq" size="50" type="text">
                                </td>
                            </tr>

                            <tr>
                                <th></th>
                                <td>
                                    <input class="btn btn-primary btn6 mr10" value="提交" type="submit" >
                                    <input class="btn btn6" onclick="history.go(-1)" value="返回" type="button">
                                </td>
                            </tr>
                        </tbody></table>
                </form>
            </div>
        </div>

    </div>
    <!--/main-->
</div>
</body>
</html>