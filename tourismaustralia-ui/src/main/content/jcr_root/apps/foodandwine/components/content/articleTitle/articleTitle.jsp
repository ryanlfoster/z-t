<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/apps/foodandwine/components/global.jsp" %>
<%@ page import="com.australia.foodandwine.components.content.articleTitle.ArticleTitle" %>

<c:set var="articleTitle" value="<%=new ArticleTitle(slingRequest) %>"/>

<div class="l-page-width-640" style="max-width:640px">
	<div class="icon-logo-withlines-container">
    	<hr class="icon-logo-withlines-hr">
    	<span class="icon-logo-withlines-logo btn-restaurant-australia-logo icon-font-logo"></span>
    	<hr class="icon-logo-withlines-hr">
	</div>
	<h1 class="form-h1">${articleTitle.name}</h1>
	<c:if test="${not empty articleTitle.byline }">
		<div class="form-biline-container type-spacing-60">
			<hr>
			<div class="form-elements-biline">
				${articleTitle.byline}
			</div>
		</div>
	</c:if>
</div>