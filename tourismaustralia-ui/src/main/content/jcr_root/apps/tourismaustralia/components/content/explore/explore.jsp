<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/apps/tourismaustralia/components/global.jsp" %>
<%@ page import="com.australia.www.components.content.explore.Explore" %>
<c:set var="explore" value="<%=new Explore(slingRequest) %>"/>

<div class="explore-container">
	<div class="section-intro">
		<div class="l-center-900">
			<h3 class="type-h1-responsive">
				<fmt:message key="EXPLORE BEYOND THE CITY LIMITS"/>
			</h3>
		</div>
		<div class="l-center-640 type-center">
			<p class="type-intro">
				Make Sydney where your adventure begins. World-heritage natural wonders, world-class wine regions, and the world’s most stunning beaches are just over the horizon.
			</p>
		</div>
	</div>
	<div class="l-h-center section-buttons">
		<!-- Select List For Mobile -->
		<div class="section-buttons-mobile">
			<div class="dropdown-select">
				<hr>
					<div class="dropdown-select-style">
						<select>
							<c:forEach items="${explore.tabs}" var="tab">
								<c:if test="${tab.hasTitle}">
									<option><c:out value="${tab.title}"/> </option>
								</c:if>
							</c:forEach>
						</select>
					</div>
				<hr>
			</div>
		</div>
			<!-- Buttons -->
		<div class="section-buttons-desktop">
			<c:forEach items="${explore.tabs}" var="tab">
				<c:if test="${tab.hasTitle}">
					<a href="#" class="btn-bubble btn-bubble-min-width is-active btn-category-extra-space">
						<span class="btn-bubble-button">
							<img class="btn-bubble-std" src="<c:url value='${tab.iconImagePath}'/>" alt=""/>
							<img class="btn-bubble-active" src="<c:url value='${tab.selectedImagePath}'/>" alt=""/>
						</span>
							<span class="type-below-btn"><c:out value="${tab.title}"/>
						</span>
					</a>
				</c:if>
			</c:forEach>
		</div>
	</div>

	<div class="carousel-center-container">
	<div class="carousel-owl-mobile-fill">
	<div id="carousel" class="owl-carousel owl-theme">
    <%-- Tab 1 Carousel --%>
	<c:forEach items="${explore.tabs[0].cards}" var="card">
	<div class="carousel-item">
		<div class="explore-item-container flip-container">
			<div class="flipper">
				<div class="explore-card-front flip-front theme-mosaic-3column-front ieAntialias">
					<!-- include category type "nature" to class to use that colour base -->
					<div class="explore-image-container nature type-spacing-40">
						<img class="l-image-full explore-image" src="<c:url value='${card.pageImagePath}'/>" alt="" />
						<div class="explore-item-diamond">
							<!-- icons, aboriginal_australia, adventure, art_culture, beaches,
							food_wine, island, nature_wildlife, outback, sports -->
							<img src="/etc/designs/tourismaustralia/clientlibs/imgs/icons/nature_wildlife.png" alt="" />
						</div>
					</div>
					<div class="line-through-container">
						<div class="line-through"><span class="line-through-hr"></span></div>
						<div class="line-through-container-biline">
							<c:out value="${card.pageTitle}"/>
						</div>
						<div class="line-through"><span class="line-through-hr"></span></div>
					</div>
					<div class="l-h-center l-padding-tb-30-lr-15">
						<a id="explore-flip-btn" href="" class="btn-bubble">
							<span class="btn-bubble-tooltip">
							<span class="btn-bubble-tooltip-container">
							<fmt:message key="Show map"/>
							</span>
							</span>
							<span class="btn-bubble-button">
							<img class="btn-bubble-std" src="/etc/designs/tourismaustralia/clientlibs/imgs/icons/mappin_outline.png" alt=""/>
							<img class="btn-bubble-active" src="/etc/designs/tourismaustralia/clientlibs/imgs/icons/mappin.png" alt=""/>
							</span>
						</a>
						<p><c:out value="${card.pageDescription}"/></p>
						<p><a href="<c:url value='${card.pagePath}'/>"><fmt:message key="View more information"/></a></p>
						<a href="#" class="btn-bubble bubble-colour-favourite" data-pagepath="<c:url value='${card.pagePath}'/>">
							<span class="btn-bubble-tooltip">
								<span class="btn-bubble-tooltip-container">
									<fmt:message key="Add to your dream trip"/>
								</span>
							</span>
							<span class="btn-bubble-button">
								<img class="btn-bubble-std" src="/etc/designs/tourismaustralia/clientlibs/imgs/icons/favourite_outline.png" alt=""/>
								<img class="btn-bubble-active" src="/etc/designs/tourismaustralia/clientlibs/imgs/icons/favourite.png" alt=""/>
							</span>
						</a>
					</div>
				</div>
				<div class="explore-card-back flip-back ieAntialias">
					<img class="l-image-full explore-image-back" src="<c:url value='${card.imageBack}'/>" alt="" />
					<div class="l-h-center l-padding-tb-30-lr-15">
						<ul class="explore-trip">
							<li>
								<span class="explore-trip-icon icon-font-Transport_Icon"></span>
								<span class="explore-trip-time">3 hours</span>
							</li>
							<li>
								<span class="explore-trip-icon icon-font-Hire_Icon"></span>
								<span class="explore-trip-time">2 hours</span>
							</li>
						</ul>
						<p>Travel time to Blue Mountains from Sydney</p>
						<hr>
						<p><a id="explore-flip-back-btn" href="#"><fmt:message key="Back to overview"/></a></p>
					</div>
				</div>
			</div>
		</div>
	</div>
	</c:forEach>

	</div>
	</div>
	</div>

</div>