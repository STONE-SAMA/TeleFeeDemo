package com.stone.teleFee.dao;

import com.stone.teleFee.beans.Info;
import com.stone.teleFee.beans.User;

public interface UserDao {

	Integer selectUserLogin(String phone, String password);

	boolean isExist(String phone);

	Integer saveUser(User user);

	boolean checkPass(String user_phone, String oldPass);

	void setNewPass(String newPass, String user_phone);

	Info getInfo(String login_phone);

	void addUserInfo(Integer flag, String phone);


}
