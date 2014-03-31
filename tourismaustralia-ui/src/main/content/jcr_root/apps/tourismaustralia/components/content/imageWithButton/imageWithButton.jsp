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

<div class="image-ugc image-with-button ${imageButton.textWhite == true ? 'make-white': 'make-black'}">

        <div class="image-bg fullwidth-bg" data-image-vertical-alignment="bottom" data-image-vertical-alignment="bottom" data--200-top="-webkit-transform: translate(0,10%);" data-200-bottom="-webkit-transform: translate(0,-10%);">
            <c:if test="${not empty (imageButton.backgroundImageSrc and imageButton.imgAltText)}">
                <div class="responsive-image" data-picture="" data-alt="${imageButton.imgAltText}" >
                    <div data-src="${imageButton.backgroundImageSrc}.adapt.480.low.jpg" data-media="(min-width: 1px)"></div>
                    <div data-src="${imageButton.backgroundImageSrc}.adapt.768.medium.jpg" data-media="(min-width: 481px)"></div>
                    <div data-src="${imageButton.backgroundImageSrc}.adapt.992.high.jpg" data-media="(min-width: 769px)"></div>
                    <div data-src="${imageButton.backgroundImageSrc}.adapt.1663.high.jpg" data-media="(min-width: 993px)"></div>

                    <noscript>
                        <img src="${imageButton.backgroundImageSrc}.adapt.1663.high.jpg" alt="${imageButton.imgAltText}">
                    </noscript>

                </div>
                <!--[if (lt IE 9) & (!IEMobile)]>
                <img src="${imageButton.backgroundImageSrc}" alt="${imageButton.imgAltText}">
                <![endif]-->
            </c:if>
        </div>

        <c:if test="${not empty imageButton.quoteText}">
            <div class="image-content-container">
                <div class="image-content">
                    <c:if test="${not empty imageButton.iconImageSrc}">
                        <div class="image-social-image">
                            <img src="${imageButton.iconImageSrc}" alt="Icon Image">
                        </div>
                    </c:if>
                    <hr>
                    <c:if test="${not empty imageButton.quoteText}">
                        <div class="blockquote-quote-pull">
                            <p>&ldquo;${imageButton.quoteText}&rdquo;</p>
                        </div>
                    </c:if>

                    <hr>

                    <c:if test="${not empty imageButton.quoteAuthorText or imageButton.quoteSubText or imageButton.quoteSourceText}">
                        <div class="image-quote">

                            <c:if test="${not empty imageButton.quoteAuthorText}">
                                <span class="image-quote-title">${imageButton.quoteAuthorText}</span>
                            </c:if>

                            <c:if test="${not empty imageButton.quoteSubText}">
                                <span class="image-quote-description">${imageButton.quoteSubText}</span>
                            </c:if>

                            <c:if test="${not empty imageButton.quoteSourceText}">
                                <span class="image-quote-source">${imageButton.quoteSourceText}</span>
                            </c:if>
                        </div>
                    </c:if>

                    <c:if test="${not empty (imageButton.imageButtonPath and imageButtonText)}">
                        <a href="${imageButton.imageButtonPath}" class="image-btn">${imageButton.imageButtonText}</a>
                    </c:if>

                </div>
            </div>
        </c:if>
</div>




