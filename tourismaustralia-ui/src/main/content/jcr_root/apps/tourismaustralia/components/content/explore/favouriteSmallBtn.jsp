<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/apps/tourismaustralia/components/global.jsp" %>
<%@ page import="com.australia.www.components.content.favourite.Favourite" %>
<%@ page import="com.day.cq.wcm.api.WCMMode" %>

<c:set var="favourite" value="<%=new Favourite(slingRequest, (String)request.getAttribute("pagepath")) %>"/>

<a href="#" class="btn-bubble bubble-colour-favourite" data-pagepath="${favourite.pagePath}">
	<span class="btn-bubble-tooltip">
		<span class="btn-bubble-tooltip-container">
			<fmt:message key="add to your dream trip"/>
		</span>
	</span>
	<span class="btn-bubble-button">
		<img class="btn-bubble-std" src="/etc/designs/tourismaustralia/clientlibs/imgs/icons/favourite_outline.png" alt=""/>
		<img class="btn-bubble-active" src="/etc/designs/tourismaustralia/clientlibs/imgs/icons/favourite.png" alt=""/>
	</span>
</a>