<%--
  Created by: Marjia Yeasmin
  Date: 26/03/2014

  This page facilitates in rendering the breadcrumb info for the current page
  by using the Breadcrumb Component.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@include file="/apps/tourismaustralia/components/global.jsp" %>
<%@ page import="com.australia.www.components.page.breadcrumb.Breadcrumb" %>

<c:set var="breadcrumb" value="<%=new Breadcrumb(slingRequest) %>"/>

<c:choose>
    <c:when test="${breadcrumb.homePage4Aus == true}">
        <c:out value=""/>
    </c:when>
    <c:otherwise>
        <ul class="breadcrumb">
            <c:choose>
                <c:when test = "${breadcrumb.localeRootPage == false}">
                    <c:forEach items="${breadcrumb.predecessorPages}" var="predecessorPage">
                        <li>
                            <c:if test = "${!predecessorPage.hideInNav}">
                                <a href="<c:out value="${predecessorPage.path}"/>.html">
                                    <c:choose>
                                        <c:when test = "${predecessorPage.depth == 2}">
                                            <c:out value="Home"/>
                                        </c:when>
                                        <c:otherwise>
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
                                        </c:otherwise>
                                    </c:choose>
                                </a>
                            </c:if>
                        </li>
                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <c:forEach items="${breadcrumb.predecessorPages}" var="predecessorPage">
                        <li>
                            <c:if test = "${!predecessorPage.hideInNav}">
                                <a href="<c:out value="${predecessorPage.path}"/>.html">
                                    <c:choose>
                                        <c:when test = "${predecessorPage.depth == 3}">
                                            <c:out value="Home"/>
                                        </c:when>
                                        <c:otherwise>
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
                                        </c:otherwise>
                                    </c:choose>
                                </a>
                            </c:if>
                        </li>
                    </c:forEach>
                </c:otherwise>
            </c:choose>
            <li>
                <c:choose>
                    <c:when test = "${currentPage.depth == 2}">
                        <c:out value="" />
                    </c:when>
                    <c:when test="${currentPage.navigationTitle == null}">
                        <c:out value="${currentPage.title}"/>
                    </c:when>
                    <c:when test="${currentPage.title == null}">
                        <c:out value="${currentPage.name}"/>
                    </c:when>
                    <c:otherwise>
                        <c:out value="${currentPage.navigationTitle}"/>
                    </c:otherwise>
                </c:choose>
            </li>
        </ul>
    </c:otherwise>
</c:choose>

