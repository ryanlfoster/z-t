<%@include file="/apps/foodandwine/components/global.jsp"%>
<%@ page import="com.australia.foodandwine.components.content.exploreBy.ExploreBy"%>

<c:set var="exploreBy" value="<%=new ExploreBy(slingRequest) %>" />

<div class="faw-territories">
	<div class='faw-places faw-bg-full-container'>
		<div class="l-position-absolute fullwidth-bg">
		<div class="responsive-image" data-picture="" data-alt="${exploreBy.imageAltTag}" >
			<div data-src="${exploreBy.imagePath}.adapt.480.low.jpg" data-media="(min-width: 1px)"></div>
			<div data-src="${exploreBy.imagePath}.adapt.720.medium.jpg" data-media="(min-width: 481px)"></div>
			<div data-src="${exploreBy.imagePath}.adapt.683.high.jpg" data-media="(min-width: 769px)"></div>
			<div data-src="${exploreBy.imagePath}.adapt.683.high.jpg" data-media="(min-width: 993px)"></div>
			<noscript>
				<img src='${exploreBy.imagePath}.adapt.1663.high.jpg'>
			</noscript>
		</div>
		<!--[if (lt IE 9) & (!IEMobile)]>
            <img src='${exploreBy.imagePath}.adapt.1663.high.jpg' alt='${exploreBy.imageAltTag}'>
        <![endif]-->
	</div>
		<div class='faw-places-inner'>
			<div class="faw-territories-copy">
				<hr class="divider-small">
				<h5>${exploreBy.topText}</h5>
				<h2>${exploreBy.bottomText}</h2>
				<hr class="divider-small">
			</div>
			<!-- selection for desktop -->
			<div class="l-display-none-md">
				<p class='icon-map-wrapper'>
					<a href="${exploreBy.capital}.html" class="icon-map icon-map-white icon-map-capital"> <span>Australian Captital Territory</span> </a>
					<a href="${exploreBy.nsw}.html" class="icon-map icon-map-white icon-map-nsw"> <span>New South Wales</span> </a>
					<a href="${exploreBy.northern}.html" class="icon-map icon-map-white icon-map-northern"> <span>Northern Territory</span> </a>
					<a href="${exploreBy.queensland}.html" class="icon-map icon-map-white icon-map-queensland"> <span>Queensland</span> </a>
					<a href="${exploreBy.south}.html" class="icon-map icon-map-white icon-map-south"> <span>South Australia</span> </a>
					<a href="${exploreBy.tasmania}.html" class="icon-map icon-map-white icon-map-tasmania"> <span>Tasmania</span> </a>
					<a href="${exploreBy.victoria}.html" class="icon-map icon-map-white icon-map-victoria"> <span>Victoria</span> </a>
					<a href="${exploreBy.western}.html" class="icon-map icon-map-white icon-map-western"> <span>Western Australia</span> </a>
				</p>
			</div>
			<!-- END: selection -->
			<!-- selection for mobile -->
			<div class="l-display-md">
				<select class="input-select input-select-small">
					<option value="" disabled>Select place</option>
					<option value="capital">Capital</option>
					<option value="nsw">NSW</option>
					<option value="northern">Northern</option>
					<option value="queensland">Queensland</option>
					<option value="south">South</option>
					<option value="tasmania">Tasmania</option>
					<option value="victoria">Victoria</option>
					<option value="western">Western</option>
				</select>
			</div>
			<!-- END: selection -->
		</div>
	</div>
</div>