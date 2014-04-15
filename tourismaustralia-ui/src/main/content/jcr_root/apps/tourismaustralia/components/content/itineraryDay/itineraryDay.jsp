<%--
  Created by: Greg Snyder
  Date: 09/04/2014

--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="/apps/tourismaustralia/components/global.jsp" %>

<%@ page import="com.australia.www.components.content.itineraryday.*" %>
<c:set var="day" value="<%=new ItineraryDay(slingRequest) %>"/>

<span id="${day.anchorId}">${day.heroTitle}</span>
<br>
<a href="#">To Top</a>
<br>
<c:forEach items="${day.dayLinks}" var="item">
    <c:if test="${item.currentDay}">
        <span>${item.text}</span>
        <br>
    </c:if>
    <c:if test="${!item.currentDay}">
        <a href="#${item.anchor}">${item.text}</a>
        <br>
    </c:if>
</c:forEach>