<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/apps/tourismaustralia/components/global.jsp" %>
<%@ page import="com.australia.www.components.content.hero.Hero" %>
<c:set var="hero" value="<%=new Hero(slingRequest) %>"/>

<div class="home-hero make-white">
	<div class="home-bg fullwidth-bg">
		<div class="responsive-image" data-picture="" data-alt="${hero.altText}" >
			<div data-src="${hero.imageSelection}" data-media="(min-width: 1px)"></div>
			<div data-src="${hero.imageSelection}" data-media="(min-width: 481px)"></div>
			<div data-src="${hero.imageSelection}" data-media="(min-width: 769px)"></div>
			<div data-src="${hero.imageSelection}" data-media="(min-width: 993px)"></div>
			<noscript>
				<img src="${hero.imageSelection}" alt="${hero.altText}">
			</noscript>
		</div>
		<!--[if (lt IE 9) & (!IEMobile)]>
		<img src="${hero.imageSelection}" alt="${hero.altText}">
		<![endif]-->
	</div>

	<div class="home-hero-text-table-container">
		<div class="home-hero-text-table-cell">
			<div class="home-hero-title">
				<c:out value="${hero.title}" />
			</div>
			<div class="home-hero-sub-title">
				<c:out value="${hero.subTitle}" />
			</div>
		</div>
	</div>
	<div class="row l-center-1200 home-hero-favourite-container">
		<div class="col-xs-12 col-sm-3">
			<div class="hero-home-favourite">
				<a href="#" class="favourite favourite-btn">
					<!-- TODO: Embed 'Favorite' component here -->
    <span class="btn-bubble">
    <span class="btn-bubble-button">
    <img class="btn-bubble-std" src="imgs/icons/favourite_white_outline.png" alt=""/>
    <img class="btn-bubble-active" src="imgs/icons/favourite_white.png" alt=""/>
    </span>
    </span>
    <span class="favourite-text">add to your dream trip</span>
				</a>
			</div>
		</div>
	</div>
</div>