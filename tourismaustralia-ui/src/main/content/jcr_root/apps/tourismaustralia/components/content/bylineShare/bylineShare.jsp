<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/apps/tourismaustralia/components/global.jsp" %>
<%@ page import="com.australia.www.components.content.bylineShare.BylineShare" %>

<c:set var="bylineShare" value="<%=new BylineShare(slingRequest) %>"/>

<div class="byline-share-container">
    <div class="byline-share-details">
		<div class="byline-container l-table">
    		<div class="byline-social-image">
				<div class="image-social-image">
				    <img src="/etc/designs/tourismaustralia/clientlibs/img/placeholders/image_social_image2.jpg" alt="Social Image">
				</div>
		    </div>

		    <div class="byline-details">
		        <div class="byline-by">Article by</div>
		        <div class="byline-author">${bylineShare.authorName}</div>
		        <a href="${bylineShare.link}" class="byline-link">${bylineShare.linkText}</a>
		    </div>

		</div>
	</div>

    <div class="byline-share-icons">
		<cq:include path="shareThis" resourceType="tourismaustralia/components/content/shareThis" />
    </div>
</div>