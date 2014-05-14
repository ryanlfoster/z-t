<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="/apps/tourismaustralia/components/global.jsp" %>

<%@ page import="com.australia.www.components.content.whatyoucansee.*" %>
<c:set var="wycs" value="<%=new WhatYouCanSee(slingRequest) %>"/>


<div class="whatyoucansee" data-aus-tab-container>
    <div class="section-intro">
        <div class="l-center-900">
            <h3 class="type-h1-responsive">
                ${wycs.title}
            </h3>
        </div>
        <div class="l-center-640 type-center">
            <p class="type-intro">
                ${wycs.text}
            </p>
        </div>
    </div>

    <c:if test="${wycs.showTabs}">
        
    <div class="l-h-center section-buttons">
        <!-- Select List For Mobile -->
        <div class="section-buttons-mobile">
            <div class="dropdown-select">
                <hr>
                <div class="dropdown-select-style">
                    <select data-aus-select>
                        <c:forEach items="${wycs.tabs}" var="tab">
                            <c:if test="${not empty tab.contentRows || isEdit}">
                                <option value="${tab.id}">
                                    <fmt:message key="${tab.displayName}" />
                                </option>
                            </c:if>
                        </c:forEach>
                    </select>
                </div>
                <hr>
            </div>
        </div>
        <!-- Buttons -->
        <div class="section-buttons-desktop">

            <c:forEach items="${wycs.tabs}" var="tab">
                <c:if test="${not empty tab.contentRows || isEdit}">
                    <a class="btn-bubble btn-bubble-min-width is-active btn-category-extra-space" data-aus-tab="${tab.id}">
                        <span class="btn-bubble-button">
                            <img class="btn-bubble-std" src="${tab.unselectedImagePath}" alt=""/>
                            <img class="btn-bubble-active" src="${tab.selectedImagePath}" alt=""/>
                        </span>
                        <span class="type-below-btn">${tab.displayName}</span>
                    </a>
                </c:if>
            </c:forEach>
        </div>
    </div>

    </c:if>


    <c:forEach items="${wycs.tabs}" var="tab">
        <c:set var="alt" value="false" scope="request"/>
        <div class="mosaic" data-aus-show-tab="${tab.id}">
            <div class="row l-row-collapse">

                <c:forEach items="${tab.contentRows}" var="row">
                    <c:set scope="request" var="row" value="${row}" />
                    <div class="row">
                        <cq:include script="/apps/tourismaustralia/components/content/fourToOneGrid/fourToOneGrid_mainRow.jsp"/>
                    </div>
                    <c:set var="alt" value="${!alt}" scope="request"/>
                </c:forEach>

            </div>
        </div>
    </c:forEach>

    <div class="l-h-center">
        <c:forEach items="${wycs.tabs}" var="tab">
            <c:if test="${not empty tab.viewMoreText}">
                <a href="${tab.viewMorePath}" class="btn-primary" data-aus-show-tab="${tab.id}">
                    <fmt:message key="${tab.viewMoreText}" var="viewMoreType" />
                    <fmt:message key="View All {0}" var="viewAllText">
                        <fmt:param value="${viewMoreType}" />
                    </fmt:message>
                    ${viewAllText}
                </a>
            </c:if>
        </c:forEach>
    </div>
</div>