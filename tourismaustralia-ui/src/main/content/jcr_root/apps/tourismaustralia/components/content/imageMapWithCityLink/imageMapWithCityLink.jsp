<%@include file="/apps/tourismaustralia/components/global.jsp" %>
<%@ page import="com.australia.www.components.content.imagemapwithcitylink.ImageMapWithCityLink" %>
<%@ page import="com.day.cq.wcm.api.WCMMode" %>

<c:set var="imageMapWithCityLink" value="<%=new ImageMapWithCityLink(slingRequest) %>"/>

<div class="map-main">
    <c:if test="${not empty imageMapWithCityLink.image && not empty imageMapWithCityLink.altText }">
        <img class="map-main-image" src="${imageMapWithCityLink.image}.img.png" alt="${imageMapWithCityLink.altText}" />
    </c:if>
    <c:if test="${not empty imageMapWithCityLink.title || not empty imageMapWithCityLink.link && not empty imageWithDate.linkText  }">
        <div class="map-main-link">
            <c:if test="${not empty imageMapWithCityLink.title}">
                <div class="map-main-title">${imageMapWithCityLink.title}</div>
            </c:if>
            <c:if test="${not empty imageMapWithCityLink.linkText}">
                <span class="map-main-pin icon-font-mappin"></span>
                <c:choose>
                    <c:when test="${not empty imageMapWithCityLink.link}">
                        <a href="${imageMapWithCityLink.link}" class="map-pin-btn" ${imageMapWithCityLink.linkIsExternal == true ? 'target="_blank"': ''}>${imageMapWithCityLink.linkText}</a>
                    </c:when>
                    <c:otherwise>
                       <span class="map-pin-btn">${imageMapWithCityLink.linkText}</span>
                    </c:otherwise>
                 </c:choose>
            </c:if>
        </div>
    </c:if>
</div>

