<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/apps/tourismaustralia/components/global.jsp" %>
<%@ page import="com.australia.www.components.content.imagewithdate.ImageWithDate" %>
<%@ page import="com.day.cq.wcm.api.WCMMode" %>

<c:set var="imageWithDate" value="<%=new ImageWithDate(slingRequest) %>"/>

<% if (WCMMode.fromRequest(slingRequest) == WCMMode.EDIT) {%>

<div class="image-ugc image-with-date ${imageWithDate.makeTextWhite == true ? 'make-white': 'make-black'}">
    <c:if test="${not empty imageWithDate.image && not empty imageWithDate.altText }">
        <div class="image-bg fullwidth-bg" data-image-vertical-alignment="bottom"
             data--200-top="-webkit-transform: translate(0,10%);"
             data-200-bottom="-webkit-transform: translate(0,-10%);">
            <div class="responsive-image" data-picture="" data-alt="${imageWithDate.altText}">
                <div data-src="${imageWithDate.image}.adapt.480.low.jpg" data-media="(min-width: 1px)"></div>
                <div data-src="${imageWithDate.image}.adapt.768.medium.jpg" data-media="(min-width: 481px)"></div>
                <div data-src="${imageWithDate.image}.adapt.992.high.jpg" data-media="(min-width: 769px)"></div>
                <div data-src="${imageWithDate.image}.adapt.1663.high.jpg" data-media="(min-width: 993px)"></div>
                <noscript>
                    <img src="${imageWithDate.image}.adapt.1663.high.jpg" alt="${imageWithDate.altText}">
                </noscript>
            </div>
            <!--[if (lt IE 9) & (!IEMobile)]>
            <img src="${imageWithDate.image}.adapt.1663.high.jpg" alt="${imageWithDate.altText}">
            <![endif]-->
        </div>
    </c:if>

    <c:if test="${not empty imageWithDate.date || not empty imageWithDate.title || not empty imageWithDate.text}">
        <div class="image-content-container">
            <div class="image-content">
                <hr>
                <div class="image-quote">
                    <c:if test="${not empty imageWithDate.date}">
                        <span class="image-quote-date">${imageWithDate.date}</span>
                    </c:if>
                    <c:if test="${not empty imageWithDate.title}">
                        <span class="image-quote-title">${imageWithDate.title}</span>
                    </c:if>

                    <c:if test="${not empty imageWithDate.text}">
                        <span class="image-quote-description">
                                ${imageWithDate.text}
                        </span>
                    </c:if>
                </div>
                <hr>
            </div>
        </div>
    </c:if>
</div>
<% } %>
