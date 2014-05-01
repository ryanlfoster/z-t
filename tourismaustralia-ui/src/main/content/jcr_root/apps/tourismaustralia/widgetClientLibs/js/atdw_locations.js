$(document).ready(function(){

    var form_selector = "div[data-aus-atdw]";
    var state_selector = "select[name=state]";
    var region_selector = "select[name=region]";
    var city_selector = "select[name=city]";
    var refresh_selector = "a[data-aus-atdw-refresh]";

    $(form_selector).each(function(index, element) {

        var $form = $(element);

        var $state;
        var $region;
        var $city;
        var $refresh;

        var locations;

        $.fn.outerHTML = function() {
            return $('<div />').append(this.eq(0).clone()).html();
        };

        $.getJSON( "/bin/ta/atdwlocations.json", function( data ) {
            locations = data;

            $form.find(state_selector).each(function(index, element) {
                $state = $(element);
                $state.change(function() {
                    onStateChange($state.val());
                });
            });

            $form.find(region_selector).each(function(index, element) {
                $region = $(element);
                $region.change(function() {
                    onRegionChange($region.val());
                });
            });

            $form.find(city_selector).each(function(index, element) {
                $city = $(element);
            });

            $form.find(refresh_selector).each(function(index, element) {
                $refresh = $(element);
                $refresh.click(refresh);
            });

            populateStates();
        });

        function populateStates() {
            var output = [];
            $state.children().each(function (index, element) {
                var $option = $(element);
                if ($option.val() == '.') {
                    output.push($option.outerHTML());
                }
                $option.remove();
            });
            $.each(locations, function(key, val) {
                output.push('<option value="'+ key +'">'+ key +'</option>');
            });
            $state[0].innerHTML = output.join('');

            resetSelects();
        }

        function onStateChange(state) {
            var $all;
            $region.children().each(function (index, element) {
                var $option = $(element);
                if ($option.val() != '.') {
                    $option.remove();
                } else {
                    $all = $option;
                    $option.remove();
                }
            });

            var output = [];
            if ($all) {
                output.push($all.outerHTML());
            }

            var stateMap = locations[state];
            if(stateMap) {
                $.each(stateMap, function(key) {
                    output.push('<option value="'+ key +'">'+ key +'</option>');
                });
            }

            $region.html(output.join(''));
            $region.val('.');
            onRegionChange('.');
        }

        function onRegionChange(region) {
            var $all;
            $city.children().each(function (index, element) {
                var $option = $(element);
                if ($option.val() != '.') {
                    $option.remove();
                } else {
                    $all = $option;
                    $option.remove();
                }
            });


            var output = [];
            if ($all) {
                output.push($all.outerHTML());
            }

            var state = $state.val();
            var stateMap = locations[state];
            if(stateMap) {
                var regionList = stateMap[region];
                if (regionList) {
                    for(var i = 0; i < regionList.length; i++) {
                        var city = regionList[i];
                        output.push('<option value="' + city + '">' + city + '</option>');
                    }
                }
            }

            $city.html(output.join(''));
            $city.val('.');
        }

        function refresh() {
            var basePath = document.location.pathname + '?';
            var searchArgsObj = parseSearchArgs();
            searchArgsObj['state'] = $state.val();
            searchArgsObj['region'] = $region.val();
            searchArgsObj['city'] = $city.val();
            searchArgsObj['page'] = 1;
            var path = basePath + outputSearchArgs(searchArgsObj);
            window.location.href = path;
        }

        function parseSearchArgs() {
            var search = document.location.search.substr(1);
            var searchArgs = search.split('&');
            var out = {};
            for(var i = 0; i < searchArgs.length; i++) {
                var args = searchArgs[i].split('=');
                if(args.length == 2) {
                    var key = decodeURIComponent(args[0]);
                    var val = decodeURIComponent(args[1]);
                    out[key] = val;
                }
            }
            return out;
        }

        function outputSearchArgs(searchArgsObj) {
            var out = [];
            $.each(searchArgsObj, function(key, value) {
                out.push(encodeURIComponent(key) + '=' + encodeURIComponent(value));
            });
            return out.join('&');
        }

        function resetSelects() {
            // Reset the drop-downs to the user's last selection
            var searchArgs = parseSearchArgs();
            var inputState = searchArgs['state'];
            var regionMap = locations[inputState];
            if(regionMap) {
                $state.val(inputState);
                onStateChange(inputState);
                var inputRegion = searchArgs['region'];
                var cities = regionMap[inputRegion];
                if(cities) {
                    $region.val(inputRegion);
                    onRegionChange(inputRegion);
                    var inputCity = searchArgs['city'];
                    if(cities.indexOf(inputCity) >= 0) {
                        $city.val(inputCity);
                    }
                }
            }
        }

    });

});
