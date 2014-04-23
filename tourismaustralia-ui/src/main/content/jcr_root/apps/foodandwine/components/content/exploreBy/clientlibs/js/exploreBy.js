$(function() {  
	$('.select-trigger-link').on('change', function(e) {
		e.preventDefault();
		var url = $(this).val();
		if (url) {
			window.location.href = url;
		}
	});
});