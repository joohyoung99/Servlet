package com.jooring.database.test;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jooring.common.MySqlService;

public class ServletDBTest02Controller extends HttpServlet{

	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		
		
		
		MySqlService mysqlService = MySqlService.getInstance();
	    mysqlService.connect();
	
	
	};
}
