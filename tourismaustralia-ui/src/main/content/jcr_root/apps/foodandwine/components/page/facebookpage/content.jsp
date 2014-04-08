<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/apps/foodandwine/components/global.jsp"%>
<%@ page import="com.australia.foodandwine.components.page.facebook.FacebookPage" %>

<c:set var="facebook" value="<%=new FacebookPage(slingRequest) %>"/>

<div>
	<p>
	<p>${facebook.userName}</p>
	<p>${facebook.postText}</p>
	<p>${facebook.postLink}</p>
</div>