package com.jooring.servlet.ex;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletEx01Controller extends HttpServlet{

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		//text/css와 비슷하넨 MIME문자열의 규격을 정하는 표준. 파일들의 타입을 정해준댜
		
		response.setContentType("text/plain");
		//캐릭터셋 , 인코딩
		response.setCharacterEncoding("utf-8");
		
		//현재 날짜와 시간을 보여주는 페이지
		Date now = new Date();
		
		PrintWriter out = response.getWriter();
		
		out.println(now);
		
		
		SimpleDateFormat fomatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		String dateString = fomatter.format(now);
		
		out.println(dateString);
		
	}
}
