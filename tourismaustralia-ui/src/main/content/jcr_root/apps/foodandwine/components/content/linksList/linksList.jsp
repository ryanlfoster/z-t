<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/apps/foodandwine/components/global.jsp" %>
<%@ page import="com.australia.foodandwine.components.content.linksList.LinksList" %>

<c:set var="linksList" value="<%=new LinksList(slingRequest) %>"/>

<ul class="form-thank-you-states">
	<c:forEach items="${linksList.links}" var="link">
		<li>
			<strong><a href="${link.url}">${link.displayText}</a></strong>
		</li>
	</c:forEach>
</ul>