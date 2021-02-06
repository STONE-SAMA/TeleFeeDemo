package com.stone.teleFee.beans;

import java.util.*;

import com.stone.teleFee.service.RecordService;
import com.stone.teleFee.service.RecordServiceImpl;

public class recordPage {
	private Integer pageSize = 10;
	private Integer pageNo = 1;
	private Integer totalPages;
	private List<records> pageData = new ArrayList<records>();
	private boolean hasNextPage;
	private boolean hasPreviousPage;
	private String userPhone;//用户手机号
	
	RecordService service = new RecordServiceImpl();
	
	public recordPage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public recordPage(Integer pageSize, Integer pageNo, String userPhone) {
		super();
		this.pageSize = pageSize;
		this.pageNo = pageNo;
		this.userPhone = userPhone;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getTotalPages() {
		//获取总记录数
		Integer total = service.getRecordCount(userPhone);
		return (total + pageSize - 1) / pageSize;
	}

	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}
	

	public List<records> getPageData() {
		//获取记录
		List<records> list = service.getRecordList(pageNo, pageSize, userPhone);
		return list;
	}

	public void setPageData(List<records> pageData) {
		this.pageData = pageData;
	}

	public boolean isHasNextPage() {
		return (this.getPageNo() < this.getTotalPages());
	}

	public void setHasNextPage(boolean hasNextPage) {
		this.hasNextPage = hasNextPage;
	}

	public boolean isHasPreviousPage() {
		return (this.getPageNo() > 1);
	}

	public void setHasPreviousPage(boolean hasPreviousPage) {
		this.hasPreviousPage = hasPreviousPage;
	}
	
	
}
