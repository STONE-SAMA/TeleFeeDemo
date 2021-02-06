package com.stone.teleFee.service;

import java.util.List;

import com.stone.teleFee.beans.records;
import com.stone.teleFee.dao.RecordDao;
import com.stone.teleFee.dao.RecordDaoImpl;

public class RecordServiceImpl implements RecordService {

	private RecordDao dao;
	
	public RecordServiceImpl() {
		dao = new RecordDaoImpl();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Integer getRecordCount(String userPhone) {
		// TODO Auto-generated method stub
		return dao.getRecordCount(userPhone);
	}

	@Override
	public List<records> getRecordList(Integer pageNo, Integer pageSize, String userPhone) {
		// TODO Auto-generated method stub
		return dao.getRecordList(pageNo, pageSize, userPhone);
	}

	@Override
	public void addRecord(String user_phone, String time, String note) {
		// TODO Auto-generated method stub
		dao.addRecord(user_phone, time, note);
	}

}
