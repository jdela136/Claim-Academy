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
		<h1 class="cover-heading">Sales</h1>

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
							<th scope="col">Car</th>
							<th scope="col">Customer</th>
							<th scope="col">Price</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${sales}" var="car">
							<tr>
								<td>${car.type} ${car.car.year} ${car.car.make} ${car.car.model}</td>
								<td>${car.sale.firstName} ${car.sale.lastName}</td>
								<td>${car.price}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>

</html>