package com.jooring.database.test;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jooring.common.MySqlService;

@WebServlet("/db/test02/delete")

public class ServletDBTest02DeleteController extends HttpServlet{

	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		
		
		String id = request.getParameter("id");
		
		MySqlService mysqlService = MySqlService.getInstance();
		mysqlService.connect();
		
		String query = "DELETE FROM `url_table` WHERE `id` = " + id + ";";
		
		mysqlService.update(query);
		
		try {
			response.sendRedirect("/db/test02_1.jsp");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
}
