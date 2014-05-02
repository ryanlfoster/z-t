/*!
 * jQuery lightweight plugin boilerplate
 * Original author: @ajpiano
 * Further changes, comments: @addyosmani
 * Licensed under the MIT license
 *
 * ..............................................................................
 *
 * Home, Hot or Not
 *
 * Controls Hot or Not interactivity, hiding/showing categories
 *
 */

;
(function ($, window, document, undefined) {

    // Create the defaults once
    var pluginName = 'hotornot', defaults = {
        hotornot_item: '.hotornot-item',
        hotornot_close_btn: '.hotornot-close-btn',
        hotornot_show_btn: '.hotornot-show-btn',
        hotornot_hide_btn: '.hotornot-hide-btn'
    };

    // The actual plugin constructor
    function Plugin(element, options) {
        this.element = element;
        this.options = $.extend({}, defaults, options);
        this._defaults = defaults;
        this._name = pluginName;
        this.init();
    }

    Plugin.prototype.init = function () {
        var scope = this;
        var event = ( (document.ontouchstart !== null) ? 'click' : 'touchstart' );
        //init events
        scope.setupEvents(scope);
    };

    // add events to items
    Plugin.prototype.setupEvents = function(scope) {
        var $el = $(scope.element);

        var $items = $el.find(scope.options.hotornot_item);
        $items.each(function(i, item){
            $item = $(item);

            // close
            var $hotornot_close_btn = $item.find(scope.options.hotornot_close_btn);
            $hotornot_close_btn.click(function(e){
                alert("close");
                e.preventDefault();
            });
            // show grid
            var $hotornot_show_btn = $item.find(scope.options.hotornot_show_btn);
            $hotornot_show_btn.click(function(e){
                $hotornot_item = $(e.currentTarget).parents(scope.options.hotornot_item);
                scope.showGrid($hotornot_item);
                e.preventDefault();
            });

            // hide grid
            var $hotornot_hide_btn = $item.find(scope.options.hotornot_hide_btn);
            $hotornot_hide_btn.click(function(e){
                $hotornot_item = $(e.currentTarget).parents(scope.options.hotornot_item);
                scope.hideGrid($hotornot_item);
                e.preventDefault();
            });

        });

    };

    Plugin.prototype.showGrid = function($target) {
        $target.addClass("is-expanded");
    };

    Plugin.prototype.hideGrid = function($target) {
        $target.removeClass("is-expanded");
        $('html,body').animate({
            scrollTop: $target.offset().top - $("#nav-bar-top").height()
        }, 800);
    };


    // A really lightweight plugin wrapper around the constructor,
    // preventing against multiple instantiations
    $.fn[pluginName] = function (options) {
        return this.each(function () {
            if (!$.data(this, 'plugin_' + pluginName)) {
                $.data(this, 'plugin_' + pluginName, new Plugin(this, options));
            }
        });
    };

    // init
    $(window).load(function () {
        $(".hotornot").hotornot();
    });

})(jQuery, window, document);
