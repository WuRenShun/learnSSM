package cn.test.email.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.test.email.exception.CustomException;
import cn.test.email.mapping.UsersMapper;
import cn.test.email.model.Users;
import cn.test.email.service.IUserService;

@Service("IUserService")
public class IUserServiceImpl implements IUserService{
	
	@Autowired
	private UsersMapper usersMapper;

	public void insertUser(Users users) throws Exception {
		
		
		if(usersMapper.selectByPrimaryKey(users.getName())!=null){
			throw new CustomException("该用户名已注册，请重新注册");
		}
		
		
		usersMapper.insertSelective(users);
	}

	public Users selectName(String name) throws Exception {
		
		Users user=usersMapper.selectByPrimaryKey(name);
		return user;
	}

	public Users selectUsers(Users user) throws Exception {
		
		if(usersMapper.selectByUsers(user)==null){
			throw new CustomException("错误的登陆密码");
		}
		
		Users u=usersMapper.selectByUsers(user);
		return u;
	}

}
