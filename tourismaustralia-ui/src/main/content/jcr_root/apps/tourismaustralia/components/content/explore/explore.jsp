<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/apps/tourismaustralia/components/global.jsp" %>
<%@ page import="com.australia.www.components.content.explore.Explore" %>
<c:set var="explore" value="<%=new Explore(slingRequest) %>"/>

<div class="explore-container">
<div class="section-intro">
	<div class="l-center-900">
		<h3 class="type-h1-responsive">
			EXPLORE BEYOND THE CITY LIMITS
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
					<c:if test="${explore.tabs[0].hasTitle}">
						<option><c:out value="${explore.tabs[0].title}"/> </option>
					</c:if>
					<c:if test="${explore.tabs[1].hasTitle}">
						<option><c:out value="${explore.tabs[1].title}"/> </option>
					</c:if>
					<c:if test="${explore.tabs[2].hasTitle}">
						<option><c:out value="${explore.tabs[2].title}"/> </option>
					</c:if>
					<c:if test="${explore.tabs[3].hasTitle}">
						<option><c:out value="${explore.tabs[3].title}"/> </option>
					</c:if>
					<c:if test="${explore.tabs[4].hasTitle}">
						<option><c:out value="${explore.tabs[4].title}"/> </option>
					</c:if>
				</select>
			</div>
			<hr>
		</div>
	</div>

	<!-- Buttons -->
	<div class="section-buttons-desktop">
		<c:if test="${explore.tabs[0].hasTitle}">
		<a href="#" class="btn-bubble btn-bubble-min-width is-active btn-category-extra-space">
    <span class="btn-bubble-button">
    <img class="btn-bubble-std" src="${explore.tabs[0].iconImagePath}" alt=""/>
    <img class="btn-bubble-active" src="${explore.tabs[0].iconImagePath}" alt=""/>
    </span>
			<span class="type-below-btn"><c:out value="${explore.tabs[0].title}"/></span>
		</a>
		</c:if>
		<c:if test="${explore.tabs[1].hasTitle}">
		<a href="#" class="btn-bubble btn-bubble-min-width btn-category-extra-space">
    <span class="btn-bubble-button">
    <img class="btn-bubble-std" src="${explore.tabs[1].iconImagePath}" alt=""/>
    <img class="btn-bubble-active" src="${explore.tabs[1].iconImagePath}" alt=""/>
    </span>
			<span class="type-below-btn"><c:out value="${explore.tabs[1].title}"/></span>
		</a>
		</c:if>
		<c:if test="${explore.tabs[2].hasTitle}">
		<a href="#" class="btn-bubble btn-bubble-min-width btn-category-extra-space">
    <span class="btn-bubble-button">
    <img class="btn-bubble-std" src="${explore.tabs[2].iconImagePath}" alt=""/>
    <img class="btn-bubble-active" src="${explore.tabs[2].iconImagePath}" alt=""/>
    </span>
			<span class="type-below-btn"><c:out value="${explore.tabs[2].title}"/></span>
		</a>
		</c:if>
		<c:if test="${explore.tabs[3].hasTitle}">
		<a href="#" class="btn-bubble btn-bubble-min-width btn-category-extra-space">
    <span class="btn-bubble-button">
    <img class="btn-bubble-std" src="${explore.tabs[3].iconImagePath}" alt=""/>
    <img class="btn-bubble-active" src="${explore.tabs[3].iconImagePath}" alt=""/>
    </span>
			<span class="type-below-btn"><c:out value="${explore.tabs[3].title}"/></span>
		</a>
		</c:if>
		<c:if test="${explore.tabs[4].hasTitle}">
		<a href="#" class="btn-bubble btn-bubble-min-width btn-category-extra-space">
    <span class="btn-bubble-button">
    <img class="btn-bubble-std" src="${explore.tabs[4].iconImagePath}" alt=""/>
    <img class="btn-bubble-active" src="${explore.tabs[4].iconImagePath}" alt=""/>
    </span>
			<span class="type-below-btn"><c:out value="${explore.tabs[4].title}"/></span>
		</a>
		</c:if>
	</div>
</div>
<div class="carousel-center-container">
<div class="carousel-owl-mobile-fill">
<div id="carousel" class="owl-carousel owl-theme">
<div class="carousel-item">
	<div class="explore-item-container flip-container">
		<div class="flipper">
			<div class="explore-card-front flip-front theme-mosaic-3column-front ieAntialias">
				<!-- include category type "nature" to class to use that colour base -->
				<div class="explore-image-container nature type-spacing-40">
					<img class="l-image-full explore-image" src="${explore.tabs[0].cards[0].pageImagePath}" alt="" />
					<div class="explore-item-diamond">
						<!-- icons, aboriginal_australia, adventure, art_culture, beaches,
						food_wine, island, nature_wildlife, outback, sports -->
						<img src="imgs/icons/nature_wildlife.png" alt="" />
					</div>
				</div>
				<div class="line-through-container">
					<div class="line-through"><span class="line-through-hr"></span></div>
					<div class="line-through-container-biline">
						<c:out value="${explore.tabs[0].cards[0].pageTitle}"/>
					</div>
					<div class="line-through"><span class="line-through-hr"></span></div>
				</div>
				<div class="l-h-center l-padding-tb-30-lr-15">
					<a id="explore-flip-btn" href="" class="btn-bubble">
    <span class="btn-bubble-tooltip">
    <span class="btn-bubble-tooltip-container">
    Show map
    </span>
    </span>
    <span class="btn-bubble-button">
    <img class="btn-bubble-std" src="imgs/icons/mappin_outline.png" alt=""/>
    <img class="btn-bubble-active" src="imgs/icons/mappin.png" alt=""/>
    </span>
					</a>
					<p><c:out value="${explore.tabs[0].cards[0].pageDescription}"/></p>
					<p><a href="#">View more information</a></p>
					<a href="#" class="btn-bubble bubble-colour-favourite">
    <span class="btn-bubble-tooltip">
    <span class="btn-bubble-tooltip-container">
    Add to your dream trip
    </span>
    </span>
    <span class="btn-bubble-button">
    <img class="btn-bubble-std" src="imgs/icons/favourite_outline.png" alt=""/>
    <img class="btn-bubble-active" src="imgs/icons/favourite.png" alt=""/>
    </span>
					</a>
				</div>
			</div>
			<div class="explore-card-back flip-back ieAntialias">
				<img class="l-image-full explore-image-back" src="imgs/placeholders/explore_map.jpg" alt="" />
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
					<p><a id="explore-flip-back-btn" href="#">Back to overview</a></p>
				</div>
			</div>
		</div>
	</div></div>
<div class="carousel-item">
	<div class="explore-item-container flip-container">
		<div class="flipper">
			<div class="explore-card-front flip-front theme-mosaic-3column-front ieAntialias">
				<!-- include category type "nature" to class to use that colour base -->
				<div class="explore-image-container nature type-spacing-40">
					<img class="l-image-full explore-image" src="imgs/placeholders/explore.jpg" alt="" />
					<div class="explore-item-diamond">
						<!-- icons, aboriginal_australia, adventure, art_culture, beaches,
						food_wine, island, nature_wildlife, outback, sports -->
						<img src="imgs/icons/nature_wildlife.png" alt="" />
					</div>
				</div>
				<div class="line-through-container">
					<div class="line-through"><span class="line-through-hr"></span></div>
					<div class="line-through-container-biline">
						Blue mountains
					</div>
					<div class="line-through"><span class="line-through-hr"></span></div>
				</div>
				<div class="l-h-center l-padding-tb-30-lr-15">
					<a id="explore-flip-btn" href="" class="btn-bubble">
    <span class="btn-bubble-tooltip">
    <span class="btn-bubble-tooltip-container">
    Show map
    </span>
    </span>
    <span class="btn-bubble-button">
    <img class="btn-bubble-std" src="imgs/icons/mappin_outline.png" alt=""/>
    <img class="btn-bubble-active" src="imgs/icons/mappin.png" alt=""/>
    </span>
					</a>
					<p>You’ll love the blue-hazed beauty of the Blue Mountains World Heritage Area – one million hectares of tall forests, sandstone cliffs, canyons, waterfalls and bushland. Take in the breathtaking panoramas...</p>
					<p><a href="#">View more information</a></p>
					<a href="#" class="btn-bubble bubble-colour-favourite">
    <span class="btn-bubble-tooltip">
    <span class="btn-bubble-tooltip-container">
    Add to your dream trip
    </span>
    </span>
    <span class="btn-bubble-button">
    <img class="btn-bubble-std" src="imgs/icons/favourite_outline.png" alt=""/>
    <img class="btn-bubble-active" src="imgs/icons/favourite.png" alt=""/>
    </span>
					</a>
				</div>
			</div>
			<div class="explore-card-back flip-back ieAntialias">
				<img class="l-image-full explore-image-back" src="imgs/placeholders/explore_map.jpg" alt="" />
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
					<p><a id="explore-flip-back-btn" href="#">Back to overview</a></p>
				</div>
			</div>
		</div>
	</div></div>
<div class="carousel-item">
	<div class="explore-item-container flip-container">
		<div class="flipper">
			<div class="explore-card-front flip-front theme-mosaic-3column-front ieAntialias">
				<!-- include category type "nature" to class to use that colour base -->
				<div class="explore-image-container nature type-spacing-40">
					<img class="l-image-full explore-image" src="imgs/placeholders/explore.jpg" alt="" />
					<div class="explore-item-diamond">
						<!-- icons, aboriginal_australia, adventure, art_culture, beaches,
						food_wine, island, nature_wildlife, outback, sports -->
						<img src="imgs/icons/nature_wildlife.png" alt="" />
					</div>
				</div>
				<div class="line-through-container">
					<div class="line-through"><span class="line-through-hr"></span></div>
					<div class="line-through-container-biline">
						Blue mountains
					</div>
					<div class="line-through"><span class="line-through-hr"></span></div>
				</div>
				<div class="l-h-center l-padding-tb-30-lr-15">
					<a id="explore-flip-btn" href="" class="btn-bubble">
    <span class="btn-bubble-tooltip">
    <span class="btn-bubble-tooltip-container">
    Show map
    </span>
    </span>
    <span class="btn-bubble-button">
    <img class="btn-bubble-std" src="imgs/icons/mappin_outline.png" alt=""/>
    <img class="btn-bubble-active" src="imgs/icons/mappin.png" alt=""/>
    </span>
					</a>
					<p>You’ll love the blue-hazed beauty of the Blue Mountains World Heritage Area – one million hectares of tall forests, sandstone cliffs, canyons, waterfalls and bushland. Take in the breathtaking panoramas...</p>
					<p><a href="#">View more information</a></p>
					<a href="#" class="btn-bubble bubble-colour-favourite">
    <span class="btn-bubble-tooltip">
    <span class="btn-bubble-tooltip-container">
    Add to your dream trip
    </span>
    </span>
    <span class="btn-bubble-button">
    <img class="btn-bubble-std" src="imgs/icons/favourite_outline.png" alt=""/>
    <img class="btn-bubble-active" src="imgs/icons/favourite.png" alt=""/>
    </span>
					</a>
				</div>
			</div>
			<div class="explore-card-back flip-back ieAntialias">
				<img class="l-image-full explore-image-back" src="imgs/placeholders/explore_map.jpg" alt="" />
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
					<p><a id="explore-flip-back-btn" href="#">Back to overview</a></p>
				</div>
			</div>
		</div>
	</div></div>
</div>
</div>
</div>
</div>