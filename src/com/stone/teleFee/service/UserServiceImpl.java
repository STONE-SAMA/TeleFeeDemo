package com.stone.teleFee.service;

import com.stone.teleFee.beans.Info;
import com.stone.teleFee.beans.User;
import com.stone.teleFee.dao.UserDao;
import com.stone.teleFee.dao.UserDaoImpl;

public class UserServiceImpl implements UserService {
	private UserDao dao;
	
	public UserServiceImpl() {
		dao = new UserDaoImpl();
	}


	@Override
	public Integer checkUser(String phone, String password) {
		// TODO Auto-generated method stub
		return dao.selectUserLogin(phone, password);
	}

	@Override
	public boolean isExist(String phone) {
		// TODO Auto-generated method stub
		return dao.isExist(phone);
	}


	@Override
	public Integer saveUser(User user) {
		// TODO Auto-generated method stub
		return dao.saveUser(user);
	}


	@Override
	public boolean checkPass(String user_phone, String oldPass) {
		// TODO Auto-generated method stub
		return dao.checkPass(user_phone, oldPass);
	}


	@Override
	public void setNewPass(String newPass, String user_phone) {
		// TODO Auto-generated method stub
		dao.setNewPass(newPass, user_phone);
	}


	@Override
	public Info getInfo(String login_phone) {
		// TODO Auto-generated method stub
		return dao.getInfo(login_phone);
	}


	@Override
	public void addUserInfo(Integer flag, String phone) {
		// TODO Auto-generated method stub
		dao.addUserInfo(flag, phone);
	}


}
