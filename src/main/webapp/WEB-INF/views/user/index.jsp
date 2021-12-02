<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>
<title>D2T | Home</title>

<body>



	<!-- Hero Section Begin -->
	<section class="hero">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="hero__banner owl-carousel owl-theme">
						<div class="hero__item set-bg hero__item__left"
							data-setbg='<c:url value="/assets/img/hero/banner4.jpeg"/>'>
							<div class="hero__text">
								<span>RED WINE LOVERS</span>
								<h2>
									BLACK FRIDAY WEEK <br />DEALS
								</h2>
								<p>
									Save up to <span class="save">30%</span>
								</p>
								<a href="#" class="primary-btn">SHOP NOW</a>
							</div>
						</div>
						<div class="hero__item set-bg hero__item__right"
							data-setbg='<c:url value="/assets/img/hero/bannerhero.jpg"/>'>
							<div class="hero__text">
								<span>WHITE WINE LOVERS</span>
								<h2>
									SEASONAL <br />SAVINGS
								</h2>
								<p>Perfect for entertaining gifting</p>
								<a href="#" class="primary-btn">SHOP NOW</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

	</section>
	<!-- Hero Section End -->

	<!-- Categories Section Begin -->
	<div class="banner">
		<div class="container">
			<div class="section-title">
				<h2>Categories</h2>
			</div>

			<div class="row">

				<c:forEach var="item" items="${categories }">

					<div class="col-lg-4 col-md-4 col-sm-4">
						<div class="banner__pic">
							<a href='<c:url value = "/${ item.category_id }" />'><img
								src='<c:url value="/assets/img/categories/${item.category_img }" />'
								alt=""></a>
						</div>
					</div>
				</c:forEach>



			</div>
		</div>
	</div>


	<!-- Featured Section Begin -->
	<section class="featured spad">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="section-title">
						<h2>Featured Product</h2>
					</div>

				</div>
			</div>
			<div class="row featured__filter">
				<c:forEach var="item" items="${products }" varStatus="loop"
					begin="4" end="12" step="1">

					<div class="col-lg-3 col-md-4 col-sm-6 mix oranges fresh-meat">
						<div class="featured__item">
							<div class="featured__item__pic set-bg"
								data-setbg='<c:url value="/assets/img/product/${item.product_img }"/>'>
								<ul class="featured__item__pic__hover">
									<li><a href='<c:url value="./add-cart/${item.product_id}"/>'><i class="fa fa-shopping-cart"></i></a></li>
								</ul>
							</div>
							<div class="featured__item__text">
								<h6>
									<a href='<c:url value="/${item.product_id }?detail"/>'>${item.product_name }</a>
								</h6>
								<h5>
									<fmt:formatNumber type="currency"	value="${item.product_price }" />

								</h5>
							</div>
						</div>
					</div>
				</c:forEach>


			</div>
		</div>
	</section>




	<!-- Banner Begin -->
	<div class="banner">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12">
					<div class="banner__pic">
						<img src='<c:url value="/assets/img/banner/banner__bottom.jpg" />'
							alt="">
					</div>
				</div>

			</div>
		</div>
	</div>
	<!-- Banner End -->

</body>

