<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="edu.osu.cse5234.model.Order" %>
<%@ page import="edu.osu.cse5234.model.LineItem" %>
<%@ page import="edu.osu.cse5234.model.Error" %>
<%@ page import="edu.osu.cse5234.model.Item" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Purchase</title>
</head>
<body background="https://previews.123rf.com/images/sudowoodo/sudowoodo1611/sudowoodo161100018/67676119-different-cartoon-cats-set-simple-modern-geometric-flat-style-vector-illustration-.jpg">
<jsp:include page="Header.jsp"/>

<div class="bg-gradient-primary">
<div class="container">
	<div class="row">
		<div class="col-xs-2">
		</div>
		<div class="col-xs-8" style="background-color: white">
			<h3 class="text-center h2">Shopping Cart</h3><br /><br />
		</div>
	</div>
</div>

<div class="container" style="background-color: white">
<div class="row">
<div class="col-xs-2">
</div>
<div class="col-xs-8">

<c:if test="${not empty sessionScope.error}">
   <div class="alert alert-danger">
   <c:out value="${sessionScope.error}"/>
   </div>
</c:if>

<form:form modelAttribute="order" method="post" action="purchase/submitItems">
<table class="table table-striped table-bordered table-hover" style="font-size: 17px">
	    <th>Available Items for Purchase</th>
	    <th>Price</th>
	    <th>Quantity</th>

	<c:forEach items="${order.getItems()}" var="item" varStatus="loop">
		<tr>
			<td><form:input path="items[${loop.index}].itemName" value="${item.itemName}" readonly="true" /></td>
			<td><form:input path="items[${loop.index}].price" value="${item.price}" readonly="true" /></td>
			<td><form:input type="number" style="width: 108px;" min="1" path="items[${loop.index}].Quantity" /></td>
		</tr>
	</c:forEach>
    </table>
<div class="col-xs-2"></div>
</div>
</div>

<div class="row">
	<div class="col-xs-2">
	</div>
	<div class="col-xs-8">
	   <h3 class="h4">Please Login to Continue</h3>
	</div>
</div>

<div class="row">
<div class="col-xs-2">
</div>
<div class="col-xs-8">
 <div class="form-group">
   <label for="exampleInputEmail1">Email address</label>
   <form:input class="form-control" path="emailAddress" type="text" placeholder="Enter email"/>
   <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
 </div>
 <div class="form-group">
   <label for="exampleInputPassword1">Password</label>
   <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
 </div>
 	<div class="text-center"><input class="btn-primary btn-md"  type="submit" value="Purchase">
 
<br/><br/>
</div>
</div>
</form:form>
</div>


</div>
</div>
</body>
</html>