package com.eclinic.user.mangament;

public interface PassService {

	boolean checkOldPassword(PassModel pm);
	
	boolean changePassword(PassModel pm);
	
	boolean checkPassAndRepeatPass(PassModel pm);
}
