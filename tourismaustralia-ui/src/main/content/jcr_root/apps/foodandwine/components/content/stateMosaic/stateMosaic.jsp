<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/apps/foodandwine/components/global.jsp" %>
<%@ page import="com.australia.foodandwine.components.content.statemosaic.StateMosaic" %>

<c:set var="stateMosaic" value="<%=new StateMosaic(slingRequest) %>"/>
<script type="text/javascript">

$(document).ready(function(){
	//alert("rady");
	//alert($(".icon-map-wrapper").find("icon-map-black-active span" ).text());
	var stateTag=$(".icon-map-black-active " ).text();
	alert(stateTag);
	$('.category-input').click(function(e){
		alert("clicked");

        var x=$(this).attr('id');
        alert(x);
        $("#"+x).click(function(){
            alert("2nd");

        });

           });
	$.ajax({
		type : "POST",
		url : "${resource.path}.ccs.json",
		data : {
			stateTag : stateTag
			

		},
		success : function(msg) {
			alert("success");
			//console.log("${resource.path}.ccs.json" );
			//window.location.href = msg;

		},
		error : function(xhr) {
			console.log('there is some error');

		}
	});	
	 
});

 	/* var checkboxArray = $('input:checkbox:checked').map(function() {
		// if($("input:checkbox:checked"))
		return this.value;
	}).get().join(',');
	alert(checkboxArray); */
	



</script>
<div class="l-display-none-md">
			<p class="icon-map-wrapper">
				<a href="#" class="icon-map icon-map-black icon-map-capital"> <span>Australian Captital Territory</span> </a>
				<a href="#" class="icon-map icon-map-black icon-map-nsw"> <span>New South Wales</span> </a>
				<a href="#" class="icon-map icon-map-black icon-map-northern"> <span>Northern Territory</span> </a>
				<a href="#" class="icon-map icon-map-black icon-map-queensland"> <span>Queensland</span> </a>
				<a href="#" class="icon-map icon-map-black icon-map-south"> <span>South Australia</span> </a>
				<a href="#" class="icon-map icon-map-black icon-map-tasmania"> <span>Tasmania</span> </a>
				<a href="#" class="icon-map icon-map-black icon-map-black-active icon-map-victoria"> <span>Victoria</span> </a>
				<a href="#" class="icon-map icon-map-black icon-map-western"> <span>Western Australia</span> </a>
			</p>
		</div>
<div class="faw-category-mosaic">
    <div class="headerlockup">
        <hr class="headerlockup-hr">
        <div class="headerlockup-type-sml1">${stateMosaic.topText}</div>
        <div class="headerlockup-type-lrg">${stateMosaic.centerText}</div>
        <div class="headerlockup-type-sml2">${stateMosaic.bottomText}</div>
        <hr class="headerlockup-hr">
    </div>
<!-- DESKTOP VIEW -->
<!-- FOOD MOSAIC CATEGORIES -->
<div class="faw-category-mosaci-items l-display-none-md">

    <!-- FOOD MOSAIC CATEGORY ITEM -->
    <input id="category-wine" type="checkbox" class="category-input">
    <label for="category-wine">
        <div class="category-item">
            <span class="icon-round is-active">
                <img class="category-image-light" src="/etc/designs/foodandwine/clientlibs/imgs/base/categories/category-icon-wine-white.png" alt="">
                <img class="category-image-dark" src="/etc/designs/foodandwine/clientlibs/imgs/base/categories/category-icon-wine-dark.png" alt="">
            </span>

            <span class="category-title">
                    Wine Story
            </span>
        </div>
    </label>
    <!-- END: FOOD MOSAIC CATEGORY ITEM -->

    <!-- FOOD MOSAIC CATEGORY ITEM -->
    <input id="category-people" type="checkbox" class="category-input">
    <label for="category-people">
        <div class="category-item">
            <span class="icon-round is-active">
                <img class="category-image-light" src="/etc/designs/foodandwine/clientlibs/imgs/base/categories/category-icon-people-white.png" alt="">
                <img class="category-image-dark" src="/etc/designs/foodandwine/clientlibs/imgs/base/categories/category-icon-people-dark.png" alt="">
            </span>

            <span class="category-title">
                    People
            </span>
        </div>
    </label>
    <!-- END: FOOD MOSAIC CATEGORY ITEM -->

    <!-- FOOD MOSAIC CATEGORY ITEM -->
    <input id="category-seafood" type="checkbox" class="category-input">
    <label for="category-seafood">
        <div class="category-item">
            <span class="icon-round is-active">
                <img class="category-image-light" src="/etc/designs/foodandwine/clientlibs/imgs/base/categories/category-icon-seafood-white.png" alt="">
                <img class="category-image-dark" src="/etc/designs/foodandwine/clientlibs/imgs/base/categories/category-icon-seafood-dark.png" alt="">
            </span>

            <span class="category-title">
                    Seafood
            </span>
        </div>
    </label>
    <!-- END: FOOD MOSAIC CATEGORY ITEM -->

    <!-- FOOD MOSAIC CATEGORY ITEM -->
    <input id="category-produce" type="checkbox" class="category-input">
    <label for="category-produce">
        <div class="category-item">
            <span class="icon-round is-active">
                <img class="category-image-light" src="/etc/designs/foodandwine/clientlibs/imgs/base/categories/category-icon-produce-white.png" alt="">
                <img class="category-image-dark" src="/etc/designs/foodandwine/clientlibs/imgs/base/categories/category-icon-produce-dark.png" alt="">
            </span>

            <span class="category-title">
                    Produce
            </span>
        </div>
    </label>
    <!-- END: FOOD MOSAIC CATEGORY ITEM -->

    <!-- FOOD MOSAIC CATEGORY ITEM -->
    <input id="category-restaurants" type="checkbox" class="category-input">
    <label for="category-restaurants">
    <div class="category-item" id="category-restaurants">
            <span class="icon-round is-active">
                <img class="category-image-light" src="/etc/designs/foodandwine/clientlibs/imgs/base/categories/category-icon-restaurants-white.png" alt="">
                <img class="category-image-dark" src="/etc/designs/foodandwine/clientlibs/imgs/base/categories/category-icon-restaurants-dark.png" alt="">
            </span>

            <span class="category-title">
                    Restaurants
            </span>
        </div>
    </label>
    <!-- END: FOOD MOSAIC CATEGORY ITEM -->

    <!-- FOOD MOSAIC CATEGORY ITEM -->
    <input id="category-experiences" type="checkbox" class="category-input">
    <label for="category-experiences">
        <div class="category-item" >
            <span class="icon-round is-active">
                <img class="category-image-light" src="/etc/designs/foodandwine/clientlibs/imgs/base/categories/category-icon-experiences-white.png" alt="">
                <img class="category-image-dark" src="/etc/designs/foodandwine/clientlibs/imgs/base/categories/category-icon-experiences-dark.png" alt="">
            </span>
            <span class="category-title">
                    Experiences
            </span>
        </div>
    </label>
    <!-- END: FOOD MOSAIC CATEGORY ITEM -->

    <!-- FOOD MOSAIC CATEGORY ITEM -->
    <input id="category-events" type="checkbox" class="category-input">
    <label for="category-events">
    <div class="category-item">
            <span class="icon-round is-active">
                <img class="category-image-light" src="/etc/designs/foodandwine/clientlibs/imgs/base/categories/category-icon-events-white.png" alt="">
                <img class="category-image-dark" src="/etc/designs/foodandwine/clientlibs/imgs/base/categories/category-icon-events-dark.png" alt="">
            </span>

            <span class="category-title">
                    Events
            </span>
       </div>
    </label>
    <!-- END: FOOD MOSAIC CATEGORY ITEM -->

</div>
<!-- END: FOOD MOSAIC CATEGORIES -->
<!-- END DESKTOP VIEW -->
<!-- MOBILE VIEW -->
<!-- FOOD MOSAIC CATEGORIES DROP DOWN -->
<div class="l-display-md">
    <select class="input-select input-select-small">
        <option value="" selected="selected" disabled>SELECT CATEGORY</option>
        <option value="restaurants">Restaurants</option>
        <option value="wine">Wine</option>
        <option value="produce">Produce</option>
        <option value="events">Events</option>
        <option value="people">People</option>
        <option value="experiences">Experiences</option>
        <option value="seafood">Seafood</option>
    </select>
</div>
<!-- END: FOOD MOSAIC CATEGORIES DROP DOWN -->
<!-- END MOBILE VIEW -->
    <!-- FOOD MOSAIC GRID CHANGER -->
<div class='mosaicgridchanger'>
    <div class="mosaicgridchanger-button mosaicgridchanger-grid-button mosaicgridchanger-button-active">
        <span class="icon-font-sort_grid"></span>
    </div>
    <div class="mosaicgridchanger-button mosaicgridchanger-list-button">
        <span class="icon-font-sort_list"></span>
    </div>
</div>
    <!-- END: FOOD MOSAIC GRID CHANGER -->
    <!-- MOSAIC -->
<div class="mosaic">
    <div class="row l-row-collapse">
        <div class="col-xs-12 col-md-6">
<a href="#" title="" class="mosaic-item">
    <img class='mosaic-item-image' src="http://placehold.it/580x580" alt="" width="100%"/>
    <!-- Parent view -->
    <span class="mosaic-item-description">
        <span class="mosaic-item-description-head type-font-feature">Melbourne & Wine</span>
        <span class="mosaic-item-description-sub">New South Wales</span>
        <span class="mosaic-item-description-copy">
            Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
            <br><br>
            <span class="mosaic-item-description-copy-link"><strong>Read more</strong></span>
        </span>
        <span class="mosaic-item-description-share mosaic-item-description-share-dark">
            <img src="imgs/base/share/share-instagram-black.png" alt="">
        </span>
        <span class="mosaic-item-description-share mosaic-item-description-share-white">
            <img src="imgs/base/share/share-instagram-white.png" alt=""/>
        </span>
    </span>
    <!-- End Parent view -->
    <!-- Overlay -->
    <span class="mosaic-item-overlay mosaic-item-overlay-share">
         <span class="mosaic-item-overlay-share-container">
             <span class="mosaic-item-overlay-share-copy">
                Looking forward AS ALWAYS to seeing you all @eveleighmarket @carriageworks tomorrow! All you need is an empty basket to fill with...
              <br><br>
              <strong>kylie_kwong on Instagram</strong>
            </span>
        </span>
    </span>
    <!-- End Overlay -->
</a>
        </div>
        <div class="col-xs-12 col-md-6">
            <div class="row">
                <div class="col-xs-12 col-sm-6">
<a href="#" title="" class="mosaic-item">
    <img class='mosaic-item-image' src="http://placehold.it/580x580" alt="" width="100%"/>
    <!-- Parent view -->
    <span class="mosaic-item-description">
        <span class="mosaic-item-description-head type-font-feature">Melbourne & Wine</span>
        <span class="mosaic-item-description-sub">New South Wales</span>
        <span class="mosaic-item-description-copy">
            Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
            <br><br>
            <span class="mosaic-item-description-copy-link"><strong>Read more</strong></span>
        </span>
        <span class="mosaic-item-description-share mosaic-item-description-share-dark">
            <img src="imgs/base/share/share-instagram-black.png" alt="">
        </span>
        <span class="mosaic-item-description-share mosaic-item-description-share-white">
            <img src="imgs/base/share/share-instagram-white.png" alt=""/>
        </span>
    </span>
    <!-- End Parent view -->
    <!-- Overlay -->
    <span class="mosaic-item-overlay mosaic-item-overlay-share">
         <span class="mosaic-item-overlay-share-container">
             <span class="mosaic-item-overlay-share-copy">
                Looking forward AS ALWAYS to seeing you all @eveleighmarket @carriageworks tomorrow! All you need is an empty basket to fill with...
              <br><br>
              <strong>kylie_kwong on Instagram</strong>
            </span>
        </span>
    </span>
    <!-- End Overlay -->
</a>
                </div>
                <div class="col-xs-12 col-sm-6">
<a href="#" class="mosaic-item"  title="">
    <img class='mosaic-item-image' src="http://placehold.it/580x580" alt="" width="100%"/>
    <!-- Parent view -->
    <span class="mosaic-item-description">
        <span class="mosaic-item-description-head type-font-feature">
            The burger shed
        </span>
        <span class="mosaic-item-description-sub">
            New South Wales
        </span>
        <span class="mosaic-item-description-copy">
            Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
            <br><br>
            <span class="mosaic-item-description-copy-link"><strong>Read more</strong></span>
            <strong class="mosaic-item-description-categories"><em>Restaurant, Places, People</em></strong>
        </span>
    </span>
    <!-- End Parent view -->
    <!-- Overlay view -->
    <span class="mosaic-item-overlay mosaic-item-overlay-info">
         <span class="mosaic-item-overlay-info-icon">
             <span class="mosaic-item-overlay-info-head type-font-feature">The burger<br/>shed</span>
              <span class="mosaic-item-overlay-info-icon-item">
                 <img src="imgs/base/categories/category-icon-wine-white.png" alt="">
             </span>
             <span class="mosaic-item-overlay-info-desciption">
			changed
                 <br>
                 <br>
                  <span class="mosaic-item-description-copy-link"><strong>Find out more</strong></span>
             </span>
         </span>
          <span class="mosaic-item-overlay-info-categories">
                 <strong>Restaurants, People, Experience...</strong>
          </span>
    </span>
    <!-- End Overlay view -->
</a>
                </div>
                <div class="col-xs-12 col-sm-6">
<a href="#" title="" class="mosaic-item">
    <img class='mosaic-item-image' src="http://placehold.it/580x580" alt="" width="100%"/>
    <!-- Parent view -->
    <span class="mosaic-item-description">
        <span class="mosaic-item-description-head type-font-feature">Melbourne & Wine</span>
        <span class="mosaic-item-description-sub">New South Wales</span>
        <span class="mosaic-item-description-copy">
            Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
            <br><br>
            <span class="mosaic-item-description-copy-link"><strong>Read more</strong></span>
        </span>
        <span class="mosaic-item-description-share mosaic-item-description-share-dark">
            <img src="imgs/base/share/share-instagram-black.png" alt="">
        </span>
        <span class="mosaic-item-description-share mosaic-item-description-share-white">
            <img src="imgs/base/share/share-instagram-white.png" alt=""/>
        </span>
    </span>
    <!-- End Parent view -->
    <!-- Overlay -->
    <span class="mosaic-item-overlay mosaic-item-overlay-share">
         <span class="mosaic-item-overlay-share-container">
             <span class="mosaic-item-overlay-share-copy">
                Looking forward AS ALWAYS to seeing you all @eveleighmarket @carriageworks tomorrow! All you need is an empty basket to fill with...
              <br><br>
              <strong>kylie_kwong on Instagram</strong>
            </span>
        </span>
    </span>
    <!-- End Overlay -->
</a>
                </div>
                <div class="col-xs-12 col-sm-6">
<a href="#" class="mosaic-item"  title="">
    <img class='mosaic-item-image' src="http://placehold.it/580x580" alt="" width="100%"/>
    <!-- Parent view -->
    <span class="mosaic-item-description">
        <span class="mosaic-item-description-head type-font-feature">
            The burger shed
        </span>
        <span class="mosaic-item-description-sub">
            New South Wales
        </span>
        <span class="mosaic-item-description-copy">
            Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
            <br><br>
            <span class="mosaic-item-description-copy-link"><strong>Read more</strong></span>
            <strong class="mosaic-item-description-categories"><em>Restaurant, Places, People</em></strong>
        </span>
    </span>
    <!-- End Parent view -->
    <!-- Overlay view -->
    <span class="mosaic-item-overlay mosaic-item-overlay-info">
         <span class="mosaic-item-overlay-info-icon">
             <span class="mosaic-item-overlay-info-head type-font-feature">The burger<br/>shed</span>
              <span class="mosaic-item-overlay-info-icon-item">
                 <img src="imgs/base/categories/category-icon-wine-white.png" alt="">
             </span>
             <span class="mosaic-item-overlay-info-desciption">
				wolomolo chnaged
                 <br>
                 <br>
                  <span class="mosaic-item-description-copy-link"><strong>Find out more</strong></span>
             </span>
         </span>
          <span class="mosaic-item-overlay-info-categories">
                 <strong>Restaurants, People, Experience...</strong>
          </span>
    </span>
    <!-- End Overlay view -->
</a>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="mosaic">
    <div class="row l-row-collapse">
         <div class="col-xs-12 col-md-3 mosaic-ie-25">
            <div class="row">
                <div class="col-xs-12 col-sm-6 col-md-12 mosaic-ie-100">
<a href="#" class="mosaic-item"  title="">
    <img class='mosaic-item-image' src="http://placehold.it/580x580" alt="" width="100%"/>
    <!-- Parent view -->
    <span class="mosaic-item-description">
        <span class="mosaic-item-description-head type-font-feature">
            The burger shed
        </span>
        <span class="mosaic-item-description-sub">
            New South Wales
        </span>
        <span class="mosaic-item-description-copy">
            Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
            <br><br>
            <span class="mosaic-item-description-copy-link"><strong>Read more</strong></span>
            <strong class="mosaic-item-description-categories"><em>Restaurant, Places, People</em></strong>
        </span>
    </span>
    <!-- End Parent view -->
    <!-- Overlay view -->
    <span class="mosaic-item-overlay mosaic-item-overlay-info">
         <span class="mosaic-item-overlay-info-icon">
             <span class="mosaic-item-overlay-info-head type-font-feature">The burger<br/>shed</span>
              <span class="mosaic-item-overlay-info-icon-item">
                 <img src="imgs/base/categories/category-icon-wine-white.png" alt="">
             </span>
             <span class="mosaic-item-overlay-info-desciption">
				Changed
                 <br>
                 <br>
                  <span class="mosaic-item-description-copy-link"><strong>Find out more</strong></span>
             </span>
         </span>
          <span class="mosaic-item-overlay-info-categories">
                 <strong>Restaurants, People, Experience...</strong>
          </span>
    </span>
    <!-- End Overlay view -->
</a>
                </div>
                <div class="col-xs-12 col-sm-6 col-md-12 mosaic-ie-100">
<a href="#" title="" class="mosaic-item">
    <img class='mosaic-item-image' src="http://placehold.it/580x580" alt="" width="100%"/>
    <!-- Parent view -->
    <span class="mosaic-item-description">
        <span class="mosaic-item-description-head type-font-feature">Melbourne & Wine</span>
        <span class="mosaic-item-description-sub">New South Wales</span>
        <span class="mosaic-item-description-copy">
            Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
            <br><br>
            <span class="mosaic-item-description-copy-link"><strong>Read more</strong></span>
        </span>
        <span class="mosaic-item-description-share mosaic-item-description-share-dark">
            <img src="imgs/base/share/share-instagram-black.png" alt="">
        </span>
        <span class="mosaic-item-description-share mosaic-item-description-share-white">
            <img src="imgs/base/share/share-instagram-white.png" alt=""/>
        </span>
    </span>
    <!-- End Parent view -->
    <!-- Overlay -->
    <span class="mosaic-item-overlay mosaic-item-overlay-share">
         <span class="mosaic-item-overlay-share-container">
             <span class="mosaic-item-overlay-share-copy">
                Looking forward AS ALWAYS to seeing you all @eveleighmarket @carriageworks tomorrow! All you need is an empty basket to fill with...
              <br><br>
              <strong>kylie_kwong on Instagram</strong>
            </span>
        </span>
    </span>
    <!-- End Overlay -->
</a>
                </div>
            </div>
        </div>
        <div class="col-xs-12 col-md-6">
<a href="#" class="mosaic-item"  title="">
    <img class='mosaic-item-image' src="http://placehold.it/580x580" alt="" width="100%"/>
    <!-- Parent view -->
    <span class="mosaic-item-description">
        <span class="mosaic-item-description-head type-font-feature">
            The burger shed
        </span>
        <span class="mosaic-item-description-sub">
            New South Wales
        </span>
        <span class="mosaic-item-description-copy">
            Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
            <br><br>
            <span class="mosaic-item-description-copy-link"><strong>Read more</strong></span>
            <strong class="mosaic-item-description-categories"><em>Restaurant, Places, People</em></strong>
        </span>
    </span>
    <!-- End Parent view -->
    <!-- Overlay view -->
    <span class="mosaic-item-overlay mosaic-item-overlay-info">
         <span class="mosaic-item-overlay-info-icon">
             <span class="mosaic-item-overlay-info-head type-font-feature">The burger<br/>shed</span>
              <span class="mosaic-item-overlay-info-icon-item">
                 <img src="imgs/base/categories/category-icon-wine-white.png" alt="">
             </span>
             <span class="mosaic-item-overlay-info-desciption">
				changed
                 <br>
                 <br>
                  <span class="mosaic-item-description-copy-link"><strong>Find out more</strong></span>
             </span>
         </span>
          <span class="mosaic-item-overlay-info-categories">
                 <strong>Restaurants, People, Experience...</strong>
          </span>
    </span>
    <!-- End Overlay view -->
</a>
        </div>
        <div class="col-xs-12 col-md-3 mosaic-ie-25">
            <div class="row">
                <div class="col-xs-12 col-sm-6 col-md-12 mosaic-ie-100">
<a href="#" class="mosaic-item"  title="">
    <img class='mosaic-item-image' src="http://placehold.it/580x580" alt="" width="100%"/>
    <!-- Parent view -->
    <span class="mosaic-item-description">
        <span class="mosaic-item-description-head type-font-feature">
            The burger shed
        </span>
        <span class="mosaic-item-description-sub">
            New South Wales
        </span>
        <span class="mosaic-item-description-copy">
            Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
            <br><br>
            <span class="mosaic-item-description-copy-link"><strong>Read more</strong></span>
            <strong class="mosaic-item-description-categories"><em>Restaurant, Places, People</em></strong>
        </span>
    </span>
    <!-- End Parent view -->
    <!-- Overlay view -->
    <span class="mosaic-item-overlay mosaic-item-overlay-info">
         <span class="mosaic-item-overlay-info-icon">
             <span class="mosaic-item-overlay-info-head type-font-feature">The burger<br/>shed</span>
              <span class="mosaic-item-overlay-info-icon-item">
                 <img src="imgs/base/categories/category-icon-wine-white.png" alt="">
             </span>
             <span class="mosaic-item-overlay-info-desciption">
				Changed
                 <br>
                 <br>
                  <span class="mosaic-item-description-copy-link"><strong>Find out more</strong></span>
             </span>
         </span>
          <span class="mosaic-item-overlay-info-categories">
                 <strong>Restaurants, People, Experience...</strong>
          </span>
    </span>
    <!-- End Overlay view -->
</a>
                </div>
                <div class="col-xs-12 col-sm-6 col-md-12 mosaic-ie-100">
<a href="#" title="" class="mosaic-item">
    <img class='mosaic-item-image' src="http://placehold.it/580x580" alt="" width="100%"/>
    <!-- Parent view -->
    <span class="mosaic-item-description">
        <span class="mosaic-item-description-head type-font-feature">Melbourne & Wine</span>
        <span class="mosaic-item-description-sub">New South Wales</span>
        <span class="mosaic-item-description-copy">
            Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
            <br><br>
            <span class="mosaic-item-description-copy-link"><strong>Read more</strong></span>
        </span>
        <span class="mosaic-item-description-share mosaic-item-description-share-dark">
            <img src="imgs/base/share/share-instagram-black.png" alt="">
        </span>
        <span class="mosaic-item-description-share mosaic-item-description-share-white">
            <img src="imgs/base/share/share-instagram-white.png" alt=""/>
        </span>
    </span>
    <!-- End Parent view -->
    <!-- Overlay -->
    <span class="mosaic-item-overlay mosaic-item-overlay-share">
         <span class="mosaic-item-overlay-share-container">
             <span class="mosaic-item-overlay-share-copy">
                Looking forward AS ALWAYS to seeing you all @eveleighmarket @carriageworks tomorrow! All you need is an empty basket to fill with...
              <br><br>
              <strong>kylie_kwong on Instagram</strong>
            </span>
        </span>
    </span>
    <!-- End Overlay -->
</a>
                </div>
            </div>
        </div>
    </div>
</div>
    <!-- END: MOSAIC -->
    <p class="type-spacing-120">
        <a href="#" class="btn-secondary btn-auto-size">Show more Results</a>
    </p>
</div>