<%@include file="/apps/tourismaustralia/components/global.jsp" %>
<%@ page import="com.australia.www.components.content.favourite.Favourite" %>
<%@ page import="com.day.cq.wcm.api.WCMMode" %>

<c:set var="favourite" value="<%=new Favourite(slingRequest) %>"/>

<a href="#" class="favourite favourite-btn" data-pagepath="${favourite.pagePath}">
    <span class="btn-bubble">
        <span class="btn-bubble-button">
            <img class="btn-bubble-std" src="/etc/designs/tourismaustralia/clientlibs/img/icons/favourite_white_outline.png" alt="">
            <img class="btn-bubble-active" src="/etc/designs/tourismaustralia/clientlibs/img/icons/favourite_white.png" alt="">
        </span>
    </span>
    <span class="favourite-text"><fmt:message key="add to your dream trip"/></span>
</a>