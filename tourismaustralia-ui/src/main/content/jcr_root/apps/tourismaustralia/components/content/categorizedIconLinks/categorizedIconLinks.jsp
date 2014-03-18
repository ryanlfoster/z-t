<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/apps/tourismaustralia/components/global.jsp" %>
<%@ page import="com.day.cq.wcm.api.WCMMode" %>
<%@ page import="com.australia.www.components.content.categorizediconlinks.CategorizedIconLinks" %>

<c:set var="categorizedIconLinks" value="<%= new CategorizedIconLinks(slingRequest) %>"/>

${categorizedIconLinks.titleText2}