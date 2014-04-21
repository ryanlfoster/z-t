<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/apps/foodandwine/components/global.jsp" %>
<%@ page import="com.australia.foodandwine.components.content.statemosaic.StateMosaic" %>

<c:set var="stateMosaic" value="<%=new StateMosaic(slingRequest) %>"/>


<script type="text/javascript">

$(document).ready(function(){
	 $(".btn-secondary").hide();
	 $(".mosaicgridchanger").hide();
	var stateTag=$(".icon-map-black-active " ).text();
    var catogoryArray=new Array();
    var source   = $("#stateMosaic").html();
		 $(document).on("click",'.category-input ', function(){
			 $(".mosaic").empty();
             var flag="default";
			 var x=$(this).attr('id');
		     if($(this).is(":checked"))
	         {
	             var checked=$("label[for='"+x+"']").find(".category-title").text();
	             //alert(checked);
	             if($.inArray(checked, catogoryArray)===-1)
	            	catogoryArray.push(checked);
	         }
	         else
	         {
				var uncheked= $("label[for='"+x+"']").find(".category-title").text()
				if($.inArray(uncheked, catogoryArray)!==-1)
                    catogoryArray = jQuery.grep(catogoryArray, function(value) {
						 return value != uncheked;
					});
	         }
			 $.ajax({
             type : "POST",
			 url : "${resource.path}.ccs.json",
             dataType:"json",
			 data : {
				 stateTag : stateTag,
				 catogoryArray:catogoryArray,
                 flag:flag
			 },
			 success : function(msg) {
				 //alert(msg.length);
				 $(".mosaicgridchanger").show();
        		if(msg.length>=10)
						$(".btn-secondary").show();
        		else
        			$(".btn-secondary").hide();
                var data;
                 var obj;
                data = JSON.stringify(msg);
                data=data.replace("[","");
                data=data.replace("]","");
      			//alert(data);
                data="{test:["+data+"]}";
                //alert(data);
                var obj=eval('('+data+')');
				Handlebars.registerHelper('compare', function(lvalue, rvalue, options) {
				    if (arguments.length < 3)
	        			throw new Error("Handlerbars Helper 'compare' needs 2 parameters");
	    			operator = options.hash.operator || "==";
				    var operators = {
				        '==':       function(l,r) { return l == r; },
				        '===':      function(l,r) { return l === r; },
				        '!=':       function(l,r) { return l != r; },
				        '<':        function(l,r) { return l < r; },
				        '>':        function(l,r) { return l > r; },
				        '<=':       function(l,r) { return l <= r; },
				        '>=':       function(l,r) { return l >= r; },
				        'typeof':   function(l,r) { return typeof l == r; }
				    }
	
				    if (!operators[operator])
				        throw new Error("Handlerbars Helper 'compare' doesn't know the operator "+operator);
	
	    			var result = operators[operator](lvalue,rvalue);
	
	    			if( result ) {
	        			return options.fn(this);
				    } else {
				        return options.inverse(this);
				    }

				});   

				var template = Handlebars.compile(source);
					 //alert("template "+template(obj));
				$(".mosaic").append(template(obj));
			}, 
			error : function(xhr) {
				console.log('there is some error');
			}
		});	
     });
     	$(".btn-secondary ").click(function(){
        	//alert("click "+catogoryArray);
			//$(".mosaic").empty();
        	var flag="showMore";
			$.ajax({
	            type : "POST",
				url : "${resource.path}.ccs.json",
	            dataType:"json",
				data : {
					stateTag : stateTag,
	                catogoryArray:catogoryArray,
	                flag:flag
	
				},
				success : function(msg) {
					$(".mosaicgridchanger").show();
					if(msg.length<10)
						$(".btn-secondary").hide();
	                //alert("success "+msg);
	                var data;
	                var obj;
	                data = JSON.stringify(msg);
	                //alert(data);
	                data=data.replace("[","");
	                data=data.replace("]","");
	                //alert(data);
	                data="{test:["+data+"]}";
	                //alert(data);
	                var obj=eval('('+data+')');
	                var template = Handlebars.compile(source);
						//alert("template "+template(obj));
	                
					$(".mosaic").append(template(obj));
	            }
        });
    });
});
</script>
<!-- Script written for handlebar template -->

<script id ="stateMosaic" type="text/x-handlebars-template">

<div class="row l-row-collapse">
 {{#each test}}
	{{#compare @index 0 operator="=="}}  
        <div class="col-xs-12 col-md-6">
            <a href="{{pagePath}}" title="" class="mosaic-item">
    		<img class='mosaic-item-image' src="{{image}}" alt="" width="100%"/>
    		<span class="mosaic-item-description">
        		<span class="mosaic-item-description-head type-font-feature">{{title}}</span>
        		<span class="mosaic-item-description-sub">{{stateTag}}</span>
        		<span class="mosaic-item-description-copy">
            		{{description}}
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
    		<span class="mosaic-item-overlay mosaic-item-overlay-share">
         		<span class="mosaic-item-overlay-share-container">
             		<span class="mosaic-item-overlay-share-copy">
                		Looking forward AS ALWAYS to seeing you all @eveleighmarket @carriageworks tomorrow! All you need is an empty basket to fill with...
              			<br><br>
              			<strong>kylie_kwong on Instagram</strong>
            		</span>
        		</span>
    		</span>
           </a>
       </div>
	{{/compare}}
 {{/each}}

<div class="col-xs-12 col-md-6">
 <div class="row">
      {{#each test}}
{{#compare @index 1 operator="=="}} 
                <div class="col-xs-12 col-sm-6">
                    <a href="{{pagePath}}" title="" class="mosaic-item">
    <img class='mosaic-item-image' src="{{image}}" alt="" width="100%"/>

    <span class="mosaic-item-description">
        <span class="mosaic-item-description-head type-font-feature">{{tiitle}}</span>
        <span class="mosaic-item-description-sub">{{stateTag}}</span>
        <span class="mosaic-item-description-copy">
            {{description}}
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


    <span class="mosaic-item-overlay mosaic-item-overlay-share">
         <span class="mosaic-item-overlay-share-container">
             <span class="mosaic-item-overlay-share-copy">
                Looking forward AS ALWAYS to seeing you all @eveleighmarket @carriageworks tomorrow! All you need is an empty basket to fill with...
              <br><br>
              <strong>kylie_kwong on Instagram</strong>
            </span>
        </span>
    </span>

</a>
                </div>
            {{/compare}}
{{#compare @index 2 operator="=="}}
                 <div class="col-xs-12 col-sm-6">
<a href="{{pagePath}}" class="mosaic-item"  title="">
    <img class='mosaic-item-image' src="{{image}}" alt="" width="100%"/>

    <span class="mosaic-item-description">
        <span class="mosaic-item-description-head type-font-feature">
            {{title}}
        </span>
        <span class="mosaic-item-description-sub">
            {{stateTag}}
        </span>
        <span class="mosaic-item-description-copy">
            {{description}}
            <br><br>
            <span class="mosaic-item-description-copy-link"><strong>Read more</strong></span>
            <strong class="mosaic-item-description-categories"><em>{{categoryTagName}}</em></strong>
        </span>
    </span>


    <span class="mosaic-item-overlay mosaic-item-overlay-info">
         <span class="mosaic-item-overlay-info-icon">
             <span class="mosaic-item-overlay-info-head type-font-feature">{{title}}<br/>shed</span>
              <span class="mosaic-item-overlay-info-icon-item">
                 <img src="{{categoryLogo}}" alt="">
             </span>
             <span class="mosaic-item-overlay-info-desciption">
			{{cityTagName}}
                 <br>
                 <br>
                  <span class="mosaic-item-description-copy-link"><strong>Find out more</strong></span>
             </span>
         </span>
          <span class="mosaic-item-overlay-info-categories">
                 <strong>{{categoryTagName}}</strong>
          </span>
    </span>

</a>
</div>
                 {{/compare}}
{{#compare @index 3 operator="=="}}
    <div class="col-xs-12 col-sm-6 ">
<a href="{{pagePath}}" title="" class="mosaic-item">
    <img class='mosaic-item-image' src="{{image}}" alt="" width="100%"/>

    <span class="mosaic-item-description">
        <span class="mosaic-item-description-head type-font-feature">{{title}}</span>
        <span class="mosaic-item-description-sub">{{stateTag}}</span>
        <span class="mosaic-item-description-copy">
            {{description}}
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
       <span class="mosaic-item-overlay mosaic-item-overlay-share">
         <span class="mosaic-item-overlay-share-container">
             <span class="mosaic-item-overlay-share-copy">
                Looking forward AS ALWAYS to seeing you all @eveleighmarket @carriageworks tomorrow! All you need is an empty basket to fill with...
              <br><br>
              <strong>kylie_kwong on Instagram</strong>
            </span>
        </span>
    </span>

</a>
                </div>
    {{/compare}}
{{#compare @index 4 operator="=="}}
                <div class="col-xs-12 col-sm-6">
<a href="{{pagePath}}" class="mosaic-item"  title="">
    <img class='mosaic-item-image' src="{{image}}" alt="" width="100%"/>

    <span class="mosaic-item-description">
        <span class="mosaic-item-description-head type-font-feature">
            {{title}}
        </span>
        <span class="mosaic-item-description-sub">
            {{stateTag}}
        </span>
        <span class="mosaic-item-description-copy">
            {{description}}
            <br><br>
            <span class="mosaic-item-description-copy-link"><strong>Read more</strong></span>
            <strong class="mosaic-item-description-categories"><em>{{categoryTagName}}</em></strong>
        </span>
    </span>


    <span class="mosaic-item-overlay mosaic-item-overlay-info">
         <span class="mosaic-item-overlay-info-icon">
             <span class="mosaic-item-overlay-info-head type-font-feature">{{title}}<br/>shed</span>
              <span class="mosaic-item-overlay-info-icon-item">
                 <img src="{{categoryLogo}}" alt="">
             </span>
             <span class="mosaic-item-overlay-info-desciption">
				{{cityTagName}}
                 <br>
                 <br>
                  <span class="mosaic-item-description-copy-link"><strong>Find out more</strong></span>
             </span>
         </span>
          <span class="mosaic-item-overlay-info-categories">
                 <strong>{{categoryTagName}}</strong>
          </span>
    </span>

</a>
                </div>
                {{/compare}}

{{/each}}
    </div>
</div> 
</div>

<div class="row l-row-collapse">
         <div class="col-xs-12 col-md-3 mosaic-ie-25">
            <div class="row">
                {{#each test}}

{{#compare @index 5 operator="=="}}  
                <div class="col-xs-12 col-sm-6 col-md-12 mosaic-ie-100">
<a href="{{pagePath}}" class="mosaic-item"  title="">
    <img class='mosaic-item-image' src="{{image}}" alt="" width="100%"/>

    <span class="mosaic-item-description">
        <span class="mosaic-item-description-head type-font-feature">
                 {{title}}
        </span>
        <span class="mosaic-item-description-sub">
            {{stateTag}}
        </span>
        <span class="mosaic-item-description-copy">
            {{description}}
            <br><br>
            <span class="mosaic-item-description-copy-link"><strong>Read more</strong></span>
            <strong class="mosaic-item-description-categories"><em>{{categoryTagName}}</em></strong>
        </span>
    </span>

    <span class="mosaic-item-overlay mosaic-item-overlay-info">
         <span class="mosaic-item-overlay-info-icon">
             <span class="mosaic-item-overlay-info-head type-font-feature">{{title}}<br/>shed</span>
              <span class="mosaic-item-overlay-info-icon-item">
                 <img src="{{categoryLogo}}" alt="">
             </span>
             <span class="mosaic-item-overlay-info-desciption">
				{{cityTagName}}
                 <br>
                 <br>
                  <span class="mosaic-item-description-copy-link"><strong>Find out more</strong></span>
             </span>
         </span>
          <span class="mosaic-item-overlay-info-categories">
                 <strong>{{categoryTagName}}</strong>
          </span>
    </span>

</a>
                </div>
                 {{/compare}}
                 {{#compare @index 6 operator="=="}} 
                <div class="col-xs-12 col-sm-6 col-md-12 mosaic-ie-100">
<a href="{{pagePath}}" title="" class="mosaic-item">
    <img class='mosaic-item-image' src="{{image}}" alt="" width="100%"/>
    <span class="mosaic-item-description">
                 <span class="mosaic-item-description-head type-font-feature">{{title}}</span>
        <span class="mosaic-item-description-sub">{{stateTag}}</span>
        <span class="mosaic-item-description-copy">
            {{description}}
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

    <span class="mosaic-item-overlay mosaic-item-overlay-share">
         <span class="mosaic-item-overlay-share-container">
             <span class="mosaic-item-overlay-share-copy">
                Looking forward AS ALWAYS to seeing you all @eveleighmarket @carriageworks tomorrow! All you need is an empty basket to fill with...
              <br><br>
              <strong>kylie_kwong on Instagram</strong>
            </span>
        </span>
    </span>

</a>
                </div>
                 {{/compare}}
                 {{/each}}
            </div>
        </div>

{{#each test}}

{{#compare @index 7 operator="=="}}  
        <div class="col-xs-12 col-md-6">
<a href="{{pagePath}}" class="mosaic-item"  title="">
    <img class='mosaic-item-image' src="{{image}}" alt="" width="100%"/>

    <span class="mosaic-item-description">
        <span class="mosaic-item-description-head type-font-feature">
                 {{title}}
        </span>
        <span class="mosaic-item-description-sub">
            {{stateTag}}
        </span>
        <span class="mosaic-item-description-copy">
            {{description}}
            <br><br>
            <span class="mosaic-item-description-copy-link"><strong>Read more</strong></span>
            <strong class="mosaic-item-description-categories"><em>{{categoryTagName}}</em></strong>
        </span>
    </span>

    <span class="mosaic-item-overlay mosaic-item-overlay-info">
         <span class="mosaic-item-overlay-info-icon">
             <span class="mosaic-item-overlay-info-head type-font-feature">{{title}}<br/>shed</span>
              <span class="mosaic-item-overlay-info-icon-item">
                 <img src="{{categoryLogo}}" alt="">
             </span>
             <span class="mosaic-item-overlay-info-desciption">
				{{cityTagName}}
                 <br>
                 <br>
                  <span class="mosaic-item-description-copy-link"><strong>Find out more</strong></span>
             </span>
         </span>
          <span class="mosaic-item-overlay-info-categories">
                 <strong>{{categoryTagName}}</strong>
          </span>
    </span>

</a>
        </div>
                 {{/compare}}
                 {{/each}}
        <div class="col-xs-12 col-md-3 mosaic-ie-25">
            <div class="row">
                 {{#each test}}

{{#compare @index 8 operator="=="}}  
                <div class="col-xs-12 col-sm-6 col-md-12 mosaic-ie-100">
<a href="{{pagePath}}" class="mosaic-item"  title="">
    <img class='mosaic-item-image' src="{{image}}" alt="" width="100%"/>

    <span class="mosaic-item-description">
        <span class="mosaic-item-description-head type-font-feature">
                 {{title}}
        </span>
        <span class="mosaic-item-description-sub">
            {{stateTag}}
        </span>
        <span class="mosaic-item-description-copy">
            {{description}}
            <br><br>
            <span class="mosaic-item-description-copy-link"><strong>Read more</strong></span>
            <strong class="mosaic-item-description-categories"><em>{{categoryTagName}}</em></strong>
        </span>
    </span>


    <span class="mosaic-item-overlay mosaic-item-overlay-info">
         <span class="mosaic-item-overlay-info-icon">
             <span class="mosaic-item-overlay-info-head type-font-feature">{{title}}<br/>shed</span>
              <span class="mosaic-item-overlay-info-icon-item">
                 <img src="{{categoryLogo}}" alt="">
             </span>
             <span class="mosaic-item-overlay-info-desciption">
				{{cityTagName}}
                 <br>
                 <br>
                  <span class="mosaic-item-description-copy-link"><strong>Find out more</strong></span>
             </span>
         </span>
          <span class="mosaic-item-overlay-info-categories">
                 <strong>{{categoryTagName}}</strong>
          </span>
    </span>

</a>
                </div>
                 {{/compare}}
{{#compare @index 9 operator="=="}}  
                <div class="col-xs-12 col-sm-6 col-md-12 mosaic-ie-100">
                 <a href="{{pagePath}}" title="" class="mosaic-item">
                 <img class='mosaic-item-image' src="{{image}}" alt="" width="100%"/>

    <span class="mosaic-item-description">
                 <span class="mosaic-item-description-head type-font-feature">{{title}}</span>
        <span class="mosaic-item-description-sub">{{stateTag}}</span>
        <span class="mosaic-item-description-copy">
            {{description}}
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

    <span class="mosaic-item-overlay mosaic-item-overlay-share">
         <span class="mosaic-item-overlay-share-container">
             <span class="mosaic-item-overlay-share-copy">
                Looking forward AS ALWAYS to seeing you all @eveleighmarket @carriageworks tomorrow! All you need is an empty basket to fill with...
              <br><br>
              <strong>kylie_kwong on Instagram</strong>
            </span>
        </span>
    </span>

</a>
                </div>
                 {{/compare}}
                 {{/each}}
            </div>
        </div>
    </div>

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
 <c:if test="${stateMosaic.templateName ne 'homepage'}">   
<div class='mosaicgridchanger'>
    <div class="mosaicgridchanger-button mosaicgridchanger-grid-button mosaicgridchanger-button-active">
        <span class="icon-font-sort_grid"></span>
    </div>
    <div class="mosaicgridchanger-button mosaicgridchanger-list-button">
        <span class="icon-font-sort_list"></span>
    </div>
</div>
   </c:if>
<div class="mosaic">
    
</div>
    <!-- END: MOSAIC -->
    <c:if test="${stateMosaic.templateName ne 'homepage'}"> 
    <p class="type-spacing-120">
        <a  class="btn-secondary btn-auto-size" >Show more Results</a>
    </p>
   </c:if> 
</div>