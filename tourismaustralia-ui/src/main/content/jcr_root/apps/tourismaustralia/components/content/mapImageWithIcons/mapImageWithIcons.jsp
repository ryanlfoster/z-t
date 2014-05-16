<%--
  Created by: Greg Snyder
  Date: 09/04/2014

--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/apps/tourismaustralia/components/global.jsp" %>
<%@ page import="com.australia.www.components.content.mapimagewithicons.MapImageWithIcons" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:set var="map" value="<%=new MapImageWithIcons(slingRequest) %>"/>

<c:if test="${not empty map.mapIconTitleDescriptionItems}">
    <c:set var="numberOfMapItems" value="${fn:length(map.mapIconTitleDescriptionItems)}"/>
</c:if>

<div class="map-with-links-container ${numberOfMapItems > 3 ? 'map-with-links-container--small l-padding-b' : ''}" data-section-name="track">
    <c:if test="${not empty map.title}">
    <div class="l-center-900">
        <h3 class="type-h1-responsive">${map.title}</h3>
    </div>
    </c:if>
    <c:if test="${not empty map.mapImage}">
    <div class="l-center-640">
        <p class="map-with-links-intro">${map.text}</p>
        <img src="${map.mapImage}" class="map-highlights-image" alt="${map.mapAltText}">
    </div>
    </c:if>

    <c:if test="${not empty map.mapIconTitleDescriptionItems}">
        <%-- START // item --%>
        <c:forEach items="${map.mapIconTitleDescriptionItems}" var="item">
        <div class="map-btn-container">
            <div class="map-btn-content">
                <c:if test="${not empty item.icon}">
                <div class="map-image-icon"><img src="${item.icon}" alt="" /></div>
                </c:if>
                <c:if test="${not empty item.title || not empty item.description}">
                    <div>
                        <span class="map-btn-heading">${item.title}</span>
                        ${item.description}
                    </div>
                </c:if>
            </div>
        </div>
        </c:forEach>
        <%-- END // item --%>
    </c:if>

</div>