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
    var pluginName = 'mosaic3column',
        defaults = {
            mosaic_item : ".mosaic-3column-item-option",  // reference to the mosaic item container
            mosaic_container : ".mosaic-3column-container", // reference to front-back container
            mosaic_front: ".mosaic-3column-front", // reference to front
            mosaic_back: ".mosaic-3column-back", // reference to back
            mosaic_content: ".mosaic-3column-item-content" // reference to content
    };
//is-trigger-content is-flip
    // The actual plugin constructor
    function Plugin( element, options ) {
        this.element = element;
        this.options = $.extend( {}, defaults, options) ;

        this._defaults = defaults;
        this._name = pluginName;
        //console.log("init-mosaic");

        //this.isIE10plus = (document.documentMode>9)?true:false;

        this.init();
    }

    Plugin.prototype.init = function () {
        var scope = this;
        //init events
        scope.setupEvents(scope);
    };

    // add events to items
    Plugin.prototype.setupEvents = function(scope) {
        // front
        var $mosaic_container = $(scope.element).find(scope.options.mosaic_container);
        var $mosaic_item = $(scope.element);
        $mosaic_container.click(function(e){
            if ($mosaic_item.hasClass('is-trigger-content')){
                $mosaic_item.removeClass('is-trigger-content');
                $(scope.element).find(scope.options.mosaic_content).slideUp({duration: 400, easing: 'swing'});
            }else{
                $mosaic_item.addClass('is-trigger-content');
                $(scope.element).find(scope.options.mosaic_content).slideDown({duration: 600, easing: 'swing'});
            }
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
        $(".mosaic-3column-item-option").mosaic3column();
    });

})( jQuery, window, document );
