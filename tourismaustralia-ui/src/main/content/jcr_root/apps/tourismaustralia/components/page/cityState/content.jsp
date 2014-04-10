<%@include file="/apps/tourismaustralia/components/global.jsp"%>
<div id="main-content">
	<cq:include path="hero" resourceType="tourismaustralia/components/content/hero"/>
	
	<div class="home-explore-summary-map">
		<div class="row l-center-1200">
			<div class="col-xs-12">
				<div class="breadcrumbs">
					<cq:include path="breadcrumb" resourceType="tourismaustralia/components/content/breadcrumb"/>
				</div>
			</div>
		</div>
		<div class="row l-center-1200">
			<div class="col-xs-12 col-sm-3">
				<cq:include path="breadcrumb" resourceType="tourismaustralia/components/content/breadcrumb"/>
	            <div class="shareicons-container">
	     			<cq:include path="shareThis" resourceType="tourismaustralia/components/content/shareThis"/>
				</div>
			</div>
			<div class="col-xs-12 col-sm-9">
				<div>
					<div class="col-xs-12 col-sm-12 col-md-6 col-md-push-6 home-summary-map-container">
						<cq:include path="imageMapWithCityLink" resourceType="tourismaustralia/components/content/imageMapWithCityLink"/>
					</div>
					<div class="col-xs-12 col-sm-12 col-md-6 col-md-pull-6">
						<div class="row">
							<cq:include path="summary" resourceType="tourismaustralia/components/content/summary"/>
						</div>
						<hr class="full">
						<div class="row">
							<div class="type-body">
								<cq:include path="text" resourceType="tourismaustralia/components/content/text"/>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="paragraph-city">
		<cq:include path="mainParsys" resourceType="foundation/components/parsys"/>
		<cq:include path="atdwHighlights" resourceType="tourismaustralia/components/content/atdwHighlights"/>
		<cq:include path="categorizedIconLinks" resourceType="tourismaustralia/components/content/categorizedIconLinks"/>
	</div>
</div>