
$(function(){
	$('.form-hero .faw-hero-home-container').each(function(){
		var $this=$(this)
		var searchUrl = $this.data('searchurl')
		$this.find('.btn-secondary').click(function(e){
			e.preventDefault();
			var searchParameter=$this.find('input').val();
			window.location.href=searchUrl + "?q=" + encodeURIComponent(searchParameter);
		})
	});
});


