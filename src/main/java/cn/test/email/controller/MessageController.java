package cn.test.email.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.test.email.model.Message;
import cn.test.email.service.IMessageService;

@Controller
@RequestMapping("/message")
public class MessageController {
	
	@Autowired
	private IMessageService iMessageService;
	
	@RequestMapping("/submitMsg")
	public String submitMsg(Message message) throws Exception{
		iMessageService.insertMsg(message);
		return "";
	}
	
	@RequestMapping("/eraseMsg")
	public String eraseMsg(Integer id) throws Exception{
		iMessageService.deleteMsg(id);
		return "";
	}
	
	

}
