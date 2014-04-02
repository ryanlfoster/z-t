<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/apps/foodandwine/components/global.jsp"%>
<%@ page
	import="com.australia.foodandwine.components.content.header.Header"%>



<c:set var="Header" value="<%=new Header(slingRequest) %>" />

<c:if test="${Header.instanceModeName ne 'prod' }">
<script src="//assets.adobedtm.com/6fb6e65091abb6d979e09e86ef9f60bfab63fe46/satelliteLib-a7cbeb25ca5db5731606b57a50a7f7440e287963-staging.js"></script>
</c:if>

<c:if test="${Header.instanceModeName eq 'prod' }">
<script src="//assets.adobedtm.com/6fb6e65091abb6d979e09e86ef9f60bfab63fe46/satelliteLib-7fd9882a28dbbd42607f18b62a0ecd9666e033fe.js"></script>
</c:if>
<header id="main-header">
	<div class="navbar-outer">
		<!-- navbar module -->
		<header class="navbar make-black">
			<div class="navbar-container">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
					<a class="navbar-brand l-display-none-md black_logo"
						href="${Header.logoLinkPath}" target="_blank"> <img
						src="${Header.imagePath}" alt="${Header.imageAltTag}" />
					</a>
				</div>
				<!-- Collect the nav links, forms, and other content for toggling -->
				<nav class="navbar-nav">
					<div class="navbar-mobile-head l-display-md">
						<h2 class="navbar-mobile-head-label">Menu</h2>
						<span class="navbar-mobile-close-icon"></span> <span
							class="navbar-mobile-open-icon"></span> <span
							class="navbar-mobile-back-icon"></span>
					</div>
					<ul class="navbar-items">
						<c:forEach items="${Header.headerDataList}" var="headerData"
							varStatus="loop">
							<c:if test="${loop.index < 2 }">
								<c:set var="pageLink" value="${currentPage.path}.html" />
								<li
									class="navbar-item${headerData.pagePath == pageLink?'-active':''}">
									<c:choose>
										<c:when test="${not empty headerData.pagePath }">
											<a href="${headerData.pagePath }">${headerData.linkText}</a>
										</c:when>
										<c:otherwise>
											<a>${headerData.linkText}</a>
										</c:otherwise>
									</c:choose>
								</li>
							</c:if>
						</c:forEach>
					</ul>
				</nav>
			</div>
		</header>
	</div>
</header>

