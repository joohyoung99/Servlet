package com.jooring.servlet.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/test04")
public class ServletTest04Controller extends HttpServlet{

	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		out.println("<html><head><title>리스트출력</title></head><body>");
		for(int i = 1; i<=30; i++) {
		   String stringList =i +"번째 리스트" ;
		   out.println("<li>" +stringList+"</li>");
		}
		
		out.println("</ul></body></html>");
		
		
	}
}
