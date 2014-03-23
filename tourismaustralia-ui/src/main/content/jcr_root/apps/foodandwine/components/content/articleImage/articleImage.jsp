<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/apps/foodandwine/components/global.jsp" %>
<%@ page import="com.australia.foodandwine.components.content.articleImage.ArticleImage" %>

<c:set var="articleImage" value="<%=new ArticleImage(slingRequest) %>"/>

<a href="${articleImage.articleImageLinkPage}" class="imagewithdescription">
	<div class="imagewithdescription-inner">
		<img src="${articleImage.imagePath}" alt="">
		<div class="imagewithdescription-description">
			<p class="imagewithdescription-description-head"><strong><em>${articleImage.captionBold}</em></strong></p>
			<p class="imagewithdescription-description-copy"><em>${articleImage.imageCaption}</em></p>
		</div>
	</div>
</a>