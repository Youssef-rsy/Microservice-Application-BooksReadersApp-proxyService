package com.local.ysf.Proxy.proxSsecurity.business;

import com.local.ysf.Proxy.proxSsecurity.Entity.BookReaderRole;
import com.local.ysf.Proxy.proxSsecurity.Entity.BookReaderUser;

public interface BookReaderUserService {
	
	public BookReaderUser saveUser(BookReaderUser user);
	
	public BookReaderRole saveRole(BookReaderRole role);
	
	public BookReaderUser getUserByUsername(String username);
	
	void addRoleToUser(String username, String role);

}
