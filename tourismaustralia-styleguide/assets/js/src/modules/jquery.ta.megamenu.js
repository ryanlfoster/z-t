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
        mm_notice_close_button: '.notice-close',
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

        $(window).resize(function () {
            scope.initStickyNavBars(scope);
        });
        scope.initStickyNavBars(scope);

        var event = ( (document.ontouchstart !== null) ? 'click' : 'touchstart' );

        scope.noticeEvents(scope, event);
        scope.mobileEvents(scope, event);
        scope.desktopEvents(scope, event);
    };

    // init Sticky Nav Bars
    Plugin.prototype.initStickyNavBars = function (scope) {
        scope.options.offsetTop = $(window).scrollTop();
        scope.options.heightAbove = 0;
        $(scope.element).find('.bar-scroll-top').each(function () {
            scope.options.heightAbove += $(this).height();
        });
        scope.stickyNavBars(scope);
    };

    // Sticky Nav Bars
    Plugin.prototype.stickyNavBars = function (scope) {
        $(window).on('scroll', function () {
            scope.options.offsetTop = $(window).scrollTop();
            if (scope.options.offsetTop > scope.options.heightAbove) {
                $('.bar-fixed-scroll').addClass('bar-fixed-top');
            }
            if (scope.options.offsetTop <= 0) {
                $('.bar-fixed-scroll').removeClass('bar-fixed-top');
            }
        });
    };

    // Setup Notice Events
    Plugin.prototype.noticeEvents = function (scope, event) {
        $(scope.element).find(scope.options.mm_notice_close_button).on(event, function (e) {
            e.preventDefault();
            scope.closeNotice(scope, e);
        });
    };

    // Setup Mobile Events
    Plugin.prototype.mobileEvents = function (scope, event) {
        $(scope.element).find(scope.options.mm_mobile_open_main_nav).on(event, function (e) {
            e.preventDefault();
            scope.openMainNav(scope);
        });

        $(scope.element).find(scope.options.mm_mobile_close_main_nav).on(event, function (e) {
            e.preventDefault();
            scope.closeMainNav(scope);
        });
    };

    // Setup Desktop Events
    Plugin.prototype.desktopEvents = function (scope, event) {
        $(scope.element).find(scope.options.mm_all_toggle_panel_nav).on(event, function (e) {
            e.preventDefault();
            scope.toggleNavPanel(scope, e);
        });
    };

    // Open Main Nav Mobile
    Plugin.prototype.closeNotice = function (scope) {
        var $el = $(scope.element).find('.notice-bar');
        $el.slideUp(function () {
            $(this).remove();
            scope.initStickyNavBars(scope);
        });
    };

    // Open Main Nav Mobile
    Plugin.prototype.openMainNav = function (scope) {
        scope.closeNotice(scope);
        $('html, body').animate({
            scrollTop: scope.options.heightAbove
        }, 150);
        $(scope.element).addClass('is-open');
    };

    // Close Main Nav Mobile
    Plugin.prototype.closeMainNav = function (scope) {
        $(scope.element).removeClass('is-open');
    };

    // toggle Nav Panel
    Plugin.prototype.toggleNavPanel = function (scope, e) {
        var $el = $(e.currentTarget);

        if ($el.closest('.has-children').hasClass('is-open')) {
            $el.closest('.has-children').removeClass('is-open');
        } else {
            $(scope.element).find('.has-children').removeClass('is-open');
            $el.closest('.has-children').addClass('is-open');
        }
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
