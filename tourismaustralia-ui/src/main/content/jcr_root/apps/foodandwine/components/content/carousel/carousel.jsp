<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/apps/foodandwine/components/global.jsp"%>
<%@ page
	import="com.australia.foodandwine.components.content.carousel.Carousel"%>

<c:set var="carousel" value="<%=new Carousel(slingRequest) %>" />

<!-- FOOD AND WINE CAROUSEL -->
<div class='carousel faw-carousel faw-bg-full-container' data-autoslidetime="0">
	<div class="l-display-none-md l-position-absolute fullwidth-bg">
		<div class="responsive-image l-display-none-md l-position-absolute" data-picture="" data-alt="" >
			<div data-src="${carousel.carouselBackgroundImagePath}.adapt.480.low.jpg" data-media="(min-width: 1px)"></div>
			<div data-src="${carousel.carouselBackgroundImagePath}.adapt.768.medium.jpg" data-media="(min-width: 481px)"></div>
			<div data-src="${carousel.carouselBackgroundImagePath}.adapt.992.high.jpg" data-media="(min-width: 769px)"></div>
			<div data-src="${carousel.carouselBackgroundImagePath}.adapt.1663.high.jpg" data-media="(min-width: 993px)"></div>
			<noscript>
				<img src='${carousel.carouselBackgroundImagePath}.adapt.1663.high.jpg'>
			</noscript>
		</div>
		<!--[if (lt IE 9) & (!IEMobile)]>
            <img src='imgs/base/faw-carousel-bg.jpg' alt=''>
        <![endif]-->
	</div>	
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