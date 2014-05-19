<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/apps/tourismaustralia/components/global.jsp" %>
<%@ page import="com.australia.www.components.content.breadcrumb.Breadcrumb" %>

<c:set var="breadcrumb" value="<%=new Breadcrumb(slingRequest) %>"/>

<ul class="breadcrumb">
    <c:forEach items="${breadcrumb.predecessorPages}" var="predecessorPage" varStatus="status">
    	<c:if test = "${!predecessorPage.hideInNav}">
           	<c:choose>
                <c:when test="${status.first and status.last}">
				     <li><fmt:message key="Home"/></li>
           		</c:when>
                <c:when test="${status.first}">
				     <li>
			            <a href="${predecessorPage.path}.html">
                    		<fmt:message key="Home"/>
			            </a>
				     </li>
           		</c:when>
                <c:when test="${status.last}">
				     <li>${predecessorPage.title}</li>
           		</c:when>
           		<c:otherwise>
				     <li>
			            <a href="${predecessorPage.path}.html">
	            			${predecessorPage.title}
   			            </a>
				     </li>
           		</c:otherwise>
           	</c:choose>		
	    </c:if>      	
    </c:forEach>
</ul>

