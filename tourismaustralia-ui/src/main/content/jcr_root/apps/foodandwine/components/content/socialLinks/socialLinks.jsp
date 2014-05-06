<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/apps/foodandwine/components/global.jsp"%>
<%@ page import="com.australia.foodandwine.components.content.sociallinks.SocialLinks" %>

<c:set var="socialLinks" value="<%=new SocialLinks(slingRequest) %>"/>

<div class="faw-share-list">
	<p>
		<!-- See all conversations relating to <strong>#restaurants</strong> on: -->
		${socialLinks.title}
	</p>
	<c:if test="${not empty socialLinks.socialLink1.socialLinksTitle }">
		<a href="${socialLinks.socialLink1.socialLinks}" target="_blank" class="faw-share-list-item"> 
			<span class="faw-share-list-icon">
				<img class="faw-share-list-icon-hover" src="${socialLinks.socialLink1.linkLogoHoverPath}" alt="111">
				<img class="faw-share-list-icon-default" src="${socialLinks.socialLink1.socialLinksLogoPath}" alt="222">
			</span>
			<p class="faw-share-list-tem-label">
				<strong>${socialLinks.socialLink1.socialLinksTitle}</strong>
			</p>
		</a>
	</c:if>

	<c:if test="${not empty socialLinks.socialLink2.socialLinksTitle }">
		<a href="${socialLinks.socialLink2.socialLinks}" target="_blank" class="faw-share-list-item"> 
			<span class="faw-share-list-icon">
				<img class="faw-share-list-icon-hover" src="${socialLinks.socialLink2.linkLogoHoverPath}" alt="">
				<img class="faw-share-list-icon-default" src="${socialLinks.socialLink2.socialLinksLogoPath }" alt="">
			</span>
			<p class="faw-share-list-tem-label">
				<strong>${socialLinks.socialLink2.socialLinksTitle }</strong>
			</p>
		</a>
	</c:if>

	<c:if test="${not empty socialLinks.socialLink3.socialLinksTitle }">
		<a href="${socialLinks.socialLink3.socialLinks}" target="_blank" class="faw-share-list-item"> 
			<span class="faw-share-list-icon">
				<img class="faw-share-list-icon-hover" src="${socialLinks.socialLink3.linkLogoHoverPath}" alt="">
				<img class="faw-share-list-icon-default" src="${socialLinks.socialLink3.socialLinksLogoPath }" alt="">
			</span>
			<p class="faw-share-list-tem-label">
				<strong>${socialLinks.socialLink3.socialLinksTitle }</strong>
			</p>
		</a>
	</c:if>
	
</div>