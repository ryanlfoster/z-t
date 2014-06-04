<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/apps/foodandwine/components/global.jsp" %>
<%@ page import="com.australia.foodandwine.components.content.statehero.StateHero" %>

<c:set var="stateHero" value="<%=new StateHero(slingRequest) %>"/>

<div class='faw-places faw-bg-full-container'>
    <div class="l-display-none-md l-position-absolute fullwidth-bg" data-image-vertical-alignment="bottom" data--500-top="-webkit-transform: translate(0,15%);" data-500-bottom="-webkit-transform: translate(0,-15%);">
        <div class="responsive-image" data-picture="" data-alt="" >
            <div data-src="${stateHero.imagePath}.adapt.480.low.jpg" data-media="(min-width: 1px)"></div>
            <div data-src="${stateHero.imagePath}.adapt.720.medium.jpg" data-media="(min-width: 481px)"></div>
            <div data-src="${stateHero.imagePath}.adapt.720.high.jpg" data-media="(min-width: 769px)"></div>
            <div data-src="${stateHero.imagePath}.adapt.1663.high.jpg" data-media="(min-width: 993px)"></div>
            <noscript>
                <img src='${stateHero.imagePath}.adapt.1663.high.jpg' alt=''>
            </noscript>
        </div>
        <!--[if (lt IE 9) & (!IEMobile)]>
            <img src='${stateHero.imagePath}.adapt.1663.high.jpg' alt=''>
        <![endif]-->
    </div>
    <div class='faw-places-inner'>
<div class="calltoaction calltoactionbubble">
    <div class="head-divider">
        <div class="head-divider-inner">
            <hr class="icon-logo-withlines-hr icon-logo-withlines-hr-small experiences-head-divider-hr">
            <div class="head-divider-title">
                <img class="experiences-head-divider-image" src="/etc/designs/foodandwine/clientlibs/imgs/base/headline-map-icon.png">
            </div>
            <hr class="icon-logo-withlines-hr icon-logo-withlines-hr-small experiences-head-divider-hr">
        </div>
    </div>
     <h5>${stateHero.topText}</h5>
    <h2>${stateHero.centerText}</h2>
    <h5>${stateHero.bottomText}</h5>
    <hr class="divider-small">
</div>
        <!-- selection for mobile -->
        <div class="l-display-none-md">
            <p class='icon-map-wrapper'>
                <a href="#" class="icon-map icon-map-white icon-map-capital"> <span>Australian Captital Territory</span> </a>
                <a href="#" class="icon-map icon-map-white icon-map-nsw"> <span>New South Wales</span> </a>
                <a href="#" class="icon-map icon-map-white icon-map-northern"> <span>Northern Territory</span> </a>
                <a href="#" class="icon-map icon-map-white icon-map-queensland"> <span>Queensland</span> </a>
                <a href="#" class="icon-map icon-map-white icon-map-south"> <span>South Australia</span> </a>
                <a href="#" class="icon-map icon-map-white icon-map-tasmania"> <span>Tasmania</span> </a>
                <a href="#" class="icon-map icon-map-white icon-map-victoria"> <span>Victoria</span> </a>
                <a href="#" class="icon-map icon-map-white icon-map-western"> <span>Western Australia</span> </a>
            </p>
        </div>
        <!-- END: selection -->
        <!-- selection for mobile -->
        <div class="l-display-md">
            <select class="input-select input-select-small">
                <option value="nsw">
                    <p class="type-font-feature">
                        Select place
                    </p></option>
				<option value="capital">ACT</option>
				<option value="nsw">NSW</option>
				<option value="northern">NT</option>
				<option value="queensland">QLD</option>
				<option value="south">SA</option>
				<option value="tasmania">TAS</option>
				<option value="victoria">VIC</option>
				<option value="western">WA</option>
            </select>
        </div>
        <!-- END: selection -->
    </div>
</div>
