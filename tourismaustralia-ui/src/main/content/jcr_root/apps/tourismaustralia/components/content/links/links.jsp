<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/apps/tourismaustralia/components/global.jsp" %>
<%@ page import="com.australia.www.components.content.links.Links" %>

<c:set var="linksComponent" value="<%=new Links(slingRequest) %>"/>

<div class="map-with-links-list-container">
    <ol class="map-with-links-list">
        <c:forEach items="${linksComponent.linksList}" var="link">
            <li><a href="${link.path}">${link.title}</a></li>
        </c:forEach>
    </ol>
</div>