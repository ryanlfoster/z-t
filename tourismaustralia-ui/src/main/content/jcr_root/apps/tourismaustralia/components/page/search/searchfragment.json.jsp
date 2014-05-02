<%@include file="/apps/tourismaustralia/components/global.jsp"%>
<%@ taglib prefix="tacore" uri="http://www.austalia.com/taglibs/tourismaustralia-core/1.0" %>

<tacore:search var="rows" term="${param.term}" page="${param.page}" limit="${param.limit}" mode="${param.mode}" />

<c:if test="${param.mode eq 'LIST'}">
    <c:forEach items="${rows}" var="item">
        <c:set var="contentItem" value="${item}" scope="request"/>
        <cq:include script="/apps/tourismaustralia/components/content/search/searchListResult.jsp"/>
    </c:forEach>
</c:if>
<c:if test="${param.mode eq 'GRID'}">
    <cq:include script="/apps/tourismaustralia/components/content/fourToOneGrid/fourToOneGrid.jsp" />
</c:if>