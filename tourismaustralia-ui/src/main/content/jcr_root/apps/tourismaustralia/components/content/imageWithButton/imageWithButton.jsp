<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by: Marjia Yeasmin
  Date: 18/03/2014

  This page facilitates in rendering an authored image with text, credits,
  and a button with a link by using ImageWithButton Component.

--%>

<%@include file="/apps/tourismaustralia/components/global.jsp"%>
<%@ page import="com.australia.www.components.content.imagewithbutton.ImageWithButton" %>
<%@ page import="com.day.cq.wcm.api.WCMMode" %>

<c:set var="imageButton" value="<%=new ImageWithButton(slingRequest) %>"/>

<c:if test="${not empty imageButton.mainImageSrc}">
    <div class="large-image-social make-white">
            <c:if test="${not empty (imageButton.mainImageSrc and imageButton.mainImageAlt)}">
                <div class="large-image-social-media">
                    <div class="responsive-image large-image-social-frame-height" data-picture="" data-alt="" >
                        <div data-src="${imageButton.mainImageSrc}.adapt.480.low.jpg" data-media="(min-width: 1px)"></div>
                        <div data-src="${imageButton.mainImageSrc}.adapt.768.medium.jpg" data-media="(min-width: 481px)"></div>
                        <div data-src="${imageButton.mainImageSrc}.adapt.992.high.jpg" data-media="(min-width: 769px)"></div>
                        <div data-src="${imageButton.mainImageSrc}.adapt.1663.high.jpg" data-media="(min-width: 993px)"></div>

                        <noscript>
                            <img src="${imageButton.mainImageSrc}.adapt.1663.high.jpg" alt="${imageButton.mainImageAlt}">
                        </noscript>
                    </div>
                    <!--[if (lt IE 9) & (!IEMobile)]>
                        <img src="${imageButton.mainImageSrc}" alt="${imageButton.mainImageAlt}">
                    <![endif]-->
                </div>
            </c:if>

            <c:if test="${not empty imageButton.overlayIconImageSrc or not empty imageButton.quoteText or not empty imageButton.imageButtonText}">
                    <div class="large-image-social-content">
                        <c:if test="${not empty imageButton.overlayIconImageSrc}">
                            <div class="image-social-image">
                                <img src="${imageButton.overlayIconImageSrc}" alt="${(not empty imageButton.overlayIconImageAlt) ? imageButton.overlayIconImageAlt : ""}">
                            </div>
                        </c:if>
                        <c:if test="${not empty imageButton.quoteText}">
                                <hr>
                                    <div class="blockquote-quote-pull">
                                        <p>&ldquo;${imageButton.quoteText}&rdquo;</p>
                                    </div>
                                <hr>
                        </c:if>
                        <c:if test="${not empty imageButton.imageButtonText and not empty imageButton.imageButtonPath}">
                                <a href="${imageButton.imageButtonPath}" class="image-btn" ${imageButton.buttonPathExternal == true ? 'target="_blank"': ''}>${imageButton.imageButtonText}</a>
                        </c:if>
                    </div>
            </c:if>
            <c:if test="${not empty imageButton.refIconImageSrc or not empty imageButton.refBoldText or not empty imageButton.refRegularText}">
                    <div class="large-image-social-mention make-white">
                        <div class="social-mention">
                            <div class="social-mention-container">
                                <c:if test = "${not empty imageButton.refIconImageSrc}">
                                    <div class="social-mention-image">
                                        <img src="${imageButton.refIconImageSrc}" alt="${(not empty imageButton.refIconImageAlt) ? imageButton.refIconImageAlt : ""}">
                                    </div>
                                </c:if>
                                <c:if test = "${not empty imageButton.refBoldText or not empty imageButton.refRegularText}">
                                    <div class="social-mention-details">
                                        <p><strong>${(not empty imageButton.refBoldText) ? imageButton.refBoldText : ""}${(not empty imageButton.refBoldText and not empty imageButton.refRegularText) ? ", " : ""}</strong>${(not empty imageButton.refRegularText) ? imageButton.refRegularText : ""}</p>
                                    </div>
                                </c:if>
                            </div>
                    </div>
                </div>
        </c:if>
    </div>
</c:if>





