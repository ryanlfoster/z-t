<%@include file="/apps/tourismaustralia/components/global.jsp"%>

<!-- search item start -->
<div class="row search-result-row-spacing">

    <!-- search item image/category start -->
    <div class="search-result-category-container">
        <a href="${contentItem.path}" class="search-result-category-link">
            <!-- highlight item start -->
            <span class="mosaic-media mosaic-primary">
                <img src="${contentItem.imagePath}" alt="">
            </span>
            <!-- highlight item end -->

            <!-- category label start -->
            <span class="mosaic-overlay">
                <span class="vertical-container">
                    <span class="vertical-content text-center">

                        <!-- item label start -->
                        <span class="label-destination type-destination theme-beaches">${contentItem.title}</span>
                        <!-- item label start -->

                    </span>
                </span>
            </span>
            <!-- category label end -->

        </a>

    </div>
    <!-- search item image/category end -->

    <!-- search item content start -->
    <div class="search-result-content-container">

        <div class="search-results-container type-ieAntialias clearfix">

            <!-- category icon start -->
            <div class="search-results-category-icon">

                <img class="icon-generic" src="/etc/designs/tourismaustralia/clientlibs/imgs/icons/art_culture.png" alt="" />

            </div>
            <!-- category icon end -->

            <div class="search-results-copy-container">

                <!-- search title start -->
                <a href="${contentItem.path}" alt="" class="search-results-title">
                    ${contentItem.title}
                </a>
                <!-- search title end -->

                <!-- search copy start -->
                ${contentItem.text}
                <!-- search copy end -->

            </div>

            <!-- favourite icon start -->
            <div class="search-favourite">
                <a href="#" class="btn-bubble bubble-colour-favourite">
                    <span class="btn-bubble-tooltip">
                        <span class="btn-bubble-tooltip-container">
                            <fmt:message key="Add to your dream trip"/>
                        </span>
                    </span>
                    <span class="btn-bubble-button">
                        <img class="btn-bubble-std" src="/etc/designs/tourismaustralia/clientlibs/imgs/icons/favourite_outline.png" alt="" />
                        <img class="btn-bubble-active" src="/etc/designs/tourismaustralia/clientlibs/imgs/icons/favourite.png" alt="" />
                    </span>
                </a>
            </div>
            <!-- favourite icon end -->

        </div>

    </div>
    <!-- search item content end -->

</div>
<!-- search item end -->