<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Shopping List</title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" />

</head>
<body>
	<script src="jquery-2.1.4.min.js">
		
	</script>

	<script src="bootstrap/js/bootstrap.js">
		
	</script>

	<div class="navbar navbar-default">

		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-responsive-collapse">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
		</div>

		<div class="navbar-collapse collapse navbar-responsive-collapse">
			<form class="navbar-form navbar-right">
				<input type="text" class="form-control" placeholder="Search">
			</form>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="/shoppinglist">Home</a></li>
				<li><a href="signup.html">Signup</a></li>
				<li class="active"><a href="login.html">Login</a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown">Explore<b class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><a href="#">Contact us</a></li>
						<li class="divider"></li>
						<li><a href="#">Further Actions</a></li>
					</ul></li>
			</ul>
		</div>
		<!-- /.nav-collapse -->
	</div>

	<c:if test="${not empty message}">
		<div class="message green">${message}</div>
	</c:if>


	<a class="btn btn-primary" href="additem.html">Add Item</a>

	<c:if test="${not empty shoppingListTable}">
		<table class="table table-striped table-hover table-condensed">
			<thead>
				<tr>
					<td>No</td>
					<td>Item Name</td>
					<td>Item Price Per Item</td>
					<td>Item Quantity</td>
					<td>Alternate Item Name</td>
					<td>Alternate Item Price Per Item</td>
					<td>Alternate Item Quantity</td>
					<td></td>
					<td></td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="t" items="${shoppingListTable}">
					<tr>
						<td><c:out value="${t.id}" /></td>
						<td><c:out value="${t.itemName}" /></td>
						<td><c:out value="${t.itemPricePerItem}" /></td>
						<td><c:out value="${t.itemQuantity}" /></td>
						<td><c:out value="${t.alternateItemName}" /></td>
						<td><c:out value="${t.alternateItemPricePerItem}" /></td>
						<td><c:out value="${t.alternateItemQuantity}" /></td>
						<td><a href="edititem.html?id=${t.id}">Edit</a></td>
						<td><a href="delete.html?id=${t.id}">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
</body>
</html>