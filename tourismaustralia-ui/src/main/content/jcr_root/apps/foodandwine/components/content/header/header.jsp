<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/apps/foodandwine/components/global.jsp"%>
<%@ page import="com.australia.foodandwine.components.content.header.Header"%>
<c:set var="Header" value="<%=new Header(slingRequest) %>" />

 <div class="navbar-outer">
 <!-- navbar module -->
    <header class="navbar make-black">
        <div class="navbar-container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <a class="navbar-brand l-display-none-md black_logo" href="http://www.australia.com/">
                    <img src="${Header.imagePath}" alt="Australia" title="Australia" />
                </a>
               
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <nav class="navbar-nav">
              <!--   <div class="navbar-mobile-head l-display-md">
                    <h2 class="navbar-mobile-head-label">Menu</h2>
                    <span class="navbar-mobile-close-icon"></span>
                    <span class="navbar-mobile-open-icon"></span>
                    <span class="navbar-mobile-back-icon"></span>
                </div> -->
                <ul class="navbar-items">
                    <c:forEach items="${Header.headerDataList}" var="headerData">
						<li class="navbar-item-active">
							<a href="${headerData.pagePath }" target="_self">${headerData.linkText}</a>
						</li>
					</c:forEach>
                    <!--
                    <li class="navbar-item-active-subitem">
                        <a href="#" target="_self">Contributors</a>
                        <a>Contributors<span class="navbar-item-dropdown-icon"></span></a>
                        <ul class="navbar-items navbar-subitems">
                            <li>
                                <a href="#1" target="_self">
                                    <p>Explore</p>
                                </a>
                            </li>
                            <li>
                                <a href="#2" target="_self">
                                    <p>Finder</p>
                                </a>
                            </li>
                            <li>
                                <a href="#3" target="_self">
                                    <p>Business</p>
                                </a>
                            </li>
                            <li>
                                <a href="#4" target="_self">
                                    <p>Wayfinder</p>
                                </a>
                            </li>
                            <li>
                                <a href="#5" target="_self">
                                    <p>Contact</p>
                                </a>
                            </li>
                        </ul>
                    </li>
                    -->
                </ul>
            </nav>
            <!-- serach icon -->
            <!--
            <a class="navbar-search-icon" href="#">
                <img src="imgs/base/search-icon.png" alt="" title="" />
            </a>
            -->
        </div>
    </header>
</div>
