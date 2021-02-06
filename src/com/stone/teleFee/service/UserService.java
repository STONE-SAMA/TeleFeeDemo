package com.stone.teleFee.service;

import com.stone.teleFee.beans.Info;
import com.stone.teleFee.beans.User;

public interface UserService {

	//用户验证
	Integer checkUser(String phone, String password);

	//用户注册时，手机号唯一性判断
	boolean isExist(String phone);

	//注册完成，保存用户信息
	Integer saveUser(User user);

	boolean checkPass(String user_phone, String oldPass);

	void setNewPass(String newPass, String user_phone);

	Info getInfo(String login_phone);

	void addUserInfo(Integer flag, String phone);
	

}