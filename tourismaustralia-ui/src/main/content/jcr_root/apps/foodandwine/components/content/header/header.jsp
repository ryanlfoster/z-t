<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/apps/foodandwine/components/global.jsp"%>
<%@ page import="com.australia.foodandwine.components.content.header.Header"%>

<c:set var="Header" value="<%=new Header(slingRequest) %>" />

<!--Search box-->
<div class="nav-bar-panel-container">
    <div class="nav-bar-panel-content">
        <form class="nav-search-form" method="get" action="${Header.searchPath}">
            <fieldset class="nav-search-fieldset">
                <label class="nav-search-label" for="nav-search-field">What would you like to explore?</label>
                <input class="nav-search-text" id="nav-search-field" type="text" name="q" value="" placeholder="What would you like to explore in Australia?">
                <button class="nav-search-button" type="submit">
                </button>
            </fieldset>
        </form>

        <a tabindex="-1" class="nav-bar-panel-close" href="#nav-bar-top"><span class="icon icon-16 icon-close" aria-hidden="true"></span></a>
    </div>
</div>

<div class="navbar-outer">
	<header class="navbar make-black">
		<div class="navbar-container">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
                <a class="navbar-brand black_logo" href="http://www.australia.com/">
                    <img src="${Header.imagePath}" alt="${Header.imageAltTag}" title="Australia">
                </a>
                <a class="navbar-brand l-display-none-lg white_logo" href="#">
                    <img src="${Header.imagePath}" alt="${Header.imageAltTag}" title="Australia">
                </a>
            </div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<nav class="navbar-nav">
				<div class="navbar-mobile-head l-display-lg">
                    <h2 class="navbar-mobile-head-label">Menu</h2>
                    <span class="navbar-mobile-close-icon"></span>
                    <span class="navbar-mobile-open-icon"></span>
                    <span class="navbar-mobile-back-icon"></span>
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
										<a href="${headerData.pagePath }" target="_self">${headerData.linkText}</a>
									</c:when>
									<c:otherwise>
										<a>${headerData.linkText}</a>
									</c:otherwise>
								</c:choose>
							</li>
						</c:if>
					</c:forEach>
                    <li class="navbar-item-active-subitem">
                        <a href="#" target="_self">Explore by State & Territory</a>
                        <a><span class="navbar-item-dropdown-icon"></span></a>
                        <ul class="navbar-items navbar-subitems">
                            <li>
                                <a href="${Header.capital}.html" target="_self">
                                    <p>Australia Capital Territory</p>
                                </a>
                            </li>
                            <li>
                                <a href="${Header.nsw}.html" target="_self">
                                    <p>New South Wales</p>
                                </a>
                            </li>
                            <li>
                                <a href="${Header.northern}.html" target="_self">
                                    <p>Northern Territory</p>
                                </a>
                            </li>
                            <li>
                                <a href="${Header.queensland}.html" target="_self">
                                    <p>Queensland</p>
                                </a>
                            </li>
                            <li>
                                <a href="${Header.south}.html" target="_self">
                                    <p>South Australia</p>
                                </a>
                            </li>
                            <li>
                                <a href="${Header.tasmania}.html" target="_self">
                                    <p>Tasmania</p>
                                </a>
                            </li>
                            <li>
                                <a href="${Header.victoria}.html" target="_self">
                                    <p>Victoria</p>
                                </a>
                            </li>
                            <li>
                                <a href="${Header.western}.html" target="_self">
                                    <p>Western Australia</p>
                                </a>
                            </li>
                        </ul>
                    </li>
				</ul>
			</nav>
            <!-- search icon -->
            <a class="navbar-search-icon" href="#">
                <img src="/etc/designs/foodandwine/clientlibs/imgs/base/search-icon.png" alt="Search icon" title="" />
            </a>			
		</div>
	</header>
</div>
