<div class="row l-row-collapse">
	{{#each test}} {{#compare @index 0 operator="=="}} {{#if templateName}}
	<div class="col-xs-12 {{#if ../../../isGrid}}col-md-6{{else}}col-reset-md-6{{/if}} 1">
		{{#if linkChecker}} <a href="{{postLink}}" title=""
			class="mosaic-item mosaic-item-{{../../../../type}}"> {{else}} <a
			href="{{postLink}}" title="" class="mosaic-item mosaic-item-{{../../../../type}}"
			target="_blank"> {{/if}} <img class='mosaic-item-image'
				src="{{image}}" alt="" width="100%" /> <span
				class="mosaic-item-description {{templateName}}"> <span
					class="mosaic-item-description-head type-font-feature">{{title}}</span>
					<span class="mosaic-item-description-sub">{{stateTag}}</span> <span
					class="mosaic-item-description-copy"> {{description}} <br>
					<br> <span class="mosaic-item-description-copy-link"><strong>Read
								more</strong></span>
				</span> <span
					class="mosaic-item-description-share mosaic-item-description-share-dark">
						<img src="{{socialIconsBlack}}" alt="">
				</span> <span
					class="mosaic-item-description-share mosaic-item-description-share-white">
						<img src="{{socialIconsWhite}}" alt="" />
				</span>
			</span> <span class="mosaic-item-overlay mosaic-item-overlay-share">
					<span class="mosaic-item-overlay-share-container"> <span
						class="mosaic-item-overlay-share-copy"> {{messageText}} <br>
						<br> <strong>{{userName}} on {{templateName}}</strong>
					</span>
				</span>
			</span>
		</a>
	</div>
	{{else}}
	<div class="col-xs-12 {{#if ../../../isGrid}}col-md-6{{else}}col-reset-md-6{{/if}} 2">
		<a href="{{pagePath}}" class="mosaic-item mosaic-item-{{../../../type}}"
			title=""> <img class='mosaic-item-image' src="{{image}}" alt=""
			width="100%" /> <span class="mosaic-item-description {{templateName}}"> <span
				class="mosaic-item-description-head type-font-feature">
					{{title}} </span> <span class="mosaic-item-description-sub">
					{{stateTag}} </span> <span class="mosaic-item-description-copy">
					{{description}} <br>
				<br> <span class="mosaic-item-description-copy-link"><strong>Read
							more</strong></span> <strong class="mosaic-item-description-categories"><em>{{categoryTagName}}</em></strong>
			</span>
		</span> <span class="mosaic-item-overlay mosaic-item-overlay-info"> <span
				class="mosaic-item-overlay-info-icon"> <span
					class="mosaic-item-overlay-info-head type-font-feature">{{title}}</span>
					<span class="mosaic-item-overlay-info-icon-item"> <img
						src="{{categoryLogo}}" alt="">
				</span> <span class="mosaic-item-overlay-info-desciption">
						{{cityTagName}} <br> <br> <span
						class="mosaic-item-description-copy-link"><strong>Find
								out more</strong></span>
				</span>
			</span> <span class="mosaic-item-overlay-info-categories"> <strong>{{categoryTagName}}</strong>
			</span>
		</span>
		</a>
	</div>
	{{/if}}  {{/compare}} {{/each}}

	<div class="col-xs-12 {{#if isGrid}}col-md-6{{else}}col-reset-md-6{{/if}} 4">
		<div class="row">
			{{#each test}} {{#compare @index 1 operator="=="}} {{#if
			templateName}}
			<div class="col-xs-12 {{#if ../../../isGrid}}col-sm-6{{else}}col-reset-sm-6{{/if}}">
				{{#if linkChecker}} <a href="{{postLink}}" title=""
					class="mosaic-item mosaic-item-{{../../../../type}}"> {{else}} <a
					href="{{postLink}}" title=""
					class="mosaic-item mosaic-item-{{../../../../type}}" target="_blank">
						{{/if}} <img class='mosaic-item-image' src="{{image}}" alt=""
						width="100%" /> <span class="mosaic-item-description {{templateName}}"> <span
							class="mosaic-item-description-head type-font-feature">{{title}}</span>
							<span class="mosaic-item-description-sub">{{stateTag}}</span> <span
							class="mosaic-item-description-copy"> {{description}} <br>
							<br> <span class="mosaic-item-description-copy-link"><strong>Read
										more</strong></span>
						</span> <span
							class="mosaic-item-description-share mosaic-item-description-share-dark">
								<img src="{{socialIconsBlack}}" alt="">
						</span> <span
							class="mosaic-item-description-share mosaic-item-description-share-white">
								<img src="{{socialIconsWhite}}" alt="" />
						</span>
					</span> <span class="mosaic-item-overlay mosaic-item-overlay-share">
							<span class="mosaic-item-overlay-share-container"> <span
								class="mosaic-item-overlay-share-copy"> {{messageText}} <br>
								<br> <strong>{{userName}} on {{templateName}}</strong>
							</span>
						</span>
					</span>
				</a>
			</div>
			{{else}}
			<div class="col-xs-12 {{#if ../../../isGrid}}col-sm-6{{else}}col-reset-sm-6{{/if}}">
				<a href="{{pagePath}}" class="mosaic-item mosaic-item-{{../../../type}}"
					title=""> <img class='mosaic-item-image' src="{{image}}" alt=""
					width="100%" /> <span class="mosaic-item-description {{templateName}}"> <span
						class="mosaic-item-description-head type-font-feature">
							{{title}} </span> <span class="mosaic-item-description-sub">
							{{stateTag}} </span> <span class="mosaic-item-description-copy">
							{{description}} <br>
						<br> <span class="mosaic-item-description-copy-link"><strong>Read
									more</strong></span> <strong class="mosaic-item-description-categories"><em>{{categoryTagName}}</em></strong>
					</span>
				</span> <span class="mosaic-item-overlay mosaic-item-overlay-info">
						<span class="mosaic-item-overlay-info-icon"> <span
							class="mosaic-item-overlay-info-head type-font-feature">{{title}}</span>
							<span class="mosaic-item-overlay-info-icon-item"> <img
								src="{{categoryLogo}}" alt="">
						</span> <span class="mosaic-item-overlay-info-desciption">
								{{cityTagName}} <br> <br> <span
								class="mosaic-item-description-copy-link"><strong>Find
										out more</strong></span>
						</span>
					</span> <span class="mosaic-item-overlay-info-categories"> <strong>{{categoryTagName}}</strong>
					</span>
				</span>

				</a>
			</div>
			{{/if}}  {{/compare}} {{#compare @index 2 operator="=="}} {{#if
			templateName}}
			<div class="col-xs-12 {{#if ../../../isGrid}}col-sm-6{{else}}col-reset-sm-6{{/if}}">
				{{#if linkChecker}} <a href="{{postLink}}" title=""
					class="mosaic-item mosaic-item-{{../../../../type}}"> {{else}} <a
					href="{{postLink}}" title=""
					class="mosaic-item mosaic-item-{{../../../../type}}" target="_blank">
						{{/if}} <img class='mosaic-item-image' src="{{image}}" alt=""
						width="100%" /> <span class="mosaic-item-description {{templateName}}"> <span
							class="mosaic-item-description-head type-font-feature">{{title}}</span>
							<span class="mosaic-item-description-sub">{{stateTag}}</span> <span
							class="mosaic-item-description-copy"> {{description}} <br>
							<br> <span class="mosaic-item-description-copy-link"><strong>Read
										more</strong></span>
						</span> <span
							class="mosaic-item-description-share mosaic-item-description-share-dark">
								<img src="{{socialIconsBlack}}" alt="">
						</span> <span
							class="mosaic-item-description-share mosaic-item-description-share-white">
								<img src="{{socialIconsWhite}}" alt="" />
						</span>
					</span> <span class="mosaic-item-overlay mosaic-item-overlay-share">
							<span class="mosaic-item-overlay-share-container"> <span
								class="mosaic-item-overlay-share-copy"> {{messageText}} <br>
								<br> <strong>{{userName}} on {{templateName}}</strong>
							</span>
						</span>
					</span>
				</a>
			</div>
			{{else}}
			<div class="col-xs-12 {{#if ../../../isGrid}}col-sm-6{{else}}col-reset-sm-6{{/if}}">
				<a href="{{pagePath}}" class="mosaic-item mosaic-item-{{../../../type}}"
					title=""> <img class='mosaic-item-image' src="{{image}}" alt=""
					width="100%" /> <span class="mosaic-item-description {{templateName}}"> <span
						class="mosaic-item-description-head type-font-feature">
							{{title}} </span> <span class="mosaic-item-description-sub">
							{{stateTag}} </span> <span class="mosaic-item-description-copy">
							{{description}} <br>
						<br> <span class="mosaic-item-description-copy-link"><strong>Read
									more</strong></span> <strong class="mosaic-item-description-categories"><em>{{categoryTagName}}</em></strong>
					</span>
				</span> <span class="mosaic-item-overlay mosaic-item-overlay-info">
						<span class="mosaic-item-overlay-info-icon"> <span
							class="mosaic-item-overlay-info-head type-font-feature">{{title}}</span>
							<span class="mosaic-item-overlay-info-icon-item"> <img
								src="{{categoryLogo}}" alt="">
						</span> <span class="mosaic-item-overlay-info-desciption">
								{{cityTagName}} <br> <br> <span
								class="mosaic-item-description-copy-link"><strong>Find
										out more</strong></span>
						</span>
					</span> <span class="mosaic-item-overlay-info-categories"> <strong>{{categoryTagName}}</strong>
					</span>
				</span>

				</a>
			</div>
			{{/if}} {{/compare}} {{#compare @index 3 operator="=="}} {{#if
			templateName}}
			<div class="col-xs-12 {{#if ../../../isGrid}}col-sm-6{{else}}col-reset-sm-6{{/if}} ">
				{{#if linkChecker}} <a href="{{postLink}}" title=""
					class="mosaic-item mosaic-item-{{../../../../type}}"> {{else}} <a
					href="{{postLink}}" title=""
					class="mosaic-item mosaic-item-{{../../../../type}}" target="_blank">
						{{/if}} <img class='mosaic-item-image' src="{{image}}" alt=""
						width="100%" /> <span class="mosaic-item-description {{templateName}}"> <span
							class="mosaic-item-description-head type-font-feature">{{title}}</span>
							<span class="mosaic-item-description-sub">{{stateTag}}</span> <span
							class="mosaic-item-description-copy"> {{description}} <br>
							<br> <span class="mosaic-item-description-copy-link"><strong>Read
										more</strong></span>
						</span> <span
							class="mosaic-item-description-share mosaic-item-description-share-dark">
								<img src="{{socialIconsBlack}}" alt="">
						</span> <span
							class="mosaic-item-description-share mosaic-item-description-share-white">
								<img src="{{socialIconsWhite}}" alt="" />
						</span>
					</span> <span class="mosaic-item-overlay mosaic-item-overlay-share">
							<span class="mosaic-item-overlay-share-container"> <span
								class="mosaic-item-overlay-share-copy"> {{messageText}} <br>
								<br> <strong>{{userName}} on {{templateName}}</strong>
							</span>
						</span>
					</span>

				</a>
			</div>
			{{else}}
			<div class="col-xs-12 {{#if ../../../isGrid}}col-sm-6{{else}}col-reset-sm-6{{/if}}">
				<a href="{{pagePath}}" class="mosaic-item mosaic-item-{{../../../type}}"
					title=""> <img class='mosaic-item-image' src="{{image}}" alt=""
					width="100%" /> <span class="mosaic-item-description {{templateName}}"> <span
						class="mosaic-item-description-head type-font-feature">
							{{title}} </span> <span class="mosaic-item-description-sub">
							{{stateTag}} </span> <span class="mosaic-item-description-copy">
							{{description}} <br>
						<br> <span class="mosaic-item-description-copy-link"><strong>Read
									more</strong></span> <strong class="mosaic-item-description-categories"><em>{{categoryTagName}}</em></strong>
					</span>
				</span> <span class="mosaic-item-overlay mosaic-item-overlay-info">
						<span class="mosaic-item-overlay-info-icon"> <span
							class="mosaic-item-overlay-info-head type-font-feature">{{title}}</span>
							<span class="mosaic-item-overlay-info-icon-item"> <img
								src="{{categoryLogo}}" alt="">
						</span> <span class="mosaic-item-overlay-info-desciption">
								{{cityTagName}} <br> <br> <span
								class="mosaic-item-description-copy-link"><strong>Find
										out more</strong></span>
						</span>
					</span> <span class="mosaic-item-overlay-info-categories"> <strong>{{categoryTagName}}</strong>
					</span>
				</span>

				</a>
			</div>
			{{/if}}  {{/compare}} {{#compare @index 4 operator="=="}} {{#if
			templateName}}
			<div class="col-xs-12 {{#if ../../../isGrid}}col-sm-6{{else}}col-reset-sm-6{{/if}} ">
				{{#if linkChecker}} <a href="{{postLink}}" title=""
					class="mosaic-item mosaic-item-{{../../../../type}}"> {{else}} <a
					href="{{postLink}}" title=""
					class="mosaic-item mosaic-item-{{../../../../type}}" target="_blank">
						{{/if}} <img class='mosaic-item-image' src="{{image}}" alt=""
						width="100%" /> <span class="mosaic-item-description {{templateName}}"> <span
							class="mosaic-item-description-head type-font-feature">{{title}}</span>
							<span class="mosaic-item-description-sub">{{stateTag}}</span> <span
							class="mosaic-item-description-copy"> {{description}} <br>
							<br> <span class="mosaic-item-description-copy-link"><strong>Read
										more</strong></span>
						</span> <span
							class="mosaic-item-description-share mosaic-item-description-share-dark">
								<img src="{{socialIconsBlack}}" alt="">
						</span> <span
							class="mosaic-item-description-share mosaic-item-description-share-white">
								<img src="{{socialIconsWhite}}" alt="" />
						</span>
					</span> <span class="mosaic-item-overlay mosaic-item-overlay-share">
							<span class="mosaic-item-overlay-share-container"> <span
								class="mosaic-item-overlay-share-copy"> {{messageText}} <br>
								<br> <strong>{{userName}} on {{templateName}}</strong>
							</span>
						</span>
					</span>

				</a>
			</div>
			{{else}}
			<div class="col-xs-12 {{#if ../../../isGrid}}col-sm-6{{else}}col-reset-sm-6{{/if}}">
				<a href="{{pagePath}}" class="mosaic-item mosaic-item-{{../../../type}}"
					title=""> <img class='mosaic-item-image' src="{{image}}" alt=""
					width="100%" /> <span class="mosaic-item-description {{templateName}}"> <span
						class="mosaic-item-description-head type-font-feature">
							{{title}} </span> <span class="mosaic-item-description-sub">
							{{stateTag}} </span> <span class="mosaic-item-description-copy">
							{{description}} <br>
						<br> <span class="mosaic-item-description-copy-link"><strong>Read
									more</strong></span> <strong class="mosaic-item-description-categories"><em>{{categoryTagName}}</em></strong>
					</span>
				</span> <span class="mosaic-item-overlay mosaic-item-overlay-info">
						<span class="mosaic-item-overlay-info-icon"> <span
							class="mosaic-item-overlay-info-head type-font-feature">{{title}}</span>
							<span class="mosaic-item-overlay-info-icon-item"> <img
								src="{{categoryLogo}}" alt="">
						</span> <span class="mosaic-item-overlay-info-desciption">
								{{cityTagName}} <br> <br> <span
								class="mosaic-item-description-copy-link"><strong>Find
										out more</strong></span>
						</span>
					</span> <span class="mosaic-item-overlay-info-categories"> <strong>{{categoryTagName}}</strong>
					</span>
				</span>

				</a>
			</div>
			{{/if}}  {{/compare}} {{/each}}
		</div>
	</div>
</div>

<div class="row l-row-collapse">
	<div class="col-xs-12 {{#if isGrid}}col-md-3{{else}}col-reset-md-3{{/if}} mosaic-ie-25">
		<div class="row">
			{{#each test}} {{#compare @index 5 operator="=="}} {{#if
			templateName}}
			<div class="col-xs-12 {{#if ../../../isGrid}}col-sm-6{{else}}col-reset-sm-6{{/if}} col-md-12 mosaic-ie-100" target="_blank">
				{{#if linkChecker}} <a href="{{postLink}}" title=""
					class="mosaic-item mosaic-item-{{../../../../type}}"> {{else}} <a
					href="{{postLink}}" title=""
					class="mosaic-item mosaic-item-{{../../../../type}}" target="_blank">
						{{/if}} <img class='mosaic-item-image' src="{{image}}" alt=""
						width="100%" /> <span class="mosaic-item-description {{templateName}}"> <span
							class="mosaic-item-description-head type-font-feature">{{title}}</span>
							<span class="mosaic-item-description-sub">{{stateTag}}</span> <span
							class="mosaic-item-description-copy"> {{description}} <br>
							<br> <span class="mosaic-item-description-copy-link"><strong>Read
										more</strong></span>
						</span> <span
							class="mosaic-item-description-share mosaic-item-description-share-dark">
								<img src="{{socialIconsBlack}}" alt="">
						</span> <span
							class="mosaic-item-description-share mosaic-item-description-share-white">
								<img src="{{socialIconsWhite}}" alt="" />
						</span>
					</span> <span class="mosaic-item-overlay mosaic-item-overlay-share">
							<span class="mosaic-item-overlay-share-container"> <span
								class="mosaic-item-overlay-share-copy"> {{messageText}} <br>
								<br> <strong>{{userName}} on {{templateName}}</strong>
							</span>
						</span>
					</span>

				</a>
			</div>
			{{else}}
			<div class="col-xs-12 {{#if ../../../isGrid}}col-sm-6{{else}}col-reset-sm-6{{/if}} col-md-12 mosaic-ie-100">
				<a href="{{pagePath}}" class="mosaic-item mosaic-item-{{../../../type}}"
					title=""> <img class='mosaic-item-image' src="{{image}}"
					alt="" width="100%" /> <span class="mosaic-item-description {{templateName}}">
						<span class="mosaic-item-description-head type-font-feature">
							{{title}} </span> <span class="mosaic-item-description-sub">
							{{stateTag}} </span> <span class="mosaic-item-description-copy">
							{{description}} <br>
						<br> <span class="mosaic-item-description-copy-link"><strong>Read
									more</strong></span> <strong class="mosaic-item-description-categories"><em>{{categoryTagName}}</em></strong>
					</span>
				</span> <span class="mosaic-item-overlay mosaic-item-overlay-info">
						<span class="mosaic-item-overlay-info-icon"> <span
							class="mosaic-item-overlay-info-head type-font-feature">{{title}}</span>
							<span class="mosaic-item-overlay-info-icon-item"> <img
								src="{{categoryLogo}}" alt="">
						</span> <span class="mosaic-item-overlay-info-desciption">
								{{cityTagName}} <br> <br> <span
								class="mosaic-item-description-copy-link"><strong>Find
										out more</strong></span>
						</span>
					</span> <span class="mosaic-item-overlay-info-categories"> <strong>{{categoryTagName}}</strong>
					</span>
				</span>

				</a>
			</div>


			{{/if}}  {{/compare}} {{#compare @index 6 operator="=="}} {{#if templateName}}
			<div class="col-xs-12 {{#if ../../../isGrid}}col-sm-6{{else}}col-reset-sm-6{{/if}} col-md-12 mosaic-ie-100">
				{{#if linkChecker}} <a href="{{postLink}}" title=""
					class="mosaic-item mosaic-item-{{../../../../type}}"> {{else}} <a
					href="{{postLink}}" title=""
					class="mosaic-item mosaic-item-{{../../../../type}}" target="_blank">
						{{/if}} <img class='mosaic-item-image' src="{{image}}" alt=""
						width="100%" /> <span class="mosaic-item-description {{templateName}}"> <span
							class="mosaic-item-description-head type-font-feature">{{title}}</span>
							<span class="mosaic-item-description-sub">{{stateTag}}</span> <span
							class="mosaic-item-description-copy"> {{description}} <br>
							<br> <span class="mosaic-item-description-copy-link"><strong>Read
										more</strong></span>
						</span> <span
							class="mosaic-item-description-share mosaic-item-description-share-dark">
								<img src="{{socialIconsBlack}}" alt="">
						</span> <span
							class="mosaic-item-description-share mosaic-item-description-share-white">
								<img src="{{socialIconsWhite}}" alt="" />
						</span>
					</span> <span class="mosaic-item-overlay mosaic-item-overlay-share">
							<span class="mosaic-item-overlay-share-container"> <span
								class="mosaic-item-overlay-share-copy"> {{messageText}} <br>
								<br> <strong>{{userName}} on {{templateName}}</strong>
							</span>
						</span>
					</span>

				</a>
			</div>
			{{else}}
			<div class="col-xs-12 {{#if ../../../isGrid}}col-sm-6{{else}}col-reset-sm-6{{/if}} col-md-12 mosaic-ie-100">
				<a href="{{pagePath}}" class="mosaic-item mosaic-item-{{../../../type}}"
					title=""> <img class='mosaic-item-image' src="{{image}}" alt=""
					width="100%" /> <span class="mosaic-item-description {{templateName}}"> <span
						class="mosaic-item-description-head type-font-feature">
							{{title}} </span> <span class="mosaic-item-description-sub">
							{{stateTag}} </span> <span class="mosaic-item-description-copy">
							{{description}} <br>
						<br> <span class="mosaic-item-description-copy-link"><strong>Read
									more</strong></span> <strong class="mosaic-item-description-categories"><em>{{categoryTagName}}</em></strong>
					</span>
				</span> <span class="mosaic-item-overlay mosaic-item-overlay-info">
						<span class="mosaic-item-overlay-info-icon"> <span
							class="mosaic-item-overlay-info-head type-font-feature">{{title}}</span>
							<span class="mosaic-item-overlay-info-icon-item"> <img
								src="{{categoryLogo}}" alt="">
						</span> <span class="mosaic-item-overlay-info-desciption">
								{{cityTagName}} <br> <br> <span
								class="mosaic-item-description-copy-link"><strong>Find
										out more</strong></span>
						</span>
					</span> <span class="mosaic-item-overlay-info-categories"> <strong>{{categoryTagName}}</strong>
					</span>
				</span>

				</a>
			</div>

			{{/if}}  {{/compare}} {{/each}}
		</div>
	</div>

	{{#each test}} {{#compare @index 7 operator="=="}} {{#if templateName}}

	<div class="col-xs-12 {{#if ../../../isGrid}}col-md-6{{else}}col-reset-md-6{{/if}} 10">
		{{#if linkChecker}} <a href="{{postLink}}" title=""
			class="mosaic-item mosaic-item-{{../../../../type}}"> {{else}} <a
			href="{{postLink}}" title="" class="mosaic-item mosaic-item-{{../../../../type}}"
			target="_blank"> {{/if}} <img class='mosaic-item-image'
				src="{{image}}" alt="" width="100%" /> <span
				class="mosaic-item-description {{templateName}}"> <span
					class="mosaic-item-description-head type-font-feature">{{title}}</span>
					<span class="mosaic-item-description-sub">{{stateTag}}</span> <span
					class="mosaic-item-description-copy"> {{description}} <br>
					<br> <span class="mosaic-item-description-copy-link"><strong>Read
								more</strong></span>
				</span> <span
					class="mosaic-item-description-share mosaic-item-description-share-dark">
						<img src="{{socialIconsBlack}}" alt="">
				</span> <span
					class="mosaic-item-description-share mosaic-item-description-share-white">
						<img src="{{socialIconsWhite}}" alt="" />
				</span>
			</span> <span class="mosaic-item-overlay mosaic-item-overlay-share">
					<span class="mosaic-item-overlay-share-container"> <span
						class="mosaic-item-overlay-share-copy"> {{messageText}} <br>
						<br> <strong>{{userName}} on {{templateName}}</strong>
					</span>
				</span>
			</span>
		</a>
	</div>



	{{else}}
	<div class="col-xs-12 {{#if ../../../isGrid}}col-md-6{{else}}col-reset-md-6{{/if}} 11">
		<a href="{{pagePath}}" class="mosaic-item mosaic-item-{{../../../type}}"
			title=""> <img class='mosaic-item-image' src="{{image}}" alt=""
			width="100%" /> <span class="mosaic-item-description {{templateName}}"> <span
				class="mosaic-item-description-head type-font-feature">
					{{title}} </span> <span class="mosaic-item-description-sub">
					{{stateTag}} </span> <span class="mosaic-item-description-copy">
					{{description}} <br>
				<br> <span class="mosaic-item-description-copy-link"><strong>Read
							more</strong></span> <strong class="mosaic-item-description-categories"><em>{{categoryTagName}}</em></strong>
			</span>
		</span> <span class="mosaic-item-overlay mosaic-item-overlay-info"> <span
				class="mosaic-item-overlay-info-icon"> <span
					class="mosaic-item-overlay-info-head type-font-feature">{{title}}</span>
					<span class="mosaic-item-overlay-info-icon-item"> <img
						src="{{categoryLogo}}" alt="">
				</span> <span class="mosaic-item-overlay-info-desciption">
						{{cityTagName}} <br> <br> <span
						class="mosaic-item-description-copy-link"><strong>Find
								out more</strong></span>
				</span>
			</span> <span class="mosaic-item-overlay-info-categories"> <strong>{{categoryTagName}}</strong>
			</span>
		</span>

		</a>
	</div>



	{{/if}}  {{/compare}} {{/each}}
	<div class="col-xs-12 {{#if isGrid}}col-md-3{{else}}col-reset-md-3{{/if}} mosaic-ie-25">
		<div class="row">
			{{#each test}} 

			{{#compare @index 8 operator="=="}} {{#if templateName}}

			<div class="col-xs-12 {{#if ../../../isGrid}}col-sm-6{{else}}col-reset-sm-6{{/if}} col-md-12 mosaic-ie-100">
				{{#if linkChecker}} <a href="{{postLink}}" title=""
					class="mosaic-item mosaic-item-{{../../../../type}}"> {{else}} <a
					href="{{postLink}}" title=""
					class="mosaic-item mosaic-item-{{../../../../type}}" target="_blank">
						{{/if}} <img class='mosaic-item-image' src="{{image}}" alt=""
						width="100%" /> <span class="mosaic-item-description {{templateName}}"> <span
							class="mosaic-item-description-head type-font-feature">{{title}}</span>
							<span class="mosaic-item-description-sub">{{stateTag}}</span> <span
							class="mosaic-item-description-copy"> {{description}} <br>
							<br> <span class="mosaic-item-description-copy-link"><strong>Read
										more</strong></span>
						</span> <span
							class="mosaic-item-description-share mosaic-item-description-share-dark">
								<img src="{{socialIconsBlack}}" alt="">
						</span> <span
							class="mosaic-item-description-share mosaic-item-description-share-white">
								<img src="{{socialIconsWhite}}" alt="" />
						</span>
					</span> <span class="mosaic-item-overlay mosaic-item-overlay-share">
							<span class="mosaic-item-overlay-share-container"> <span
								class="mosaic-item-overlay-share-copy"> {{messageText}} <br>
								<br> <strong>{{userName}} on {{templateName}}</strong>
							</span>
						</span>
					</span>

				</a>
			</div>

			{{else}}
			<div class="col-xs-12 {{#if ../../../isGrid}}col-sm-6{{else}}col-reset-sm-6{{/if}} col-md-12 mosaic-ie-100">
				<a href="{{pagePath}}" class="mosaic-item mosaic-item-{{../../../type}}"
					title=""> <img class='mosaic-item-image' src="{{image}}" alt=""
					width="100%" /> <span class="mosaic-item-description {{templateName}}"> <span
						class="mosaic-item-description-head type-font-feature">
							{{title}} </span> <span class="mosaic-item-description-sub">
							{{stateTag}} </span> <span class="mosaic-item-description-copy">
							{{description}} <br>
						<br> <span class="mosaic-item-description-copy-link"><strong>Read
									more</strong></span> <strong class="mosaic-item-description-categories"><em>{{categoryTagName}}</em></strong>
					</span>
				</span> <span class="mosaic-item-overlay mosaic-item-overlay-info">
						<span class="mosaic-item-overlay-info-icon"> <span
							class="mosaic-item-overlay-info-head type-font-feature">{{title}}</span>
							<span class="mosaic-item-overlay-info-icon-item"> <img
								src="{{categoryLogo}}" alt="">
						</span> <span class="mosaic-item-overlay-info-desciption">
								{{cityTagName}} <br> <br> <span
								class="mosaic-item-description-copy-link"><strong>Find
										out more</strong></span>
						</span>
					</span> <span class="mosaic-item-overlay-info-categories"> <strong>{{categoryTagName}}</strong>
					</span>
				</span>

				</a>
			</div>


			{{/if}}  {{/compare}} {{#compare @index 9 operator="=="}} 
			 {{#if templateName}}

			<div class="col-xs-12 {{#if ../../../isGrid}}col-sm-6{{else}}col-reset-sm-6{{/if}} col-md-12 mosaic-ie-100">
				{{#if linkChecker}} <a href="{{postLink}}" title=""
					class="mosaic-item mosaic-item-{{../../../../type}}"> {{else}} <a
					href="{{postLink}}" title=""
					class="mosaic-item mosaic-item-{{../../../../type}}" target="_blank">
						{{/if}} <img class='mosaic-item-image' src="{{image}}" alt=""
						width="100%" /> <span class="mosaic-item-description {{templateName}}"> <span
							class="mosaic-item-description-head type-font-feature">{{title}}</span>
							<span class="mosaic-item-description-sub">{{stateTag}}</span> <span
							class="mosaic-item-description-copy"> {{description}} <br>
							<br> <span class="mosaic-item-description-copy-link"><strong>Read
										more</strong></span>
						</span> <span
							class="mosaic-item-description-share mosaic-item-description-share-dark">
								<img src="{{socialIconsBlack}}" alt="">
						</span> <span
							class="mosaic-item-description-share mosaic-item-description-share-white">
								<img src="{{socialIconsWhite}}" alt="" />
						</span>
					</span> <span class="mosaic-item-overlay mosaic-item-overlay-share">
							<span class="mosaic-item-overlay-share-container"> <span
								class="mosaic-item-overlay-share-copy"> {{messageText}} <br>
								<br> <strong>{{userName}} on {{templateName}}</strong>
							</span>
						</span>
					</span>

				</a>
			</div>

			{{else}}

			<div class="col-xs-12 {{#if ../../../../isGrid}}col-sm-6{{else}}col-reset-sm-6{{/if}} col-md-12 mosaic-ie-100">
				<a href="{{pagePath}}" class="mosaic-item mosaic-item-{{../../../type}}"
					title=""> <img class='mosaic-item-image' src="{{image}}" alt=""
					width="100%" /> <span class="mosaic-item-description {{templateName}}"> <span
						class="mosaic-item-description-head type-font-feature">
							{{title}} </span> <span class="mosaic-item-description-sub">
							{{stateTag}} </span> <span class="mosaic-item-description-copy">
							{{description}} <br>
						<br> <span class="mosaic-item-description-copy-link"><strong>Read
									more</strong></span> <strong class="mosaic-item-description-categories"><em>{{categoryTagName}}</em></strong>
					</span>
				</span> <span class="mosaic-item-overlay mosaic-item-overlay-info">
						<span class="mosaic-item-overlay-info-icon"> <span
							class="mosaic-item-overlay-info-head type-font-feature">{{title}}</span>
							<span class="mosaic-item-overlay-info-icon-item"> <img
								src="{{categoryLogo}}" alt="">
						</span> <span class="mosaic-item-overlay-info-desciption">
								{{cityTagName}} <br> <br> <span
								class="mosaic-item-description-copy-link"><strong>Find
										out more</strong></span>
						</span>
					</span> <span class="mosaic-item-overlay-info-categories"> <strong>{{categoryTagName}}</strong>
					</span>
				</span>

				</a>
			</div>


			{{/if}}  {{/compare}} {{/each}}
		</div>
	</div>
</div>