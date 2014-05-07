<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/apps/tourismaustralia/components/global.jsp" %>
<%@ page import="com.australia.www.components.content.hero.Hero" %>
<c:set var="hero" value="<%=new Hero(slingRequest) %>"/>

<div class="home-hero make-white">
	<div class="home-bg fullwidth-bg" data-image-vertical-alignment="bottom">
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
            <h1 class="home-hero-title">
				<c:out value="${hero.title}" />
			</h1>
            <h2 class="home-hero-sub-title">
				<c:out value="${hero.subTitle}" />
			</h2>
		</div>
	</div>
	<div class="row l-center-1200 home-hero-favourite-container">
		<div class="col-xs-12 col-md-5">
			<div class="hero-home-favourite">
				<cq:include path="favorite" resourceType="tourismaustralia/components/content/favourite"/>
			</div>
		</div>
	</div>
</div>