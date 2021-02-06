package com.stone.teleFee.service;

import java.util.List;

import com.stone.teleFee.beans.Combo;

public interface ComboService {

	Integer getRecordCount();

	List<Combo> getComboList(int pageNo, int pageSize);

	Combo getComboByID(String comboID);

	String getComboName(Integer combo_id);

	void changeCombo(String user_phone, Integer comboID);


}
