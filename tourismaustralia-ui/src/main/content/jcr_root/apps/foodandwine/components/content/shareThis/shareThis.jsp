<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/apps/foodandwine/components/global.jsp" %>
<%@ page import="com.australia.foodandwine.components.content.sharethis.ShareThis" %>
<%@ page import="com.australia.www.components.page.global.Global" %>

<c:set var="sharethis" value="<%=new ShareThis(slingRequest) %>"/>
<c:set var="global" value="<%=new Global(slingRequest) %>"/>

<div class="shareThisFawHolder" data-shareUrl="${sharethis.shareUrl}" 
 	data-type="${sharethis.shareType}" data-accountId="${sharethis.accountId}">  
 	    <script type="text/javascript">
		  	var sharethis_json = '${sharethis.socialNetworks}';
	 	    var page_title = '${global.title}';
  			var page_desc = '${global.description}';
        </script>
 		<script type="text/javascript" src="http://w.sharethis.com/button/buttons.js"></script>
 		<br/>
 		
 		<a class='faw-article-divider'></a>
 		<a href="#" class="faw-bookmark-icon">
 			<img class="faw-article-share-round faw-bookmark-icon-light" src="/etc/designs/foodandwine/clientlibs/imgs/base/share/share-round-bookmark.png" alt="">
 			<img class="faw-article-share-round faw-bookmark-icon-black" src="/etc/designs/foodandwine/clientlibs/imgs/base/share/share-round-bookmark-black.png" alt="">
 		</a>
</div> 

<cq:includeClientLib js="faw-share-this"/>

<p class='faw-article-share-label l-color-black'>Share or bookmark this page</p>
<hr class='divider-small'></hr> 		
