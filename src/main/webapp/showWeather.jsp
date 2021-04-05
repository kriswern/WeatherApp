<%@page import="com.sun.org.apache.xpath.internal.operations.Div"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="model.weatherBean"%>
<div class="d-flex justify-content-center">

<div class='card text-center border w-35 hover-shadow margin m-2' style='background-color:#ffffff; width: 250px;'>

	<%
	@SuppressWarnings("unchecked")
	weatherBean wBean = (weatherBean) request.getAttribute("wBean");

	out.print("<div class='card-header' id='cityName'>" + wBean.getCityStr().toUpperCase() + "</div>"
			  +"<div class='card-body'>"
			  +"<h1 class='card-title text-primary'>"+ wBean.getTemperature() +"<span class='position-absolute top' style='font-size: 20px;'>&#x2103;</span></h1>"
			  +"<p class='card-text'>"
			  +wBean.getCloudsStr() + " and wind coming from " + wBean.getWind()
			  +"</p>"
			  +"</div>"
			  +"</div>");
	%>
	
	
</div>

</div>