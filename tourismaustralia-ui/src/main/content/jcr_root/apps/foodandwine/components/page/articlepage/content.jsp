<%@include file="/apps/foodandwine/components/global.jsp"%>
<%@ page import="com.day.cq.wcm.api.WCMMode" %>

<% if (WCMMode.fromRequest(slingRequest) == WCMMode.EDIT) {%>
		<script>
		   Sidekick_CUSTOM = {
		           "text": "Add to Shortlist",
		           "handler": function () {
		               var contentWindow = CQ.utils.WCM.getContentWindow();
		               var sidekick = CQ.wcm.Sidekick.findSidekick(this);
		               var dialogPath = '/apps/foodandwine/components/page/shortlist/shortlist_dialog';
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
		       CQ.WCM.getTopWindow().CQ.wcm.Sidekick.DEFAULT_ACTIONS.push(Sidekick_CUSTOM);
		   } else {
		       CQ.wcm.Sidekick.DEFAULT_ACTIONS.push(Sidekick_CUSTOM);
		   }
		</script>
<% } %>
<c:set var="articleDescription"
value="<%=currentPage.getProperties().get("articleDescription", "")%>" />
<div class="faw-article">
		<!-- test background for testing, whow the transparent menu respons -->
	<div class='form-hero'>
		<div class="faw-hero-home-container">
			<cq:include path="articleTitle" resourceType="foodandwine/components/content/articleTitle" />
			<cq:include path="category" resourceType="foodandwine/components/content/category" />
			<h3 class="faw-article-healdine">${articleDescription}</h3>
		</div>
	</div>

	<cq:include path="shareThis" resourceType="foodandwine/components/content/shareThis" />
	<cq:include path="mainparsys" resourceType="foundation/components/parsys" />
	<cq:include path="accolade" resourceType="foundation/components/content/accolade" />
	<cq:include path="map" resourceType="foodandwine/components/content/map" />


	<cq:include path="otherExperiences" resourceType="foodandwine/components/content/otherExperiences" />
</div>



