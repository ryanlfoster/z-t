<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/apps/tourismaustralia/components/global.jsp"%>
<%@ page import="com.australia.www.components.page.search.SearchPage" %>

<c:set var="search" value="<%=new SearchPage(slingRequest) %>"/>
<div id="main-content">
    <div class="paragraph-search">
        <cq:include path="breadcrumb" resourceType="tourismaustralia/components/content/breadcrumb"/>

        <%-- REMOVE WHEN HEADER IS FIXED --%>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>

        <div class="search-box">
            <div class="row l-center-1200">
                <div class="col-xs-12">
                    <div class="search-box-wrapper">
                        <form method="get" action="#">
                            <label class="search-input-label" for="searchinput">Type text to search</label>
                            <input class="search-input" name="searchinput" type="text" placeholder="Type text to search" value="${search.query}" />
                            <input type="button" class="search-input-go" type="submit" name="submit" />
                            <input type="button" class="search-input-clear" type="button" name="submit" />
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <div class="search-your-results">
            <div class="row l-center-1200">
                <div class="col-xs-12">

                    <div class="section-intro">
                        <div class="l-center-900">
                            <h3 class="type-h3-responsive">
                                <fmt:message key="Your Results"/>
                            </h3>
                        </div>
                        <div class="search-toggle-buttons">
                            <c:if test="${search.listMode}"><c:set var="listActive" value="is-active"/></c:if>
                            <a class="btn-bubble btn-bubble-min-width ${listActive}">
                                <img class="btn-bubble-std" src="/etc/designs/tourismaustralia/clientlibs/imgs/icons/search_list_icon_outline.png" alt=""/>
                                <img class="btn-bubble-active" src="/etc/designs/tourismaustralia/clientlibs/imgs/icons/search_list_icon.png" alt=""/>
                            </a>
                            <c:if test="${search.gridMode}"><c:set var="gridActive" value="is-active"/></c:if>
                            <a class="btn-bubble btn-bubble-min-width ${gridActive}">
                                <img class="btn-bubble-std" src="/etc/designs/tourismaustralia/clientlibs/imgs/icons/search_grid_icon_outline.png" alt=""/>
                                <img class="btn-bubble-active" src="/etc/designs/tourismaustralia/clientlibs/imgs/icons/search_grid_icon.png" alt=""/>
                            </a>
                        </div>
                    </div>
                </div>

                <div class="search-result-count">
                    <div class="row l-center-1200">
                        <div class="col-xs-12">
                            <span class="search-result-count-copy">
                                <fmt:message key="Showing {0} results" var="resultCountText">
                                    <fmt:param value="${search.totalResultCount}"/>
                                </fmt:message>
                                <c:out value="${resultCountText}" />
                            </span>
                        </div>
                    </div>
                </div>

                <div class="search-results-mosaic">

                    <div class="mosaic">
                        <div class="row l-row-collapse">
                            <div class="row">
                                <c:if test="${search.gridMode}">
                                    <c:set var="alt" value="false" scope="request"/>
                                    <c:forEach items="${search.contentResultsAsGrid}" var="row">
                                        <c:set var="row" value="${row}" scope="request"/>
                                        <cq:include script="/apps/tourismaustralia/components/content/fourToOneGrid/fourToOneGrid_mainRow.jsp"/>
                                        <c:set var="alt" value="${!alt}" scope="request"/>
                                    </c:forEach>
                                </c:if>
                            </div>
                        </div>
                    </div>

                </div>

                <div class="search-atdw-highlights">
                    <div class="row l-center-1200">
                        <div class="col-xs-12">

                            <div class="section-intro">
                                <div class="l-center-900">
                                    <h3 class="type-h1-responsive">
                                        <fmt:message key="Make Your Trip Happen" />
                                    </h3>
                                </div>
                                <div class="l-center-640 type-center">
                                    <p class="type-intro">
                                        {{{copy}}}
                                    </p>
                                </div>
                            </div>

                            <div class="search-atdw-mosaic">
                                <c:set var="products" value="${search.productResults}" scope="request"/>
                                <cq:include script="/apps/tourismaustralia/components/content/atdwHighlights/atdwHighlightMosaic.jsp" />
                                {{> mosaic_3column_2rows }}
                            </div>

                            {{#parseJSON '{"copy" : "Search More"}'}}
                            {{> search_view_more }}
                            {{/parseJSON}}

                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>