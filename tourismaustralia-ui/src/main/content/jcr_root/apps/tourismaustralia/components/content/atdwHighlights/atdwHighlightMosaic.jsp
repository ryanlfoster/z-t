<%--
  Created by: Greg Snyder
  Date: 01/04/2014

--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/apps/tourismaustralia/components/global.jsp" %>

<c:forEach items="${param.products}" var="product" varStatus="status">

    <c:if test="${status.index % 3 == 0}">
        <div class="row l-row-collapse">
    </c:if>

    <div class="col-xs-12 col-sm-4">

        <div class="row mosaic-3column-item-option">
            <div class="mosaic-3column-item-container">
                <div class="row mosaic-3column-container">
                    <div class="col-xs-6">
                        <div>
                            <div class="mosaic-media">
                                <img src="imgs/mosaic/img11.jpg" alt=""/>
                            </div>
                        </div>
                    </div>

                    <div class="col-xs-6 mosaic-3column-front-back-container flip-container">

                        <div class="mosaic-3column-front flip-front-fade">
                            <div class="mosaic-3column-media theme-mosaic-3column-front l-padding-t-15">
                                <img src="imgs/logo/logo_tqual_black.png" alt=""/>
                                <p>front</p>
                            </div>
                        </div>

                        <div class="mosaic-3column-back flip-back-fade">
                            <div class="mosaic-3column-media theme-mosaic-3column-back l-padding-t-15">
                                <img src="imgs/logo/logo_tqual_white.png" alt=""/>
                                <p>back</p>
                            </div>
                        </div>

                    </div>

                </div>

                <div class="row mosaic-3column-item-content">
                    {{> mosaic3columnitem_detail }}
                </div>

            </div>
        </div>

    </div>

    <c:if test="${status.index % 3 == 2}">
        </div>
    </c:if>

</c:forEach>