'use strict';


/**
 * Dynamically generate a style guide section
 * @param Handlebars
 * @param options
 */
module.exports.register = function(Handlebars, options) {

    /**
     * Convert string into lowercase
     * @param string
     * @param context
     * @returns {string}
     */
    function toLowerCase(string, context) {
        return string.toLowerCase();
    };


    /**
     * Keep template tags available for json rendering
     * @param string
     * @param contenxt
     * @returns {SafeString}
     */
    function escape(string, contenxt) {
        return new Handlebars.SafeString("{{section '" + string.toLowerCase() + "'}}"); //Generate
    };


    /**
     * Quick fix for rendering all partials into a single page
     * Todo - Move into a seperate helper
     * @returns {SafeString}
     */
    function allPartials() {
        return new Handlebars.SafeString("{{#each sg-navigation.navigation}}{{#each this.category}}{{#each this.item}}{{section this.text}}{{/each}}{{/each}}{{/each}}"); //Generate
    };


    /**
     * Return Partial title if defined within tye Yaml
     * @param name
     * @returns {*}
     */
    function partialTitle(name) {

        var title, name = name.toLowerCase();
        if(typeof options.data[name] !== 'undefined') {
            title =  options.data[name].title || name;
        }
        return title;
    };

    Handlebars.registerHelper('escape', escape)
    Handlebars.registerHelper('toLowerCase', toLowerCase);
    Handlebars.registerHelper('allPartials', allPartials);
    Handlebars.registerHelper('partialTitle', partialTitle);


};