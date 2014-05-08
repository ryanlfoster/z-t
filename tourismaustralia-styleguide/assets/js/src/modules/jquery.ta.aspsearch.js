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
    var pluginName = 'toggleemailsection', defaults = {
        asp_search_agent_list_item: '.asp-search-agent-list-item',
        asp_search_agent_list_item_btn_anchor: '.asp-search-agent-list-item-btn a',
        asp_search_agent_list_item_form: '.asp-search-agent-list-item-form',
        asp_search_agent_list_item_form_close_btn: '.asp-search-agent-list-item-form-close-btn'

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

        //Toggle form on Email Agent Button
        $el.on('click', scope.options.asp_search_agent_list_item_btn_anchor , function(e){

            var $asp_search_agent_list_item_form = $(this).parents().closest(scope.options.asp_search_agent_list_item).find(scope.options.asp_search_agent_list_item_form);

            if ($asp_search_agent_list_item_form.hasClass('is-open')) {
                $asp_search_agent_list_item_form.removeClass('is-open');
                $(this).removeClass('active');
            } else {
                $asp_search_agent_list_item_form.addClass('is-open');
                $(this).addClass('active');
            }

            e.preventDefault();
        });

        //Close Form on CLose button
        $el.on('click', scope.options.asp_search_agent_list_item_form_close_btn , function(e){

            var $asp_search_agent_list_item_form = $(this).parents().closest(scope.options.asp_search_agent_list_item).find(scope.options.asp_search_agent_list_item_form);
            var $asp_search_agent_list_item_btn_anchor = $(this).parents().closest(scope.options.asp_search_agent_list_item).find(scope.options.asp_search_agent_list_item_btn_anchor);

            $asp_search_agent_list_item_form.removeClass('is-open');
            $asp_search_agent_list_item_btn_anchor.removeClass('active');

            e.preventDefault();
        });

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
        $(".asp-search-agent-list").each(function (index, element) {
            $(this).toggleemailsection();
        });
    });

})(jQuery, window, document);
