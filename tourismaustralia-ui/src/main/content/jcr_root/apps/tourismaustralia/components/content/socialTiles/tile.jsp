<%@include file="/apps/tourismaustralia/components/global.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="iconPath" value="/etc/designs/tourismaustralia/clientlibs/imgs/"/>

<div class="mosaic-item">
	<c:choose>
		<c:when test="${tile.hasImage}">
			<div class="mosaic-front-back-container flip-container">
				<div class="flipper">

					<div class="mosaic-column-front flip-front">
						<div class="mosaic-media mosaic-primary">
							<img src=<c:url value="${tile.imagePath}"/> alt="" />
						</div>
						<div class="mosaic-overlay">
							<div class="vertical-container">
								<div class="vertical-content text-center">
									<div class="type-date-mosaic">

										<!-- front content start -->
										<!-- front content end -->

									</div>
								</div>
							</div>

							<!-- social icon start -->
							<span class="mosaic-socialtiles-icon"><img
								src=<c:url value="${tile.iconPath}"/> alt="" /></span>
							<!-- social icon end -->

						</div>
					</div>

					<div
						class="mosaic-column-back mosaic-content flip-back mosaic-back theme-mosaic-social-back">
						<div class="vertical-container">
							<div class="vertical-content text-center">

								<!-- back content start -->
								<p class="type-destination">
									<strong>${tile.title}</strong><br> <br>
								</p>
								<fmt:message key="See More" />
								<!-- back content end -->

							</div>
						</div>

						<!-- social icon start -->
						<span class="mosaic-socialtiles-icon"><img
							src=<c:url value="${tile.iconPath}"/> alt="" /></span>
						<!-- social icon end -->
					</div>

				</div>
			</div>

			<div class="mosaic-item-detail-container">
                <%--Close button // start --%>
                <span class="mosaic-close-icon">
                    <a class="mosaic-detail-close-btn" href="#">
                        <img src="${iconPath}icons/close_outline.png" alt="">
                    </a>
                </span>
                <%--Close button // end --%>
				<!-- content start -->
				<div class="l-h-center theme-mosaic-social-detail">

					${tile.text}</div>
				<!-- content end -->

			</div>

		</c:when>
		<c:otherwise>

			<div class="socialtiles-static-front">
				<div class="mosaic-media mosaic-primary">
					<img
						src="/etc/designs/tourismaustralia/clientlibs/imgs/base/spacer.gif"
						alt="" />
				</div>
				<div class="mosaic-overlay">
					<div class="vertical-container">
						<div class="vertical-content text-center">
							<div class="type-socialtiles-static-mosaic">

								<!-- front content start -->
								${tile.text}
								<!-- front content end -->

							</div>
						</div>
					</div>

					<!-- social icon start -->
					<span class="mosaic-socialtiles-icon"><img
						src=<c:url value="${tile.iconPath}"/> alt="" /></span>
					<!-- social icon end -->

				</div>
			</div>

		</c:otherwise>
	</c:choose>
</div>