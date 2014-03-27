<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/apps/foodandwine/components/global.jsp" %>
<%@ page import="com.australia.foodandwine.components.content.contact.Contact" %>

<c:set var="contact" value="<%=new Contact(slingRequest) %>"/>

<h3 class="faw-article-quotes">"${contact.title}"</h3>
<p class="faw-article-quotes"><em>${contact.text} </em></p>
<br/>
<div class='faw-hero-home-bg'><img data-width='1580' data-height='1153' class='faw-bg-full' src="${contact.imagePath}" alt=""/></div>
<p class="faw-article-quotes"><em>${contact.iconText} </em></p>
<br/>
<p class="faw-article-quotes"><em>${contact.additionalText} </em></p>
