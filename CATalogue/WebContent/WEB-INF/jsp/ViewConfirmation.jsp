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
<body background="https://previews.123rf.com/images/sudowoodo/sudowoodo1611/sudowoodo161100018/67676119-different-cartoon-cats-set-simple-modern-geometric-flat-style-vector-illustration-.jpg">
<jsp:include page="Header.jsp"/>
<div class="container" style="background:white">
<h3> Your Order is Confirmed! </h3><br />
<h3>Please find the order Details below:</h3>
<h3>
Confirmation Number: <c:out value="${sessionScope.confirmation}"/> <br />
</h3>
<table class="table table-striped table-bordered table-hover" style="font-size: 17px">
<th>Item</th>
<th>Quantity</th>
    <%
    Order order = (Order) request.getSession().getAttribute("order");
    for(LineItem item : order.getItems()) {
    	out.println("<tr>");
    	out.println("<td>");
    	out.println(item.getItemName() + "\n");
    	out.println("</td>");
    	out.println("<td>");
    	out.println(item.getQuantity() + "\n");
    	out.println("</td>");
    	out.println("</tr>");
    }
    %>   
</table>
<br /> <br /> <br /> <br /> <br /> <br /> <br /> <br />
<div style="font-size: 18px; color: #fc6f03;">Congrats! A Lovely Cat is on it's way!</div>
</div>
<jsp:include page="Footer.jsp"/>
</body>
</html>