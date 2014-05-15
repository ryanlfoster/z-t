<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/apps/foodandwine/components/global.jsp"%>
<%@ page import="com.australia.foodandwine.components.page.facebook.Facebook" %>
<%@ page import="com.day.cq.wcm.api.WCMMode" %>

<c:set var="facebook" value="<%=new Facebook(slingRequest) %>"/>

<% if (WCMMode.fromRequest(slingRequest) == WCMMode.EDIT) {%>
		<script>
		   Sidekick_FACEBOOK = {
		           "text": "Facebook Page",
		           "handler": function () {
		               var contentWindow = CQ.utils.WCM.getContentWindow();
		               var sidekick = CQ.wcm.Sidekick.findSidekick(this);
		               var dialogPath = '/apps/foodandwine/components/page/facebook/facebook_dialog';
		               var propsDialogConfig = contentWindow.CQ.WCM.getDialogConfig(dialogPath);
		               propsDialogConfig.success = function (form, action) {
		                   CQ.Util.reload(CQ.WCM.getContentWindow());
		               };
		               propsDialogConfig.failure = function (form, action) {
		                   var response = CQ.HTTP.buildPostResponseFromHTML(action.response);
		                   CQ.Ext.Msg.alert(response.headers[CQ.HTTP.HEADER_MESSAGE]);
		               };
		               var propsDialog = contentWindow.CQ.WCM.getDialog(propsDialogConfig, dialogPath);
		               propsDialog.fieldEditLockMode = true;
		               propsDialog.loadContent(this.getPath() + "/jcr:content");
		               propsDialog.setTitle(CQ.I18n.getMessage("Config of {0}", this.getPath()));
		               propsDialog.show();
		           },
		           "context": CQ.wcm.Sidekick.PAGE
		       };    
		   
		   
		   Sidekick_CUSTOM = {
		           "text": "Facebook Properties",
		           "handler": function () {
		               var contentWindow = CQ.utils.WCM.getContentWindow();
		               var sidekick = CQ.wcm.Sidekick.findSidekick(this);
		               var dialogPath = '/apps/foodandwine/components/page/articlepage/shortlist_dialog';
		               var propsDialogConfig = contentWindow.CQ.WCM.getDialogConfig(dialogPath);
		               propsDialogConfig.success = function (form, action) {
		                   CQ.Util.reload(CQ.WCM.getContentWindow());
		               };
		               propsDialogConfig.failure = function (form, action) {
		                   var response = CQ.HTTP.buildPostResponseFromHTML(action.response);
		                   CQ.Ext.Msg.alert(response.headers[CQ.HTTP.HEADER_MESSAGE]);
		               };
		               var propsDialog = contentWindow.CQ.WCM.getDialog(propsDialogConfig, dialogPath);
		               propsDialog.fieldEditLockMode = true;
		               propsDialog.loadContent(this.getPath() + "/jcr:content");
		               propsDialog.setTitle(CQ.I18n.getMessage("Config of {0}", this.getPath()));
		               propsDialog.show();
		           },
		           "context": CQ.wcm.Sidekick.PAGE
		       };    
		   
		   if (CQ.WCM.getTopWindow()) {
		       CQ.WCM.getTopWindow().CQ.wcm.Sidekick.DEFAULT_ACTIONS.splice(CQ.wcm.Sidekick.DEFAULT_ACTIONS.length, CQ.WCM.getTopWindow().CQ.wcm.Sidekick.DEFAULT_ACTIONS.length - CQ.wcm.Sidekick.DEFAULT_ACTIONS.length);
		       CQ.WCM.getTopWindow().CQ.wcm.Sidekick.DEFAULT_ACTIONS.push(Sidekick_FACEBOOK);
		       CQ.WCM.getTopWindow().CQ.wcm.Sidekick.DEFAULT_ACTIONS.push(Sidekick_CUSTOM);
		   } else {
		       CQ.wcm.Sidekick.DEFAULT_ACTIONS.push(Sidekick_FACEBOOK);
		       CQ.wcm.Sidekick.DEFAULT_ACTIONS.push(Sidekick_CUSTOM);
		   }
		</script>
<% } %>

<div id="main-content">
	<div class='form-hero'>
		<div class="faw-hero-home-container">
			<cq:include path="articleTitle" resourceType="foodandwine/components/content/articleTitle" />
		</div>
	</div>
	<p>${facebook.userName}</p>
	<p>${facebook.postText}</p>
	<p>${facebook.postLink}</p>
</div>