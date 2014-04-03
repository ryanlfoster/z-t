<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/apps/foodandwine/components/global.jsp" %>
<%@ page import="com.australia.foodandwine.components.content.avatar.Avatar" %>

<c:set var="avatar" value="<%=new Avatar(slingRequest) %>"/>

<div class="avatar">
	<img src="${avatar.imagePath}" alt="${avatar.imageText}">
	<p class="avatar-label"><strong>${avatar.imageText}</strong></p>
</div>
