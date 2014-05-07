<%@include file="/apps/tourismaustralia/components/global.jsp" %>
<%@ page import="com.australia.www.components.content.navigation.Navigation" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:set var="navigation" value="<%=new Navigation(slingRequest) %>"/>

<c:if test="${not empty navigation.megamenu1LhsMosaicThemeLinks}">
    <c:set var="numberOfMegamenu1LhsMosaicLinks" value="${fn:length(navigation.megamenu1LhsMosaicThemeLinks)}"/>
    <c:set var="numberOfMegamenu1LhsMosaicRows" value="${(numberOfMegamenu1LhsMosaicLinks) / 4}"/>
    <fmt:formatNumber
        var="numberOfMegamenu1LhsMosaicRowsCeil"
        value="${(numberOfMegamenu1LhsMosaicRows)+(1-((numberOfMegamenu1LhsMosaicRows)%1))%1}"
        type="number"
        maxFractionDigits="0"
        pattern="#"
    />
</c:if>

<c:if test="${not empty navigation.megamenu3LhsMosaicLinks}">
    <c:set var="numberOfMegamenu3LhsMosaicLinks" value="${fn:length(navigation.megamenu3LhsMosaicLinks)}"/>
    <c:set var="numberOfMegamenu3LhsMosaicRows" value="${(numberOfMegamenu3LhsMosaicLinks) / 4}"/>
    <fmt:formatNumber
            var="numberOfMegamenu3LhsMosaicRowsCeil"
            value="${(numberOfMegamenu3LhsMosaicRows)+(1-((numberOfMegamenu3LhsMosaicRows)%1))%1}"
            type="number"
            maxFractionDigits="0"
            pattern="#"
            />
</c:if>

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

            <a class="logo-masthead" href="${navigation.homepagePath}" tabindex="-1">
                <img src="/etc/designs/tourismaustralia/clientlibs/imgs/logo/logo_australia_com.png" alt="">
            </a>
        </div>
        <div class="main-nav-panel">
            <ul class="nav-bar-nav nav-bar-right">
                <li class="toggle-home vis-hidden-sm">
                    <a href="${navigation.homepagePath}" tabindex="-1"><span class="icon icon-32 icon-home" aria-hidden="true"></span><span> <fmt:message key="Home"/></span></a>
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
                    <a class="nav-toggle-none favourite-summary" href="${navigation.myTripLink}" target="${navigation.myTripLinkIsExternal ? '_blank' : '_self'}" tabindex="-1">
                        <span class="icon icon-32 icon-heart" aria-hidden="true"></span>
                        <span class="vis-hidden-sm"><fmt:message key="My Trip"/></span>
                        <span class="my-trip-count"></span>
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
                                   <c:if test="${not empty navigation.megamenu1LhsMosaicThemeLinks}">
                                    <ul class="nav-bar-panel-nav l-hideondesktop">
                                        <c:if test="${not empty navigation.megamenu1LhsMosaicThemeLinks}">
                                        <%-- START // link --%>
                                        <c:forEach items="${navigation.megamenu1LhsMosaicThemeLinks}" var="link">
                                        <li><a href="${link.pagePath}" target="${link.isExternal ? '_blank' : '_self'}">${link.linkText}</a></li>
                                        </c:forEach>
                                        <%-- END // link --%>
                                        </c:if>
                                        <c:if test="${not empty navigation.megamenu1RhsMosaicLinks}">
                                        <%-- START // link --%>
                                        <c:forEach items="${navigation.megamenu1RhsMosaicLinks}" var="link" varStatus="linkCount">
                                        <c:if test="${not empty numberOfMegamenu1LhsMosaicRowsCeil && (numberOfMegamenu1LhsMosaicRowsCeil >= linkCount.count)}">
                                            <li><a href="${link.pagePath}" target="${link.isExternal ? '_blank' : '_self'}">${link.linkText}</a></li>
                                        </c:if>
                                        </c:forEach>
                                        <%-- END // link --%>
                                        </c:if>
                                    </ul>
                                   </c:if>
                                    <div class="megamenu-mosaic-left l-hideonmobile">
                                        <c:if test="${not empty navigation.megamenu1LhsCategoryTitle}">
                                        <h3 class="megamenu-mosaic-title">${navigation.megamenu1LhsCategoryTitle}</h3>
                                        </c:if>
                                        <c:if test="${not empty navigation.megamenu1LhsMosaicThemeLinks}">
                                        <%-- START // mosaic item --%>
                                        <c:forEach items="${navigation.megamenu1LhsMosaicThemeLinks}" var="link">
                                        <div class="megamenu-mosaic-item">
                                            <div class="mosaic-item">
                                                <div class="mosaic-front-back-container flip-container outbound-link">
                                                    <div class="flipper">
                                                        <c:if test="${not empty link.image && not empty link.linkText}">
                                                        <div class="mosaic-column-front flip-front">
                                                            <c:if test="${not empty link.image}">
                                                            <div class="mosaic-media mosaic-primary">
                                                                <img src="${link.image}" alt="">
                                                            </div>
                                                            </c:if>
                                                            <c:if test="${not empty link.linkText && not empty link.theme}">
                                                            <div class="mosaic-overlay">
                                                                <div class="vertical-container">
                                                                    <div class="vertical-content text-center">
                                                                        <span class="label-destination type-destination theme-${link.theme}">${link.linkText}</span>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            </c:if>
                                                        </div>
                                                        </c:if>
                                                        <c:if test="${not empty link.pagePath && not empty link.iconImage && not empty link.linkText && not empty link.theme}">
                                                        <div class="mosaic-column-back mosaic-content flip-back mosaic-back theme-${link.theme}">
                                                            <div class="vertical-container">
                                                               <a href="${link.pagePath}" class="mosaic-link vertical-content text-center" target="${link.isExternal ? '_blank' : '_self'}">
                                                                    <c:if test="${not empty link.iconImage}">
                                                                    <span class="mosaic-icon">
                                                                        <img class="icon-generic" src="${link.iconImage}" alt="">
                                                                    </span>
                                                                    </c:if>
                                                                    <c:if test="${not empty link.linkText}">
                                                                    <p class="type-destination line-through-line-wrapper">${link.linkText}</p>
                                                                    </c:if>
                                                                </a>
                                                            </div>
                                                        </div>
                                                        </c:if>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        </c:forEach>
                                        <%-- END //  mosaic item --%>
                                        </c:if>
                                    </div>
                                    <div class="megamenu-mosaic-right l-hideonmobile">
                                        <c:if test="${not empty navigation.megamenu1RhsCategoryTitle}">
                                            <h3 class="megamenu-mosaic-title">${navigation.megamenu1RhsCategoryTitle}</h3>
                                        </c:if>
                                        <c:if test="${not empty navigation.megamenu1RhsMosaicLinks}">
                                        <c:forEach items="${navigation.megamenu1RhsMosaicLinks}" var="link" varStatus="linkCount">
                                        <c:if test="${not empty numberOfMegamenu1LhsMosaicRowsCeil && (numberOfMegamenu1LhsMosaicRowsCeil >= linkCount.count)}">
                                        <%-- START // mosaic item --%>
                                        <div class="megamenu-mosaic-item">
                                            <div class="mosaic-item">
                                                <div class="mosaic-front-back-container flip-container outbound-link">
                                                    <div class="flipper">
                                                        <c:if test="${not empty link.image && not empty link.linkText}">
                                                        <div class="mosaic-column-front flip-front">
                                                            <c:if test="${not empty link.image}">
                                                            <div class="mosaic-media mosaic-primary">
                                                                <img src="${link.image}" alt="" />
                                                            </div>
                                                            </c:if>
                                                            <c:if test="${not empty link.linkText}">
                                                            <div class="mosaic-overlay">
                                                                <div class="vertical-container">
                                                                    <div class="vertical-content text-center">
                                                                        <span class="label-destination type-destination theme-discover">${link.linkText}</span>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            </c:if>
                                                        </div>
                                                        </c:if>
                                                        <c:if test="${not empty link.pagePath && not empty link.iconImage && not empty link.linkText}">
                                                        <div class="mosaic-column-back mosaic-content flip-back mosaic-back theme-discover">
                                                            <div class="vertical-container">
                                                                <a href="${link.pagePath}" class="mosaic-link vertical-content text-center" target="${link.isExternal ? '_blank' : '_self'}">
                                                                    <c:if test="${not empty link.iconImage}">
                                                                    <span class="mosaic-icon">
                                                                        <img class="icon-generic" src="${link.iconImage}" alt="">
                                                                    </span>
                                                                    </c:if>
                                                                    <c:if test="${not empty link.linkText}">
                                                                    <p class="type-destination line-through-line-wrapper">${link.linkText}</p>
                                                                    </c:if>
                                                                </a>
                                                            </div>
                                                        </div>
                                                        </c:if>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <%-- END //  mosaic item --%>
                                        </c:if>
                                        </c:forEach>
                                        </c:if>
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
                                        <c:if test="${not empty navigation.megamenu2LhsCategoryTitle1 && not empty navigation.megamenu2LhsCategoryTitle1Links}">
                                        <li class="megamenu-map-filters is-active">
                                            <div class="megamenu-components">
                                                <a class="megamenu-map-filter" href="#iconic">${navigation.megamenu2LhsCategoryTitle1}</a>
                                                <ul class="megamenu-map-markers">
                                                    <c:forEach items="${navigation.megamenu2LhsCategoryTitle1Links}" var="link">
                                                    <%-- START // marker --%>
                                                    <li class="megamenu-map-marker map-marker-${link.state}">
                                                        <a href="${link.pagePath}" target="${link.isExternal ? '_blank' : '_self'}"><span class="map-segment"></span>${link.linkText}</a>
                                                    </li>
                                                    <%-- END // marker --%>
                                                    </c:forEach>
                                                </ul>
                                            </div>
                                        </li>
                                        </c:if>
                                        <c:if test="${not empty navigation.megamenu2LhsCategoryTitle2 && not empty navigation.megamenu2LhsCategoryTitle2Links}">
                                        <li class="megamenu-map-filters">
                                            <div class="megamenu-components">
                                                <a class="megamenu-map-filter is-active" href="#cities">${navigation.megamenu2LhsCategoryTitle2}</a>
                                                <ul class="megamenu-map-markers">
                                                    <c:forEach items="${navigation.megamenu2LhsCategoryTitle2Links}" var="link">
                                                        <%-- START // marker --%>
                                                        <li class="megamenu-map-marker map-marker-${link.state}">
                                                            <a href="${link.pagePath}" target="${link.isExternal ? '_blank' : '_self'}"><span class="map-segment"></span>${link.linkText}</a>
                                                        </li>
                                                        <%-- END // marker --%>
                                                    </c:forEach>
                                                </ul>
                                            </div>
                                        </li>
                                        </c:if>
                                        <c:if test="${not empty navigation.megamenu2LhsCategoryTitle3 && not empty navigation.megamenu2LhsCategoryTitle3Links}">
                                        <li class="megamenu-map-filters">
                                            <div class="megamenu-components">
                                                <a class="megamenu-map-filter is-active" href="#states">${navigation.megamenu2LhsCategoryTitle3}</a>
                                                <ul class="megamenu-map-markers">
                                                    <c:forEach items="${navigation.megamenu2LhsCategoryTitle3Links}" var="link">
                                                        <%-- START // marker --%>
                                                        <li class="megamenu-map-marker map-marker-${link.state}">
                                                            <a href="${link.pagePath}" target="${link.isExternal ? '_blank' : '_self'}"><span class="map-segment"></span>${link.linkText}</a>
                                                        </li>
                                                        <%-- END // marker --%>
                                                    </c:forEach>
                                                </ul>
                                            </div>
                                        </li>
                                        </c:if>
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
                                        <c:if test="${not empty navigation.megamenu3LhsMosaicLinks}">
                                            <%-- START // link --%>
                                            <c:forEach items="${navigation.megamenu3LhsMosaicLinks}" var="link">
                                                <li><a href="${link.pagePath}" target="${link.isExternal ? '_blank' : '_self'}">${link.linkText}</a></li>
                                            </c:forEach>
                                            <%-- END // link --%>
                                        </c:if>
                                        <c:if test="${not empty navigation.megamenu3RhsMosaicLinks}">
                                            <%-- START // link --%>
                                            <c:forEach items="${navigation.megamenu3RhsMosaicLinks}" var="link" varStatus="linkCount">
                                                <c:if test="${not empty numberOfMegamenu3LhsMosaicRowsCeil && (numberOfMegamenu3LhsMosaicRowsCeil >= linkCount.count)}">
                                                    <li><a href="${link.pagePath}" target="${link.isExternal ? '_blank' : '_self'}">${link.linkText}</a></li>
                                                </c:if>
                                            </c:forEach>
                                            <%-- END // link --%>
                                        </c:if>
                                    </ul>
                                    <div class="megamenu-mosaic-left l-hideonmobile">
                                        <c:if test="${not empty navigation.megamenu3LhsCategoryTitle}">
                                        <h3 class="megamenu-mosaic-title">${navigation.megamenu3LhsCategoryTitle}</h3>
                                        </c:if>
                                        <%-- START // mosaic item --%>
                                        <c:if test="${not empty navigation.megamenu3LhsMosaicLinks}">
                                            <c:forEach items="${navigation.megamenu3LhsMosaicLinks}" var="link">
                                                <%-- START // mosaic item --%>
                                                <div class="megamenu-mosaic-item">
                                                    <div class="mosaic-item">
                                                        <div class="mosaic-front-back-container flip-container outbound-link">
                                                            <div class="flipper">
                                                                <c:if test="${not empty link.image && not empty link.linkText}">
                                                                    <div class="mosaic-column-front flip-front">
                                                                        <c:if test="${not empty link.image}">
                                                                            <div class="mosaic-media mosaic-primary">
                                                                                <img src="${link.image}" alt="" />
                                                                            </div>
                                                                        </c:if>
                                                                        <c:if test="${not empty link.linkText}">
                                                                            <div class="mosaic-overlay">
                                                                                <div class="vertical-container">
                                                                                    <div class="vertical-content text-center">
                                                                                        <span class="label-destination type-destination theme-discover">${link.linkText}</span>
                                                                                    </div>
                                                                                </div>
                                                                            </div>
                                                                        </c:if>
                                                                    </div>
                                                                </c:if>
                                                                <c:if test="${not empty link.pagePath && not empty link.iconImage && not empty link.linkText}">
                                                                    <div class="mosaic-column-back mosaic-content flip-back mosaic-back theme-discover">
                                                                        <div class="vertical-container">
                                                                            <a href="${link.pagePath}" class="mosaic-link vertical-content text-center">
                                                                                <c:if test="${not empty link.iconImage}">
                                                                                <span class="mosaic-icon">
                                                                                    <img class="icon-generic" src="${link.iconImage}" alt="">
                                                                                </span>
                                                                                </c:if>
                                                                                <c:if test="${not empty link.linkText}">
                                                                                    <p class="type-destination line-through-line-wrapper">${link.linkText}</p>
                                                                                </c:if>
                                                                            </a>
                                                                        </div>
                                                                    </div>
                                                                </c:if>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <%-- END //  mosaic item --%>
                                            </c:forEach>
                                        </c:if>
                                        <%-- END // mosaic item --%>
                                    </div>
                                    <div class="megamenu-mosaic-right l-hideonmobile">
                                        <c:if test="${not empty navigation.megamenu3RhsCategoryTitle}">
                                        <h3 class="megamenu-mosaic-title">${navigation.megamenu3RhsCategoryTitle}</h3>
                                        </c:if>
                                        <c:if test="${not empty navigation.megamenu3RhsMosaicLinks}">
                                            <c:forEach items="${navigation.megamenu3RhsMosaicLinks}" var="link" varStatus="linkCount">
                                                <c:if test="${not empty numberOfMegamenu3LhsMosaicRowsCeil && (numberOfMegamenu3LhsMosaicRowsCeil >= linkCount.count)}">
                                                    <%-- START // mosaic item --%>
                                                    <div class="megamenu-mosaic-item">
                                                        <div class="mosaic-item">
                                                            <div class="mosaic-front-back-container flip-container outbound-link">
                                                                <div class="flipper">
                                                                    <c:if test="${not empty link.image && not empty link.linkText}">
                                                                        <div class="mosaic-column-front flip-front">
                                                                            <c:if test="${not empty link.image}">
                                                                                <div class="mosaic-media mosaic-primary">
                                                                                    <img src="${link.image}" alt="" />
                                                                                </div>
                                                                            </c:if>
                                                                            <c:if test="${not empty link.linkText}">
                                                                                <div class="mosaic-overlay">
                                                                                    <div class="vertical-container">
                                                                                        <div class="vertical-content text-center">
                                                                                            <span class="label-destination type-destination theme-discover">${link.linkText}</span>
                                                                                        </div>
                                                                                    </div>
                                                                                </div>
                                                                            </c:if>
                                                                        </div>
                                                                    </c:if>
                                                                    <c:if test="${not empty link.pagePath && not empty link.iconImage && not empty link.linkText}">
                                                                        <div class="mosaic-column-back mosaic-content flip-back mosaic-back theme-discover">
                                                                            <div class="vertical-container">
                                                                                <a href="${link.pagePath}" class="mosaic-link vertical-content text-center">
                                                                                    <c:if test="${not empty link.iconImage}">
                                                                                    <span class="mosaic-icon">
                                                                                        <img class="icon-generic" src="${link.iconImage}" alt="">
                                                                                    </span>
                                                                                    </c:if>
                                                                                    <c:if test="${not empty link.linkText}">
                                                                                        <p class="type-destination line-through-line-wrapper">${link.linkText}</p>
                                                                                    </c:if>
                                                                                </a>
                                                                            </div>
                                                                        </div>
                                                                    </c:if>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <%-- END //  mosaic item --%>
                                                </c:if>
                                            </c:forEach>
                                        </c:if>
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
                    <c:if test="${not empty navigation.arrivalBarLink1Text && not empty navigation.arrivalBarLink1}">
                        <li class="is-current">
                            <a href="${navigation.arrivalBarLink1}" target="${navigation.arrivalBarLink1IsExternal ? '_blank' : '_self'}">${navigation.arrivalBarLink1MobileText}</a>
                        </li>
                    </c:if>
                    <c:if test="${not empty navigation.arrivalBarLink2Text && not empty navigation.arrivalBarLink2}">
                        <li><a href="${navigation.arrivalBarLink2}" target="${navigation.arrivalBarLink2IsExternal ? '_blank' : '_self'}">${navigation.arrivalBarLink2MobileText}</a></li>
                    </c:if>
                    <li class="nav-bar-toggle">
                        <a class="nav-toggle-close" href="#nav-bar-top">
                            <span class="icon icon-close icon-32" aria-hidden="true"></span>
                            <span class="sr-only"><fmt:message key="Close Navigation"/></span>
                        </a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>
<%-- END: Navigation - navigation bar --%>