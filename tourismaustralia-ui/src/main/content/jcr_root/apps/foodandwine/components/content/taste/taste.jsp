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
				
					<img class="mosaic-item-image" src="${taste.imagePath}"
						alt="${taste.imageAltTag}" width="100%"> 
						
					<img class="mosaic-item-location-icon"  alt="White map marker icon" 
						src="/etc/designs/foodandwine/clientlibs/imgs/map-icons/map-marker-white.png">
					<div class="mosaic-item-description">
						<p class="mosaic-item-description-head type-font-feature">${taste.imageTitle}</p>
						<p class="mosaic-item-description-sub">${taste.imageSubscript}</p>
					</div>
				</div>
			</div>
			
			<div class="col-xs-12 col-md-6">
				<div class="row">
					<div class="col-xs-12 col-sm-6">
						<div class="mosaic-item">
							<img class="mosaic-item-image" src="${taste.upperLeftExperience.imagePath}"
								alt="${taste.upperLeftExperience.imageTitle}" width="100%">

							<div class="mosaic-item-description">
								<p class="mosaic-item-description-head type-font-feature">
									${taste.upperLeftExperience.imageTitle}</p>
								<p class="mosaic-item-description-sub">${taste.upperLeftExperience.state}</p>
								<p class="mosaic-item-description-copy">
									Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed
									do eiusmod tempor incididunt ut labore et dolore magna aliqua.
									Ut enim ad minim veniam, quis nostrud exercitation ullamco
									laboris nisi ut aliquip ex ea commodo consequat. Duis aute
									irure dolor in reprehenderit in voluptate velit esse cillum
									dolore eu fugiat nulla pariatur. Excepteur sint occaecat
									cupidatat non proident, sunt in culpa qui officia deserunt
									mollit anim id est laborum. <br/>
									<br/> <a href=""><strong>Read more</strong></a> <strong
										class="mosaic-item-description-categories"><em>${fn:join(taste.upperLeftExperience.tags,', ')}</em></strong>
								</p>
							</div>

							<div class="mosaic-item-overlay mosaic-item-overlay-info">
								<div class="mosaic-item-overlay-info-icon">
									<span class="mosaic-item-overlay-info-icon-item"><img
										src="${taste.upperLeftExperience.icon}" alt=""></span>

									<p class="mosaic-item-overlay-info-head type-font-feature">
										${taste.upperLeftExperience.imageTitle}</p>

									<p class="mosaic-item-overlay-info-desciption">
										${taste.upperLeftExperience.city}, ${taste.upperLeftExperience.state}<br/> <br/> <a href=""><strong>Find
												out more</strong></a>
									</p>
								</div>
								<p class="mosaic-item-overlay-info-categories">
									<strong>${fn:join(taste.upperLeftExperience.tags,', ')}...</strong>
								</p>
							</div>
						</div>
					</div>
					
					<div class="col-xs-12 col-sm-6">
						<div class="mosaic-item">
							<img class="mosaic-item-image" src="${taste.upperRightExperience.imagePath}"
								alt="${taste.upperRightExperience.imageTitle}" width="100%">

							<div class="mosaic-item-description">
								<p class="mosaic-item-description-head type-font-feature">
									${taste.upperRightExperience.imageTitle}</p>
								<p class="mosaic-item-description-sub">${taste.upperRightExperience.state}</p>
								<p class="mosaic-item-description-copy">
									Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed
									do eiusmod tempor incididunt ut labore et dolore magna aliqua.
									Ut enim ad minim veniam, quis nostrud exercitation ullamco
									laboris nisi ut aliquip ex ea commodo consequat. Duis aute
									irure dolor in reprehenderit in voluptate velit esse cillum
									dolore eu fugiat nulla pariatur. Excepteur sint occaecat
									cupidatat non proident, sunt in culpa qui officia deserunt
									mollit anim id est laborum. <br/>
									<br/> <a href=""><strong>Read more</strong></a> <strong
										class="mosaic-item-description-categories"><em>${fn:join(taste.upperRightExperience.tags,',')}</em></strong>
								</p>
							</div>

							<div class="mosaic-item-overlay mosaic-item-overlay-info">
								<div class="mosaic-item-overlay-info-icon">
									<span class="mosaic-item-overlay-info-icon-item"><img
										src="${taste.upperRightExperience.icon}" alt=""></span>

									<p class="mosaic-item-overlay-info-head type-font-feature">
										${taste.upperRightExperience.imageTitle}</p>

									<p class="mosaic-item-overlay-info-desciption">
										${taste.upperRightExperience.city}, ${taste.upperRightExperience.state}<br/> <br/> <a href=""><strong>Find
												out more</strong></a>
									</p>
								</div>
								<p class="mosaic-item-overlay-info-categories">
									<strong>${fn:join(taste.upperRightExperience.tags,', ')}...</strong>
								</p>
							</div>
						</div>
					</div>
					
					<div class="col-xs-12 col-sm-6">
						<div class="mosaic-item">
							<img class="mosaic-item-image" src="${taste.lowerLeftExperience.imagePath}"
								alt="${taste.lowerLeftExperience.imageTitle}" width="100%">

							<div class="mosaic-item-description">
								<p class="mosaic-item-description-head type-font-feature">
									${taste.lowerLeftExperience.imageTitle}</p>
								<p class="mosaic-item-description-sub">${taste.lowerLeftExperience.state}</p>
								<p class="mosaic-item-description-copy">
									Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed
									do eiusmod tempor incididunt ut labore et dolore magna aliqua.
									Ut enim ad minim veniam, quis nostrud exercitation ullamco
									laboris nisi ut aliquip ex ea commodo consequat. Duis aute
									irure dolor in reprehenderit in voluptate velit esse cillum
									dolore eu fugiat nulla pariatur. Excepteur sint occaecat
									cupidatat non proident, sunt in culpa qui officia deserunt
									mollit anim id est laborum. <br/>
									<br/> <a href=""><strong>Read more</strong></a> <strong
										class="mosaic-item-description-categories"><em>${fn:join(taste.lowerLeftExperience.tags,',')}</em></strong>
								</p>
							</div>

							<div class="mosaic-item-overlay mosaic-item-overlay-info">
								<div class="mosaic-item-overlay-info-icon">
									<span class="mosaic-item-overlay-info-icon-item"><img
										src="${taste.lowerLeftExperience.icon}" alt=""></span>

									<p class="mosaic-item-overlay-info-head type-font-feature">
										${taste.lowerLeftExperience.imageTitle}</p>

									<p class="mosaic-item-overlay-info-desciption">
										${taste.lowerLeftExperience.city}, ${taste.lowerLeftExperience.state}<br/> <br/> <a href=""><strong>Find
												out more</strong></a>
									</p>
								</div>
								<p class="mosaic-item-overlay-info-categories">
									<strong>${fn:join(taste.lowerLeftExperience.tags,', ')}...</strong>
								</p>
							</div>
						</div>
					</div>
					
					<div class="col-xs-12 col-sm-6">
						<div class="mosaic-item">
							<img class="mosaic-item-image" src="${taste.lowerRightExperience.imagePath}"
								alt="${taste.lowerRightExperience.imageTitle}" width="100%">

							<div class="mosaic-item-description">
								<p class="mosaic-item-description-head type-font-feature">
									${taste.lowerRightExperience.imageTitle}</p>
								<p class="mosaic-item-description-sub">${taste.lowerRightExperience.state}</p>
								<p class="mosaic-item-description-copy">
									Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed
									do eiusmod tempor incididunt ut labore et dolore magna aliqua.
									Ut enim ad minim veniam, quis nostrud exercitation ullamco
									laboris nisi ut aliquip ex ea commodo consequat. Duis aute
									irure dolor in reprehenderit in voluptate velit esse cillum
									dolore eu fugiat nulla pariatur. Excepteur sint occaecat
									cupidatat non proident, sunt in culpa qui officia deserunt
									mollit anim id est laborum. <br/>
									<br/> <a href=""><strong>Read more</strong></a> <strong
										class="mosaic-item-description-categories"><em>${fn:join(taste.lowerRightExperience.tags,',')}</em></strong>
								</p>
							</div>

							<div class="mosaic-item-overlay mosaic-item-overlay-info">
								<div class="mosaic-item-overlay-info-icon">
									<span class="mosaic-item-overlay-info-icon-item"><img
										src="${taste.lowerRightExperience.icon}" alt=""></span>

									<p class="mosaic-item-overlay-info-head type-font-feature">
										${taste.lowerRightExperience.imageTitle}</p>

									<p class="mosaic-item-overlay-info-desciption">
										${taste.lowerRightExperience.city}, ${taste.lowerRightExperience.state}<br/> <br/> <a href=""><strong>Find
												out more</strong></a>
									</p>
								</div>
								<p class="mosaic-item-overlay-info-categories">
									<strong>${fn:join(taste.lowerRightExperience.tags,', ')}...</strong>
								</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<p class="fawexploremosaictext">
		Want to list your Food &amp; Wine business here? <a href="" target="_self">Register now.</a>
	</p>
</div>