<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/apps/tourismaustralia/components/global.jsp"%>
<%@ page import="com.australia.www.components.content.bylineShare.BylineShare"%>

<c:set var="byline" value="<%=new BylineShare(slingRequest) %>" />

<!-- bylinewithshare start -->
<div class="byline-share-container">
	<div class="byline-share-details">
		<div class="byline-container l-table">
			<div class="byline-social-image">
				<div class="image-social-image">
					<img src="${byline.imageSrc}" alt="" />
				</div>
			</div>
			<div class="byline-details">
				<div class="byline-by">Article by</div>
				<div class="byline-author">${byline.authorName}</div>
				<a href="${byline.link}" target="${byline.external?'_blank':'_self'}" class="byline-link">${byline.linkText}</a>
			</div>
		</div>
	</div>
	<div class="byline-share-icons">
		<cq:include path="shareThis" resourceType="tourismaustralia/components/content/shareThis" />
	</div>
</div>
<!-- bylinewithshare end -->
