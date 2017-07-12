package cn.test.email.service;

import java.util.List;

import cn.test.email.model.Message;

public interface IMessageService {
	
	/*添加短消息*/
	public void insertMsg(Message message) throws Exception;
	
	/*删除指定编号的短消息*/
	public void deleteMsg(Integer id) throws Exception;
	
	/*查找某用户接收到的所有短消息*/
	public List<Message> seekAllMsg(String name) throws Exception;
	
	/*查找一条指定编号的短消息*/
	public Message findMsg(Integer id) throws Exception;
	
	/*更新一条指定编号的短消息*/
	public void updateMsg(Integer id) throws Exception;
	
	/*取得数据库中最大id*/
	public int getMax() throws Exception;

}
