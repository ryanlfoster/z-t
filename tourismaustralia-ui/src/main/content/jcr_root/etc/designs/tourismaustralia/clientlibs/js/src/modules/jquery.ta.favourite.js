/*!
 * jQuery lightweight plugin boilerplate
 * Original author: @wma
 * Further changes, comments:
 * Licensed under the MIT license
 *
 * ..............................................................................
 *
 * Favourite
 *
 */

;(function($, window, document, undefined) {

    $.cookie("numberOfFavourites", 0, {
        path    : '/',          //The value of the path attribute of the cookie
        //(default: path of page that created the cookie).
        secure: true          //If set to true the secure attribute of the cookie
        //will be set and the cookie transmission will
        //require a secure protocol (defaults to false).
    })

	// Create the defaults once
	var pluginName = 'favourite', defaults = {
        currentPagePath: "",
        btn_bubble: ".btn-bubble",
        count_container: ".my-trip-count",
        numberOfFavouritesCookie: $.cookie("numberOfFavourites", parseInt(0))
	};

	// The actual plugin constructor
	function Plugin(element, options) {
		this.element = element;
		this.options = $.extend({}, defaults, options);
		this._defaults = defaults;
		this._name = pluginName;

        this.init();

	}

    Plugin.prototype.init = function(){
        var scope = this;
        //console.log(scope.element);
        if($(scope.element).hasClass('favourite-summary')){
            scope.setupCounter(scope);
        } else {
            scope.setupEvents(scope);
        }
    };

    Plugin.prototype.setupCounter = function(scope) {
        var currentPagePath = $(scope.element).data('pagepath');
        $.ajax({
            type: "GET",
            url: "/bin/favorites/add.json?page="+currentPagePath,
            success: function(data) {
                var favouriteCount = data.length;
                if(favouriteCount > 0) {
                    $(scope.element).find(scope.options.count_container).text(favouriteCount);
                    $.cookie("numberOfFavourites", parseInt(favouriteCount));
                }
                console.log("successfully retrieved favourites");
            },
            error: function(){
                console.log("failed to retrieve favourites");
            }
        });
    };

    Plugin.prototype.setupEvents = function(scope) {
        $(scope.element).click(function(e) {
            e.preventDefault();
            if (!($(scope.element).find(scope.options.btn_bubble).hasClass("is-active"))){
                scope.addFavourite(scope, e);
            }
        });
    };

    // item selected
    Plugin.prototype.addFavourite = function (scope, e) {
        var currentPagePath = $(scope.element).data('pagepath');
        //console.log(currentPagePath);

        if(!($(scope.element).find(scope.options.btn_bubble).hasClass("is-active"))) {
            // AJAX post currentPagePath to favourites
            $.ajax({
                type: "POST",
                url: "/bin/favorites/add.json?page=" + currentPagePath,
                success: function () {
                    $(scope.element).find(scope.options.btn_bubble).addClass("is-active");
                    console.log("successfully added to favourites");
                    $('#nav-heart-this-widget').find(scope.options.count_container).text(parseInt(scope.options.numberOfFavouritesCookie) + 1);
                },
                error: function () {
                    console.log("failed to add to favourites");
                }
            });
        }
    };

    // increment favourite
    Plugin.prototype.incrementTotal = function (scope, e){
        console.log($(scope.element.widget_heart_this).find('.my-trip-count').val());
    };

    // A really lightweight plugin wrapper around the constructor,
	// preventing against multiple instantiations
	$.fn[pluginName] = function(options) {
		return this.each(function() {
			if (!$.data(this, 'plugin_' + pluginName)) {
				$.data(this, 'plugin_' + pluginName, new Plugin(this, options));
			}
		});
	};

	//init all objects on page automatically -> TBR
	$(window).load(function() {
        $(".favourite, .bubble-colour-favourite, #nav-heart-this-widget a").favourite();
	});

})(jQuery, window, document);
