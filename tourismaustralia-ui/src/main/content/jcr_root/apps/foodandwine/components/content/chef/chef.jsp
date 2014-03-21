<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/apps/foodandwine/components/global.jsp" %>
<%@ page import="com.australia.foodandwine.components.content.profile.Chef" %>

<c:set var="chef" value="<%=new Chef(slingRequest) %>"/>

<h3 class="faw-article-quotes">${chef.title}</h3>
<p class="faw-article-quotes"><em>${chef.content} </em></p>
<br/>
<h3 class="faw-article-quotes">Chef Profile</h3>
			<c:if test="${not empty chef.imagePath}">
<div class='faw-hero-home-bg'><img data-width='1580' data-height='1153' class='faw-bg-full' src="${chef.imagePath}" alt=""/></div>
			</c:if>

<p class="faw-article-quotes"><em>${chef.imageText} </em></p>
