<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/apps/tourismaustralia/components/global.jsp" %>
<%@ page import="com.australia.www.components.content.iframe.IFrame" %>
<%@ page import="com.day.cq.wcm.api.WCMMode" %>

<c:set var="iframe" value="<%=new IFrame(slingRequest) %>"/>

<% if (WCMMode.fromRequest(slingRequest) == WCMMode.EDIT) {%>
<c:choose>
    <c:when test="${not empty iframe.applicationUrl}">
        <c:choose>
            <c:when test="${!iframe.excludeFromMobile && !iframe.excludeFromTablet}">
                <div>
                    <iframe src="${iframe.applicationUrl}" style="max-width:${iframe.maxWidth}px;"
                            width="100%" height="${iframe.height}" frameborder="0"></iframe>
                </div>
            </c:when>
            <c:otherwise>
                <!-- just spitting out values for now as it has not been determined what exactly to do yet -->
                <p>URL: ${iframe.applicationUrl}, Max Width: ${iframe.maxWidth}, Height: ${iframe.height}</p>
            </c:otherwise>
        </c:choose>
    </c:when>
    <c:otherwise>
        <p><i>Please setup the target application by clicking Edit and specifying
            its URL, maximum width & height</i></p>
    </c:otherwise>
</c:choose>

<% } %>