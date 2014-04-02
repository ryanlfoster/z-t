<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/apps/foodandwine/components/global.jsp" %>
<%@ page import="com.australia.foodandwine.components.content.contactIconText.ContactIconText" %>

<c:set var="cit" value="<%=new ContactIconText(slingRequest) %>"/>

<div class="l-center">
		<p class="type-spacing-30">
			<span class="form-contact-icon"><img src="${cit.icon}" alt="${cit.title}"></span>
			<br>
			<strong>${cit.title}</strong>
			<br>${cit.text}
		</p>
</div>