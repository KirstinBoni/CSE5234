<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="edu.osu.cse5234.model.Order" %>
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
<body>
<jsp:include page="Header.jsp"/>

<div class="container">
<h3 class="text-center">Pick your Cat!</h3><br /><br />
<div class="row">
<div class="col-xs-2"></div>
<div class="col-xs-8">

<c:if test="${not empty sessionScope.error}">
   <div class="alert alert-danger">
   <c:out value="${sessionScope.error}"/>
   </div>
</c:if>

<form:form modelAttribute="order" method="post" action="purchase/submitItems">
<table class="table table-striped table-bordered" style="font-size: 17px">
	    <th>Available Items for Purchase</th>
	    <th>Price</th>
	    <th>Quantity</th>
	    
	<c:forEach items="${order.getItems()}" var="item" varStatus="loop">
		<tr>
			<td><form:input path="items[${loop.index}].name" value="${item.name}" readonly="true" /></td>
			<td><form:input path="items[${loop.index}].price" value="${item.price}" readonly="true" /></td>
			<td><form:input type="number" style="width: 108px;" min="1" path="items[${loop.index}].quantity" /></td>
		</tr>
	</c:forEach>
    </table>
<div class="col-xs-2"></div>
</div>
</div>
<br /><br /><div class="text-center"><input class="btn-primary btn-md"  type="submit" value="Purchase"></div>
</form:form>
</div>

<jsp:include page="Footer.jsp"/>

</body>
</html>