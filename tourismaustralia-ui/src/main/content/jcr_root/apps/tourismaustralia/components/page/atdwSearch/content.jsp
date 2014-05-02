<%@ taglib prefix="tacore" uri="http://www.austalia.com/taglibs/tourismaustralia-core/1.0" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/apps/tourismaustralia/components/global.jsp"%>
<%@ page import="com.australia.www.components.page.atdwsearch.AtdwSearchPage" %>

<c:set var="search" value="<%=new AtdwSearchPage(slingRequest) %>"/>

<div class="paragraph-search">

    <div class="row l-center-1200">
        <div class="col-xs-12">
            <div class="breadcrumbs">
                <cq:include path="breadcrumb" resourceType="tourismaustralia/components/content/breadcrumb"/>
            </div>
        </div>
    </div>

    <div class="search-box">
        <div class="row l-center-1200">
            <div class="col-xs-12">
                <div class="search-box-wrapper">
                    <form method="get" action="#" data-aus-atdw-locations>
                        <fmt:message key="Type text to search" var="typeTextToSearch"/>
                        <label class="search-input-label" for="searchinput">${typeTextToSearch}</label>
                        <input class="search-input" name="term" type="text" placeholder="${typeTextToSearch}" value="${search.term}" />
                        <input type="button" class="search-input-go" type="submit" name="submit" />
                        <input type="button" class="search-input-clear" type="button" name="submit" />
                    </form>
                </div>
            </div>
        </div>
    </div>

    <c:if test="${search.showResults}">

        <div class="section-intro">
            <div class="l-center-900">
                <h3 class="type-h1-responsive">
                    <fmt:message key="MAKE YOUR TRIP HAPPEN"/>
                </h3>
            </div>
        </div>

        <div class="row l-center-1200">
            <div class="col-xs-12">
                <div class="l-h-center section-buttons">

                    <!-- Select List For Mobile -->
                    <div class="section-buttons-mobile">
                        <div class="dropdown-select">
                            <hr>
                            <div class="dropdown-select-style">
                                <select>
                                    <c:forEach items="${search.categories}" var="cat">
                                        <option value="${cat.searchPath}">
                                            <fmt:message key="${cat.display}" />
                                        </option>
                                    </c:forEach>
                                </select>
                            </div>
                            <hr>
                        </div>
                    </div>

                    <!-- Buttons -->
                    <div class="section-buttons-desktop">

                        <c:forEach items="${search.categories}" var="cat">
                            <c:if test="${cat.active}">
                                <c:set var="active" value="is-active" />
                            </c:if>
                            <c:if test="${!cat.active}">
                                <c:set var="active" value="" />
                            </c:if>
                            <a class="btn-bubble btn-bubble-min-width ${active} " href="${cat.searchPath}">
                                <span class="btn-bubble-button">
                                    <img class="btn-bubble-std" src="${cat.standardIconPath}" alt="">
                                    <img class="btn-bubble-active" src="${cat.activeIconPath}" alt="">
                                </span>
                                <span class="type-below-btn">
                                    <fmt:message key="${cat.display}" />
                                </span>
                            </a>
                        </c:forEach>

                    </div>

                </div>
            </div>
        </div>


        <div class="atdw-refresh-results">
            <div class="row l-center-1200">
                <div class="col-xs-12">
                    <div class="atdw-refresh-results-wrapper" data-aus-atdw>
                        <div class="atdw-refresh-results-item">
                            <div class="dropdown-white-background">
                                <div class="dropdown-white-background-style">
                                    <select name="state">
                                        <option value="."><fmt:message key="All States" /></option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="atdw-refresh-results-item">
                            <div class="dropdown-white-background">
                                <div class="dropdown-white-background-style">
                                    <select name="region">
                                        <option value="."><fmt:message key="All Regions" /></option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="atdw-refresh-results-item">
                            <div class="dropdown-white-background">
                                <div class="dropdown-white-background-style">
                                    <select name="city">
                                        <option value="."><fmt:message key="All Cities" /></option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="atdw-refresh-results-item">
                            <a class="btn-primary transparent" data-aus-atdw-refresh><fmt:message key="refresh results"/></a>
                        </div>
                    </div>
                </div>
            </div>
        </div>


        <div class="search-result-count">
            <div class="row l-center-1200">
                <div class="col-xs-12">
                    <span class="search-result-count-copy">
                        <fmt:message key="Showing {0} results" var="resultCountText">
                            <fmt:param value="${search.results.totalResultCount}"/>
                        </fmt:message>
                        <c:out value="${resultCountText}" />
                    </span>
                </div>
            </div>
        </div>

        <c:set var="products" value="${search.results.results}" scope="request" />
        <cq:include script="/apps/tourismaustralia/components/content/atdwHighlights/atdwHighlightMosaic.jsp" />

        <div class="atdw-search-pagination">
            <div class="row l-center-1200">
                <div class="col-xs-12">
                    <div class="atdw-search-pagination-wrapper type-links-bottom-border">
                        <c:if test="${search.page gt 1}">
                            <div class="atdw-search-pagination-prev">
                                <a href="${search.prevPage.path}"><fmt:message key="Prev"/></a>
                            </div>
                        </c:if>
                        <div class="atdw-search-pagination-pages">
                            <ul class="atdw-search-pagination-pages-wrapper">
                                <c:forEach items="${search.pages}" var="page">
                                    <c:if test="${page.selected}">
                                        <li><a class="is-active">${page.pageNumber}</a></li>
                                    </c:if>
                                    <c:if test="${!page.selected}">
                                        <li><a href="${page.path}">${page.pageNumber}</a></li>
                                    </c:if>
                                </c:forEach>
                            </ul>
                        </div>
                        <c:if test="${search.page lt search.lastPage}">
                            <div class="atdw-search-pagination-next">
                                <a href="${search.nextPage.path}"><fmt:message key="Next"/></a>
                            </div>
                        </c:if>
                    </div>
                </div>
            </div>
        </div>

    </c:if>

</div>