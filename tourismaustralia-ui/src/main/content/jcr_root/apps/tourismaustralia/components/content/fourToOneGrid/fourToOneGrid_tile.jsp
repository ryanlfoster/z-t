<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/apps/tourismaustralia/components/global.jsp" %>

<div class="mosaic-item">
    <div class="mosaic-front-back-container flip-container">
        <div class="flipper">

            <c:set var="category" value="${contentItem.pageCategory}"/>

            <div class="mosaic-column-front flip-front">
                <!-- image start -->
                <div class="mosaic-media mosaic-primary">
                    <img src="${contentItem.imagePath}" alt="">
                </div>
                <!-- image end -->
                <!-- label start -->
                <div class="mosaic-overlay">
                    <div class="vertical-container">
                        <div class="vertical-content text-center">
                            <c:set var="categoryThemeClass" value=""/>
                            <c:if test="${not empty category}">
                                <c:set var="categoryThemeClass" value="${category.themeCssClass}"/>
                            </c:if>
                            <span class="label-destination type-destination ${categoryThemeClass}">${contentItem.title}</span>
                        </div>
                    </div>
                </div>
                <!-- label end -->
                <!-- date start -->
                <div class="mosaic-overlay">
                    <div class="vertical-container">
                        <div class="vertical-content text-center type-date-mosaic">
                            <span class="month"></span>
                        </div>
                    </div>
                </div>
                <!-- date end -->
            </div>

            <div class="mosaic-column-back mosaic-content flip-back mosaic-back ${categoryThemeClass}">
                <div class="vertical-container">
                    <div class="vertical-content text-center">
                        <c:if test="${not empty category}">
                            <img class="icon-generic" src="${category.whiteOutlineIcon}" alt="">
                        </c:if>
                        <p class="type-destination line-through-line-wrapper">${contentItem.title}</p>
                    </div>
                </div>
            </div>

        </div>
    </div>

    <div class="mosaic-item-detail-container">
        <!-- close button start -->
        <span class="mosaic-close-icon"><a class="mosaic-detail-close-btn" href="#"><img src="/etc/designs/tourismaustralia/clientlibs/imgs/icons/close_outline.png" alt=""></a></span>
        <!-- close button end -->
        <div class="mosaic-item-container type-ieAntialias">
            <div class="l-h-center type-spacing-20">
                <c:if test="${not empty category}">
                    <img src="${category.standardIcon}" alt="">
                </c:if>
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
                <a href="${contentItem.path}" class="btn-bubble bubble-colour-favourite">
                <span class="btn-bubble-tooltip">
                    <span class="btn-bubble-tooltip-container">
                        <fmt:message key="add to your dream trip" />
                    </span>
                </span>
                <span class="btn-bubble-button">
                    <img class="btn-bubble-std" src="/etc/designs/tourismaustralia/clientlibs/imgs/icons/favourite_outline.png" alt="">
                    <img class="btn-bubble-active" src="/etc/designs/tourismaustralia/clientlibs/imgs/icons/favourite.png" alt="">
                </span>
                </a>

            </div>
        </div>
    </div>

</div>