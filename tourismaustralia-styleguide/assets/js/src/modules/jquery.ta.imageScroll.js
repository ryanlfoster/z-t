/**
 * Parallax ImageScroll - jQuery plugin
 * Author: Peder A. Nielsen
 * Created date: 04.12.13
 * Updated date: 10.04.14
 * Version: 0.1.2
 * Company: Making Waves
 * Licensed under the MIT license
 */
;
(function (root, factory) {
    if (typeof define === 'function' && define.amd) {
        // AMD. Register as an anonymous module.
        define(['jquery'], factory);
    } else {
        // Browser globals
        factory(root.jQuery);
    }
}(this, function ($) {
    "use strict";

    var ImageScroll,
        defaults = {
            image: null,
            imageAttribute: 'image',
            holderClass: 'imageHolder',
            container: $('body'),
            speed: 0.2,
            coverRatio: 0.75,
            holderMinHeight: 200,
            extraHeight: 0,
            mediaWidth: 1600,
            mediaHeight: 900,
            parallax: true,
            touch: false,
            dataIdForParallax: 0,
            dataParallaxHeight:200
        },
        ImageScrollModernizr = {},
        docElement = document.documentElement,
        mod = 'imageScrollModernizr',
        modElem = document.createElement(mod),
        mStyle = modElem.style,
        omPrefixes = 'Webkit Moz O ms',
        cssomPrefixes = omPrefixes.split(' '),
        domPrefixes = omPrefixes.toLowerCase().split(' '),
        tests = {},
        $win = $(window),
        lastTickTime = 0,
        supportedFeature = '',
        transformProperty,
        injectElementWithStyles = function (rule, callback, nodes, testnames) {

            var style, ret, node, docOverflow,
                div = document.createElement('div'),
                body = document.body,
                fakeBody = body || document.createElement('body');

            if (parseInt(nodes, 10)) {
                while (nodes--) {
                    node = document.createElement('div');
                    node.id = testnames ? testnames[nodes] : mod + (nodes + 1);
                    div.appendChild(node);
                }
            }

            style = ['&#173;', '<style id="s', mod, '">', rule, '</style>'].join('');
            div.id = mod;
            (body ? div : fakeBody).innerHTML += style;
            fakeBody.appendChild(div);
            if (!body) {
                fakeBody.style.background = '';
                fakeBody.style.overflow = 'hidden';
                docOverflow = docElement.style.overflow;
                docElement.style.overflow = 'hidden';
                docElement.appendChild(fakeBody);
            }

            ret = callback(div, rule);
            if (!body) {
                fakeBody.parentNode.removeChild(fakeBody);
                docElement.style.overflow = docOverflow;
            } else {
                div.parentNode.removeChild(div);
            }

            return !!ret;

        };

    function is(obj, type) {
        return typeof obj === type;
    }

    function contains(str, substr) {
        return !!~('' + str).indexOf(substr);
    }

    function testProps(props, prefixed) {
        for (var i in props) {
            var prop = props[i];
            if (!contains(prop, "-") && mStyle[prop] !== undefined) {
                return prefixed == 'pfx' ? prop : true;
            }
        }
        return false;
    }

    function testDOMProps(props, obj, elem) {
        for (var i in props) {
            var item = obj[props[i]];
            if (item !== undefined) {

                if (elem === false) return props[i];

                if (is(item, 'function')) {
                    return item.bind(elem || obj);
                }

                return item;
            }
        }
        return false;
    }

    function testPropsAll(prop, prefixed, elem) {
        var ucProp = prop.charAt(0).toUpperCase() + prop.slice(1),
            props = (prop + ' ' + cssomPrefixes.join(ucProp + ' ') + ucProp).split(' ');

        if (is(prefixed, "string") || is(prefixed, "undefined")) {
            return testProps(props, prefixed);
        } else {
            props = (prop + ' ' + (domPrefixes).join(ucProp + ' ') + ucProp).split(' ');
            return testDOMProps(props, prefixed, elem);
        }
    }

    tests['csstransforms'] = function () {
        return !!testPropsAll('transform');
    };

    tests['csstransforms3d'] = function () {

        var ret = !!testPropsAll('perspective');

        if (ret && 'webkitPerspective' in docElement.style) {

            injectElementWithStyles('@media (transform-3d),(-webkit-transform-3d){#imageScrollModernizr{left:9px;position:absolute;height:3px;}}', function (node, rule) {
                ret = node.offsetLeft === 9 && node.offsetHeight === 3;
            });
        }
        return ret;
    };

    ImageScrollModernizr.prefixed = function (prop, obj, elem) {
        if (!obj) {
            return testPropsAll(prop, 'pfx');
        } else {
            return testPropsAll(prop, obj, elem);
        }
    };

    window.requestAnimationFrame = ImageScrollModernizr.prefixed('requestAnimationFrame', window) || function (callback, element) {
        var currTime = new Date().getTime();
        var timeToCall = Math.max(0, 16 - (currTime - lastTickTime));
        var id = window.setTimeout(function () {
                callback(currTime + timeToCall);
            },
            timeToCall);
        lastTickTime = currTime + timeToCall;
        return id;
    };

    if (tests['csstransforms3d']()) {
        supportedFeature = 'csstransforms3d';
    } else if (tests['csstransforms']()) {
        supportedFeature = 'csstransforms';
    }

    if (supportedFeature !== '') {
        transformProperty = ImageScrollModernizr.prefixed('transform');
    }

    ImageScroll = function (imageHolder, options) {
        return {
            init: function () {
                //this.imageHolder = imageHolder;
                this.$imageHolder = $(imageHolder);
                this.settings = $.extend({}, defaults, options);

                // this.image = this.$imageHolder.data(this.settings.imageAttribute) || this.settings.image;
                // Added this to work with media images
                this.image = this.$imageHolder.next('.img-src').find('img').last().attr('src') || this.settings.image;

                this.mediaWidth = this.$imageHolder.data('width') || this.settings.mediaWidth;
                this.mediaHeight = this.$imageHolder.data('height') || this.settings.mediaHeight;
                this.coverRatio = this.$imageHolder.data('cover-ratio') || this.settings.coverRatio;

                //changed for the event [from data() to attr()], when this plugin is called on resize event of page.
                this.extraHeight = parseFloat(this.$imageHolder.attr('data-extra-height')) || this.settings.extraHeight;
                this.dataParallaxHeight = parseFloat(this.$imageHolder.attr('data-parallax-height')) || this.settings.dataParallaxHeight;
                this.dataIdForParallax = this.$imageHolder.attr('data-id-for-parallax') || this.settings.dataIdForParallax;
                this.ticking = false;

                //This condition is to avoid creating img, when this plugin is called on resize event of page. it will find the img in element e.g. 'parallax_elementID_1'
                //If img in element e.g. 'parallax_elementID_1', exists it will point that, otherwise new img will be created
                if($('#'+  this.dataIdForParallax).length<=0)
                {
                    if (this.image) {
                        this.$scrollingElement = $('<img/>', {
                            src: this.image
                        });
                    } else {
                        throw new Error('You need to provide either a data-img attr or an image option');
                    }
                }
                else{
                    this.$scrollingElement = $('#'+  this.dataIdForParallax +" img")
                }

                if(this.settings.touch === true) {
                    this.$scrollingElement.css({maxWidth:'100%'}).prependTo(this.$imageHolder);
                } else if(this.settings.parallax === true) {

                    //This condition is to avoid creating a div 'parallaxHolder' , when this plugin is called on resize event of page. it will find the element e.g. 'parallax_elementID_1'
                    //If element e.g. 'parallax_elementID_1', exists it will point that, otherwise new div 'parallaxHolder' will be created
                    if($('#'+  this.dataIdForParallax).length>0)
                    {
                        this.$scrollerHolder = $('#'+  this.dataIdForParallax);
                    }
                    else{
                        this.$scrollerHolder = $('<div/>', {
                            html: this.$imageHolder.html()
                        }).css(this._getCSSObject({
                                transform: transformProperty,
                                top: 0,
                                left: 0,
                                x: 0,
                                y: 0,
                                visibility: 'hidden',
                                position: 'fixed',
                                overflow: 'hidden'
                            })).addClass(this.settings.holderClass).prependTo(this.settings.container);
                    }


                    this.$scrollerHolder.attr('id',this.dataIdForParallax);
                    this.$imageHolder.css('visibility', 'hidden').empty();
                    this.$scrollingElement.css({position: 'absolute', visibility: 'hidden', maxWidth: 'none'}).prependTo(this.$scrollerHolder);

                } else {
                    this.$scrollerHolder = this.$imageHolder.css({overflow: 'hidden'});
                    this.$scrollingElement.css({position: 'relative', overflow: 'hidden'}).prependTo(this.$imageHolder);
                }

                if(this.settings.touch === false) {
                    this._adjustImgHolderHeights();
                    if(this.settings.parallax === true) {this._updatePositions();}
                    else {this._updateFallbackPositions();}
                    this._bindEvents();
                }
            },
            _adjustImgHolderHeights: function () {
                var winHeight = $win.height(),
                    winWidth = $win.width(),
                    imgHolderHeight = this.coverRatio * winHeight,
                    imgTopPos,
                    imgLeftPos,
                    fromY,
                    toY,
                    imgScrollingDistance,
                    travelDistance,
                    imgWidth,
                    imgHeight,
                    fakedImgHeight,
                    imageDiff,
                    adjustedYDiff,
                    holderToWinDiff;
                var localExtraHeight =0;

                imgHolderHeight = (this.settings.holderMinHeight < imgHolderHeight ? Math.floor(imgHolderHeight) : this.settings.holderMinHeight) + this.extraHeight;

                //Start - Modified Code to fix the height to Defined px
                localExtraHeight = this.dataParallaxHeight - imgHolderHeight;
                imgHolderHeight = imgHolderHeight + localExtraHeight;
                //End - Modified Code to fix the height to Defined px

                fakedImgHeight = Math.floor(winHeight - (winHeight - imgHolderHeight) * this.settings.speed);
                imgWidth = Math.round(this.mediaWidth * (fakedImgHeight / this.mediaHeight));

                if (imgWidth >= winWidth) {
                    imgHeight = fakedImgHeight;
                } else {
                    imgWidth = winWidth;
                    imgHeight = Math.round(this.mediaHeight * (imgWidth / this.mediaWidth));
                }

                imageDiff = (fakedImgHeight - imgHolderHeight) / 2;
                adjustedYDiff = (imgHeight - fakedImgHeight) / 2;
                holderToWinDiff = (winHeight - imgHolderHeight) / 2;
                fromY = -((winHeight / holderToWinDiff) * imageDiff) - adjustedYDiff;
                toY = ((imgHolderHeight / holderToWinDiff) * imageDiff) - adjustedYDiff;
                imgScrollingDistance = toY - fromY;
                travelDistance = winHeight + imgHolderHeight;
                imgTopPos = -(imageDiff + adjustedYDiff);
                imgLeftPos = Math.round((imgWidth - winWidth) * -0.5);

                this.$scrollingElement.css({
                    height: imgHeight,
                    width: imgWidth
                });
                this.$imageHolder.height(imgHolderHeight);

                this.$scrollerHolder.css({
                    height: imgHolderHeight,
                    width: imgWidth
                });

                this.scrollingState = {
                    winHeight: winHeight,
                    fromY: fromY,
                    imgTopPos: imgTopPos,
                    imgLeftPos: imgLeftPos,
                    imgHolderHeight: imgHolderHeight,
                    imgScrollingDistance: imgScrollingDistance,
                    travelDistance: travelDistance,
                    holderDistanceFromTop: this.$imageHolder.offset().top - $win.scrollTop()
                };
            },
            _bindEvents: function () {
                var self = this;
                $win.on('resize', function (evt) {
                    self._adjustImgHolderHeights();
                    if(self.settings.parallax === true) {
                        self._requestTick();
                    } else {
                        self._updateFallbackPositions();
                    }
                });
                if(this.settings.parallax === true) {
                    $win.on('scroll', function (evt) {
                        self.scrollingState.holderDistanceFromTop = self.$imageHolder.offset().top - $win.scrollTop();
                        self._requestTick();
                    });
                }
            },
            _requestTick: function () {
                var self = this;
                if (!this.ticking) {
                    this.ticking = true;
                    requestAnimationFrame(function () {
                        self._updatePositions();
                    });
                }
            },
            _updatePositions: function () {
                if (this.scrollingState.holderDistanceFromTop <= (this.scrollingState.winHeight) && this.scrollingState.holderDistanceFromTop >= -this.scrollingState.imgHolderHeight) {
                    var distanceFromTopAddedWinHeight = this.scrollingState.holderDistanceFromTop + this.scrollingState.imgHolderHeight,
                        distanceInPercent = distanceFromTopAddedWinHeight / this.scrollingState.travelDistance,
                        currentImgYPosition = Math.round(this.scrollingState.fromY + (this.scrollingState.imgScrollingDistance * (1 - distanceInPercent)));

                    this.$scrollerHolder.css(this._getCSSObject({
                        transform: transformProperty,
                        x: Math.ceil(this.scrollingState.imgLeftPos),
                        y: Math.round(this.scrollingState.holderDistanceFromTop),
                        visibility: 'visible'
                    }));

                    this.$scrollingElement.css(this._getCSSObject({
                        transform: transformProperty,
                        x: 0,
                        y: currentImgYPosition,
                        visibility: 'visible'
                    }));
                } else {
                    this.$scrollerHolder.css({visibility: 'hidden'});
                    this.$scrollingElement.css({visibility: 'hidden'});
                }

                this.ticking = false;
            },
            _updateFallbackPositions: function() {
                this.$scrollerHolder.css({width: '100%'});
                this.$scrollingElement.css({
                    top: this.scrollingState.imgTopPos,
                    left: this.scrollingState.imgLeftPos
                });
            },
            _getCSSObject: function (options) {
                if (supportedFeature === "csstransforms3d") {
                    options.transform = "translate3d(" + options.x + "px, " + options.y + "px, 0)";
                } else if (supportedFeature === "csstransforms") {
                    options.transform = "translate(" + options.x + "px, " + options.y + "px)";
                } else {
                    options.top = options.y;
                    options.left = options.x;
                }
                return options;
            }
        };
    };

    ImageScroll.defaults = defaults;
    $.fn.imageScroll = function (options) {
        return this.each(function () {
            new ImageScroll(this, options).init();
        });
    };

    return ImageScroll;
}));