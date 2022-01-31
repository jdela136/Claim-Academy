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

body {
	font-family: 'Roboto Condensed', sans-serif;
	background-color: #f5f5f5
}

.hedding {
	font-size: 20px;
	color: #ab8181`;
}

.main-section {
	position: absolute;
	left: 50%;
	right: 50%;
	transform: translate(-50%, 5%);
}

.left-side-product-box img {
	width: 100%;
}

.left-side-product-box .sub-img img {
	margin-top: 5px;
	width: 83px;
	height: 100px;
}

.right-side-pro-detail span {
	font-size: 15px;
}

.right-side-pro-detail p {
	font-size: 25px;
	color: #a1a1a1;
}

.right-side-pro-detail .price-pro {
	color: #E45641;
}

.right-side-pro-detail .tag-section {
	font-size: 18px;
	color: #5D4C46;
}

.pro-box-section .pro-box img {
	width: 100%;
	height: 200px;
}

@media ( min-width :360px) and (max-width:640px) {
	.pro-box-section .pro-box img {
		height: auto;
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
						class="nav-link" href="">Sale Center</a>
				</nav>
			</div>
		</header>
		<br /> <br />
		<div class="container">
			<div class="col-lg-8 border p-3 main-section bg-white">
				<div class="row m-0">
					<div class="col-lg-4 left-side-product-box pb-3">
						<img src="http://nicesnippets.com/demo/pd-image1.jpg"
							class="border p-3">
					</div>
					<div class="col-lg-8">
						<div class="right-side-pro-detail border p-3 m-0">
							<div class="row">
								<div class="col-lg-12">
									<span>${car.type}</span>
									<p class="m-0 p-0">${car.car.year}${car.car.make}
										${car.car.model}</p>
								</div>
								<div class="col-lg-12">
									<p class="m-0 p-0 price-pro">$${car.price}</p>
									<hr class="p-0 m-0">
								</div>
								<div class="col-lg-12 pt-2">
									<h5>Car Details</h5>
									<p>Miles: ${car.miles}</p>
									<p>Build: ${car.car.build}</p>
									<p>Description: ${car.description}</p>
									<p>Added to inventory: ${car.purchaseDate}</p>
									<hr class="m-0 pt-2 mt-2">
								</div>
								<form:form modelAttribute="inventoryCar"
									action="/inventory-car/${id}" method="post">
									<label for="inputPrice">Bid Price</label>
									<form:input path="price" type="price" class="form-control"
										id="inputPrice" />
									<button type="submit" class="btn btn-primary">Make Bid</button>
								</form:form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
</body>

</html>