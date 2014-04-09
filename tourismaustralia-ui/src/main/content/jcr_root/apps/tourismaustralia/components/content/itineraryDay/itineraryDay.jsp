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
<c:forEach items="${day.dayLinks}" var="item">
    <a href="#${item.anchor}">${item.text}</a>
    <br>
</c:forEach>