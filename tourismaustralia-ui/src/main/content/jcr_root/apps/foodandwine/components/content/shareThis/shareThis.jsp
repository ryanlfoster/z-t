<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/apps/foodandwine/components/global.jsp" %>
<%@ page import="com.australia.foodandwine.components.content.sharethis.ShareThis" %>
<%@ page import="com.australia.www.components.page.global.Global" %>

<c:set var="sharethis" value="<%=new ShareThis(slingRequest) %>"/>
<c:set var="global" value="<%=new Global(slingRequest) %>"/>

<cq:includeClientLib js="faw-share-this"/>

<div class="shareThisFawHolder" data-shareUrl="${sharethis.shareUrl}" 
 	data-type="${sharethis.shareType}" data-accountId="${sharethis.accountId}">  
 	    <script type="text/javascript">
  			  var page_title = '${global.title}';
  			  var page_desc = '${global.description}';
        </script>

 		<script type="text/javascript" src="http://w.sharethis.com/button/buttons.js"></script> 
</div> 

<p class='faw-article-share-label l-color-black'>Share or bookmark this page</p>
<hr class='divider-small'></hr> 		