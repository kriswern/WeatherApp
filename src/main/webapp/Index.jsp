<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="model.weatherBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css"
	rel="stylesheet" />
<!-- Google Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap"
	rel="stylesheet" />
<!-- MDB -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/3.3.0/mdb.min.css"
	rel="stylesheet">
</head>

<body class="bg-light bg-image" style="background-image: url('weather.jpg'); height: 100vh">

		<header>
			<jsp:include page="form.jsp" />
		</header>





		<main style="margin: 20px">
			<%
weatherBean bean = (weatherBean) request.getAttribute("wBean");
if (bean != null) {%>
			<jsp:include page="showWeather.jsp" />
			<%}%>
		</main>


	<jsp:include page="cookies.jsp" />
	<jsp:include page="cookieConsent.jsp" />





	<script type="text/javascript">
		getCookie();
	</script>


	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/3.3.0/mdb.min.js">
		
	</script>
</body>
</html>