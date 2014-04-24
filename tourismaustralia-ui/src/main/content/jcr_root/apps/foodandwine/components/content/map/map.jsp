<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/apps/foodandwine/components/global.jsp" %>
<%@ page import="com.australia.foodandwine.components.content.map.Map" %>

<c:set var="map" value="<%=new Map(slingRequest) %>"/>

<c:if test="${not map.hideMap}">
	<div class="l-center">
		<div class="custommap">
		    <img src="${map.googleMapUrl}" alt="Google Map image of Australia" />
		    <div class="custommap-description">
				<c:if test="${not empty map.phone}">
					<p class="custommap-description-head"><strong>Phone</strong></p>
					<p>${map.phone}</p>
				</c:if>
				<c:if test="${not empty map.suburb || not empty map.addresss || not empty map.state} ">
					<p class="custommap-description-head"><strong>Address</strong></p>
					<p>${map.address1}</p>
					<p>${map.suburb} ${map.state} ${map.postcode}</p>
				<br/>
				</c:if>
				<c:if test="${not empty map.website}">
					<a href="http://${map.website}" target="_blank"><strong>${map.website}</strong></a>
				</c:if>	
			</div>
		</div>
	</div>
</c:if>