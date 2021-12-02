<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>


<title>D2T | Register - Login</title>

<body>

	<!-- Breadcrumb Section Begin -->
	<section class="breadcrumb-section set-bg"
		data-setbg='<c:url value="assets/img/banner2.jpg"/>'>
		<div class="container">
			<div class="row">
				<div class="col-lg-12 text-center">
					<div class="breadcrumb__text">
						<h2>Register - Login</h2>
						<div class="breadcrumb__option">
							<a href="./index.html">Home</a> <span>Register/Login</span>
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
				<!-- <h4>Billing Details</h4> -->

				<div class="row">

					<div class="col-lg-6 col-md-6">
						<form:form action="dang-ky" method="POST" modelAttribute="user">
							<h4>Register</h4>
							<c:if test='${ status == "Đăng ký tài khoản thất bại!" || status == "Đăng ký tài khoản thành công!"}'>
								<h4>${ status }</h4>
							</c:if>
							<div class="checkout__input">
								<p>
									Full name<span>*</span>
								</p>
								<form:input type="text" path="user_fullname" />
							</div>
							<div class="checkout__input">
								<p>
									Address<span>*</span>
								</p>
								<form:input type="text" class="checkout__input__add"
									path="user_address" />

							</div>
							<div class="checkout__input">
								<p>
									Phone<span>*</span>
								</p>
								<form:input type="text" path="user_phone" />
							</div>
							<div class="checkout__input">
								<p>
									Email<span>*</span>
								</p>
								<form:input type="email" path="user_email" />
							</div>
							<div class="checkout__input">
								<p>
									Password<span>*</span>
								</p>
								<form:input type="password" path="user_password" />
							</div>


							<button type="submit" class="site-btn res-log">REGISTER</button>

						</form:form>
					</div>

					<div class="col-lg-6 col-md-6">

						<form:form action="dang-nhap" method="POST" modelAttribute="user">
							<h4>Login</h4>
							 <c:if test='${ statusLogin == "Đăng nhập thất bại!" }'>
								<h4>${ statusLogin }</h4>
							</c:if> 
							
							<div class="checkout__input">
								<p>
									Email<span>*</span>
								</p>
								<form:input type="email" path="user_email" />
							</div>
							<div class="checkout__input">
								<p>
									Password<span>*</span>
								</p>
								<form:input type="password" path="user_password" />
							</div>

							<button type="submit" class="site-btn">LOGIN</button>
							<a href="" style="margin-left: 15px;">Forgot password?</a>

						</form:form>
					</div>



				</div>

			</div>
		</div>
	</section>
	<!-- Checkout Section End -->

</body>
