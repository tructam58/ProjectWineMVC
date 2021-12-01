<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>



<title>D2T | Product</title>
<style>
.active {
	background: #dc2543;
	border-color: #dc2543;
	color: #ffffff;
}
</style>
<body>

	<!-- Categories Section Begin -->
	<div class="banner">
		<div class="container">
			<div class="section-title">
				<h2>Danh mục sản phẩm</h2>
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


	<section class="product spad">
		<div class="container">
			<div class="row">


				<div class="col-lg-3">
					<div class="sidebar">
						<div class="sidebar__item">
							<h4>Department</h4>
							<ul>
								<c:forEach var="item" items="${categories }">
									<li><a
										href='<c:url value = "/${ item.category_id }" />'>${item.category_name }
											Wine</a></li>
								</c:forEach>
							</ul>
						</div>
						<div class="sidebar__item">
							<h4>Country</h4>
							<ul>
								<c:forEach var="item" items="${countries }">
									<li><a
										href='<c:url value = "/${ item.country_id }" />'>${item.country_name }</a></li>
								</c:forEach>
							</ul>
						</div>
					</div>
				</div>



				<!-- Phải -->
				<div class="col-lg-9">

					<div class="section-title ">
						<h2>Tất cả sản phẩm</h2>
					</div>
					<div class="filter__sort" style="margin-left: auto;">
						<span>Sort By</span> <select>
							<option value="0">A-Z</option>
							<option value="0">Thấp - Cao</option>
						</select>
					</div>




					<div class="row featured__filter">
						<c:forEach var="item" items="${productsPaginate }" varStatus="loop">
							<div class="col-lg-4">
								<div class="product__item">
									<div class="product__item__pic set-bg" data-setbg='<c:url value="/assets/img/product/${item.product_img }"/>'>
										<ul class="product__item__pic__hover">
											<li><a href='<c:url value="./add-cart/${item.product_id}"/>'><i class="fa fa-shopping-cart"></i></a></li>
										</ul>
									</div>
									<div class="product__item__text">
										<h6>
											<a href='<c:url value="/${item.product_id }?detail"/>'>${item.product_name }</a>
										</h6>
										<h5><fmt:formatNumber type="currency" value="${item.product_price }" /></h5>
									</div>
								</div>
							</div>

						</c:forEach>
					</div>



					<div class="product__pagination"
						style="display: flex; justify-content: center;">
						<c:forEach var="item" begin="1" end="${paginateInfo.totalPage }"
							varStatus="loop">

							<c:if test="${(loop.index) == paginateInfo.currentPage }">
								<a href='<c:url value="/san-pham/page=${loop.index }"/>'
									class="active">${loop.index }</a>
							</c:if>

							<c:if test="${(loop.index) != paginateInfo.currentPage }">
								<a href='<c:url value="/san-pham/page=${loop.index }"/>'>${loop.index }</a>
							</c:if>

						</c:forEach>

					</div>
				</div>
			</div>
		</div>
	</section>
</body>
