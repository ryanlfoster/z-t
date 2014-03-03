<%@page session="false"%><%--**********************************************************************
  *
  * ADOBE CONFIDENTIAL
  * __________________
  *
  *  Copyright 2012 Adobe Systems Incorporated
  *  All Rights Reserved.
  *
  * NOTICE:  All information contained herein is, and remains
  * the property of Adobe Systems Incorporated and its suppliers,
  * if any.  The intellectual and technical concepts contained
  * herein are proprietary to Adobe Systems Incorporated and its
  * suppliers and are protected by trade secret or copyright law.
  * Dissemination of this information or reproduction of this material
  * is strictly forbidden unless prior written permission is obtained
  * from Adobe Systems Incorporated.
  **********************************************************************--%><%
%><%@page contentType="text/javascript" %><%
%><%@include file="/libs/foundation/global.jsp"%><%
%><%

    String store = properties.get("store", currentStyle.get("store", String.class));
    String serviceURL = properties.get("serviceURL", currentStyle.get("serviceURL", String.class));

%>

        var store = CQ_Analytics.StoreRegistry.getStore("<%= xssAPI.getValidJSToken(store, "") %>");

        if (!store) {
            CQ_Analytics.JSONPStore.registerNewInstance("<%= xssAPI.getValidJSToken(store, "") %>", "<%= serviceURL %>", {});
        }


