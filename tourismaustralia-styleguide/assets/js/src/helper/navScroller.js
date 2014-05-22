var navScroller = navScroller || {};

navScroller.sectionDistances = {};
navScroller.sectionLinks = new Array();

navScroller.init = function(){

	// store distances from top for each section.
	$('.navScroller-section').each(function(index, value) {

        if( $("html").hasClass("lt-ie9") ) {
            //Disabled for IE8 only
            //var offset   = getPosition($(this)[0]).top;
            //navScroller.sectionDistances[index] = offset;
        }
        else
        {
            navScroller.sectionDistances[index] = $(this).offset().top;
        }


        var hashLink = $(this).attr('data-section-name');
        navScroller.sectionLinks.push($('ul.navScroller a[href="#'+ hashLink +'"]'));
	});

	navScroller._bindEvents();
	navScroller._updateActive();

};

//hack for IE-8 not working properly
function getPosition(element) {
    var xPosition = 0;
    var yPosition = 0;

    while(element) {
        xPosition += (element.offsetLeft - element.scrollLeft + element.clientLeft);
        yPosition += (element.offsetTop - element.scrollTop + element.clientTop);
        element = element.offsetParent;
    }
    return { x: xPosition, y: yPosition };
}

// populate nav with click events based on this distance
navScroller._bindEvents = function(){

	$('a[href*=#]:not([href=#])', '.navScroller').click(function() {
		if (location.pathname.replace(/^\//,'') == this.pathname.replace(/^\//,'') && location.hostname == this.hostname) {
			
			var target = $(this.hash);
			target = target.length ? target : $('[data-section-name=' + this.hash.slice(1) +']');

			if (target.length) {

				$('html,body').animate({
				  scrollTop: target.offset().top - ($('.main-nav-panel').height() - 1) // offset to accommodate navbar
				}, 1000);

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

    var distance1, distance2;
    var hashLink;
    var totalNo_navScroller_section=$('.navScroller-section').size();
    $window = $(window);


    $window.scroll(function() {
        $('.navScroller-section').each(function(index){

            //Top of current section
            distance1 = navScroller.sectionDistances[index];

            if(index < totalNo_navScroller_section-1)
            {
                //Top of next to current section
                distance2 = navScroller.sectionDistances[index + 1];

                if ( $window.scrollTop() >= distance1 && $window.scrollTop() < distance2 )
                {
                    //Reset current active state
                    $('ul.navScroller li.active').removeClass('active');

                    //Set active to link in 'navScroller' according to current section
                    $(navScroller.sectionLinks[index]).parent().addClass('active');
                }
            }
            else{

                if ( $window.scrollTop() >= distance1)
                {
                    //Reset Current active state
                    $('ul.navScroller li.active').removeClass('active');

                    //Set active to link in 'navScroller' according to current section
                    $(navScroller.sectionLinks[index]).parent().addClass('active');
                }
            }
        });
    });
};


$(function() {
	navScroller.init();	
});


