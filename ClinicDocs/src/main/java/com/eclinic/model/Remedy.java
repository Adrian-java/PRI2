package com.eclinic.model;

public class Remedy {

	private String name;
	private String repayment;
	
	public Remedy(String name, String repayment) {
		this.name = name;
		this.repayment = repayment;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRepayment() {
		return repayment;
	}

	public void setRepayment(String repayment) {
		this.repayment = repayment;
	}
	
	
	
}
