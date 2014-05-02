<%--
  Created by: Greg Snyder
  Date: 01/04/2014

--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/apps/tourismaustralia/components/global.jsp"%>

<c:forEach items="${products}" var="product" varStatus="status">

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
								<img src="${product.image}" alt="" />
							</div>
						</div>
					</div>

					<div
						class="col-xs-6 mosaic-3column-front-back-container flip-container">

						<div class="mosaic-3column-front flip-front-fade">
							<div
								class="mosaic-3column-media theme-mosaic-3column-front l-padding-t-15">
								<%-- Use visibility:hidden to hide in order to maintain layout and prevent text from shifting --%>
								<img
									src="/etc/designs/tourismaustralia/clientlibs/imgs/logo/logo_tqual_black.png"
									<c:if test="${!product.tqual}">style="visibility: hidden"</c:if>
									alt="" />
								<p>${product.title}</p>
							</div>
						</div>

						<div class="mosaic-3column-back flip-back-fade">
							<div
								class="mosaic-3column-media theme-mosaic-3column-back l-padding-t-15">
								<%-- Use visibility:hidden to hide in order to maintain layout and prevent text from shifting --%>
								<img
									src="/etc/designs/tourismaustralia/clientlibs/imgs/logo/logo_tqual_white.png"
									<c:if test="${!product.tqual}">style="visibility: hidden"</c:if>
									alt="" />
								<p>${product.title}</p>
							</div>
						</div>

					</div>

				</div>

				<div class="row mosaic-3column-item-content">

					<div class="mosaic-item-detail-container">
						<div class="mosaic-item-container">

							<div class="line-through-container">
								<div class="line-through">
									<span class="line-through-hr"></span>
								</div>
								<div class="line-through-container-biline">
									${product.title}</div>
								<div class="line-through">
									<span class="line-through-hr"></span>
								</div>
							</div>

							<div class="l-h-center l-padding-tb-30-lr-15">

								<p>${product.description}</p>

								<a href="#" data-pagepath="${product.productPath}"
									class="btn-bubble bubble-colour-favourite"> <span
									class="btn-bubble-tooltip"> <span
										class="btn-bubble-tooltip-container"> <fmt:message
												key="Add to your dream trip" />
									</span>
								</span> <span class="btn-bubble-button"> <img
										class="btn-bubble-std"
										src="/etc/designs/tourismaustralia/clientlibs/imgs/icons/favourite_outline.png"
										alt="" /> <img class="btn-bubble-active"
										src="/etc/designs/tourismaustralia/clientlibs/imgs/icons/favourite.png"
										alt="" />
								</span>
								</a>

							</div>
						</div>
					</div>
				</div>

			</div>
		</div>

	</div>

	<c:if test="${status.index % 3 == 2 || status.last}">
		</div>
	</c:if>

</c:forEach>