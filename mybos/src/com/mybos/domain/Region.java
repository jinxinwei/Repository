package com.mybos.domain;

import java.util.HashSet;
import java.util.Set;

public class Region {

	   private Long id;//                   varchar(32) not null,  // 编号
	   private String province;//             varchar(50),  // 省
	   private String city;//                 varchar(50), // 市
	   private String district;//             varchar(50), // 区
	   private String postcode;//             varchar(50), // 邮编
	   private String shortcode;//            varchar(30), // 简码
	   private String citycode;//             varchar(30), // 城市编码	
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
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getShortcode() {
		return shortcode;
	}
	public void setShortcode(String shortcode) {
		this.shortcode = shortcode;
	}
	public String getCitycode() {
		return citycode;
	}
	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}
	
}
