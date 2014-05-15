<%@include file="/apps/foodandwine/components/global.jsp"%>
<%@ page
	import="com.australia.foodandwine.components.content.search.Search"%>

<c:set var="search" value="<%=new Search(slingRequest) %>" />
<cq:includeClientLib js="faw-search" />

<script id="searchMosaic" type="text/x-handlebars-template">
<cq:include script="template.jsp" />
</script>

<div class="faw-hero-home-container">

	<h3 class="form-h3 l-padding-top-xs-2 l-padding-bottom-xs-0-5"></h3>

	<input
		class="input-field-blank input-field-big input-field-normal-left-border"
		placeholder="E.g. Cafe Sydney"> <a href="#"
		class="btn-secondary btn-auto-size">Search</a>
</div>


<div class="faw-search-tag-cloud">
	<p class="faw-search-tag-cloud-headline">${search.headLine}</p>
	<ul>
		<c:forEach items="${search.interestedSearchList}" var="item">
			<li><a href="#" onclick="interestedSearch('${item}')">${item}</a></li>
		</c:forEach>
	</ul>
</div>

<div class="faw-category-mosaic">
	<!-- FOOD MOSAIC GRID CHANGER -->

	<div class="mosaicgridchanger">

		<!-- CATEGORY DROP DOWNS -->
		<div class="faw-category-mosaic-drop-downs">

			<!-- CATEGORY DROP DOWN -->
			<div class="faw-category-mosaic-drop-down">
				<select
					class="input-select input-select-small input-select-bottom-border input-select-mosaic-filter"
					id="categoryDropdown">
					<option value="" selected="selected">Filter by category</option>
					<option value="ta:food-and-wine/category/restaurant">Restaurants</option>
					<option value="ta:food-and-wine/category/wine">Wine</option>
					<option value="ta:food-and-wine/category/produce">Produce</option>
					<option value="ta:food-and-wine/category/events">Festivals</option>
					<option value="ta:food-and-wine/category/people">People</option>
					<option value="ta:food-and-wine/category/experiences">Experiences</option>
					<option value="ta:food-and-wine/category/seafood">Seafood</option>
				</select>
			</div>
			<!-- END: CATEGORY DROP DOWN -->

			<!-- STATE DROP DOWN -->
			<div class="faw-category-mosaic-drop-down">
				<select
					class="input-select input-select-small input-select-bottom-border input-select-mosaic-filter"
					id="stateDropdown">
					<option value="" selected="selected">Filter by location</option>
					<option value="ta:place/australia-capital-territory">ACT</option>
					<option value="ta:place/new-south-wales">NSW</option>
					<option value="ta:place/northern-territory">NT</option>
					<option value="ta:place/queensland">QLD</option>
					<option value="ta:place/south-australia">SA</option>
					<option value="ta:place/tasmania">TAS</option>
					<option value="ta:place/victoria">VIC</option>
					<option value="ta:place/western-australia">WA</option>
				</select>
			</div>
			<!-- END: STATE DROP DOWN -->
		</div>
		<!-- END: CATEGORY DROP DOWNS -->

		<!-- GRID CHANGER BUTTONS -->
		<div
			class="mosaicgridchanger-button mosaicgridchanger-grid-button mosaicgridchanger-button-active">
			<span class="icon-font-sort_grid"></span>
		</div>
		<div class="mosaicgridchanger-button mosaicgridchanger-list-button">
			<span class="icon-font-sort_list"></span>
		</div>
		<!-- END: GRID CHANGER BUTTONS -->
	</div>
	<div class="mosaic"></div>

	<p class="type-spacing-120">
		<a class="btn-secondary btn-auto-size">Show more Results</a>
	</p>

</div>

