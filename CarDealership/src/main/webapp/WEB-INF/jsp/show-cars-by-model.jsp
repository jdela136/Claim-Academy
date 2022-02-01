<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>
<head>
<meta charset="utf-8">
<title>Car Dealership</title>

<link rel="canonical"
	href="https://getbootstrap.com/docs/4.4/examples/cover/">

<!-- Bootstrap core CSS -->
<link
	href="https://getbootstrap.com/docs/4.4/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">


<style>
.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
	user-select: none;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}
</style>
<!-- Custom styles for this template -->
<link href="cover.css" rel="stylesheet">
</head>


<body class="text-center">
	<div class="cover-container d-flex w-100 h-25 p-3 mx-auto flex-column">
		<header class="masthead mb-auto">
			<div class="inner">
				<h3 class="masthead-brand">Car Dealership</h3>
				<nav class="nav nav-masthead justify-content-center">
					<a class="nav-link active" href="/">Inventory</a><a
						class="nav-link" href="/add-to-inventory">Add Car</a> <a
						class="nav-link" href="display-sales">Sale Center</a>
				</nav>
			</div>
		</header>
		<br /> <br />
		<!--    <main role="main" class="inner cover"> -->
		<h1 class="cover-heading">Inventory</h1>
		<div class="main-search-input-wrap">
			<div class="main-search-input fl-wrap">
				<div class="main-search-input-item">
					<form:form modelAttribute="model" action="/inventory" method="post">
						<form:input type="text" path="car.model"
							placeholder="Search by Model" />
						<button class="main-search-button">Search</button>
					</form:form>
				</div>
			</div>
		</div>

		<!--     </main> -->
	</div>
	<br />
	<br />
	<br />
	<br />
	<div class="container">
		<div class="row">
			<div class="col-12">
				<table class="table table-image">
					<thead>
						<tr>
							<th scope="col">Image</th>
							<th scope="col">Car</th>
							<th scope="col">Type</th>
							<th scope="col">Details</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${cars}" var="car">
							<tr>
								<td class="w-25"><img
									src="${car.car.image}"
									class="img-fluid img-thumbnail"></td>
								<td>${car.car.make} ${car.car.model}</td>
								<td>${car.type}</td>
								<td><a class="btn btn-primary" href="/inventory-car/${car.id}" role="button">View Here</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>

</html>