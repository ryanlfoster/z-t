<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/apps/foodandwine/components/global.jsp"%>
<%@ page
	import="com.australia.foodandwine.components.content.otherExperiences.OtherExperiences"%>

<c:set var="otherExperiences"
	value="<%=new OtherExperiences(slingRequest) %>" />

<div class="l-center">
	<div class="experiences">
		<div class="head-divider experiences-head-divider">
			<div class="head-divider-inner">
				<hr class="icon-logo-withlines-hr icon-logo-withlines-hr-small">
				<h5>
					<img src="${otherExperiences.logoPath}"
						style="width: 60px; height: 59px" />
				</h5>
				<hr class="icon-logo-withlines-hr icon-logo-withlines-hr-small">
			</div>
		</div>
		<h5 class='experiences-headline'>${otherExperiences.smallTextTitle }</h5>
		<h2>${otherExperiences.largeTextTitle }</h2>
		<hr class="divider-small">
		<div class="faw-experience">
			<div class='faw-experience-outer'>
				<div class='faw-experience-wrapper'>
					<ul class="carousel-wrapper faw-experience-carousel"
						data-mobilemaxresolution="1200" data-startindex="0"
						data-disablecarouselondesktop="true" data-showsingleitem='true'>
						<c:forEach items="${otherExperiences.articlesList}" var="item">
							<li class="item">
								<ul class="imagecarousel-item">
									<li><a href="#">
											<div class='mosaic-item'>
												<img src="${item.articleImage }"
													style="width: 268px; height: 268px" />
												<div class='mosaic-item-description'>
													<p class="mosaic-item-description-head type-font-feature">
														${item.articleTitle }</p>
													<p class="mosaic-item-description-sub">${item.articleSubTitle }</p>
													<p class="mosaic-item-description-copy">
														${item.articleDescription }<br> <br> <a
															href="${item.articlePath}"><strong>Read more</strong></a>
													</p>
												</div>
												<div class='mosaic-item-overlay mosaic-item-overlay-info'>
													<div class='mosaic-item-overlay-info-icon'>
														<span class="mosaic-item-overlay-info-icon-item"><img
															src="${item.articleOverLayLogoPath }"
															style="width: 80px; height: 56px" alt=""></span>
														<p class="mosaic-item-overlay-info-head type-font-feature">
															${item.articleTitle }</p>
														<p class="mosaic-item-overlay-info-desciption">${item.articleSubTitle }<br>
															<br> <a href='${item.articlePath}'><strong>Find
																	out more</strong></a>
														</p>
													</div>
													<p class="mosaic-item-overlay-info-categories">
														<strong>${item.articleOverlayText }</strong>
													</p>
												</div>
											</div>
									</a></li>
								</ul>
							</li>
							<li class="item"></li>
						</c:forEach>
					</ul>
				</div>
			</div>
		</div>
	</div>
</div>