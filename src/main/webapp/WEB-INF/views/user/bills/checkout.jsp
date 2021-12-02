<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>


<title>D2T | Checkout</title>

<body>

	<!-- Breadcrumb Section Begin -->
	<section class="breadcrumb-section set-bg"
		data-setbg='<c:url value="assets/img/banner2.jpg"/>'>
		<div class="container">
			<div class="row">
				<div class="col-lg-12 text-center">
					<div class="breadcrumb__text">
						<h2>Checkout</h2>
						<div class="breadcrumb__option">
							<a href="./index.html">Home</a> <span>Checkout</span>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Breadcrumb Section End -->

	<!-- Checkout Section Begin -->
	<section class="checkout spad">
		<div class="container">

			<div class="checkout__form">

				<div class="row">

					<div class="col-lg-6 col-md-6" >
						<form:form action="checkout" method="POST" modelAttribute="bills">
							<h4>Billing Details</h4>
							
							<div class="checkout__input">
								<p>
									Full name<span>*</span>
								</p>
								<form:input type="text" path="bill_fullname" />
							</div>
							<div class="checkout__input">
								<p>
									Address<span>*</span>
								</p>
								<form:input type="text" class="checkout__input__add"
									path="bill_address" />

							</div>
							<div class="checkout__input">
								<p>
									Email<span>*</span>
								</p>
								<form:input type="email" path="bill_email" />
							</div>
							<div class="checkout__input">
								<p>
									Phone<span>*</span>
								</p>
								<form:input type="text" path="bill_phone" />
							</div>
							<div class="checkout__input">
								<p>
									Order Notes<span>*</span>
								</p>
								<form:input type="text" path="bill_notes" />
							</div>
							


							<button type="submit" class="site-btn res-log">CHECKOUT</button>

						</form:form>
					</div>
					<div class="col-lg-6 col-md-6" style="margin-top:100px;">
						<img alt="" src='<c:url value="/assets/img/shipping.png"/>'>
						<h3 style="text-align: center;">Thanks for shopping!</h3>
					</div>
				</div>

			</div>
		</div>
	</section>
	<!-- Checkout Section End -->

</body>
