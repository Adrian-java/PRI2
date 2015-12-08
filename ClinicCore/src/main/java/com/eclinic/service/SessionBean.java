package com.eclinic.service;

import com.eclinic.domain.SystemUser;

public interface SessionBean {
	
	 SystemUser getLoggedSystemUser();
	 
	 void setSystemUser(SystemUser su);

}
