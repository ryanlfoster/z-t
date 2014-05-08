<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/apps/tourismaustralia/components/global.jsp" %>
<%@ page import="com.australia.www.components.content.mapWithLinks.MapWithLinks" %>

<c:set var="mapWithLinks" value="<%=new MapWithLinks(slingRequest) %>"/>

<div class="map-with-links-container l-padding-b">

    <c:if test="${not empty mapWithLinks.title }">
        <div class="l-center-900">
            <h3 class="type-h1-responsive">${mapWithLinks.title}</h3>
        </div>
    </c:if>

    <div class="l-center-640">
        
        <c:if test="${not empty mapWithLinks.text }">
            <p class="map-with-links-intro">${mapWithLinks.text}</p>
        </c:if>
        
        <c:if test="${not empty mapWithLinks.image }">
            <img class="map-highlights-image" src="${mapWithLinks.image}.img.png" alt="${mapWithLinks.altText}" />
       
            <div class="map-image-view-btn-container">
                <a href="#" class="btn-primary"><fmt:message key="view detailed map"/></a>
            </div>
        </c:if>

    </div>
    
	<div class="map-with-links-list-container">
	    <ol class="map-with-links-list">
	        <c:forEach items="${mapWithLinks.linksList}" var="link">
	            <li><a href="${link.path}">${link.title}</a></li>
	        </c:forEach>
	    </ol>
	</div>

</div>
