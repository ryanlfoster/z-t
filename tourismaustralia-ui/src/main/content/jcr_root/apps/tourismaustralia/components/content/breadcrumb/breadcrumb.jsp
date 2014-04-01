<%--
  Created by: Marjia Yeasmin
  Date: 26/03/2014

  This page facilitates in rendering the breadcrumb info for the current page
  by using the Breadcrumb Component.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/apps/tourismaustralia/components/global.jsp" %>
<%@ page import="com.australia.www.components.page.breadcrumb.*" %>

<c:set var="breadcrumb" value="<%=new Breadcrumb(slingRequest) %>"/>
<c:choose>
    <c:when test="${empty breadcrumb.predecessorPages}">
        <c:out value=""/>
    </c:when>
    <c:otherwise>
        <c:forEach items="${breadcrumb.predecessorPages}" var="predecessorPage">
            <c:if test = "${!predecessorPage.hideInNav}">
                <a href="<c:out value="${predecessorPage.path}"/>.html">
                    <c:choose>
                        <c:when test="${predecessorPage.navigationTitle == null}">
                            <c:out value="${predecessorPage.title}"/>
                        </c:when>
                        <c:when test="${predecessorPage.title == null}">
                            <c:out value="${predecessorPage.name}"/>
                        </c:when>
                        <c:otherwise>
                            <c:out value="${predecessorPage.navigationTitle}"/>
                        </c:otherwise>
                    </c:choose>
                </a>
                &nbsp;
            </c:if>
        </c:forEach>
    </c:otherwise>
</c:choose>
