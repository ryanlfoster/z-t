/*
 * Adobe Systems Incorporated
 * Modified: October 30th, 2012
 *
 * Picturefill - Responsive Images that work today. (and mimic the proposed Picture element with divs).
 * Author: Scott Jehl, Filament Group, 2012 | License: MIT/GPLv2
 */

(function ($, w) {

    // Enable strict mode
    "use strict";

    w.picturefill = function (context) {
        var undefined;
        var parallaxImagesCounterID =0;

        if (context === undefined) {
            context = $("body");
        }

        $("div[data-picture]", context).each(function () {
            var currentPicture = this;
            var matches = [];
            $("div[data-media]", currentPicture).each(function () {
                var media = $(this).attr("data-media");
                if (!media || ( w.matchMedia && w.matchMedia(media).matches )) {
                    matches.push(this);
                }
            });

            var $picImg = $("img", currentPicture).first();

            if (matches.length) {
                if ($picImg.size() === 0) {
                    var $currentPicture = $(currentPicture);
                    $picImg = $("<img />").attr("alt", $currentPicture.attr("data-alt")).appendTo($currentPicture);
                }
                var $matchElement = matches.pop();
                $picImg.attr("src", $matchElement.getAttribute("data-src"));

                // Start - Code for setting the data-extra-height according to new Parallax code
                var data_extra_height = $matchElement.getAttribute("data-height");
                if(data_extra_height!=null)
                {
                    parallaxImagesCounterID = parallaxImagesCounterID + 1;
                    data_extra_height = parseFloat(data_extra_height) - 436;//436 is default height of parallax plugin
                    $picImg.closest('.largeparallax').find('.img-holder').attr("data-extra-height", data_extra_height).attr('data-id-for-parallax', 'parallax_elementID_' + parallaxImagesCounterID);
                }
                // End - Code for setting the data-extra-height according to new Parallax code

            } else {
                $picImg.remove();
            }
        });
    };

    // Run on debounced resize and domready
    $(function () {

        w.picturefill();
    });

    $(w).on("debouncedresize", function () {
        w.picturefill();
    });

}($, this));