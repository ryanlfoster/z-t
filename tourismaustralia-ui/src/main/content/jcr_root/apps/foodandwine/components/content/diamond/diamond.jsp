<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/apps/foodandwine/components/global.jsp" %>
<%@ page import="com.australia.foodandwine.components.content.diamond.Diamond" %>

<c:set var="diamond" value="<%=new Diamond(slingRequest) %>"/>

<div class="faw-territories-socialcounter">
	<div class="socialcounter">
		<div class="socialcounter-bg"></div>
		<div class="socialcounter-content">
			<p class="socialcounter-count type-font-feature">${diamond.numberFormat}</p>
			<p class="socialcounter-tagged">${diamond.centerText}</p>
			<c:if test="${not empty diamond.bottomText}">
			<p class="socialcounter-link"><strong>#${diamond.bottomText}</strong></p>
			</c:if>
		</div>
	</div>	
</div>
