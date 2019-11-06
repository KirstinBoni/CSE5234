<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Payment Details</title>
</head>
<body>
<jsp:include page="Header.jsp"/>
	<form:form modelAttribute="paymentInfo" method="post" action="submitPayment">
	<div class="container">
<h3 class="text-center">Enter Payment Details</h3><br /><br />
<div class="row">
<div class="col-xs-4"></div>
<div class="col-xs-4">
	    <table class="table table-striped table-bordered" style="font-size: 15px">
   			<tr>
		  		<td><form:label path="cardHolderName">Card Holder</form:label></td> 
				<td><form:input path="cardHolderName" /></td>
			</tr>
    		<tr> 
    			<td><form:label path="creditCardNumber">Credit Card Number</form:label></td>   	
				<td><form:input path="creditCardNumber" /></td>
			</tr>
			<tr>
			    <td><form:label path="expirationDate">Expiration Date</form:label></td>   	
				<td><form:input path="expirationDate" /></td>
			</tr>
			<tr>
		  		<td><form:label path="cvvCode">Cvv Code</form:label></td> 
				<td><form:input path="cvvCode" /></td>
			</tr>
			
		</table>
		</div>
<div class="col-xs-4"></div>
</div>
</div>
    <br />
		    <div class="text-center"><input class="btn-primary btn-md"  type="submit" value="Submit"></div>
		
	</form:form>
<jsp:include page="Footer.jsp"/>
</body>
