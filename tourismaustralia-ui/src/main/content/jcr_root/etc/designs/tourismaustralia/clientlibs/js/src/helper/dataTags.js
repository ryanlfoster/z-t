/*!
 * Data Tag Helper Class
 * simple helper class for checking, if data-tags are defined and to convert their strings into booleans if necessary
 */
var DataTagHelper = {};

//check data tags (target element, data tag string and value to override)
DataTagHelper.setDataTag = function(target, dataTagString, value, isInt){
    //check if data tag is defined
    var dataAttr = $(target.element).attr(dataTagString);
    if (dataAttr !== undefined) {
        if(dataAttr === "true" || dataAttr === "false"){
            value = (string === "true");
        }
        if(isInt){
            value = parseInt(value);
        }
    }
    return value;
};