package com.jooring.servlet.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/servlet/test07")
public class ServletTest07Controller extends HttpServlet {
	
	@Override
	public void doGet (HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		
		String addressString = request.getParameter("address");
		String creditCard = request.getParameter("creditcard");
		String priceString = request.getParameter("price");
		
		
		String address = addressString.substring(0,3);
		
		
		
		
		out.println("<html><head><title>결제완료</title></head>");
		out.println("<body>");
		out.println("<h2>" );
		if(!address.equals("서울시")) {
			out.println("배달 불가 지역입니다.</h2>");
			out.println("</body></html>");
		}else if(creditCard.equals("신한카드")){
			out.println("결제 불가 카드입니다</h2>");
			out.println("</body></html>");
		}else {
			out.println(addressString + "으로 배달 준비중 </h2>");
			out.println("<hr>결제 금액: " + priceString + "원");
			out.println("</body></html>");
		
	      }
		
	
	}
	

}
