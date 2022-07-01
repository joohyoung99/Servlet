package com.jooring.database.ex;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jooring.common.MySqlService;

@WebServlet("/db/ex02/delete")
public class ServletDBEx02DeleteController extends HttpServlet{

	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		
		
		String id = request.getParameter("id");
		
		MySqlService mysqlService = MySqlService.getInstance();
		
		mysqlService.connect();
		
		String query = "delete from `new_user` where `id` = " +id+ ";" ;
		
		mysqlService.update(query);
		
		try {
			response.sendRedirect("/db/ex02.jsp");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
}
