<%@include file="/apps/tourismaustralia/components/global.jsp"%>

<div class="site-wrapper l-overflow-x-hidden">

    
<div class="no-js-message">Site Requires Javascript - turn on javascript!<br></div>

    <header id="main-header">
        
<div id="nav-main-header" class="header bar-fixed-top">

    

    <div class="accessibility-links">
        <a tabindex="1" class="sr-only vis-focusable" href="#main-content">Skip to content</a>
        <a tabindex="2" class="sr-only vis-focusable" href="#main-footer">Skip to footer navigation</a>
    </div>

        

        
        <div class="nav-bar navigation-bar">
            <div class="row l-center-1200">

                
                <div class="header-masthead">
                    <a class="nav-bar-toggle" href="#nav-main-header">
                        <span class="sr-only">Open Navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </a>

                    <a class="logo-masthead" href="#" tabindex="-1">
                        <img src="/etc/designs/tourismaustralia/clientlibs/img/logo/logo_australia_com.png" alt=""/>
                    </a>
                </div>
                

                <div class="main-nav-panel">
                    
                    <ul class="nav-bar-nav nav-bar-right">
                        <li class="toggle-home vis-hidden-sm">
                            <a href="#" tabindex="-1"><span class="icon icon-32 icon-home" aria-hidden="true"></span><span> Home</span></a>
                        </li>
                        <li id="nav-search-panel" class="toggle-search has-children">
                            <a href="#nav-search-panel"><span class="icon icon-32 icon-search" aria-hidden="true"></span><span class="vis-hidden-sm"> Search</span></a>
                            <ul class="nav-bar-panel">
                                <li class="nav-bar-panel-content">
                                    Mega menu content for "Search"
                                </li>
                            </ul>
                        </li>
                        <li id="nav-map-panel" class="toggle-map has-children">
                            <a href="#nav-map-panel"><span class="icon icon-32 icon-map" aria-hidden="true"></span><span class="vis-hidden-sm"> Map</span></a>
                            <ul class="nav-bar-panel">
                                <li class="nav-bar-panel-content">
                                    Mega menu content for "Map"
                                </li>
                            </ul>
                        </li>
                        <li class="toggle-my-trip">
                            <a href="#" tabindex="-1">
                                <span class="icon icon-32 icon-heart circle" aria-hidden="true"></span>
                                <span class="vis-hidden-sm">My Trip</span>
                                    <span class="my-trip-count">
                                        <span class="type-plus" aria-hidden="true"> +</span> 30
                                    </span>
                            </a>
                        </li>
                    </ul>
                    

                    
                    <ul class="nav-bar-nav nav-bar-left">
                        <li id="nav-things-to-do-panel" class="has-children">
                            <a href="#nav-things-to-do-panel">Things to do</a>
                            <ul class="nav-bar-panel">
                                <li class="nav-bar-panel-content">
                                    Mega menu content for "Thing to do"
                                </li>
                            </ul>
                        </li>
                        <li id="nav-where-to-go-panel" class="has-children">
                            <a href="#nav-where-to-go-panel">Where to go</a>
                            <ul class="nav-bar-panel">
                                <li class="nav-bar-panel-content">
                                    Mega menu content for "Where to go"
                                </li>
                            </ul>
                        </li>
                        <li id="nav-plan-your-trip-panel" class="has-children">
                            <a href="#nav-plan-your-trip-panel">Plan your trip</a>
                            <ul class="nav-bar-panel">
                                <li class="nav-bar-panel-content">
                                    Mega menu content for "Plan your trip"
                                </li>
                            </ul>
                        </li>
                    </ul>
                    

                    
                    <ul class="tool-bar mobile-open-bar bar-fixed-top">
                        <li class="is-current"><a href="#">Holiday</a></li>
                        <li><a href="#">Business</a></li>
                        <li class="nav-bar-toggle"><a href="#"><span class="icon icon-close icon-32" aria-hidden="true"></span> <span class="sr-only">Close Navigation</span></a></li>
                    </ul>
                    

                </div>
            </div>
        </div>
    </div>
</div>

    </header>
    <!-- End #main-header -->

    <div id="main-content">

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
                    <div class="map-main">
                        <img class="map-main-image" src="/etc/designs/tourismaustralia/clientlibs/img/placeholders/intro-map-australia-nsw.png" alt="Map">
                        <div class="map-main-link">
                            <div class="map-main-title">Capital of New South Wales</div>
                            <img src="/etc/designs/tourismaustralia/clientlibs/img/icons/pin_sml.png" class="map-pin"><span class="map-pin-btn">Sydney</span>
                        </div>
                    </div>
                </div>
                <div class="col-xs-12 col-sm-12 col-md-6 col-md-pull-6">
                    <div class="row">
                        <div class="type-summary"> <%-- TEXT COMPONENT --%>
							<p>Discover Sydney, Australia's famous harbour city and the capital of New South Wales.</p>
							<p>Plan your Sydney holiday using our three-day itinerary, which takes in the attractions around Sydney Harbour, beaches and inner-city precincts. Read up on the World Heritage-listed Blue Mountains and the Six Foot Track bushwalk.</p>
                        </div>
                    </div>
                    <hr class="full">
                    <div class="row">
                        <div class="type-body"> <%-- TEXT COMPONENT --%>
							<p>Learn about other places to visit in New South Wales and scenic journeys you can take from Sydney. Drive the Pacific Coast Touring Route north to Brisbane past the Hunter Valley, Port Stephens and bohemian Byron Bay. Or head south to Melbourne via the pure white beaches of Jervis Bay.</p>
							<p>Check out Australia's other cities and get ideas for the rest of your Australian holiday. Melbourne, the Great Ocean Road and Australia's Red Centre are all possible in a three-week holiday from Sydney.</p>
							<p>For more Sydney holiday ideas, read our articles on the Hunter Valley, Sydney's sparkling beaches, the Bondi to Bronte walk and the annual Sydney to Hobart yacht race.</p>
                        </div>
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
	<cq:include path="AtdwHighlights" resourceType="tourismaustralia/components/content/atdwHighlights"/>
</div>

<%-- Category Links --%>
<div class="l-padding-between-item-fill-white">
    <div class="categorylinks">
    <div class="row l-center-1200">
        <hr>
        <div class="col-xs-12 col-sm-4">
            <div class="categorylinks-item">
                <div class="categorylink-header">
                    <h3 class="categorylink-title">Getting here,<br />getting around</h3>
                </div>
                <div class="categorylink-body">
                    <p>Copy to include transport and local airport options. Lorem ipsum dolor sit amet.</p>
                </div>
                <div class="categorylink-links">
                    <a herf="#">
                        <span class="categorylink-arrive-by-air-icon icon-font-ArrivingByAir_Icon"></span>
                        <span class="categorylink-linktext">See airlines that fly to this destination</span>
                    </a>
                    <br />
                    <a herf="#">
                        <img src="/etc/designs/tourismaustralia/clientlibs/img/placeholders/footer_promo_transport_nsw.jpg" alt="Transport" />
                        <span class="categorylink-linktext">www.nswtrainlink.info</span>
                    </a>
                </div>
            </div>
        </div>

        <div class="col-xs-12 col-sm-4">
            <div class="categorylinks-item">
                <div class="categorylink-header">
                    <h3 class="categorylink-title">find your nearest<br />travel specialist</h3>
                </div>
                <div class="categorylink-body">
                    <p>Copy to include how to find a travel specailist Lorem ipsum dolor sit amet.</p>
                </div>
                <div class="categorylink-links">
                    <a herf="#">
                        <img src="/etc/designs/tourismaustralia/clientlibs/img/placeholders/footer_promo_aussiespecialist.jpg" alt="Aussie Specialist" />
                        <span class="categorylink-linktext">Find a travel specialist</span>
                    </a>
                </div>
            </div>
        </div>

        <div class="col-xs-12 col-sm-4">
            <div class="categorylinks-item">
                <div class="categorylink-header">
                    <h3 class="categorylink-title">Visit new south wales<br />tourism site</h3>
                </div>
                <div class="categorylink-body">
                    <p>Visit <a href="http://visitnsw.com">visitnsw.com</a> for more information on destinations and things to do!</p>
                </div>
                <div class="categorylink-links">
                    <a herf="#">
                        <img src="/etc/designs/tourismaustralia/clientlibs/img/placeholders/footer-promo-visit-nsw.jpg" alt="visitnsw.com" />
                        <span class="categorylink-linktext">Go to visitnsw.com</span>
                    </a>
                </div>
            </div>
        </div>

    </div>
</div>
</div>

</div>


<%-- FOOTER --%>
<footer id="main-footer" class="site-footer">
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
					    <div class="footer-copyright">© Tourism Australia 2014</div>
					</div>
                </div>
            </div>
        </div>

    </div>
</div>
</footer>
<!-- End #main-footer -->

<script type="text/javascript" src="etc/designs/tourismaustralia/clientlibs/js/vendor/owl-carousel/owl.carousel.js"></script>
<script src="etc/designs/tourismaustralia/clientlibs/js/src/modules/jquery.ta.carousel.js"></script>
<script src="etc/designs/tourismaustralia/clientlibs/js/vendor/skrollr.js"></script>
<script src="etc/designs/tourismaustralia/clientlibs/js/vendor/responsive-images/jquery.picturefill.js"></script>
<script src="etc/designs/tourismaustralia/clientlibs/js/vendor/responsive-images/mediamatch.js"></script>
<script src="etc/designs/tourismaustralia/clientlibs/js/src/modules/jquery.ta.flipcard.js"></script>
<script src="etc/designs/tourismaustralia/clientlibs/js/src/modules/jquery.ta.mosaic.js"></script>
<script src="etc/designs/tourismaustralia/clientlibs/js/src/modules/jquery.ta.fullwidthbg.js"></script>
<script src="etc/designs/tourismaustralia/clientlibs/js/src/modules/jquery.ta.parallax.js"></script>
<script src="etc/designs/tourismaustralia/clientlibs/js/src/helper/responsive.image.helper.js"></script>

<script>
    //Hack for mobile detection
    function checkPlatform() {
        return (/Android|iPhone|iPad|iPod|BlackBerry/i).test(navigator.userAgent || navigator.vendor || window.opera);
    }
    
    $(window).load(function(){
    	if(!checkPlatform()) {
    		var s = skrollr.init();
    	 }
    });
</script>


