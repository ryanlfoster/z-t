<div class="row l-row-collapse">
{{#each test}}
    {{#compare @index 5 operator="=="}}
    <div class="row l-row-collapse">
    {{/compare}}
    {{#compare @index 4 operator="<="}}
        {{#compare @index 1 operator="<="}}
        <div class="col-xs-12 col-{{#if ../../../isGrid}}{{else}}reset-{{/if}}md-6">
        {{/compare}}
        {{#between @index 1 4}}
            {{#compare @index 1 operator="=="}}
            <div class="row">
            {{/compare}}
            <div class="col-xs-12 col-{{#if ../../../isGrid}}{{else}}reset-{{/if}}sm-6">
        {{/between}}
    {{else}}
        {{#betweenTwoRanges @index 5 5 8 8}}
                    <div class="col-xs-12 col-{{#if ../../../isGrid}}{{else}}reset-{{/if}}md-3 mosaic-ie-25">
                        <div class="row">
        {{/betweenTwoRanges}}
        {{#betweenTwoRanges @index 5 6 8 9}}
                            <div class="col-xs-12 col-md-12 mosaic-ie-100 col-sm-6">
        {{else}}
                                <div class="col-xs-12 col-{{#if ../../../isGrid}}{{else}}reset-{{/if}}md-6">
        {{/betweenTwoRanges}}
    {{/compare}}



    {{#if templateName}}
                                        <a href="{{postLink}}" title="" class="mosaic-item mosaic-item-{{../../type}} {{templateName}}"{{#if linkChecker}} target="_blank"{{/if}}>
                                            <img class='mosaic-item-image' src="{{image}}" alt="" width="100%" />
                                            {{#showOverlay templateName hasDefaultImageFlag}}
                                            {{else}}
                                                {{#if imageOverlay}}<img class='mosaic-item-image-overlay' src="{{imageOverlay}}" alt="" width="100%" />{{/if}}
				<span class="mosaic-item-overlay-share-container">
					<span class="mosaic-item-overlay-share-copy {{templateName}}"> {{messageText}} <strong>{{userName}} on {{templateName}}</strong></span>
				</span>
                                            {{/showOverlay}}
				<span class="mosaic-item-description {{#if hasDefaultImageFlag}}{{templateName}}{{/if}}">
					<span class="mosaic-item-description-head type-font-feature">{{title}}</span>
					<span class="mosaic-item-description-sub">{{stateTag}}</span>
					<span class="mosaic-item-description-copy">{{description}}<br><br>
						<span class="mosaic-item-description-copy-link"><strong>Read more</strong></span>
					</span>
					<span class="mosaic-item-description-share mosaic-item-description-share-dark"><img src="{{socialIconsBlack}}" alt="{{templateName}}"></span>
					<span class="mosaic-item-description-share mosaic-item-description-share-white"><img src="{{socialIconsWhite}}" alt="{{templateName}}" /></span>
				</span>
                                            {{#showOverlay templateName hasDefaultImageFlag}}
				<span class="mosaic-item-overlay mosaic-item-overlay-share">
					<span class="mosaic-item-overlay-share-container">
						<span class="mosaic-item-overlay-share-copy"> {{messageText}}<br><br><strong>{{userName}} on {{templateName}}</strong></span>
					</span>
				</span>
                                            {{/showOverlay}}
                                        </a>

    {{else}}
                                        <a href="{{pagePath}}" class="mosaic-item mosaic-item-{{../../type}}" title=""><img class='mosaic-item-image' src="{{image}}" alt="{{title}}" width="100%" />
				<span class="mosaic-item-description">
					<span class="mosaic-item-description-head type-font-feature">{{title}}</span>
					<span class="mosaic-item-description-sub">{{stateTag}}</span>
					<span class="mosaic-item-description-copy">{{description}}<br><br>
						<span class="mosaic-item-description-copy-link"><strong>Read more</strong></span>
						<strong class="mosaic-item-description-categories"><em>{{categoryTagName}}</em></strong>
					</span>
				</span>
				<span class="mosaic-item-overlay mosaic-item-overlay-info">
					<span class="mosaic-item-overlay-info-icon">
						<span class="mosaic-item-overlay-info-head type-font-feature">{{title}}</span>
						<span class="mosaic-item-overlay-info-icon-item"> <img src="{{categoryLogo}}" alt="{{categoryTagName}}"></span>
						<span class="mosaic-item-overlay-info-desciption">{{cityTagName}}<br><br>
							<span class="mosaic-item-description-copy-link"><strong>Find out more</strong></span>
						</span>
					</span>
					<span class="mosaic-item-overlay-info-categories"> <strong>{{categoryTagName}}</strong></span>
				</span>
                                        </a>
    {{/if}}



    </div>
    {{#betweenTwoRanges @index 4 4 6 6}}
                            </div></div>
         {{#compare @index 4 operator="=="}}
                    </div>
         {{/compare}}
    {{/betweenTwoRanges}}
    {{#compare @index 9 operator="=="}}
                </div></div>
    {{/compare}}
{{/each}}
        </div>