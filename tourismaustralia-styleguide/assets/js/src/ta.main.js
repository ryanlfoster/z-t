$(function(){

	// Used for new parallax
	var touch = Modernizr.touch,
		csstransforms3d = Modernizr.csstransforms3d;

	if(csstransforms3d === true){
		$('.img-holder').imageScroll({
			holderClass: 'parallaxHolder',
			extraHeight: 200,
			coverRatio: 0.50,
			container: $('#main-content'),
			parallax: csstransforms3d,
			touch: touch
		});
	};

	


});