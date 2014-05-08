<%--
  Created by: Greg Snyder
  Date: 01/04/2014

--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="/apps/tourismaustralia/components/global.jsp" %>

<%@ page import="com.australia.www.components.content.atdwhighlights.*" %>
<c:set var="h" value="<%=new AtdwHighlights(slingRequest) %>"/>

<div class="atdwhighlights" data-aus-tab-container>

    <div class="section-intro">
        <div class="l-center-900">
            <h3 class="type-h1-responsive">${h.title}</h3>
        </div>
        <div class="l-center-640 type-center">
            <p class="type-intro"> ${h.text}</p>
        </div>
    </div>

    <div class="l-h-center section-buttons">

        <!-- Select List For Mobile -->
        <div class="section-buttons-mobile">
            <div class="dropdown-select">
                <hr>
                <div class="dropdown-select-style">
                    <select data-aus-select>
                        <c:forEach items="${h.activeCategories}" var="cat">
                            <c:if test="${not empty cat.products || isEdit}">
                                <option value="${cat.id}">
                                    <fmt:message key="${cat.display}" />
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
            <c:forEach items="${h.activeCategories}" var="cat">
                <c:if test="${not empty cat.products || isEdit}">
                    <a class="btn-bubble btn-bubble-min-width is-active " data-aus-tab="${cat.id}">
                        <span class="btn-bubble-button">
                            <img class="btn-bubble-std" src="${cat.standardIconPath}" alt="">
                            <img class="btn-bubble-active" src="${cat.activeIconPath}" alt="">
                        </span>
                        <span class="type-below-btn">
                            <fmt:message key="${cat.display}" />
                        </span>
                    </a>
                </c:if>
            </c:forEach>

        </div>

    </div>



    <c:forEach items="${h.activeCategories}" var="cat">

        <div class="mosaic" data-aus-show-tab="${cat.id}">
            <%
                AtdwHighlights.Category cat = (AtdwHighlights.Category) pageContext.getAttribute("cat");
                request.setAttribute("products", cat.getProducts());
            %>

            <c:if test="${empty products}">
                <div class="l-h-center" style="color: #833">No results -- This category will be hidden in Publish</div>
            </c:if>
            <c:if test="${not empty products}">
                <cq:include script="atdwHighlightMosaic.jsp" />
            </c:if>

        </div>

    </c:forEach>

    <div class="l-h-center">

        <c:forEach items="${h.activeCategories}" var="cat">
            <a href="${cat.allProductsPath}" class="btn-primary" data-aus-show-tab="${cat.id}">
                <fmt:message key="${cat.display}" var="catDisplay"/>
                <fmt:message key="View All {0}" var="viewAll">
                    <fmt:param value="${catDisplay}"/>
                </fmt:message>
                ${viewAll}
            </a>
        </c:forEach>

    </div>


</div>

