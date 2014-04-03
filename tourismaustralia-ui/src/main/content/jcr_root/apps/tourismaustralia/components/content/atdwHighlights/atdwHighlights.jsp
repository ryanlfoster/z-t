<%--
  Created by: Greg Snyder
  Date: 01/04/2014

--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="/apps/tourismaustralia/components/global.jsp" %>
<%@ page import="com.australia.www.components.content.atdwhighlights.*" %>
<c:set var="h" value="<%=new AtdwHighlights(slingRequest) %>"/>

<div class="makeyourtriphappen-container">

    <div class="section-intro">
        <div class="l-center-900">
            <h1 class="type-h1-responsive">${h.title}</h1>
        </div>
        <div class="l-center-640 type-center">
            <p class="type-intro"> ${h.text}</p>

            <%-- Display the selected page tag to authors in edit mode --%>
            <c:if test="${isEdit && h.tagBased}">
                <p>Tag selected: ${h.selectedTagId}</p>
            </c:if>
        </div>
    </div>

    <div class="l-h-center section-buttons">

        <!-- Select List For Mobile -->
        <div class="section-buttons-mobile">



            <div class="dropdown-select">
                <hr>
                <div class="dropdown-select-style">
                    <select data-atdw-select>

                        <c:forEach items="${h.activeCategories}" var="cat">
                            <c:if test="${not empty cat.products || isEdit}">
                                <option value="${cat.id}">
                                    <%= i18n.get("${cat.display}") %>
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
                    <a href="#" class="btn-bubble btn-bubble-min-width is-active " data-atdw-category="${cat.id}">
                        <span class="btn-bubble-button">
                            <img class="btn-bubble-std" src="${cat.standardIconPath}" alt="">
                            <img class="btn-bubble-active" src="${cat.activeIconPath}" alt="">
                        </span>
                        <span class="type-below-btn">
                            <%= i18n.get("${cat.display}") %>
                        </span>
                    </a>
                </c:if>
            </c:forEach>

        </div>

    </div>



    <c:forEach items="${h.activeCategories}" var="cat">

        <div class="mosaic" data-atdw-show-cat="${cat.id}">
            <%
                AtdwHighlights.Category cat = (AtdwHighlights.Category) pageContext.getAttribute("cat");
                request.setAttribute("products", cat.getProducts());
            %>
            <cq:include script="atdwHighlightMosaic.jsp" />
        </div>

    </c:forEach>

    <div class="l-h-center">

        <c:forEach items="${h.activeCategories}" var="cat">
            <a href="#" class="btn-primary" data-atdw-show-cat="${cat.id}">
                <%= i18n.get("View all " + ((AtdwHighlights.Category) pageContext.getAttribute("cat")).getDisplay()) %>
            </a>
        </c:forEach>

    </div>


</div>

