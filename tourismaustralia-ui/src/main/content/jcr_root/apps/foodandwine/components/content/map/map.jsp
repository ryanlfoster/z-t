<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/apps/foodandwine/components/global.jsp" %>
<%@ page import="com.australia.foodandwine.components.content.map.Map" %>

<c:set var="map" value="<%=new Map(slingRequest) %>"/>

<div class="l-center">
	<div class="custommap">
	    <img src="${map.googleMapUrl}" />
	    <div class="custommap-description">
			<p class="custommap-description-head"><strong>Phone</strong></p>
			<p>${map.phone}</p>
			<p class="custommap-description-head"><strong>Address</strong></p>
			<p>${map.address1}</p>
			<p>${map.suburb}, ${map.state} ${map.postcode}</p>
			<br/>
			<a href="http://${map.website}" target="_blank"><strong>${map.website}</strong></a>
		</div>
	</div>
</div>
