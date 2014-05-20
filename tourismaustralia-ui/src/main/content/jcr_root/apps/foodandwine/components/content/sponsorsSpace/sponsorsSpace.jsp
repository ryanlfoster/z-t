<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/apps/foodandwine/components/global.jsp"%>
<%@ page
	import="com.australia.foodandwine.components.content.sponsorsSpace.SponsorsSpace"%>


<c:set var="sponsorsSpace" value="<%=new SponsorsSpace(slingRequest) %>" />

<div class="faw-sponsors">
	<div class='faw-sponsors-outer'>
		<div class='faw-sponsors-wrapper'>
			<ul class="carousel-wrapper faw-sponsors-carousel"
				data-mobilemaxresolution="1200" data-startIndex="0"
				data-disablecarouselondesktop="true">
				<c:if test="${not empty sponsorsSpace.sponsor1.bigTitle }">
					<li class="faw-sponsors-carousel-item">
						<div class="sponsors-wrapper">
							<div class="row sponsors-item type-spacing-30">
								<div class="sponsors-row-1 type-spacing-15">
									<c:if test="${not empty sponsorsSpace.sponsor1.bigTitle}">
										<div class="sponsors-type-title type-spacing-15">${sponsorsSpace.sponsor1.bigTitle }</div>
									</c:if>
									<hr class="sponsors-hr">
								</div>
								<div class="row sponsors-row-2">
									<div class="sponsors-image-link-container">
										<c:if test="${empty sponsorsSpace.sponsor1.imageTitle}">
											<div class="video-link-container">
										</c:if>
										<c:if test="${not empty sponsorsSpace.sponsor1.imagePath}">
											<a href="${sponsorsSpace.sponsor1.linkTextPath}" target="${sponsorsSpace.sponsor1.external? '_blank':'self'}">
											<img src="${sponsorsSpace.sponsor1.imagePath }" class="sponsors-image ${empty sponsorsSpace.sponsor1.imageTitle ? 'type-spacing-15' : '' }" alt="${sponsorsSpace.sponsor1.imageAltTag}">
											</a>
										</c:if>
										<c:if test="${not empty sponsorsSpace.sponsor1.imageTitle }">
											<p>${sponsorsSpace.sponsor1.imageTitle }</p>
										</c:if>
										<c:if test="${empty sponsorsSpace.sponsor1.imageTitle }">
											</div>
										</c:if>
									</div>
								</div>
								<div class="row sponsors-row-3">
									<c:choose>
										<c:when test="${sponsorsSpace.sponsor1.external }">
											<c:if test="${not empty sponsorsSpace.sponsor1.linkTextPath }">
											<a href="${sponsorsSpace.sponsor1.linkTextPath }" target="_BLANK"
												class="sponsors-link">${sponsorsSpace.sponsor1.linkText }</a>
												</c:if>
										</c:when>
										<c:otherwise>
											<c:if test="${not empty sponsorsSpace.sponsor1.linkTextPath }">
											<a href="${sponsorsSpace.sponsor1.linkTextPath }" class="sponsors-link">${sponsorsSpace.sponsor1.linkText }</a>
										</c:if>
										</c:otherwise>
									</c:choose>
								</div>
							</div>
						</div>
					</li>
				</c:if>
				
				<c:if test="${not empty sponsorsSpace.sponsor2.bigTitle }">
					<li class="faw-sponsors-carousel-item">
						<div class="sponsors-wrapper">
							<div class="row sponsors-item type-spacing-30">
								<div class="sponsors-row-1 type-spacing-15">
									<c:if test="${not empty sponsorsSpace.sponsor2.bigTitle}">
										<div class="sponsors-type-title type-spacing-15">${sponsorsSpace.sponsor2.bigTitle }</div>
									</c:if>
									<hr class="sponsors-hr">
								</div>
								<div class="row sponsors-row-2">
									<div class="sponsors-image-link-container">
										<c:if test="${empty sponsorsSpace.sponsor2.imageTitle}">
											<div class="video-link-container">
										</c:if>
										<c:if test="${not empty sponsorsSpace.sponsor2.imagePath}">
											<a href="${sponsorsSpace.sponsor2.linkTextPath}" target="${sponsorsSpace.sponsor2.external? '_blank':'self'}">
												<img src="${sponsorsSpace.sponsor2.imagePath }" class="sponsors-image ${empty sponsorsSpace.sponsor2.imageTitle ? 'type-spacing-15' : '' }" alt="${sponsorsSpace.sponsor2.imageAltTag}">
											</a>
										</c:if>
										<c:if test="${not empty sponsorsSpace.sponsor2.imageTitle }">
											<p>${sponsorsSpace.sponsor2.imageTitle }</p>
										</c:if>
										<c:if test="${empty sponsorsSpace.sponsor2.imageTitle }">
											</div>
										</c:if>
									</div>
								</div>
								<div class="row sponsors-row-3">
									<c:choose>
										<c:when test="${sponsorsSpace.sponsor2.external }">
											<c:if test="${not empty sponsorsSpace.sponsor2.linkTextPath }">
											<a href="${sponsorsSpace.sponsor2.linkTextPath }" target="_BLANK"
												class="sponsors-link">${sponsorsSpace.sponsor2.linkText }</a>
												</c:if>
										</c:when>
										<c:otherwise>
											<c:if test="${not empty sponsorsSpace.sponsor2.linkTextPath }">
											<a href="${sponsorsSpace.sponsor2.linkTextPath }" class="sponsors-link">${sponsorsSpace.sponsor2.linkText }</a>
										</c:if>
										</c:otherwise>
									</c:choose>
								</div>
							</div>
						</div>
					</li>
				</c:if>
				
				<c:if test="${not empty sponsorsSpace.sponsor3.bigTitle }">
					<li class="faw-sponsors-carousel-item">
						<div class="sponsors-wrapper">
							<div class="row sponsors-item type-spacing-30">
								<div class="sponsors-row-1 type-spacing-15">
									<c:if test="${not empty sponsorsSpace.sponsor3.bigTitle}">
										<div class="sponsors-type-title type-spacing-15">${sponsorsSpace.sponsor3.bigTitle }</div>
									</c:if>
									<hr class="sponsors-hr">
								</div>
								<div class="row sponsors-row-2">
									<div class="sponsors-image-link-container">
										<c:if test="${empty sponsorsSpace.sponsor3.imageTitle}">
											<div class="video-link-container">
										</c:if>
										<c:if test="${not empty sponsorsSpace.sponsor3.imagePath}">
											<a href="${sponsorsSpace.sponsor3.linkTextPath}" target="${sponsorsSpace.sponsor3.external? '_blank':'self'}">
												<img src="${sponsorsSpace.sponsor3.imagePath }" class="sponsors-image ${empty sponsorsSpace.sponsor3.imageTitle ? 'type-spacing-15' : '' }" alt="${sponsorsSpace.sponsor3.imageAltTag}">
											</a>
										</c:if>
										<c:if test="${not empty sponsorsSpace.sponsor3.imageTitle }">
											<p>${sponsorsSpace.sponsor3.imageTitle }</p>
										</c:if>
										<c:if test="${empty sponsorsSpace.sponsor3.imageTitle }">
											</div>
										</c:if>
									</div>
								</div>
								<div class="row sponsors-row-3">
									<c:choose>
										<c:when test="${sponsorsSpace.sponsor3.external }">
											<c:if test="${not empty sponsorsSpace.sponsor3.linkTextPath }">
											<a href="${sponsorsSpace.sponsor3.linkTextPath }" target="_BLANK"
												class="sponsors-link">${sponsorsSpace.sponsor3.linkText }</a>
												</c:if>
										</c:when>
										<c:otherwise>
											<c:if test="${not empty sponsorsSpace.sponsor3.linkTextPath }">
											<a href="${sponsorsSpace.sponsor3.linkTextPath }" class="sponsors-link">${sponsorsSpace.sponsor3.linkText }</a>
										</c:if>
										</c:otherwise>
									</c:choose>
								</div>
							</div>
						</div>
					</li>
				</c:if>
			</ul>
		</div>
	</div>
</div>