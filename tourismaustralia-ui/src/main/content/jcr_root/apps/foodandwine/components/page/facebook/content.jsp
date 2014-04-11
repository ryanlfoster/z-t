<%@include file="/apps/foodandwine/components/global.jsp"%>
<%@ page import="com.australia.foodandwine.components.page.facebook.FacebookPage" %>

<c:set var="facebook" value="<%=new FacebookPage(slingRequest) %>"/>

<p>
	${facebook.userName}<br/>
	${facebook.postText}<br/>
	${facebook.postLink}<br/>
</p>