<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<p class="type-spacing-30">
		<a href="#" class="icon-google-color"><img src="${item.iconImage}" alt=""></a>
	</p>	
	<p class="type-spacing-50">${item.richText}</p>
	</c:forEach>
</div>