/*!
 * jQuery lightweight plugin boilerplate
 * Original author: @ajpiano
 * Further changes, comments: @addyosmani
 * Licensed under the MIT license
 *
 * ..............................................................................
 *
 * TA Mega Menu Helper...
 *
 * The TA navigation bar works mostly without the aid of javascript but this helper adds
 * in some required functionality and enhances the CSS only functionality.
 *
 */

;
(function ($, window, document, undefined) {

    // Create the defaults once
    var pluginName = 'megamenu', defaults = {
        mm_mobile_open_main_nav: '.nav-toggle-open',
        mm_mobile_close_main_nav: '.nav-toggle-close',
        mm_all_toggle_panel_nav: '.nav-toggle-panel'

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
        scope.delegateEvents(scope);
    };

    // Set up events
    Plugin.prototype.delegateEvents = function (scope) {

        var event = ( (document.ontouchstart !== null) ? 'click' : 'touchstart' );

        $(scope.element).find(scope.options.mm_mobile_open_main_nav).on(event, function (e) {
            scope.openMainNav(scope, e);
        });

        $(scope.element).find(scope.options.mm_mobile_close_main_nav).on(event, function (e) {
            scope.closeMainNav(scope, e);
        });

        $(scope.element).find(scope.options.mm_all_toggle_panel_nav).on(event, function (e) {
            scope.toggleNavPanel(scope, e);
        });
    };

    // Open Main Nav Mobile
    Plugin.prototype.openMainNav = function (scope, e) {
        e.preventDefault();
        $(scope.element).addClass('is-open');
    };

    // Close Main Nav Mobile
    Plugin.prototype.closeMainNav = function (scope, e) {
        e.preventDefault();
        $(scope.element).removeClass('is-open');
    };

    // toggle Nav Panel
    Plugin.prototype.toggleNavPanel = function (scope, e) {
        e.preventDefault();
        var $el = $(e.currentTarget);

        if ( $el.closest('.has-children').hasClass('is-open') ) {
            $el.closest('.has-children').removeClass('is-open');
        } else {
            $(scope.element).find('.has-children').removeClass('is-open');
            $el.closest('.has-children').addClass('is-open');
        }

        // TODO: force redraw in IE8

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
        $(".megamenu").each(function (index, element) {
            $(this).megamenu();
        });
    });

})(jQuery, window, document);
