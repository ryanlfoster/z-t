<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/apps/foodandwine/components/global.jsp" %>
<%@ page import="com.australia.foodandwine.components.content.statemosaic.StateMosaic" %>

<c:set var="stateMosaic" value="<%=new StateMosaic(slingRequest) %>"/>

<cq:includeClientLib js="faw-stateMosaic" />

<!-- Script written for handlebar template -->

<script id ="stateMosaic" type="text/x-handlebars-template">
 
<cq:include script="template.jsp" />

</script>
<!-- Included for local testing purpose This should be from statelinks component -->
<!-- <div class="l-display-none-md">
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
		</div> -->
<!-- End of statelinks-->	
<input type="hidden" class="page" name="${stateMosaic.template}"/>
<input type="hidden" class="resourcePath" value="${resource.path}"/>	
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
    <input id="category-wine" type="checkbox" class="category-input" value="wine">
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
    <input id="category-people" type="checkbox" class="category-input" value="people">
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
    <input id="category-seafood" type="checkbox" class="category-input" value="seafood">
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
    <input id="category-produce" type="checkbox" class="category-input" value="produce">
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
    <input id="category-restaurants" type="checkbox" class="category-input" value="restaurant">
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
    <input id="category-experiences" type="checkbox" class="category-input" value="experiences">
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
    <input id="category-events" type="checkbox" class="category-input" value="events">
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
 <c:if test="${stateMosaic.template ne 'homepage'}">   
<div class='mosaicgridchanger'>
    <div class="mosaicgridchanger-button mosaicgridchanger-grid-button mosaicgridchanger-button-active">
        <span class="icon-font-sort_grid"></span>
    </div>
    <div class="mosaicgridchanger-button mosaicgridchanger-list-button">
        <span class="icon-font-sort_list"></span>
    </div>
</div>
   </c:if>
<div class="mosaic" id="statemosaic">
    
</div>
<c:if test="${stateMosaic.template eq 'homepage'}">
    <div class="register" style="display:none">
<div class="col-xs-12 col-sm-6 col-md-12 mosaic-ie-100">
<div class='mosaic-item mosaic-item-register'>
    <div class='mosaic-item mosaic-item-register-inner'>
        <img src="/etc/designs/foodandwine/clientlibs/imgs/placeholders/placeholder-white.jpg" alt="" width="100%"/>
        <div class="mosaic-item-register-content">
            <div class="calltoaction-type-sml1">${stateMosaic.registerTopText}</div>
            <div class="calltoaction-type-lrg">${stateMosaic.registerCenterText}</div>
            <div class="calltoaction-type-sml1">${stateMosaic.registerBottomText}</div>
            <p>
                <a href="${stateMosaic.buttonLink}" class="btn-primary btn-small" target="${stateMosaic.external ? '_BLANK' : '_self'}">${stateMosaic.buttonText}</a>
            </p>
            <p class="faw-register-teaser-subline">${stateMosaic.belowButtonText}</p>
         </div>   
    </div>
</div>
</div>
</div>
                </c:if>
    <!-- END: MOSAIC -->
    <c:if test="${stateMosaic.template ne 'homepage'}"> 
    <p class="type-spacing-120">
        <a  class="btn-secondary btn-auto-size" >Show more Results</a>
    </p>
   </c:if> 
</div>



               <!--  -->