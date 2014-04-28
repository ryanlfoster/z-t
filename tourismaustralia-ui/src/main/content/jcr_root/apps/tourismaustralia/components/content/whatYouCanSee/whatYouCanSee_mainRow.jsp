<%@include file="/apps/tourismaustralia/components/global.jsp" %>
<%@ page import="com.australia.www.components.content.whatyoucansee.WhatYouCanSee" %>

<%
    WhatYouCanSee.ContentRow row = (WhatYouCanSee.ContentRow) request.getAttribute("row");
    request.setAttribute("single", row.getSingle());
    request.setAttribute("remainder", row.getRemainder());
%>
<div class="row">

    <c:if test="${alt}">
        <cq:include script="whatYouCanSee_grid_4.jsp" />
    </c:if>
    <cq:include script="whatYouCanSee_grid_1.jsp" />
    <c:if test="${!alt}">
        <cq:include script="whatYouCanSee_grid_4.jsp" />
    </c:if>

</div>