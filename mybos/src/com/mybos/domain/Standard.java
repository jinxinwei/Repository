package com.mybos.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

//���ɱ�׼��
public class Standard {

	  private Long id; //                  varchar(32) not null,   // ��� uuid����
	  private String name;//                 varchar(30),  // ��׼���� 
	  private Double minweight;//            double,      // ��С����
	  private Double maxweight;//            double,      // �������
	  private Boolean deltag;//               char(1),     // �Ƿ�����  1 ���ϣ� 0 ����ʹ��
	  private User user;//              int,         // ������ 
	  private Date updatetime;//           timestamp,   // ����ʱ�� 
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
