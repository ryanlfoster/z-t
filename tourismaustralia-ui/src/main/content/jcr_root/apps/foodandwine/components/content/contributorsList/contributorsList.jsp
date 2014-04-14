<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/apps/foodandwine/components/global.jsp"%>
<%@ page import="com.australia.foodandwine.components.content.contributorsList.ContributorsList" %>

<c:set var="contributorsList" value="<%=new ContributorsList(slingRequest) %>"/>


<script>
	var searchParameter = $(".form-h3 .input-field-blank").val();
	$(document).ready(function() {
		$(".btn-secondary").click(function() {
			$.ajax({
				type : "POST",
				url : "${resource.path}.contributors.json",
				data : {
					searchParameter : searchParameter
				},
				success : function(msg) {
					console.log(msg);

				},
				error : function(xhr) {
				}
			});
		});
	});
</script>



<h3 class="form-h3 l-padding-top-xs-2 l-padding-bottom-xs-0-5">Search
	out 789 contributers:</h3>
<input class="input-field-blank input-field-big"
	placeholder="E.g. Cafe Sydney" />
<a href="#" class="btn-secondary btn-auto-size">Search</a>

<div class="sorted-list container">
	<!-- head selection for desktop -->
	<div class="sorted-list-head l-display-none-md">
		<ul class="row l-row-collapse">
			<li class="col-xs-6 col-sm-4 col-md-3 col-lg-3"><a
				class="sorted-list-sort-button sorted-list-sort-active type-font-feature"
				href="" target="_self">Name</a></li>
			<li class="col-xs-6 col-sm-4 col-md-3 l-display-none-sm"><a
				class="sorted-list-sort-button sorted-list-sort-inactive type-font-feature"
				href="" target="_self">Primary Category</a></li>
			<li class="col-xs-0 col-sm-4 col-md-3 l-display-none-md"><a
				class="sorted-list-sort-button sorted-list-sort-inactive type-font-feature"
				href="" target="_self">Stage</a></li>
			<li class="col-xs-0 col-sm-0 col-md-3 l-display-none-lg">
				<p class="sorted-list-sort-button type-font-feature">Website</p>
			</li>
		</ul>
	</div>
	<!-- END: head selection -->
	<!-- head selection for mobile -->
	<div class="sorted-list-head-mobile l-display-md">
		<select class="input-select input-select-small">
			<option value="nsw"><p class="type-font-feature">Filter
					by Name</p>
			</option>
			<option value="southernaustralia">Filter by Category</option>
			<option value="victoria">Filter by State/Region</option>
		</select>
	</div>
	<!-- END: head selection -->
	<!-- category -->
	
	<c:forEach items="${contributorsList.artileMap}" var="item">
	<ul class="sorted-list-category">
		<div class="row l-row-collapse">
			<div class="col-xs-12">
				<h2>${item.key}</h2>
			</div>
		</div>
		<!-- item row -->
		<c:forEach items="${item.value }" var="list">
		<li class="sorted-list-item">
			<ul class="row l-row-collapse">
				<li class="col-xs-6 col-sm-4 col-md-3 col-lg-3">
					<p>${list.businessName}</p>
				</li>
				<li class="col-xs-6 col-sm-4 col-md-3 l-display-none-sm">
					<p></p>
				</li>
				<li class="col-xs-0 col-sm-4 col-md-3 l-display-none-md">
					<p>${list.state}</p>
				</li>
				<li class="col-xs-0 col-sm-0 col-md-3 l-display-none-lg"><a
					href="http://${list.businessWebsite }" target="_blank">Visit website</a></li>
			</ul>
		</li>
		</c:forEach>
		
	</ul>
	</c:forEach>
	
</div>
<!-- pagination -->
<div class="sorted-list-pagination container">
	<p class="sorted-list-results-label type-font-primary-i">
		Viewing <strong><em>1</em></strong>-<strong><em>25</em></strong> of
		789 results
	</p>
	<div class="sorted-list-pagination-buttons">
		<a href="#" class="btn-square icon-font-arrow-previous"></a> <a
			href="#" class="btn-square icon-font-arrow-left"></a> <a href="#"
			class="btn-square">1</a> <a href="#" class="btn-square is-active">2</a>
		<a href="#" class="btn-square">3</a> <a href="#"
			class="btn-square icon-font-arrow-right"></a> <a href="#"
			class="btn-square icon-font-arrow-next"></a>
	</div>
</div>
<!-- END: pagination -->
