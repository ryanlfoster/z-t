<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/apps/tourismaustralia/components/global.jsp" %>
<%@ page import="com.australia.www.components.content.buttons.Buttons" %>

<c:set var="buttonsComponent" value="<%=new Buttons(slingRequest) %>"/>

<c:forEach items="${buttonsComponent.buttonsList}" var="button">
	<c:if test="${button.isEmpty}">
		<div class="map-btn-container">
			<div class="map-btn-content">         
				<div class="map-image-icon">                   
			    		<img src=${button.imagePath }>
				</div>
				<div>
		    		<span class="map-btn-heading">${button.title}</span>
					${button.text}
				</div>
			</div>
		</div>
	</c:if>
</c:forEach>