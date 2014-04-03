<%@include file="/apps/foodandwine/components/global.jsp"%>
<%@ page import="com.australia.www.components.page.global.Global" %>

<c:set var="global" value="<%=new Global(slingRequest) %>"/>

<head>
	<c:choose>
		<c:when test="${global.prodPublish}">
			<script src="//assets.adobedtm.com/6fb6e65091abb6d979e09e86ef9f60bfab63fe46/satelliteLib-7fd9882a28dbbd42607f18b62a0ecd9666e033fe.js"></script>
		</c:when>
		<c:otherwise>
			<script src="//assets.adobedtm.com/6fb6e65091abb6d979e09e86ef9f60bfab63fe46/satelliteLib-a7cbeb25ca5db5731606b57a50a7f7440e287963-staging.js"></script>
		</c:otherwise>
	</c:choose>
	
    <meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <meta name="keywords" content="${global.keywords}"/>
    <meta name="description" content="${global.description}"/>
    <meta property="og:title" content="${global.title}"/>
    <meta property="og:type" content="website"/>
    <meta property="og:url" content="${global.url}"/>
    <c:if test="${not empty global.imagePath}">
        <meta property="og:image" content="${global.imagePath}"/>
    </c:if>

	<meta name="DC.Creator" content="Tourism Australia-Food and Wine" />		 
 	<meta name="DC.Title" content="${global.title}"/> 
 	<meta name="DC.Description" content="${global.description}"/>
  	<meta name="DC.Date" content="${global.lastModified}"/> 
 	<meta name="DC.Type" content="text"/>
 
    <cq:include script="headlibs.jsp"/>
    <cq:include script="/libs/wcm/core/components/init/init.jsp"/>
    <cq:include script="stats.jsp"/>
    <cq:includeClientLib categories="ta-foodandwine"/> 
    <!--[if IE]>
		 <cq:includeClientLib categories="ta-foodandwine-ie9"/> 
	<![endif]-->
    <c:if test="${not empty global.favIcon}">
        <link rel="icon" type="image/vnd.microsoft.icon" href="${global.favIcon}"/>
        <link rel="shortcut icon" type="image/vnd.microsoft.icon" href="${global.favIcon}"/>
    </c:if>
    <title>${global.title}</title>
</head>
