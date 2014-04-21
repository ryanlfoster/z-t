<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/apps/tourismaustralia/components/global.jsp" %>
<%@ page import="com.australia.content.domain.ContentType.Content" %>
<%@ page import="java.util.List" %>
<!-- grid of 4 items start -->
<div class="col-xs-12 col-md-6 mosaic-grid-4 l-row-collapse">

    <div class="row mosaic-grid-2">
        <div class="row mosaic-grid-2-tile">
            <div class="col-xs-12 col-sm-6">
                <c:set value="${remainder[0]}" var="contentItem" scope="request" />
                <cq:include script="whatYouCanSee_tile.jsp" />
            </div>
            <div class="col-xs-12 col-sm-6">
                <c:set value="${remainder[1]}" var="contentItem" scope="request" />
                <cq:include script="whatYouCanSee_tile.jsp" />
            </div>
        </div>
        <div class="row mosaic-grid-2-content">
            <div class="col-xs-12">
                <div class="mosaic-item-detail-container">
                    <div class="mosaic-item-container">

                        <div class="l-h-center type-spacing-20">
                            <img src="imgs/icons/art_culture.png" alt="" />
                        </div>

                        {{#parseJSON '{"copy": "Virgin Australia Fashion Festival"}'}}
                        {{> linethroughtext }}
                        {{/parseJSON}}

                        <div class="l-h-center l-padding-tb-30-lr-15">

                            <p>You’ll love the blue-hazed beauty of the Blue Mountains World Heritage Area – one million hectares of tall forests, sandstone cliffs, canyons, waterfalls and bushland. Take in the breathtaking panoramas...</p>
                            <p><a href="#">View more information</a></p>

                            <a href="#" class="btn-bubble bubble-colour-favourite">
                <span class="btn-bubble-tooltip">
                    <span class="btn-bubble-tooltip-container">
                        Add to your dream trip
                    </span>
                </span>
                <span class="btn-bubble-button">
                    <img class="btn-bubble-std" src="imgs/icons/favourite_outline.png" alt="" />
                    <img class="btn-bubble-active" src="imgs/icons/favourite.png" alt="" />
                </span>
                            </a>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="row mosaic-grid-2">
        <div class="row mosaic-grid-2-tile">
            <div class="col-xs-12 col-sm-6">
                <c:set value="${remainder[2]}" var="contentItem" scope="request" />
                <cq:include script="whatYouCanSee_tile.jsp" />
            </div>
            <div class="col-xs-12 col-sm-6">
                <c:set value="${remainder[3]}" var="contentItem" scope="request" />
                <cq:include script="whatYouCanSee_tile.jsp" />
            </div>
        </div>
        <div class="row mosaic-grid-2-content">
            <div class="col-xs-12">
                <div class="mosaic-item-detail-container">
                    <div class="mosaic-item-container">

                        <div class="l-h-center type-spacing-20">
                            <img src="imgs/icons/art_culture.png" alt="" />
                        </div>

                        {{#parseJSON '{"copy": "Virgin Australia Fashion Festival"}'}}
                        {{> linethroughtext }}
                        {{/parseJSON}}

                        <div class="l-h-center l-padding-tb-30-lr-15">

                            <p>You’ll love the blue-hazed beauty of the Blue Mountains World Heritage Area – one million hectares of tall forests, sandstone cliffs, canyons, waterfalls and bushland. Take in the breathtaking panoramas...</p>
                            <p><a href="#">View more information</a></p>

                            <a href="#" class="btn-bubble bubble-colour-favourite">
                <span class="btn-bubble-tooltip">
                    <span class="btn-bubble-tooltip-container">
                        Add to your dream trip
                    </span>
                </span>
                <span class="btn-bubble-button">
                    <img class="btn-bubble-std" src="imgs/icons/favourite_outline.png" alt="" />
                    <img class="btn-bubble-active" src="imgs/icons/favourite.png" alt="" />
                </span>
                            </a>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- grid of 4 items start end -->