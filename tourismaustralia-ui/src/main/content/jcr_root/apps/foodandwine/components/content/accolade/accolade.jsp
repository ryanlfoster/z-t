<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/apps/foodandwine/components/global.jsp" %>
<%@ page import="com.australia.foodandwine.components.content.accolade.Accolade" %>

<c:set var="accolade" value="<%=new Accolade(slingRequest) %>"/>

<div class="head-divider">
	<div class="head-divider-inner">
	    <hr class="icon-logo-withlines-hr icon-logo-withlines-hr-small">
	    <h5>Accolades</h5>
	    <hr class="icon-logo-withlines-hr icon-logo-withlines-hr-small">
	</div>
</div>
    
<div class="l-center">
	<ul class="historylist">
		<c:forEach items="${accolade.accoladeList}" var="item">
			<li>
				<p><strong>${item.year}</strong></p>
				<p>${item.title}</p>
				<hr/>
			</li>
		</c:forEach>
	</ul>
</div>    