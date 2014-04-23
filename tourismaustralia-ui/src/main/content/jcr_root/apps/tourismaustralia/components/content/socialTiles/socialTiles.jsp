<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/apps/tourismaustralia/components/global.jsp"%>
<%@ page
	import="com.australia.www.components.content.socialTiles.SocialTiles"%>
<c:set var="socialTiles" value="<%=new SocialTiles(slingRequest)%>" />


<div class="socialtiles">

	<div class="row l-center-1200">

		<div class="section-intro">
			<div class="l-center-900">
				<h3 class="type-h1-responsive">${socialTiles.title}</h3>
			</div>
		</div>

		<div class="mosaic">

			<div class="row l-row-collapse">

				<div class="row">
					<c:forEach items="${socialTiles.tilesList}" var="loopTile"
						begin="0" end="2">
						<div class="col-xs-12 col-sm-4 mosaic-grid-1 l-row-collapse">
							<div class="row">
								<div class="col-xs-12">
									<c:set var="tile" scope="request" value="${loopTile}" />
									<cq:include script="tile.jsp" />
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
				<c:if test="${socialTiles.hasNine}">
					<div class="row">
						<div class="col-xs-12 col-sm-4 mosaic-grid-1 l-row-collapse">
							<div class="row">
								<div class="col-xs-12">
									<c:set var="tile" scope="request"
										value="${socialTiles.tilesList[3]}" />
									<cq:include script="tile.jsp" />
								</div>
							</div>
						</div>
						<div class="col-xs-12 col-sm-4 mosaic-grid-4 l-row-collapse">

							<div class="row mosaic-grid-2">
								<div class="row mosaic-grid-2-tile">
									<div class="col-xs-12 col-sm-6">
										<c:set var="tile" scope="request"
											value="${socialTiles.tilesList[4]}" />
										<cq:include script="tile.jsp" />
									</div>
									<div class="col-xs-12 col-sm-6">
										<c:set var="tile" scope="request"
											value="${socialTiles.tilesList[5]}" />
										<cq:include script="tile.jsp" />
									</div>
								</div>
								<div class="row mosaic-grid-2-content">
									<div class="col-xs-12">
										<div class="mosaic-item-detail-container">
											<!-- content start -->
											<div class="l-h-center theme-mosaic-social-detail">
												<p>NON-VISIBLE DATA</p>
												<p>
													Uploaded by: <a href="#">notsupposedto</a>
												</p>
											</div>
											<!-- content end -->
										</div>
									</div>
								</div>
							</div>

							<div class="row mosaic-grid-2">
								<div class="row mosaic-grid-2-tile">
									<div class="col-xs-12 col-sm-6">
										<c:set var="tile" scope="request"
											value="${socialTiles.tilesList[6]}" />
										<cq:include script="tile.jsp" />
									</div>
									<div class="col-xs-12 col-sm-6">
										<c:set var="tile" scope="request"
											value="${socialTiles.tilesList[7]}" />
										<cq:include script="tile.jsp" />
									</div>
								</div>
								<div class="row mosaic-grid-2-content">
									<div class="col-xs-12">
										<div class="mosaic-item-detail-container">
											<div class="l-h-center theme-mosaic-social-detail">
												<p>NON-VISIBLE DATA</p>
												<p>
													Uploaded by: <a href="#">notsupposedto</a>
												</p>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="col-xs-12 col-sm-4 mosaic-grid-1 l-row-collapse">
							<div class="row">
								<div class="col-xs-12">
									<c:set var="tile" scope="request"
										value="${socialTiles.tilesList[8]}" />
									<cq:include script="tile.jsp" />
								</div>
							</div>
						</div>
					</div>
				</c:if>

			</div>

		</div>
	</div>



	<c:if test="${socialTiles.hasSubTitle}">
		<div class="socialtiles-linethrough">
			<div class="line-through-container">
				<div class="line-through">
					<span class="line-through-hr"></span>
				</div>
				<div class="line-through-container-biline">
					${socialTiles.subTitle}</div>
				<div class="line-through">
					<span class="line-through-hr"></span>
				</div>
			</div>
		</div>
	</c:if>
	
	<div class="l-h-center">
		<a href="${socialTiles.link.path }" class="btn-primary">${socialTiles.link.title}</a>
	</div>

</div>