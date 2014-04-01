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

	// Create the defaults once
	var pluginName = 'favourite', defaults = {
        currentPage: ""
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
        scope.setupEvents(scope);
    }

    Plugin.prototype.setupEvents = function(scope) {
        $(scope.element).click(function(e) {
            scope.favouriteBtnClicked(scope, e);
        });
    }


    // item selected
    Plugin.prototype.favouriteBtnClicked = function (scope, e) {
        e.preventDefault();
        var currentPagePath = window.location.pathname;
        //console.log(currentPagePath);
        $.ajax({
            type:"POST",
            url: "/bin/favorites/add.json?page="+currentPagePath,
            success: function(){
              console.log("successfully added to favourites");
            },
            error: function(){
              console.log("failed to add to favourites");
            }
        });
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

	//init all carousel objects on page automatically -> TBR
	$(window).load(function() {
		$(".favourite").favourite();
	});

})(jQuery, window, document);
