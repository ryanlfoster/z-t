(function ($, w) {

    // Enable strict mode
    "use strict";

    w.parallaxscroll = function (context) {

        // Used for new parallax
        var touch = Modernizr.touch,
        csstransforms3d = Modernizr.csstransforms3d;
        //parseInt($(this).attr("data-extra-height"))

        if(csstransforms3d === true){
            $('.img-holder').imageScroll({
                holderClass: 'parallaxHolder',
                coverRatio: 0.50,
                container: $('#main-content'),
                parallax: csstransforms3d,
                touch: touch
            });
        };
    };

    // Run on debounced resize and domready
    $(function () {
        w.parallaxscroll();
    });

    $(w).on("debouncedresize", function () {
       w.parallaxscroll();
    });

}($, this));