<%--
  Created by: Marjia Yeasmin
  Date: 08/04/2014

  This page facilitates in rendering a small image with text by using SmallImageWithText Component.

--%>
<%@include file="/apps/tourismaustralia/components/global.jsp"%>
<%@ page import="com.australia.www.components.content.smallimagewithtext.SmallImageWithText" %>
<%@ page import="com.day.cq.wcm.api.WCMMode" %>

<c:set var="smallImageWithText" value="<%=new SmallImageWithText(slingRequest) %>"/>

<c:if test = "${not empty smallImageWithText.imageSrc}">
    <div class="row l-center-1200">
        <div class="small-image-text col-xs-12 col-sm-9 col-sm-offset-3">
            <c:if test = "${not empty smallImageWithText.imageSrc}">
                <c:choose>
                    <c:when test = "${not empty smallImageWithText.imageAltText}">
                        <img class="small-image-text-img" src="${smallImageWithText.imageSrc}" alt="${smallImageWithText.imageAltText}">
                        <c:if test = "${not empty smallImageWithText.imageText}">
                            <div class="small-image-text-content">
                                <p>${smallImageWithText.imageText}</p>
                            </div>
                        </c:if>
                    </c:when>
                    <c:otherwise>
                        <img class="small-image-text-img" src="${smallImageWithText.imageSrc}" alt="">
                        <c:if test = "${not empty smallImageWithText.imageText}">
                            <div class="small-image-text-content">
                                <p>${smallImageWithText.imageText}</p>
                            </div>
                        </c:if>
                    </c:otherwise>
                </c:choose>
            </c:if>
        </div>
    </div>
</c:if>



