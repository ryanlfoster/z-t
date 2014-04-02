<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@include file="/apps/foodandwine/components/global.jsp"%>
<%@ page
	import="com.australia.foodandwine.components.content.numberIconText.NumberIconText"%>

<c:set var="nit" value="<%=new NumberIconText(slingRequest) %>" />

<div class="l-page-width-600 l-center">


	<c:choose>
		<c:when test="${fn:length(nit.icons) > 1}">
			<div class="form-number-container type-spacing-40">
					<hr />
					<div class="form-number-square-box">
						<div class="form-number-square-box">
							<div class="form-number">${nit.number}</div>
						</div>
					</div>
				</div>
			<ul class="form-social-list type-spacing-40">
			<c:forEach items="${nit.icons}" var="item">
			<c:choose>
			<c:when test="${item.external eq 'true'}">
			<li>
				<a href="${item.link }" target="_blank"><img src="${item.icon }" alt=""></a>
			</li>
			</c:when>
			<c:otherwise>
			<li>
				<a href="${item.link }" ><img src="${item.icon }" alt=""></a>
			</li>
			</c:otherwise>
			</c:choose>
			</c:forEach>
		</ul>
		</c:when>
		<c:otherwise>
			<c:forEach items="${nit.icons}" var="item">
				<div class="form-number-container type-spacing-40">
					<hr />
					<div class="form-number-square-box">
						<div class="form-number-square-box">
							<div class="form-number">${nit.number}</div>
						</div>
					</div>
				</div>
				<p class="type-spacing-30">
					<c:set var="pathparts" value="${fn:split(item.icon, '/')}" />
					<c:set var="filename"
						value="${pathparts[fn:length(pathparts) - 1]}" />
					<c:set var="basename" value="${fn:split(filename, '.')[0]}" />
					<c:choose>
					<c:when test="${item.external eq 'true'}">
					<a href="${item.link }" class="icon-google-color" target="_blank"><img src="${item.icon}"
						alt="${basename} logo image"></a>
					</c:when>
					<c:otherwise>
					<a href="${item.link }" class="icon-google-color" ><img src="${item.icon}"
						alt="${basename} logo image"></a>
					
					</c:otherwise>
					</c:choose>
				</p>
			</c:forEach>
		</c:otherwise>
	</c:choose>

	<p class="type-spacing-50">${nit.text}</p>
</div>