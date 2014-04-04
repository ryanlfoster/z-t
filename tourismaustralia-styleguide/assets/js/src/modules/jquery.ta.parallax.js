/*!
 * jQuery lightweight plugin boilerplate
 * Original author: @ajpiano
 * Further changes, comments: @addyosmani
 * Licensed under the MIT license
 *
 * ..............................................................................
 *
 * parallaxImages Jquery Plugin
 *
 */





 // set parallax css3 tags on body if IE10+
 // find all images with class .parallax-me
 // grab all data attr
 // construct faux scroller-containers on top of document from last image to first
 // set height and hide image on original section
 // set visible if visible else hide


;(function ( $, window, document, undefined ) {

    // Create the defaults once
    var pluginName = 'parallaxImages',
        defaults = {
            parallaxImages : ".parallaxImages", // reference to parallaxImages container
            parallaxImages_item : ".parallaxImages-item",  // reference to the parallaxImages item container
            parallaxImages_container: ".flip-container", // reference item that should trigger a click
            parallaxImages_front: ".parallaxImages-column-front", // reference to front
            parallaxImages_back: ".parallaxImages-column-back", // reference to back
            parallaxImages_content: ".parallaxImages-item-detail-container", // reference to content
            parallaxImages_grid2: ".parallaxImages-grid-2", // parent grid 2 row container
            parallaxImages_grid_content: ".parallaxImages-grid-2-content", // reference to content block for 2 grid
            parallaxImages_detail_close_btn: ".parallaxImages-detail-close-btn" // close button on detail panel
    };

    // The actual plugin constructor
    function Plugin( element, options ) {
        this.element = element;
        this.options = $.extend( {}, defaults, options) ;

        this._defaults = defaults;
        this._name = pluginName;
        //console.log("init-parallaxImages");

        this.init();
    }

    Plugin.prototype.init = function () {
        var scope = this;
        //init events
        //scope.setupparallaxImages(scope);
        scope.setupEvents(scope);
    };

    // add events to items
    Plugin.prototype.setupEvents = function(scope) {
        
    };

    // A really lightweight plugin wrapper around the constructor,
    // preventing against multiple instantiations
    $.fn[pluginName] = function ( options ) {
        return this.each(function () {
            if (!$.data(this, 'plugin_' + pluginName)) {
                $.data(this, 'plugin_' + pluginName,
                    new Plugin( this, options ));
            }
        });
    };

    //init all flipcard objects on page automatically -> TBR
    $(window).load(function() {
        $(".parallaxImages-item").parallaxImages();
        $(".parallaxImages-3column-item-option").parallaxImages({
            parallaxImages : ".parallaxImages",
            parallaxImages_item : ".parallaxImages-3column-item-option",
            parallaxImages_container : ".parallaxImages-3column-container",
            parallaxImages_front: ".parallaxImages-3column-front",
            parallaxImages_back: ".parallaxImages-3column-back",
            parallaxImages_content: ".parallaxImages-item-detail-container"});
    });

})( jQuery, window, document );
