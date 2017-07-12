package cn.test.email.controller;



import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	
	
	@RequestMapping("/dologin")
	public String doLogin(Users user,HttpSession session,HttpServletRequest request) throws Exception{
		
		Users u=iUserService.selectUsers(user);
		
		session.setAttribute("user", u);
		
		List<Message> messageList=iMessageService.seekAllMsg(u.getName());
		
		
		request.setAttribute("messageList", messageList);
		
		return "listMsges";
		
	}
	
	@RequestMapping("/doregister")
	public String doRegister(Model model,@Validated Users user,BindingResult bindingResult) throws Exception{
		
		if (bindingResult.hasErrors()) {
			// 输出错误信息
			List<ObjectError> allErrors = bindingResult.getAllErrors();

			for (ObjectError objectError : allErrors) {
				// 输出错误信息
				System.out.println(objectError.getDefaultMessage());

			}
			// 将错误信息传到页面
			model.addAttribute("allErrors", allErrors);
			
			// 出错重新到商品修改页面
			return "register";
		}
		
		iUserService.insertUser(user);
		
		return "login";
		
	}
	
	@RequestMapping("/login")
	public String login(){
		return "login";
	}
	
	@RequestMapping("/register")
	public String register(){
		
		return "register";
	}
	
	
	@RequestMapping("/loginOut")
	public String loginOut(HttpSession session) throws Exception{
		
		session.invalidate();
		return "login";
		
	}

}
