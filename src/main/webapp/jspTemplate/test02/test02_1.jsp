<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import = "java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>곡 세부페이지</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

  <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  
<link rel="stylesheet" href="style.css" type="text/css">

</head>
<body>


<%

    
    //title이 전달되면 id는 없다
    //id가 있으면 title없다
   	String title = request.getParameter("title");
    int targetId = 0;
	if(title == null){
    	targetId = Integer.parseInt(request.getParameter("id"));
	}
   
%>
<%@ include file="data.jsp" %>
<div id="wrap">
		<jsp:include page="header.jsp" />
		
		<jsp:include page="nav.jsp" />
		<section>
		
		
		<% for(Map<String, Object> music :musicList){ 
					
			int minute = (int)music.get("time")/60;
			int second = (int)music.get("time")% 60;
			int musicId = (Integer) music.get("id");
					
				if(title != null && title.equals(music.get("title"))
						|| (title == null && targetId == musicId)) {
						
				
		
			%>
			<h2>곡 정보</h2>
			<div class="songInfo d-flex border border-success p-3">
				
				<div>
					<img width="200" src="<%=music.get("thumbnail")%>">
				</div>
				<div class="ml-3">
					<div class="display-4"><%=music.get("title") %></div>
					<div class="text-success font-weight-bold"><%=music.get("singer") %></div>
					<div class="d-flex mt-4">
						<div class="text-secondary">앨범<br> 재생시간 <br> 작곡가<br> 작사가</div>
						<div class="ml-4 text-secondary"><%=music.get("album") %><br> <%=minute%>:<%=second %>  <br> <%=music.get("composer") %> <br> <%= music.get("lyricist") %></div>
					</div>
				</div>
				
			</div>
			<div class="mt-3 lyrics">
			<h2>가사</h2>
			<hr>
			<span>가사 정보 없음</span>
			<hr>
			</div>
		<%} }%>
		</section>
		
		
		
		<jsp:include page="footer.jsp" />
	
	
	</div>


	
</body>
</html>