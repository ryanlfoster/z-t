<%@ page import="com.day.cq.wcm.api.WCMMode" %>
<%@include file="/libs/foundation/global.jsp" %>

<%
    boolean isEdit = WCMMode.fromRequest(request) == WCMMode.EDIT;
%>
<c:set var="isEdit" value="<%= isEdit %>" />