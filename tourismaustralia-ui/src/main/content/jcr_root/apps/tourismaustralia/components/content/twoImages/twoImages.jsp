<%@include file="/apps/tourismaustralia/components/global.jsp"%>
<%@ page import="com.australia.www.components.content.twoimages.TwoImages" %>
<%@ page import="com.day.cq.wcm.api.WCMMode" %>

<c:set var="twoImages" value="<%=new TwoImages(slingRequest) %>"/>

<div class="two-images">
    <div class="row l-center-1200">
        <div class="col-xs-12">
            <div class="row">
                <div class="col-xs-7 two-images-column">
                    <img class="two-images-large-img" src="${twoImages.largeImageSrc}" alt="${twoImages.largeImageAltText}" />
                    <div class="two-images-large-content">
                        <p>${twoImages.largeImageText}</p>
                    </div>
                </div>
                <div class="col-xs-5 two-images-column">
                    <img class="two-images-small-img" src="${twoImages.smallImageSrc}" alt="${twoImages.smallImageAltText}" />
                    <div class="two-images-small-content">
                        <p>${twoImages.smallImageText}</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

