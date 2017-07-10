package cn.test.email.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.test.email.mapping.MessageMapper;
import cn.test.email.model.Message;
import cn.test.email.service.IMessageService;

@Service
public class IMessageServiceImpl implements IMessageService {
	
	@Autowired
	private  MessageMapper messageMapper;

	public void insertMsg(Message message) throws Exception {
		// TODO Auto-generated method stub
		messageMapper.insertSelective(message);

	}

	public void deleteMsg(int id) throws Exception {
		// TODO Auto-generated method stub
		if(messageMapper.selectByPrimaryKey(id)==null){
			throw new Exception("删除的对象不存在");
		}
		messageMapper.deleteByPrimaryKey(id);

	}

	public List<Message> seekAllMsg(String name) throws Exception {
		
		List<Message> message=messageMapper.selectMessage(name);
		return message;
	}

	public Message findMsg(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateMsg(int id) throws Exception {
		// TODO Auto-generated method stub

	}

	public int getMax() throws Exception {
		int a=messageMapper.getMessageMax();
		return a;
	}

}
