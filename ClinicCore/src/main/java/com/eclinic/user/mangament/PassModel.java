package com.eclinic.user.mangament;

public class PassModel {

	private String oldPass;
	
	private String newPass;
	
	private String repeatNewPass;
	
	private String id;

	public String getOldPass() {
		return oldPass;
	}

	public void setOldPass(String oldPass) {
		this.oldPass = oldPass;
	}

	public String getNewPass() {
		return newPass;
	}

	public void setNewPass(String newPass) {
		this.newPass = newPass;
	}

	public String getRepeatNewPass() {
		return repeatNewPass;
	}

	public void setRepeatNewPass(String repeatNewPass) {
		this.repeatNewPass = repeatNewPass;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
