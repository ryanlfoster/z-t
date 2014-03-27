<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/apps/foodandwine/components/global.jsp" %>
<%@ page import="com.australia.foodandwine.components.content.articleTitle.ArticleTitle" %>

<c:set var="articleTitle" value="<%=new ArticleTitle(slingRequest) %>"/>

<div class="l-center">
	<h1 class="form-h1">${articleTitle.name}</h1>
	<div class="form-biline-container type-spacing-60">
		<hr>
		<div class="form-elements-biline">
			${articleTitle.byline}
		</div>
	</div>
</div>