<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/apps/foodandwine/components/global.jsp"%>
<%@ page
	import="com.australia.foodandwine.components.content.header.Header"%>
<c:set var="Header" value="<%=new Header(slingRequest) %>" />
<div class="navbar-outer">
	<header class="navbar make-black">
		<div class="navbar-container">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
			<c:if test="${not empty Header.imagePath}">
				<a class="navbar-brand l-display-none-md black_logo" href="${Header.linkPath}"> <img
					src="${Header.imagePath}" alt="Australia" title="Australia" />
				</a> <a class="navbar-brand l-display-none-md white_logo" href="#">
					<img src="imgs/brand/logo_white_text.png" alt="Australia"
					title="Australia" />
					
				</a>
			</c:if>	
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
					<c:forEach items="${Header.headerDataList}" var="headerData">
						<li class="navbar-item-active"><a
							href="${headerData.pagePath }" target="_self">${headerData.linkText}</a></li>
					</c:forEach>
				</ul>
			</nav>
			<!-- serach icon -->
			<c:if test="${not empty Header.searchIconPath}">
			<a class="navbar-search-icon" href="#"> <img
				src="${Header.searchIconPath}" alt="" title="" />
			</a>
			</c:if>
		</div>
	</header>
</div>
