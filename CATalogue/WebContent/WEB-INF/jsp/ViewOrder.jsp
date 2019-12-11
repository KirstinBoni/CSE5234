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
</head>
<body background="https://previews.123rf.com/images/sudowoodo/sudowoodo1611/sudowoodo161100018/67676119-different-cartoon-cats-set-simple-modern-geometric-flat-style-vector-illustration-.jpg">
<jsp:include page="Header.jsp"/>

<div class="bg-gradient-primary">
<div class="container">
	<div class="row">
		<div class="col-xs-2">
		</div>
		<div class="col-xs-8" style="background-color: white">
			<h3 class="text-center h2">Please Confirm Your Order</h3><br /><br />
		</div>
	</div>
</div>

<div class="container" style="background-color: white">
<div class="row">
<div class="col-xs-2">
</div>
<div class="col-xs-8">
<form:form method="post" action="confirmOrder" class="text-center">
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
 <br />  <br />
</table>
 	<div class="text-center"><input class="btn-primary btn-md"  type="submit" value="Confirm Order"></div>
     <h5 class="text-center">Please click on Confirm Order to confirm your order. Order once placed cannot be cancelled.</h5>
     
</form:form>
</div>
</div>
</div>
<jsp:include page="Footer.jsp"/>
</body>
</html>