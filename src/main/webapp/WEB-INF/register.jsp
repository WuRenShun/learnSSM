<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
 <link rel="stylesheet" type="text/css" href="css/css2.css">
</head>
<body>
	<div class="top">
Register········
	</div>
	<div class="text"><span style="font-family:黑体;font-size:20px;font-weight:bold;">欢迎来到注册页面</div>
	<div class="radius"></div>
	<div class="one">
		
		<form action="${pageContext.request.contextPath }/user/login.do" method="post"  name="form1">
		<div class="two">
			<div class="space-2"></div>
			<div class="space-1">用户名:<input type="text" class="input" name="registerName"></div>
		</div>
		<div class="two">
			<div class="space-3"></div>
			<div class="space-1">密码:<input type="password" class="input" name="registerPass"></div>
		</div>
		<div class="two">
			<div class="space"></div> 
			<div class="space-1">确认密码:<input type="password" class="input" name="againPass"></div>
		</div>
		<div class="two">
			<div class="space-4"></div>
			<div class="space-1">邮箱:<input type="text" class="input" name="youxiang"></div>
		</div>
		<!-- 后台进行的错误数据放置处 -->
		<%-- <div class="spacespace">
				<%
					String error=(String)session.getAttribute("error");
					if(error!=null){
				%>
						<%=error %>
				<% 
					}
				 %>
			</div> --%>
		<div class="button">
			<div class="submit">
				<input value="注册" type="submit" class="submit-1" onclick="return fun()">
			</div>
			<div class="submit">
				<input value="重置" type="reset" class="submit-1">
			</div>
		</div>
		</form>
	</div>
	
</body>
	<script type="text/javascript">
		function fun(){
  		var userName=form1.registerName.value;
  		var password=form1.registerPass.value;
  		var again=form1.againPass.value;
  		var youxiang=form1.youxiang.value;
  		if(youxiang==""||youxiang==null||userName==""||password==""||userName==null||password==null){
  			alert("密码、用户名、邮箱不能为空！");
  			return false;
  		}
  		if(password!=again){
  			alert("密码不一致");
  			return false;
  		}
  		return true;
  	}
	</script>
</html>
