package com.stone.teleFee.dao;

import java.util.List;

import com.stone.teleFee.beans.records;

public interface RecordDao {
	
	//得到记录总数
	Integer getRecordCount(String userPhone);
	//当页记录
	List<records> getRecordList(Integer pageNo, Integer pageSize, String userPhone);
	//添加套餐变更记录
	void addRecord(String user_phone, String time, String note);

}
