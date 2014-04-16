var navScroller = navScroller || {};

navScroller.sectionDistances = {};

navScroller.init = function(){

	// store distances from top for each section.	
	$('.navScroller-section').each(function(index, value) {
		navScroller.sectionDistances[index] = $(this).offset().top;
	});

	navScroller._bindEvents();
	navScroller._updateActive();

};

// populate nav with click events based on this distance
navScroller._bindEvents = function(){

	$('a[href*=#]:not([href=#])', '.navScroller').click(function() {
		if (location.pathname.replace(/^\//,'') == this.pathname.replace(/^\//,'') && location.hostname == this.hostname) {
			
			var target = $(this.hash);
			target = target.length ? target : $('[data-section-name=' + this.hash.slice(1) +']');

			if (target.length) {
				$('html,body').animate({
				  scrollTop: target.offset().top - 30 // offset to accommodate navbar
				}, 1000);

				console.log(this.hash.slice(1));

				$('.active', '.navScroller').removeClass('active');
				if(this.hash.slice(1) != 'top'){
					$('a[href=#' + this.hash.slice(1) +']', '.navScroller').parent().addClass('active');
				}

				return false;
			}
		}
	});
};

// check if section is in view
navScroller._updateActive = function(){

};

$(function() {
	navScroller.init();	
});


