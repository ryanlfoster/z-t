<%@ page session="false"%>
<%@ page
    import="
    java.net.URLEncoder,
    org.apache.sling.api.scripting.SlingBindings,
    org.apache.sling.engine.auth.Authenticator,
    org.apache.sling.engine.auth.NoAuthenticationHandlerException,
    com.day.cq.wcm.api.WCMMode,
    com.australia.errorhandler.Sling404ErrorHandler"%>
<%@include file="/apps/tourismaustralia/components/global.jsp"%>

<%!

private boolean isAnonymousUser(HttpServletRequest request) {
    return request.getAuthType() == null
        || request.getRemoteUser() == null
        || "anonymous".equals(request.getRemoteUser());
}

private boolean isBrowserRequest(HttpServletRequest request) {
    // check if user agent contains "Mozilla" or "Opera"
    final String userAgent = request.getHeader("User-Agent");
    return userAgent != null
        && (userAgent.indexOf("Mozilla") > -1
            || userAgent.indexOf("Opera") > -1);
}
    
%>
<%

// DO IT ONLY FOR AUTHOR INSTANCE
if(!WCMMode.fromRequest(request).equals(WCMMode.DISABLED)) {

    // DEVICE WHETHER TO REDIRECT TO THE (WCM) LOGIN PAGE, OR TO SEND A PLAIN 404
    if (isAnonymousUser(request) && isBrowserRequest(request)) {
        
        SlingBindings bindings2 = (SlingBindings) request.getAttribute("org.apache.sling.api.scripting.SlingBindings");
        Authenticator auth = bindings2.getSling().getService(Authenticator.class);
        
        if (auth != null) {
            
            try {
                auth.login(request, response);
                
                // LOGIN HAS BEEN REQUESTED, NOTHING MORE TO DO
                return;
                
            } catch (NoAuthenticationHandlerException nahe) {
                bindings2.getLog().warn("Cannot login: No Authentication Handler is willing to authenticate");
            }
        } else {
            bindings2.getLog().warn("Cannot login: Missing Authenticator service");
        }
    }
}

// WE GOT HERE IF AUTHENTICATION SHOULD NOT HAVE TAKEN PLACE OR IF 
//   NO AUTHENTICATOR SERVICE IS AVAILABLE OR IF NOT AUTHENTICATIONHANDLER
//   IS WILLING TO AUTHENTICATE.
 
// SET RESPONSE STATUS
response.setStatus(404);
 
%>

<c:set var="fourofour" value="<%=new Sling404ErrorHandler(slingRequest) %>"/>

<sling:include path="${fourofour.pageLocation}" />