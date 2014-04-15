<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/apps/tourismaustralia/components/global.jsp" %>
<%@ page import="com.australia.www.components.content.socialTile.SocialTile" %>
<c:set var="socialTiles" value="<%=new SocialTile(slingRequest)%>"/>



<div class="socialtiles">

    <div class="row l-center-1200">

		<div class="section-intro">
		    <div class="l-center-900">
		        <h3 class="type-h1-responsive">
			        <c:if test="${socialTiles.title}">
			        	${socialTiles.title}
			        </c:if>
		        </h3>
		    </div>
		    {{#if copy}}
		    <div class="l-center-640 type-center">
		        <p class="type-intro">
		                {{{copy}}}
		        </p>
		    </div>
		    {{/if}}
		</div>

        <div class="mosaic">

		    <div class="row l-row-collapse">
		
		        <div class="row">
		
    				<c:forEach items="${socialTiles.tilesList}" var="tile">
						<div class="col-xs-12 col-md-6 mosaic-grid-1 l-row-collapse">
						    <div class="row">
						        <div class="col-xs-12">
						            <div class="mosaic-item">
									    <div class="mosaic-front-back-container flip-container">
									        <div class="flipper">
									
									            <div class="mosaic-column-front flip-front">
									                <div class="mosaic-media mosaic-primary">
									                    <img src="imgs/mosaic/img3.jpg" alt=""/>
									                </div>
									                <div class="mosaic-overlay">
									                    <div class="vertical-container">
									                        <div class="vertical-content text-center">
									                            <span class="label-destination type-destination theme-beaches">Manly Beach</span>
									                        </div>
									                    </div>
									                </div>
									            </div>
									
									            <div class="mosaic-column-back mosaic-content flip-back mosaic-back theme-arts">
									                <div class="vertical-container">
									                    <div class="vertical-content text-center">
															<img src="${tile.iconPath}" alt="" />
									                        <p class="type-destination line-through-line-wrapper">Manly Beach</p>
									                    </div>
									                </div>
									            </div>
									
									        </div>
									    </div>
									
									    <div class="mosaic-item-detail-container">
										    <div class="mosaic-item-container">
										
										        <div class="l-h-center type-spacing-20">
										            <img src="imgs/icons/art_culture.png" alt="" />
										        </div>
										
												<div class="line-through-container">
												    <div class="line-through"><span class="line-through-hr"></span></div>
												    <div class="line-through-container-biline">
												        {{#if copy}}
												            {{{copy}}}
												        {{else}}
												            Blue mountains
												        {{/if}}
												    </div>
												    <div class="line-through"><span class="line-through-hr"></span></div>
												</div>
										
										        <div class="l-h-center l-padding-tb-30-lr-15">
										
										            <p>You'll love the blue-hazed beauty of the Blue Mountains World Heritage Area - one million hectares of tall forests, sandstone cliffs, canyons, waterfalls and bushland. Take in the breathtaking panoramas...</p>
										            <p><a href="#">View more information</a></p>
										
										            <a href="#" class="btn-bubble bubble-colour-favourite">
										                <span class="btn-bubble-tooltip">
										                    <span class="btn-bubble-tooltip-container">
										                        Add to your dream trip
										                    </span>
										                </span>
										                <span class="btn-bubble-button">
										                    <img class="btn-bubble-std" src="imgs/icons/favourite_outline.png" alt="" />
										                    <img class="btn-bubble-active" src="imgs/icons/favourite.png" alt="" />
										                </span>
										            </a>
										
										        </div>
										    </div>
										</div>
									
									</div>
						        </div>
						    </div>
						</div>
		            </c:forEach>
		
		        </div>
		
		        <div class="row">
		
		            {{> mosaic_socialtiles_grid_1 }}
		
		            {{> mosaic_socialtiles_grid_4 }}
		
		            {{> mosaic_socialtiles_grid_1 }}
		
		        </div>
		
		    </div>
		</div>


        <div class="socialtiles-linethrough">
			<div class="line-through-container">
			    <div class="line-through"><span class="line-through-hr"></span></div>
			    <div class="line-through-container-biline">
			        {{#if copy}}
			            {{{copy}}}
			        {{else}}
			            Blue mountains
			        {{/if}}
			    </div>
			    <div class="line-through"><span class="line-through-hr"></span></div>
			</div>
        </div>

        <div class="l-h-center">
            <a href="#" class="btn-primary">Find out how</a>
        </div>

    </div>

</div>