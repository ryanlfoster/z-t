/*!
 * jQuery lightweight plugin boilerplate
 * Original author: @ajpiano
 * Further changes, comments: @addyosmani
 * Licensed under the MIT license
 *
 * ..............................................................................
 *
 * Flip Card Jquery Plugin
 *
 * explore_item : reference to the explore item container
 * explore_flip_btn : flip card button
 * explore_flip_back_btn : flip card back button
 * explore_card_front : front card
 * explore_card_back : back card
 */

;(function ( $, window, document, undefined ) {

    // Create the defaults once
    var pluginName = 'flipcard',
        defaults = {
            explore_item: ".explore-item-container",  // reference to the explore item container
            explore_flip_btn: "#explore-flip-btn", // flip card button
            explore_flip_back_btn: "#explore-flip-back-btn", // flip card back button
            explore_card_front: ".explore-card-front", // front card
            explore_card_back: ".explore-card-back" // back card
    };

    // The actual plugin constructor
    function Plugin( element, options ) {
        this.element = element;
        this.options = $.extend( {}, defaults, options) ;

        this._defaults = defaults;
        this._name = pluginName;
        //console.log("init-flipcard");

        this.init();
    }

    Plugin.prototype.init = function () {
        var scope = this;
        //init events
        scope.setupEvents(scope);
    };

    // add events to items
    Plugin.prototype.setupEvents = function(scope) {
        //add click events for navigation buttons

        /*$(scope.element).find(scope.options.explore_flip_btn).click(function(e){
        //$("." + $(scope.element).attr('class') + " " + scope.options.explore_flip_btn).click(function(e){
            scope.frontClicked(scope, e);
            $(e.target).trigger('touchstart');
            e.preventDefault();
        });*/


        var clickEventType = ((document.ontouchstart!==null)?'click':'touchstart');
        //$(scope.element).find(scope.options.explore_flip_btn).click(function(e){
        $(scope.element).find(scope.options.explore_flip_btn).on(clickEventType, function(e){
            scope.frontClicked(scope, e);
        });


        $(scope.element).find(scope.options.explore_flip_back_btn).click(function(e){
        //$("." + $(scope.element).attr('class') + " " + scope.options.explore_flip_back_btn).click(function(e){
            scope.backClicked(scope, e);
        });

    };

    // item selected
    Plugin.prototype.frontClicked = function (scope, e) {
        var $el = $(e.currentTarget);
        var $itemSelected = $($el.parents(scope.options.explore_item));
        scope.flipToBackCard(scope, $itemSelected);
        e.preventDefault();
    };

    // item selected
    Plugin.prototype.backClicked = function (scope, e) {
        var $el = $(e.currentTarget);
        var $itemSelected = $($el.parents(scope.options.explore_item));
        scope.flipToFrontCard(scope, $itemSelected);
        e.preventDefault();
    };

    // flip to front
    Plugin.prototype.flipToFrontCard = function (scope, $itemSelected) {
        //var $back = $itemSelected.find(scope.options.explore_card_back);
        //$back.css("display", "none");
        $itemSelected.removeClass("is-flip");
    };

    // flip to front
    Plugin.prototype.flipToBackCard = function (scope, $itemSelected) {
        //var $back = $itemSelected.find(scope.options.explore_card_back);
        //$back.css("display", "block");
        $itemSelected.addClass("is-flip");
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
        $(".explore-item-container").flipcard();
    });

})( jQuery, window, document );
