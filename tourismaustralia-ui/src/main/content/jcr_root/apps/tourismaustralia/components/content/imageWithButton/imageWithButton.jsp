<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/apps/tourismaustralia/components/global.jsp"%>
<%@ page import="com.australia.www.components.content.imagewithbutton.ImageWithButton"%>

<c:set var="imageButton" value="<%=new ImageWithButton(slingRequest) %>" />

<div class="image-ugc-container">
	<div class="image-ugc image-with-button make-white">
        <div class="image-bg fullwidth-bg" data-image-vertical-alignment="bottom" data--200-top="-webkit-transform: translate(0,10%);" data-200-bottom="-webkit-transform: translate(0,-10%);">
            <div class="responsive-image" data-picture="" data-alt="${imageButton.mainImageAlt}" >
                <div data-src="${imageButton.mainImageSrc}.adapt.480.low.jpg" data-media="(min-width: 1px)"></div>
                <div data-src="${imageButton.mainImageSrc}.adapt.768.medium.jpg" data-media="(min-width: 481px)"></div>
                <div data-src="${imageButton.mainImageSrc}.adapt.992.high.jpg" data-media="(min-width: 769px)"></div>
                <div data-src="${imageButton.mainImageSrc}.adapt.1663.high.jpg" data-media="(min-width: 993px)"></div>
                <noscript>
                    <img src="${imageButton.mainImageSrc}.adapt.1663.high.jpg" alt="${imageButton.mainImageAlt}">
                </noscript>
            </div>
            <!--[if (lt IE 9) & (!IEMobile)]>
             	<img src="${imageButton.mainImageSrc}.adapt.1663.high.jpg" alt="${imageButton.mainImageAlt}">
            <![endif]-->
        </div>
		<div class="image-content-container">
			<div class="image-content">
				<hr>
				<div class="blockquote-quote-pull">
					<p>&#8220;${imageButton.quoteText}&#8221;</p>
				</div>
				<hr>
				<a href="${imageButton.imageButtonPath}" class="image-btn" ${imageButton.buttonPathExternal?'target="_blank"':''}>${imageButton.imageButtonText}</a>
			</div>
		</div>
	</div>
	<div class="image-ugc-copyright">
		<div class="social-mention l-padding-b">
			<div class="social-mention-container">
				<div class="social-mention-image">
					<img src="${imageButton.refIconImageSrc}" alt="${imageButton.refIconImageAlt}" />
				</div>
				<div class="social-mention-details">
					<p><strong>${imageButton.refBoldText} </strong>${imageButton.refRegularText}</p>
				</div>
			</div>
		</div>
	</div>
</div>