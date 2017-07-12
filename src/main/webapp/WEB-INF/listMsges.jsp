<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="cn.test.email.model.*,java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>短消息管理列表页面</title>
<link href="${pageContext.request.contextPath }/css/style.css" rel="stylesheet" type="text/css"/>
</head>
<%
	Users user = (Users)session.getAttribute("user");
	List<Message> messageList=(ArrayList)request.getAttribute("messageList");
	Message message=new Message();
%>
<body>
	<div class="background">
		<div class="sapce-1"></div>
		<div class="top">
		<div class="login_person"><center>当前用户：<%=user.getName() %></div>
		<div class="logout"><div class="logout_button">[ <a href="${pageContext.request.contextPath }/user/loginOut.do">登出</a> ]</div></div>
		<div class="Msg">
		<div class="myMsg"><center><h2>我的短消息</h2></center></div>
		<div class="postMsg"> [ <a href="${pageContext.request.contextPath }/message/postMsg.do">发送短消息</a> ]</center></div></div>
		<div class="table">
		<table width="60%" align="center" style="border-bottom:1px dashed #535660;font-size:14px;">
		<%
			for(int i =0;i<messageList.size();i++){
				 message = messageList.get(i);
		%>
		<tr>
			<td align="right" width="15%">
				<img src="${pageContext.request.contextPath }/image/<%=message.getReadsign()==0?"new.jpg":"old.jpg" %>"/>
			</td>
			<td><a href="${pageContext.request.contextPath }/message/<%=message.getId() %>/displayMsg.do">[ <%=message.getSenduname() %> ]:
			<%=message.getNote().substring(0,1) %>......</a></td>
		</tr>
		<%} %>
		</table>
		</div>
		${delect }
		
</body>
</html>