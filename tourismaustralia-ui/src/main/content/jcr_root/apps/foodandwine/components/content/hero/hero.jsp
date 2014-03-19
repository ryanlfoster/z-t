<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/apps/foodandwine/components/global.jsp"%>
<%@ page import="com.australia.foodandwine.components.content.hero.Hero"%>

<c:set var="Hero" value="<%=new Hero(slingRequest) %>" /> 
<!-- test background for testing, whow the transparent menu respons -->
<div class='faw-hero-home faw-bg-full-container faw-hero-home make-black'>
	<div class='faw-hero-home-bg'><img data-width='1580' data-height='1153' class='faw-bg-full' src="${Hero.imagePath}" alt=""/></div>
	<div class="faw-hero-home-container">
<div class="icon-logo-withlines-container">
    <hr class="icon-logo-withlines-hr">
    <span href="#" class="icon-logo-withlines-logo btn-restaurant-australia-logo icon-font-logo"></span>
    <hr class="icon-logo-withlines-hr">
</div>
		<h1>${Hero.bigTitle}</h1>
        <hr class="faw-hero-home-hr">
 <div class='calltoaction'>
    <div class="calltoaction-title-container is-mobile">
        <div class="calltoaction-type-sml1">add your business to our venues list</div>
    </div>
   <%--  <div class="calltoaction-title-container is-desktop">
        <div class="calltoaction-type-sml1">${Hero.smallFontText }</div>
        <div class="calltoaction-type-lrg">${Hero.largeFontText }</div>
        <div class="calltoaction-type-sml1">${Hero.smallFont }</div>
        <hr class="calltoaction-hr">
    </div> --%>
    <a href="#" class="btn-secondary btn-register">${Hero.buttonText }</a>
    <p>${Hero.byLineText }</p>
    <div class="is-mobile">
        <hr class="calltoaction-hr">
    </div>
</div>
	</div>
	<div class="faw-video-teaser-wrapper l-position-normal">
	<div class="faw-video-teaser">
		<h5 class="faw-video-teaser-label is-mobile">what is restaurant australia?</h5>
		<h5 class="faw-video-teaser-label is-desktop">${Hero.textBeforePlayButton }</h5>
		<a href="#" class="faw-video-teaser-icon btn-round-video icon-font-video-play" data-video-button="home-video"></a>
		<h5 class="faw-video-teaser-label is-desktop">${Hero.textAfterPlayButton }</h5>
	</div>
</div>
<!-- video container -->
<div id='home-video' class="video-container">
    <a class="video-close-btn icon-font-cross" href="#"></a>
    <div class="video-table">
        <div class="video-table-cell">
            PLACE VIDEO HERE!
        </div>
    </div>
</div>
</div>