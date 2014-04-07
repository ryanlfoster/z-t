<%@include file="/apps/foodandwine/components/global.jsp"%>

<div class="faw-article">
		<!-- test background for testing, whow the transparent menu respons -->
	<div class='form-hero'>
		<div class="faw-hero-home-container">
			<cq:include path="articleTitle" resourceType="foodandwine/components/content/articleTitle" />
			<cq:include path="category" resourceType="foodandwine/components/content/category" />
			<h3 class="faw-article-healdine">${currentPage.description}</h3>
		</div>
	</div>

	<cq:include path="shareThis" resourceType="foodandwine/components/content/shareThis" />
	<cq:include path="mainparsys" resourceType="foundation/components/parsys" />
	<cq:include path="accolade" resourceType="foundation/components/content/accolade" />
	<cq:include path="map" resourceType="foodandwine/components/content/map" />


	<cq:include path="otherExperiences" resourceType="foodandwine/components/content/otherExperiences" />
</div>



