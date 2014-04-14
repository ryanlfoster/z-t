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
			<div class="faw-carousel-bg-container" data-picture="" data-alt="" >
			    <div data-src="${carousel.imagePath}.adapt.480.low.jpg" data-media="(min-width: 1px)"></div>
			    <div data-src="${carousel.imagePath}.adapt.768.medium.jpg" data-media="(min-width: 481px)"></div>
			    <div data-src="${carousel.imagePath}.adapt.992.high.jpg" data-media="(min-width: 769px)"></div>
			    <div data-src="${carousel.imagePath}.adapt.1663.high.jpg" data-media="(min-width: 993px)"></div>
			    <noscript>
			        <img class="faw-carousel-bg" src="${carousel.imagePath}.adapt.1663.high.jpg" alt="${carouse.imageAltTag}">
			    </noscript>
			</div>
			<!--[if (lt IE 9) & (!IEMobile)]>
				<img class="faw-carousel-bg" src="${carousel.imagePath}.adapt.1663.high.jpg" alt="${carouse.imageAltTag}">
			<![endif]-->
			<div class="calltoaction calltoactionbubble">
			    <div class="head-divider">
			        <div class="head-divider-inner">
			            <hr class="icon-logo-withlines-hr icon-logo-withlines-hr-small experiences-head-divider-hr">
			            <div class="head-divider-title">
			                <img class="experiences-head-divider-image" src="imgs/base/headline-map-icon.png">
			            </div>
			            <hr class="icon-logo-withlines-hr icon-logo-withlines-hr-small experiences-head-divider-hr">
			        </div>
			    </div>
			    <h5>Food & wine can take you to</h5>
			    <h2>Another place</h2>
			    <h5>Select a state or territory</h5>
			    <hr class="divider-small">
			</div>
        </li>
		<li class="item">
			<div class="faw-carousel-bg-container" data-picture="" data-alt="" >
			    <div data-src="${carousel.act.imagePath}.adapt.480.low.jpg" data-media="(min-width: 1px)"></div>
			    <div data-src="${carousel.act.imagePath}.adapt.768.medium.jpg" data-media="(min-width: 481px)"></div>
			    <div data-src="${carousel.act.imagePath}.adapt.992.high.jpg" data-media="(min-width: 769px)"></div>
			    <div data-src="${carousel.act.imagePath}.adapt.1663.high.jpg" data-media="(min-width: 993px)"></div>
			    <noscript>
			        <img class="faw-carousel-bg" src="${carousel.act.imagePath}.adapt.1663.high.jpg" alt="${carousel.act.imageAltTag}">
			    </noscript>
			</div>
			<!--[if (lt IE 9) & (!IEMobile)]>
				<img class="faw-carousel-bg" src="imgs/base/faw-carousel-bg.jpg" alt="">
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
					<h5 class="cta-title">${carousel.act.circleTopText}</h5>
					<h2 class="cta-main-title">${carousel.act.circleMiddleText}</h2>
					<h5 class="cta-sub-title">${carousel.act.circleBottomText}</h5>
					<hr class="divider-small">
					<p class="cta-description">${carousel.act.text} <a href="${carousel.act.findOutMoreLink}">Find out more</a>
					</p>
				</div>
			</div></li>
		<li class="item">
			<div class="faw-carousel-bg-container" data-picture="" data-alt="" >
			    <div data-src="${carousel.nsw.imagePath}.adapt.480.low.jpg" data-media="(min-width: 1px)"></div>
			    <div data-src="${carousel.nsw.imagePath}.adapt.768.medium.jpg" data-media="(min-width: 481px)"></div>
			    <div data-src="${carousel.nsw.imagePath}.adapt.992.high.jpg" data-media="(min-width: 769px)"></div>
			    <div data-src="${carousel.nsw.imagePath}.adapt.1663.high.jpg" data-media="(min-width: 993px)"></div>
			    <noscript>
			        <img class="faw-carousel-bg" src="${carousel.nsw.imagePath}.adapt.1663.high.jpg" alt="${carousel.nsw.imageAltTag}">
			    </noscript>
			</div>
			<!--[if (lt IE 9) & (!IEMobile)]>
				<img class="faw-carousel-bg" src="${carousel.nsw.imagePath}.adapt.1663.high.jpg" alt="${carousel.nsw.imageAltTag}">
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
					<h5 class="cta-title">${carousel.nsw.circleTopText}</h5>
					<h2 class="cta-main-title">${carousel.nsw.circleMiddleText}</h2>
					<h5 class="cta-sub-title">${carousel.nsw.circleBottomText}</h5>
					<hr class="divider-small">
					<p class="cta-description">${carousel.nsw.text} <a href="${carousel.nsw.findOutMoreLink}">Find out more</a>
					</p>
				</div>
			</div></li>
		<li class="item">
			<div class="faw-carousel-bg-container" data-picture="" data-alt="" >
			    <div data-src="${carousel.nt.imagePath}.adapt.480.low.jpg" data-media="(min-width: 1px)"></div>
			    <div data-src="${carousel.nt.imagePath}.adapt.768.medium.jpg" data-media="(min-width: 481px)"></div>
			    <div data-src="${carousel.nt.imagePath}.adapt.992.high.jpg" data-media="(min-width: 769px)"></div>
			    <div data-src="${carousel.nt.imagePath}.adapt.1663.high.jpg" data-media="(min-width: 993px)"></div>
			    <noscript>
			        <img class="faw-carousel-bg" src="${carousel.nt.imagePath}.adapt.1663.high.jpg" alt="${carousel.nt.imageAltTag}">
			    </noscript>
			</div>
			<!--[if (lt IE 9) & (!IEMobile)]>
				<img class="faw-carousel-bg" src="${carousel.nt.imagePath}.adapt.1663.high.jpg" alt="${carousel.nt.imageAltTag}">
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
					<h5 class="cta-title">${carousel.nt.circleTopText}</h5>
					<h2 class="cta-main-title">${carousel.nt.circleMiddleText}</h2>
					<h5 class="cta-sub-title">${carousel.nt.circleBottomText}</h5>
					<hr class="divider-small">
					<p class="cta-description">${carousel.nt.text} <a href="${carousel.nt.findOutMoreLink}">Find out more</a>
					</p>
				</div>
			</div></li>
		<li class="item">
			<div class="faw-carousel-bg-container" data-picture="" data-alt="" >
			    <div data-src="${carousel.qld.imagePath}.adapt.480.low.jpg" data-media="(min-width: 1px)"></div>
			    <div data-src="${carousel.qld.imagePath}.adapt.768.medium.jpg" data-media="(min-width: 481px)"></div>
			    <div data-src="${carousel.qld.imagePath}.adapt.992.high.jpg" data-media="(min-width: 769px)"></div>
			    <div data-src="${carousel.qld.imagePath}.adapt.1663.high.jpg" data-media="(min-width: 993px)"></div>
			    <noscript>
			        <img class="faw-carousel-bg" src="${carousel.qld.imagePath}.adapt.1663.high.jpg" alt="${carousel.qld.imageAltTag}">
			    </noscript>
			</div>
			<!--[if (lt IE 9) & (!IEMobile)]>
				<img class="faw-carousel-bg" src="${carousel.qld.imagePath}.adapt.1663.high.jpg" alt="${carousel.qld.imageAltTag}">
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
					<h5 class="cta-title">${carousel.qld.circleTopText}</h5>
					<h2 class="cta-main-title">${carousel.qld.circleMiddleText}</h2>
					<h5 class="cta-sub-title">${carousel.qld.circleBottomText}</h5>
					<hr class="divider-small">
					<p class="cta-description">${carousel.qld.text} <a href="${carousel.qld.findOutMoreLink}">Find out more</a>
					</p>
				</div>
			</div></li>
		<li class="item">
			<div class="faw-carousel-bg-container" data-picture="" data-alt="" >
			    <div data-src="${carousel.sa.imagePath}.adapt.480.low.jpg" data-media="(min-width: 1px)"></div>
			    <div data-src="${carousel.sa.imagePath}.adapt.768.medium.jpg" data-media="(min-width: 481px)"></div>
			    <div data-src="${carousel.sa.imagePath}.adapt.992.high.jpg" data-media="(min-width: 769px)"></div>
			    <div data-src="${carousel.sa.imagePath}.adapt.1663.high.jpg" data-media="(min-width: 993px)"></div>
			    <noscript>
			        <img class="faw-carousel-bg" src="${carousel.sa.imagePath}.adapt.1663.high.jpg" alt="${carousel.sa.imageAltTag}">
			    </noscript>
			</div>
			<!--[if (lt IE 9) & (!IEMobile)]>
				<img class="faw-carousel-bg" src="${carousel.sa.imagePath}.adapt.1663.high.jpg" alt="${carousel.sa.imageAltTag}">
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
					<h5 class="cta-title">${carousel.sa.circleTopText}</h5>
					<h2 class="cta-main-title">${carousel.sa.circleMiddleText}</h2>
					<h5 class="cta-sub-title">${carousel.sa.circleBottomText}</h5>
					<hr class="divider-small">
					<p class="cta-description">${carousel.sa.text} <a href="${carousel.sa.findOutMoreLink}">Find out more</a>
					</p>
				</div>
			</div></li>
		<li class="item">
			<div class="faw-carousel-bg-container" data-picture="" data-alt="" >
			    <div data-src="${carousel.tas.imagePath}.adapt.480.low.jpg" data-media="(min-width: 1px)"></div>
			    <div data-src="${carousel.tas.imagePath}.adapt.768.medium.jpg" data-media="(min-width: 481px)"></div>
			    <div data-src="${carousel.tas.imagePath}.adapt.992.high.jpg" data-media="(min-width: 769px)"></div>
			    <div data-src="${carousel.tas.imagePath}.adapt.1663.high.jpg" data-media="(min-width: 993px)"></div>
			    <noscript>
			        <img class="faw-carousel-bg" src="${carousel.tas.imagePath}.adapt.1663.high.jpg" alt="${carousel.tas.imageAltTag}">
			    </noscript>
			</div>
			<!--[if (lt IE 9) & (!IEMobile)]>
				<img class="faw-carousel-bg" src="${carousel.tas.imagePath}.adapt.1663.high.jpg" alt="${carousel.tas.imageAltTag}">
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
					<h5 class="cta-title">${carousel.tas.circleTopText}</h5>
					<h2 class="cta-main-title">${carousel.tas.circleMiddleText}</h2>
					<h5 class="cta-sub-title">${carousel.tas.circleBottomText}</h5>
					<hr class="divider-small">
					<p class="cta-description">${carousel.tas.text} <a href="${carousel.tas.findOutMoreLink}">Find out more</a>
					</p>
				</div>
			</div></li>
		<li class="item">
			<div class="faw-carousel-bg-container" data-picture="" data-alt="" >
			    <div data-src="${carousel.vic.imagePath}.adapt.480.low.jpg" data-media="(min-width: 1px)"></div>
			    <div data-src="${carousel.vic.imagePath}.adapt.768.medium.jpg" data-media="(min-width: 481px)"></div>
			    <div data-src="${carousel.vic.imagePath}.adapt.992.high.jpg" data-media="(min-width: 769px)"></div>
			    <div data-src="${carousel.vic.imagePath}.adapt.1663.high.jpg" data-media="(min-width: 993px)"></div>
			    <noscript>
			        <img class="faw-carousel-bg" src="${carousel.vic.imagePath}.adapt.1663.high.jpg" alt="${carousel.vic.imageAltTag}">
			    </noscript>
			</div>
			<!--[if (lt IE 9) & (!IEMobile)]>
				<img class="faw-carousel-bg" src="${carousel.vic.imagePath}.adapt.1663.high.jpg" alt="${carousel.vic.imageAltTag}">
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
					<h5 class="cta-title">${carousel.vic.circleTopText}</h5>
					<h2 class="cta-main-title">${carousel.vic.circleMiddleText}</h2>
					<h5 class="cta-sub-title">${carousel.vic.circleBottomText}</h5>
					<hr class="divider-small">
					<p class="cta-description">${carousel.vic.text} <a href="${carousel.vic.findOutMoreLink}">Find out more</a>
					</p>
				</div>
			</div></li>
		<li class="item">
			<div class="faw-carousel-bg-container" data-picture="" data-alt="" >
			    <div data-src="${carousel.wa.imagePath}.adapt.480.low.jpg" data-media="(min-width: 1px)"></div>
			    <div data-src="${carousel.wa.imagePath}.adapt.768.medium.jpg" data-media="(min-width: 481px)"></div>
			    <div data-src="${carousel.wa.imagePath}.adapt.992.high.jpg" data-media="(min-width: 769px)"></div>
			    <div data-src="${carousel.wa.imagePath}.adapt.1663.high.jpg" data-media="(min-width: 993px)"></div>
			    <noscript>
			        <img class="faw-carousel-bg" src="${carousel.wa.imagePath}.adapt.1663.high.jpg" alt="${carousel.wa.imageAltTag}">
			    </noscript>
			</div>
			<!--[if (lt IE 9) & (!IEMobile)]>
				<img class="faw-carousel-bg" src="${carousel.wa.imagePath}.adapt.1663.high.jpg" alt="${carousel.wa.imageAltTag}">
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
					<h5 class="cta-title">${carousel.wa.circleTopText}</h5>
					<h2 class="cta-main-title">${carousel.wa.circleMiddleText}</h2>
					<h5 class="cta-sub-title">${carousel.wa.circleBottomText}</h5>
					<hr class="divider-small">
					<p class="cta-description">${carousel.wa.text} <a href="${carousel.wa.findOutMoreLink}">Find out more</a>
					</p>
				</div>
			</div></li>
	</ul>
	<p class="carousel-pagination-icons">
		<span class="icon-map icon-map-white icon-map icon-hidden"> <span>Australia</span>
		</span> <span class="icon-map icon-map-white icon-map-capital"> <span>Australian Capital Territory</span>
		</span> <span class="icon-map icon-map-white icon-map-nsw"> <span>New South Wales</span>
		</span> <span class="icon-map icon-map-white icon-map-northern"> <span>Northern Territory</span>
		</span> <span class="icon-map icon-map-white icon-map-queensland"> <span>Queensland</span>
		</span> <span class="icon-map icon-map-white icon-map-south"> <span>South Australia</span>
		</span> <span class="icon-map icon-map-white icon-map-tasmania"> <span>Tasmania</span>
		</span> <span class="icon-map icon-map-white icon-map-victoria"> <span>Victoria</span>
		</span> <span class="icon-map icon-map-white icon-map-western"> <span>Western Australia</span>
		</span>
	</p>
</div>
<!-- END: FOOD AND WINE PLACES CAROUSEL -->