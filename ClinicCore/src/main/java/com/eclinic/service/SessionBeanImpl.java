package com.eclinic.service;

import org.springframework.stereotype.Service;

import com.eclinic.domain.SystemUser;

@Service("SessionBean")
//@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.INTERFACES)
public class SessionBeanImpl implements SessionBean {

	private SystemUser su;

	public SystemUser getLoggedSystemUser() {
		return su;
	}

	public void setSystemUser(SystemUser su) {
		this.su = su;

	}

}
