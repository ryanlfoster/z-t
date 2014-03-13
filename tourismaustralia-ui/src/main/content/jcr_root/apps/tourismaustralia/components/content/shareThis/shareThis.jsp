<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/apps/tourismaustralia/components/global.jsp" %>
<%@ page import="com.australia.www.components.content.sharethis.ShareThis" %>
<%@ page import="com.australia.www.components.page.global.Global" %>

<c:set var="sharethis" value="<%=new ShareThis(slingRequest) %>"/>
<c:set var="global" value="<%=new Global(slingRequest) %>"/>

<div class="shareThisHolder" data-shareUrl="${sharethis.shareUrl}" 
	data-type="${sharethis.shareType}" data-accountId="${sharethis.accountId}"> 
	
       <script type="text/javascript">
		  var json = '${global.socialNetworks}';
		  
       </script>

        hello world
</div>