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
            <a tabindex="1" class="sr-only vis-focusable" href="#main-content"><fmt:message key="Skip to content" /></a>
            <a tabindex="2" class="sr-only vis-focusable" href="#main-footer"><fmt:message key="Skip to"/> footer navigation</a>
        </div>
        <%-- END: accessibility links --%>

        <c:if test="${not global.isAuHomePage}">
            <% WCMMode.DISABLED.toRequest(slingRequest); %>
        </c:if>

        <%-- START: notice bar--%>
        <cq:include path="noticeBar" resourceType="tourismaustralia/components/content/noticeBar"/>
        <%-- END: notice bar--%>

        <%-- START: Navigation --%>
        <cq:include path="navigation" resourceType="tourismaustralia/components/content/navigation"/>
        <%-- END: Navigation --%>
        <% modeBefore.toRequest(slingRequest); %>



    </div>
</header>