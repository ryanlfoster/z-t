<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/apps/tourismaustralia/components/global.jsp" %>
<%@ page import="com.australia.www.components.content.text.Text" %>
<%@ page import="com.day.cq.wcm.api.WCMMode" %>

<c:set var="text" value="<%=new Text(slingRequest) %>"/>

<c:if test="${not empty text.text}">
    <div class="type-body">
        ${text.text}
    </div>
</c:if>

