<%--
  Created by: Marjia Yeasmin
  Date: 03/04/2014

  This page facilitates in rendering an image with text by using ImageWithText Component.

--%>
<%@include file="/apps/tourismaustralia/components/global.jsp"%>
<%@ page import="com.australia.www.components.content.largeimagewithtext.LargeImageWithText" %>
<%@ page import="com.day.cq.wcm.api.WCMMode" %>

<c:set var="largeImageWithText" value="<%=new LargeImageWithText(slingRequest) %>"/>

<c:if test = "${not empty largeImageWithText.imageSrc}">
    <div class="row l-center-1200">
        <div class="large-image-text col-xs-9 col-sm-9 col-sm-offset-3">
            <c:if test = "${not empty largeImageWithText.imageSrc}">
                <c:choose>
                    <c:when test = "${not empty largeImageWithText.imageAltText}">
                        <img class="large-image-text-img" src="${largeImageWithText.imageSrc}" alt="${largeImageWithText.imageAltText}">
                        <c:if test = "${not empty largeImageWithText.imageText}">
                            <div class="large-image-text-content">
                                <p>${largeImageWithText.imageText}</p>
                            </div>
                        </c:if>
                    </c:when>
                    <c:otherwise>
                        <img class="large-image-text-img" src="${largeImageWithText.imageSrc}" alt="">
                        <c:if test = "${not empty largeImageWithText.imageText}">
                            <div class="large-image-text-content">
                                <p>${largeImageWithText.imageText}</p>
                            </div>
                        </c:if>
                    </c:otherwise>
                </c:choose>
            </c:if>

        </div>
    </div>
</c:if>



