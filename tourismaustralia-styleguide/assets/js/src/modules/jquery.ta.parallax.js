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
            lastScrollPosition : 0,
            parallaxInView : false
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

        window.onscroll = function(){

            scope.options.windowPositionTop = $(window).scrollTop();

            // check if we are before the image
            if((scope.options.containerOffset - scope.options.heightOfWindow) >= scope.options.windowPositionTop){
                // if we are, set the transform to 0
                $(scope.element).find('img').css({
                        'transform': 'translate(0px, 0px)',
                        '-moz-transform': 'translate(0px, 0px)',
                        '-webkit-transform': 'translate(0px, 0px)',
                        '-ms-transform': 'translate(0px, 0px)',
                        '-o-transform': 'translate(0px, 0px)'
                });

                scope.options.parallaxPosition = 0;

                // Trigger bool for in view
                scope.options.parallaxInView = false;
            } else if((scope.options.containerOffset + (scope.options.heightOfWindow / 2)) <= scope.options.windowPositionTop) {
                
                $(scope.element).find('img').css({
                        'transform': 'translate(0px, -40px)',
                        '-webkit-transform': 'translate(0px, -40px)',
                        '-moz-transform': 'translate(0px, -40px)',
                        '-ms-transform': 'translate(0px, -40px)',
                        '-o-transform': 'translate(0px, -40px)'
                });

                scope.options.parallaxPosition = -40;


                scope.options.parallaxInView = false;
            } else {
                scope.options.parallaxInView = true; 
            }

            if(scope.options.parallaxInView){
                // check if we are scrolling up or down
                if(scope.options.lastScrollPosition < scope.options.windowPositionTop){

                    if(scope.options.parallaxPosition >= -39){
                        scope.options.parallaxPosition -= 0.3;
                    }

                    $(scope.element).find('img').css({
                            'transform': 'translate(0px, ' + scope.options.parallaxPosition + 'px)',
                            '-webkit-transform': 'translate(0px, ' + scope.options.parallaxPosition + 'px)',
                            '-moz-transform': 'translate(0px, ' + scope.options.parallaxPosition + 'px)',
                            '-ms-transform': 'translate(0px, ' + scope.options.parallaxPosition + 'px)',
                            '-o-transform': 'translate(0px, ' + scope.options.parallaxPosition + 'px)'
                    });
                } else {
                    if(scope.options.parallaxPosition <= -1){
                        scope.options.parallaxPosition += 0.3;
                    }

                    $(scope.element).find('img').css({
                            'transform': 'translate(0px, ' + scope.options.parallaxPosition + 'px)',
                            '-webkit-transform': 'translate(0px, ' + scope.options.parallaxPosition + 'px)',
                            '-moz-transform': 'translate(0px, ' + scope.options.parallaxPosition + 'px)',
                            '-ms-transform': 'translate(0px, ' + scope.options.parallaxPosition + 'px)',
                            '-o-transform': 'translate(0px, ' + scope.options.parallaxPosition + 'px)',
                    });
                }
            }

            // set last scroll position
            scope.options.lastScrollPosition = scope.options.windowPositionTop;


        }

        if (!window.addEventListener) {                      
            window.attachEvent('resize', function() {
                scope.setupParallax(scope);
                scope.setHeightOfWindow(scope);
            });
            window.attachEvent('orientationchange', function() {
                scope.setupParallax(scope);
                scope.setHeightOfWindow(scope);
            });
        } else {
            // set height of window on resize & orientation change
            window.addEventListener('resize', function() {
                scope.setupParallax(scope);
                scope.setHeightOfWindow(scope);  
            }, false);

            window.addEventListener('orientationchange', function() {
                scope.setupParallax(scope);
                scope.heightOfWindow(scope);
            }, false);
        };

    };
        // set height of window
    Plugin.prototype.setHeightOfWindow = function(scope){

        // get height of window, and devide by half. So parallax initiates in center of screen.        
        scope.options.heightOfWindow = $(window).height();

    }

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
        $('.parallax').parallaxImages();
    });

})( jQuery, window, document );
