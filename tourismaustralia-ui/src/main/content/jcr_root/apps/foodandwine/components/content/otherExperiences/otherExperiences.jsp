<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/apps/foodandwine/components/global.jsp"%>
<%@ page
	import="com.australia.foodandwine.components.content.otherExperiences.OtherExperiences"%>

<c:set var="otherExperiences"
	value="<%=new OtherExperiences(slingRequest) %>" />
<c:if test="${not empty otherExperiences.articlesList }">
	<div class="l-center">
		<div class="experiences">
			<div class="head-divider experiences-head-divider">
				<div class="head-divider-inner">
					<hr class="icon-logo-withlines-hr icon-logo-withlines-hr-small">
					<h5>
						<img src="/etc/designs/foodandwine/clientlibs/imgs/base/header-map-icon.png"
							style="width: 60px; height: 59px" />
					</h5>
					<hr class="icon-logo-withlines-hr icon-logo-withlines-hr-small">
				</div>
			</div>
			<h5 class='experiences-headline'>Other Experiences in</h5>
			<h2>${otherExperiences.stateTitle }</h2>
			<hr class="divider-small">
			<div class="faw-experience">
				<div class='faw-experience-outer'>
					<div class='faw-experience-wrapper'>
						<ul class="carousel-wrapper faw-experience-carousel"
							data-mobilemaxresolution="1200" data-startindex="0"
							data-disablecarouselondesktop="true" data-showsingleitem='true'>
							<c:forEach items="${otherExperiences.articlesList}" var="item">
								<li class="item">
									<div class='mosaic-item'>
										<img class='mosaic-item-image' src="${item.image }" alt="" width="100%"/>

										<div class='mosaic-item-description'>
											<p class="mosaic-item-description-head type-font-feature">${item.title }</p>
											<p class="mosaic-item-description-sub">${item.state}</p>
										</div>
										<div class='mosaic-item-overlay mosaic-item-overlay-info'>
											<div class='mosaic-item-overlay-info-icon'>
												<span class="mosaic-item-overlay-info-icon-item">
													<img src="${item.icon }" style="width: 80px; height: 56px" alt="">
												</span>
												<p class="mosaic-item-overlay-info-head type-font-feature">
													${item.title }
												</p>
												<p class="mosaic-item-overlay-info-desciption">${item.city }, ${item.state }
													<br>
													<br> 
													<a href='${item.path}'><strong>Find out more</strong></a>
												</p>
											</div>
											<p class="mosaic-item-overlay-info-categories">
												<strong>${fn:join(item.tags,',')}...</strong>
											</p>
										</div>
									</div>
								</li>
								<li class="item"></li>
							</c:forEach>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</c:if>