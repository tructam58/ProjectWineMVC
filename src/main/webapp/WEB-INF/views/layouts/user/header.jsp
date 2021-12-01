<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" %>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>
<div class="header__top">
	<div class="container">
		<div class="row">
			<div class="col-lg-6 col-md-6">
				<div class="header__top__left">
					<ul>
						<li><i class="fa fa-envelope"></i> d2t@gmail.com</li>
						<li>Free Shipping for all Order of $999</li>
					</ul>
				</div>
			</div>
			<div class="col-lg-6 col-md-6">
				<div class="header__top__right">
					<div class="header__top__right__social">
						<a href="#"><i class="fa fa-facebook"></i></a> 
						<a href="#"><i class="fa fa-twitter"></i></a> 
						<a href="#"><i class="fa fa-linkedin"></i></a>
						<a href="#"><i class="fa fa-pinterest-p"></i></a>
					</div>
					<div class="header__top__right__language">
						<img src='<c:url value="/assets/img/language.png"/>' alt="">
						<div>English</div>
						
					</div>
					<div class="header__top__right__auth">
						<a href="#"><i class="fa fa-user"></i> Login</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<!-- Header Section Begin -->
<header class="header">

	<div class="container">
		<div class="row">
			<div class="col-lg-3">
				<div class="header__logo">
					<a href="#"><img src='<c:url value="/assets/img/logo.png"/>' alt=""></a>
				</div>
			</div>
			<div class="col-lg-6">
				<nav class="header__menu">
					<ul>
						<li class="active"><a href="./home">Home</a></li>
						<li><a href="./san-pham">Shop</a></li>
						<li><a href="#">Pages</a>
							<ul class="header__menu__dropdown">
								<li><a href="./shop-details.html">Shop Details</a></li>
								<li><a href="./shoping-cart.html">Shoping Cart</a></li>
								<li><a href="./checkout.html">Check Out</a></li>
							</ul></li>
						<li><a href="./contact.html">Contact</a></li>
					</ul>
				</nav>
			</div>
			<div class="col-lg-3">
				<div class="header__cart">
					<ul>
						<!-- <li><a href="#"><i class="fa fa-heart"></i> <span>1</span></a></li> -->
						<li><a href='<c:url value="/gio-hang"/>'><i class="fa fa-shopping-bag"></i>
						
						<span>${TotalQuantityCart }</span>
						<c:if test="${TotalQuantityCart == null }"> <span>0</span></c:if>
						
						 </a></li>
					</ul>
					<div class="header__cart__price">
						Total: <span>$${TotalPriceCart }</span><c:if test="${TotalPriceCart == null }"> <span>0</span></c:if>
					</div>
				</div>
			</div>
		</div>
	</div>
</header>


		<!-- Hero Section Begin -->
<section class="hero">
	<div class="container">
		<div class="row">
		
			<div class="col-lg-12">
				<div class="hero__search">
					<div class="hero__search__form">
						<form action="#">
							<div class="hero__search__categories">
								All Categories <span class="arrow_carrot-down"></span>
							</div>
							<input type="text" placeholder="What do you need?">
							<button type="submit" class="site-btn">SEARCH</button>
						</form>
					</div>
					<div class="hero__search__phone">
						<div class="hero__search__phone__icon">
							<i class="fa fa-phone"></i>
						</div>
						<div class="hero__search__phone__text">
							<h5>+65 11.188.888</h5>
							<span>support 24/7 time</span>
						</div>
					</div>
				</div>
				
			</div>
		</div>
	</div>
	</section>