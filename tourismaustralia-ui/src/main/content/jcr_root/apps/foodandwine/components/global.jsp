<%@include file="/libs/foundation/global.jsp" %>
<%@ page import="com.day.cq.wcm.api.WCMMode" %>

<c:set var="isEdit" value="<%= WCMMode.fromRequest(request) == WCMMode.EDIT %>" />