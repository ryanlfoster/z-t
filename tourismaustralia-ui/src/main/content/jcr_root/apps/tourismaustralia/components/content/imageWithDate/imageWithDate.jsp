<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/apps/tourismaustralia/components/global.jsp" %>
<%@ page import="com.australia.www.components.content.imagewithdate.ImageWithDate" %>
<%@ page import="com.day.cq.wcm.api.WCMMode" %>

<c:set var="imageWithDate" value="<%=new ImageWithDate(slingRequest) %>"/>

<% if (WCMMode.fromRequest(slingRequest) == WCMMode.EDIT) {%>
<c:if test="${not empty imageWithDate.image && not empty imageWithDate.altText }">
    <div><img src='${imageWithDate.image}' alt="${imageWithDate.altText}"/></div>
</c:if>

<c:if test="${not empty imageWithDate.date}">
    <p>${imageWithDate.date}</p>
</c:if>

<c:if test="${not empty imageWithDate.title || not empty imageWithDate.text}">
    <p>
        <c:if test="${not empty imageWithDate.title}">
            <strong>${imageWithDate.title}</strong><br/>
        </c:if>

        <c:if test="${not empty imageWithDate.text}">
            ${imageWithDate.text}
        </c:if>
    </p>
</c:if>
<% } %>