<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/apps/foodandwine/components/global.jsp"%>
<%@ page import="com.australia.www.components.page.global.Global" %>
<%@ page import="com.day.cq.wcm.api.WCMMode" %>

<c:set var="global" value="<%=new Global(slingRequest) %>"/>

<body>
	<script type="application/javascript">
		// IE console.log disable errors
		if ( typeof console === "undefined" || typeof console.log === "undefined") {
			console = {};
			console.log = function() {
			};
		}
	</script>
	
	<% WCMMode modeBefore = WCMMode.fromRequest(slingRequest); %>
	
   	<c:if test="${not global.isHomePage}"> 
   		<% WCMMode.DISABLED.toRequest(slingRequest); %>
	</c:if>		
	<cq:include path="header" resourceType="foodandwine/components/content/header" />		
   	<% modeBefore.toRequest(slingRequest); %>	
	<!-- End #main-header -->
	
	<div class="site-wrapper">

		<div id="main-content"><cq:include script="content.jsp" /></div>
	   	<c:if test="${not global.isHomePage}"> 
	   		<% WCMMode.DISABLED.toRequest(slingRequest); %>
		</c:if>		
		<cq:include path="footer" resourceType="foodandwine/components/content/footer" />
	   	<% modeBefore.toRequest(slingRequest); %>	

	</div>
	<script type="text/javascript">_satellite.pageBottom();</script>
</body>