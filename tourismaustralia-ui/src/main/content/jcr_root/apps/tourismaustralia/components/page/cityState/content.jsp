<%@include file="/apps/tourismaustralia/components/global.jsp"%>

<%-- Header --%>

<%-- Hero --%>
<cq:include path="hero" resourceType="tourismaustralia/components/content/hero"/>

<%-- Page explore summary map --%>
<div class="row l-padding-between-item-fill-white">
<div class="home-explore-summary-map">

    <div class="row l-center-1200"> <%-- Breadcrumb component --%>
        <div class="col-xs-12">
            <div class="breadcrumbs">
                <ul class="breadcrumb">
                    <li><a href="#">...</a>
                    <li><a href="#">New South Wales</a>
                </ul>
            </div>
        </div>
    </div>

    <div class="row l-center-1200">
        <div class="col-xs-12 col-sm-3">
            <div class="tagcloud-container">
                <cq:include path="tagCloud" resourceType="tourismaustralia/components/content/tagCloud"/>
            </div>
            <div class="shareicons-container"> <%-- SHARE COMPONENT --%>
				<div class="shareicons">
				    <ul>
				        <li class="btn-bubble">
				            <span class="btn-bubble-button st_email_large" displayText="Email">
				                <img class="btn-bubble-std" src="/etc/designs/tourismaustralia/clientlibs/img/icons/email_outline.png" alt="">
				                <img class="btn-bubble-active" src="/etc/designs/tourismaustralia/clientlibs/img/icons/email.png" alt="">
				            </span>
				        </li>
				        <li class="btn-bubble">
				            <span class="btn-bubble-button st_facebook_large" displayText="Facebook">
				                <img class="btn-bubble-std" src="/etc/designs/tourismaustralia/clientlibs/img/icons/facebook_outline.png" alt="">
				                <img class="btn-bubble-active" src="/etc/designs/tourismaustralia/clientlibs/img/icons/facebook.png" alt="">
				            </span>
				        </li>
				        <li class="btn-bubble">
				            <span class="btn-bubble-button st_twitter_large" displayText="Twitter">
				                <img class="btn-bubble-std" src="/etc/designs/tourismaustralia/clientlibs/img/icons/twitter_outline.png" alt="">
				                <img class="btn-bubble-active" src="/etc/designs/tourismaustralia/clientlibs/img/icons/twitter.png" alt="">
				            </span>
				        </li>
				        <li class="btn-bubble">
				            <span class="btn-bubble-button st_sharethis_large" displayText="ShareThis">
				                <img class="btn-bubble-std" src="/etc/designs/tourismaustralia/clientlibs/img/icons/share_outline.png" alt="">
				                <img class="btn-bubble-active" src="/etc/designs/tourismaustralia/clientlibs/img/icons/share.png" alt="">
				            </span>
				        </li>
				        <li class="social-fblike"><span class="st_fblike_large" displayText="Facebook Like"></span></li>
				    </ul>
				
				    <script type="text/javascript">var switchTo5x=true;</script>
				    <script type="text/javascript" src="http://w.sharethis.com/button/buttons.js"></script>
				    <script type="text/javascript">stLight.options({publisher: "ur-f4ab25a3-9e79-84bb-993-552e71e1bc9", onhover: false, doNotHash: true, doNotCopy: true, hashAddressBar: false});</script>
				
				</div>
            </div>
        </div>
        <div class="col-xs-12 col-sm-9">
            <div>
                <div class="col-xs-12 col-sm-12 col-md-6 col-md-push-6 home-summary-map-container"> <%-- MAP WITH CITY COMPONENT --%>
                    <cq:include path="imageMapWithCityLink" resourceType="tourismaustralia/components/content/imageMapWithCityLink"/>
                </div>
                <div class="col-xs-12 col-sm-12 col-md-6 col-md-pull-6">
                    <div class="row">
                        <%-- TEXT COMPONENT --%>
                        <cq:include path="summary" resourceType="tourismaustralia/components/content/summary"/>
                    </div>
                    <hr class="full">
                    <div class="row">
                        <%-- TEXT COMPONENT --%>
                        <cq:include path="text" resourceType="tourismaustralia/components/content/text"/>
                    </div>
                </div>
            </div>

        </div>
    </div>

</div>
</div>

<%-- main parsys --%>
<cq:include path="mainparsys" resourceType="foundation/components/parsys" />

<%-- ATDW TEMPLATE --%>
<div class="l-padding-between-item-fill-white">
<div class="makeyourtriphappen-container">

	<div class="section-intro">
	    <div class="l-center-900">
	        <h1 class="type-h1-responsive">
	            MAKE YOUR TRIP HAPPEN
	        </h1>
	    </div>
	    <div class="l-center-640 type-center">
	        <p class="type-intro">
	            You've come this far. Now let us help make your dream trip a reality. Choose from the options below and let your holiday take shape.
	        </p>
	    </div>
	</div>
    <div class="l-h-center section-buttons">

        <!-- Select List For Mobile -->
        <div class="section-buttons-mobile">
            <div class="dropdown-select">
			    <hr>
			    <div class="dropdown-select-style">
			        <select>
	                    <option>Accommodation</option>
	                    <option>Attractions</option>
	                    <option>Restaurants</option>
	                    <option>Tours</option>
	                    <option>Hire</option>
	                    <option>Events</option>
	                    <option>Transport</option>
			        </select>
			    </div>
			    <hr>
			</div>
        </div>


        <!-- Buttons -->
        <div class="section-buttons-desktop">

            <a href="#" class="btn-bubble btn-bubble-min-width is-active">
			        <span class="btn-bubble-button">
			              <img class="btn-bubble-std" src="/etc/designs/tourismaustralia/clientlibs/img/icons/accommodation_outline.png" alt=""/>
			              <img class="btn-bubble-active" src="/etc/designs/tourismaustralia/clientlibs/img/icons/accommodation.png" alt=""/>
			        </span>
			    <span class="type-below-btn">Accommodation</span>
			</a>

            <a href="#" class="btn-bubble btn-bubble-min-width">
			        <span class="btn-bubble-button">
			              <img class="btn-bubble-std" src="/etc/designs/tourismaustralia/clientlibs/img/icons/accommodation_outline.png" alt=""/>
			              <img class="btn-bubble-active" src="/etc/designs/tourismaustralia/clientlibs/img/icons/attraction.png" alt=""/>
			        </span>
			    <span class="type-below-btn">Attractions</span>
			</a>
            <a href="#" class="btn-bubble btn-bubble-min-width">
			        <span class="btn-bubble-button">
			              <img class="btn-bubble-std" src="/etc/designs/tourismaustralia/clientlibs/img/icons/restaurant_outline.png" alt=""/>
			              <img class="btn-bubble-active" src="/etc/designs/tourismaustralia/clientlibs/img/icons/restaurant.png" alt=""/>
			        </span>
			    <span class="type-below-btn">Restaurants</span>
			</a>
            <a href="#" class="btn-bubble btn-bubble-min-width">
			        <span class="btn-bubble-button">
			              <img class="btn-bubble-std" src="/etc/designs/tourismaustralia/clientlibs/img/icons/tours_outline.png" alt=""/>
			              <img class="btn-bubble-active" src="/etc/designs/tourismaustralia/clientlibs/img/icons/tours.png" alt=""/>
			        </span>
			    <span class="type-below-btn">Tours</span>
			</a>
            <a href="#" class="btn-bubble btn-bubble-min-width">
			        <span class="btn-bubble-button">
			              <img class="btn-bubble-std" src="/etc/designs/tourismaustralia/clientlibs/img/icons/hire_outline.png" alt=""/>
			              <img class="btn-bubble-active" src="/etc/designs/tourismaustralia/clientlibs/img/icons/hire.png" alt=""/>
			        </span>
			    <span class="type-below-btn">Hire</span>
			</a>
            <a href="#" class="btn-bubble btn-bubble-min-width">
			        <span class="btn-bubble-button">
			              <img class="btn-bubble-std" src="/etc/designs/tourismaustralia/clientlibs/img/icons/events_outline.png" alt=""/>
			              <img class="btn-bubble-active" src="/etc/designs/tourismaustralia/clientlibs/img/icons/events.png" alt=""/>
			        </span>
			    <span class="type-below-btn">Events</span>
			</a>
            <a href="#" class="btn-bubble btn-bubble-min-width">
			        <span class="btn-bubble-button">
			              <img class="btn-bubble-std" src="/etc/designs/tourismaustralia/clientlibs/img/icons/transport_outline.png" alt=""/>
			              <img class="btn-bubble-active" src="/etc/designs/tourismaustralia/clientlibs/img/icons/transport.png" alt=""/>
			        </span>
			    <span class="type-below-btn">Transport</span>
			</a>
        </div>

    </div>

    <div class="mosaic">
    <div class="row l-row-collapse">
        <div class="col-xs-12 col-sm-4">
            <div class="row mosaic-3column-item-option">
                <div class="mosaic-3column-item-container">
				    <div class="row mosaic-3column-container">
				        <div class="col-xs-6">
				            <div>
				                <div class="mosaic-media">
				                    <img src="/etc/designs/tourismaustralia/clientlibs/img/mosaic/img11.jpg" alt=""/>
				                </div>
				            </div>
				        </div>
				
				        <div class="col-xs-6 mosaic-3column-front-back-container flip-container">
				
				            <div class="mosaic-3column-front flip-front-fade">
				                <div class="mosaic-3column-media theme-mosaic-3column-front l-padding-t-15">
				                    <img src="/etc/designs/tourismaustralia/clientlibs/img/logo/logo_tqual_black.png" alt=""/>
				                    <p>front</p>
				                </div>
				            </div>
				
				            <div class="mosaic-3column-back flip-back-fade">
				                <div class="mosaic-3column-media theme-mosaic-3column-back l-padding-t-15">
				                    <img src="/etc/designs/tourismaustralia/clientlibs/img/logo/logo_tqual_white.png" alt=""/>
				                    <p>back</p>
				                </div>
				            </div>
				
				        </div>
				
				    </div>
				
				    <div class="row mosaic-3column-item-content">
				        <div class="mosaic-item-detail-container">
						    <div class="mosaic-item-container">
						
						        <div class="l-h-center type-spacing-20">
						            <img src="/etc/designs/tourismaustralia/clientlibs/img/icons/art_culture.png">
						        </div>
						
						        <div class="line-through-container">
								    <div class="line-through"><span class="line-through-hr"></span></div>
								    <div class="line-through-container-biline">
										Virgin Australia Fashion Festival
								    </div>
								    <div class="line-through"><span class="line-through-hr"></span></div>
								</div>
						
						        <div class="l-h-center l-padding-tb-30-lr-15">
						
						            <p>You'll love the blue-hazed beauty of the Blue Mountains World Heritage Area - one million hectares of tall forests, sandstone cliffs, canyons, waterfalls and bushland. Take in the breathtaking panoramas...</p>
						
						            <a href="#" class="btn-bubble bubble-colour-favourite">
						                <span class="btn-bubble-tooltip">
						                    <span class="btn-bubble-tooltip-container">
						                        Add to your dream trip
						                    </span>
						                </span>
						                <span class="btn-bubble-button">
						                    <img class="btn-bubble-std" src="/etc/designs/tourismaustralia/clientlibs/img/icons/favourite_outline.png" alt=""/>
						                    <img class="btn-bubble-active" src="/etc/designs/tourismaustralia/clientlibs/img/icons/favourite.png" alt=""/>
						                </span>
						            </a>
						
						        </div>
						    </div>
						</div>
				    </div>
				
				</div>
            </div>
        </div>

        <div class="col-xs-12 col-sm-4">
            <div class="row mosaic-3column-item-option">
                <div class="mosaic-3column-item-container">
				    <div class="row mosaic-3column-container">
				        <div class="col-xs-6">
				            <div>
				                <div class="mosaic-media">
				                    <img src="/etc/designs/tourismaustralia/clientlibs/img/mosaic/img11.jpg" alt=""/>
				                </div>
				            </div>
				        </div>
				
				        <div class="col-xs-6 mosaic-3column-front-back-container flip-container">
				
				            <div class="mosaic-3column-front flip-front-fade">
				                <div class="mosaic-3column-media theme-mosaic-3column-front l-padding-t-15">
				                    <img src="/etc/designs/tourismaustralia/clientlibs/img/logo/logo_tqual_black.png" alt=""/>
				                    <p>front</p>
				                </div>
				            </div>
				
				            <div class="mosaic-3column-back flip-back-fade">
				                <div class="mosaic-3column-media theme-mosaic-3column-back l-padding-t-15">
				                    <img src="/etc/designs/tourismaustralia/clientlibs/img/logo/logo_tqual_white.png" alt=""/>
				                    <p>back</p>
				                </div>
				            </div>
				
				        </div>
				
				    </div>
				
				    <div class="row mosaic-3column-item-content">
				        <div class="mosaic-item-detail-container">
						    <div class="mosaic-item-container">
						
						        <div class="l-h-center type-spacing-20">
						            <img src="/etc/designs/tourismaustralia/clientlibs/img/icons/art_culture.png">
						        </div>
						
						        <div class="line-through-container">
								    <div class="line-through"><span class="line-through-hr"></span></div>
								    <div class="line-through-container-biline">
										Virgin Australia Fashion Festival
								    </div>
								    <div class="line-through"><span class="line-through-hr"></span></div>
								</div>
						
						        <div class="l-h-center l-padding-tb-30-lr-15">
						
						            <p>You'll love the blue-hazed beauty of the Blue Mountains World Heritage Area - one million hectares of tall forests, sandstone cliffs, canyons, waterfalls and bushland. Take in the breathtaking panoramas...</p>
						
						            <a href="#" class="btn-bubble bubble-colour-favourite">
						                <span class="btn-bubble-tooltip">
						                    <span class="btn-bubble-tooltip-container">
						                        Add to your dream trip
						                    </span>
						                </span>
						                <span class="btn-bubble-button">
						                    <img class="btn-bubble-std" src="/etc/designs/tourismaustralia/clientlibs/img/icons/favourite_outline.png" alt=""/>
						                    <img class="btn-bubble-active" src="/etc/designs/tourismaustralia/clientlibs/img/icons/favourite.png" alt=""/>
						                </span>
						            </a>
						
						        </div>
						    </div>
						</div>
				    </div>
				
				</div>
            </div>
        </div>

        <div class="col-xs-12 col-sm-4">
            <div class="row mosaic-3column-item-option">
                <div class="mosaic-3column-item-container">
				    <div class="row mosaic-3column-container">
				        <div class="col-xs-6">
				            <div>
				                <div class="mosaic-media">
				                    <img src="/etc/designs/tourismaustralia/clientlibs/img/mosaic/img11.jpg" alt=""/>
				                </div>
				            </div>
				        </div>
				
				        <div class="col-xs-6 mosaic-3column-front-back-container flip-container">
				
				            <div class="mosaic-3column-front flip-front-fade">
				                <div class="mosaic-3column-media theme-mosaic-3column-front l-padding-t-15">
				                    <img src="/etc/designs/tourismaustralia/clientlibs/img/logo/logo_tqual_black.png" alt=""/>
				                    <p>front</p>
				                </div>
				            </div>
				
				            <div class="mosaic-3column-back flip-back-fade">
				                <div class="mosaic-3column-media theme-mosaic-3column-back l-padding-t-15">
				                    <img src="/etc/designs/tourismaustralia/clientlibs/img/logo/logo_tqual_white.png" alt=""/>
				                    <p>back</p>
				                </div>
				            </div>
				
				        </div>
				
				    </div>
				
				    <div class="row mosaic-3column-item-content">
				        <div class="mosaic-item-detail-container">
						    <div class="mosaic-item-container">
						
						        <div class="l-h-center type-spacing-20">
						            <img src="/etc/designs/tourismaustralia/clientlibs/img/icons/art_culture.png">
						        </div>
						
						        <div class="line-through-container">
								    <div class="line-through"><span class="line-through-hr"></span></div>
								    <div class="line-through-container-biline">
										Virgin Australia Fashion Festival
								    </div>
								    <div class="line-through"><span class="line-through-hr"></span></div>
								</div>
						
						        <div class="l-h-center l-padding-tb-30-lr-15">
						
						            <p>You'll love the blue-hazed beauty of the Blue Mountains World Heritage Area - one million hectares of tall forests, sandstone cliffs, canyons, waterfalls and bushland. Take in the breathtaking panoramas...</p>
						
						            <a href="#" class="btn-bubble bubble-colour-favourite">
						                <span class="btn-bubble-tooltip">
						                    <span class="btn-bubble-tooltip-container">
						                        Add to your dream trip
						                    </span>
						                </span>
						                <span class="btn-bubble-button">
						                    <img class="btn-bubble-std" src="/etc/designs/tourismaustralia/clientlibs/img/icons/favourite_outline.png" alt=""/>
						                    <img class="btn-bubble-active" src="/etc/designs/tourismaustralia/clientlibs/img/icons/favourite.png" alt=""/>
						                </span>
						            </a>
						
						        </div>
						    </div>
						</div>
				    </div>
				
				</div>
            </div>
        </div>
    </div>

    <div class="row l-row-collapse">
        <div class="col-xs-12 col-sm-4">
            <div class="row mosaic-3column-item-option">
                <div class="mosaic-3column-item-container">
				    <div class="row mosaic-3column-container">
				        <div class="col-xs-6">
				            <div>
				                <div class="mosaic-media">
				                    <img src="/etc/designs/tourismaustralia/clientlibs/img/mosaic/img11.jpg" alt=""/>
				                </div>
				            </div>
				        </div>
				
				        <div class="col-xs-6 mosaic-3column-front-back-container flip-container">
				
				            <div class="mosaic-3column-front flip-front-fade">
				                <div class="mosaic-3column-media theme-mosaic-3column-front l-padding-t-15">
				                    <img src="/etc/designs/tourismaustralia/clientlibs/img/logo/logo_tqual_black.png" alt=""/>
				                    <p>front</p>
				                </div>
				            </div>
				
				            <div class="mosaic-3column-back flip-back-fade">
				                <div class="mosaic-3column-media theme-mosaic-3column-back l-padding-t-15">
				                    <img src="/etc/designs/tourismaustralia/clientlibs/img/logo/logo_tqual_white.png" alt=""/>
				                    <p>back</p>
				                </div>
				            </div>
				
				        </div>
				
				    </div>
				
				    <div class="row mosaic-3column-item-content">
				        <div class="mosaic-item-detail-container">
						    <div class="mosaic-item-container">
						
						        <div class="l-h-center type-spacing-20">
						            <img src="/etc/designs/tourismaustralia/clientlibs/img/icons/art_culture.png">
						        </div>
						
						        <div class="line-through-container">
								    <div class="line-through"><span class="line-through-hr"></span></div>
								    <div class="line-through-container-biline">
										Virgin Australia Fashion Festival
								    </div>
								    <div class="line-through"><span class="line-through-hr"></span></div>
								</div>
						
						        <div class="l-h-center l-padding-tb-30-lr-15">
						
						            <p>You'll love the blue-hazed beauty of the Blue Mountains World Heritage Area - one million hectares of tall forests, sandstone cliffs, canyons, waterfalls and bushland. Take in the breathtaking panoramas...</p>
						
						            <a href="#" class="btn-bubble bubble-colour-favourite">
						                <span class="btn-bubble-tooltip">
						                    <span class="btn-bubble-tooltip-container">
						                        Add to your dream trip
						                    </span>
						                </span>
						                <span class="btn-bubble-button">
						                    <img class="btn-bubble-std" src="/etc/designs/tourismaustralia/clientlibs/img/icons/favourite_outline.png" alt=""/>
						                    <img class="btn-bubble-active" src="/etc/designs/tourismaustralia/clientlibs/img/icons/favourite.png" alt=""/>
						                </span>
						            </a>
						
						        </div>
						    </div>
						</div>
				    </div>
				
				</div>
            </div>
        </div>

        <div class="col-xs-12 col-sm-4">
            <div class="row mosaic-3column-item-option">
                <div class="mosaic-3column-item-container">
				    <div class="row mosaic-3column-container">
				        <div class="col-xs-6">
				            <div>
				                <div class="mosaic-media">
				                    <img src="/etc/designs/tourismaustralia/clientlibs/img/mosaic/img11.jpg" alt=""/>
				                </div>
				            </div>
				        </div>
				
				        <div class="col-xs-6 mosaic-3column-front-back-container flip-container">
				
				            <div class="mosaic-3column-front flip-front-fade">
				                <div class="mosaic-3column-media theme-mosaic-3column-front l-padding-t-15">
				                    <img src="/etc/designs/tourismaustralia/clientlibs/img/logo/logo_tqual_black.png" alt=""/>
				                    <p>front</p>
				                </div>
				            </div>
				
				            <div class="mosaic-3column-back flip-back-fade">
				                <div class="mosaic-3column-media theme-mosaic-3column-back l-padding-t-15">
				                    <img src="/etc/designs/tourismaustralia/clientlibs/img/logo/logo_tqual_white.png" alt=""/>
				                    <p>back</p>
				                </div>
				            </div>
				
				        </div>
				
				    </div>
				
				    <div class="row mosaic-3column-item-content">
				        <div class="mosaic-item-detail-container">
						    <div class="mosaic-item-container">
						
						        <div class="l-h-center type-spacing-20">
						            <img src="/etc/designs/tourismaustralia/clientlibs/img/icons/art_culture.png">
						        </div>
						
						        <div class="line-through-container">
								    <div class="line-through"><span class="line-through-hr"></span></div>
								    <div class="line-through-container-biline">
										Virgin Australia Fashion Festival
								    </div>
								    <div class="line-through"><span class="line-through-hr"></span></div>
								</div>
						
						        <div class="l-h-center l-padding-tb-30-lr-15">
						
						            <p>You'll love the blue-hazed beauty of the Blue Mountains World Heritage Area - one million hectares of tall forests, sandstone cliffs, canyons, waterfalls and bushland. Take in the breathtaking panoramas...</p>
						
						            <a href="#" class="btn-bubble bubble-colour-favourite">
						                <span class="btn-bubble-tooltip">
						                    <span class="btn-bubble-tooltip-container">
						                        Add to your dream trip
						                    </span>
						                </span>
						                <span class="btn-bubble-button">
						                    <img class="btn-bubble-std" src="/etc/designs/tourismaustralia/clientlibs/img/icons/favourite_outline.png" alt=""/>
						                    <img class="btn-bubble-active" src="/etc/designs/tourismaustralia/clientlibs/img/icons/favourite.png" alt=""/>
						                </span>
						            </a>
						
						        </div>
						    </div>
						</div>
				    </div>
				
				</div>
            </div>
        </div>

        <div class="col-xs-12 col-sm-4">
            <div class="row mosaic-3column-item-option">
                <div class="mosaic-3column-item-container">
				    <div class="row mosaic-3column-container">
				        <div class="col-xs-6">
				            <div>
				                <div class="mosaic-media">
				                    <img src="/etc/designs/tourismaustralia/clientlibs/img/mosaic/img11.jpg" alt=""/>
				                </div>
				            </div>
				        </div>
				
				        <div class="col-xs-6 mosaic-3column-front-back-container flip-container">
				
				            <div class="mosaic-3column-front flip-front-fade">
				                <div class="mosaic-3column-media theme-mosaic-3column-front l-padding-t-15">
				                    <img src="/etc/designs/tourismaustralia/clientlibs/img/logo/logo_tqual_black.png" alt=""/>
				                    <p>front</p>
				                </div>
				            </div>
				
				            <div class="mosaic-3column-back flip-back-fade">
				                <div class="mosaic-3column-media theme-mosaic-3column-back l-padding-t-15">
				                    <img src="/etc/designs/tourismaustralia/clientlibs/img/logo/logo_tqual_white.png" alt=""/>
				                    <p>back</p>
				                </div>
				            </div>
				
				        </div>
				
				    </div>
				
				    <div class="row mosaic-3column-item-content">
						<div class="mosaic-item-detail-container">
						    <div class="mosaic-item-container">
						
						        <div class="l-h-center type-spacing-20">
						            <img src="/etc/designs/tourismaustralia/clientlibs/img/icons/art_culture.png">
						        </div>
						
						        <div class="line-through-container">
								    <div class="line-through"><span class="line-through-hr"></span></div>
								    <div class="line-through-container-biline">
										Virgin Australia Fashion Festival
								    </div>
								    <div class="line-through"><span class="line-through-hr"></span></div>
								</div>
						
						        <div class="l-h-center l-padding-tb-30-lr-15">
						
						            <p>You'll love the blue-hazed beauty of the Blue Mountains World Heritage Area - one million hectares of tall forests, sandstone cliffs, canyons, waterfalls and bushland. Take in the breathtaking panoramas...</p>
						
						            <a href="#" class="btn-bubble bubble-colour-favourite">
						                <span class="btn-bubble-tooltip">
						                    <span class="btn-bubble-tooltip-container">
						                        Add to your dream trip
						                    </span>
						                </span>
						                <span class="btn-bubble-button">
						                    <img class="btn-bubble-std" src="/etc/designs/tourismaustralia/clientlibs/img/icons/favourite_outline.png" alt=""/>
						                    <img class="btn-bubble-active" src="/etc/designs/tourismaustralia/clientlibs/img/icons/favourite.png" alt=""/>
						                </span>
						            </a>
						
						        </div>
						    </div>
						</div>
				    </div>
				
				</div>
            </div>
        </div>
    </div>

    <div class="row l-row-collapse">
        <div class="col-xs-12 col-sm-4">
            <div class="row mosaic-3column-item-option">
                <div class="mosaic-3column-item-container">
				    <div class="row mosaic-3column-container">
				        <div class="col-xs-6">
				            <div>
				                <div class="mosaic-media">
				                    <img src="/etc/designs/tourismaustralia/clientlibs/img/mosaic/img11.jpg" alt=""/>
				                </div>
				            </div>
				        </div>
				
				        <div class="col-xs-6 mosaic-3column-front-back-container flip-container">
				
				            <div class="mosaic-3column-front flip-front-fade">
				                <div class="mosaic-3column-media theme-mosaic-3column-front l-padding-t-15">
				                    <img src="/etc/designs/tourismaustralia/clientlibs/img/logo/logo_tqual_black.png" alt=""/>
				                    <p>front</p>
				                </div>
				            </div>
				
				            <div class="mosaic-3column-back flip-back-fade">
				                <div class="mosaic-3column-media theme-mosaic-3column-back l-padding-t-15">
				                    <img src="/etc/designs/tourismaustralia/clientlibs/img/logo/logo_tqual_white.png" alt=""/>
				                    <p>back</p>
				                </div>
				            </div>
				
				        </div>
				
				    </div>
				
				    <div class="row mosaic-3column-item-content">
				        <div class="mosaic-item-detail-container">
						    <div class="mosaic-item-container">
						
						        <div class="l-h-center type-spacing-20">
						            <img src="/etc/designs/tourismaustralia/clientlibs/img/icons/art_culture.png">
						        </div>
						
						        <div class="line-through-container">
								    <div class="line-through"><span class="line-through-hr"></span></div>
								    <div class="line-through-container-biline">
										Virgin Australia Fashion Festival
								    </div>
								    <div class="line-through"><span class="line-through-hr"></span></div>
								</div>
						
						        <div class="l-h-center l-padding-tb-30-lr-15">
						
						            <p>You'll love the blue-hazed beauty of the Blue Mountains World Heritage Area - one million hectares of tall forests, sandstone cliffs, canyons, waterfalls and bushland. Take in the breathtaking panoramas...</p>
						
						            <a href="#" class="btn-bubble bubble-colour-favourite">
						                <span class="btn-bubble-tooltip">
						                    <span class="btn-bubble-tooltip-container">
						                        Add to your dream trip
						                    </span>
						                </span>
						                <span class="btn-bubble-button">
						                    <img class="btn-bubble-std" src="/etc/designs/tourismaustralia/clientlibs/img/icons/favourite_outline.png" alt=""/>
						                    <img class="btn-bubble-active" src="/etc/designs/tourismaustralia/clientlibs/img/icons/favourite.png" alt=""/>
						                </span>
						            </a>
						
						        </div>
						    </div>
						</div>
				    </div>
				
				</div>
            </div>
        </div>

        <div class="col-xs-12 col-sm-4">
            <div class="row mosaic-3column-item-option">
                <div class="row mosaic-3column-container">
				    <div class="row mosaic-3column-container">
				        <div class="col-xs-6">
				            <div>
				                <div class="mosaic-media">
				                    <img src="/etc/designs/tourismaustralia/clientlibs/img/mosaic/img11.jpg" alt=""/>
				                </div>
				            </div>
				        </div>
				
				        <div class="col-xs-6 mosaic-3column-front-back-container flip-container">
				
				            <div class="mosaic-3column-front flip-front-fade">
				                <div class="mosaic-3column-media theme-mosaic-3column-front l-padding-t-15">
				                    <img src="/etc/designs/tourismaustralia/clientlibs/img/logo/logo_tqual_black.png" alt=""/>
				                    <p>front</p>
				                </div>
				            </div>
				
				            <div class="mosaic-3column-back flip-back-fade">
				                <div class="mosaic-3column-media theme-mosaic-3column-back l-padding-t-15">
				                    <img src="/etc/designs/tourismaustralia/clientlibs/img/logo/logo_tqual_white.png" alt=""/>
				                    <p>back</p>
				                </div>
				            </div>
				
				        </div>
				
				    </div>
				
				    <div class="row mosaic-3column-item-content">
						<div class="mosaic-item-detail-container">
						    <div class="mosaic-item-container">
						
						        <div class="l-h-center type-spacing-20">
						            <img src="/etc/designs/tourismaustralia/clientlibs/img/icons/art_culture.png">
						        </div>
						
						        <div class="line-through-container">
								    <div class="line-through"><span class="line-through-hr"></span></div>
								    <div class="line-through-container-biline">
										Virgin Australia Fashion Festival
								    </div>
								    <div class="line-through"><span class="line-through-hr"></span></div>
								</div>
						
						        <div class="l-h-center l-padding-tb-30-lr-15">
						
						            <p>You'll love the blue-hazed beauty of the Blue Mountains World Heritage Area - one million hectares of tall forests, sandstone cliffs, canyons, waterfalls and bushland. Take in the breathtaking panoramas...</p>
						
						            <a href="#" class="btn-bubble bubble-colour-favourite">
						                <span class="btn-bubble-tooltip">
						                    <span class="btn-bubble-tooltip-container">
						                        Add to your dream trip
						                    </span>
						                </span>
						                <span class="btn-bubble-button">
						                    <img class="btn-bubble-std" src="/etc/designs/tourismaustralia/clientlibs/img/icons/favourite_outline.png" alt=""/>
						                    <img class="btn-bubble-active" src="/etc/designs/tourismaustralia/clientlibs/img/icons/favourite.png" alt=""/>
						                </span>
						            </a>
						
						        </div>
						    </div>
						</div>
				    </div>
				
				</div>
            </div>
        </div>

        <div class="col-xs-12 col-sm-4">
            <div class="row mosaic-3column-item-option">
                <div class="row mosaic-3column-container">
				    <div class="row mosaic-3column-container">
				        <div class="col-xs-6">
				            <div>
				                <div class="mosaic-media">
				                    <img src="/etc/designs/tourismaustralia/clientlibs/img/mosaic/img11.jpg" alt=""/>
				                </div>
				            </div>
				        </div>
				
				        <div class="col-xs-6 mosaic-3column-front-back-container flip-container">
				
				            <div class="mosaic-3column-front flip-front-fade">
				                <div class="mosaic-3column-media theme-mosaic-3column-front l-padding-t-15">
				                    <img src="/etc/designs/tourismaustralia/clientlibs/img/logo/logo_tqual_black.png" alt=""/>
				                    <p>front</p>
				                </div>
				            </div>
				
				            <div class="mosaic-3column-back flip-back-fade">
				                <div class="mosaic-3column-media theme-mosaic-3column-back l-padding-t-15">
				                    <img src="/etc/designs/tourismaustralia/clientlibs/img/logo/logo_tqual_white.png" alt=""/>
				                    <p>back</p>
				                </div>
				            </div>
				
				        </div>
				
				    </div>
				
				    <div class="row mosaic-3column-item-content">
						<div class="mosaic-item-detail-container">
						    <div class="mosaic-item-container">
						
						        <div class="l-h-center type-spacing-20">
						            <img src="/etc/designs/tourismaustralia/clientlibs/img/icons/art_culture.png">
						        </div>
						
						        <div class="line-through-container">
								    <div class="line-through"><span class="line-through-hr"></span></div>
								    <div class="line-through-container-biline">
										Virgin Australia Fashion Festival
								    </div>
								    <div class="line-through"><span class="line-through-hr"></span></div>
								</div>
						
						        <div class="l-h-center l-padding-tb-30-lr-15">
						
						            <p>You'll love the blue-hazed beauty of the Blue Mountains World Heritage Area - one million hectares of tall forests, sandstone cliffs, canyons, waterfalls and bushland. Take in the breathtaking panoramas...</p>
						
						            <a href="#" class="btn-bubble bubble-colour-favourite">
						                <span class="btn-bubble-tooltip">
						                    <span class="btn-bubble-tooltip-container">
						                        Add to your dream trip
						                    </span>
						                </span>
						                <span class="btn-bubble-button">
						                    <img class="btn-bubble-std" src="/etc/designs/tourismaustralia/clientlibs/img/icons/favourite_outline.png" alt=""/>
						                    <img class="btn-bubble-active" src="/etc/designs/tourismaustralia/clientlibs/img/icons/favourite.png" alt=""/>
						                </span>
						            </a>
						
						        </div>
						    </div>
						</div>
				    </div>
				
				</div>
            </div>
        </div>
    </div>

</div>

    <div class="l-h-center">
        <a href="#" class="btn-primary">View all accommodation</a>
    </div>


</div>
</div>

<%-- Category Links --%>
<cq:include path="categorizedIconLinks" resourceType="tourismaustralia/components/content/categorizedIconLinks"/>

<%-- FOOTER --%>
<div class="footer-container">
    <div class="footer">

        <div class="row footer-logo">
            <img class="type-spacing-30" src="/etc/designs/tourismaustralia/clientlibs/img/logo/logo_australia_com_whitetext.png">
        </div>

        <div class="row l-padding-lr-10">
            <div class="col-xs-12 col-sm-4 1col-sm-3 1col-md-3 1col-lg-3 1l-footer-align">
				<div class="footer-col">
				    <p class="footer-heading">Change your country and language</p>
				    <ul class="footer-text-list l-list-clean">
				        <li><a href="#">United States of America</a></li>
				        <li><a href="#">International English</a></li>
				    </ul>
				</div>
            </div>
            <div class="col-xs-12 col-sm-4 1col-sm-4 1col-md-3 1col-lg-3 1l-footer-align">
				<div class="footer-col">
				    <p class="footer-heading">Find us on</p>
				    <ul class="footer-social-list type-spacing-15">
				        <li><a href="https://www.facebook.com/seeaustralia" class="btn-share"><span><img src="/etc/designs/tourismaustralia/clientlibs/img/icons/footer/footer-fb-icon.png" alt=""/>Facebook</span></a></li>
				        <li><a href="https://plus.google.com/+australia/posts" class="btn-share"><span><img src="/etc/designs/tourismaustralia/clientlibs/img/icons/footer/footer-gplus-icon.png" alt=""/>Google +</span></a></li>
				        <li><a href="http://instagram.com/australia" class="btn-share"><span><img src="/etc/designs/tourismaustralia/clientlibs/img/icons/footer/footer-instagram-icon.png" alt=""/>Instagram</span></a></li>
				        <li><a href="https://twitter.com/australia" class="btn-share"><span><img src="/etc/designs/tourismaustralia/clientlibs/img/icons/footer/footer-twitter-icon.png" alt=""/>Twitter</span></a></li>
				        <li><a href="https://www.youtube.com/user/australia" class="btn-share"><span><img src="/etc/designs/tourismaustralia/clientlibs/img/icons/footer/footer-yt-icon.png" alt=""/>Youtube</span></a></li>
				    </ul>
				</div>
            </div>
            <div class="col-xs-12 col-sm-4 1col-sm-3 1col-md-3 1col-lg-3 1l-footer-align">
                <div class="col-xs-6">
                    <div class="footer-col">
					    <p class="footer-heading">About this site</p>
					    <ul class="footer-text-list footer-type-light l-list-clean">
					        <li><a href="#">Sitemap</a></li>
					        <li><a href="http://www.australia.com/privacypolicy.aspx">Privacy policy</a></li>
					        <li><a href="http://www.australia.com/terms-conditions.aspx">Terms & conditions</a></li>
					        <li><a href="#">Special offers disclaimer</a></li>
					        <li><a href="#">Feedback</a></li>
					    </ul>
					</div>
                </div>
                <div class="col-xs-6">
                    <div class="footer-col">
					    <p class="footer-heading">Other Sites</p>
					    <ul class="footer-text-list l-list-clean">
					        <li><a href="#">Media & industry</a></li>
					        <li><a href="#">Business events</a></li>
					    </ul>
					    <div class="footer-copyright">� Tourism Australia 2014</div>
					</div>
                </div>
            </div>
        </div>

    </div>
</div>


