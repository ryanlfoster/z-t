<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/apps/tourismaustralia/components/global.jsp"%>
<%@ page import="com.australia.www.components.page.global.Global" %>
<%@ page import="com.day.cq.wcm.api.WCMMode" %>

<c:set var="global" value="<%=new Global(slingRequest) %>"/>
<% WCMMode modeBefore = WCMMode.fromRequest(slingRequest); %>

<header id="main-header">
    <div id="nav-main-header" class="header megamenu">

        <%-- START: accessibility links --%>
        <div class="accessibility-links">
            <a tabindex="1" class="sr-only vis-focusable" href="#main-content">Skip to content</a>
            <a tabindex="2" class="sr-only vis-focusable" href="#main-footer">Skip to footer navigation</a>
        </div>
        <%-- END: accessibility links --%>

        <%-- START: main notice bar--%>
        <div id="main-notice-bar" class="notice-bar bar-scroll-top">
            <div class="row l-center-1200">
                <p class="notice-text notice-title">News alert</p>
                <p class="notice-text notice-summary">Lorem ipsum dolor sit amet consecuter. Ut enim ad minim. <a href="#">View the announcement</a></p>
                <a href="#nav-bar-top" class="notice-close"><span class="icon icon-16 icon-close" aria-hidden="true"></span></a>
            </div>
        </div>
        <%-- END: main notice bar--%>

        <c:if test="${not global.isAuHomePage}">
            <% WCMMode.DISABLED.toRequest(slingRequest); %>
        </c:if>
        <%-- START: Navigation --%>
        <cq:include path="navigation" resourceType="tourismaustralia/components/content/navigation"/>
        <%-- END: Navigation --%>
        <% modeBefore.toRequest(slingRequest); %>



    </div>
</header>