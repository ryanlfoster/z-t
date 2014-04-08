<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/apps/tourismaustralia/components/global.jsp" %>
<%@ page import="com.australia.www.components.content.mapwithparsys.MapWithParsys" %>

<c:set var="mapWithParsys" value="<%=new MapWithParsys(slingRequest) %>"/>

<div class="l-padding-between-item-fill-white">
<div class="map-with-links-container">

    <c:if test="${not empty mapWithParsys.title }">
        <div class="l-center-900">
            <h3 class="type-h1-responsive">${mapWithParsys.title}</h3>
        </div>
    </c:if>

    <div class="l-center-640">
        
        <c:if test="${not empty mapWithParsys.text }">
            <p class="map-with-links-intro">${mapWithParsys.text}</p>
        </c:if>
        
        <c:if test="${not empty mapWithParsys.image }">
            <img class="map-highlights-image" src="${mapWithParsys.image}.img.png" alt="${mapWithParsys.altText}" />
       
            <div class="map-image-view-btn-container">
                <a href="#" class="btn-primary"><%= i18n.get("view detailed map") %></a>
            </div>
        </c:if>

    </div>
    
    <cq:include script="bottom.jsp"/>

</div>
</div>