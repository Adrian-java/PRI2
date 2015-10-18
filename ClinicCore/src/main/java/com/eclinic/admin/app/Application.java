package com.eclinic.admin.app;

public class Application {

	public static enum AppRoles {
		Admin, Super_Admin, User
	}
	
	private static boolean normalAdminLogged;
	
	private static boolean superAdminLogged;

	public static boolean isNormalAdminLogged() {
		return normalAdminLogged;
	}

	public static void setNormalAdminLogged(boolean normalAdminLogged) {
		Application.normalAdminLogged = normalAdminLogged;
	}

	public static boolean isSuperAdminLogged() {
		return superAdminLogged;
	}

	public static void setSuperAdminLogged(boolean superAdminLogged) {
		Application.superAdminLogged = superAdminLogged;
	}

}
