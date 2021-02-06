package com.stone.teleFee.beans;

import java.util.ArrayList;
import java.util.List;

import com.stone.teleFee.service.ComboService;
import com.stone.teleFee.service.ComboServiceImpl;

public class comboPage {
	// 每页显示记录数
	private int pageSize = 10;
	// 当前页码
	private int pageNo = 1;
	// 总页数
	private int totalPages;
	// 每页数据记录集合
	private List<Combo> pageData = new ArrayList<Combo>();
	// 是否有下一页
	private boolean hasNextPage;
	// 是否有上一页
	private boolean hasPreviousPage;
	
	ComboService service = new ComboServiceImpl();
	
	public comboPage() {
		// TODO Auto-generated constructor stub
	}

	public comboPage(int pageSize, int pageNo) {
		this.pageSize = pageSize;
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getTotalPages() {
		//获取总记录数
		Integer total = service.getRecordCount();
		//返回总页数
		return (total + pageSize - 1) / pageSize;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public List<Combo> getPageData() {
		//查询当页记录
		List<Combo> list = service.getComboList(pageNo, pageSize);
		return list;
	}

	public void setPageData(List<Combo> pageData) {
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
