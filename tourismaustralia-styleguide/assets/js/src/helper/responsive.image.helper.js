/*!
 * Responsive Image Height Helper
 * Responsive image helper to set the image container height based on current image height.
 */
var responsiveImageHelper = {};

responsiveImageHelper.bindEvents = function(){

	if (!window.addEventListener) {		
		window.attachEvent('resize', responsiveImageHelper.setContainerHeight);
		window.attachEvent('orientationchange', responsiveImageHelper.setContainerHeight);
	} else {
		$(window).resize(function(){
		// Get screen size (inner/outerWidth, inner/outerHeight)
			responsiveImageHelper.setContainerHeight();
		});

		window.addEventListener('orientationchange', function() {
			// Announce the new orientation number
			responsiveImageHelper.setContainerHeight();
		}, false);
	};

	responsiveImageHelper.setContainerHeight();

	// Initiate parallax
	$('.parallax').parallaxImages({
	    parallaxSpeed : 1
	});

};

responsiveImageHelper.setContainerHeight = function(){
	$('.largeimage-container').each(function(){
		var offSet = $(this).find('img').height() * parseFloat(20) / 100,
			maxImageHeight = 600, // Max height of responsive images
			heightOfImage = $(this).find('img').height() - offSet;

		heightOfImage = ( heightOfImage <= maxImageHeight ) ? heightOfImage : maxImageHeight;

		$(this).css('height', heightOfImage);
		$(this).find('img').css('margin-top', -($(this).find('img').height() / 2));
	});
};

$(window).bind('load', function() {
	responsiveImageHelper.bindEvents();



	// Used for new parallax


	$('.img-holder').imageScroll({
		holderClass: 'parallaxHolder',
		extraHeight: 200,
		coverRatio: 0.50,
		container: $('#main-content')
	});
	
});