package com.stone.teleFee.dao;

import java.sql.*;

import com.stone.teleFee.beans.Info;
import com.stone.teleFee.beans.User;
import com.stone.teleFee.utils.JdbcUtil;

public class UserDaoImpl implements UserDao {
	
	private Connection conn;
	private Statement stmt;
	private PreparedStatement ps;
	private ResultSet rs;
	

	/**
	 * 登录验证
	 */
	@Override
	public Integer selectUserLogin(String phone, String password) {
		// TODO Auto-generated method stub
		Integer id = 0;
		
		try {
			conn = JdbcUtil.getConnection();
			String sql = "select USER_id from tb_userdata where USER_phone = ? and USER_password = ?";
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, phone);
			ps.setString(2, password);
			rs = ps.executeQuery();
			
			if(rs.next()) {		
				id = rs.getInt("USER_id");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				JdbcUtil.close(conn, stmt, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return id;//返回不为0表明登录成功
	}

/**
 * 手机号是否使用
 */
	@Override
	public boolean isExist(String phone) {
		// TODO Auto-generated method stub
		try {
			conn = JdbcUtil.getConnection();
			String sql = "select * from tb_userdata where USER_phone = ?";
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, phone);
			rs = ps.executeQuery();
			if(rs.next())
				return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				JdbcUtil.close(conn, stmt, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return false;//未使用
	}

/**
 * 用户信息写入数据库
 */
	@Override
	public Integer saveUser(User user) {
		// TODO Auto-generated method stub
		Integer flag = null;
		
		try {
			conn = JdbcUtil.getConnection();
			String sql = "insert into tb_userdata(USER_name,USER_phone,USER_password) values(?,?,?)";
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, user.getName());
			ps.setString(2, user.getPhone());
			ps.setString(3, user.getPassword());
			
			ps.executeUpdate();
			
			//获取最后插入数据的id
			sql = "select @@identity newId";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				flag = rs.getInt("newId");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				JdbcUtil.close(conn, stmt, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return flag;
	}

	/**
	 * 检验用户原密码是否输入正确
	 */
	@Override
	public boolean checkPass(String user_phone, String oldPass) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			conn = JdbcUtil.getConnection();
			String sql = "select USER_password from tb_userdata where USER_phone = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, user_phone);
			rs = ps.executeQuery();
			if(rs.next()) {
				String pass = rs.getString("USER_password");
				if(pass.equals(oldPass))
					flag = true;//密码输入正确
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				JdbcUtil.close(conn, stmt, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return flag;
	}

	/**
	 * 设置新密码
	 */
	@Override
	public void setNewPass(String newPass, String user_phone) {
		// TODO Auto-generated method stub
		try {
			conn = JdbcUtil.getConnection();
			String sql = "update tb_userdata set USER_password = ? where USER_phone = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, newPass);
			ps.setString(2, user_phone);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				JdbcUtil.close(conn, stmt, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	/**
	 * 获取账户金额、套餐信息
	 */
	@Override
	public Info getInfo(String login_phone) {
		// TODO Auto-generated method stub
		Info info = null;
		try {
			conn = JdbcUtil.getConnection();
			String sql = "select * from tb_info where USER_phone = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, login_phone);
			rs = ps.executeQuery();
			if(rs.next()) {
				info = new Info();
				info.setMoney(rs.getDouble("USER_money"));
				info.setCombo_id(rs.getInt("USER_combo"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				JdbcUtil.close(conn, stmt, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return info;
	}

	/**
	 * 注册时添加新用户的套餐、余额等信息
	 */
	@Override
	public void addUserInfo(Integer flag, String phone) {
		// TODO Auto-generated method stub
		try {
			conn = JdbcUtil.getConnection();
			String sql = "insert into tb_info(USER_id,USER_phone,USER_money,USER_combo) values(?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, flag);
			ps.setString(2, phone);
			ps.setDouble(3, 0.0);
			ps.setInt(4, 1);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				JdbcUtil.close(conn, stmt, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
