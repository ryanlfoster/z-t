<%@ taglib prefix="tacore" uri="http://www.austalia.com/taglibs/tourismaustralia-core/1.0" %>
<%@include file="/apps/tourismaustralia/components/global.jsp"%>
<%@ page import="com.australia.www.components.page.atdwsearch.AtdwSearchPage" %>

<div id="main-content">
    <cq:include path="hero" resourceType="tourismaustralia/components/content/hero"/>

    <div class="home-explore-summary-map">
        <div class="row l-center-1200">
            <div class="col-xs-12">
                <div class="breadcrumbs">
                    <cq:include path="breadcrumb" resourceType="tourismaustralia/components/content/breadcrumb"/>
                </div>
            </div>
        </div>
        <div class="row l-center-1200">
            <div class="col-xs-12 col-sm-3">
                <cq:include path="tagCloud" resourceType="tourismaustralia/components/content/tagCloud"/>
                <div class="shareicons-container">
                    <cq:include path="shareThis" resourceType="tourismaustralia/components/content/shareThis"/>
                </div>
            </div>
            <div class="col-xs-12 col-sm-9">
                <div>
                    <div class="col-xs-12 col-sm-12 col-md-6 col-md-push-6 home-summary-map-container">
                        <cq:include path="imageMapWithCityLink" resourceType="tourismaustralia/components/content/imageMapWithCityLink"/>
                    </div>
                    <div class="col-xs-12 col-sm-12 col-md-6 col-md-pull-6">
                        <div class="row">
                            <cq:include path="summary" resourceType="tourismaustralia/components/content/summary"/>
                        </div>
                        <hr class="full">
                        <div class="row">
                            <div class="type-body">
                                <cq:include path="text" resourceType="tourismaustralia/components/content/text"/>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="paragraph-city">
        <cq:include path="mainParsys" resourceType="foundation/components/parsys"/>
        <c:set var="atdwSearch" value="<%=new AtdwSearchPage(slingRequest) %>"/>
        <tacore:atdwSearch var="results" term="${param.term}" category="${param.category}" state="${param.state}" region="${param.region}" city="${param.city}" page="${param.page}" count="${atdwSearch.count}" />

        <table>
            <tbody>
            <c:forEach items="${results}" var="item" varStatus="status">

                <c:if test="${status.index % 3 == 0}">
                    <tr>
                </c:if>

                <td>${item.title}<br>${item.state}<br>${item.city}</td>


                <c:if test="${status.index % 3 == 2 || status.last}">
                    </tr>
                </c:if>

            </c:forEach>
            </tbody>
        </table>
        <cq:include path="categorizedIconLinks" resourceType="tourismaustralia/components/content/categorizedIconLinks"/>
    </div>
</div>

<%--
<c:set var="atdwSearch" value="<%=new AtdwSearchPage(slingRequest) %>"/>
<tacore:atdwSearch var="results" term="${param.term}" category="${param.category}" state="${param.state}" region="${param.region}" city="${param.city}" page="${param.page}" count="${atdwSearch.count}" />

<table>
    <tbody>
        <c:forEach items="${results}" var="item" status="status">

            <c:if test="${status.count % 3 == 0}">
                <tr>
            </c:if>

            <td>${item.title}<br>${item.state}<br>${item.city}</td>


            <c:if test="${status.count % 3 == 2 || status.last}">
                </tr>
            </c:if>

        </c:forEach>
    </tbody>
</table>
--%>