<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/apps/foodandwine/components/global.jsp"%>
<%@ page import="com.australia.foodandwine.components.content.imageWithCircleText.ImageWithCircleText"%>

<c:set var="imageWithCircleText" value="<%=new ImageWithCircleText(slingRequest) %>"/>

<div class="faw-explore-teaser faw-bg-full-container">
	<div class="l-position-absolute fullwidth-bg" data-image-vertical-alignment="bottom" data--250-top="-webkit-transform: translate(0,10%);" data-250-bottom="-webkit-transform: translate(0,-10%);">
		<div class="responsive-image" data-picture="" data-alt="${imageWithCircleText.imageAltTag}">
			<div data-src="${imageWithCircleText.backGroundImage}.adapt.480.low.jpg" data-media="(min-width: 1px)"></div>
			<div data-src="${imageWithCircleText.backGroundImage}.adapt.720.medium.jpg" data-media="(min-width: 481px)"></div>
			<div data-src="${imageWithCircleText.backGroundImage}.adapt.720.high.jpg" data-media="(min-width: 769px)"></div>
			<div data-src="${imageWithCircleText.backGroundImage}.adapt.1663.high.jpg" data-media="(min-width: 993px)"></div>
			<noscript>
				<img src="${imageWithCircleText.backGroundImage}.adapt.1663.high.jpg" alt="${imageWithCircleText.imageAltTag}" >
			</noscript> 
		<img alt="${imageWithCircleText.imageAltTag}" src="${imageWithCircleText.backGroundImage}.adapt.1663.high.jpg" style="width: 1674.1840490797545px; margin-left: -124.09202453987723px; margin-top: 0px;"></div>
		<!--[if (lt IE 9) & (!IEMobile)]>
            <img src='imgs/pages/explore/explore-teaser-bg.jpg' alt='${imageWithCircleText.imageAltTag}'>
        <![endif]-->
	</div>
	
	<div class="faw-explore-teaser-inner">
		<div class="calltoaction calltoactionbubble calltoactionbubblebig">
		  	<hr class="divider-small">
			<h5>${imageWithCircleText.smallTitle}</h5>
			<h2>${imageWithCircleText.bigText}</h2>
			<hr class="divider-small">
			<p>${imageWithCircleText.descriptionText}</p>
		</div>
	</div>
</div>

