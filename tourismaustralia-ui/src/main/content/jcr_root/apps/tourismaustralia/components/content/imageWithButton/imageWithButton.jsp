<%@include file="/apps/tourismaustralia/components/global.jsp"%>
<%@ page import="com.australia.www.components.content.imageWithButton.ImageWithButton" %>
<%@ page import="com.day.cq.wcm.api.WCMMode" %>

<c:set var="imageButton" value="<%=new ImageWithButton(slingRequest) %>"/>

<% if (WCMMode.fromRequest(slingRequest) == WCMMode.EDIT) {%>

    <div><h2>${imageButton.text}></h2></div></br/>

    <div><img src='${imageButton.imageSrc}' alt="${imageButton.imgAltText}" /></div></br/>

    <div>
        <p>
            <div>${imageButton.authorText}</div></br>
            <div>${imageButton.subText}</div></br>
            <div>${imageButton.buttonText}></div></br>
            <div>${imageButton.buttonPath}></div></br>
        </p>

    </div>
<% } %>


