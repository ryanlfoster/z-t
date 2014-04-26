<%@include file="/apps/foodandwine/components/global.jsp"%>
<%@ page
	import="com.australia.foodandwine.components.content.search.Search"%>

<c:set var="search" value="<%=new Search(slingRequest) %>" />
<cq:includeClientLib js="faw-search" />

<script id ="searchMosaic" type="text/x-handlebars-template">

<div class="row l-row-collapse">
{{#each searchResults}}
	{{#compare @index 0 operator="=="}}  
{{#if templateName}}
        <div class="col-xs-12 col-md-6">
{{#if linkChecker}}
<a href="{{postLink}}" title="" class="mosaic-item">
{{else}}
	<a href="{{postLink}}" title="" class="mosaic-item" target="_blank">
{{/if}}            

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
            	<img src="{{socialIconsWhite}}" alt=""/>
        	</span>
   			</span>
    		<span class="mosaic-item-overlay mosaic-item-overlay-share">
         		<span class="mosaic-item-overlay-share-container">
             		<span class="mosaic-item-overlay-share-copy">
                		{{messagePosts}}
              			<br><br>
              			<strong>{{userName}} on {{templateName}}</strong>
            		</span>
        		</span>
    		</span>
           </a>
       </div>
{{else}}
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
             <span class="mosaic-item-overlay-info-head type-font-feature">{{title}}</span>
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
{{/if}}
	{{/compare}}
 {{/each}}

<div class="col-xs-12 col-md-6">
 <div class="row">
     {{#each searchResults}}
{{#compare @index 1 operator="=="}} 
{{#if templateName}}
                <div class="col-xs-12 col-sm-6">
                    {{#if linkChecker}}
<a href="{{postLink}}" title="" class="mosaic-item">
{{else}}
	<a href="{{postLink}}" title="" class="mosaic-item" target="_blank">
{{/if}} 
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
            <img src="{{socialIconsBlack}}" alt="">
        </span>
        <span class="mosaic-item-description-share mosaic-item-description-share-white">
            <img src="{{socialIconsWhite}}" alt=""/>
        </span>
    </span>


    <span class="mosaic-item-overlay mosaic-item-overlay-share">
         <span class="mosaic-item-overlay-share-container">
             <span class="mosaic-item-overlay-share-copy">
                		{{messagePosts}}
              			<br><br>
              			<strong>{{userName}} on {{templateName}}</strong>
            		</span>
        </span>
    </span>

</a>
                </div>
{{else}}
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
             <span class="mosaic-item-overlay-info-head type-font-feature">{{title}}</span>
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
{{/if}}
            {{/compare}}
{{#compare @index 2 operator="=="}}
{{#if templateName}}
  <div class="col-xs-12 col-sm-6">
                   {{#if linkChecker}}
<a href="{{postLink}}" title="" class="mosaic-item">
{{else}}
	<a href="{{postLink}}" title="" class="mosaic-item" target="_blank">
{{/if}} 
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
            <img src="{{socialIconsBlack}}" alt="">
        </span>
        <span class="mosaic-item-description-share mosaic-item-description-share-white">
            <img src="{{socialIconsWhite}}" alt=""/>
        </span>
    </span>


    <span class="mosaic-item-overlay mosaic-item-overlay-share">
         <span class="mosaic-item-overlay-share-container">
             <span class="mosaic-item-overlay-share-copy">
                		{{messagePosts}}
              			<br><br>
              			<strong>{{userName}} on {{templateName}}</strong>
            		</span>
        </span>
    </span>

</a>
                </div>
{{else}}
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
             <span class="mosaic-item-overlay-info-head type-font-feature">{{title}}</span>
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
{{/if}}
                 {{/compare}}
{{#compare @index 3 operator="=="}}
{{#if templateName}}
    <div class="col-xs-12 col-sm-6 ">

{{#if linkChecker}}
<a href="{{postLink}}" title="" class="mosaic-item">
{{else}}
	<a href="{{postLink}}" title="" class="mosaic-item" target="_blank">
{{/if}} 
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
            <img src="{{socialIconsBlack}}" alt="">
        </span>
        <span class="mosaic-item-description-share mosaic-item-description-share-white">
            <img src="{{socialIconsWhite}}" alt=""/>
        </span>
    </span>
       <span class="mosaic-item-overlay mosaic-item-overlay-share">
         <span class="mosaic-item-overlay-share-container">
             <span class="mosaic-item-overlay-share-copy">
                		{{messagePosts}}
              			<br><br>
              			<strong>{{userName}} on {{templateName}}</strong>
            		</span>
        </span>
    </span>

</a>
                </div>
{{else}}
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
             <span class="mosaic-item-overlay-info-head type-font-feature">{{title}}</span>
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
{{/if}}
    {{/compare}}
{{#compare @index 4 operator="=="}}
{{#if templateName}}
  <div class="col-xs-12 col-sm-6">
                   {{#if linkChecker}}
<a href="{{postLink}}" title="" class="mosaic-item">
{{else}}
	<a href="{{postLink}}" title="" class="mosaic-item" target="_blank">
{{/if}} 
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
            <img src="{{socialIconsBlack}}" alt="">
        </span>
        <span class="mosaic-item-description-share mosaic-item-description-share-white">
            <img src="{{socialIconsWhite}}" alt=""/>
        </span>
    </span>


    <span class="mosaic-item-overlay mosaic-item-overlay-share">
         <span class="mosaic-item-overlay-share-container">
             <span class="mosaic-item-overlay-share-copy">
                		{{messagePosts}}
              			<br><br>
              			<strong>{{userName}} on {{templateName}}</strong>
            		</span>
        </span>
    </span>

</a>
                </div>

{{else}}
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
             <span class="mosaic-item-overlay-info-head type-font-feature">{{title}}</span>
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
{{/if}}

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
{{#if templateName}}
  <div class="col-xs-12 col-sm-6 col-md-12 mosaic-ie-100">
{{#if linkChecker}}
<a href="{{postLink}}" title="" class="mosaic-item">
{{else}}
	<a href="{{postLink}}" title="" class="mosaic-item" target="_blank">
{{/if}} 
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
            <img src="{{socialIconsBlack}}" alt="">
        </span>
        <span class="mosaic-item-description-share mosaic-item-description-share-white">
            <img src="{{socialIconsWhite}}" alt=""/>
        </span>
    </span>

    <span class="mosaic-item-overlay mosaic-item-overlay-share">
         <span class="mosaic-item-overlay-share-container">
             <span class="mosaic-item-overlay-share-copy">
                		{{messagePosts}}
              			<br><br>
              			<strong>{{userName}} on {{templateName}}</strong>
            		</span>
        </span>
    </span>

</a>
                </div>
{{else}}
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
             <span class="mosaic-item-overlay-info-head type-font-feature">{{title}}</span>
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
{{/if}}
                 {{/compare}}
                 {{#compare @index 6 operator="=="}} 
{{#if templateName}}
                <div class="col-xs-12 col-sm-6 col-md-12 mosaic-ie-100">
{{#if linkChecker}}
<a href="{{postLink}}" title="" class="mosaic-item">
{{else}}
	<a href="{{postLink}}" title="" class="mosaic-item" target="_blank">
{{/if}} 
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
            <img src="{{socialIconsBlack}}" alt="">
        </span>
        <span class="mosaic-item-description-share mosaic-item-description-share-white">
            <img src="{{socialIconsWhite}}" alt=""/>
        </span>
    </span>

    <span class="mosaic-item-overlay mosaic-item-overlay-share">
         <span class="mosaic-item-overlay-share-container">
             <<span class="mosaic-item-overlay-share-copy">
                		{{messagePosts}}
              			<br><br>
              			<strong>{{userName}} on {{templateName}}</strong>
            		</span>
        </span>
    </span>

</a>
                </div>
{{else}}

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
             <span class="mosaic-item-overlay-info-head type-font-feature">{{title}}</span>
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
{{/if}}
                 {{/compare}}
                 {{/each}}
            </div>
        </div>

{{#each searchResults}}

{{#compare @index 7 operator="=="}}  
        <div class="col-xs-12 col-md-6">
{{#if templateName}}
	<div class="col-xs-12 col-md-6">
           {{#if linkChecker}}
<a href="{{postLink}}" title="" class="mosaic-item">
{{else}}
	<a href="{{postLink}}" title="" class="mosaic-item" target="_blank">
{{/if}} 
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
            	<img src="{{socialIconsBlack}}" alt="">
        	</span>
        	<span class="mosaic-item-description-share mosaic-item-description-share-white">
            	<img src="{{socialIconsWhite}}" alt=""/>
        	</span>
   			</span>
    		<span class="mosaic-item-overlay mosaic-item-overlay-share">
         		<span class="mosaic-item-overlay-share-container">
             		<span class="mosaic-item-overlay-share-copy">
                		{{messagePosts}}
              			<br><br>
              			<strong>{{userName}} on {{templateName}}</strong>
            		</span>
        		</span>
    		</span>
           </a>
       </div>
{{else}}
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
             <span class="mosaic-item-overlay-info-head type-font-feature">{{title}}</span>
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
{{/if}}
                 {{/compare}}
                 {{/each}}
        <div class="col-xs-12 col-md-3 mosaic-ie-25">
            <div class="row">
                {{#each searchResults}}

{{#compare @index 8 operator="=="}}  
{{#if templateName}}
	 <div class="col-xs-12 col-sm-6 col-md-12 mosaic-ie-100">
{{#if linkChecker}}
<a href="{{postLink}}" title="" class="mosaic-item">
{{else}}
	<a href="{{postLink}}" title="" class="mosaic-item" target="_blank">
{{/if}} 
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
            <img src="{{socialIconsBlack}}" alt="">
        </span>
        <span class="mosaic-item-description-share mosaic-item-description-share-white">
            <img src="{{socialIconsWhite}}" alt=""/>
        </span>
    </span>

    <span class="mosaic-item-overlay mosaic-item-overlay-share">
         <span class="mosaic-item-overlay-share-container">
             <span class="mosaic-item-overlay-share-copy">
                		{{messagePosts}}
              			<br><br>
              			<strong>{{userName}} on {{templateName}}</strong>
            		</span>
        </span>
    </span>

</a>
                </div>
{{else}}
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
             <span class="mosaic-item-overlay-info-head type-font-feature">{{title}}</span>
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
{{/if}}
                 {{/compare}}
{{#compare @index 9 operator="=="}}  
{{#if templateName}}
                <div class="col-xs-12 col-sm-6 col-md-12 mosaic-ie-100">
                 {{#if linkChecker}}
<a href="{{postLink}}" title="" class="mosaic-item">
{{else}}
	<a href="{{postLink}}" title="" class="mosaic-item" target="_blank">
{{/if}} 
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
            <img src="{{socialIconsBlack}}" alt="">
        </span>
        <span class="mosaic-item-description-share mosaic-item-description-share-white">
            <img src="{{socialIconsWhite}}" alt=""/>
        </span>
    </span>

    <span class="mosaic-item-overlay mosaic-item-overlay-share">
         <span class="mosaic-item-overlay-share-container">
             <span class="mosaic-item-overlay-share-copy">
                		{{messagePosts}}
              			<br><br>
              			<strong>{{userName}} on {{templateName}}</strong>
            		</span>
        </span>
    </span>

</a>
                </div>
{{else}}
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
             <span class="mosaic-item-overlay-info-head type-font-feature">{{title}}</span>
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
{{/if}}
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

 
 <div class="faw-search-tag-cloud">
	<p class="faw-search-tag-cloud-headline">${search.headLine}</p>
	<ul>
		<c:forEach items="${search.interestedSearchList}" var="item">
		<li><a href="${item.searchPagePath}" target="_self">${item.searchPageTitle}</a></li>
		</c:forEach>
	</ul>
</div> 

<div class="faw-category-mosaic">
	<!-- FOOD MOSAIC GRID CHANGER -->

	<div class="mosaicgridchanger">

		<!-- CATEGORY DROP DOWNS -->
		<div class="faw-category-mosaic-drop-downs">

			<!-- CATEGORY DROP DOWN -->
			<div class="faw-category-mosaic-drop-down">
				<select class="input-select input-select-small" id="categoryDropdown">
					<option value="" selected="selected" >Filter by
						category</option>
					<option value="ta:food-and-wine/category/restaurant">Restaurants</option>
					<option value="ta:food-and-wine/category/wine">Wine</option>
					<option value="ta:food-and-wine/category/produce">Produce</option>
					<option value="ta:food-and-wine/category/events">Events</option>
					<option value="ta:food-and-wine/category/people">People</option>
					<option value="ta:food-and-wine/category/experiences">Experiences</option>
					<option value="ta:food-and-wine/category/seafood">Seafood</option>
				</select>
			</div>
			<!-- END: CATEGORY DROP DOWN -->

			<!-- STATE DROP DOWN -->
			<div class="faw-category-mosaic-drop-down" id="stateDropdown">
				<select class="input-select input-select-small">
					<option value="" selected="selected" >Filter by
						location</option>
					<option value="ta:place/australia-capital-teritory">ACT</option>
					<option value="ta:place/new-south-wales">NSW</option>
					<option value="ta:place/northern-terriotory">NT</option>
					<option value="ta:place/queensland">QLD</option>
					<option value="ta:place/south-australia">SA</option>
					<option value="ta:place/tasmania">TAS</option>
					<option value="ta:place/victoria">VIC</option>
					<option value="ta:place/western-australia">WA</option>
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
