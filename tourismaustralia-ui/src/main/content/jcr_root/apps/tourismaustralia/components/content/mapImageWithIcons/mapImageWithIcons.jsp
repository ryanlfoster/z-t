<%--
  Created by: Greg Snyder
  Date: 09/04/2014

--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/apps/tourismaustralia/components/global.jsp" %>
<%@ page import="com.australia.www.components.content.mapImageWithIcons.MapImageWithIcons" %>

<c:set var="map" value="<%=new MapImageWithIcons(slingRequest) %>"/>
<c:set var="iconPath" value="/etc/designs/tourismaustralia/clientlibs/imgs/placeholders/"/>

<div class="map-with-links-container map-with-links-container--small l-padding-b" data-section-name="track">
    <c:if test="${not empty map.title}">
    <div class="l-center-900">
        <h3 class="type-h1-responsive">${map.title}</h3>
    </div>
    </c:if>
    <c:if test="${not empty map.mapImage}">
    <div class="l-center-640">
        <p class="map-with-links-intro">${map.text}</p>

        <img src="${map.mapImage}" class="map-highlights-image" alt="">

    </div>
    </c:if>

    <div class="map-btn-container">
        <c:if test="${not empty map.bestTime}">
            <div class="map-btn-content">
                <div class="map-image-icon">
                    <img src="${iconPath}calendar-small.png" alt="" />
                </div>
                <div>
                    <span class="map-btn-heading"><fmt:message key="Best time to go"/></span>
                    ${map.bestTime}
                </div>
            </div>
        </c:if>
    </div>

    <div class="map-btn-container">
        <c:if test="${not empty map.duration}">
            <div class="map-btn-content">
                <div class="map-image-icon">
                    <img src="${iconPath}clock-small.png" alt="" />
                </div>
                <div>
                    <span class="map-btn-heading"><fmt:message key="Duration"/></span>
                    ${map.duration}
                </div>
            </div>
        </c:if>
    </div>

    <div class="map-btn-container">
        <c:if test="${not empty map.totalDistance}">
            <div class="map-btn-content">
                <div class="map-image-icon">
                    <img src="${iconPath}graph-small.png" alt="" />
                </div>
                <div>
                    <span class="map-btn-heading"><fmt:message key="Total distance"/></span>
                    ${map.totalDistance}
                </div>
            </div>
        </c:if>
    </div>

    <div class="map-btn-container">
        <c:if test="${not empty map.modeOfTransport}">
            <div class="map-btn-content">
                <div class="map-image-icon">
                    <img src="${iconPath}walking-small.png" alt="" />
                </div>
                <div>
                    <span class="map-btn-heading"><fmt:message key="Mode of transport"/></span>
                    ${map.modeOfTransport}
                </div>
            </div>
        </c:if>
    </div>

    <div class="map-btn-container">
        <c:if test="${not empty map.moreInfo}">
            <div class="map-btn-content">
                <div class="map-image-icon">
                    <img src="${iconPath}info-small.png" alt="" />
                </div>
                <div>
                    <span class="map-btn-heading"><fmt:message key="More information"/></span>
                    ${map.moreInfo}
                </div>
            </div>
        </c:if>
    </div>

</div>