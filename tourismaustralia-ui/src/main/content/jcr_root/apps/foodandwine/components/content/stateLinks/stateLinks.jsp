<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/apps/foodandwine/components/global.jsp"%>
<%@ page import="com.australia.foodandwine.components.content.stateLinks.StateLinks"%>

<c:set var="stateLinks" value="<%=new StateLinks(slingRequest) %>" />

<div class="l-display-none-md">
	<p class="icon-map-wrapper">
		<a href="${stateLinks.capital}.html" class="icon-map icon-map-black icon-map-capital${currentPage.path==stateLinks.capital ?' icon-map-black-active':''}"><span>Australian Capital Territory</span></a>
		<a href="${stateLinks.nsw}.html" class="icon-map icon-map-black icon-map-nsw${currentPage.path==stateLinks.nsw ?' icon-map-black-active':''}"><span>New South Wales</span></a>
		<a href="${stateLinks.northern}.html" class="icon-map icon-map-black icon-map-northern${currentPage.path==stateLinks.northern ?' icon-map-black-active':''}"><span>Northern Territory</span></a>
		<a href="${stateLinks.queensland}.html" class="icon-map icon-map-black icon-map-queensland${currentPage.path==stateLinks.queensland ?' icon-map-black-active' :''}"><span>Queensland</span></a>
		<a href="${stateLinks.south}.html" class="icon-map icon-map-black icon-map-south${currentPage.path==stateLinks.south ?' icon-map-black-active':''}"><span>South Australia</span></a>
		<a href="${stateLinks.tasmania}.html" class="icon-map icon-map-black icon-map-tasmania${currentPage.path==stateLinks.tasmania ?' icon-map-black-active':''}"><span>Tasmania</span></a>
		<a href="${stateLinks.victoria}.html" class="icon-map icon-map-black icon-map-victoria${currentPage.path==stateLinks.victoria ?' icon-map-black-active':''}"><span>Victoria</span></a>
		<a href="${stateLinks.western}.html" class="icon-map icon-map-black icon-map-western${currentPage.path==stateLinks.western ?' icon-map-black-active':''}"><span>Western Australia</span></a>
	</p>
</div>