<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/apps/tourismaustralia/components/global.jsp" %>
<%@ page import="com.australia.www.components.content.summary.Summary" %>

<c:set var="summary" value="<%=new Summary(slingRequest) %>"/>

<c:if test="${not empty summary.text}">
    <div class="type-summary">
        ${summary.text}
    </div>
</c:if>
