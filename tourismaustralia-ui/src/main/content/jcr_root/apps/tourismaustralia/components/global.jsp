<%@include file="/libs/foundation/global.jsp" %>
<%@ page import="com.day.cq.wcm.api.WCMMode" %>

<%
// Allows JSPs to determine if currently in edit mode
boolean isEdit = WCMMode.fromRequest(request) == WCMMode.EDIT;
%>
<c:set var="isEdit" value="<%= isEdit %>" />

<cq:setContentBundle/>