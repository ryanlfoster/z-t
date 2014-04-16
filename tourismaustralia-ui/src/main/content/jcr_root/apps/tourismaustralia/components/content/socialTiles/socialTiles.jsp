<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/apps/tourismaustralia/components/global.jsp" %>
<%@ page import="com.australia.www.components.content.socialTiles.SocialTiles" %>
<c:set var="socialTiles" value="<%=new SocialTiles(slingRequest)%>"/>


<div class="socialtiles">

    <div class="row l-center-1200">

		<div class="section-intro">
		    <div class="l-center-900">
		        <h3 class="type-h1-responsive">
					TEMPORARY WORDS
		        </h3>
		    </div>
		</div>
		
    <div class="mosaic">

	    <div class="row l-row-collapse">
	
	        <div class="row">
				<c:choose>
				<c:when test="${socialTiles.hasEleven }">
				<!-- 11 TILES BEGIN -->
				<c:forEach items="${socialTiles.tilesList}" var="tile" begin="0" end="2"> 
	            <!-- single item start -->
	            <c:choose>
	            <c:when test="${tile.hasImage}">
				<div class="col-xs-12 col-sm-4 mosaic-grid-1 l-row-collapse">
				    <div class="row">
				        <div class="col-xs-12">
				            <div class="mosaic-item">
							    <div class="mosaic-front-back-container flip-container">
							        <div class="flipper">
							
							            <div class="mosaic-column-front flip-front">
							                <div class="mosaic-media mosaic-primary">
							                    <img src=<c:url value="${tile.imagePath}"/> alt=""/>
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
							                    <span class="mosaic-socialtiles-icon"><img src=<c:url value="${tile.iconPath}"/> alt=""/></span>
							                    <!-- social icon end -->
							
							                </div>
							            </div>
							
							            <div class="mosaic-column-back mosaic-content flip-back mosaic-back theme-mosaic-social-back">
							                <div class="vertical-container">
							                    <div class="vertical-content text-center">
							
							                        <!-- back content start -->
							                        <p class="type-destination"><strong>${tile.title}</strong><br><br></p>
							                        <a href="${tile.link}">See more</a>
							                        <!-- back content end -->
							
							                    </div>
							                </div>
							
							                <!-- social icon start -->
							                <span class="mosaic-socialtiles-icon"><img src=<c:url value="${title.iconPath}"/> alt=""/></span>
							                <!-- social icon end -->
							
							            </div>
							
							        </div>
							    </div>
							
								<div class="mosaic-item-detail-container">
								
								    <!-- content start -->
								    <div class="l-h-center theme-mosaic-social-detail">
								
								    ${tile.text}
								
								    </div>
								    <!-- content end -->
								
								</div>
							
							</div>
						</div>
					</div>
				</div>
	            </c:when>
	            <c:otherwise>
				<div class="col-xs-12 col-sm-4 mosaic-grid-1 l-row-collapse">
				    <div class="row">
				        <div class="col-xs-12">
				            <div class="mosaic-item">

							    <div class="socialtiles-static-front">
							        <div class="mosaic-media mosaic-primary">
							            <img src="/etc/designs/tourismaustralia/clientlibs/img/base/spacer.gif" alt=""/>
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
							            <span class="mosaic-socialtiles-icon"><img src=<c:url value="${tile.iconPath}"/> alt=""/></span>
							            <!-- social icon end -->
							
							        </div>
							    </div>
							
							</div>
				        </div>
				    </div>
				</div>
				</c:otherwise>
				</c:choose>
				<!-- single item end -->
				</c:forEach>
				<!-- 11 TILES END -->
				</c:when>
				<c:otherwise>
				<!--  3 TILES BEGIN -->
	        	<c:forEach items="${socialTiles.tilesList}" var="tile" begin="0" end="2"> 
	            <!-- single item start -->
	            <c:choose>
	            <c:when test="${tile.hasImage}">
				<div class="col-xs-12 col-sm-4 mosaic-grid-1 l-row-collapse">
				    <div class="row">
				        <div class="col-xs-12">
				            <div class="mosaic-item">
							    <div class="mosaic-front-back-container flip-container">
							        <div class="flipper">
							
							            <div class="mosaic-column-front flip-front">
							                <div class="mosaic-media mosaic-primary">
							                    <img src=<c:url value="${tile.imagePath}"/> alt=""/>
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
							                    <span class="mosaic-socialtiles-icon"><img src=<c:url value="${tile.iconPath}"/> alt=""/></span>
							                    <!-- social icon end -->
							
							                </div>
							            </div>
							
							            <div class="mosaic-column-back mosaic-content flip-back mosaic-back theme-mosaic-social-back">
							                <div class="vertical-container">
							                    <div class="vertical-content text-center">
							
							                        <!-- back content start -->
							                        <p class="type-destination"><strong>${tile.title}</strong><br><br></p>
							                        <a href="${tile.link}">See more</a>
							                        <!-- back content end -->
							
							                    </div>
							                </div>
							
							                <!-- social icon start -->
							                <span class="mosaic-socialtiles-icon"><img src=<c:url value="${title.iconPath}"/> alt=""/></span>
							                <!-- social icon end -->
							
							            </div>
							
							        </div>
							    </div>
							
								<div class="mosaic-item-detail-container">
								
								    <!-- content start -->
								    <div class="l-h-center theme-mosaic-social-detail">
								
								    ${tile.text}
								
								    </div>
								    <!-- content end -->
								
								</div>
							
							</div>
						</div>
					</div>
				</div>
	            </c:when>
	            <c:otherwise>
				<div class="col-xs-12 col-sm-4 mosaic-grid-1 l-row-collapse">
				    <div class="row">
				        <div class="col-xs-12">
				            <div class="mosaic-item">

							    <div class="socialtiles-static-front">
							        <div class="mosaic-media mosaic-primary">
							            <img src="/etc/designs/tourismaustralia/clientlibs/img/base/spacer.gif" alt=""/>
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
							            <span class="mosaic-socialtiles-icon"><img src=<c:url value="${tile.iconPath}"/> alt=""/></span>
							            <!-- social icon end -->
							
							        </div>
							    </div>
							
							</div>
				        </div>
				    </div>
				</div>
				</c:otherwise>
				</c:choose>
				<!-- single item end -->
				</c:forEach>
				</c:otherwise>
				</c:choose>
				<!-- 3 TILES END -->
	
	        </div>
	
	        <div class="row">
	
	        </div>
	
	    </div>
	</div>
    	
    	
    	
    	
        <div class="socialtiles-linethrough">
			<div class="line-through-container">
			    <div class="line-through"><span class="line-through-hr"></span></div>
			    <div class="line-through-container-biline">
					TEMPORARY WORDS
			    </div>
			    <div class="line-through"><span class="line-through-hr"></span></div>
			</div>
        </div>

        <div class="l-h-center">
            <a href="#" class="btn-primary">Find out how</a>
        </div>

    </div>

</div>