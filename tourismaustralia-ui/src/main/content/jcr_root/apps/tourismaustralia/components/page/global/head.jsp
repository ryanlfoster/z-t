<%@include file="/apps/tourismaustralia/components/global.jsp" %>
<%@ page import="com.australia.www.components.page.global.Global" %>

<c:set var="global" value="<%=new Global(slingRequest) %>"/>

<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
    <meta name="keywords" content="${global.keywords}"/>
    <meta name="description" content="${global.description}"/>
    <meta property="og:title" content="${global.title}"/>
    <meta property="og:type" content="website"/>
    <meta property="og:url" content="${global.url}"/>
    <c:if test="${not empty global.imagePath}">
        <meta property="og:image" content="${global.imagePath}"/>
    </c:if>

	<meta name="DC.Creator" content="Tourism Australia" />		 
 	<meta name="DC.Title" content="${global.title}"/> 
 	<meta name="DC.Description" content="${global.description}"/>
  	<meta name="DC.Date" content="${global.lastModified}"/> 
 	<meta name="DC.Type" content="text"/>
 
    <cq:include script="headlibs.jsp"/>
    <cq:include script="/libs/wcm/core/components/init/init.jsp"/>
    <cq:include script="stats.jsp"/>
    <c:if test="${not empty global.favIcon}">
        <link rel="icon" type="image/vnd.microsoft.icon" href="${global.favIcon}"/>
        <link rel="shortcut icon" type="image/vnd.microsoft.icon" href="${global.favIcon}"/>
    </c:if>
    <title>${global.title}</title>

    <cq:includeClientLib css="ta"/>

</head>
