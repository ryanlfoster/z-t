<%--

  File fourToOneGrid_mainRow.jsp must be called with the following context dependencies:

  - alt: a boolean indicating whether the large tile should be on the right
  - row: the FourToOneGridMosaic object to render

--%>


<%@include file="/apps/tourismaustralia/components/global.jsp" %>
<%@ page import="com.australia.mosaic.FourToOneGridMosaic" %>
<%
    FourToOneGridMosaic row = (FourToOneGridMosaic) request.getAttribute("row");
    request.setAttribute("single", row.getSingleItem());
    request.setAttribute("remainder", row.getGridFourItems());
%>
<div class="row">

    <c:if test="${alt}">
        <cq:include script="/apps/tourismaustralia/components/content/fourToOneGrid/fourToOneGrid_grid_4.jsp" />
    </c:if>
    <cq:include script="/apps/tourismaustralia/components/content/fourToOneGrid/fourToOneGrid_grid_1.jsp" />
    <c:if test="${!alt}">
        <cq:include script="/apps/tourismaustralia/components/content/fourToOneGrid/fourToOneGrid_grid_4.jsp" />
    </c:if>

</div>