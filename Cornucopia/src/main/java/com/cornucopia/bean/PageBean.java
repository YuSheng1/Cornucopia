package com.cornucopia.bean;

import org.springframework.stereotype.Component;

@Component
public class PageBean {

	private int page;//页码
	private int size;//每页显示的行数
	private int total; //总行数
	private int totalpage; //总页数   

	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	//计算頁數
	public int getTotalpage() {
		if(total%size==0){
			return total/size;
		}else{
			return (total/size)+1;
		}
	}
	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}
	
}
