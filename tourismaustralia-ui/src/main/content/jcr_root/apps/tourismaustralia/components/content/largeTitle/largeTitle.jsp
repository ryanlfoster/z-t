<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/apps/tourismaustralia/components/global.jsp"%>
<%@ page import="com.australia.www.components.content.largeTitle.LargeTitle"%>
<c:set var="largeTitle" value="<%=new LargeTitle(slingRequest)%>" />

<div class="largetitle l-table l-padding-lr-15">
	<h1>
		<c:choose>
		<c:when test="${largeTitle.hasTitle}">
    		${largeTitle.title}
		</c:when>
		<c:otherwise>
			<fmt:message key="Large Title" />
		</c:otherwise>
		</c:choose>
	</h1>
</div>