package com.mybos.web.action;

import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import sun.org.mozilla.javascript.internal.EcmaError;

import com.mybos.domain.AjaxJson;
import com.mybos.domain.PageBean;
import com.mybos.domain.User;
import com.mybos.utils.MD5;
import com.mybos.utils.MyUtil;
import com.mybos.utils.QueryHelp;
import com.opensymphony.xwork2.ActionContext;

import flexjson.JSONSerializer;

@Controller
@Scope("prototype")
public class UserAction extends BaseAction<User>{
	
	private Long[] ids;
	
	
	public Long[] getIds() {
		return ids;
	}

	public void setIds(Long[] ids) {
		this.ids = ids;
	}

	private String validateCode;
	
	private String repeatPassword;
	private String newPassword;
	
	private Date beginBirthday;
	private Date endBirthday;
	


	public Date getBeginBirthday() {
		return beginBirthday;
	}

	public void setBeginBirthday(Date beginBirthday) {
		this.beginBirthday = beginBirthday;
	}

	public Date getEndBirthday() {
		return endBirthday;
	}

	public void setEndBirthday(Date endBirthday) {
		this.endBirthday = endBirthday;
	}

	public String getRepeatPassword() {
		return repeatPassword;
	}

	public void setRepeatPassword(String repeatPassword) {
		this.repeatPassword = repeatPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String loginUI() throws Exception {
		return "loginUI";
	}

	public String login() throws Exception {
		String code=(String)ServletActionContext.getRequest().getSession().getAttribute(MyUtil.VALIDATECODE);
		if(!this.validateCode.toLowerCase().equals(code.toLowerCase())){
			this.addFieldError("validatecodeerror",this.getText("validatecode.error"));
			return INPUT;
		}
		
		
		this.entity=userServices.login(this.entity);
		if(this.entity==null){
			this.addFieldError("usererror",this.getText("user.error"));
			return INPUT;
		}
		ServletActionContext.getRequest().getSession().setAttribute(MyUtil.USER, this.entity);
		return SUCCESS;
	}
	
	public String logout()throws Exception{
		ServletActionContext.getRequest().getSession().invalidate();
		AjaxJson json=new AjaxJson("退出成功!",MyUtil.getUrl("user.loginUI"));
		sendResponse(json);
		return NONE;
	}
	

	private void sendResponse(AjaxJson json)throws Exception{
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/json");
		response.setCharacterEncoding("utf-8");
		response.getWriter().println(json.toString());
	}
	
	private void sendResponse(String value)throws Exception{
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/json");
		response.setCharacterEncoding("utf-8");
		response.getWriter().println(value);		
	}
	
	public String index(){

		
		return "index";
	}
	
	
	// TODO 条件查询没有完成，通过get方法传过来的sex字段接收过来的中文还需要编码
	public String list()throws Exception{
		if(this.entity.getSex()!=null&&this.entity.getSex().length()>0){
			this.entity.setSex(URLDecoder.decode(URLDecoder.decode(this.entity.getSex(), "utf-8"),"utf-8"));
		}
		
		if(this.entity.getName()!=null&&this.entity.getName().length()>0){
			this.entity.setName(URLDecoder.decode(URLDecoder.decode(this.entity.getName(), "utf-8"),"utf-8"));
		}
		
		
		PageBean<User> pageBean=new QueryHelp(User.class)
		.addWhere((this.entity.getName()!=null&&!this.entity.getName().trim().equals("")),"name like ?", "%"+this.entity.getName()+"%")
		.addWhere((this.entity.getSex()!=null&&!this.entity.getSex().trim().equals("")),"sex=?", this.entity.getSex())
		.addWhere((this.getBeginBirthday()!=null),"birthday>=?",this.getBeginBirthday())
		.addWhere((this.getEndBirthday()!=null),"birthday<=?",this.getEndBirthday())
		.addOrder("id", true)
		.getPageBean(userServices,page,pageSize);
		
		//JSONSerializer jsonSerializer=new JSONSerializer();
		//jsonSerializer.exclude("*.class");
		//String json=jsonSerializer.deepSerialize(pageBean.getEntitys());
		//System.out.println(json);
		
		ActionContext.getContext().put("pageBean", pageBean);
		return "list";
		//sendResponse(json);
		//return NONE;
	}
	

	
	public String addUI(){
		return "info";
	}
	
	
	public String add(){
		if(this.entity.getName().isEmpty()){
			this.addFieldError("name.required", this.getText("name.required"));
		}
		
		if(this.entity.getPassword().isEmpty()){
			this.addFieldError("password.required", this.getText("password.required"));
		}
		
		if(this.entity.getSex().isEmpty()){
			this.addFieldError("sex.required",this.getText("sex.required"));
		}
		if(this.getFieldErrors().size()>0){
			return "info";
		}
		entity.setPassword(MD5.MD5Encode(entity.getPassword()));
		userServices.save(entity);
		return "toList";
	}
	public String editUI(){
		this.entity=userServices.findById(this.entity.getId());
		ActionContext.getContext().getValueStack().push(this.entity);
		return "info";
	}
	public String edit(){
		if(this.entity.getName()==null||this.entity.getName().trim().equals("")){
			this.addFieldError("name.required", this.getText("name.required"));
		}
		
		if(this.getFieldErrors().size()>0){
			return "info";
		}
		
		if(entity.getPassword()==null||entity.getPassword().equals("")){
			User user=userServices.findById(entity.getId());
			entity.setPassword(user.getPassword());
		}else{
			entity.setPassword(MD5.MD5Encode(entity.getPassword()));
		}
		
		userServices.update(entity);
		
		return "toList";
	}

	public String editPassword()throws Exception{
		AjaxJson json=null;
		User user=MyUtil.getSessionUser(ServletActionContext.getRequest());

		
		user.setPassword(this.entity.getPassword());
		user=userServices.login(user);
		if(user==null){
			json=new AjaxJson("旧密码错误!");
			sendResponse(json);
			return NONE;
		}
		
		if(newPassword.isEmpty()||repeatPassword.isEmpty()){
			json=new AjaxJson("新密码或者重复密码为空!");
			sendResponse(json);
			return NONE;
		}
		
		if(!this.newPassword.equals(this.repeatPassword)){
			json=new AjaxJson("两次密码输入不一致，请重新输入!");
			sendResponse(json);
			return NONE;
		}
		
		user.setPassword(MD5.MD5Encode(this.newPassword));
		userServices.update(user);
		json=new AjaxJson("修改成功!");
		sendResponse(json);
		return NONE;
	}
	
	
	public String getValidateCode() {
		return validateCode;
	}

	public void setValidateCode(String validateCode) {
		this.validateCode = validateCode;
	}
	
	
	public String delete()throws Exception{
		AjaxJson json=null;
		if(ids==null||ids.length<=0){
			json=new AjaxJson("请选择要删除的ID");
			sendResponse(json);
			return NONE;
		}
		userServices.delete(ids);
		json=new AjaxJson("删除成功!",MyUtil.getUrl("user.list"));
		sendResponse(json);
		return NONE;			
		
	}
	
	
}
