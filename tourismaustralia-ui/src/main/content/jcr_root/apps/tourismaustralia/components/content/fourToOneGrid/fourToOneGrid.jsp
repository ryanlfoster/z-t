<%@include file="/apps/tourismaustralia/components/global.jsp"%>

<c:forEach items="${rows}" var="row">
    <c:set scope="request" var="row" value="${row}" />
    <div class="row">
        <cq:include script="/apps/tourismaustralia/components/content/fourToOneGrid/fourToOneGrid_mainRow.jsp"/>
    </div>
    <c:set var="alt" value="${!alt}" scope="request"/>
</c:forEach>