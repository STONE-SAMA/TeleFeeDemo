package com.stone.teleFee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.stone.teleFee.beans.records;
import com.stone.teleFee.utils.JdbcUtil;

public class RecordDaoImpl implements RecordDao {

	private Connection conn;
	private Statement stmt;
	private PreparedStatement ps;
	private ResultSet rs;
	
	/**
	 * 获取消费记录数
	 */
	@Override
	public Integer getRecordCount(String userPhone) {
		// TODO Auto-generated method stub
		Integer count = 0;
		try {
			conn = JdbcUtil.getConnection();
			String sql = "select * from tb_record where USER_phone = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, userPhone);
			rs = ps.executeQuery();
			
			while(rs.next())
				count++;

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
		
		return count;
	}
	
	/**
	 * 获取当前记录
	 */
	@Override
	public List<records> getRecordList(Integer pageNo, Integer pageSize, String userPhone) {
		// TODO Auto-generated method stub
		List<records> list = new ArrayList<records>();
		int firstIndex = pageSize * (pageNo-1);
		try {
			conn = JdbcUtil.getConnection();
			String sql = "select * from tb_record where USER_phone = ? limit ?,?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, userPhone);
			ps.setInt(2, firstIndex);
			ps.setInt(3, pageSize);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				if(rs.getString("USER_phone").equals(userPhone)) {
					records record = new records();
					record.setPhone(rs.getString("USER_phone"));
					record.setMoney(rs.getDouble("Consume_money"));
					record.setTime(rs.getString("Consume_time"));
					record.setNote(rs.getString("Consume_note"));
					list.add(record);
				}
			}//缺少数据库执行反馈
			
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
		
		return list;
	}

	/**
	 * 套餐变更记录
	 */
	@Override
	public void addRecord(String user_phone, String time, String note) {
		// TODO Auto-generated method stub
		try {
			conn = JdbcUtil.getConnection();
			String sql = "insert into tb_record(USER_phone,Consume_money,Consume_time,Consume_note) values(?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, user_phone);
			ps.setDouble(2, 0.0);
			ps.setString(3, time);
			ps.setString(4, note);
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
