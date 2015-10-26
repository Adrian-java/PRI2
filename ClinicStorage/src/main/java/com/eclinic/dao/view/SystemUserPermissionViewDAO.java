package com.eclinic.dao.view;

import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import com.eclinic.domain.view.SystemUserPermissionView;

public interface SystemUserPermissionViewDAO  extends JpaDao<SystemUserPermissionView>{

	public Set<SystemUserPermissionView> findSystemUserPermissionByPesel(String pesel);
}
