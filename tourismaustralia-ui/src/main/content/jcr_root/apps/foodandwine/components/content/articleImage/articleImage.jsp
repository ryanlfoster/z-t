<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/apps/foodandwine/components/global.jsp"%>
<%@ page
	import="com.australia.foodandwine.components.content.articleImage.ArticleImage"%>

<c:set var="articleImage" value="<%=new ArticleImage(slingRequest) %>" />

<c:if test="${not empty articleImage.imagePath}">
	<c:choose>
		<c:when test="${not empty articleImage.externalLink }">
				<a href="${articleImage.articleImageLinkPage}" target="_BLANK"
					class="imagewithdescription">
			<div class="imagewithdescription-inner">
				<img src="${articleImage.imagePath}"
					style="width: 683px; height: 385px;" alt="">
				<c:if test="${not empty articleImage.captionBold}">
					<div class="imagewithdescription-description">
						<p class="imagewithdescription-description-head">
							<strong><em>${articleImage.captionBold}</em></strong>
						</p>
						<c:if test="${not empty articleImage.imageCaption}">
							<p class="imagewithdescription-description-copy">
								<em>${articleImage.imageCaption}</em>
							</p>
						</c:if>
					</div>
				</c:if>
			</div>
				</a>
		</c:when>
		<c:otherwise>
				<a href="${articleImage.articleImageLinkPage}"
					class="imagewithdescription">
			<div class="imagewithdescription-inner">
				<img src="${articleImage.imagePath}"
					style="width: 683px; height: 385px;" alt="">
				<c:if test="${not empty articleImage.captionBold}">

					<div class="imagewithdescription-description">
						<p class="imagewithdescription-description-head">
							<strong><em>${articleImage.captionBold}</em></strong>
						</p>
						<c:if test="${not empty articleImage.imageCaption}">
							<p class="imagewithdescription-description-copy">
								<em>${articleImage.imageCaption}</em>
							</p>
						</c:if>
					</div>
				</c:if>
			</div>
				</a>
		</c:otherwise>

	</c:choose>
</c:if>