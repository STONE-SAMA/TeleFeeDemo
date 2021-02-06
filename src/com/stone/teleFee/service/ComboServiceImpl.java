package com.stone.teleFee.service;

import java.util.List;

import com.stone.teleFee.beans.Combo;
import com.stone.teleFee.dao.ComboDao;
import com.stone.teleFee.dao.ComboDaoImpl;

public class ComboServiceImpl implements ComboService {

	private ComboDao dao;
	
	public ComboServiceImpl() {
		dao = new ComboDaoImpl();
	}

	@Override
	public Integer getRecordCount() {
		// TODO Auto-generated method stub
		return dao.getRecordCount();
	}

	@Override
	public List<Combo> getComboList(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return dao.getComboList(pageNo, pageSize);
	}

	@Override
	public Combo getComboByID(String comboID) {
		// TODO Auto-generated method stub
		return dao.getComboByID(comboID);
	}

	@Override
	public String getComboName(Integer combo_id) {
		// TODO Auto-generated method stub
		return dao.getComboName(combo_id);
	}

	@Override
	public void changeCombo(String user_phone, Integer comboID) {
		// TODO Auto-generated method stub
		dao.changeCombo(user_phone, comboID);
	}

}
