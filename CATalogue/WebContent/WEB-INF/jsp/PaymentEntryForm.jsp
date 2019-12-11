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
<body background="https://previews.123rf.com/images/sudowoodo/sudowoodo1611/sudowoodo161100018/67676119-different-cartoon-cats-set-simple-modern-geometric-flat-style-vector-illustration-.jpg">

<jsp:include page="Header.jsp"/>
	<form:form modelAttribute="paymentInfo" method="post" action="submitPayment">
	<div class="container">
<div class="row">
<div class="col-xs-4"></div>
<div class="col-xs-4" style="background: white">
<h3 class="text-center">Enter Your Payment Information</h3><br /><br />
</div>
</div>
<div class="row">
<div class="col-xs-4" style="background:white"></div>
<div class="col-xs-4" style="background:white">
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
		    <div class="text-center" style="background:white"><input class="btn-primary btn-md"  type="submit" value="Submit"></div>
		
	</form:form>
<jsp:include page="Footer.jsp"/>
</body>
