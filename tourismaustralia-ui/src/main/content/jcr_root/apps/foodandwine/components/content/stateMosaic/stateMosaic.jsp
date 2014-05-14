<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/apps/foodandwine/components/global.jsp" %>
<%@ page import="com.australia.foodandwine.components.content.statemosaic.StateMosaic" %>

<c:set var="stateMosaic" value="<%=new StateMosaic(slingRequest) %>"/>

<cq:includeClientLib js="faw-stateMosaic" />

<!-- Script written for handlebar template -->

<script id ="stateMosaic" type="text/x-handlebars-template">
 
<%@ include file="template.jsp" %>

</script>
<input type="hidden" class="message" value="${stateMosaic.messageText}"/>
<input type="hidden" class="page" name="${stateMosaic.template}"/>
<input type="hidden" name="currentPage" value="${currentPage.path}"/>
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
    <c:if test="${stateMosaic.wine}">
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
    </c:if>
    <!-- END: FOOD MOSAIC CATEGORY ITEM -->

    <!-- FOOD MOSAIC CATEGORY ITEM -->
   <c:if test="${stateMosaic.people}">
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
    </c:if>
    <!-- END: FOOD MOSAIC CATEGORY ITEM -->

    <!-- FOOD MOSAIC CATEGORY ITEM -->
    <c:if test="${stateMosaic.seafood}">
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
    </c:if>
    <!-- END: FOOD MOSAIC CATEGORY ITEM -->

    <!-- FOOD MOSAIC CATEGORY ITEM -->
    <c:if test="${stateMosaic.produce}">
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
    </c:if>
    <!-- END: FOOD MOSAIC CATEGORY ITEM -->

    <!-- FOOD MOSAIC CATEGORY ITEM -->
    <c:if test="${stateMosaic.restaurant}">
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
    </c:if>
    <!-- END: FOOD MOSAIC CATEGORY ITEM -->

    <!-- FOOD MOSAIC CATEGORY ITEM -->
     <c:if test="${stateMosaic.experiences}">
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
    </c:if>
    <!-- END: FOOD MOSAIC CATEGORY ITEM -->

    <!-- FOOD MOSAIC CATEGORY ITEM -->
    <c:if test="${stateMosaic.events}">
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
    </c:if>
    <!-- END: FOOD MOSAIC CATEGORY ITEM -->

</div>
<!-- END: FOOD MOSAIC CATEGORIES -->
<!-- END DESKTOP VIEW -->
<!-- MOBILE VIEW -->
<!-- FOOD MOSAIC CATEGORIES DROP DOWN -->
<div class="l-display-md">
    <select class="input-select input-select-small category-input-small">
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
    <!-- END: MOSAIC -->
    <c:if test="${stateMosaic.template ne 'homepage'}"> 
    <p class="type-spacing-120">
        <a  class="btn-secondary btn-auto-size" >Show more Results</a>
    </p>
   </c:if> 
</div>
