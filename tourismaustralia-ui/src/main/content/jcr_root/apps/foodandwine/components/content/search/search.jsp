<%@include file="/apps/foodandwine/components/global.jsp"%>

<cq:includeClientLib js="faw-search" />

<script id ="searchMosaic" type="text/x-handlebars-template">

<div class="row l-row-collapse">
{{#each searchResults}}
	{{#compare @index 0 operator="=="}}  
        <div class="col-xs-12 col-md-6">
            <a href="{{link}}" title="" class="mosaic-item">
    		<img class='mosaic-item-image' src="{{imagePath}}" alt="" width="100%"/>
    		<span class="mosaic-item-description">
        		<span class="mosaic-item-description-head type-font-feature">{{title}}</span>
        		<span class="mosaic-item-description-sub">{{state}}</span>
        		<span class="mosaic-item-description-copy">
            		{{pageDescription}}
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
     {{#each searchResults}}
{{#compare @index 1 operator="=="}} 
                <div class="col-xs-12 col-sm-6">
                    <a href="{{link}}" title="" class="mosaic-item">
    <img class='mosaic-item-image' src="{{imagePath}}" alt="" width="100%"/>

    <span class="mosaic-item-description">
        <span class="mosaic-item-description-head type-font-feature">{{tiitle}}</span>
        <span class="mosaic-item-description-sub">{{state}}</span>
        <span class="mosaic-item-description-copy">
            {{pageDescription}}
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
<a href="{{link}}" class="mosaic-item"  title="">
    <img class='mosaic-item-image' src="{{imagePath}}" alt="" width="100%"/>

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
            <strong class="mosaic-item-description-categories"><em>{{primaryCategory}}</em></strong>
        </span>
    </span>


    <span class="mosaic-item-overlay mosaic-item-overlay-info">
         <span class="mosaic-item-overlay-info-icon">
             <span class="mosaic-item-overlay-info-head type-font-feature">{{title}}<br/>shed</span>
              <span class="mosaic-item-overlay-info-icon-item">
                 <img src="{{categoryLogo}}" alt="">
             </span>
             <span class="mosaic-item-overlay-info-desciption">
			{{city}}
                 <br>
                 <br>
                  <span class="mosaic-item-description-copy-link"><strong>Find out more</strong></span>
             </span>
         </span>
          <span class="mosaic-item-overlay-info-categories">
                 <strong>{{primaryCategory}}</strong>
          </span>
    </span>

</a>
</div>
                 {{/compare}}
{{#compare @index 3 operator="=="}}
    <div class="col-xs-12 col-sm-6 ">
<a href="{{link}}" title="" class="mosaic-item">
    <img class='mosaic-item-image' src="{{image}}" alt="" width="100%"/>

    <span class="mosaic-item-description">
        <span class="mosaic-item-description-head type-font-feature">{{title}}</span>
        <span class="mosaic-item-description-sub">{{state}}</span>
        <span class="mosaic-item-description-copy">
            {{pageDescription}}
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
<a href="{{link}}" class="mosaic-item"  title="">
    <img class='mosaic-item-image' src="{{imagePath}}" alt="" width="100%"/>

    <span class="mosaic-item-description">
        <span class="mosaic-item-description-head type-font-feature">
            {{title}}
        </span>
        <span class="mosaic-item-description-sub">
            {{state}}
        </span>
        <span class="mosaic-item-description-copy">
            {{pageDescription}}
            <br><br>
            <span class="mosaic-item-description-copy-link"><strong>Read more</strong></span>
            <strong class="mosaic-item-description-categories"><em>{{primaryCategory}}</em></strong>
        </span>
    </span>


    <span class="mosaic-item-overlay mosaic-item-overlay-info">
         <span class="mosaic-item-overlay-info-icon">
             <span class="mosaic-item-overlay-info-head type-font-feature">{{title}}<br/>shed</span>
              <span class="mosaic-item-overlay-info-icon-item">
                 <img src="{{icon}}" alt="">
             </span>
             <span class="mosaic-item-overlay-info-desciption">
				{{city}}
                 <br>
                 <br>
                  <span class="mosaic-item-description-copy-link"><strong>Find out more</strong></span>
             </span>
         </span>
          <span class="mosaic-item-overlay-info-categories">
                 <strong>{{primaryCategory}}</strong>
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
               {{#each searchResults}}

{{#compare @index 5 operator="=="}}  
                <div class="col-xs-12 col-sm-6 col-md-12 mosaic-ie-100">
<a href="{{link}}" class="mosaic-item"  title="">
    <img class='mosaic-item-image' src="{{imagePath}}" alt="" width="100%"/>

    <span class="mosaic-item-description">
        <span class="mosaic-item-description-head type-font-feature">
                 {{title}}
        </span>
        <span class="mosaic-item-description-sub">
            {{state}}
        </span>
        <span class="mosaic-item-description-copy">
            {{pageDescription}}
            <br><br>
            <span class="mosaic-item-description-copy-link"><strong>Read more</strong></span>
            <strong class="mosaic-item-description-categories"><em>{{primaryCategory}}</em></strong>
        </span>
    </span>

    <span class="mosaic-item-overlay mosaic-item-overlay-info">
         <span class="mosaic-item-overlay-info-icon">
             <span class="mosaic-item-overlay-info-head type-font-feature">{{title}}<br/>shed</span>
              <span class="mosaic-item-overlay-info-icon-item">
                 <img src="{{icon}}" alt="">
             </span>
             <span class="mosaic-item-overlay-info-desciption">
				{{city}}
                 <br>
                 <br>
                  <span class="mosaic-item-description-copy-link"><strong>Find out more</strong></span>
             </span>
         </span>
          <span class="mosaic-item-overlay-info-categories">
                 <strong>{{primaryCategory}}</strong>
          </span>
    </span>

</a>
                </div>
                 {{/compare}}
                 {{#compare @index 6 operator="=="}} 
                <div class="col-xs-12 col-sm-6 col-md-12 mosaic-ie-100">
<a href="{{link}}" title="" class="mosaic-item">
    <img class='mosaic-item-image' src="{{imagePath}}" alt="" width="100%"/>
    <span class="mosaic-item-description">
                 <span class="mosaic-item-description-head type-font-feature">{{title}}</span>
        <span class="mosaic-item-description-sub">{{state}}</span>
        <span class="mosaic-item-description-copy">
            {{pageDescription}}
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
<a href="{{link}}" class="mosaic-item"  title="">
    <img class='mosaic-item-image' src="{{imagePath}}" alt="" width="100%"/>

    <span class="mosaic-item-description">
        <span class="mosaic-item-description-head type-font-feature">
                 {{title}}
        </span>
        <span class="mosaic-item-description-sub">
            {{state}}
        </span>
        <span class="mosaic-item-description-copy">
            {{pageDescription}}
            <br><br>
            <span class="mosaic-item-description-copy-link"><strong>Read more</strong></span>
            <strong class="mosaic-item-description-categories"><em>{{primaryCategory}}</em></strong>
        </span>
    </span>

    <span class="mosaic-item-overlay mosaic-item-overlay-info">
         <span class="mosaic-item-overlay-info-icon">
             <span class="mosaic-item-overlay-info-head type-font-feature">{{title}}<br/>shed</span>
              <span class="mosaic-item-overlay-info-icon-item">
                 <img src="{{icon}}" alt="">
             </span>
             <span class="mosaic-item-overlay-info-desciption">
				{{city}}
                 <br>
                 <br>
                  <span class="mosaic-item-description-copy-link"><strong>Find out more</strong></span>
             </span>
         </span>
          <span class="mosaic-item-overlay-info-categories">
                 <strong>{{primaryCategory}}</strong>
          </span>
    </span>

</a>
        </div>
                 {{/compare}}
                 {{/each}}
        <div class="col-xs-12 col-md-3 mosaic-ie-25">
            <div class="row">
                {{#each searchResults}}

{{#compare @index 8 operator="=="}}  
                <div class="col-xs-12 col-sm-6 col-md-12 mosaic-ie-100">
<a href="{{link}}" class="mosaic-item"  title="">
    <img class='mosaic-item-image' src="{{imagePath}}" alt="" width="100%"/>

    <span class="mosaic-item-description">
        <span class="mosaic-item-description-head type-font-feature">
                 {{title}}
        </span>
        <span class="mosaic-item-description-sub">
            {{state}}
        </span>
        <span class="mosaic-item-description-copy">
            {{pageDescription}}
            <br><br>
            <span class="mosaic-item-description-copy-link"><strong>Read more</strong></span>
            <strong class="mosaic-item-description-categories"><em>{{primaryCategory}}</em></strong>
        </span>
    </span>


    <span class="mosaic-item-overlay mosaic-item-overlay-info">
         <span class="mosaic-item-overlay-info-icon">
             <span class="mosaic-item-overlay-info-head type-font-feature">{{title}}<br/>shed</span>
              <span class="mosaic-item-overlay-info-icon-item">
                 <img src="{{icon}}" alt="">
             </span>
             <span class="mosaic-item-overlay-info-desciption">
				{{city}}
                 <br>
                 <br>
                  <span class="mosaic-item-description-copy-link"><strong>Find out more</strong></span>
             </span>
         </span>
          <span class="mosaic-item-overlay-info-categories">
                 <strong>{{primaryCategory}}</strong>
          </span>
    </span>

</a>
                </div>
                 {{/compare}}
{{#compare @index 9 operator="=="}}  
                <div class="col-xs-12 col-sm-6 col-md-12 mosaic-ie-100">
                 <a href="{{link}}" title="" class="mosaic-item">
                 <img class='mosaic-item-image' src="{{imagePath}}" alt="" width="100%"/>

    <span class="mosaic-item-description">
                 <span class="mosaic-item-description-head type-font-feature">{{title}}</span>
        <span class="mosaic-item-description-sub">{{state}}</span>
        <span class="mosaic-item-description-copy">
            {{pageDescription}}
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


<div class="faw-hero-home-container">
	
	<h3 class="form-h3 l-padding-top-xs-2 l-padding-bottom-xs-0-5">
		
	</h3>
	
	<input
		class="input-field-blank input-field-big input-field-normal-left-border"
		placeholder="E.g. Cafe Sydney"> <a href="#"
		class="btn-secondary btn-auto-size" >Search</a>
</div>

 
 <!-- <div class="faw-search-tag-cloud">
	<p class="faw-search-tag-cloud-headline">Other people were
		intrested in searching for:</p>
	<ul>
		<li><a href="" target="_self">Alpine</a></li>
		<li><a href="" target="_self">Roasted</a></li>
		<li><a href="" target="_self">Outdoors</a></li>
		<li><a href="" target="_self">Produce</a></li>
	</ul>
</div>  -->

<div class="faw-category-mosaic">
	<!-- FOOD MOSAIC GRID CHANGER -->

	<div class="mosaicgridchanger">

		<!-- CATEGORY DROP DOWNS -->
		<div class="faw-category-mosaic-drop-downs">

			<!-- CATEGORY DROP DOWN -->
			<div class="faw-category-mosaic-drop-down">
				<select class="input-select input-select-small" id="categoryDropdown">
					<option value="" selected="selected" disabled="">Filter by
						category</option>
					<option value="restaurants">Restaurants</option>
					<option value="wine">Wine</option>
					<option value="produce">Produce</option>
					<option value="events">Events</option>
					<option value="people">People</option>
					<option value="experiences">Experiences</option>
					<option value="seafood">Seafood</option>
				</select>
			</div>
			<!-- END: CATEGORY DROP DOWN -->

			<!-- STATE DROP DOWN -->
			<div class="faw-category-mosaic-drop-down" id="stateDropdown">
				<select class="input-select input-select-small">
					<option value="" selected="selected" disabled="">Filter by
						location</option>
					<option value="australia-capital-teritory">ACT</option>
					<option value="new-south-wales">NSW</option>
					<option value="northern-terriotory">NT</option>
					<option value="queensland">QLD</option>
					<option value="south-australia">SA</option>
					<option value="tasmania">TAS</option>
					<option value="victoria">VIC</option>
					<option value="western-australia">WA</option>
				</select>
			</div>
			<!-- END: STATE DROP DOWN -->
		</div>
		<!-- END: CATEGORY DROP DOWNS -->

		<!-- GRID CHANGER BUTTONS -->
		<div
			class="mosaicgridchanger-button mosaicgridchanger-grid-button mosaicgridchanger-button-active">
			<span class="icon-font-sort_grid"></span>
		</div>
		<div class="mosaicgridchanger-button mosaicgridchanger-list-button">
			<span class="icon-font-sort_list"></span>
		</div>
		<!-- END: GRID CHANGER BUTTONS -->
	</div>
	<div class="mosaic">
    </div>
   
    <p class="type-spacing-120"  >
        <a class="btn-secondary btn-auto-size" >Show more Results</a>
    </p>
    
	</div>
