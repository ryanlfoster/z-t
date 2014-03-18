<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/apps/foodandwine/components/global.jsp" %>
<%@ page import="com.australia.foodandwine.components.content.sponsorsSpace.SponsorsSpace" %>


<c:set var="sponsorsSpace" value="<%=new SponsorsSpace(slingRequest) %>"/>

<div class="faw-sponsors">
    <div class='faw-sponsors-outer'>
        <div class='faw-sponsors-wrapper'>
            <ul class="carousel-wrapper faw-sponsors-carousel" data-mobilemaxresolution="1200" data-startIndex="0" data-disablecarouselondesktop="true">
			<c:forEach items="${sponsorsSpace.sponsorsList }" var="item">
                <li class = "faw-sponsors-carousel-item">
				<div class="row sponsors-item type-spacing-30">
				    <div class="sponsors-row-1 type-spacing-15">
				       <c:if test="${not empty item.bigTitle}">
				        <div class="sponsors-type-title type-spacing-15">${item.bigTitle }</div>
				        </c:if>
				        <hr class="sponsors-hr">
				    </div>
				    <div  class="row sponsors-row-2">
				        <div class="sponsors-image-link-container">
				            <c:if test="${not empty item.imagePath}">
				            <img src="${item.imagePath }" class="sponsors-image" alt="">
				            </c:if>
				             <c:if test="${not empty item.imageTitle }">
				            <p>${item.imageTitle }</p>
				            </c:if>
				        </div>
				    </div>
				    <div  class="row sponsors-row-3">
				        <c:if test="${ not empty item.linkText }">
				        <a href="${item.linkTextPath }" class="sponsors-link">${item.linkText }</a>
				        </c:if>
				    </div>
					</div>
					</li>
			</c:forEach>
            </ul>
        </div>
    </div>
</div>