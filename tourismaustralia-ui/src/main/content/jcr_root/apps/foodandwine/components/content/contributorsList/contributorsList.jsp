<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/apps/foodandwine/components/global.jsp"%>


<script>
	$(document).ready(function() {
		var articleCount;
		var searchParameter = "";
		var offsetValue=0;
		var limitValue=20;
		$.ajax({
			type : "POST",
			url : "${resource.path}.contributors.json",
			data : {
				searchParameter : searchParameter,
				offsetValue : offsetValue,
				limitValue : limitValue
				
			},
			success : function(msg) {
				
				$('#searchResults').empty();
				var html="";
				var pagination = "";
				var pageCount;
				$.each(msg,function(key,value){
					 html +='<ul class="sorted-list-category"><div class="row l-row-collapse"><div class="col-xs-12"><h2>'+key+'</h2></div></div>';
					for(var i=0;i<value.length;i++){
						html +='<li class="sorted-list-item"><ul class="row l-row-collapse"><li class="col-xs-6 col-sm-4 col-md-3 col-lg-3"><p>'+value[i].businessName+'</p></li><li class="col-xs-6 col-sm-4 col-md-3 l-display-none-sm"><p>'+value[i].primaryCategory+'</p></li><li class="col-xs-0 col-sm-4 col-md-3 l-display-none-md"><p>'+value[i].state+'</p></li><li class="col-xs-0 col-sm-0 col-md-3 l-display-none-lg"><a href="http://'+value[i].businessWebsite +'" target="_blank">Visit website</a></li></ul></li>';
						$('.form-h3').html("Search out "+value[i].artileCount+" contributers:");
						pageCount= value[i].pageCount;
					}
					html+="</ul>";
                   
				});
				if(pageCount > 1){
					pagination +='<a href="#" class="btn-square icon-font-arrow-previous"></a> <a href="#" class="btn-square icon-font-arrow-left"></a>';
				for(var j=0;j<=pageCount;j++){
					pagination += ' <a href="#" onclick="contributersListCall('+j+')" class="btn-square">'+j+'</a>';
				}
				pagination +=' <a href="#" class="btn-square icon-font-arrow-right"></a> <a href="#" class="btn-square icon-font-arrow-next"></a>';
				}else{
					pagination += '<a href="#" class="btn-square icon-font-arrow-previous"></a> <a href="#" class="btn-square icon-font-arrow-left"></a> <a href="#" onclick="contributersListCall('+pageCount+')" class="btn-square">'+pageCount+'</a> <a href="#" class="btn-square icon-font-arrow-right"></a> <a href="#" class="btn-square icon-font-arrow-next"></a>';
				}
				 $('#searchResults').html(html);
				 $('.sorted-list-pagination .sorted-list-pagination-buttons').html(pagination);
			},
			error : function(xhr) {
			}
		});

	});
	
	
	function contributersListCall(pageId){
		var offsetValue;
		var limitValue;
		if(pageId >1){
			offsetValue = (pageId - 1) * 20;
			limitValue = offsetValue + 20;
        }else{
			offsetValue = (pageId) * 20;
			limitValue = offsetValue + 20;
        }
		
		var search = $("#searchParameter").val();
		$('#searchResults').empty();
		$.ajax({
			type : "POST",
			url : "${resource.path}.contributors.json",
			data : {
				searchParameter : search,
				offsetValue : offsetValue,
				limitValue : limitValue
			},
			success : function(msg) {
				var html="";
				var pagination = "";
				var pageCount;
				$.each(msg,function(key,value){
					 html +='<ul class="sorted-list-category"><div class="row l-row-collapse"><div class="col-xs-12"><h2>'+key+'</h2></div></div>';
					for(var i=0;i<value.length;i++){
						html +='<li class="sorted-list-item"><ul class="row l-row-collapse"><li class="col-xs-6 col-sm-4 col-md-3 col-lg-3"><p>'+value[i].businessName+'</p></li><li class="col-xs-6 col-sm-4 col-md-3 l-display-none-sm"><p>'+value[i].primaryCategory+'</p></li><li class="col-xs-0 col-sm-4 col-md-3 l-display-none-md"><p>'+value[i].state+'</p></li><li class="col-xs-0 col-sm-0 col-md-3 l-display-none-lg"><a href="http://'+value[i].businessWebsite +'" target="_blank">Visit website</a></li></ul></li>';
						$('.form-h3').html("Search out "+value[i].artileCount+" contributers:");
						pageCount= value[i].pageCount;
					}
					html+="</ul>";
					
				});
				
				if(pageCount >1){
					pagination +='<a href="#" class="btn-square icon-font-arrow-previous"></a> <a href="#" class="btn-square icon-font-arrow-left"></a>';
					for(var j=0;j<=pageCount;j++){
						pagination += ' <a href="#" onclick="contributersListCall('+j+')" class="btn-square">'+j+'</a>';
					}
					pagination +=' <a href="#" class="btn-square icon-font-arrow-right"></a> <a href="#" class="btn-square icon-font-arrow-next"></a>';
					}else{
						pagination += '<a href="#" class="btn-square icon-font-arrow-previous"></a> <a href="#" class="btn-square icon-font-arrow-left"></a> <a href="#" onclick="contributersListCall('+pageCount+')" class="btn-square">'+pageCount+'</a> <a href="#" class="btn-square icon-font-arrow-right"></a> <a href="#" class="btn-square icon-font-arrow-next"></a>';
					}
                    $('#searchResults').html(html);
                    $('.sorted-list-pagination .sorted-list-pagination-buttons').html(pagination);
			},
			error : function(xhr) {
			}
		});
	}
	
	
</script>



<h3 class="form-h3 l-padding-top-xs-2 l-padding-bottom-xs-0-5"></h3>
<input class="input-field-blank input-field-big" id="searchParameter"
	placeholder="E.g. Cafe Sydney" />
<a href="#" onclick="contributersListCall(1)" class="btn-secondary btn-auto-size">Search</a>

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
<div id="searchResults"></div>
</div>
<!-- pagination -->
<div class="sorted-list-pagination container">
	<p class="sorted-list-results-label type-font-primary-i">
		Viewing <strong><em>1</em></strong>-<strong><em>25</em></strong> of
		789 results
	</p>
	<div class="sorted-list-pagination-buttons">
		<!-- <a href="#" class="btn-square icon-font-arrow-previous"></a> <a
			href="#" class="btn-square icon-font-arrow-left"></a> <a href="#" onclick="contributersListCall(0,20)"
			class="btn-square">1</a> <a href="#" onclick="contributersListCall(21,40)" class="btn-square is-active">2</a>
		<a href="#" class="btn-square">3</a> <a href="#"
			class="btn-square icon-font-arrow-right"></a> <a href="#"
			class="btn-square icon-font-arrow-next"></a> -->
	</div>
</div>
<!-- END: pagination -->
