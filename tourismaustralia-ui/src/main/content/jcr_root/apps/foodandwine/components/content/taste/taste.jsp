<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/apps/foodandwine/components/global.jsp"%>
<%@ page
	import="com.australia.foodandwine.components.content.taste.Taste"%>

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

				<a title="" class="mosaic-item"
					href="http://restaurant.australia.com/explore/victoria/Restaurants/taste-the-menu-at-the-lake-house.html">
					<img width="100%" class="mosaic-item-image"
					alt="${taste.imageAltTag}" src="${taste.imagePath}"> <span
					class="mosaic-item-description"> <span
						class="mosaic-item-description-head type-font-feature">${taste.imageTitle}</span>
						<span class="mosaic-item-description-sub">Victoria</span> <span
						class="mosaic-item-description-copy">${taste.imageSubscript}<br>
						<br> <span class="mosaic-item-description-copy-link"><strong>Read
									more</strong></span> <strong class="mosaic-item-description-categories"><em>Restaurants</em></strong>
					</span>
				</span> <span class="mosaic-item-overlay mosaic-item-overlay-info">
						<span class="mosaic-item-overlay-info-icon"> <span
							class="mosaic-item-overlay-info-head type-font-feature">${taste.imageTitle} </span> <span
							class="mosaic-item-overlay-info-icon-item"></span>
							<span class="mosaic-item-overlay-info-desciption">${taste.imageSubscript}
								<br> <br> <span
								class="mosaic-item-description-copy-link"><strong>Find
										out more</strong></span>
						</span>
					</span> <span class="mosaic-item-overlay-info-categories"><strong>Restaurants</strong></span>
				</span>
				</a>
			</div>


			<div class="col-xs-12 col-md-6">
				<div class="row">
					<div class="col-xs-12 col-sm-6">
						<a href="${taste.upperLeftExperience.link}" title=""
							class="mosaic-item"> <img class="mosaic-item-image"
							src="${taste.upperLeftExperience.imagePath}"
							alt="${taste.upperLeftExperience.title}" width="100%"> <span
							class="mosaic-item-description"> <span
								class="mosaic-item-description-head type-font-feature">${taste.upperLeftExperience.title}</span>
								<span class="mosaic-item-description-sub">${taste.upperLeftExperience.state}</span>
						</span> <span class="mosaic-item-overlay mosaic-item-overlay-info">
								<span class="mosaic-item-overlay-info-icon"> <span
									class="mosaic-item-overlay-info-head type-font-feature">${taste.upperLeftExperience.title} </span> <span
									class="mosaic-item-overlay-info-icon-item"></span>
									<span class="mosaic-item-overlay-info-desciption">${taste.upperLeftExperience.state}
										<br> <br> <span
										class="mosaic-item-description-copy-link"><strong>Find
												out more</strong></span>
								</span>
							</span> <span class="mosaic-item-overlay-info-categories"><strong>Restaurants</strong></span>
						</span>
						</a>

					</div>
					<div class="col-xs-12 col-sm-6">
						<a href="${taste.upperRightExperience.link}" title=""
							class="mosaic-item"> <img class="mosaic-item-image"
							src="${taste.upperRightExperience.imagePath}"
							alt="${taste.upperRightExperience.title}" width="100%"> <span
							class="mosaic-item-description"> <span
								class="mosaic-item-description-head type-font-feature">${taste.upperRightExperience.title}</span>
								<span class="mosaic-item-description-sub">${taste.upperRightExperience.state}</span>
						</span> <span class="mosaic-item-overlay mosaic-item-overlay-info">
								<span class="mosaic-item-overlay-info-icon"> <span
									class="mosaic-item-overlay-info-head type-font-feature">${taste.upperRightExperience.title}</span> <span
									class="mosaic-item-overlay-info-icon-item"></span>
									<span class="mosaic-item-overlay-info-desciption">${taste.upperRightExperience.state}
										<br> <br> <span
										class="mosaic-item-description-copy-link"><strong>Find
												out more</strong></span>
								</span>
							</span> <span class="mosaic-item-overlay-info-categories"><strong></strong></span>
						</span>
						</a>

					</div>
					<div class="col-xs-12 col-sm-6">
						<a href="${taste.lowerLeftExperience.link}" title=""
							class="mosaic-item"> <img class="mosaic-item-image"
							src="${taste.lowerLeftExperience.imagePath}"
							alt="${taste.lowerLeftExperience.title}" width="100%"> <span
							class="mosaic-item-description"> <span
								class="mosaic-item-description-head type-font-feature">${taste.lowerLeftExperience.title}</span>
								<span class="mosaic-item-description-sub">${taste.lowerLeftExperience.state}</span>
						</span> <span class="mosaic-item-overlay mosaic-item-overlay-info">
								<span class="mosaic-item-overlay-info-icon"> <span
									class="mosaic-item-overlay-info-head type-font-feature">${taste.lowerLeftExperience.title} </span> <span
									class="mosaic-item-overlay-info-icon-item"></span>
									<span class="mosaic-item-overlay-info-desciption">${taste.lowerLeftExperience.state}
										<br> <br> <span
										class="mosaic-item-description-copy-link"><strong>Find
												out more</strong></span>
								</span>
							</span> <span class="mosaic-item-overlay-info-categories"><strong></strong></span>
						</span>
						</a>

					</div>
					<div class="col-xs-12 col-sm-6">
						<a href="${taste.lowerRightExperience.link}" title=""
							class="mosaic-item"> <img class="mosaic-item-image"
							src="${taste.lowerRightExperience.imagePath}"
							alt="${taste.lowerRightExperience.title}" width="100%"> <span
							class="mosaic-item-description"> <span
								class="mosaic-item-description-head type-font-feature">${taste.lowerRightExperience.title}</span>
								<span class="mosaic-item-description-sub">${taste.lowerRightExperience.state}</span>
						</span> <span class="mosaic-item-overlay mosaic-item-overlay-info">
								<span class="mosaic-item-overlay-info-icon"> <span
									class="mosaic-item-overlay-info-head type-font-feature">${taste.lowerRightExperience.title} </span> <span
									class="mosaic-item-overlay-info-icon-item"></span>
									<span class="mosaic-item-overlay-info-desciption">${taste.lowerRightExperience.state}
										<br> <br> <span
										class="mosaic-item-description-copy-link"><strong>Find
												out more</strong></span>
								</span>
							</span> <span class="mosaic-item-overlay-info-categories"><strong></strong></span>
						</span>
						</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class='fawexploremosaictext'>${taste.mosaicText}</div>
</div>