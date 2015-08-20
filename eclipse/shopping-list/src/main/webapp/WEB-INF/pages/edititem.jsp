<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Shopping List Edit Item</title>
<link href="bootstrap/css/bootstrap.css" rel="stylesheet" />
<link href="datepicker/css/datepicker.css" rel="stylesheet" />
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" />

<style>
.green {
	font-weight: bold;
	color: green;
}

.message {
	margin-bottom: 10px;
}

.error {
	color: #ff0000;
	font-size: 0.9em;
	font-weight: bold;
}

.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>
</head>
<body>

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
				<li class="active"><a href="signup.html">Signup</a></li>
				<li><a href="login.html">Login</a></li>
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

	<script src="jquery-2.1.4.min.js">
		
	</script>

	<script src="bootstrap/js/bootstrap.js">
		
	</script>

	<script src="datepicker/js/bootstrap-datepicker.js">
		
	</script>


	<div class="container">
		<div class="jumbotron">
			<div>
				<h1>Welcome to Shopping List</h1>
				<p>Its absolutely quick!</p>
			</div>
		</div>

		<div></div>
	</div>

	<c:if test="${not empty message}">
		<div class="message green">${message}</div>
	</c:if>
  <c:url var="addItem" value="additem.html" /> 
	<div class="col-lg-6 col-lg-offset-3">
		<div class="well">
			<div class="container">
				<div class="row">
					<div class="col-lg-6">
						<form:form id="editForm" 
							class="bs-example form-horizontal" modelAttribute="item"
							method="post" action="update">
							<fieldset>
								<legend>Shopping List Item Form</legend>

								<div class="form-group">
									<label for="itemNameInput" class="col-lg-5 control-label">Item
										Name</label>
									<div class="col-lg-7">
										<form:input type="text" class="form-control" path="itemName"
											value="${item.itemName}" id="itemNameInput"
											placeholder="Item Name" />
										<form:errors path="itemName" cssClass="error" />
									</div>
								</div>

								<div class="form-group">
									<label for="itemPriceInput" class="col-lg-5 control-label">Item
										Price Per Item</label>
									<div class="col-lg-7">
										<form:input type="text" class="form-control"
											path="itemPricePerItem" value="${item.itemPricePerItem}"
											id="itemPricePerItemInput" placeholder="Item Price PER Item" />
										<form:errors path="itemPricePerItem" cssClass="error" />
									</div>
								</div>

								<div class="form-group">
									<label for="itemQuantityInput" class="col-lg-5 control-label">Item
										Quantity</label>
									<div class="col-lg-7">
										<form:input type="text" class="form-control"
											path="itemQuantity" value="${item.itemQuantity}"
											id="itemQuantityInput" placeholder="Item Quantity" />
										<form:errors path="itemQuantity" cssClass="error" />
									</div>
								</div>

								<div class="form-group">
									<label for="alternateItemNameInput"
										class="col-lg-5 control-label">Alternate Item Name</label>
									<div class="col-lg-7">
										<form:input type="text" class="form-control"
											path="alternateItemName" value="${item.alternateItemName}"
											id="alternateItemNameInput" placeholder="Alternate Item Name" />
										<form:errors path="alternateItemName" cssClass="error" />
									</div>
								</div>

								<div class="form-group">
									<label for="alternateItemPricePerItemInput"
										class="col-lg-5 control-label">Alternate Item Price
										Per Item</label>
									<div class="col-lg-7">
										<form:input type="text" class="form-control"
											path="alternateItemPricePerItem"
											value="${item.alternateItemPricePerItem}"
											id="alternateItemPricePerItemInput"
											placeholder="Alternate Item Price Per Item" />
										<form:errors path="alternateItemPricePerItem" cssClass="error" />
									</div>
								</div>

								<div class="form-group">
									<label for="alternateItemPricePerItemInput"
										class="col-lg-5 control-label">Alternate Item Quantity</label>
									<div class="col-lg-7">
										<form:input type="text" class="form-control"
											path="alternateItemQuantity"
											value="${item.alternateItemQuantity}"
											id="alternateItemPricePerItemInput"
											placeholder="Alternate Item Quantity" />
										<form:errors path="alternateItemQuantity" cssClass="error" />
									</div>
								</div>

								<div class="col-lg-9 col-lg-offset-3">
									<button class="btn btn-default">Cancel</button>

									<button class="btn btn-primary">Submit</button>


								</div>

							</fieldset>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>


	<script type="text/javascript">
		$(function() {
			var yesButton = $("#yesbutton");
			var progress = $("#doitprogress");

			yesButton.click(function() {
				yesButton.button("loading");

				var counter = 0;
				var countDown = function() {
					counter++;
					if (counter == 11) {
						yesButton.button("complete");
					} else {
						progress.width(counter * 10 + "%");
						setTimeout(countDown, 100);
					}
				};

				setTimeout(countDown, 100);
			});

		});
	</script>


</body>
</html>