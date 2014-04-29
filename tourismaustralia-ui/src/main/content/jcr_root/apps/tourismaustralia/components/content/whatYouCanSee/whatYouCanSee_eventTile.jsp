<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="/apps/tourismaustralia/components/global.jsp" %>

<div class="mosaic-item">
    <div class="mosaic-front-back-container flip-container">
        <div class="flipper">

            <div class="mosaic-column-front flip-front">
                <div class="mosaic-media mosaic-primary">
                    <img src="/etc/designs/tourismaustralia/clientlibs/imgs/mosaic/img10.jpg" alt=""/>
                </div>
                <div class="mosaic-overlay">
                    <div class="vertical-container">
                        <div class="vertical-content text-center">
                            <div class="type-date-mosaic">
                                <span class="month">${contentItem.startDateMonth}</span> <span class="day">${contentItem.startDateDay}</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="mosaic-column-back mosaic-content flip-back mosaic-back theme-arts">
                <div class="vertical-container">
                    <div class="vertical-content text-center">
                        <img class="icon-generic" src="/etc/designs/tourismaustralia/clientlibs/imgs/icons/art_culture_white_outline.png" alt="" />
                        <p class="type-destination line-through-line-wrapper">${contentItem.title}</p>
                        <p class="type-date">${contentItem.dateString}</p>
                    </div>
                </div>
            </div>

        </div>
    </div>

    <div class="mosaic-item-detail-container">
        <div class="mosaic-item-container">

            <div class="l-h-center type-spacing-20">
                <img src="/etc/designs/tourismaustralia/clientlibs/imgs/icons/art_culture.png" alt="" />
            </div>

            <div class="line-through-container">
                <div class="line-through"><span class="line-through-hr"></span></div>
                <div class="line-through-container-biline">
                    ${contentItem.title}
                </div>
                <div class="line-through"><span class="line-through-hr"></span></div>
            </div>

            <div class="l-h-center l-padding-tb-30-lr-15">

                <p>${contentItem.text}</p>
                <p><a href="${contentItem.path}"><fmt:message key="View more information" /></a></p>

                <a href="#" class="btn-bubble bubble-colour-favourite">
                <span class="btn-bubble-tooltip">
                    <span class="btn-bubble-tooltip-container">
                        <fmt:message key="Add to your dream trip" />
                    </span>
                </span>
                <span class="btn-bubble-button">
                    <img class="btn-bubble-std" src="/etc/designs/tourismaustralia/clientlibs/imgs/icons/favourite_outline.png" alt="" />
                    <img class="btn-bubble-active" src="/etc/designs/tourismaustralia/clientlibs/imgs/icons/favourite.png" alt="" />
                </span>
                </a>

            </div>
        </div>
    </div>

</div>