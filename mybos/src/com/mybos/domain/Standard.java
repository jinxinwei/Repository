package com.mybos.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

//收派标准表
public class Standard {

	  private Long id; //                  varchar(32) not null,   // 编号 uuid生成
	  private String name;//                 varchar(30),  // 标准名称 
	  private Double minweight;//            double,      // 最小重量
	  private Double maxweight;//            double,      // 最大重量
	  private Boolean deltag;//               char(1),     // 是否作废  1 作废， 0 正常使用
	  private User user;//              int,         // 操作人 
	  private Date updatetime;//           timestamp,   // 更新时间 
	  private Set<Staff> staffs=new HashSet<Staff>();
	  
	public Set<Staff> getStaffs() {
		return staffs;
	}
	public void setStaffs(Set<Staff> staffs) {
		this.staffs = staffs;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getMinweight() {
		return minweight;
	}
	public void setMinweight(Double minweight) {
		this.minweight = minweight;
	}
	public Double getMaxweight() {
		return maxweight;
	}
	public void setMaxweight(Double maxweight) {
		this.maxweight = maxweight;
	}
	public Boolean getDeltag() {
		return deltag;
	}
	public void setDeltag(Boolean deltag) {
		this.deltag = deltag;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Date getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
	  
	
}
