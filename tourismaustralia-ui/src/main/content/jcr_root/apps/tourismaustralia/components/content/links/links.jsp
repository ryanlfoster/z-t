<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/apps/tourismaustralia/components/global.jsp" %>
<%@ page import="com.australia.www.components.content.links.Links" %>

<c:set var="mapWithParsys" value="<%=new Links(slingRequest) %>"/>

<div class="map-with-links-list-container">
    <ol class="map-with-links-list">
        <li><a href="#">Melbourne</a></li>
        <li><a href="#">Yarra Valley & Dandenong Ranges</a></li>
        <li><a href="#">Phillip Island</a></li>
        <li><a href="#">High Country</a></li>
        <li><a href="#">Phillip Island</a></li>
        <li><a href="#">Great Ocean Road</a></li>
        <li><a href="#">Goldfield</a></li>
        <li><a href="#">Grampians</a></li>
        <li><a href="#">High Country</a></li>
        <li><a href="#">Gippsland</a></li>
        <li><a href="#">The Murray</a></li>
    </ol>
</div>