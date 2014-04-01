<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>
<%@include file="/apps/foodandwine/components/global.jsp" %>
<%@ page import="com.australia.foodandwine.components.content.numberIconText.NumberIconText" %>

<c:set var="nit" value="<%=new NumberIconText(slingRequest) %>"/>

<div class="l-page-width-600 l-center">
	<c:forEach items="${nit.icons}" var="item">
		<div class="form-number-container type-spacing-40">
			<hr/>
			<div class="form-number-square-box">
				<div class="form-number-square-box">
					<div class="form-number">${nit.number}</div>
				</div>
			</div>
		</div>	
		<p class="type-spacing-30">
			<c:set var="pathparts" value="${fn:split(item.icon, '/')}" />               
			<c:set var="filename" value="${pathparts[fn:length(pathparts) - 1]}" /> 
			<c:set var="basename" value="${fn:split(filename, '.')[0]}" />    
				<a href="#" class="icon-google-color"><img src="${item.icon}" alt="${basename} logo image"></a> 
		</p>	
	</c:forEach>
	<p class="type-spacing-50">${nit.text}</p>
</div>