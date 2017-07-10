package cn.test.email.controller;



import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.test.email.mapping.MessageMapper;
import cn.test.email.model.Message;
import cn.test.email.model.Users;
import cn.test.email.service.IMessageService;
import cn.test.email.service.IUserService;

@Controller
@RequestMapping("/user")
public class UsersController {
	
	@Autowired
	private IUserService iUserService;
	
	@Autowired
	private  IMessageService iMessageService;
	
	
	
	@RequestMapping("/login")
	public String login(Users user,HttpSession session,HttpServletRequest request) throws Exception{
		
		Users u=iUserService.selectUsers(user);
		
		session.setAttribute("user", u);
		
		List<Message> messageList=iMessageService.seekAllMsg(u.getName());
		
		
		request.setAttribute("messageList", messageList);
		
		return "listMsg";
		
	}
	
	@RequestMapping("/register")
	public String register(Users user) throws Exception{
		
		iUserService.insertUser(user);
		
		return "login";
		
	}

}
