package com.mybos.domain;

public class Subarea {

	private Long id;//                   varchar(32) not null,  // ���
	private Decidedzone decidedzone;//       varchar(32),  // �������
	private Region region;//            varchar(32),  // ������ 
	private String addresskey;//           varchar(100), // �ؼ���
	private String startnum;//             varchar(30),  // ��ʼ ¥��С�� ���ֵ��� 
	private String endnum;//               varchar(30),  // ���� ¥��С�����ֵ���
	private Boolean single;//               char(1),      // ��˫�� 
	private String position;//             varchar(255), // λ����Ϣ 	
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
