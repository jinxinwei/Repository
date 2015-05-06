package com.mybos;

import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class HibernateTest {

	@Test
	public void sessionFactory(){
		
		Configuration configuration=new Configuration().configure("hibernate.cfg.xml");
		configuration.buildSessionFactory();
	}
}
