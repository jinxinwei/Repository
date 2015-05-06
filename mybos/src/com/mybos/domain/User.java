package com.mybos.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class User implements Serializable{
	private Long id;
	private String name;
	
	private String password;
	private String sex;
	private Date birthday;
	private String company;//公司
	
	private Long salary;//工资
	private String telephone;
	
	private String info;
	
	private Set<Standard> standards=new HashSet<Standard>();
	
	
	public Set<Standard> getStandards() {
		return standards;
	}

	public void setStandards(Set<Standard> standards) {
		this.standards = standards;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Long getSalary() {
		return salary;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setSalary(Long salary) {
		this.salary = salary;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	private Set<Role> roles=new HashSet<Role>();
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
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

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", sex=" + sex
				+ ", birthday=" + birthday + ", company=" + company
				+ ", salary=" + salary + ", telephone=" + telephone + "]";
	}

	
}
