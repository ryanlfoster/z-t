<%@include file="/apps/foodandwine/components/global.jsp"%>
<%@ page import="com.australia.foodandwine.components.content.stateLinks.StateLinks"%>

<c:set var="stateLinks" value="<%=new StateLinks(slingRequest) %>" />

<div class="l-display-none-md">
	<p class="icon-map-wrapper">
		<a href="#" class="icon-map icon-map-black icon-map-capital"> <span>Australian Captital Territory</span> </a>
		<a href="#" class="icon-map icon-map-black icon-map-nsw"> <span>New South Wales</span> </a>
		<a href="#" class="icon-map icon-map-black icon-map-northern"> <span>Northern Territory</span> </a>
		<a href="#" class="icon-map icon-map-black icon-map-queensland"> <span>Queensland</span> </a>
		<a href="#" class="icon-map icon-map-black icon-map-south"> <span>South Australia</span> </a>
		<a href="#" class="icon-map icon-map-black icon-map-tasmania"> <span>Tasmania</span> </a>
		<a href="#" class="icon-map icon-map-black icon-map-victoria"> <span>Victoria</span> </a>
		<a href="#" class="icon-map icon-map-black icon-map-western"> <span>Western Australia</span> </a>
	</p>

    <script type="text/javascript">
		$('.icon-map-${stateLinks.state}').addClass('icon-map-black-active');
    </script>
</div>