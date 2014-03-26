'use strict';


module.exports.register = function(Handlebars, options) {



    //Group partails together in an array
    function bar(name, context, options) {

       // console.log(context, this);

        console.log(name);
        /*

       var concatTemplate = [];

       for(var i = 0; i < name.length; i++) {
           var pName = name[i];

           var partial = Handlebars.partials[pName];
           var template = Handlebars.compile(partial);
           var templateContext = template(context);


           concatTemplate.push(templateContext);

       }

        return new Handlebars.SafeString(concatTemplate.join(""));
        */
        return 'cat';

    }


    Handlebars.registerHelper('bar', bar);
};
