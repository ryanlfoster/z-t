<%@include file="/apps/foodandwine/components/global.jsp" %>
<%@ page import="com.australia.foodandwine.components.content.numberIconText.NumberIconText" %>

<c:set var="nit" value="<%=new NumberIconText(slingRequest) %>"/>

<div class="l-page-width-600 l-center">
		<div class="form-number-container type-spacing-40">
			<hr/>
			<div class="form-number-square-box">
				<div class="form-number-square-box">
					<div class="form-number">${nit.number}</div>
				</div>
			</div>
		</div>	
		<c:choose>
		    <c:when test="${fn:length(nit.icons) eq 1}">
				<p class="type-spacing-30">
					<c:set var="icon" value="${nit.icons[0]}"/>
		 			<c:choose>
						<c:when test="${not empty  icon.link}">
							<a href="${icon.link}" target="${icon.external ? '_blank' : 'self'}"><img src="${icon.icon}" alt="${icon.alt}"></a>
						</c:when>
						<c:otherwise>
							<img src="${icon.icon}" alt="${icon.alt}">
						</c:otherwise>
					</c:choose>
		 		</p>	
		    </c:when>
		    <c:when test="${fn:length(nit.icons) gt 1}">
				<ul class="form-social-list type-spacing-40">
					<c:forEach items="${nit.icons}" var="icon">
						<c:choose>
							<c:when test="${not empty  icon.link}">
								<li><a href="${icon.link}" target="${icon.external ? '_blank' : 'self'}"><img src="${icon.icon}" alt="${icon.alt}"></a></li>
							</c:when>
							<c:otherwise>
								<li><img src="${icon.icon}" alt="${icon.alt}"></li>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</ul>	
		    </c:when>
		</c:choose>		
		<p class="type-spacing-50">${nit.text}</p>
</div>