package com.mybos.domain;

import java.util.HashSet;
import java.util.Set;

public class Decidedzone {

	   private Long id;//                varchar(32) not null,  // ±àºÅ
	   private String name;//                 varchar(30),   // Ãû³Æ
	   private Staff staff;//             varchar(32),  // È¡ÅÉÔ± 	
	   private Set<Subarea> subareas=new HashSet<Subarea>();
	public Set<Subarea> getSubareas() {
		return subareas;
	}
	public void setSubareas(Set<Subarea> subareas) {
		this.subareas = subareas;
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
	public Staff getStaff() {
		return staff;
	}
	public void setStaff(Staff staff) {
		this.staff = staff;
	}
	
}
