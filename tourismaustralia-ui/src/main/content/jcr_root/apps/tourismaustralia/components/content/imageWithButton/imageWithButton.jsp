<%--
  Created by: Marjia Yeasmin
  Date: 18/03/2014

  This page facilitates in rendering an authored image with text, credits,
  and a button with a link by using ImageWithButton Component.

--%>

<%@include file="/apps/tourismaustralia/components/global.jsp"%>
<%@ page import="com.australia.www.components.content.imageWithButton.ImageWithButton" %>
<%@ page import="com.day.cq.wcm.api.WCMMode" %>

<c:set var="imageButton" value="<%=new ImageWithButton(slingRequest) %>"/>

<% if (WCMMode.fromRequest(slingRequest) == WCMMode.EDIT) {%>
    <div><img src='${imageButton.imageSrc}' alt="${imageButton.imgAltText}" /></div>

    <c:if test="${not empty imageButton.text}">
        <div>Text: ${imageButton.text}</div>
    </c:if>

    <c:if test="${not empty imageButton.authorText}">
        <div>Author Text: ${imageButton.authorText}</div>
    </c:if>

    <c:if test="${not empty imageButton.subText}">
        <div>Sub Text: ${imageButton.subText}</div>
    </c:if>

    <c:if test="${not empty imageButton.buttonText}">
        <div>Button Text: ${imageButton.buttonText}</div>
    </c:if>

    <c:if test="${not empty imageButton.buttonPath}">
        <div>Button Path: ${imageButton.buttonPath}</div>
    </c:if>

<% } %>


