<%--
  Created by: Greg Snyder
  Date: 09/04/2014

--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="/apps/tourismaustralia/components/global.jsp" %>

<%@ page import="com.australia.www.components.content.itinerary.*" %>
<c:set var="i" value="<%=new Itinerary(slingRequest) %>"/>

<cq:include path="." resourceType="foundation/components/parsys" />