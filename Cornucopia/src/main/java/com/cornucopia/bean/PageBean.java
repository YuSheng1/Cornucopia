package com.cornucopia.bean;

import org.springframework.stereotype.Component;

@Component
public class PageBean {

	private int page1=1;//ҳ��
	private int page2=1;//ҳ��
	private int page3=1;//ҳ��
	private int size;//ÿҳ��ʾ������
	private int total1; //������
	private int total2; //������
	private int total3; //������
	private int totalpage1; //��ҳ��   
	private int totalpage2; //��ҳ��
	private int totalpage3; //��ҳ��

	public int getPage1() {
		return page1;
	}
	public void setPage1(int page1) {
		this.page1 = page1;
	}
	public int getPage2() {
		return page2;
	}
	public void setPage2(int page2) {
		this.page2 = page2;
	}
	public int getPage3() {
		return page3;
	}
	public void setPage3(int page3) {
		this.page3 = page3;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getTotal1() {
		return total1;
	}
	public void setTotal1(int total1) {
		this.total1 = total1;
	}
	public int getTotal2() {
		return total2;
	}
	public void setTotal2(int total2) {
		this.total2 = total2;
	}
	public int getTotal3() {
		return total3;
	}
	public void setTotal3(int total3) {
		this.total3 = total3;
	}
	//����퓔�
	public int getTotalpage1() {
		if(total1%size==0){
			return total1/size;
		}else{
			return (total1/size)+1;
		}
	}
	public void setTotalpage1(int totalpage1) {
		this.totalpage1 = totalpage1;
	}
	
	//����퓔�
		public int getTotalpage2() {
			if(total2%size==0){
				return total2/size;
			}else{
				return (total2/size)+1;
			}
		}
		public void setTotalpage2(int totalpage2) {
			this.totalpage2 = totalpage2;
		}
		
		//����퓔�
		public int getTotalpage3() {
			if(total3%size==0){
				return total3/size;
			}else{
				return (total3/size)+1;
			}
		}
		public void setTotalpage3(int totalpage3) {
			this.totalpage3 = totalpage3;
		}
	
}
