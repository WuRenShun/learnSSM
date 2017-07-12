<%@ page language="java" import="java.util.*,cn.test.email.model.*" pageEncoding="utf-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<title>具体短消息内容查看</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/style.css"/>
</head>
<%
	if(null == session.getAttribute("user")){
		response.sendRedirect("login.jsp");
		return;
	}
	Users user=(Users)session.getAttribute("user");
	request.setCharacterEncoding("utf-8");
	Message message=(Message)request.getAttribute("message");
	

%>
<body>
<div class="background">
		<div class="sapce-1"></div>
		<div class="top">
		<div class="login_person"><center>当前用户：<%=user.getName() %></div>
		<div class="logout"><div class="logout_button">[ <a href="${pageContext.request.contextPath }/user/loginOut.do">登出</a> ]</div></div>
		<div class="Msg">
		<div class="myMsg"><center><h2>阅读短消息</h2></center></div>
		<div class="postMsg"> [ <a href="${pageContext.request.contextPath }/message/postMsg.do">发送短消息</a> ]&nbsp;&nbsp;[<A href="listMsg.jsp">我的短消息</A>]</center></div>
		</div>
	<table width="60%" align="center" style="border-bottom:1px #535660 dashed">
	<tr>
		<td>来自：<%=message.getSenduname() %></td>
	</tr>
	<tr>
		<td><%=message.getNote() %></td>
	</tr>
	<tr>
		<td align="right">[<a href="${pageContext.request.contextPath }/message/<%=message.getSenduname() %>/postMsgReceiveUname.do">回复</a>][<a href="${pageContext.request.contextPath }/message/<%=message.getId() %>/eraseMsg.do">删除</a>]</td>
	</tr>
	<tr>
		<td align="right">[<%=message.getPosttime() %>]</td>
	</tr>
	</table>
</body>
</html>