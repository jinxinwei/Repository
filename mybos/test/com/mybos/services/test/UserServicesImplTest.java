package com.mybos.services.test;




import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mybos.domain.User;
import com.mybos.services.UserServices;
import com.mybos.utils.MD5;

public class UserServicesImplTest {
	UserServices userServices;
	public UserServicesImplTest(){
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		userServices=(UserServices)applicationContext.getBean("userServicesImpl");
	}
	@Test
	public void save(){
		
		for(int i=1;i<20;i++){
			User entity=new User();
			entity.setName("jinxinwei"+i);
			entity.setPassword(MD5.MD5Encode("jinxinwei"+i));
			entity.setBirthday(new Date());
			entity.setCompany("华为技术有限公司");
			entity.setSalary(8000L);
			entity.setSex("男");
			entity.setTelephone("13916671198");
			userServices.save(entity);
		}
	}
	
	@Test
	public void delete(){
		userServices.delete(1L);
	}
	
	@Test
	public void update(){
		User user=userServices.findById(1L);
		user.setCompany("华为荣耀技术有限公司");
		userServices.update(user);		
	}
	
	@Test
	public void findById(){
		User user=userServices.findById(1L);
		System.out.println(user.toString());
	}
	
	@Test
	public void findByIds(){
		Long[] ids={1L,2L,3L};
		List<User> users=userServices.findByIds(ids);
		for(User user:users){
			System.out.println(user.toString());
		}
	}
	
	@Test
	public void login(){
		User user=new User();
		user.setName("jinxinwei");
		user.setPassword(MD5.MD5Encode("jinxinwei"));		
		user=userServices.login(user);
		if(user==null){
			System.out.println("用户不存在!");
		}
	}
	
	@Test
	public void editPassword(){
		
		User user=new User();
		user.setId(2L);
		user.setPassword(MD5.MD5Encode("jinxinwei"));
		userServices.editPassword(user);
		
	}

}
