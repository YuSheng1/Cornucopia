package com.cornucopia.bean;

import org.springframework.stereotype.Component;

@Component
public class PageBean {

	private int page;//ҳ��
	private int size;//ÿҳ��ʾ������
	private int total; //������
	private int totalpage; //��ҳ��   

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
	//����퓔�
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
