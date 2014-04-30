<%@include file="/apps/tourismaustralia/components/global.jsp" %>

<c:if test="${contentItem.event}">
    <cq:include script="whatYouCanSee_eventTile.jsp" />
</c:if>
<c:if test="${!contentItem.event}">
    <cq:include script="whatYouCanSee_standardTile.jsp" />
</c:if>