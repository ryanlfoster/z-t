<%@include file="/apps/tourismaustralia/components/global.jsp" %>
<%@ page import="com.day.cq.wcm.api.WCMMode" %>

<% if (WCMMode.fromRequest(slingRequest) == WCMMode.EDIT) {%>
<script>
    Sidekick_CONF = {
        "text": "Custom Properties",
        "handler": function () {
            var contentWindow = CQ.utils.WCM.getContentWindow();
            var sidekick = CQ.wcm.Sidekick.findSidekick(this);
            var dialogPath = '/apps/tourismaustralia/components/page/global/extra_dialog';
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
    
    Sidekick_SHARE = {
            "text": "ShareThis Page",
            "handler": function () {
                var contentWindow = CQ.utils.WCM.getContentWindow();
                var sidekick = CQ.wcm.Sidekick.findSidekick(this);
                var dialogPath = '/apps/tourismaustralia/components/page/shareThis/share_dialog';
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
        CQ.WCM.getTopWindow().CQ.wcm.Sidekick.DEFAULT_ACTIONS.push(Sidekick_CONF);
        CQ.WCM.getTopWindow().CQ.wcm.Sidekick.DEFAULT_ACTIONS.push(Sidekick_SHARE);
        
    } else {
        CQ.wcm.Sidekick.DEFAULT_ACTIONS.push(Sidekick_CONF);
        CQ.wcm.Sidekick.DEFAULT_ACTIONS.push(Sidekick_SHARE);
    
    }
</script>
<% } %>