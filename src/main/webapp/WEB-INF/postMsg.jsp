<%@ page language="java" import="java.util.*,cn.test.email.model.*" pageEncoding="utf-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <head>
 	<title>发送短消息页面</title>
 	<link href="${pageContext.request.contextPath }/css/style.css" rel="stylesheet" type="text/css"/>
</head>
<%
	request.setCharacterEncoding("utf-8");
	Users user=(Users)session.getAttribute("user");
	if(user==null){
			response.sendRedirect("login.jsp");
			return;
	}
	String name=user.getName();
	
	java.util.Date d=new java.util.Date();
	
	Integer i=1;

%>
<body>
	<div class="background">
		<div class="sapce-1"></div>
		<div class="top">
		<div class="login_person"><center>当前用户：<%=user.getName() %></div>
		<div class="logout"><div class="logout_button">[ <a href="${pageContext.request.contextPath }/message/loginOut.do">登出</a> ]</div></div>
		<div class="Msg">
		<div class="myMsg"><center><h2>发送短消息</h2></center></div>
		<div class="postMsg"> [ <a href="${pageContext.request.contextPath }/message/listsMsg.do">我的短消息</a> ]</center></div></div>
	
	<div class="table">
		<form name="myForm" action="${pageContext.request.contextPath }/message/submitMsg.do" method="post">
			<input type="hidden" name="senduname" value="<%=name %>"/>
			<div class="send">
			发送给:
			
				<input type="text" name="receiveuname" value="<% 
					if(request.getAttribute("receiveUname")!=null){
						%><%=request.getAttribute("receiveUname")%><%
					}
				%>" style="background:#131417;color:white;"/>
			
			</div>
			
			<input type="hidden" name="posttime" value="<%=d%>"/>
			
			<div class="short">
				<div class="text">短消息:</div>
				<div>
			<textarea name="note" cols="30" rows="5" style="background:#131417;color:white"></textarea></div>
			
			<input type="hidden" name="readsign" value="<%=i%>"/>
			
				<div class="buttonsend"><input type="submit" value="发送" onclick="return fun()" class="button_send"/></div>
			</div>
	</form>
	</div>
	</div>

</body>
	<script type="text/javascript">
		function fun(){
	  		var userName=myForm.receiveUname.value;
	  		var note=myForm.note.value;
	  		if(userName==""||note==""||userName==null||note==null){
		  		alert("输入框不能为空！");
		  		return false;
		  	}
		  		return true;
  		}
	</script>
</html>
