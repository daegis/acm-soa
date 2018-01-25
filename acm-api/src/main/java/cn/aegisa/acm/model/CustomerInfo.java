package cn.aegisa.acm.model;

import java.io.Serializable;


/**
 * CustomerInfo Entity.
 */
public class CustomerInfo implements Serializable{
	
	//列信息
	private Integer id;
	
	private String customerName;
	
	private String customerNickname;
	
	private String customerPhone;
	
	private String customerId;
	
	private String customerComment;
	
	private String customerAddress;
	

		
	public void setId(Integer value) {
		this.id = value;
	}
	
	public Integer getId() {
		return this.id;
	}
		
		
	public void setCustomerName(String value) {
		this.customerName = value;
	}
	
	public String getCustomerName() {
		return this.customerName;
	}
		
		
	public void setCustomerNickname(String value) {
		this.customerNickname = value;
	}
	
	public String getCustomerNickname() {
		return this.customerNickname;
	}
		
		
	public void setCustomerPhone(String value) {
		this.customerPhone = value;
	}
	
	public String getCustomerPhone() {
		return this.customerPhone;
	}
		
		
	public void setCustomerId(String value) {
		this.customerId = value;
	}
	
	public String getCustomerId() {
		return this.customerId;
	}
		
		
	public void setCustomerComment(String value) {
		this.customerComment = value;
	}
	
	public String getCustomerComment() {
		return this.customerComment;
	}
		
		
	public void setCustomerAddress(String value) {
		this.customerAddress = value;
	}
	
	public String getCustomerAddress() {
		return this.customerAddress;
	}
		
}

