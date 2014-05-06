'use strict';


/**
 * Dynamically generate a style guide section
 * @param Handlebars
 * @param options
 */
module.exports.register = function(Handlebars, options) {

    function section(name, context) {
        //Todo validate partial for avalible note reference

        var markdown, title, name = name.toLowerCase();

       if(typeof options.data[name] !== 'undefined') {
           markdown = options.data[name].note || 'note';
           title =  options.data[name].title || name;
       }

        var partial = Handlebars.partials[name];   //Get partial from collection


        if(typeof partial !== 'string') {
            partial = partial();
        }

        var partialComplete = _getStyleGuideMarktup(partial, name, markdown, title); //Generate dynamic markup

        var template = _getCompiledTemplate(partialComplete);       //Compile template with all styleguide elements
        var templateCode = _getCompiledTemplate(partial);          //Compile template with just code element
        //var templateFinal = _mergeTemplates(partialComplete, _makeString(partial));




        var templateContext = template(options.data);    //Add to template
        var templateCodeContext = templateCode(options.data);   //Generate template with data



        var templateFinal = _mergeTemplates(templateContext, _getCode(_trim(templateCodeContext)));

        return new Handlebars.SafeString(templateFinal); //Generate
    };








    //Compile template
    function _getCompiledTemplate(partial) {
        return Handlebars.compile(partial); //Compile partial;
    }





    //Generate code
    function _getCode(partial) {
       var sStringMarkup = _makeString(partial);
       var sCode = '<pre class="sg-code" style="display: none"><code>' + sStringMarkup + '</code></pre>';
        return sCode;
    };


    //Make string
    function _makeString(code) {
        var sFormattedCode = code.replace(/[<>]/g, function(m) { return {'<':'&lt;','>':'&gt;'}[m]});
        return sFormattedCode;
    }




    function _trim (str) {
        var str = str.replace(/^\s\s*/, '').replace(/\s\s*$/, '').replace(/^\s*[\r\n]/gm, '');
        //var str = str.replace(/^\s*[\r\n]/gm, '');  //Todo - remove weird line breaks on start and end of string need to remove space around code not the entire page
        return str;
    }

    /**
     * Merge Styleguide template and code
     * @private
     */
    function _mergeTemplates(template, templateCode) {
        return template.replace("[code]", templateCode);
    }




    function _getStyleGuideMarktup (partial, sName, markdown, title) {

        //Standard note
        if(typeof markdown === 'undefined') {
            markdown = 'note';
        }

        var markup = '<h2 class="sg-head sg-sub" id="00-Colors"><a href="/#' + sName.toLowerCase() + '" class="sg-pop">' + title + '</a></h2>';
            markup += '<div class="sg-section">';
            markup += '<div class="sg-pattern">';
            markup += partial;
            markup += "[code]";
            markup += '</div>';
            markup += '<div class="sg-annotation-container">';
            markup += '<div class="sg-annotations" style="display: none">{{md  "assets/md/annotations/' + markdown + '.md" }}</div>'
            markup += '</div>';
            markup += '</div>';
        return markup;
    }

    Handlebars.registerHelper('section', section)
};