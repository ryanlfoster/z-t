<%@include file="/apps/foodandwine/components/global.jsp"%>
<%@ page import="com.australia.foodandwine.components.content.search.Search" %>

<c:set var="search" value="<%=new Search(slingRequest) %>"/>

<cq:includeClientLib js="faw-search"/>



<div class="faw-hero-home-container" data-searchurl="${search.searchPath}">
        <h3 class="form-h3 l-padding-top-xs-2 l-padding-bottom-xs-0-5">${search.totalSearchResultsCount} Search results for: <strong></strong></h3>
        <input class="input-field-blank input-field-big input-field-normal-left-border" placeholder="E.g. Cafe Sydney">
        <a href="#" class="btn-secondary btn-auto-size">Search</a>
    </div>
    <div class="faw-search-tag-cloud">
	<p class="faw-search-tag-cloud-headline">Other people were intrested in searching for:</p>
		<ul>
			<li><a href="" target="_self">Alpine</a></li>
			<li><a href="" target="_self">Roasted</a></li>
			<li><a href="" target="_self">Outdoors</a></li>
			<li><a href="" target="_self">Produce</a></li>
		</ul>
</div>

<div class="faw-category-mosaic">
	<!-- FOOD MOSAIC GRID CHANGER -->
	
<div class="mosaicgridchanger">

	<!-- CATEGORY DROP DOWNS -->
	<div class="faw-category-mosaic-drop-downs">

		<!-- CATEGORY DROP DOWN -->
		<div class="faw-category-mosaic-drop-down">
			<select class="input-select input-select-small">
				<option value="" selected="selected" disabled="">Filter by category</option>
				<option value="restaurants">Restaurants</option>
				<option value="wine">Wine</option>
				<option value="produce">Produce</option>
				<option value="events">Events</option>
				<option value="people">People</option>
				<option value="experiences">Experiences</option>
				<option value="seafood">Seafood</option>
			</select>
		</div>
		<!-- END: CATEGORY DROP DOWN -->

		<!-- STATE DROP DOWN -->
		<div class="faw-category-mosaic-drop-down">
			<select class="input-select input-select-small">
				<option value="" selected="selected" disabled="">Filter by location</option>
				<option value="southernaustralia">Capital</option>
				<option value="victoria">NSW</option>
				<option value="northern">Northern</option>
				<option value="queensland">Queensland</option>
				<option value="south">South</option>
				<option value="tasmania">Tasmania</option>
				<option value="victoria">Victoria</option>
				<option value="western">Western</option>
			</select>
		</div>
		<!-- END: STATE DROP DOWN -->
	</div>
	<!-- END: CATEGORY DROP DOWNS -->
	
	<!-- GRID CHANGER BUTTONS -->
	<div class="mosaicgridchanger-button mosaicgridchanger-grid-button mosaicgridchanger-button-active">
		<span class="icon-font-sort_grid"></span>
	</div>
	<div class="mosaicgridchanger-button mosaicgridchanger-list-button">
		<span class="icon-font-sort_list"></span>
	</div>
	<!-- END: GRID CHANGER BUTTONS -->
</div>
	<!-- END: FOOD MOSAIC GRID CHANGER -->

	<!-- MOSAIC -->
	
