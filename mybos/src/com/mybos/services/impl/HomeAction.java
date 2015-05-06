package com.mybos.services.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;


@Controller
@Scope("prototype")
public class HomeAction extends ActionSupport {

	
	public String index() throws Exception {
		return "index";
	}
}
