module.exports.register = function(Handlebars, options) {

    function snippet(string) {

        var test = '<h1>Hello</h1>';
        return new Handlebars.SafeString(test); //Generate
    }

    Handlebars.registerHelper('snippet', snippet)
};