<%@include file="/apps/foodandwine/components/global.jsp"%>
<%@ page import="com.australia.foodandwine.components.content.taste.Taste"%>

<c:set var="taste" value="<%=new Taste(slingRequest) %>" />

<div class="fawexploremosaic">
	<div class="headerlockup headerlockup-single">
		<hr class="headerlockup-hr">
		<h2>${taste.title}</h2>
		<hr class="headerlockup-hr">
	</div>
	
	<p class="fawexploremosaictext">${taste.description}</p>

	<div class="mosaic mosaic-static">
		<div class="row l-row-collapse">
			<div class="col-xs-12 col-md-6">
				<div class="mosaic-item mosaic-item-location">
					<img class="mosaic-item-image" src="${taste.imagePath}" alt="${taste.imageAltTag}"
						width="100%"> <img class="mosaic-item-location-icon"
						src="/etc/designs/foodandwine/clientlibs/imgs/map-icons/map-marker-white.png" alt="">
					<div class="mosaic-item-description">
						<p class="mosaic-item-description-head type-font-feature">${taste.imageTitle}</p>
						<p class="mosaic-item-description-sub">${taste.imageSubscript}</p>
					</div>
				</div>
			</div>
			<div class="col-xs-12 col-md-6">
				<div class="row">
					<div class="col-xs-12 col-sm-6">
						<a href="#" title="" class="mosaic-item"> <img
							class="mosaic-item-image"
							src="${taste.upperLeftExperience.imagePath}"
							alt="${taste.upperLeftExperience.title}" width="100%"> <span
							class="mosaic-item-description"> <span
								class="mosaic-item-description-head type-font-feature">${taste.upperLeftExperience.title}</span>
								<span class="mosaic-item-description-sub">${taste.upperLeftExperience.state}</span>
						</span>
						</a>

					</div>
					<div class="col-xs-12 col-sm-6">
						<a href="#" title="" class="mosaic-item"> <img
							class="mosaic-item-image"
							src="${taste.upperRightExperience.imagePath}"
							alt="${taste.upperRightExperience.title}" width="100%"> <span
							class="mosaic-item-description"> <span
								class="mosaic-item-description-head type-font-feature">${taste.upperRightExperience.title}</span>
								<span class="mosaic-item-description-sub">${taste.upperRightExperience.state}</span>
						</span>
						</a>

					</div>
					<div class="col-xs-12 col-sm-6">
						<a href="#" title="" class="mosaic-item"> <img
							class="mosaic-item-image"
							src="${taste.lowerLeftExperience.imagePath}"
							alt="${taste.lowerLeftExperience.title}" width="100%"> <span
							class="mosaic-item-description"> <span
								class="mosaic-item-description-head type-font-feature">${taste.lowerLeftExperience.title}</span>
								<span class="mosaic-item-description-sub">${taste.lowerLeftExperience.state}</span>
						</span>
						</a>

					</div>
					<div class="col-xs-12 col-sm-6">
						<a href="#" title="" class="mosaic-item"> <img
							class="mosaic-item-image"
							src="${taste.lowerRightExperience.imagePath}"
							alt="${taste.lowerRightExperience.title}" width="100%"> <span
							class="mosaic-item-description"> <span
								class="mosaic-item-description-head type-font-feature">${taste.lowerRightExperience.title}</span>
								<span class="mosaic-item-description-sub">${taste.lowerRightExperience.state}</span>
						</span>
						</a>
					</div>
				</div>
			</div>
		</div>
	</div>

	<p class="fawexploremosaictext">
		Want to list your Food &amp; Wine business here? <a href="" target="_self">Register now.</a>
	</p>
</div>