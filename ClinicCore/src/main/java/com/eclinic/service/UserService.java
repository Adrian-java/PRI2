package com.eclinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.eclinic.dao.SystemUserDAO;
import com.eclinic.domain.SystemUser;

@Service("userService")
public class UserService implements UserDetailsService {
	
	
	@Autowired
	private SystemUserDAO systemUserDao;
	
	@Autowired
	private SessionBean sessionBean;

	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {

		SystemUser su = systemUserDao.findSystemUserById(username);
		sessionBean.setSystemUser(su);
		return su;
	}

}
