<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@include file="/apps/tourismaustralia/components/global.jsp" %>
<%@ page import="com.australia.www.components.page.breadcrumb.Breadcrumb" %>

<c:set var="breadcrumb" value="<%=new Breadcrumb(slingRequest) %>"/>

<ul class="breadcrumb">
    <c:forEach items="${breadcrumb.predecessorPages}" var="predecessorPage">
    	<c:if test = "${!predecessorPage.hideInNav}">
		     <li>
	            <a href="${predecessorPage.path}.html">
	            	<c:choose>
                    	<c:when test="${predecessorPage.depth == 3}">
                    		<fmt:message key="Home"/>
	            		</c:when>
	            		<c:otherwise>
	            			${predecessorPage.title}
	            		</c:otherwise>
	            	</c:choose>		
	            </a>
		     </li>
	     </c:if>
    </c:forEach>
	<li>${currentPage.title}</li>
</ul>

