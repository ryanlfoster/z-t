'use strict';


/**
 * Dynamically generate a style guide section
 * @param Handlebars
 * @param options
 */
module.exports.register = function(Handlebars, options) {


   function tagcollection(context, options) {

       return new Handlebars.SafeString(_getNavigation(_getCategories(this, _getTags(this)))); //Generate
   };



    function _getNavigation (categories) {
        var markup = '';
            markup += '<ol class="sg-nav">';
            markup += categories;
            markup += '</ol>';
            return markup;
    }


    function _getCategories(scope, tags) {
        var aTarget = scope.categories;
        var nLength = aTarget.length;
        var markup = '';

        for(var i = 0; i < nLength; i++) {
            markup += '<li class="sg-nav-' + aTarget[i].category + '">';
            markup +=       '<a href="#" class="sg-acc-handle">' + aTarget[i].category + '</a>'
            markup +=       tags,
            markup +=       '</ol>';
            markup += '</li>';
        }
        return markup;
    }


    //Generate tags
    function _getTags(scope) {


       // console.log(scope);

        var aTarget = scope.tags;
        var nLength = aTarget.length;
        var markup = '<ol class="sg-acc-panel">';
        for(var i = 0; i < nLength; i++) {
            markup += '<li><a href="#" class="sg-pop">' + aTarget[i].tag  + '</a></li>'
            markup += '</li>';
        }
        markup += '</ol>'
        return markup;
    }


    Handlebars.registerHelper('tagcollection', tagcollection)
};