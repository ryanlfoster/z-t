<%@include file="/libs/foundation/global.jsp" %>
<%@ page import="com.day.cq.wcm.api.WCMMode" %>
<%@ page import="com.day.cq.i18n.I18n" %>
<%
//To allow other JSPs to provide translation
final I18n i18n = new I18n(slingRequest);
%>


<%
// Allows JSPs to determine if currently in edit mode
boolean isEdit = WCMMode.fromRequest(request) == WCMMode.EDIT;
%>
<c:set var="isEdit" value="<%= isEdit %>" />

<cq:setContentBundle source="request" />