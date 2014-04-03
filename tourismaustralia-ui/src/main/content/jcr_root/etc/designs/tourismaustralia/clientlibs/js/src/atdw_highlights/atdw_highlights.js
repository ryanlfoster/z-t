$(document).ready(function(){
    // Find each highlights container
    $("div[data-atdw-path]").each(function(index, element){

        var $elem = $(element);

        //TODO find the target div
        var target = $elem.find("div[data-atdw-content]");

        var path = $elem.attr("data-atdw-path");

        // Find each contained category selector
        $elem.find("a[data-atdw-category]").each(function(index, element){

            var $elem = $(element);

            var category = $elem.attr("data-atdw-category");

            $elem.bind("click", function(){
                populateContent(path, category, target);
            });

        });
    });


    function populateContent(path, category, target){

    }

});

