package com.jooring.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletTest01Controller extends HttpServlet {
	
	@Override 
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		response.setContentType("text/plain");
		
		response.setCharacterEncoding("utf-8");
		
		
		
		//오늘 날짜 출력 
		Date now = new Date();
		
		PrintWriter out = response.getWriter();
		
		
		SimpleDateFormat formatter = new SimpleDateFormat("오늘의 날짜는 yyyy년 M월 d일");
	
	 
        String dateString = formatter.format(now);
		
		out.println(dateString);
	
		
		//out.println("오늘의 날짜는 "+ dateString);
	
	}

}
