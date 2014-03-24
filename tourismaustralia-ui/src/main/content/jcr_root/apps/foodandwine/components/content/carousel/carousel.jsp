<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/apps/foodandwine/components/global.jsp"%>
<%@ page
	import="com.australia.foodandwine.components.content.carousel.Carousel"%>

<c:set var="carousel" value="<%=new Carousel(slingRequest) %>" />

<!-- FOOD AND WINE CAROUSEL -->
<div class='carousel faw-carousel faw-bg-full-container'
	data-autoslidetime="0">
	<img data-width='1228' data-height='565'
		class='faw-bg-full l-display-none-md l-position-absolute'
		src='${carousel.carouselBackgroundImagePath}' alt='' />
	<div class='faw-carousel-outer'>
		<div class='faw-carousel-wrapper'>
			<ul class="carousel-wrapper">
				<c:if test="${not empty carousel.carouselList}">
					<c:forEach items="${carousel.carouselList}" var="item">
						<li class="item">
							<!-- FOOD AND WINE CAROUSEL ITEM -->
							<div class='faw-carousel-item'>
								<div class="headerlockup">
									<hr class="headerlockup-hr">
									<div class="headerlockup-type-sml1">${item.carouselHeaderLockupSmallTitle }</div>
									<div class="headerlockup-type-lrg">${item.carouselHeaderLockupLargeTitle }</div>
									<hr class="headerlockup-hr">
								</div>
								<p class='faw-carousel-copy'>${item.carouselHeaderLockupDescription }</p>
								<p>
									<a href="${item.carouselButtonTextLink }"
										class="btn-secondary btn-small">${item.carouselButtonText }</a>
								</p>
							</div> <!-- END: FOOD AND WINE CAROUSEL ITEM -->
						</li>
					</c:forEach>
				</c:if>
			</ul>
		</div>
	</div>
</div>
<!-- END: FOOD AND WINE CAROUSEL -->
