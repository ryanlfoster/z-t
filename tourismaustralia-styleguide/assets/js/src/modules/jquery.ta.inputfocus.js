/*!
 * jQuery lightweight plugin boilerplate
 * Original author: @ajpiano
 * Further changes, comments: @addyosmani
 * Licensed under the MIT license
 *
 * ..............................................................................
 *
 * Search Input Jquery Plugin
 *
  * Handles search input field when changed
 *
 */

;(function ( $, window, document, undefined ) {

    // Create the defaults once
    var pluginName = 'inputFocus';

    // The actual plugin constructor
    function Plugin( element, options ) {
        this.element = element;
        this.options = $.extend( {}, defaults, options) ;

        this._defaults = defaults;
        this._name = pluginName;
        //console.log("init-search-input");

        this.init();
    }

    Plugin.prototype.init = function () {
        var scope = this;
        //init events
        scope.setupEvents(scope);
    };

    // add events to items
    Plugin.prototype.setupEvents = function(scope) {
        var $el = $(scope.element);
        var $search_input = $el.find(scope.options.search_input);

        $el.focusin(function(e){
            $(this).addClass('input-focus');
            e.preventDefault();
        });

        $el.focusout(function(e){
            $(this).removeClass('input-focus');
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

    //init all search input objects on page automatically -> TBR
    $(window).load(function() {
        $(".inputFocus-wrapper").inputFocus();
    });

})( jQuery, window, document );
