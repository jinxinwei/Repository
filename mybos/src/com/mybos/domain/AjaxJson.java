package com.mybos.domain;

import flexjson.JSONSerializer;

public class AjaxJson {
	private String message;
	private String urlAddress="";
	
	public AjaxJson(String message){
		this.message=message;
	}
	public AjaxJson(String message,String urlAddress){
		this.message=message;
		this.urlAddress=urlAddress;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getUrlAddress() {
		return urlAddress;
	}
	public void setUrlAddress(String urlAddress) {
		this.urlAddress = urlAddress;
	}
	
	
	@Override
	public String toString() {
		JSONSerializer jsonSerializer=new JSONSerializer();
		jsonSerializer.exclude("*.class");
		return jsonSerializer.serialize(this);

	}
	

}
