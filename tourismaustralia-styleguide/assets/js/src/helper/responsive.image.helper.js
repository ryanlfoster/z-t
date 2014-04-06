/*!
 * Responsive Image Height Helper
 * Responsive image helper to set the image container height based on current image height.
 */
var responsiveImageHelper = {};

responsiveImageHelper.bindEvents = function(){

	if (!window.addEventListener) {		
		window.attachEvent('resize', responsiveImageHelper.setContainerHeight());
		window.attachEvent('orientationchange', responsiveImageHelper.setContainerHeight());
	} else {
		window.addEventListener('resize', function() {
		// Get screen size (inner/outerWidth, inner/outerHeight)
			responsiveImageHelper.setContainerHeight();
		}, false);

		window.addEventListener('orientationchange', function() {
			// Announce the new orientation number
			responsiveImageHelper.setContainerHeight();
		}, false);
	};

	responsiveImageHelper.setContainerHeight();

};

responsiveImageHelper.setContainerHeight = function(){
	$('.largeimage-container').each(function(){
		var offSet = 80,
			maxImageHeight = 600, // Max height of responsive images
			heightOfImage = $(this).find('img').height() - offSet;

		heightOfImage = ( heightOfImage <= maxImageHeight ) ? heightOfImage : maxImageHeight;

		$(this).css('height', heightOfImage);
		$(this).find('img').css('margin-top', -($(this).find('img').height() / 2));	
		
	});
};

$(window).bind('load', function() {
	responsiveImageHelper.bindEvents();
});