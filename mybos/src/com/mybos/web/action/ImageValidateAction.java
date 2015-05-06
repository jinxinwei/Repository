package com.mybos.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.mybos.utils.MyUtil;
import com.mybos.utils.ValidateCode;
import com.opensymphony.xwork2.ActionSupport;


@Controller
@Scope("prototype")
public class ImageValidateAction extends ActionSupport{

	public String execute() throws Exception {
		HttpServletResponse response=ServletActionContext.getResponse();
		HttpServletRequest request=ServletActionContext.getRequest();
		response.setContentType("image/jpeg");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		
		HttpSession session = request.getSession();
		
		ValidateCode vCode = new ValidateCode(80,25,4,100);
		session.setAttribute(MyUtil.VALIDATECODE, vCode.getCode());
		vCode.write(response.getOutputStream());
		return NONE;
	}
	
}
