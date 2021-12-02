<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>
<head>
<title>List Cart</title>
</head>
<body>
	<!-- Shoping Cart Section Begin -->
	<section class="shoping-cart spad">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="shoping__cart__table">
						<table>
							<thead>
								<tr>
									<th class="shoping__product">Products</th>
									<th>Price</th>
									<th>Quantity</th>
									<th>Total</th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="item" items="${Cart }">
									<tr>
										<td class="shoping__cart__item"><img
											src='<c:url value="assets/img/product/${item.value.productsDto.product_img }"/>'
											style="width: 100px">
											<h5>${item.value.productsDto.product_name}</h5></td>
										<td class="shoping__cart__price">$${item.value.productsDto.product_price}</td>
										<td class="shoping__cart__quantity">
											<div class="quantity">
												<div class="pro-qty" data-id="${item.key }">
													<input type="text" value="${item.value.quantity}" min="0"
														max="1000" id="quantity-cart-${item.key }">
												</div>
											</div>
										</td>
										<td class="shoping__cart__total">$${item.value.totalPrice}</td>
										<td class="shoping__cart__item__close"><a
											href='<c:url value="/delete-cart/${item.key }"/>'><span
												class="icon_close"></span></a></td>
									</tr>

								</c:forEach>






							</tbody>
						</table>
					</div>
				</div>


			</div>


			<div class="row">
				<div class="col-lg-6">
					<div class="shoping__cart__btns">
						<a href="./san-pham" class="primary-btn cart-btn">CONTINUE
							SHOPPING</a>
					</div>
				</div>
				<div class="col-lg-6">
					<div class="shoping__checkout" style="margin-top: 0px">
						<h5>Cart Total</h5>
						<ul>
							<li>Total <span>$${TotalPriceCart}</span></li>
						</ul>
						<a href="./checkout" class="primary-btn">PROCEED TO CHECKOUT</a>
					</div>
				</div>
			</div>
		</div>

	</section>
	<!-- Shoping Cart Section End -->

	<content tag="script"> <script>
		var proQty = $('.pro-qty');
		proQty.prepend('<span class="dec qtybtn edit-quantity">-</span>');
		proQty.append('<span class="inc qtybtn edit-quantity">+</span>');
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

			const id = proQty.data("id");
			window.location = "edit-cart/" + id + "/" + newVal;

		});
	</script> </content>
</body>