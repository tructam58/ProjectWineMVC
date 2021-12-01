<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>
<title>D2T | Product</title>


<body>

	<img src='<c:url value="/assets/img/long.jpg" />'>



	<!-- Product Details Section Begin -->
	<section class="product-details spad">
		<div class="container">
			<div class="row">
				<div class="col-lg-6 col-md-6">
					<div class="product__details__pic">
						<div class="product__details__pic__item">
							<img class="product__details__pic__item--large"
								src='<c:url value="/assets/img/product/${product.product_img }" />'>
						</div>

					</div>
				</div>
				<div class="col-lg-6 col-md-6">
					<div class="product__details__text">
						<h3>${product.product_name }</h3>
						<div class="product__details__rating">
							<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
								class="fa fa-star"></i> <i class="fa fa-star"></i> <i
								class="fa fa-star-half-o"></i> <span>(18 reviews)</span>
						</div>
						<div class="product__details__price">
							<fmt:formatNumber type="currency"
								value="${product.product_price }" />
						</div>
						<p>${product.product_description }</p>
						<div class="product__details__quantity">
							<div class="quantity">
								<div class="pro-qty" data-id="${product.product_id}">
									<input type="text" value="1" id="qty">
								</div>
							</div>
						</div>
						<a class="primary-btn edit-cart">ADD TO CARD</a>

						<ul>
							<li><b>Availability</b> <span>In Stock</span></li>

							<li><b>Country </b> <c:if
									test="${product.country_id == 'F'}">
									<span>France</span>
								</c:if> <c:if test="${product.country_id == 'I'}">
									<span>Italy</span>
								</c:if> <c:if test="${product.country_id == 'C'}">
									<span>Chile</span>
								</c:if></li>
							<li><b>Share on</b>
								<div class="share">
									<a href="#"><i class="fa fa-facebook"></i></a> <a href="#"><i
										class="fa fa-twitter"></i></a> <a href="#"><i
										class="fa fa-instagram"></i></a> <a href="#"><i
										class="fa fa-pinterest"></i></a>
								</div></li>
						</ul>
					</div>
				</div>

			</div>
		</div>
	</section>
	<!-- Product Details Section End -->


	<content tag="script">
		<script>
		var proQty = $('.pro-qty');
		proQty.prepend('<span class="dec qtybtn ">-</span>');
		proQty.append('<span class="inc qtybtn ">+</span>');
		proQty.on('click', '.qtybtn', function() {
			var $button = $(this);
			var oldValue = $button.parent().find('input').val();
			if ($button.hasClass('inc')) {
				var newVal = parseFloat(oldValue) + 1;
			} else {
				// Don't allow decrementing below zero
				if (oldValue > 0) {
					var newVal = parseFloat(oldValue) - 1;
				} else {
					newVal = 0;
				}
			}
			$button.parent().find('input').val(newVal);
	

	
		});

		$(".edit-cart").on("click", function() {
			const quantity = $("#qty").val();
			const id = $(".pro-qty").data("id");
		
			window.location =   "add-many-cart/" + id + "/" + quantity;
		})
		
		
		</script>
	</content>

</body>
