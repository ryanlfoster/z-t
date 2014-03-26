<%@include file="/apps/foodandwine/components/global.jsp"%>

<div class="faw-article">
	<!-- test background for testing, whow the transparent menu respons -->
	<div class='form-hero'>
		<div class="faw-hero-home-container">
			<h1 class="form-h1">Simone's bright</h1>
			<div class="form-biline-container type-spacing-60">
				<hr>
				<div class="form-elements-biline">
					www.simonesofbright.com.au</div>
			</div>

			<cq:include path="category" resourceType="foodandwine/components/content/category" />
			<cq:include path="text" resourceType="foodandwine/components/content/text" />
		</div>
	</div>

	<cq:include path="shareThis" resourceType="foodandwine/components/content/shareThis" />
	<cq:include path="quote" resourceType="foodandwine/components/content/quote" />
	<cq:include path="chef" resourceType="foodandwine/components/content/chef" />
	<cq:include path="mainparsys" resourceType="foundation/components/parsys" />
	<cq:include path="map" resourceType="foodandwine/components/content/map" />

	<div class="l-center">
		<div class="experiences">
			<h5 class='experiences-headline'>Other Experiences in</h5>
			<h2>Victoria</h2>
			<hr class="divider-small">
			<cq:include path="otherExperiences" resourceType="foodandwine/components/content/other" />
		</div>
	</div>
</div>



