<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
    <%
    if(session.getAttribute("cookieConsent") == null){
    	out.print("<div class='fixed-bottom note note-warning'>");
    	out.print("<form id='acceptCookies' class='d-flex align-items-center' action='CookieServlet' method='post'>"
    	+"<p>This site uses cookies for some of it's feutures, press accept to consent</p>");
    			
    	out.print("<button name='consent' type='submit' class='btn btn-success btn-rounded' style='margin-left: 15px;' value='yes'>Accept</button>");
    	out.print("<button name='consent' type='submit' class='btn btn-danger btn-rounded' value='no'>Decline</button>");
    	out.print("</form></div>");
    }  
    %>