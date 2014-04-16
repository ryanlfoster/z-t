<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/apps/foodandwine/components/global.jsp"%>
<%@ page import="com.australia.foodandwine.components.content.carouselState.CarouselState"%>

<c:set var="carousel" value="<%=new CarouselState(slingRequest) %>" />

<!-- FOOD AND WINE PLACES CAROUSEL -->
<div class="carousel faw-places-carousel faw-bg-full-container">
	<ul class="carousel-wrapper" data-mobilemaxresolution="0"
		data-autoslidetime="0" data-startindex="0" data-iconpagination="true"
		data-breakpoint-sm="800" data-breakpoint-md="1168"
		data-carouseltheme="faw-places-theme">
		<li class="item">
			<div class="faw-carousel-bg-container" data-picture="" data-alt="">
				<div data-src="${carousel.imagePath}.adapt.480.low.jpg"
					data-media="(min-width: 1px)"></div>
				<div data-src="${carousel.imagePath}.adapt.768.medium.jpg"
					data-media="(min-width: 481px)"></div>
				<div data-src="${carousel.imagePath}.adapt.992.high.jpg"
					data-media="(min-width: 769px)"></div>
				<div data-src="${carousel.imagePath}.adapt.1663.high.jpg"
					data-media="(min-width: 993px)"></div>
				<noscript>
					<img class="faw-carousel-bg"
						src="${carousel.imagePath}.adapt.1663.high.jpg"
						alt="${carouse.imageAltTag}">
				</noscript>
			</div> <!--[if (lt IE 9) & (!IEMobile)]>
				<img class="faw-carousel-bg" src="${carousel.imagePath}.adapt.1663.high.jpg" alt="${carouse.imageAltTag}">
			<![endif]-->
			<div class="calltoaction calltoactionbubble">
				<div class="head-divider">
					<div class="head-divider-inner">
						<hr
							class="icon-logo-withlines-hr icon-logo-withlines-hr-small experiences-head-divider-hr">
						<div class="head-divider-title">
							<img class="experiences-head-divider-image"
								src="/etc/designs/foodandwine/clientlibs/imgs/base/headline-map-icon.png">
						</div>
						<hr
							class="icon-logo-withlines-hr icon-logo-withlines-hr-small experiences-head-divider-hr">
					</div>
				</div>
				<h5>${carousel.circleTopText}</h5>
				<h2>${carousel.circleMiddleText}</h2>
				<h5>${carousel.circleBottomText}</h5>
				<hr class="divider-small">
			</div>
		</li>
		<li class="item">
			<div class="faw-carousel-bg-container" data-picture="" data-alt="">
				<div data-src="${carousel.capital.imagePath}.adapt.480.low.jpg"
					data-media="(min-width: 1px)"></div>
				<div data-src="${carousel.capital.imagePath}.adapt.768.medium.jpg"
					data-media="(min-width: 481px)"></div>
				<div data-src="${carousel.capital.imagePath}.adapt.992.high.jpg"
					data-media="(min-width: 769px)"></div>
				<div data-src="${carousel.capital.imagePath}.adapt.1663.high.jpg"
					data-media="(min-width: 993px)"></div>
				<noscript>
					<img class="faw-carousel-bg"
						src="${carousel.capital.imagePath}.adapt.1663.high.jpg"
						alt="${carousel.capital.imageAltTag}">
				</noscript>
			</div> <!--[if (lt IE 9) & (!IEMobile)]>
				<img class="faw-carousel-bg" src="${carousel.capital.imagePath}.adapt.1663.high.jpg" alt="${carouse.capital.imageAltTag}">
			<![endif]-->
			<div class="calltoaction calltoactionbubble calltoactionbubble-white">
				<div class="head-divider">
					<div class="head-divider-inner">
						<hr
							class="icon-logo-withlines-hr icon-logo-withlines-hr-small experiences-head-divider-hr">
						<div class="head-divider-title">
							<span
								class="icon-map icon-map-small icon-map-black icon-map-capital"></span>
						</div>
						<hr
							class="icon-logo-withlines-hr icon-logo-withlines-hr-small experiences-head-divider-hr">
					</div>
				</div>
				<div class="calltoactionbubble-copy">
					<h5 class="cta-title">${carousel.capital.circleTopText}</h5>
					<h2 class="cta-main-title">${carousel.capital.circleMiddleText}</h2>
					<h5 class="cta-sub-title">${carousel.capital.circleBottomText}</h5>
					<hr class="divider-small">
					<p class="cta-description">${carousel.capital.text}
						<a href="${carousel.capital.findOutMoreLink}">Find out more</a>
					</p>
				</div>
			</div>
		</li>
		<li class="item">
			<div class="faw-carousel-bg-container" data-picture="" data-alt="">
				<div data-src="${carousel.nsw.imagePath}.adapt.480.low.jpg"
					data-media="(min-width: 1px)"></div>
				<div data-src="${carousel.nsw.imagePath}.adapt.768.medium.jpg"
					data-media="(min-width: 481px)"></div>
				<div data-src="${carousel.nsw.imagePath}.adapt.992.high.jpg"
					data-media="(min-width: 769px)"></div>
				<div data-src="${carousel.nsw.imagePath}.adapt.1663.high.jpg"
					data-media="(min-width: 993px)"></div>
				<noscript>
					<img class="faw-carousel-bg"
						src="${carousel.nsw.imagePath}.adapt.1663.high.jpg"
						alt="${carousel.nsw.imageAltTag}">
				</noscript>
			</div> <!--[if (lt IE 9) & (!IEMobile)]>
				<img class="faw-carousel-bg" src="${carousel.nsw.imagePath}.adapt.1663.high.jpg" alt="${carousel.nsw.imageAltTag}">
			<![endif]-->
			<div class="calltoaction calltoactionbubble calltoactionbubble-white">
				<div class="head-divider">
					<div class="head-divider-inner">
						<hr
							class="icon-logo-withlines-hr icon-logo-withlines-hr-small experiences-head-divider-hr">
						<div class="head-divider-title">
							<span
								class="icon-map icon-map-small icon-map-black icon-map-nsw"></span>
						</div>
						<hr
							class="icon-logo-withlines-hr icon-logo-withlines-hr-small experiences-head-divider-hr">
					</div>
				</div>
				<div class="calltoactionbubble-copy">
					<h5 class="cta-title">${carousel.nsw.circleTopText}</h5>
					<h2 class="cta-main-title">${carousel.nsw.circleMiddleText}</h2>
					<h5 class="cta-sub-title">${carousel.nsw.circleBottomText}</h5>
					<hr class="divider-small">
					<p class="cta-description">${carousel.nsw.text}
						<a href="${carousel.nsw.findOutMoreLink}">Find out more</a>
					</p>
				</div>
			</div>
		</li>
		<li class="item">
			<div class="faw-carousel-bg-container" data-picture="" data-alt="">
				<div data-src="${carousel.northern.imagePath}.adapt.480.low.jpg"
					data-media="(min-width: 1px)"></div>
				<div data-src="${carousel.northern.imagePath}.adapt.768.medium.jpg"
					data-media="(min-width: 481px)"></div>
				<div data-src="${carousel.northern.imagePath}.adapt.992.high.jpg"
					data-media="(min-width: 769px)"></div>
				<div data-src="${carousel.northern.imagePath}.adapt.1663.high.jpg"
					data-media="(min-width: 993px)"></div>
				<noscript>
					<img class="faw-carousel-bg"
						src="${carousel.northern.imagePath}.adapt.1663.high.jpg"
						alt="${carousel.northern.imageAltTag}">
				</noscript>
			</div> <!--[if (lt IE 9) & (!IEMobile)]>
				<img class="faw-carousel-bg" src="${carousel.northern.imagePath}.adapt.1663.high.jpg" alt="${carousel.northern.imageAltTag}">
			<![endif]-->
			<div class="calltoaction calltoactionbubble calltoactionbubble-white">
				<div class="head-divider">
					<div class="head-divider-inner">
						<hr
							class="icon-logo-withlines-hr icon-logo-withlines-hr-small experiences-head-divider-hr">
						<div class="head-divider-title">
							<span
								class="icon-map icon-map-small icon-map-black icon-map-northern"></span>
						</div>
						<hr
							class="icon-logo-withlines-hr icon-logo-withlines-hr-small experiences-head-divider-hr">
					</div>
				</div>
				<div class="calltoactionbubble-copy">
					<h5 class="cta-title">${carousel.northern.circleTopText}</h5>
					<h2 class="cta-main-title">${carousel.northern.circleMiddleText}</h2>
					<h5 class="cta-sub-title">${carousel.northern.circleBottomText}</h5>
					<hr class="divider-small">
					<p class="cta-description">${carousel.northern.text}
						<a href="${carousel.northern.findOutMoreLink}">Find out more</a>
					</p>
				</div>
			</div>
		</li>
		<li class="item">
			<div class="faw-carousel-bg-container" data-picture="" data-alt="">
				<div data-src="${carousel.queensland.imagePath}.adapt.480.low.jpg"
					data-media="(min-width: 1px)"></div>
				<div
					data-src="${carousel.queensland.imagePath}.adapt.768.medium.jpg"
					data-media="(min-width: 481px)"></div>
				<div data-src="${carousel.queensland.imagePath}.adapt.992.high.jpg"
					data-media="(min-width: 769px)"></div>
				<div data-src="${carousel.queensland.imagePath}.adapt.1663.high.jpg"
					data-media="(min-width: 993px)"></div>
				<noscript>
					<img class="faw-carousel-bg"
						src="${carousel.queensland.imagePath}.adapt.1663.high.jpg"
						alt="${carousel.queensland.imageAltTag}">
				</noscript>
			</div> <!--[if (lt IE 9) & (!IEMobile)]>
				<img class="faw-carousel-bg" src="${carousel.queensland.imagePath}.adapt.1663.high.jpg" alt="${carousel.queensland.imageAltTag}">
			<![endif]-->
			<div class="calltoaction calltoactionbubble calltoactionbubble-white">
				<div class="head-divider">
					<div class="head-divider-inner">
						<hr
							class="icon-logo-withlines-hr icon-logo-withlines-hr-small experiences-head-divider-hr">
						<div class="head-divider-title">
							<span
								class="icon-map icon-map-small icon-map-black icon-map-queensland"></span>
						</div>
						<hr
							class="icon-logo-withlines-hr icon-logo-withlines-hr-small experiences-head-divider-hr">
					</div>
				</div>
				<div class="calltoactionbubble-copy">
					<h5 class="cta-title">${carousel.queensland.circleTopText}</h5>
					<h2 class="cta-main-title">${carousel.queensland.circleMiddleText}</h2>
					<h5 class="cta-sub-title">${carousel.queensland.circleBottomText}</h5>
					<hr class="divider-small">
					<p class="cta-description">${carousel.queensland.text}
						<a href="${carousel.queensland.findOutMoreLink}">Find out more</a>
					</p>
				</div>
			</div>
		</li>
		<li class="item">
			<div class="faw-carousel-bg-container" data-picture="" data-alt="">
				<div data-src="${carousel.south.imagePath}.adapt.480.low.jpg"
					data-media="(min-width: 1px)"></div>
				<div data-src="${carousel.south.imagePath}.adapt.768.medium.jpg"
					data-media="(min-width: 481px)"></div>
				<div data-src="${carousel.south.imagePath}.adapt.992.high.jpg"
					data-media="(min-width: 769px)"></div>
				<div data-src="${carousel.south.imagePath}.adapt.1663.high.jpg"
					data-media="(min-width: 993px)"></div>
				<noscript>
					<img class="faw-carousel-bg"
						src="${carousel.south.imagePath}.adapt.1663.high.jpg"
						alt="${carousel.south.imageAltTag}">
				</noscript>
			</div> <!--[if (lt IE 9) & (!IEMobile)]>
				<img class="faw-carousel-bg" src="${carousel.south.imagePath}.adapt.1663.high.jpg" alt="${carousel.south.imageAltTag}">
			<![endif]-->
			<div class="calltoaction calltoactionbubble calltoactionbubble-white">
				<div class="head-divider">
					<div class="head-divider-inner">
						<hr
							class="icon-logo-withlines-hr icon-logo-withlines-hr-small experiences-head-divider-hr">
						<div class="head-divider-title">
							<span
								class="icon-map icon-map-small icon-map-black icon-map-south"></span>
						</div>
						<hr
							class="icon-logo-withlines-hr icon-logo-withlines-hr-small experiences-head-divider-hr">
					</div>
				</div>
				<div class="calltoactionbubble-copy">
					<h5 class="cta-title">${carousel.south.circleTopText}</h5>
					<h2 class="cta-main-title">${carousel.south.circleMiddleText}</h2>
					<h5 class="cta-sub-title">${carousel.south.circleBottomText}</h5>
					<hr class="divider-small">
					<p class="cta-description">${carousel.south.text}
						<a href="${carousel.south.findOutMoreLink}">Find out more</a>
					</p>
				</div>
			</div>
		</li>
		<li class="item">
			<div class="faw-carousel-bg-container" data-picture="" data-alt="">
				<div data-src="${carousel.tasmania.imagePath}.adapt.480.low.jpg"
					data-media="(min-width: 1px)"></div>
				<div data-src="${carousel.tasmania.imagePath}.adapt.768.medium.jpg"
					data-media="(min-width: 481px)"></div>
				<div data-src="${carousel.tasmania.imagePath}.adapt.992.high.jpg"
					data-media="(min-width: 769px)"></div>
				<div data-src="${carousel.tasmania.imagePath}.adapt.1663.high.jpg"
					data-media="(min-width: 993px)"></div>
				<noscript>
					<img class="faw-carousel-bg"
						src="${carousel.tasmania.imagePath}.adapt.1663.high.jpg"
						alt="${carousel.tasmania.imageAltTag}">
				</noscript>
			</div> <!--[if (lt IE 9) & (!IEMobile)]>
				<img class="faw-carousel-bg" src="${carousel.tasmania.imagePath}.adapt.1663.high.jpg" alt="${carousel.tasmania.imageAltTag}">
			<![endif]-->
			<div class="calltoaction calltoactionbubble calltoactionbubble-white">
				<div class="head-divider">
					<div class="head-divider-inner">
						<hr
							class="icon-logo-withlines-hr icon-logo-withlines-hr-small experiences-head-divider-hr">
						<div class="head-divider-title">
							<span
								class="icon-map icon-map-small icon-map-black icon-map-tasmania"></span>
						</div>
						<hr
							class="icon-logo-withlines-hr icon-logo-withlines-hr-small experiences-head-divider-hr">
					</div>
				</div>
				<div class="calltoactionbubble-copy">
					<h5 class="cta-title">${carousel.tasmania.circleTopText}</h5>
					<h2 class="cta-main-title">${carousel.tasmania.circleMiddleText}</h2>
					<h5 class="cta-sub-title">${carousel.tasmania.circleBottomText}</h5>
					<hr class="divider-small">
					<p class="cta-description">${carousel.tasmania.text}
						<a href="${carousel.tasmania.findOutMoreLink}">Find out more</a>
					</p>
				</div>
			</div>
		</li>
		<li class="item">
			<div class="faw-carousel-bg-container" data-picture="" data-alt="">
				<div data-src="${carousel.victoria.imagePath}.adapt.480.low.jpg"
					data-media="(min-width: 1px)"></div>
				<div data-src="${carousel.victoria.imagePath}.adapt.768.medium.jpg"
					data-media="(min-width: 481px)"></div>
				<div data-src="${carousel.victoria.imagePath}.adapt.992.high.jpg"
					data-media="(min-width: 769px)"></div>
				<div data-src="${carousel.victoria.imagePath}.adapt.1663.high.jpg"
					data-media="(min-width: 993px)"></div>
				<noscript>
					<img class="faw-carousel-bg"
						src="${carousel.victoria.imagePath}.adapt.1663.high.jpg"
						alt="${carousel.victoria.imageAltTag}">
				</noscript>
			</div> <!--[if (lt IE 9) & (!IEMobile)]>
				<img class="faw-carousel-bg" src="${carousel.victoria.imagePath}.adapt.1663.high.jpg" alt="${carousel.victoria.imageAltTag}">
			<![endif]-->
			<div class="calltoaction calltoactionbubble calltoactionbubble-white">
				<div class="head-divider">
					<div class="head-divider-inner">
						<hr
							class="icon-logo-withlines-hr icon-logo-withlines-hr-small experiences-head-divider-hr">
						<div class="head-divider-title">
							<span
								class="icon-map icon-map-small icon-map-black icon-map-victoria"></span>
						</div>
						<hr
							class="icon-logo-withlines-hr icon-logo-withlines-hr-small experiences-head-divider-hr">
					</div>
				</div>
				<div class="calltoactionbubble-copy">
					<h5 class="cta-title">${carousel.victoria.circleTopText}</h5>
					<h2 class="cta-main-title">${carousel.victoria.circleMiddleText}</h2>
					<h5 class="cta-sub-title">${carousel.victoria.circleBottomText}</h5>
					<hr class="divider-small">
					<p class="cta-description">${carousel.victoria.text}
						<a href="${carousel.victoria.findOutMoreLink}">Find out more</a>
					</p>
				</div>
			</div>
		</li>
		<li class="item">
			<div class="faw-carousel-bg-container" data-picture="" data-alt="">
				<div data-src="${carousel.western.imagePath}.adapt.480.low.jpg"
					data-media="(min-width: 1px)"></div>
				<div data-src="${carousel.western.imagePath}.adapt.768.medium.jpg"
					data-media="(min-width: 481px)"></div>
				<div data-src="${carousel.western.imagePath}.adapt.992.high.jpg"
					data-media="(min-width: 769px)"></div>
				<div data-src="${carousel.western.imagePath}.adapt.1663.high.jpg"
					data-media="(min-width: 993px)"></div>
				<noscript>
					<img class="faw-carousel-bg"
						src="${carousel.western.imagePath}.adapt.1663.high.jpg"
						alt="${carousel.western.imageAltTag}">
				</noscript>
			</div> <!--[if (lt IE 9) & (!IEMobile)]>
				<img class="faw-carousel-bg" src="${carousel.western.imagePath}.adapt.1663.high.jpg" alt="${carousel.western.imageAltTag}">
			<![endif]-->
			<div class="calltoaction calltoactionbubble calltoactionbubble-white">
				<div class="head-divider">
					<div class="head-divider-inner">
						<hr
							class="icon-logo-withlines-hr icon-logo-withlines-hr-small experiences-head-divider-hr">
						<div class="head-divider-title">
							<span
								class="icon-map icon-map-small icon-map-black icon-map-western"></span>
						</div>
						<hr
							class="icon-logo-withlines-hr icon-logo-withlines-hr-small experiences-head-divider-hr">
					</div>
				</div>
				<div class="calltoactionbubble-copy">
					<h5 class="cta-title">${carousel.western.circleTopText}</h5>
					<h2 class="cta-main-title">${carousel.western.circleMiddleText}</h2>
					<h5 class="cta-sub-title">${carousel.western.circleBottomText}</h5>
					<hr class="divider-small">
					<p class="cta-description">${carousel.western.text}
						<a href="${carousel.western.findOutMoreLink}">Find out more</a>
					</p>
				</div>
			</div>
		</li>
	</ul>
	<p class="carousel-pagination-icons">
		<span class="icon-map icon-map-white icon-map icon-hidden"> <span>Australia</span>
		</span> <span class="icon-map icon-map-white icon-map-capital"> <span>Australian
				Capital Territory</span>
		</span> <span class="icon-map icon-map-white icon-map-nsw"> <span>New
				South Wales</span>
		</span> <span class="icon-map icon-map-white icon-map-northern"> <span>Northern
				Territory</span>
		</span> <span class="icon-map icon-map-white icon-map-queensland"> <span>Queensland</span>
		</span> <span class="icon-map icon-map-white icon-map-south"> <span>South
				Australia</span>
		</span> <span class="icon-map icon-map-white icon-map-tasmania"> <span>Tasmania</span>
		</span> <span class="icon-map icon-map-white icon-map-victoria"> <span>Victoria</span>
		</span> <span class="icon-map icon-map-white icon-map-western"> <span>Western
				Australia</span>
		</span>
	</p>
</div>
<!-- END: FOOD AND WINE PLACES CAROUSEL -->