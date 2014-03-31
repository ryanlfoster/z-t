<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/apps/foodandwine/components/global.jsp"%>
<%@ page import="com.australia.foodandwine.components.content.header.Header"%>
<c:set var="Header" value="<%=new Header(slingRequest) %>" />	
		
<header id="main-header">
	<div class="navbar-outer">
		<!-- navbar module -->
		<header class="navbar make-black">
			<div class="navbar-container">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
					<a class="navbar-brand l-display-none-md black_logo" href="${Header.logoLinkPath}" target="_blank"> 
						<img src="${Header.imagePath}" alt="${Header.imageAltTag}" />
					</a>
				</div>
				<!-- Collect the nav links, forms, and other content for toggling -->
				<nav class="navbar-nav">
					<div class="navbar-mobile-head l-display-md">
	                    <h2 class="navbar-mobile-head-label">Menu</h2>
	                    <span class="navbar-mobile-close-icon"></span>
	                    <span class="navbar-mobile-open-icon"></span>
	                    <span class="navbar-mobile-back-icon"></span>
	                </div>
					<ul class="navbar-items">
						<c:forEach items="${Header.headerDataList}" var="headerData"
							varStatus="loop">
							<c:if test="${loop.index < 2 }">
								<c:set var="pageLink" value="${currentPage.path}.html"/>
								<li class="navbar-item${headerData.pagePath == pageLink?'-active':''}">
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

