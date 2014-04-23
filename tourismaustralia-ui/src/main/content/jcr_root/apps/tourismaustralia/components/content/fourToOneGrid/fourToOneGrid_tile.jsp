<%--

  File fourToOneGrid_tile.jsp must be called with the following context dependencies:

  - contentItem: the Content item to render as a tile

--%>

<%@include file="/apps/tourismaustralia/components/global.jsp" %>

<c:if test="${contentItem.event}">
    <cq:include script="/apps/tourismaustralia/components/content/fourToOneGrid/fourToOneGrid_eventTile.jsp" />
</c:if>
<c:if test="${!contentItem.event}">
    <cq:include script="/apps/tourismaustralia/components/content/fourToOneGrid/fourToOneGrid_standardTile.jsp" />
</c:if>