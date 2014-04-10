$(document).ready(function(){

    var button_selector = "a[data-atdw-category]";
    var content_selector = "[data-atdw-show-cat]";
    var select_selector = "select[data-atdw-select]";

    // Find each highlights container
    $(".makeyourtriphappen-container").each(function(index, element){

        var $component = $(element);

        var $select = $component.find(select_selector);

        $select.change(function() {
            selectCategory(this.value, $component);
        });

        // Find each contained category selector
        $component.find(button_selector).each(function(index, element){

            var $button = $(element);

            var category = $button.attr("data-atdw-category");

            $button.bind("click", function(){
                // We use the drop-down as the main selection mechanism to keep both select mechanisms in-sync
                $select.val(category);
                $select.change();
            });

            if(index === 0) {
                $select.val(category);
                $select.change();
            }

        });
    });


    function selectCategory(category, $component){

        var categoryText;

        $component.find(button_selector).each(function(index, element) {

            var $elem = $(element);

            if(category === $elem.attr("data-atdw-category")) {
                $elem.addClass("is-active");
                categoryText = $elem.find(".type-below-btn").text();
            } else {
                $elem.removeClass("is-active");
            }

        });

        $component.find(content_selector).each(function(index, element) {

            var $elem = $(element);

            if(category === $elem.attr("data-atdw-show-cat")) {
                $elem.show();
            } else {
                $elem.hide();
            }

        });

    }

});

