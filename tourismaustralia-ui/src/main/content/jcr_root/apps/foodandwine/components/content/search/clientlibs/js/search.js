$(function() {
	$('.faw-hero-home-container').each(
			function() {
				var $this = $(this)
				var searchUrl = $this.data('searchurl')
				var url = $(location).attr('href');
				$this.find('a').click(
						function(e) {
							e.preventDefault();
							var searchParameter = $this.find('input').val();
							var category = $('#categoryDropdown').find(
									'option:selected').val();
							var location = $('#stateDropdown').find(
									'option:selected').val();

							window.location.href = searchUrl + "?q="
									+ encodeURIComponent(searchParameter)
									+ "&category=" + category + "&location="
									+ location;

						})
			});
});

var showmore;
$(function() {
	$('.type-spacing-120').each(
			function() {
				var $this = $(this)
				var searchUrl = $this.data('searchurl')
				if (showmore === undefined) {
					showmore = 10;
				}
				$this.find('.btn-secondary').click(
						function(e) {
							e.preventDefault();
							var searchParameter = getQuerystring("q");
							var category = getQuerystring("category");
							var location = getQuerystring("location");
							showmore = parseInt(showmore) + 10;
							window.location.href = searchUrl + "?q="
									+ encodeURIComponent(searchParameter)
									+ "&category=" + category + "&location="
									+ location + "&showmore=" + showmore;
						})
			});
});
showmore = getQuerystring("showmore");

function getQuerystring(key) {
	var query = window.location.search.substring(1);

	var vars = query.split("&");
	for ( var i = 0; i < vars.length; i++) {
		var pair = vars[i].split("=");
		if (pair[0] == key) {
			return pair[1];
		}
	}
}