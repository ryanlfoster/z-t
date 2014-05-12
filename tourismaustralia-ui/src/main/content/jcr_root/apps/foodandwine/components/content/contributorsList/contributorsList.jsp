<%@include file="/apps/foodandwine/components/global.jsp"%>
<%@ page import="com.australia.foodandwine.components.content.contributorslist.ContributorsList" %>

<c:set var="cl" value="<%=new ContributorsList(slingRequest) %>"/>

<cq:includeClientLib js="faw-contributerslist"/>

<div class='form-hero'>
<div class='faw-hero-home-container' data-searchurl="${cl.searchPath}">
        <h3 class="form-h3 l-padding-top-xs-2 l-padding-bottom-xs-0-5">Search our ${cl.totalExperiencesCount} contributers: ${cl.searchParameter}</h3>
        <input class='input-field-blank input-field-big input-field-normal-left-border' placeholder="E.g. Cafe Sydney"/>
        <a href="#" class="btn-secondary btn-auto-size">Search</a>
    </div>
</div>

<c:choose>
	<c:when test="${cl.searchResult.totalCount > 0}">
	<div class="sorted-list container">
		<!-- head selection for desktop -->
		<div class="sorted-list-head l-display-none-md">
			<ul class="row l-row-collapse">
				<li class="col-xs-6 col-sm-4 col-md-3 col-lg-3">
					<p class="sorted-list-sort-button type-font-feature">Name</p>
				</li>
				<li class="col-xs-6 col-sm-4 col-md-3 l-display-none-sm">
					<p class="sorted-list-sort-button type-font-feature">Primary Category</p>
				</li>
				<li class="col-xs-0 col-sm-4 col-md-3 l-display-none-md">
					<p class="sorted-list-sort-button type-font-feature">State</p>
				</li>
				<li class="col-xs-0 col-sm-0 col-md-3 l-display-none-lg">
					<p class="sorted-list-sort-button type-font-feature">Website</p>
				</li>
			</ul>
		</div>
		<ul class="sorted-list-category">
			<!-- item row -->
			<c:forEach var="exp" items="${cl.searchResult.articleMap}">
				<div class="row l-row-collapse">
		            <div class="col-xs-12">
		                <h2>${exp.key}</h2>
		            </div>
	        	</div>
                <c:forEach var="list" items="${exp.value}">
	                <li class="sorted-list-item">
						<ul class="row l-row-collapse">
							<li class="col-xs-6 col-sm-4 col-md-3 col-lg-3">
								<p>
								<c:choose>
								<c:when test="${not empty list.link}">
								<a href="${list.link}" style="text-decoration:none">${list.title }</a>
								</c:when>
								<c:otherwise>
									${list.title }
								</c:otherwise>
								</c:choose>
								</p>
							</li>
							<li class="col-xs-6 col-sm-4 col-md-3 l-display-none-sm">
								<p>
									${list.primaryCategory}
								</p>
							</li>
							<li class="col-xs-0 col-sm-4 col-md-3 l-display-none-md">
								<p>
									${list.state}
								</p>
							</li>
							<li class="col-xs-0 col-sm-0 col-md-3 l-display-none-lg">
								<c:choose>
									<c:when test="${not empty list.website}">
										<a href="${list.website}" target="_blank">Visit website</a>
									</c:when>
									<c:otherwise>
										<strong>-</strong>
									</c:otherwise>
								</c:choose>
							</li>
						</ul>
					</li>
				  </c:forEach>
			</c:forEach>
		</ul>
	</div>
	<!-- pagination -->
	<div class="sorted-list-pagination container">
		<p class="sorted-list-results-label type-font-primary-i">
			Viewing <strong><em>${((cl.searchResult.page-1) * cl.resultsPerPage) + 1 }</em></strong>-<strong><em>${cl.searchResult.page * cl.resultsPerPage > cl.searchResult.totalCount ? cl.searchResult.totalCount : cl.searchResult.page * cl.resultsPerPage}</em></strong> of ${cl.searchResult.totalCount} results
		</p>
		<c:if test="${cl.pages > 1}">
			<div class="sorted-list-pagination-buttons">
				<c:if test="${cl.searchResult.page != 1 }">
					<a href="${fn:replace(cl.paginationPath,'{0}','1')}" class="btn-square icon-font-arrow-previous"></a>
					<c:set var="replacement" value="${cl.searchResult.page - 1}"/>
					<a href="${fn:replace(cl.paginationPath,'{0}',replacement)}" class="btn-square icon-font-arrow-left"></a>
					<c:set var="newreplacement" value="${cl.searchResult.page -2}"/>
					<c:if test="${cl.searchResult.page != 1 && newreplacement >0}">
						<a href="${fn:replace(cl.paginationPath,'{0}',newreplacement)}" class="btn-square">${newreplacement}</a>
					</c:if>
					<a href="${fn:replace(cl.paginationPath,'{0}',replacement)}" class="btn-square">${replacement}</a>
				</c:if>	
				<a href="#" class="btn-square is-active">${cl.searchResult.page}</a>
				<c:if test="${cl.searchResult.page != cl.pages }">
					<c:set var="replacement" value="${cl.searchResult.page +1}"/>
					<a href="${fn:replace(cl.paginationPath,'{0}',replacement)}" class="btn-square">${replacement}</a>
					<c:set var="newreplacement" value="${cl.searchResult.page +2}"/>
					<c:if test="${cl.searchResult.page != 1 && newreplacement <=cl.pages}">
						<a href="${fn:replace(cl.paginationPath,'{0}',newreplacement)}" class="btn-square">${newreplacement}</a>
					</c:if>
					<a href="${fn:replace(cl.paginationPath,'{0}',replacement)}" class="btn-square icon-font-arrow-right"></a>
					<a href="${fn:replace(cl.paginationPath,'{0}',cl.pages)}" class="btn-square icon-font-arrow-next"></a>
				</c:if>
			</div>
		</c:if>
	</div>
	</c:when>
	<c:otherwise>
		<div class="sorted-list container">
			<p class="type-font-primary-i">
				No Results Found
			</p>
		</div>
	</c:otherwise>
</c:choose>
<!-- END: pagination -->
