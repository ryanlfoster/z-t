<%--
  Created by: Greg Snyder
  Date: 09/04/2014

--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/apps/tourismaustralia/components/global.jsp" %>

<%@ page import="com.australia.www.components.content.itineraryday.*" %>
<c:set var="day" value="<%=new ItineraryDay(slingRequest) %>"/>

<div class="l-padding-b itinerary-day navScroller-section" data-section-name="${day.anchorId}">
    <div class="largeparallax l-padding-b">
        <div class="img-holder">
        </div>
        <div class="img-src" data-picture="" data-alt="" >
            <div data-src="/etc/designs/tourismaustralia/clientlibs/img/placeholders/image_with_date.jpg" data-media="(min-width: 1px)"></div>
            <div data-src="/etc/designs/tourismaustralia/clientlibs/img/placeholders/image_with_date.jpg" data-media="(min-width: 481px)"></div>
            <div data-src="/etc/designs/tourismaustralia/clientlibs/img/placeholders/image_with_date.jpg" data-media="(min-width: 769px)"></div>
            <div data-src="/etc/designs/tourismaustralia/clientlibs/img/placeholders/image_with_date.jpg" data-media="(min-width: 993px)"></div>
            <noscript>
                <img src="/etc/designs/tourismaustralia/clientlibs/img/placeholders/image_with_date.jpg" alt="">
            </noscript>
            <img src="/etc/designs/tourismaustralia/clientlibs/img/placeholders/image_with_date.jpg" alt="">
        </div>
        <!--[if (lt IE 9) & (!IEMobile)]>
        <div class="legacy-img">
            <img src="/etc/designs/tourismaustralia/clientlibs/img/placeholders/image_with_date.jpg" alt="" />
        </div>
        <![endif]-->
    </div>
    <div class="largeparallax-images l-padding-b">
        <div class="column col-first">
            <img src="${day.image1}" alt="${day.image1AltText}">
        </div>
        <div class="column col-second">
            <img src="${day.image2}" alt="${day.image2AltText}">
        </div>
        <div class="column col-third">
            <img src="${day.image3}" alt="${day.image3AltText}">
        </div>
        <div class="column col-fourth">
            <img src="${day.image4}" alt="${day.image4AltText}">
        </div>
    </div>
    <div class="itinerary-day-content">
        <div class="row l-center-1200">
            <div class="col-xs-6  col-sm-offset-3 itinerary-day-textarea">
                <h4 class="type-h4">${day.textTitle}</h4>
                <p></p>
                <p></p>
                <p>${day.text}</p>
            </div>
            <div class="col-xs-3 itinerary-day-map">
                <c:if test="${not empty day.mapImage}">
                    <img src="${day.mapImage}" alt="">
                </c:if>
            </div>
            <ul class="itinerary-day-nav navScroller">
                <li><a href="#top"><fmt:message key="Back to Top"/></a></li>
                <c:forEach var="link" items="${day.dayLinks}">
                    <c:if test="${link.currentDay}">
                        <li class="active"><a href="#${link.anchor}">${link.text}</a></li>
                    </c:if>
                    <c:if test="${!link.currentDay}">
                        <li><a href="#${link.anchor}">${link.text}</a></li>
                    </c:if>
                </c:forEach>
            </ul>
        </div>
    </div>
</div>