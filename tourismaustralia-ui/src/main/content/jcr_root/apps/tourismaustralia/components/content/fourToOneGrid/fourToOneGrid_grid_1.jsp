<%--

  File fourToOneGrid_grid_1.jsp must be called with the following context dependencies:

  - single: the Content object to render

--%>
<%@include file="/apps/tourismaustralia/components/global.jsp" %>
<!-- single item start -->
<div class="col-xs-12 col-md-6 mosaic-grid-1 l-row-collapse">
    <div class="row">
        <div class="col-xs-12">
            <c:set value="${single}" var="contentItem" scope="request" />
            <cq:include script="/apps/tourismaustralia/components/content/fourToOneGrid/fourToOneGrid_tile.jsp" />
        </div>
    </div>
</div>

<!-- single item end -->