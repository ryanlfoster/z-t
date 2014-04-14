<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/apps/tourismaustralia/components/global.jsp" %>
<%@ page import="com.australia.www.components.content.mapwithbuttons.MapWithButtons" %>

<c:set var="mapWithButtons" value="<%=new MapWithButtons(slingRequest) %>"/>

<div class="l-padding-between-item-fill-white">
<div class="map-with-links-container">

    <c:if test="${not empty mapWithButtons.title }">
        <div class="l-center-900">
            <h3 class="type-h1-responsive">${mapWithButtons.title}</h3>
        </div>
    </c:if>

    <div class="l-center-640">
        
        <c:if test="${not empty mapWithButtons.text }">
            <p class="map-with-links-intro">${mapWithButtons.text}</p>
        </c:if>
        
        <c:if test="${not empty mapWithButtons.image }">
            <img class="map-highlights-image" src="${mapWithButtons.image}.img.png" alt="${mapWithButtons.altText}" />
       
            <div class="map-image-view-btn-container">
                <a href="#" class="btn-primary"><fmt:message key="view detailed map"/></a>
            </div>
        </c:if>

    </div>
    
    <c:forEach items="${mapWithButtons.buttonsList}" var="button">
		<c:if test="${button.isEmpty}">
			<div class="map-btn-container">
				<div class="map-btn-content">         
					<div class="map-image-icon">                   
				    		<img src="<c:url value="${button.imagePath }" />">
					</div>
					<div>
			    		<span class="map-btn-heading">${button.title}</span>
						${button.text}
					</div>
				</div>
			</div>
		</c:if>
	</c:forEach>

</div>
</div>