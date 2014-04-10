<%@include file="/apps/tourismaustralia/components/global.jsp" %>


<body>
	<cq:include path="clientcontext" resourceType="cq/personalization/components/clientcontext"/>
	<cq:include script="customProperties.jsp"/>
	
	<div class="site-wrapper l-overflow-x-hidden">

    
<div class="no-js-message">Site Requires Javascript - turn on javascript!<br></div>

    <header id="main-header">
        
<div id="nav-main-header" class="header megamenu">



    <div class="accessibility-links">
        <a tabindex="1" class="sr-only vis-focusable" href="#main-content">Skip to content</a>
        <a tabindex="2" class="sr-only vis-focusable" href="#main-footer">Skip to footer navigation</a>
    </div>

    

<div id="main-notice-bar" class="notice-bar bar-scroll-top">
    <div class="row l-center-1200">
        <p class="notice-text notice-title">News alert</p>
        <p class="notice-text notice-summary">Lorem ipsum dolor sit amet consecuter. Ut enim ad minim. <a href="#">View the announcement</a></p>
        <a href="#nav-bar-top" class="notice-close"><span class="icon icon-16 icon-close" aria-hidden="true"></span></a>
    </div>
</div>

    
    <div class="nav-bar arrival-bar bar-scroll-top">
        <div class="row l-center-1200">
            <ul class="nav-bar-nav nav-bar-right">
                <li class="header-byline">
                    <span class="l-nowrap">The official Australian tourism website.</span>
                    <span class="l-nowrap">The site uses cookies. <a href="#">Find out more</a>.</span>
                </li>
            </ul>
            <ul class="nav-bar-nav nav-bar-left">
                <li class="is-current"><a href="#">Holiday in Australia</a></li>
                <li><a href="#">Plan a Business Event</a></li>
            </ul>
        </div>
    </div>

    
    <div id="nav-bar-top" class="nav-bar navigation-bar bar-fixed-scroll">
        <div class="row l-center-1200">

            
            <div class="header-masthead">
                <a class="nav-bar-toggle nav-toggle-open" href="#nav-main-header">
                    <span class="sr-only">Open Navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </a>

                <a class="logo-masthead" href="#" tabindex="-1">
                    <img src="imgs/logo/logo_australia_com.png" alt=""/>
                </a>
            </div>
            

            <div class="main-nav-panel">
                
                <ul class="nav-bar-nav nav-bar-right">
                    <li class="toggle-home vis-hidden-sm">
                        <a href="#" tabindex="-1"><span class="icon icon-32 icon-home" aria-hidden="true"></span><span> Home</span></a>
                    </li>
                    <li id="nav-search-panel" class="toggle-search has-children">
                        <a class="nav-toggle-panel" href="#nav-search-panel"><span class="icon icon-32 icon-search" aria-hidden="true"></span><span class="vis-hidden-sm"> Search</span></a>
                        <ul class="nav-bar-panel">
                            <li class="nav-bar-panel-container">
                                <div class="nav-bar-panel-content">
                                    <form class="nav-search-form" method="" action="#">
                                        <fieldset class="nav-search-fieldset">
                                            <label class="nav-search-label" for="nav-search-field">What would you like to explore in Australia?</label>
                                            <input class="nav-search-text" id="nav-search-field" type="text" name="" value="" placeholder="What would you like to explore in Australia?"/>
                                            <button class="biutton nav-search-button" type="submit" name="submit" value="submit">
                                                <span class="icon icon-32 icon-search" aria-hidden="true"></span><span class="vis-hidden-sm"> Search</span>
                                            </button>
                                        </fieldset>
                                    </form>

                                    <a tabindex="-1" class="nav-bar-panel-close" href="#nav-bar-top"><span class="icon icon-16 icon-close" aria-hidden="true"></span></a>
                                </div>
                            </li>
                        </ul>
                    </li>
                    <li id="nav-map-panel" class="toggle-map has-children">
                        <a class="nav-toggle-panel" href="#nav-map-panel"><span class="icon icon-32 icon-map" aria-hidden="true"></span><span class="vis-hidden-sm"> Map</span></a>
                        <ul class="nav-bar-panel">
                            <li class="nav-bar-panel-container">
                                <a class="sr-only vis-focusable" href="#nav-things-to-do-panel">Skip to "Things to do"</a>

                                <div class="nav-bar-panel-content">
                                    <p>Mega menu content for "Map" (is this even a mega menu?)</p>
                                    <ul class="nav-bar-panel-nav">
                                        <li><a href="#">Link Text</a></li>
                                        <li><a href="#">Link Text</a></li>
                                        <li><a href="#">Link Text</a></li>
                                    </ul>

                                    <a tabindex="-1" class="nav-bar-panel-close" href="#nav-bar-top"><span class="icon icon-16 icon-close" aria-hidden="true"></span></a>
                                </div>
                            </li>
                        </ul>
                    </li>
                    <li class="toggle-my-trip" class="toggle-my-trip">
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
                        <a class="nav-toggle-panel" href="#nav-things-to-do-panel">Things to do <span class="icon icon-16 icon-arrow-down" aria-hidden="true"></span></a>
                        <ul class="nav-bar-panel">
                            <li class="nav-bar-panel-container">
                                <a class="sr-only vis-focusable" href="#nav-where-to-go-panel">Skip to "Where to go"</a>

                                <div class="nav-bar-panel-content">
                                    <ul class="nav-bar-panel-nav">
                                        <li><a href="#">Link Text</a></li>
                                        <li><a href="#">Link Text</a></li>
                                        <li><a href="#">Link Text</a></li>
                                        <li><a href="#">Link Text</a></li>
                                        <li><a href="#">Link Text</a></li>
                                        <li><a href="#">Link Text</a></li>
                                    </ul>

                                    <a tabindex="-1" class="nav-bar-panel-close" href="#nav-bar-top"><span class="icon icon-16 icon-close" aria-hidden="true"></span></a>
                                </div>
                            </li>
                        </ul>
                    </li>
                    <li id="nav-where-to-go-panel" class="has-children">
                        <a class="nav-toggle-panel" href="#nav-where-to-go-panel">Where to go <span class="icon icon-16 icon-arrow-down" aria-hidden="true"></span></a>
                        <ul class="nav-bar-panel">
                            <li class="nav-bar-panel-container">
                                <a class="sr-only vis-focusable" href="#nav-plan-your-trip-panel">Skip to "Plan your trip"</a>

                                <div class="nav-bar-panel-content">
                                    <ul class="nav-bar-panel-nav">
                                        <li><a href="#">Link Text</a></li>
                                        <li><a href="#">Link Text</a></li>
                                        <li><a href="#">Link Text</a></li>
                                        <li><a href="#">Link Text</a></li>
                                    </ul>

                                    <a tabindex="-1" class="nav-bar-panel-close" href="#nav-bar-top"><span class="icon icon-16 icon-close" aria-hidden="true"></span></a>
                                </div>
                            </li>
                        </ul>
                    </li>
                    <li id="nav-plan-your-trip-panel" class="has-children">
                        <a class="nav-toggle-panel" href="#nav-plan-your-trip-panel">Plan your trip <span class="icon icon-16 icon-arrow-down" aria-hidden="true"></span></a>
                        <ul class="nav-bar-panel">
                            <li class="nav-bar-panel-container">
                                <a class="sr-only vis-focusable" href="#main-content">Skip to content</a>

                                <div class="nav-bar-panel-content">
                                    <ul class="nav-bar-panel-nav">
                                        <li><a href="#">Link Text</a></li>
                                        <li><a href="#">Link Text</a></li>
                                        <li><a href="#">Link Text</a></li>
                                        <li><a href="#">Link Text</a></li>
                                        <li><a href="#">Link Text</a></li>
                                        <li><a href="#">Link Text</a></li>
                                        <li><a href="#">Link Text</a></li>
                                        <li><a href="#">Link Text</a></li>
                                        <li><a href="#">Link Text</a></li>
                                        <li><a href="#">Link Text</a></li>
                                        <li><a href="#">Link Text</a></li>
                                        <li><a href="#">Link Text</a></li>
                                    </ul>

                                    <a tabindex="-1" class="nav-bar-panel-close" href="#nav-bar-top"><span class="icon icon-16 icon-close" aria-hidden="true"></span></a>
                                </div>
                            </li>
                        </ul>
                    </li>
                </ul>
                

                
                <div class="mobile-open-bar bar-fixed-scroll">
                    <ul class="tool-bar">
                        <li class="is-current"><a href="#">Holiday</a></li>
                        <li><a href="#">Business</a></li>
                        <li class="nav-bar-toggle">
                            <a class="nav-toggle-close" href="#nav-bar-top"><span class="icon icon-close icon-32" aria-hidden="true"></span>
                                <span class="sr-only">Close Navigation</span></a></li>
                    </ul>
                </div>
                

            </div>
        </div>
    </div>
</div>

    </header>
	
	<cq:include script="content.jsp"/>
	
	
	
	<footer id="main-footer" class="site-footer">
    
<div class="footer-container">
    <div class="footer">

        <div class="row footer-logo">
            

<img id="logo" src="/etc/designs/tourismaustralia/clientlibs/img/logo/logo_australia_com_whitetext.png" alt="" />
        </div>

        <div class="row l-padding-lr-10">
            <div class="col-xs-12 col-sm-6 col-md-4 1col-sm-3">
                

<div class="footer-col">
    <p class="footer-heading">Change your country and language</p>

    <div class="row">
        <div class="col-xs-12 type-spacing-20">
            
                

<div class="dropdown-select-countrylanguage">
    <div class="dropdown-select-countrylanguage-style">
        <select>
            
                
                    <option>United States of America</option>
                
                    <option>Australia</option>
                
            
        </select>
    </div>
</div>

            
        </div>

        <div class="col-xs-12">
            
                

<div class="dropdown-select-countrylanguage">
    <div class="dropdown-select-countrylanguage-style">
        <select>
            
                
                    <option>International English</option>
                
                    <option>German</option>
                
            
        </select>
    </div>
</div>

            
        </div>
    </div>

</div>

            </div>
            <div class="col-xs-12 col-sm-6 col-md-4 1col-sm-4">
                

<div class="footer-col">
    <p class="footer-heading">Find us on</p>
    <ul class="footer-social-list">
        <li><a href="https://www.facebook.com/seeaustralia" class="btn-share"><span><img src="/etc/designs/tourismaustralia/clientlibs/img/icons/footer/footer-fb-icon.png" alt=""/>Facebook</span></a></li>
        <li><a href="https://plus.google.com/+australia/posts" class="btn-share"><span><img src="/etc/designs/tourismaustralia/clientlibs/img/icons/footer/footer-gplus-icon.png" alt=""/>Google +</span></a></li>
        <li><a href="http://instagram.com/australia" class="btn-share"><span><img src="/etc/designs/tourismaustralia/clientlibs/img/icons/footer/footer-instagram-icon.png" alt=""/>Instagram</span></a></li>
        <li><a href="https://twitter.com/australia" class="btn-share"><span><img src="/etc/designs/tourismaustralia/clientlibs/img/icons/footer/footer-twitter-icon.png" alt=""/>Twitter</span></a></li>
        <li><a href="https://www.youtube.com/user/australia" class="btn-share"><span><img src="/etc/designs/tourismaustralia/clientlibs/img/icons/footer/footer-yt-icon.png" alt=""/>Youtube</span></a></li>
    </ul>
</div>

            </div>
            <div class="col-xs-12 col-sm-12 col-md-4 l-clear-padding l-push-up-xs--1">
                <div class="col-xs-12 col-sm-6">
                    

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
                <div class="col-xs-12 col-sm-6">
                    

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
</body>