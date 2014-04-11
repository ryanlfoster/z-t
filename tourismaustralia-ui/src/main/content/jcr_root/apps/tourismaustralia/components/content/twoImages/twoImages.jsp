<%--
  Created by: Marjia Yeasmin
  Date: 03/04/2014

  This page facilitates in rendering two images - large image and small image along with their descriptions side
  by side by using TwoImages Component.

--%>
<%@include file="/apps/tourismaustralia/components/global.jsp"%>
<%@ page import="com.australia.www.components.content.twoimages.TwoImages" %>
<%@ page import="com.day.cq.wcm.api.WCMMode" %>

<c:set var="twoImages" value="<%=new TwoImages(slingRequest) %>"/>

<c:if test = "${not empty (twoImages.largeImageSrc or twoImages.smallImageSrc)}">
    <div class="row l-center-1200">
        <div class="two-images col-xs-12">
            <div class="row">
                <c:if test = "${not empty twoImages.largeImageSrc}">
                    <div class="col-xs-7 two-images-column">
                        <c:choose>
                            <c:when test = "${not empty twoImages.largeImageAltText}">
                                <img class="two-images-large-img" src="${twoImages.largeImageSrc}" alt="${twoImages.largeImageAltText}">
                                    <c:if test = "${not empty twoImages.largeImageText}">
                                        <div class="two-images-large-content">
                                            <p>${twoImages.largeImageText}</p>
                                        </div>
                                    </c:if>
                            </c:when>
                            <c:otherwise>
                                <img class="two-images-large-img" src="${twoImages.largeImageSrc}" alt="">
                                <c:if test = "${not empty twoImages.largeImageText}">
                                    <div class="two-images-large-content">
                                        <p>${twoImages.largeImageText}</p>
                                    </div>
                                </c:if>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </c:if>


                <c:if test = "${not empty twoImages.smallImageSrc}">
                    <div class="col-xs-5 two-images-column">
                        <c:choose>
                            <c:when test = "${not empty twoImages.smallImageAltText}">
                                <img class="two-images-small-img" src="${twoImages.smallImageSrc}" alt="${twoImages.smallImageAltText}">
                                <c:if test = "${not empty twoImages.smallImageText}">
                                    <div class="two-images-small-content">
                                        <p>${twoImages.smallImageText}</p>
                                    </div>
                                </c:if>
                            </c:when>
                            <c:otherwise>
                                <img class="two-images-small-img" src="${twoImages.smallImageSrc}" alt="">
                                <c:if test = "${not empty twoImages.smallImageText}">
                                    <div class="two-images-small-content">
                                        <p>${twoImages.smallImageText}</p>
                                    </div>
                                </c:if>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </c:if>
            </div>
        </div>
    </div>
</c:if>