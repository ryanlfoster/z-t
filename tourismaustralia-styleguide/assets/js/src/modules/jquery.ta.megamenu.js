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
        mm_mobile_breakpoint: 768,
        mm_main_header_element: '#nav-main-header',
        mm_main_navigation_bar: '#nav-bar-top',
        mm_clone_navigation_bar_id: 'nav-bar-top-clone',
        mm_notice_close_button: '.notice-close',
        mm_mobile_open_main_nav: '.nav-toggle-open',
        mm_mobile_close_main_nav: '.nav-toggle-close',
        mm_all_toggle_panel_nav: '.nav-toggle-panel',
        mm_map_panel_filters: '.megamenu-map-filters',
        mm_heart_this_widget: '#heart-this-widget'
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

        // clone the nav bar, set the height, insert it, empty it and hide it.
        // This will maintain the body height when we fix the navigation bar.
        scope.options.navbarHeight = $(scope.options.mm_main_navigation_bar).css('height');
        scope.options.mm_clone_navigation_bar = $(scope.options.mm_main_navigation_bar)
            .clone()
            .height(scope.options.navbarHeight)
            .removeClass('bar-fixed-scroll')
            .addClass('is-bar-cloned')
            .attr('id', scope.options.mm_clone_navigation_bar_id)
            .insertBefore($(scope.options.mm_main_navigation_bar))
            .html('')
            .hide();

        $(window).resize(function () {
            scope.initStickyNavBars(scope);
        });
        scope.initStickyNavBars(scope);

        var event = ( (document.ontouchstart !== null) ? 'click' : 'touchstart' );

        scope.noticeEvents(scope, event);
        scope.mobileEvents(scope, event);
        scope.desktopEvents(scope, event);

        scope.checkFocus(scope, event);

        scope.initMapPanel(scope, event);
    };

    // init Sticky Nav Bars
    Plugin.prototype.initStickyNavBars = function (scope) {
        if ($(scope.element).find('.bar-fixed-top').length < 1) {
            scope.options.offsetTop = $(window).scrollTop();
            scope.options.heightAbove = $(scope.options.mm_main_navigation_bar).offset().top;
            scope.options.navbarHeight = $(scope.options.mm_main_navigation_bar).css('height');

            $(scope.options.mm_clone_navigation_bar).height(scope.options.navbarHeight);

            scope.stickyNavBars(scope);
        }

        scope.checkResponsive(scope);

    };

    Plugin.prototype.checkResponsive = function (scope) {
        // remove is-open if we scaled up from mobile because it breaks things
        if ($(window).width() > scope.options.mm_mobile_breakpoint) {
            $(scope.element).removeClass('is-open');
            $('html, body').css({'overflow': ''});
            // and if we were above the top of the navbar we need to reset fixed elements
            if ($(window).scrollTop() <= scope.options.heightAbove) {
                $('.bar-fixed-scroll').removeClass('bar-fixed-top');
                $(scope.options.mm_clone_navigation_bar).hide();
            }
        }
    };

    // Sticky Nav Bars
    Plugin.prototype.stickyNavBars = function (scope) {
        $(window).on('scroll', function () {
            scope.options.offsetTop = $(window).scrollTop();
            if (scope.options.offsetTop > scope.options.heightAbove) {
                scope.stickNav(scope);
            }
            if (scope.options.offsetTop <= scope.options.heightAbove) {
                scope.unstickNav(scope);
            }
        });
        scope.options.ignores_croll_event = false;
    };

    // Stick the Nav Bar
    Plugin.prototype.stickNav = function (scope) {
        $('.bar-fixed-scroll').addClass('bar-fixed-top');
        $(scope.options.mm_clone_navigation_bar).show();
    };

    // Un-stick the Nav Bar
    Plugin.prototype.unstickNav = function (scope) {
        if (!$(scope.element).hasClass('is-open')) {
            $('.bar-fixed-scroll').removeClass('bar-fixed-top');
            $(scope.options.mm_clone_navigation_bar).hide();
        }
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
        $(document).on(event, scope.closeAll(scope, event));

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
        $(document).on(event, scope.closeAll(scope, event));
        $(scope.element).find(scope.options.mm_all_toggle_panel_nav).on(event, function (e) {
            e.preventDefault();
            var $el = $(e.currentTarget);
            scope.toggleNavPanel(scope, $el);
        });
    };

    // Init Map Panel
    Plugin.prototype.initMapPanel = function (scope, event) {
        $(scope.element).find(scope.options.mm_map_panel_filters).on(event, function (e) {
            e.preventDefault();
            var $el = $(e.currentTarget);
            $el.closest('.megamenu-panel').find('.is-active').removeClass('is-active');
            $el.addClass('is-active');
        });
    };

    // Check the target element on click or touch and close the nav if the target not inside
    Plugin.prototype.closeAll = function (scope, event) {
        var $el = $(event.currentTarget);
        if ($el.not().closest(scope.options.mm_main_header_element)) {
            $(scope.element).find('.has-children').removeClass('is-open');
        }
    };

    // Check for focus for keyboard navigation
    Plugin.prototype.checkFocus = function (scope) {
        $(document).on('keyup', function () {
            var $el = $(document.activeElement);

            // TODO: consider closing on key up no matter what in case we used a skip link...

            if ($el.closest('.has-children').length < 1) {
                $(scope.element).find('.has-children').removeClass('is-open');
            }

            if ($el.is(scope.options.mm_all_toggle_panel_nav) || $el.closest('.has-children').length > 0) {
                $el.closest('.has-children').addClass('is-open');
            }

            // TODO: try to get this working a little better
            $el.on('blur', function (e) {
                $(scope.element).find('.has-children').removeClass('is-open');
            });

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
        // scrolls to the top of the nav bar + 1 pixel to push it over the heightAbove and trigger the fixed navigation
        if (scope.options.offsetTop <= scope.options.heightAbove) {
            $('html, body').animate({
                scrollTop: scope.options.heightAbove + 1
            }, 150, function () {
                $(scope.element).addClass('is-open');
            });
        } else {
            $(scope.element).addClass('is-open');
        }
        // force no scroll while the nav is open
        $('html, body').css({'overflow': 'hidden'});
    };

    // Close Main Nav Mobile
    Plugin.prototype.closeMainNav = function (scope) {
        $(scope.element).removeClass('is-open');
        $('html, body').css({'overflow': ''});
    };

    // Toggle Nav Panel
    Plugin.prototype.toggleNavPanel = function (scope, elm) {
        if (elm.closest('.has-children').is('.is-open')) {
            elm.closest('.has-children').removeClass('is-open');
        } else {
            $(scope.element).find('.has-children').removeClass('is-open');
            elm.closest('.has-children').addClass('is-open');
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
