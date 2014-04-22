<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
								<a href="${tile.link}"><fmt:message key="See More" /></a>
								<!-- back content end -->

							</div>
						</div>

						<!-- social icon start -->
						<span class="mosaic-socialtiles-icon"><img
							src=<c:url value="${title.iconPath}"/> alt="" /></span>
						<!-- social icon end -->

					</div>

				</div>
			</div>

			<div class="mosaic-item-detail-container">

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
						src="/etc/designs/tourismaustralia/clientlibs/img/base/spacer.gif"
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