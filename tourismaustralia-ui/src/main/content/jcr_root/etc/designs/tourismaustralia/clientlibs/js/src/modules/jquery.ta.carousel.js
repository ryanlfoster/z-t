/*!
 * jQuery lightweight plugin boilerplate
 * Original author: @ajpiano
 * Further changes, comments: @addyosmani
 * Licensed under the MIT license
 *
 * ..............................................................................
 *
 * Carousel Jquery Plugin
 * http://owlgraphic.com/owlcarousel/
 *
 * items : 3, //10 items above 1000px browser width
 * itemsDesktop : [1000,3], //5 items between 1000px and 901px
 * itemsDesktopSmall : [900,2], // betweem 900px and 801px
 * itemsTablet: [800,1], //2 items between 451 and 800
 * itemsMobile : [450,1], //1 items between 450 and 0
 * navigation: false, // Display "next" and "prev" buttons.
 * pagination: true, // Show pagination.
 * itemsScaleUp : true //Option to not stretch items when it is less than the supplied items
 */

;(function($, window, document, undefined) {

	// Create the defaults once
	var pluginName = 'carousel', defaults = {
        items : 3, //10 items above 1000px browser width
        itemsDesktop : [1000,3], //5 items between 1000px and 901px
        itemsDesktopSmall : [900,2], // betweem 900px and 801px
        itemsTablet: [800,1], //2 items between 451 and 800
        itemsMobile : [450,1], //1 items between 450 and 0
        navigation: false, // Display "next" and "prev" buttons.
        pagination: true, // Show pagination.
        itemsScaleUp : true //Option to not stretch items when it is less than the supplied items
	};

	// The actual plugin constructor
	function Plugin(element, options) {
		this.element = element;
		this.options = $.extend({}, defaults, options);
		this._defaults = defaults;
		this._name = pluginName;

        //console.log("init-carousel");

        $(this.element).owlCarousel(this.options);

	}

    // A really lightweight plugin wrapper around the constructor,
	// preventing against multiple instantiations
	$.fn[pluginName] = function(options) {
		return this.each(function() {
			if (!$.data(this, 'plugin_' + pluginName)) {
				$.data(this, 'plugin_' + pluginName, new Plugin(this, options));
			}
		});
	};

	//init all carousel objects on page automatically -> TBR
	$(window).load(function() {
		$("#carousel").carousel();
	});

})(jQuery, window, document);
