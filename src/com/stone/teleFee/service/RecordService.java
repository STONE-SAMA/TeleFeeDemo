package com.stone.teleFee.service;

import java.util.List;

import com.stone.teleFee.beans.records;

public interface RecordService {

	Integer getRecordCount(String userPhone);

	List<records> getRecordList(Integer pageNo, Integer pageSize, String userPhone);

	void addRecord(String user_phone, String time, String note);

}
