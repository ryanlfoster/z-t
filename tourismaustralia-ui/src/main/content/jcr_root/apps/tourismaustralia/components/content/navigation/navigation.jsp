<%@include file="/apps/tourismaustralia/components/global.jsp" %>
<%@ page import="com.australia.www.components.content.navigation.Navigation" %>

<c:set var="navigation" value="<%=new Navigation(slingRequest) %>"/>

<%-- START: Navigation - arrival bar --%>
<div class="nav-bar arrival-bar bar-scroll-top">
    <div class="row l-center-1200">
        <ul class="nav-bar-nav nav-bar-right">
            <li class="header-byline">
                <span class="l-nowrap"><fmt:message key="The official Australian tourism website."/></span>
                <span class="l-nowrap"><fmt:message key="The site uses cookies."/><c:if test="${not empty navigation.findOutMoreLink}"> <a href="${navigation.findOutMoreLink}" target="${link.findOutMoreLinkIsExternal ? '_blank' : '_self'}"><fmt:message key="Find out more"/></a>.</c:if></span>
            </li>
        </ul>
        <ul class="nav-bar-nav nav-bar-left">
            <c:if test="${not empty navigation.arrivalBarLink1Text && not empty navigation.arrivalBarLink1}">
            <li class="is-current">
                <a href="${navigation.arrivalBarLink1}" target="${navigation.arrivalBarLink1IsExternal ? '_blank' : '_self'}">${navigation.arrivalBarLink1Text}</a>
            </li>
            </c:if>
            <c:if test="${not empty navigation.arrivalBarLink2Text && not empty navigation.arrivalBarLink2}">
            <li><a href="${navigation.arrivalBarLink2}" target="${navigation.arrivalBarLink2IsExternal ? '_blank' : '_self'}">${navigation.arrivalBarLink2Text}</a></li>
            </c:if>
        </ul>
    </div>
</div>

<%-- END: Navigation - arrival bar --%>

<%-- START: Navigation - navigation bar --%>
<div id="nav-bar-top-clone" class="nav-bar navigation-bar is-bar-cloned" style="height: 91px; display: none;"></div>
<div id="nav-bar-top" class="nav-bar navigation-bar bar-fixed-scroll">
    <div class="row l-center-1200">
        <div class="header-masthead">
            <a class="nav-bar-toggle nav-toggle-open" href="#nav-main-header">
                <span class="sr-only"><fmt:message key="Open Navigation"/></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </a>

            <a class="logo-masthead" href="#" tabindex="-1">
                <img src="/etc/designs/tourismaustralia/clientlibs/imgs/logo/logo_australia_com.png" alt="">
            </a>
        </div>
        <div class="main-nav-panel">
            <ul class="nav-bar-nav nav-bar-right">
                <li class="toggle-home vis-hidden-sm">
                    <a href="#" tabindex="-1"><span class="icon icon-32 icon-home" aria-hidden="true"></span><span> <fmt:message key="Home"/></span></a>
                </li>
                <li id="nav-main-panel-search" class="toggle-search has-children">
                    <a class="nav-toggle-panel" href="#nav-main-panel-search"><span class="icon icon-32 icon-search" aria-hidden="true"></span><span class="vis-hidden-sm"> <fmt:message key="Search"/></span></a>
                    <ul class="nav-bar-panel">
                        <li class="nav-bar-panel-container">
                            <div class="nav-bar-panel-content">
                                <form class="nav-search-form" method="" action="#">
                                    <fieldset class="nav-search-fieldset">
                                        <label class="nav-search-label" for="nav-search-field">What would you like to explore in Australia?</label>
                                        <input class="nav-search-text" id="nav-search-field" type="text" name="" value="" placeholder="What would you like to explore in Australia?">
                                        <button class="biutton nav-search-button" type="submit" name="submit" value="submit">
                                            <span class="icon icon-32 icon-search" aria-hidden="true"></span><span class="vis-hidden"> Search</span>
                                        </button>
                                    </fieldset>
                                </form>

                                <a tabindex="-1" class="nav-bar-panel-close" href="#nav-bar-top"><span class="icon icon-16 icon-close" aria-hidden="true"></span></a>
                            </div>
                        </li>
                    </ul>
                </li>
                <c:if test="${not empty navigation.mapLink}">
                <li class="link-map">
                    <a href="${navigation.mapLink}" target="${navigation.mapLinkIsExternal ? '_blank' : '_self'}" class="nav-toggle-none"><span class="icon icon-32 icon-map" aria-hidden="true"></span><span class="vis-hidden-sm"> <fmt:message key="Map"/></span></a>
                </li>
                </c:if>
                <c:if test="${not empty navigation.myTripLink}">
                <li id="nav-heart-this-widget" class="link-my-trip items-added">
                    <a class="nav-toggle-none" href="${navigation.myTripLink}" target="${navigation.myTripLinkIsExternal ? '_blank' : '_self'}" tabindex="-1">
                        <span class="icon icon-32 icon-heart" aria-hidden="true"></span>
                        <span class="vis-hidden-sm"><fmt:message key="My Trip"/></span>
                        <span class="my-trip-count">26</span>
                    </a>
                </li>
                </c:if>
            </ul>
            <c:if test="${not empty navigation.megamenu1Title || not empty navigation.megamenu2Title || not empty navigation.megamenu3Title}">
            <ul class="nav-bar-nav nav-bar-left">
            <c:if test="${not empty navigation.megamenu1Title}">
                <li id="nav-main-panel-1" class="has-children">
                    <a class="nav-toggle-panel" href="#nav-main-panel-1">${navigation.megamenu1Title} <span class="icon icon-16 icon-arrow-down" aria-hidden="true"></span></a>
                    <ul class="nav-bar-panel">
                        <li class="nav-bar-panel-container">
                            <c:choose>
                                <c:when test="${not empty navigation.megamenu2Title}">
                                    <a class="sr-only vis-focusable" href="#nav-main-panel-2"><fmt:message key="Skip to"/> "${navigation.megamenu2Title}"</a>
                                </c:when>
                                <c:otherwise>
                                    <a class="sr-only vis-focusable" href="#main-content"><fmt:message key="Skip to content"/></a>
                                </c:otherwise>
                            </c:choose>
                            <div class="nav-bar-panel-content">
                                <div class="megamenu-panel megamenu-mosaic">
                                    <ul class="nav-bar-panel-nav l-hideondesktop">
                                        <%-- START // link --%>
                                        <li><a href="#">Link Text</a></li>
                                        <%-- END // link --%>
                                    </ul>
                                    <div class="megamenu-mosaic-left l-hideonmobile">
                                        <c:if test="${not empty navigation.megamenu1LhsCategoryTitle}">
                                        <h3 class="megamenu-mosaic-title">${navigation.megamenu1LhsCategoryTitle}</h3>
                                        </c:if>
                                        <%-- START // mosaic item --%>
                                        <div class="megamenu-mosaic-item">
                                            <div class="mosaic-item">
                                                <div class="mosaic-front-back-container flip-container outbound-link">
                                                    <div class="flipper">
                                                        <div class="mosaic-column-front flip-front">
                                                            <div class="mosaic-media mosaic-primary">
                                                                <img src="imgs/placeholders/meganav-img1.jpg" alt="">
                                                            </div>
                                                            <div class="mosaic-overlay">
                                                                <div class="vertical-container">
                                                                    <div class="vertical-content text-center">
                                                                        <span class="label-destination type-destination theme-nature">Nature &amp; Wildlife</span>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="mosaic-column-back mosaic-content flip-back mosaic-back theme-nature">
                                                            <div class="vertical-container">
                                                                <a href="#" class="mosaic-link vertical-content text-center">
                                                                    <span class="mosaic-icon">
                                                                        <img class="icon-generic" src="imgs/icons/beaches_white_outline.png" alt="">
                                                                    </span>
                                                                    <p class="type-destination line-through-line-wrapper">Nature &amp; Wildlife</p>
                                                                </a>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <%-- END //  mosaic item --%>
                                    </div>
                                    <div class="megamenu-mosaic-right l-hideonmobile">
                                        <c:if test="${not empty navigation.megamenu1RhsCategoryTitle}">
                                            <h3 class="megamenu-mosaic-title">${navigation.megamenu1RhsCategoryTitle}</h3>
                                        </c:if>
                                        <%-- START // mosaic item --%>
                                        <div class="megamenu-mosaic-item">
                                            <div class="mosaic-item">
                                                <div class="mosaic-front-back-container flip-container outbound-link">
                                                    <div class="flipper">
                                                        <div class="mosaic-column-front flip-front">
                                                            <div class="mosaic-media mosaic-primary">
                                                                <img src="imgs/placeholders/meganav-img10.jpg" alt="">
                                                            </div>
                                                            <div class="mosaic-overlay">
                                                                <div class="vertical-container">
                                                                    <div class="vertical-content text-center">
                                                                        <span class="label-destination type-destination theme-discover">Trip Ideas</span>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="mosaic-column-back mosaic-content flip-back mosaic-back theme-discover">
                                                            <div class="vertical-container">
                                                                <a href="#" class="mosaic-link vertical-content text-center">
                                                                                                <span class="mosaic-icon">
                                                                                                    <img class="icon-generic" src="imgs/icons/beaches_white_outline.png" alt="">
                                                                                                </span>
                                                                    <p class="type-destination line-through-line-wrapper">Trip Ideas</p>
                                                                </a>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <%-- END //  mosaic item --%>
                                    </div>
                                </div>
                                <a tabindex="-1" class="nav-bar-panel-close" href="#nav-bar-top"><span class="icon icon-16 icon-close" aria-hidden="true"></span></a>
                            </div>
                        </li>
                    </ul>
                </li>
            </c:if>
            <c:if test="${not empty navigation.megamenu2Title}">
                <li id="nav-main-panel-2" class="has-children">
                    <a class="nav-toggle-panel" href="#nav-main-panel-2">${navigation.megamenu2Title} <span class="icon icon-16 icon-arrow-down" aria-hidden="true"></span></a>
                    <ul class="nav-bar-panel">
                        <li class="nav-bar-panel-container">
                            <c:choose>
                                <c:when test="${not empty navigation.megamenu3Title}">
                                <a class="sr-only vis-focusable" href="#nav-main-panel-3"><fmt:message key="Skip to"/> "${navigation.megamenu3Title}"</a>
                                </c:when>
                                <c:otherwise>
                                <a class="sr-only vis-focusable" href="#main-content"><fmt:message key="Skip to content"/></a>
                                </c:otherwise>
                            </c:choose>
                            <div class="nav-bar-panel-content">
                                <div class="megamenu-panel megamenu-map">
                                    <ul class="nav-bar-panel-nav">
                                        <li class="megamenu-map-filters is-active">
                                            <div class="megamenu-components">
                                                <a class="megamenu-map-filter" href="#iconic">Iconic destinations</a>
                                                <ul class="megamenu-map-markers">
                                                    <%-- START // marker --%>
                                                    <li class="megamenu-map-marker map-marker-qld">
                                                        <a href="#"><span class="map-segment"></span>Great Barrier Reef</a>
                                                    </li>
                                                    <%-- END // marker --%>
                                                </ul>
                                            </div>
                                        </li>
                                        <li class="megamenu-map-filters">
                                            <div class="megamenu-components">
                                                <a class="megamenu-map-filter is-active" href="#cities">Cities</a>
                                                <ul class="megamenu-map-markers">
                                                    <%-- START // marker --%>
                                                    <li class="megamenu-map-marker map-marker-act">
                                                        <a href="#"><span class="map-segment"></span>Canberra</a>
                                                    </li>
                                                    <%-- END // marker --%>
                                                </ul>
                                            </div>
                                        </li>
                                        <li class="megamenu-map-filters">
                                            <div class="megamenu-components">
                                                <a class="megamenu-map-filter is-active" href="#states">States &amp; Territories</a>
                                                <ul class="megamenu-map-markers">
                                                    <%-- START // marker --%>
                                                    <li class="megamenu-map-marker map-marker-act">
                                                        <a href="#"><span class="map-segment"></span>Australian Capital Territory</a>
                                                    </li>
                                                    <%-- END // marker --%>
                                                </ul>
                                            </div>
                                        </li>
                                    </ul>
                                </div>
                                <a tabindex="-1" class="nav-bar-panel-close" href="#nav-bar-top"><span class="icon icon-16 icon-close" aria-hidden="true"></span></a>
                            </div>
                        </li>
                    </ul>
                </li>
            </c:if>
            <c:if test="${not empty navigation.megamenu3Title}">
                <li id="nav-main-panel-3" class="has-children">
                    <a class="nav-toggle-panel" href="#nav-main-panel-3">${navigation.megamenu3Title} <span class="icon icon-16 icon-arrow-down" aria-hidden="true"></span></a>
                    <ul class="nav-bar-panel">
                        <li class="nav-bar-panel-container">
                            <a class="sr-only vis-focusable" href="#main-content"><fmt:message key="Skip to content"/></a>
                            <div class="nav-bar-panel-content">
                                <div class="megamenu-panel megamenu-mosaic">
                                    <ul class="nav-bar-panel-nav l-hideondesktop">
                                        <%-- START // link --%>
                                        <li><a href="#">Link Text</a></li>
                                        <%-- END // link --%>
                                    </ul>
                                    <div class="megamenu-mosaic-left l-hideonmobile">
                                        <h3 class="megamenu-mosaic-title">Plan your holiday in Australia</h3>
                                        <%-- START // mosaic item --%>
                                        <div class="megamenu-mosaic-item">
                                            <div class="mosaic-item">
                                                <div class="mosaic-front-back-container flip-container outbound-link">
                                                    <div class="flipper">
                                                        <div class="mosaic-column-front flip-front">
                                                            <div class="mosaic-media mosaic-primary">
                                                                <img src="imgs/placeholders/meganav-img1.jpg" alt="">
                                                            </div>
                                                            <div class="mosaic-overlay">
                                                                <div class="vertical-container">
                                                                    <div class="vertical-content text-center">
                                                                        <span class="label-destination type-destination theme-discover">Find a travel agent</span>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>

                                                        <div class="mosaic-column-back mosaic-content flip-back mosaic-back theme-discover">
                                                            <div class="vertical-container">
                                                                <a href="#" class="mosaic-link vertical-content text-center">
                                                                                                <span class="mosaic-icon">
                                                                                                    <img class="icon-generic" src="imgs/icons/beaches_white_outline.png" alt="">
                                                                                                </span>
                                                                    <p class="type-destination line-through-line-wrapper">Find a travel agent</p>
                                                                </a>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <%-- END // mosaic item --%>
                                    </div>
                                    <div class="megamenu-mosaic-right l-hideonmobile">
                                        <h3 class="megamenu-mosaic-title">Holiday deals</h3>
                                        <div class="megamenu-mosaic-item">
                                            <div class="mosaic-item">
                                                <div class="mosaic-front-back-container flip-container outbound-link">
                                                    <div class="flipper">
                                                        <div class="mosaic-column-front flip-front">
                                                            <div class="mosaic-media mosaic-primary">
                                                                <img src="imgs/placeholders/meganav-img10.jpg" alt="">
                                                            </div>
                                                            <div class="mosaic-overlay">
                                                                <div class="vertical-container">
                                                                    <div class="vertical-content text-center">
                                                                        <span class="label-destination type-destination theme-discover">Special Offers</span>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="mosaic-column-back mosaic-content flip-back mosaic-back theme-discover">
                                                            <div class="vertical-container">
                                                                <a href="#" class="mosaic-link vertical-content text-center">
                                                                                                <span class="mosaic-icon">
                                                                                                    <img class="icon-generic" src="imgs/icons/beaches_white_outline.png" alt="">
                                                                                                </span>
                                                                    <p class="type-destination line-through-line-wrapper">Special Offers</p>
                                                                </a>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <a tabindex="-1" class="nav-bar-panel-close" href="#nav-bar-top"><span class="icon icon-16 icon-close" aria-hidden="true"></span></a>
                            </div>
                        </li>
                    </ul>
                </li>
            </c:if>
            </ul>
            </c:if>
            <div class="mobile-open-bar bar-fixed-scroll">
                <ul class="tool-bar">
                    <li class="is-current"><a href="#">Holiday</a></li>
                    <li><a href="#">Business</a></li>
                    <li class="nav-bar-toggle">
                        <a class="nav-toggle-close" href="#nav-bar-top">
                            <span class="icon icon-close icon-32" aria-hidden="true"></span>
                            <span class="sr-only">Close Navigation</span>
                        </a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>
<%-- END: Navigation - navigation bar --%>