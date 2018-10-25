<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" type="text/css" href="css/style.css"/>
    <script type="text/javascript" src="js/modernizr.min.js"></script>
    <script type="text/javascript" src="../fckeditor/fckeditor.js"></script>
    <script type="text/javascript" src="../jquery-1.11.1.min.js"></script>
    <script>
       $(function(){
            var ofckeditor=new FCKeditor("content");
            ofckeditor.BasePath="/T/fckeditor/";
            ofckeditor.Height=400;
            ofckeditor.Width=700;
            ofckeditor.ReplaceTextarea();
            $("#pictures").change(function(){
                var file=$("#pictures").get(0).files[0];
                if(file){
                    var reader=new FileReader();
                    reader.readAsDataURL(file);
                    reader.onload=function(e){
                        $("#newsPic").attr("src",e.target.result);
                    };
                }
            });
       });
    </script>
    
</head>
<body>

    <div class="main-wrap">

       
            
        <div class="result-wrap">
            <div class="result-content">
                <form action="ListNews?op=edit" method="post" id="myform" name="myform" enctype="multipart/form-data">
                <input type="hidden" name="newsId" value="${news.newsId }">
                    <table class="insert-tab" width="100%">
                       <div class="formbody">
         <form action="ListNews?op=add" method="post" id="myform" name="myform" enctype="multipart/form-data">
		<div class="formtitle">
			<span>基本信息</span>
		</div>

		<ul class="forminfo">
			<li><label>新闻分类：</label> <select name="classId" id="classId"
				class="dfinput">
					<c:forEach items="${classList}" var="c">
						<option value="${c.classId}"
							<c:if test="${c.classId==news.classId}"> selected="selected"</c:if>>
							${c.content}</option>
					</c:forEach>
			</select></li>
			<li><label>新闻标题：</label><input name="headTitle" type="text"
				class="dfinput" value="${news.headTitle }" /></li>
            
            <li><label>作者：</label><input name="author" type="text"
				class="dfinput" value="${news.author }" /></li>
			
			<li><label>编辑：</label><input name="editor" type="text"
				class="dfinput" value="${news.editor }" /></li>
			
			<li><label>新闻来源：</label><input name="newsFrom" type="text"
				class="dfinput" value="${news.newsFrom }" /></li>
			
			<li><label>是否置顶：</label>
				<input name="top" type="radio" value="1">是
				<input name="top" type="radio" value="0">否</li>
			
			<li><label>新闻图片：</label>
				<input id="pictures" name="pictures" type="file" 
					value="${news.pictures}" accept="image/*"> <br />
				<img id="newsPic" src="../images/${news.pictures }" width="150px" height="100" />
				</input></li>
			<li><label>文章内容：</label> 
				<textarea name="content" cols="30" rows="10" class="textinput"> 
				${news.content }</textarea></li>
			<li><label>&nbsp;</label><input name="" type="submit"
				class="btn" value="确认保存" /></li>
		</ul>

    </form>
	</div>
                        </table>
                </form>
            </div>
        </div>

    </div>
    <!--/main-->
</div>
</body>
</html>