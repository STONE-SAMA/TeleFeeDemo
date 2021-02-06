package com.stone.teleFee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.stone.teleFee.beans.Combo;
import com.stone.teleFee.utils.JdbcUtil;

public class ComboDaoImpl implements ComboDao {

	private Connection conn;
	private Statement stmt;
	private PreparedStatement ps;
	private ResultSet rs;
	
	/**
	 * 获取套餐记录总数
	 */
	@Override
	public Integer getRecordCount() {
		// TODO Auto-generated method stub
		Integer recordCount = 0;
		try {
			conn = JdbcUtil.getConnection();
			String sql = "select count(*) from tb_combo";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				recordCount = rs.getInt(1);
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
		
		return recordCount;
	}

	@Override
	public List<Combo> getComboList(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		List<Combo> list = new ArrayList<Combo>();
		int firstIndex = pageSize * (pageNo-1);
		try {
			conn = JdbcUtil.getConnection();
			String sql = "select * from tb_combo group by COMBO_id order by COMBO_id limit ?,?";
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, firstIndex);
			ps.setInt(2, pageSize);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				Combo combo = new Combo();
				combo.setId(rs.getInt("COMBO_id"));
				combo.setName(rs.getString("COMBO_name"));
				combo.setPrice(rs.getDouble("COMBO_price"));
				combo.setDescription(rs.getString("COMBO_des"));
				combo.setImg(rs.getString("COMBO_img"));
				list.add(combo);
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
		
		return list;
	}

	@Override
	public Combo getComboByID(String comboID) {
		// TODO Auto-generated method stub
		Combo combo = new Combo();
		try {
			conn = JdbcUtil.getConnection();
			String sql = "select * from tb_combo where COMBO_id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(comboID));
			rs = ps.executeQuery();
			while(rs.next()) {
				combo.setId(rs.getInt("COMBO_id"));
				combo.setName(rs.getString("COMBO_name"));
				combo.setPrice(rs.getDouble("COMBO_price"));
				combo.setDescription(rs.getString("COMBO_des"));
				combo.setImg(rs.getString("COMBO_img"));
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
		
		return combo;
	}

	/**
	 * 获取套餐名
	 */
	@Override
	public String getComboName(Integer combo_id) {
		// TODO Auto-generated method stub
		String name = null;
		try {
			conn = JdbcUtil.getConnection();
			String sql = "select COMBO_name from tb_combo where COMBO_id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, combo_id);
			rs = ps.executeQuery();
			if(rs.next()) {
				name = rs.getString("COMBO_name");
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
		
		return name;
	}

	/**
	 * 更换套餐
	 */
	@Override
	public void changeCombo(String user_phone, Integer comboID) {
		// TODO Auto-generated method stub
		try {
			conn =JdbcUtil.getConnection();
			String sql = "update tb_info set USER_combo = ? where USER_phone = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, comboID);
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

}
