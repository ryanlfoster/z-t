<%@include file="/apps/tourismaustralia/components/global.jsp" %>
<%@ page import="com.australia.www.components.content.noticeBar.NoticeBar" %>

<c:set var="noticeBar" value="<%=new NoticeBar(slingRequest) %>"/>

<c:if test="${not empty noticeBar.title || not empty noticeBar.text || ( not empty noticeBar.linkPath && not empty noticeBar.linkText )}">
<div id="main-notice-bar" class="notice-bar bar-scroll-top">
    <div class="row l-center-1200">
        <c:if test="${not empty noticeBar.title}">
        <p class="notice-text notice-title">${noticeBar.title}</p>
        </c:if>

        <c:if test="${not empty noticeBar.text || ( not empty noticeBar.linkPath && not empty noticeBar.linkText )}">
        <p class="notice-text notice-summary">
            <c:if test="${not empty noticeBar.text}">${noticeBar.text}</c:if> <c:if test="${not empty noticeBar.linkPath && not empty noticeBar.linkText}"><a href="${noticeBar.linkPath}">${noticeBar.linkText}</a></c:if>
        </p>
        </c:if>
        <a href="#nav-bar-top" class="notice-close"><span class="icon icon-16 icon-close" aria-hidden="true"></span></a>
    </div>
</div>
</c:if>