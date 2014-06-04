'use strict';


module.exports.register = function(Handlebars, options, params) {

    // Render a partial and pass in some data
    // Example Usage:
    //      {{#parseJSON '{"category_id": "category-wine-story", "category_icon" : "icon-font-restaurants", "title": "Restaurants", "description": "Restaurants, desc..."}'}}
    //          {{> category_item}}
    //      {{/parseJSON}}
    //  .hbs: <a href="#" class="btn-share icon-font-{{category_icon}}"><span>{{text}}</span></a>
    Handlebars.registerHelper('parseJSON', function(data, options) {
        return options.fn(JSON.parse(data));
    });

    // Render a partial and pass in some data, also inherits data from ancestor parsers
    // Example Usage:
    //      {{#parseJSONDeepLink '{"colors": {"primary": "#ffffff", "secondary": "#000000"}}'}}
    //
    //          <div style="color:{{colors.primary}}">
    //              I can use my color object right here in this page...
    //          </div>
    //
    //          {{#parseJSONDeepLink '{"title": "Hello World", "description": "I will inherit the colors object from the previous parseJSONDeepLink..."}'}}
    //              {{> partial}}
    //          {{/parseJSONDeepLink}}
    //
    //      {{/parseJSONDeepLink}}
    //
    //  partial.hbs:
    //      <div style="color:{{colors.primary}}; background-color:{{colors.secondary}}">
    //          <h4>{{title}}</h4>
    //          <p>{{description}}</p>
    //      </div>
    //
    Handlebars.registerHelper('parseJSONDeepLink', function (data, options)  {
        //console.log(this, data);

        if (this.flatten){
            return options.fn(JSON.parse(data));
        }else{
            var inheritData = {};
            for (var i in this){
                inheritData[i] = this[i];
            }
            var data1Parse;
            if (data == undefined){
                data1Parse = {};
            }else{
                data1Parse = JSON.parse(data);
            }

            var newData = merge(data1Parse, inheritData);
            return options.fn(newData);
        }
    });

    // Function to merge to objects
    function merge(target, source) {

        /* Merges two (or more) objects,
         giving the last one precedence */

        if ( typeof target !== 'object' ) {
            target = {};
        }

        for (var property in source) {

            if ( source.hasOwnProperty(property) ) {

                var sourceProperty = source[ property ];

                if ( typeof sourceProperty === 'object' ) {
                    target[ property ] = merge( target[ property ], sourceProperty );
                    continue;
                }

                target[ property ] = sourceProperty;

            }

        }

        for (var a = 2, l = arguments.length; a < l; a++) {
            merge(target, arguments[a]);
        }

        return target;
    };

};
