package com.mybos.domain;

public class Subarea {

	private Long id;//                   varchar(32) not null,  // 编号
	private Decidedzone decidedzone;//       varchar(32),  // 定区编号
	private Region region;//            varchar(32),  // 区域编号 
	private String addresskey;//           varchar(100), // 关键字
	private String startnum;//             varchar(30),  // 开始 楼、小区 、街道号 
	private String endnum;//               varchar(30),  // 结束 楼、小区、街道号
	private Boolean single;//               char(1),      // 单双号 
	private String position;//             varchar(255), // 位置信息 	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Decidedzone getDecidedzone() {
		return decidedzone;
	}
	public void setDecidedzone(Decidedzone decidedzone) {
		this.decidedzone = decidedzone;
	}
	public Region getRegion() {
		return region;
	}
	public void setRegion(Region region) {
		this.region = region;
	}
	public String getAddresskey() {
		return addresskey;
	}
	public void setAddresskey(String addresskey) {
		this.addresskey = addresskey;
	}
	public String getStartnum() {
		return startnum;
	}
	public void setStartnum(String startnum) {
		this.startnum = startnum;
	}
	public String getEndnum() {
		return endnum;
	}
	public void setEndnum(String endnum) {
		this.endnum = endnum;
	}
	public Boolean getSingle() {
		return single;
	}
	public void setSingle(Boolean single) {
		this.single = single;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	
}
