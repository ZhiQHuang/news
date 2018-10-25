<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">
function login(){
	var name=$("#username").val();
	var pass=$("#password").val();
	$.post("Front?op=login",{"username":name,"password":pass},
			function(data){
				if(eval(data)==true){
					$("#login").empty();
					var tempDiv=$("<div>登录成功！欢迎您"+name+"<div>");
					$("#login").append(tempDiv);
				}
				else if(eval(data)==false){
					alert("登录失败");
					window.location.reload(true);
				}
	});
}
</script>

				<div id="login" >
					<h1 class="side-title-head">登录</h1>
					<form id=form1>
                        <label >用户名</label>
                        <input class="" name="username" type="text" id="username" style="float:right;"/><br/><br/>
                        <label>密码 </label>
                        <input class="" name="password" type="password" id="password" style="float:right;"/><br/>
                        
                        <input class="button" type="button" name="Submit" value="登录" style="margin-left:50%" 
                        		onclick="javascript:login()" />
                        <input class="button" type="reset" name="reset" value="重置" style="float:right;" />
                        <p style="float:right;">还未注册？请点击<a href="regist.jsp">注册</a>！</p><br/> <br/>      
                    	<p style="float:right;">忘记密码？请点击<a href="#">密码提示</a>！</p>  
					</form>
					 
				</div>