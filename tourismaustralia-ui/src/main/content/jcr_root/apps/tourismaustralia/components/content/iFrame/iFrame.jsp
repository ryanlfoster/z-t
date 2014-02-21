<%@include file="/apps/tourismaustralia/components/global.jsp"%>
<%@ page import="com.australia.www.components.content.iframe.IFrame" %>
<%@ page import="com.day.cq.wcm.api.WCMMode" %>

<c:set var="iframe" value="<%=new IFrame(slingRequest) %>"/>

<% if(WCMMode.fromRequest(slingRequest)==WCMMode.EDIT) {%>

    <div>
        <iframe src="${iframe.applicationUrl}" style="max-width:${iframe.maxWidth}px;"
                width="100%" height="${iframe.height}" frameborder="0"></iframe>
    </div>

<% } %>