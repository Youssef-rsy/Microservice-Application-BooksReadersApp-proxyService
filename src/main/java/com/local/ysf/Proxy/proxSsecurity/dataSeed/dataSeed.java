package com.local.ysf.Proxy.proxSsecurity.dataSeed;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;
import com.local.ysf.Proxy.proxSsecurity.Entity.BookReaderRole;
import com.local.ysf.Proxy.proxSsecurity.Entity.BookReaderUser;
import com.local.ysf.Proxy.proxSsecurity.business.BookReaderUserService;

@Component
public class dataSeed {
	
	@Autowired
	private BookReaderUserService service;
	
	//@PostConstruct
	public void data(){
		
		service.saveRole(new BookReaderRole(null, "ADMIN"));
		service.saveRole(new BookReaderRole(null, "USER"));
		
		service.saveUser(new BookReaderUser(null, "admin","admin",null));
		service.saveUser(new BookReaderUser(null, "user","user",null));
		
		service.addRoleToUser("admin", "ADMIN");
		service.addRoleToUser("admin", "USER");
		service.addRoleToUser("user", "USER");
	
	}
	
}
