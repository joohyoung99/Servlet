package com.jooring.database.test;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jooring.common.MySqlService;

@WebServlet("/db/test02/insert")
public class SevletDBTest02InsertController extends HttpServlet{

	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		response.setContentType("text/plain");
		
		
		String name = request.getParameter("name");
		String url = request.getParameter("url");
		
		MySqlService mysqlService = MySqlService.getInstance();
		
		mysqlService.connect();
		
		String query = "insert into `url_table` ( `name`, `url`, `createdAt`, `updatedAt`)\r\n"
				+ "value ('"+ name + "','" + url + "',now(), now());";
		
		int count = mysqlService.update(query);
		
		response.sendRedirect("/db/test02_1.jsp");
	};
}
