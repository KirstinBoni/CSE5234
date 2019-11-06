<%@ page import="edu.osu.cse5234.model.Order" %>
<%@ page import="edu.osu.cse5234.model.Item" %>
<%@ page import="edu.osu.cse5234.model.LineItem" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CATalogue</title>
</head>
<body>
<jsp:include page="Header.jsp"/>
<div class="container">
<h3> Your Order is Confirmed! </h3><br />
<h4>Please find the order Details below:</h4>
<h5>
Confirmation Number: <c:out value="${sessionScope.confirmation}"/> <br />
Order Items:
    <%
    Order order = (Order) request.getSession().getAttribute("order");
    for(LineItem item : order.getItems()) {
    	out.println(item.getItemName() + "\n");
    	out.println(item.getQuantity() + "\n");
    }
    %>   
</h5> 
<br /> <br /> <br /> <br /> <br /> <br /> <br /> <br />
<div style="font-size: 18px; color: #fc6f03;">Congrats! A Lovely Cat is on it's way!</div>
</div>
<jsp:include page="Footer.jsp"/>
</body>
</html>