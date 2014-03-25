<%@include file="/apps/foodandwine/components/global.jsp"%>

		<div class="faw-article">
			<!-- test background for testing, whow the transparent menu respons -->
			<div class='form-hero'>
				<div class="faw-hero-home-container">
					<div class="icon-logo-withlines-container">
						<hr class="icon-logo-withlines-hr">
						<span href="#"
							class="icon-logo-withlines-logo btn-restaurant-australia-logo icon-font-logo"></span>
						<hr class="icon-logo-withlines-hr">
					</div>
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
			<cq:include path="mainparsys" resourceType="foundation/components/parsys" />
			<cq:include path="map" resourceType="foodandwine/components/content/map" />

			<div class="l-center">
				<div class="experiences">
<!-- 					<div class="head-divider experiences-head-divider"> -->
<!-- 						<div class="head-divider-inner"> -->
<!-- 							<hr class="icon-logo-withlines-hr icon-logo-withlines-hr-small"> -->
<!-- 							<hr class="icon-logo-withlines-hr icon-logo-withlines-hr-small"> -->
<!-- 						</div> -->
<!-- 					</div> -->

					<h5 class='experiences-headline'>Other Experiences in</h5>
					<h2>Victoria</h2>
					<hr class="divider-small">

					<cq:include path="otherExperiences" resourceType="foodandwine/components/content/other" />

				</div>
			</div>

		</div>
	</div>



