<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/apps/foodandwine/components/global.jsp" %>
<%@ page import="com.australia.foodandwine.components.content.contactIconText.ContactIconText" %>

<c:set var="cit" value="<%=new ContactIconText(slingRequest) %>"/>

<div class="l-center">
	<div class="form-biline-container type-spacing-30">
		<hr><div class="form-elements-biline">${cit.title}</div>
	</div>
	<p class="type-spacing-30">${cit.description}</p>
	<c:forEach items="${cit.ittList}" var="item">
		<p class="type-spacing-30">
			<span class="form-contact-icon"><img src="${item.iconImage}" alt=""></span>
			<br>
			<strong>${item.iconTitle}</strong>
			<br>${item.iconText}
		</p>
	</c:forEach>
	<em class="form-thank-you-small-print">${cit.smallPrint}</em>
</div>