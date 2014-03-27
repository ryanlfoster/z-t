<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>
<%@include file="/apps/foodandwine/components/global.jsp" %>
<%@ page import="com.australia.foodandwine.components.content.numberIconText.NumberIconText" %>

<c:set var="nit" value="<%=new NumberIconText(slingRequest) %>"/>

<div class="l-page-width-600 l-center">
	<c:forEach items="${nit.iconTextList}" var="item">
		<div class="form-number-container type-spacing-40">
			<hr/>
			<div class="form-number-square-box">
				<div class="form-number-square-box">
					<div class="form-number">${item.number}</div>
				</div>
			</div>
		</div>	
		
		<c:choose>
		    <c:when test="${fn:length(item.iconImages) eq 1}">
				<p class="type-spacing-30">
		 			<a href="#" class="icon-google-color"><img src="${item.iconImages[0]}" alt=""></a> 
		 		</p>	
		    </c:when>
		    <c:when test="${fn:length(item.iconImages) gt 1}">
				<ul class="form-social-list type-spacing-40">
					<c:forEach items="${item.iconImages}" var="icon">
						<li><a href="#" class="icon-google-color"><img src="${icon}" alt=""></a></li>
					</c:forEach>
				</ul>	
		    </c:when>
		</c:choose>		
		
		<p class="type-spacing-50">${item.richText}</p>
	</c:forEach>
</div>