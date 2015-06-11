package com.pluralsight.security;

import java.io.Serializable;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;

public class FitnessPermissionEvaluator implements PermissionEvaluator{
	
	private DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public boolean hasPermission(Authentication auth, Object targetDomainOnject, Object permission) {
		JdbcTemplate template = new JdbcTemplate(dataSource);
		//makes easy to do some jdbc in this code block
		//in 1. index will represent the com.pluralsight.model.Goal
		Object [] args = {((User)auth.getPrincipal()).getUsername(),targetDomainOnject.getClass().getName(),
				permission.toString()};
		//build query
		int count = template.queryForObject("select count(*) from permissions p where p.username = ? "
				+ "and p.target = ? and p.permission = ?", args, Integer.class);
		//if coutn == 1 the it is valid
		if(count == 1)
			return true;
		
		return false;
	} 

	public boolean hasPermission(Authentication arg0, Serializable arg1,
			String arg2, Object arg3) {
		
		return false;
	}

	
	
	
}
