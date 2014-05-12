<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/apps/tourismaustralia/components/global.jsp" %>
<%@ page import="com.australia.www.components.content.largeTitle.LargeTitle" %>
<c:set var="largeTitle" value="<%=new LargeTitle(slingRequest)%>"/>

<c:if test="${not empty largeTitle.title}">
    <div class="largetitle l-table l-padding-lr-15">
        <h1>
            ${largeTitle.title}
        </h1>
    </div>
</c:if>