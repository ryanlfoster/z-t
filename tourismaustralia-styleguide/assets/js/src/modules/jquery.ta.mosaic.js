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
 * mosaic_item : reference to the mosaic item container
 * mosaic_detail_close_btn : mosaic detail close button
 * mosaic_item_detail_container : reference to the mosaic item detail container
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
            mosaic_grid_content: ".mosaic-grid-2-content" // reference to content block for 2 grid
    };

    // The actual plugin constructor
    function Plugin( element, options ) {
        this.element = element;
        this.options = $.extend( {}, defaults, options) ;

        this._defaults = defaults;
        this._name = pluginName;
        //console.log("init-mosaic");

        this.init();
    }

    Plugin.prototype.init = function () {
        var scope = this;
        //init events
        //scope.setupMosaic(scope);
        scope.setupEvents(scope);
    };

    // add events to items
    Plugin.prototype.setupEvents = function(scope) {
        var $mosaic = $(scope.element).parents(scope.options.mosaic);
        var $mosaic_container = $(scope.element).find(scope.options.mosaic_container);
        var $mosaic_item = $(scope.element);
        var $mosaic_content = $(scope.element).find(scope.options.mosaic_content);

        $mosaic_container.click(function(e){

            // turn other items opacity on
            $mosaic.find(scope.options.mosaic_item).addClass("is-opacity");
            $mosaic_item.removeClass("is-opacity");

            // copy content for mosaic_grid2
            var $mosaic_grid2_content = $(scope.element).parents(scope.options.mosaic_grid2).find(scope.options.mosaic_grid_content).find(scope.options.mosaic_content);
            if ($mosaic_grid2_content.length){
                $mosaic_grid2_content.html($mosaic_content.html());
            }

            if ($mosaic_item.hasClass('is-trigger-content')){
                scope.removeClass($mosaic_item, $mosaic_content, $mosaic_grid2_content);
                // turn other items opacity on
                $mosaic.find(scope.options.mosaic_item).removeClass("is-opacity");
            }else{
                // disable any open tiles before showing next tile
                scope.disableTiles(scope, $mosaic_item, $mosaic_content, $mosaic_grid2_content);
            }
            $mosaic_item.removeClass('is-flip')

            e.preventDefault();
        });
        $mosaic_container.mouseenter(function(e){
            $mosaic_item.addClass("is-flip");
            e.preventDefault();
        });
        $mosaic_container.mouseleave(function(e){
            $mosaic_item.removeClass("is-flip");
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
                var $mosaic_grid2_content1 = $mosaic_item1.parents(scope.options.mosaic_grid2).find(scope.options.mosaic_grid_content).find(scope.options.mosaic_content);
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
        $mosaic_grid2_content.addClass("active");
    };
    Plugin.prototype.removeClass = function($mosaic_item, $mosaic_content, $mosaic_grid2_content) {
        $mosaic_item.removeClass('is-trigger-content');
        //$(scope.element).find(scope.options.mosaic_content).slideUp({duration: 400, easing: 'swing'});
        $mosaic_content.removeClass("active");
        $mosaic_grid2_content.removeClass("active");
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
