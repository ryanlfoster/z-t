<%@include file="/apps/tourismaustralia/components/global.jsp"%>

<header id="main-header">
    <div id="nav-main-header" class="header megamenu">

        <%-- START: accessibility links --%>
        <div class="accessibility-links">
            <a tabindex="1" class="sr-only vis-focusable" href="#main-content">Skip to content</a>
            <a tabindex="2" class="sr-only vis-focusable" href="#main-footer">Skip to footer navigation</a>
        </div>
        <%-- END: accessibility links --%>

        <%-- START: main notice bar--%>
        <div id="main-notice-bar" class="notice-bar bar-scroll-top">
            <div class="row l-center-1200">
                <p class="notice-text notice-title">News alert</p>
                <p class="notice-text notice-summary">Lorem ipsum dolor sit amet consecuter. Ut enim ad minim. <a href="#">View the announcement</a></p>
                <a href="#nav-bar-top" class="notice-close"><span class="icon icon-16 icon-close" aria-hidden="true"></span></a>
            </div>
        </div>
        <%-- END: main notice bar--%>

        <%-- START: Navigation --%>
        <cq:include path="navigation" resourceType="tourismaustralia/components/content/navigation"/>
        <%-- END: Navigation --%>

    </div>
</header>