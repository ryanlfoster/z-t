<%@include file="/apps/foodandwine/components/global.jsp"%>


<body>
	<cq:include path="header" resourceType="foodandwine/components/content/header" />		<!-- End #main-header -->

	<div class="site-wrapper">
	
		<div id="main-content"><cq:include script="content.jsp" /></div>
		<cq:include path="footer" resourceType="foodandwine/components/content/footer" />
		
	</div>
</body>