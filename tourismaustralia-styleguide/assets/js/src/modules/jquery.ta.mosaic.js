/*!
 * jQuery lightweight plugin boilerplate
 * Original author: @ajpiano
 * Further changes, comments: @addyosmani
 * Licensed under the MIT license
 *
 * ..............................................................................
 *
 * Mosaic Jquery Plugin
 *
  * Flips tile when rolled over/off, sets to front view when clicked and reveals content
  * changes other tiles opacity
  * when clicked again or close btn clicked, retracts and resets all tiles opacity
 *
 * mosaic : ".mosaic", // reference to mosaic container
 * mosaic_item : ".mosaic-item",  // reference to the mosaic item container
 * mosaic_container: ".flip-container", // reference item that should trigger a click
 * mosaic_front: ".mosaic-column-front", // reference to front
 * mosaic_back: ".mosaic-column-back", // reference to back
 * mosaic_content: ".mosaic-item-detail-container", // reference to content
 * mosaic_grid2: ".mosaic-grid-2", // parent grid 2 row container
 * mosaic_grid2_content: ".mosaic-grid-2-content", // reference to content block for 2 grid
 * mosaic_detail_close_btn: ".mosaic-detail-close-btn", // close button on detail panel
 * mosaic_close_btn: "<span class='mosaic-close-icon'><a class='mosaic-detail-close-btn' href='#'><img src='imgs/icons/close_outline.png' alt=''/></a></span>" // html for button to close mosaic tile
 */

;(function ( $, window, document, undefined ) {

    // Create the defaults once
    var pluginName = 'mosaic',
        defaults = {
            mosaic : ".mosaic", // reference to mosaic container
            mosaic_item : ".mosaic-item",  // reference to the mosaic item container
            mosaic_container: ".flip-container", // reference item that should trigger a click
            mosaic_front: ".mosaic-column-front", // reference to front
            mosaic_back: ".mosaic-column-back", // reference to back
            mosaic_content: ".mosaic-item-detail-container", // reference to content
            mosaic_grid2: ".mosaic-grid-2", // parent grid 2 row container
            mosaic_grid2_content: ".mosaic-grid-2-content", // reference to content block for 2 grid
            mosaic_detail_close_btn: ".mosaic-detail-close-btn", // close button on detail panel
            mosaic_close_btn: "<span class='mosaic-close-icon'><a class='mosaic-detail-close-btn' href='#'><img src='imgs/icons/close_outline.png' alt=''/></a></span>" // html for button to close mosaic tile
    };

    // The actual plugin constructor
    function Plugin( element, options ) {
        this.element = element;
        this.options = $.extend( {}, defaults, options) ;

        this._defaults = defaults;
        this._name = pluginName;
        //console.log("init-mosaic");

        this.interactiveType = $(this.element).attr('data-interactive-type');
        if (this.interactiveType === undefined){
            this.interactiveType = "fade";  // "fade", default mode, ATDW half card fades to reveal back
                                            // "flip", flip card

        }
        this.transitionType = "is-" + this.interactiveType;

        this.init();
    }

    var numOfCalls_parallaxscroll = 0;
    var int_parallaxscroll;

    Plugin.prototype.scrollfor_parallaxscroll = function () {
        $(window).scrollTop($(window).scrollTop()+1);
    };

    Plugin.prototype.clock_parallaxscroll = function () {
        //window.parallaxscroll();
        $(window).trigger("scroll");
        numOfCalls_parallaxscroll++;
        if(numOfCalls_parallaxscroll == 50){
            numOfCalls_parallaxscroll=0;
            window.clearInterval(int_parallaxscroll);
        }
    };


    Plugin.prototype.init = function () {
        var scope = this;
        //init events except of megamenu items
        var $megamenu_mosaic_item = $(scope.element).parents(".megamenu-mosaic-item");
        if ($megamenu_mosaic_item.length == 0){
            scope.setupEvents(scope);
        }
    };

    // add events to items
    Plugin.prototype.setupEvents = function(scope) {
        var $mosaic_item = $(scope.element);
        var $mosaic = $(scope.element).parents(scope.options.mosaic);
        var $mosaic_container = $(scope.element).find(scope.options.mosaic_container);
        var $mosaic_content = $(scope.element).find(scope.options.mosaic_content);

        //$mosaic_content.prepend(scope.options.mosaic_close_btn);

        var $mosaic_detail_close_btn = $(scope.element).find(scope.options.mosaic_detail_close_btn);

        /*
        if (this.interactiveType != "video"){

        }
        */



        $mosaic_container.click(function(e){



            // check if outbound link tile
            if(!$(this).hasClass('outbound-link')){

                // turn other items opacity on
                $mosaic.find(scope.options.mosaic_item).addClass("is-opacity");
                $mosaic_item.removeClass("is-opacity");

                // copy content for mosaic_grid2 and setup events
                var $mosaic_grid2_content = $(scope.element).parents(scope.options.mosaic_grid2).find(scope.options.mosaic_grid2_content).find(scope.options.mosaic_content);
                scope.setupGrid2Content(scope, $mosaic, $mosaic_content, $mosaic_grid2_content);

                if ($mosaic_item.hasClass('is-trigger-content')){
                    scope.removeClass($mosaic_item, $mosaic_content, $mosaic_grid2_content);
                    // turn other items opacity on
                    $mosaic.find(scope.options.mosaic_item).removeClass("is-opacity");
                }else{
                    // disable any open tiles before showing next tile
                    scope.disableTiles(scope, $mosaic_item, $mosaic_content, $mosaic_grid2_content);
                }
                //$mosaic_item.removeClass('is-flip');
                scope.removeTransition($mosaic_item);

                int_parallaxscroll=self.setInterval(scope.clock_parallaxscroll,10);

                e.preventDefault();
            }
        });



        $mosaic_container.mouseenter(function(e){
            //$mosaic_item.addClass("is-flip");
            scope.addTransition($mosaic_item);
            e.preventDefault();
        });
        $mosaic_container.mouseleave(function(e){
            //$mosaic_item.removeClass("is-flip");
            scope.removeTransition($mosaic_item);
            e.preventDefault();
        });

        $mosaic_detail_close_btn.click(function(e){
            $mosaic_container.trigger("click");
            e.preventDefault();
        });

    };

    Plugin.prototype.disableTiles = function(scope, $mosaic_item, $mosaic_content, $mosaic_grid2_content) {
        var $mosaic = $(scope.element).parents(scope.options.mosaic);
        var $triggered = $mosaic.find('.is-trigger-content');
        if ($triggered.length){
            $triggered.each(function(i, mosaic_item1){
                $mosaic_item1 = $(mosaic_item1);
                var $mosaic_content1 = $mosaic_item1.find(scope.options.mosaic_content);
                var $mosaic_grid2_content1 = $mosaic_item1.parents(scope.options.mosaic_grid2).find(scope.options.mosaic_grid2_content).find(scope.options.mosaic_content);
                scope.removeClass($mosaic_item1, $mosaic_content1, $mosaic_grid2_content1);
            });
            setTimeout(function(){
                scope.addClass($mosaic_item, $mosaic_content, $mosaic_grid2_content);
            }, 800);
        }else{
            scope.addClass($mosaic_item, $mosaic_content, $mosaic_grid2_content);
        }
    };

    Plugin.prototype.addClass = function($mosaic_item, $mosaic_content, $mosaic_grid2_content) {
        $mosaic_item.addClass('is-trigger-content');
        //$(scope.element).find(scope.options.mosaic_content).slideDown({duration: 600, easing: 'swing'});
        $mosaic_content.addClass("active");
        if ($mosaic_item.attr("data-interactive-type") != "video"){
            $mosaic_grid2_content.addClass("active");
        }
    };
    Plugin.prototype.removeClass = function($mosaic_item, $mosaic_content, $mosaic_grid2_content) {
        $mosaic_item.removeClass('is-trigger-content');
        //$(scope.element).find(scope.options.mosaic_content).slideUp({duration: 400, easing: 'swing'});
        $mosaic_content.removeClass("active");
        $mosaic_grid2_content.removeClass("active");
    };

    Plugin.prototype.addTransition = function($target) {
        //check for atdw type 1/2 fade interactivity (instead of standard flip) by data-tag
        $target.addClass(this.transitionType);
    };

    Plugin.prototype.removeTransition = function($target) {
        //check for atdw type 1/2 fade interactivity (instead of standard flip) by data-tag
        $target.removeClass(this.transitionType);
    };

    // close all tiles, remove opacity and fold up
    Plugin.prototype.closeAllTiles = function(scope, $mosaic) {

        // all mosaic its unselect and show
        var $mosaic_items = $mosaic.find(scope.options.mosaic_item);
        $mosaic_items.removeClass("is-opacity");
        $mosaic_items.removeClass('is-trigger-content');

        // clear content as active
        var $mosaic_content = $mosaic.find(scope.options.mosaic_content);
        $mosaic_content.removeClass("active");

        // clear grid2 content as active
        var $mosaic_grid2_content = $mosaic.find(scope.options.mosaic_grid2_content);
        $mosaic_grid2_content.removeClass("active");

    };

    // copy content for mosaic_grid2 and setup events
    Plugin.prototype.setupGrid2Content = function(scope, $mosaic, $mosaic_content, $mosaic_grid2_content) {
        if ($mosaic_grid2_content.length){
            // replicate content
            $mosaic_grid2_content.html($mosaic_content.html());
            // add close btn
            // $mosaic_grid2_content.prepend(scope.options.mosaic_close_btn);
            // setup close btn events
            var $mosaic_grid2_detail_close_btn = $mosaic_grid2_content.find(scope.options.mosaic_detail_close_btn);
            $mosaic_grid2_detail_close_btn.click(function(e){
                scope.closeAllTiles(scope, $mosaic);
                e.preventDefault();
            });
        }
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
        $(".mosaic-item").mosaic();
        $(".mosaic-3column-item-option").mosaic({
            mosaic : ".mosaic",
            mosaic_item : ".mosaic-3column-item-option",
            mosaic_container : ".mosaic-3column-container",
            mosaic_front: ".mosaic-3column-front",
            mosaic_back: ".mosaic-3column-back",
            mosaic_content: ".mosaic-item-detail-container"});
    });

})( jQuery, window, document );
