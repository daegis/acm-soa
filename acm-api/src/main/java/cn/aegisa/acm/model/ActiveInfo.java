package cn.aegisa.acm.model;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * ActiveInfo Entity.
 */
public class ActiveInfo implements Serializable{
	
	//列信息
	private Integer id;
	
	private String activeName;
	
	private java.util.Date activeStartDatetime;
	
	private BigDecimal activePrice;
	
	private Integer activeDayCount;
	
	private Integer activeStatus;
	

		
	public void setId(Integer value) {
		this.id = value;
	}
	
	public Integer getId() {
		return this.id;
	}
		
		
	public void setActiveName(String value) {
		this.activeName = value;
	}
	
	public String getActiveName() {
		return this.activeName;
	}
		
		
	public void setActiveStartDatetime(java.util.Date value) {
		this.activeStartDatetime = value;
	}
	
	public java.util.Date getActiveStartDatetime() {
		return this.activeStartDatetime;
	}
		
		
	public void setActivePrice(BigDecimal value) {
		this.activePrice = value;
	}
	
	public BigDecimal getActivePrice() {
		return this.activePrice;
	}
		
		
	public void setActiveDayCount(Integer value) {
		this.activeDayCount = value;
	}
	
	public Integer getActiveDayCount() {
		return this.activeDayCount;
	}
		
		
	public void setActiveStatus(Integer value) {
		this.activeStatus = value;
	}
	
	public Integer getActiveStatus() {
		return this.activeStatus;
	}
		
}

