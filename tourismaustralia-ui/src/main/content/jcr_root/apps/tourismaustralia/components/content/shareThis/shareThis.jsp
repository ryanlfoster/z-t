<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/apps/tourismaustralia/components/global.jsp" %>
<%@ page import="com.australia.www.components.content.sharethis.ShareThis" %>
<%@ page import="com.australia.www.components.page.global.Global" %>

<c:set var="sharethis" value="<%=new ShareThis(slingRequest) %>"/>
<c:set var="global" value="<%=new Global(slingRequest) %>"/>

<div class="shareThisHolder" data-shareUrl="${sharethis.shareUrl}" 
	data-type="${sharethis.shareType}" data-accountId="${sharethis.accountId}"> 
	    <script type="text/javascript">
 			  var sharethis_json = '${global.socialNetworks}';
 			  var page_title = '${global.title}';
 			  var page_desc = '${global.description}';
       	</script>
       	<script type="text/javascript">var switchTo5x=true;</script>
		<script type="text/javascript" src="http://w.sharethis.com/button/buttons.js"></script>
		<script type="text/javascript">stLight.options({publisher: "${sharethis.accountId}", doNotHash: false, doNotCopy: false, hashAddressBar: false});</script>

		<div class="shareicons">
		    <ul> 
		    	<!-- Email icon always shows -->
			    <li class="btn-bubble email-bubble">
					<span class="btn-bubble-button st_email_large" displayText="Email" st_url="${sharethis.shareUrl}" st_title="${global.title}" st_summary="${global.description}">
			            <img class="btn-bubble-std" src="/etc/designs/tourismaustralia/clientlibs/img/icons/email_outline.png" alt="Email icon">
			            <img class="btn-bubble-active" src="/etc/designs/tourismaustralia/clientlibs/img/icons/email.png" alt="Email icon">
					</span>
				</li>
		    
		    	<!-- ShareThis icons inserted here via javascript (see shareThis.js) --> 

		    	<!-- ShareThis icon always shows -->
			    <li class="btn-bubble">
					<span class="btn-bubble-button st_sharethis_large" displayText="ShareThis" st_url="${sharethis.shareUrl}" st_title="${global.title}" st_summary="${global.description}">
			            <img class="btn-bubble-std" src="/etc/designs/tourismaustralia/clientlibs/img/icons/sharethis_outline.png" alt="ShareThis icon">
			            <img class="btn-bubble-active" src="/etc/designs/tourismaustralia/clientlibs/img/icons/sharethis.png" alt="ShareThis icon">
					</span>
				</li>
		    	<!-- Facebok Like always shows -->
				<li class="social-fblike">
					<span class="st_fblike_large" displayText="Facebook Like" st_url="${sharethis.shareUrl}"></span>
				</li>
			</ul>		    
		</div>
</div>

<cq:includeClientLib js="ta-share-this"/>
