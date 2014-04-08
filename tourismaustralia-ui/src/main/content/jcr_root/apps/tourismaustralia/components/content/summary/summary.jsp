<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/apps/tourismaustralia/components/global.jsp" %>
<%@ page import="com.australia.www.components.content.summary.Summary" %>
<%@ page import="com.day.cq.wcm.api.WCMMode" %>

<c:set var="summary" value="<%=new Summary(slingRequest) %>"/>

<c:if test="${not empty summary.text}">
    <div class="row">
        <div class="type-summary">
            ${summary.text}
        </div>
    </div>
    <hr class="full">
</c:if>
