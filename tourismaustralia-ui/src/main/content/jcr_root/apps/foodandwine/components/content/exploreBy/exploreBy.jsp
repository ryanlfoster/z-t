<%@include file="/apps/foodandwine/components/global.jsp"%>
<%@ page import="com.australia.foodandwine.components.content.exploreBy.ExploreBy"%>

<c:set var="exploreBy" value="<%=new ExploreBy(slingRequest) %>" />

<div class="faw-territories">
	<div class="faw-territories-socialcounter">
<div class="socialcounter">
	<div class="socialcounter-bg"></div>
	<div class="socialcounter-content">
		<p class='socialcounter-count type-font-feature'>10,337</p>
		<p class='socialcounter-tagged'>tagged</p>
		<p class='socialcounter-link'><strong>#restaurants</strong></p>
	</div>
</div>	
	</div>
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
					<option value="" disabled>Select place</option>
					<option value="capital">Australian Capital Territory</option>
					<option value="nsw">New South Wales</option>
					<option value="northern">Northern Territory</option>
					<option value="queensland">Queensland</option>
					<option value="south">South Australia</option>
					<option value="tasmania">Tasmania</option>
					<option value="victoria">Victoria</option>
					<option value="western">Western Australia</option>
				</select>
			</div>
			<!-- END: selection -->
		</div>
	</div>
</div>