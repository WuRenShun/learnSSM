package cn.test.email.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.test.email.model.Message;
import cn.test.email.model.Users;
import cn.test.email.service.IMessageService;
import cn.test.email.service.IUserService;

@Controller
@RequestMapping("/message")
public class MessageController {
	
	@Autowired
	private IMessageService iMessageService;
	
	@Autowired
	private IUserService iUserService;
	
	@RequestMapping("/submitMsg")
	public String submitMsg(Message message,HttpSession session,HttpServletRequest request) throws Exception{
		
		if(iUserService.selectName(message.getReceiveuname())==null){
			String noReceiveuname="不存在此用户！";
			request.setAttribute("noReceiveuname", noReceiveuname);
			return "postMsg";
		}
		
		iMessageService.insertMsg(message);
		
		Users u=(Users) session.getAttribute("user");
		
		List<Message> messageList=iMessageService.seekAllMsg(u.getName());
		
		request.setAttribute("messageList", messageList);
		
		
		
		return "listMsges";
	}
	
	@RequestMapping("/{id}/eraseMsg")
	public String eraseMsg(@PathVariable("id") Integer id,HttpSession session,HttpServletRequest request) throws Exception{
		
		iMessageService.deleteMsg(id);
		
		request.setAttribute("delect","<script type='text/javascript' >alert('删除成功');</script>");
		
		Users u=(Users) session.getAttribute("user");
		
		List<Message> messageList=iMessageService.seekAllMsg(u.getName());
		
		request.setAttribute("messageList", messageList);
		return "listMsges";
	}
	
	@RequestMapping("/{id}/displayMsg")
	public String displayMsg(@PathVariable("id") int id,HttpServletRequest request) throws Exception{
		
		Message message=iMessageService.findMsg(id);
		request.setAttribute("message", message);
		return "displayMsg";
	}
	
	@RequestMapping("postMsg")
	public String postMsg(){
		
		
		return "postMsg";
		
	}
	
	//RESF
	@RequestMapping("/{receiveUname}/postMsgReceiveUname")
	public String postMsgReceiveUname(@PathVariable("receiveUname") String receiveUname,HttpServletRequest request) throws Exception{
		
		request.setAttribute("receiveUname", receiveUname);
		
		
		return "postMsg";
	}
	
	@RequestMapping("/listsMsg")
	public String listsMsg(HttpSession session,HttpServletRequest request) throws Exception{
		Users u=(Users) session.getAttribute("user");
		
		List<Message> messageList=iMessageService.seekAllMsg(u.getName());
		
		request.setAttribute("messageList", messageList);
		
		return "listMsges";
		
	}
	

}
