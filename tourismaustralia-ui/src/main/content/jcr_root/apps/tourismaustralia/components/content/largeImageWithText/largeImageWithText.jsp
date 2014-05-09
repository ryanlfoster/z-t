<%@include file="/apps/tourismaustralia/components/global.jsp"%>
<%@ page import="com.australia.www.components.content.largeimagewithtext.LargeImageWithText" %>
<%@ page import="com.day.cq.wcm.api.WCMMode" %>

<c:set var="liwt" value="<%=new LargeImageWithText(slingRequest) %>"/>

<div class="large-image-text">
	<div class="row l-center-1200">
	    <div class="col-xs-9 col-sm-9 col-sm-offset-3">
	        <img class="large-image-text-img" src="${liwt.imageSrc}" alt="${liwt.imageAltText}" />
	        <div class="large-image-text-content">
	            <p>${liwt.imageText}</p>
	        </div>
	    </div>
	</div>
</div>