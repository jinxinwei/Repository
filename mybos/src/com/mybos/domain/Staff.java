package com.mybos.domain;

import java.util.HashSet;
import java.util.Set;

public class Staff {

	  private Long id;//                   varchar(32) not null,   // ���
	  private String name;//                 varchar(20),   // ����
	  private String telephone;//            int,   // �ֻ�
	  private Boolean haspda;//               char(1),  // �Ƿ���PDA �ƶ��豸 
	  private Boolean deltag;//               char(1),  // ���ϱ�־
	  private String station;//              varchar(40), // ������˾
	  private Standard standard;//          varchar(32), // ����ȡ�ɱ�׼ 	
	  private Set<Decidedzone> decidedzones=new HashSet<Decidedzone>();
	public Set<Decidedzone> getDecidedzones() {
		return decidedzones;
	}
	public void setDecidedzones(Set<Decidedzone> decidedzones) {
		this.decidedzones = decidedzones;
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
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public Boolean getHaspda() {
		return haspda;
	}
	public void setHaspda(Boolean haspda) {
		this.haspda = haspda;
	}
	public Boolean getDeltag() {
		return deltag;
	}
	public void setDeltag(Boolean deltag) {
		this.deltag = deltag;
	}
	public String getStation() {
		return station;
	}
	public void setStation(String station) {
		this.station = station;
	}
	public Standard getStandard() {
		return standard;
	}
	public void setStandard(Standard standard) {
		this.standard = standard;
	}
	
	  
}
