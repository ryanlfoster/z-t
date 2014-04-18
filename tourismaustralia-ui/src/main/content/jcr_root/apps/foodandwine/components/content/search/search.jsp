<%@include file="/apps/foodandwine/components/global.jsp"%>
<%@ page
	import="com.australia.foodandwine.components.content.search.Search"%>

<c:set var="search" value="<%=new Search(slingRequest) %>" />

<cq:includeClientLib js="faw-search" />

<div class="faw-hero-home-container"
	data-searchurl="${search.searchPath}">
	<c:if test="${search.totalSearchResultsCount > 0}">
	<h3 class="form-h3 l-padding-top-xs-2 l-padding-bottom-xs-0-5">${search.totalSearchResultsCount}
		Search results for: <strong></strong>
	</h3>
	</c:if>
	<input
		class="input-field-blank input-field-big input-field-normal-left-border"
		placeholder="E.g. Cafe Sydney"> <a href="#"
		class="btn-secondary btn-auto-size">Search</a>
</div>
<div class="faw-search-tag-cloud">
	<p class="faw-search-tag-cloud-headline">Other people were
		intrested in searching for:</p>
	<ul>
		<li><a href="" target="_self">Alpine</a></li>
		<li><a href="" target="_self">Roasted</a></li>
		<li><a href="" target="_self">Outdoors</a></li>
		<li><a href="" target="_self">Produce</a></li>
	</ul>
</div>

<div class="faw-category-mosaic">
	<!-- FOOD MOSAIC GRID CHANGER -->

	<div class="mosaicgridchanger">

		<!-- CATEGORY DROP DOWNS -->
		<div class="faw-category-mosaic-drop-downs">

			<!-- CATEGORY DROP DOWN -->
			<div class="faw-category-mosaic-drop-down">
				<select class="input-select input-select-small">
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
			<div class="faw-category-mosaic-drop-down">
				<select class="input-select input-select-small">
					<option value="" selected="selected" disabled="">Filter by
						location</option>
					<option value="southernaustralia">Capital</option>
					<option value="victoria">NSW</option>
					<option value="northern">Northern</option>
					<option value="queensland">Queensland</option>
					<option value="south">South</option>
					<option value="tasmania">Tasmania</option>
					<option value="victoria">Victoria</option>
					<option value="western">Western</option>
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
		<div class="row l-row-collapse">

<c:forEach var="exp" items="${search.searchResult.experiences}" varStatus="loop">
    <c:if test="${loop.index eq 0}">
        <div class="col-xs-12 col-md-6">
            <a href="${exp.link}" title="" class="mosaic-item">
    		<img class='mosaic-item-image' src="${exp.imagePath}" alt="" width="100%"/>
    		<span class="mosaic-item-description">
        		<span class="mosaic-item-description-head type-font-feature">${exp.title}</span>
        		<span class="mosaic-item-description-sub">${exp.state}</span>
        		<span class="mosaic-item-description-copy">
						${exp.pageDescription}
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
    </c:if>

            </c:forEach>
<div class="col-xs-12 col-md-6">
 <div class="row">
<c:forEach var="exp" items="${search.searchResult.experiences}" varStatus="loop">
<c:if test="${loop.index eq 1}">
                <div class="col-xs-12 col-sm-6">
                    <a href="${exp.link}" title="" class="mosaic-item">
    <img class='mosaic-item-image' src="${exp.imagePath}" width="100%"/>

    <span class="mosaic-item-description">
        <span class="mosaic-item-description-head type-font-feature">${exp.title}</span>
        <span class="mosaic-item-description-sub">${exp.state}</span>
        <span class="mosaic-item-description-copy">
			${exp.pageDescription}
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
    </c:if>
<c:if test="${loop.index eq 2}">
                 <div class="col-xs-12 col-sm-6">
                     <a href="${exp.link}" class="mosaic-item"  title="">
    <img class='mosaic-item-image' src="${exp.imagePath}" alt="" width="100%"/>

    <span class="mosaic-item-description">
        <span class="mosaic-item-description-head type-font-feature">
            ${exp.title}
        </span>
        <span class="mosaic-item-description-sub">
            ${exp.state}
        </span>
        <span class="mosaic-item-description-copy">
            ${exp.pageDescription}
            <br><br>
            <span class="mosaic-item-description-copy-link"><strong>Read more</strong></span>
            <strong class="mosaic-item-description-categories"><em>${exp.primaryCategory}</em></strong>
        </span>
    </span>


    <span class="mosaic-item-overlay mosaic-item-overlay-info">
         <span class="mosaic-item-overlay-info-icon">
             <span class="mosaic-item-overlay-info-head type-font-feature">The burger<br/>shed</span>
              <span class="mosaic-item-overlay-info-icon-item">
                 <img src="imgs/base/categories/category-icon-wine-white.png" alt="">
             </span>
             <span class="mosaic-item-overlay-info-desciption">
                 ${exp.city}
                 <br>
                 <br>
                  <span class="mosaic-item-description-copy-link"><strong>Find out more</strong></span>
             </span>
         </span>
          <span class="mosaic-item-overlay-info-categories">
                 <strong>${exp.primaryCategory}</strong>
          </span>
    </span>

</a>
</div>
    </c:if>
    <c:if test="${loop.index eq 3}">

    <div class="col-xs-12 col-sm-6 ">
        <a href="${exp.link}" title="" class="mosaic-item">
            <img class='mosaic-item-image' src="${exp.imagePath}" alt="" width="100%"/>

    <span class="mosaic-item-description">
        <span class="mosaic-item-description-head type-font-feature">${exp.title}</span>
        <span class="mosaic-item-description-sub">${exp.state}</span>
        <span class="mosaic-item-description-copy">
            ${exp.pageDescription}
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
    </c:if>
<c:if test="${loop.index eq 4}">
                <div class="col-xs-12 col-sm-6">
                    <a href="${exp.link}" class="mosaic-item"  title="">
                        <img class='mosaic-item-image' src="${exp.imagePath}" alt="" width="100%"/>

    <span class="mosaic-item-description">
        <span class="mosaic-item-description-head type-font-feature">
            ${exp.title}
        </span>
        <span class="mosaic-item-description-sub">
            ${exp.state}
        </span>
        <span class="mosaic-item-description-copy">
            ${exp.pageDescription}
            <br><br>
            <span class="mosaic-item-description-copy-link"><strong>Read more</strong></span>
            <strong class="mosaic-item-description-categories"><em>${exp.primaryCategory}</em></strong>
        </span>
    </span>


    <span class="mosaic-item-overlay mosaic-item-overlay-info">
         <span class="mosaic-item-overlay-info-icon">
             <span class="mosaic-item-overlay-info-head type-font-feature">The burger<br/>shed</span>
              <span class="mosaic-item-overlay-info-icon-item">
                 <img src="imgs/base/categories/category-icon-wine-white.png" alt="">
             </span>
             <span class="mosaic-item-overlay-info-desciption">
				${exp.city}
                 <br>
                 <br>
                  <span class="mosaic-item-description-copy-link"><strong>Find out more</strong></span>
             </span>
         </span>
          <span class="mosaic-item-overlay-info-categories">
              <strong>${exp.primaryCategory}</strong>
          </span>
    </span>

</a>
                </div>
    </c:if>

     </c:forEach>
    </div>
</div> 
</div>

<div class="row l-row-collapse">
         <div class="col-xs-12 col-md-3 mosaic-ie-25">
            <div class="row">
<c:forEach var="exp" items="${search.searchResult.experiences}" varStatus="loop">
<c:if test="${loop.index eq 5}">

                <div class="col-xs-12 col-sm-6 col-md-12 mosaic-ie-100">
<a href="${exp.link}" class="mosaic-item"  title="">
    <img class='mosaic-item-image' src="${exp.imagePath}" alt="" width="100%"/>

    <span class="mosaic-item-description">
        <span class="mosaic-item-description-head type-font-feature">
            ${exp.title}
        </span>
        <span class="mosaic-item-description-sub">
            ${exp.state}
        </span>
        <span class="mosaic-item-description-copy">
            ${exp.pageDescription}
            <br><br>
            <span class="mosaic-item-description-copy-link"><strong>Read more</strong></span>
            <strong class="mosaic-item-description-categories"><em>Restaurant, Places, People</em></strong>
        </span>
    </span>

    <span class="mosaic-item-overlay mosaic-item-overlay-info">
         <span class="mosaic-item-overlay-info-icon">
             <span class="mosaic-item-overlay-info-head type-font-feature">The burger<br/>shed</span>
              <span class="mosaic-item-overlay-info-icon-item">
                 <img src="imgs/base/categories/category-icon-wine-white.png" alt="">
             </span>
             <span class="mosaic-item-overlay-info-desciption">
				${exp.city}
                 <br>
                 <br>
                  <span class="mosaic-item-description-copy-link"><strong>Find out more</strong></span>
             </span>
         </span>
          <span class="mosaic-item-overlay-info-categories">
                 <strong>${exp.primaryCategory}</strong>
          </span>
    </span>

</a>
                </div>
    </c:if>
    <c:if test="${loop.index eq 6}" >
                <div class="col-xs-12 col-sm-6 col-md-12 mosaic-ie-100">
<a href="${exp.link}" title="" class="mosaic-item">
    <img class='mosaic-item-image' src="${exp.imagePath}" alt="" width="100%"/>
    <span class="mosaic-item-description">
                 <span class="mosaic-item-description-head type-font-feature">${exp.title}</span>
        <span class="mosaic-item-description-sub">${exp.state}</span>
        <span class="mosaic-item-description-copy">
            ${exp.pageDescription}
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
    </c:if>
                </c:forEach>
            </div>
        </div>

<c:forEach var="exp" items="${search.searchResult.experiences}" varStatus="loop">
<c:if test="${loop.index eq 7}">
        <div class="col-xs-12 col-md-6">
            <a href="${exp.link}" class="mosaic-item"  title="">
    <img class='mosaic-item-image' src="${exp.imagePath}" alt="" width="100%"/>

    <span class="mosaic-item-description">
        <span class="mosaic-item-description-head type-font-feature">
                 ${exp.title}
        </span>
        <span class="mosaic-item-description-sub">
            ${exp.state}
        </span>
        <span class="mosaic-item-description-copy">
            ${exp.pageDescription}
            <br><br>
            <span class="mosaic-item-description-copy-link"><strong>Read more</strong></span>
            <strong class="mosaic-item-description-categories"><em>${exp.primaryCategory}</em></strong>
        </span>
    </span>

    <span class="mosaic-item-overlay mosaic-item-overlay-info">
         <span class="mosaic-item-overlay-info-icon">
             <span class="mosaic-item-overlay-info-head type-font-feature">The burger<br/>shed</span>
              <span class="mosaic-item-overlay-info-icon-item">
                 <img src="imgs/base/categories/category-icon-wine-white.png" alt="">
             </span>
             <span class="mosaic-item-overlay-info-desciption">
				${exp.city}
                 <br>
                 <br>
                  <span class="mosaic-item-description-copy-link"><strong>Find out more</strong></span>
             </span>
         </span>
          <span class="mosaic-item-overlay-info-categories">
                 <strong>${exp.primaryCategory}</strong>
          </span>
    </span>

</a>
        </div>
    </c:if>
    </c:forEach>
        <div class="col-xs-12 col-md-3 mosaic-ie-25">
            <div class="row">
                <c:forEach var="exp" items="${search.searchResult.experiences}" varStatus="loop">
<c:if test="${loop.index eq 8}">

                <div class="col-xs-12 col-sm-6 col-md-12 mosaic-ie-100">
<a href="${exp.link}" class="mosaic-item"  title="">
    <img class='mosaic-item-image' src="${exp.imagePath}" alt="" width="100%"/>

    <span class="mosaic-item-description">
        <span class="mosaic-item-description-head type-font-feature">
                 ${exp.title}
        </span>
        <span class="mosaic-item-description-sub">
            ${exp.state}
        </span>
        <span class="mosaic-item-description-copy">
            ${exp.pageDescription}
            <br><br>
            <span class="mosaic-item-description-copy-link"><strong>Read more</strong></span>
            <strong class="mosaic-item-description-categories"><em>${exp.primaryCategory}</em></strong>
        </span>
    </span>


    <span class="mosaic-item-overlay mosaic-item-overlay-info">
         <span class="mosaic-item-overlay-info-icon">
             <span class="mosaic-item-overlay-info-head type-font-feature">{{title}}<br/>shed</span>
              <span class="mosaic-item-overlay-info-icon-item">
                 <img src="imgs/base/categories/category-icon-wine-white.png" alt="">
             </span>
             <span class="mosaic-item-overlay-info-desciption">
				${exp.city}
                 <br>
                 <br>
                  <span class="mosaic-item-description-copy-link"><strong>Find out more</strong></span>
             </span>
         </span>
          <span class="mosaic-item-overlay-info-categories">
                 <strong>${exp.primaryCategory}</strong>
          </span>
    </span>

</a>
                </div>
                    </c:if>
<c:if test="${loop.index eq 9}">
                <div class="col-xs-12 col-sm-6 col-md-12 mosaic-ie-100">
                 <a href="${exp.link}" title="" class="mosaic-item">
                 <img class='mosaic-item-image' src="${exp.imagePath}" alt="" width="100%"/>

    <span class="mosaic-item-description">
                 <span class="mosaic-item-description-head type-font-feature">${exp.title}</span>
        <span class="mosaic-item-description-sub">${exp.state}</span>
        <span class="mosaic-item-description-copy">
            ${exp.pageDescription}
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
                    </c:if>
                </c:forEach>
            </div>
        </div>
    </div>

    </div>
    <p class="type-spacing-120">
        <a  class="btn-secondary btn-auto-size" >Show more Results</a>
    </p>
	</div>




<%-- <%@include file="/apps/foodandwine/components/global.jsp"%>
<%@ page
	import="com.australia.foodandwine.components.content.search.Search"%>

<c:set var="search" value="<%=new Search(slingRequest) %>" />

<cq:includeClientLib js="faw-search" />



<div class="faw-hero-home-container"
	data-searchurl="${search.searchPath}">
	<c:if test="${search.totalSearchResultsCount > 0}">
	<h3 class="form-h3 l-padding-top-xs-2 l-padding-bottom-xs-0-5">${search.totalSearchResultsCount}
		Search results for: <strong></strong>
	</h3>
	</c:if>
	<input
		class="input-field-blank input-field-big input-field-normal-left-border"
		placeholder="E.g. Cafe Sydney"> <a href="#"
		class="btn-secondary btn-auto-size">Search</a>
</div>
<div class="faw-search-tag-cloud">
	<p class="faw-search-tag-cloud-headline">Other people were
		intrested in searching for:</p>
	<ul>
		<li><a href="" target="_self">Alpine</a></li>
		<li><a href="" target="_self">Roasted</a></li>
		<li><a href="" target="_self">Outdoors</a></li>
		<li><a href="" target="_self">Produce</a></li>
	</ul>
</div>

<div class="faw-category-mosaic">
	<!-- FOOD MOSAIC GRID CHANGER -->

	<div class="mosaicgridchanger">

		<!-- CATEGORY DROP DOWNS -->
		<div class="faw-category-mosaic-drop-downs">

			<!-- CATEGORY DROP DOWN -->
			<div class="faw-category-mosaic-drop-down">
				<select class="input-select input-select-small">
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
			<div class="faw-category-mosaic-drop-down">
				<select class="input-select input-select-small">
					<option value="" selected="selected" disabled="">Filter by
						location</option>
					<option value="southernaustralia">Capital</option>
					<option value="victoria">NSW</option>
					<option value="northern">Northern</option>
					<option value="queensland">Queensland</option>
					<option value="south">South</option>
					<option value="tasmania">Tasmania</option>
					<option value="victoria">Victoria</option>
					<option value="western">Western</option>
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
		<div class="row l-row-collapse">
			<div class="col-xs-12 col-md-6">
				<c:forEach var="exp" items="${search.searchResult.experiences}">
					<a href="${exp.link}" title="${exp.title }"
						class="mosaic-item mosaic-item-grid"> <img
						class="mosaic-item-image" src="${exp.imagePath}" alt=""
						width="100%"> <!-- Parent view --> <span
						class="mosaic-item-description"> <span
							class="mosaic-item-description-head type-font-feature">${exp.city}
								&amp; ${exp.primaryCategory}</span> <span
							class="mosaic-item-description-sub">${exp.state}</span> <span
							class="mosaic-item-description-copy">
								${exp.pageDescription} <br>
							<br> <span class="mosaic-item-description-copy-link"><strong>Read
										more</strong></span>
						</span> <span
							class="mosaic-item-description-share mosaic-item-description-share-dark">
								<img src="imgs/base/share/share-instagram-black.png" alt="">
						</span> <span
							class="mosaic-item-description-share mosaic-item-description-share-white">
								<img src="imgs/base/share/share-instagram-white.png" alt="">
						</span>
					</span> <!-- End Parent view --> <!-- Overlay --> <span
						class="mosaic-item-overlay mosaic-item-overlay-share"> <span
							class="mosaic-item-overlay-share-container"> <span
								class="mosaic-item-overlay-share-copy">
									${exp.pageDescription} 
								<br> <strong></strong>
							</span>
						</span>
					</span> <!-- End Overlay -->
					</a>
				</c:forEach>


			</div>
			<div class="col-xs-12 col-md-6">

				<div class="row">
					<div class="col-xs-12 col-sm-6"></div>
				</div>

			</div>
			
		</div> 
	</div>
	 --%>
	 
	 
	 
	 
	 
	 