<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/apps/foodandwine/components/global.jsp" %>
<%@ page import="com.australia.foodandwine.components.content.text.Text" %>

<c:set var="text" value="<%=new Text(slingRequest) %>"/>
<c:set var="medium" value="medium"/>
<c:if test="${text.textStyle  eq  'large' }">
	<div class="faw-hero-home-container">
		<h3 class="form-h3">${text.text } </h3>
	</div>
</c:if>

<c:if test="${text.textStyle  eq  'small' }">
        <p class="form-hero-register">${text.text }</p>
	
</c:if>
<c:if test="${text.textStyle  eq  'articlelarge' }">
<div class="form-hero">
<div class="faw-hero-home-container">
<h3 class="faw-article-healdine">${text.text }</h3>
</div>
</div>
</c:if>
<c:if test="${text.textStyle  eq  'articlesmall' }">
<p class="faw-article-copy">${text.text }</p>
</c:if>
<%-- <h3 class="faw-article-healdine">${text.text }</h3> --%>



