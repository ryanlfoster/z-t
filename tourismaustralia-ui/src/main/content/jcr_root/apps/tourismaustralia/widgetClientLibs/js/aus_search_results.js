$(document).ready(function(){

    var container_selector = "div[data-aus-result-container]";
    var inner_container_selector = "div[data-aus-result-container-inner]";
    var button_selector = "a[data-aus-load-results]";
    var limit = 10;

    // Find container
    $(container_selector).each(function(index, element){

        var page = 2;

        var $container = $(element);

        var $button;

        var $insert;

        var htmlToInsert;

        // Find the load more
        $container.find(button_selector).each(function(index, element){

            $button = $(element);

        });

        // Find the load more
        $container.find(inner_container_selector).each(function(index, element){

            $insert = $(element);

        });

        // loads the data for the next page, caching it in memory until the button is hit
        function loadNextPage() {

            // Prevent double-clicks
            $button.off('click', loadNextPage);

            if(htmlToInsert) {

                var $toInsert = $(htmlToInsert);
                $toInsert.hide();
                $insert.children().last().after($toInsert);
                $toInsert.fadeIn(300);

            }

            var data = {
                'page': page,
                'limit': limit,
                'term': $.url().param('term'),
                'mode': $.url().param('mode')
            };

            var url = location.pathname.replace('.html', '/_jcr_content.searchfragment.json');

            $.get(url, data, addResults, 'html');
        }

        // Adds any cached results to the page, then caches the incoming results for the next load
        // If the incoming results are empty, the button will be removed
        function addResults(html) {

            if(html.trim() === '') {

                $button.remove();

            } else {

                htmlToInsert = html;

                page += 1;

                // start/resume listening for the next button click
                $button.on('click', loadNextPage);

            }
        }

        loadNextPage();

    });

});
