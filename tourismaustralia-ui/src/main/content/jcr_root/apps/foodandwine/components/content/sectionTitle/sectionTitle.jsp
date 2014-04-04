<%@include file="/apps/foodandwine/components/global.jsp" %>
<%@ page import="com.australia.foodandwine.components.content.sectiontitle.SectionTitle" %>

<c:set var="title" value="<%=new SectionTitle(slingRequest) %>"/>

<div class="head-divider">
	<div class="head-divider-inner">
	    <hr class="icon-logo-withlines-hr icon-logo-withlines-hr-small">
	    <h5>${title.title }</h5>
	    <hr class="icon-logo-withlines-hr icon-logo-withlines-hr-small">
    </div>
</div>