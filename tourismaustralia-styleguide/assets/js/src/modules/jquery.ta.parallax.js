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

// scope.options.heightOfWindow
// scope.options.containerOffset

;(function ( $, window, document, undefined ) {

    // Create the defaults once
    var pluginName = 'parallaxImages',
        defaults = {
            lastScrollPosition : 0,
            parallaxInView : false,
            parallaxOffsetParcentage : 20,
            parallaxSpeed : 1,
            parallaxSpeedMultiplier: 1
        };

    // The actual plugin constructor
    function Plugin( element, options ) {
        this.element = element;
        this.options = $.extend( {}, defaults, options) ;

        this._defaults = defaults;
        this._name = pluginName;

        this.init();
    }

    Plugin.prototype.init = function () {
        var scope = this;
        //init events
        scope.setupParallax(scope);
    };

    // add events to items
    Plugin.prototype.setupParallax = function(scope) {

        // Set stuff up
        scope.setHeightOfWindow(scope); 
        scope.options.containerOffset = $(scope.element).offset().top;
        scope.options.parallaxPosition = 0;
        scope.options._parallaxSpeed = parseFloat(scope.options.parallaxSpeed * scope.options.parallaxSpeedMultiplier);
        scope.options.parallaxOffset = ($(scope.element).find('img').height() - $(scope.element).height()) / 2;

        if(scope.options.parallaxOffset >= 150){
            scope.options.parallaxSpeedMultiplier = 2;
        } else {            
            scope.options.parallaxSpeedMultiplier = 1;
        }

        window.onscroll = function(){

            scope.options.windowPositionTop = $(window).scrollTop();

            // check if we are before the image
            if((scope.options.containerOffset - scope.options.heightOfWindow) >= scope.options.windowPositionTop){
                // if we are, set the transform to 0
                $(scope.element).find('img').css({
                        'transform': 'translate3d(0px, 0px, 0px)',
                        '-moz-transform': 'translate3d(0px, 0px, 0px)',
                        '-webkit-transform': 'translate3d(0px, 0px, 0px)',
                        '-ms-transform': 'translate3d(0px, 0px, 0px)',
                        '-o-transform': 'translate3d(0px, 0px, 0px)'
                });

                scope.options.parallaxPosition = 0;

                // Trigger bool for in view
                scope.options.parallaxInView = false;

            } else if((scope.options.containerOffset + (scope.options.heightOfWindow / 2)) <= scope.options.windowPositionTop) {
                scope.options.parallaxInView = false;
            } else {
                if(scope.options.containerOffset - (scope.options.heightOfWindow / 2) <= scope.options.windowPositionTop){
                    // start parallax only in the top half of screen
                    scope.options.parallaxInView = true; 
                } else {
                    scope.options.parallaxInView = false; 
                }
            }

            if(scope.options.parallaxInView){
                // check if we are scrolling down or up
                if(scope.options.lastScrollPosition < scope.options.windowPositionTop){
                    // Scrolling Down

                    if(scope.options.parallaxPosition > -scope.options.parallaxOffset){
                        scope.options.parallaxPosition -= scope.options._parallaxSpeed;
                    }

                    $(scope.element).find('img').css({
                            'transform': 'translate3d(0px, ' + scope.options.parallaxPosition + 'px, 0px)',
                            '-webkit-transform': 'translate3d(0px, ' + scope.options.parallaxPosition + 'px, 0px)',
                            '-moz-transform': 'translate3d(0px, ' + scope.options.parallaxPosition + 'px, 0px)',
                            '-ms-transform': 'translate3d(0px, ' + scope.options.parallaxPosition + 'px, 0px)',
                            '-o-transform': 'translate3d(0px, ' + scope.options.parallaxPosition + 'px, 0px)'
                    });
                } else {
                    // Scrolling Up

                    if(scope.options.parallaxPosition < -1){
                        scope.options.parallaxPosition += scope.options._parallaxSpeed;
                    }

                    $(scope.element).find('img').css({
                            'transform': 'translate3d(0px, ' + scope.options.parallaxPosition + 'px, 0px)',
                            '-webkit-transform': 'translate3d(0px, ' + scope.options.parallaxPosition + 'px, 0px)',
                            '-moz-transform': 'translate3d(0px, ' + scope.options.parallaxPosition + 'px, 0px)',
                            '-ms-transform': 'translate3d(0px, ' + scope.options.parallaxPosition + 'px, 0px)',
                            '-o-transform': 'translate3d(0px, ' + scope.options.parallaxPosition + 'px, 0px)',
                    });
                }
            };

            // set last scroll position
            scope.options.lastScrollPosition = scope.options.windowPositionTop;
        };

        // IE9+ only support
        if(window.addEventListener){
            // set height of window on resize & orientation change
            window.onresize = function(){
                scope.setupParallax(scope);
                scope.setHeightOfWindow(scope);
            };

            window.addEventListener('orientationchange', function() {
                scope.setupParallax(scope);
                scope.heightOfWindow(scope);
            }, false);
        };

    };

    // set height of window
    Plugin.prototype.setHeightOfWindow = function(scope){

        // get height of window   
        scope.options.heightOfWindow = $(window).height();

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
    $(window).bind('load', function() {
        // $('.parallax').parallaxImages({
        //     parallaxSpeed : 2
        // });
    });

})( jQuery, window, document );
