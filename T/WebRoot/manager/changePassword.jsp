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
    <script type="text/javascript" src="js/modernizr.min.js"></script>
</head>
<body>

<div class="container clearfix">
    
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="result-wrap">
            <div class="result-content">
                <form action="changePassword" method="post" id="myform" name="myform">
                
                    <table class="insert-tab" width="100%">
                        <tbody>
                            <tr>
                                <th><i class="require-red">*</i>原密码：</th>
                                <td>
                                    <input class="common-text required" id="password" name="password" size="50" type="password">
                                </td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>新密码：</th>
                                <td>
                                    <input class="common-text required" id="password2" name="password2" size="50" type="password">
                                </td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>确认新密码：</th>
                                <td>
                                    <input class="common-text required" id="repassword" name="repassword" size="50" type="password">
                                </td>
                            </tr>
                            <tr>
                                <th></th>
                                <td>
                                    <input class="btn btn-primary btn6 mr10" value="提交" type="submit">
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