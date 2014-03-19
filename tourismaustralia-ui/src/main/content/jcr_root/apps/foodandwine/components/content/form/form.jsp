<%@include file="/apps/foodandwine/components/global.jsp"%>

<script>
	$(document).ready(function() {
		$(".categories-box").formcategory();
	});
</script>

<form action="${resource.path}.formemail.json" method="post">
	<!-- input fields -->
	<div class="field-container">
		<div class="input-field" data-type="text">
			<div class="col-xs-4">
				<label class="input-field-label" for="text">
					<p>
						<strong>Business name*</strong>
					</p>
				</label>
			</div>
			<div class="col-xs-8">
				<input class="input-field-input" name="businessName" id="businessName" type="text"
					placeholder="E.g. Rockpool"> <span
					class="input-field-validation-icon"></span>
			</div>
			<div class="col-xs-12">
				<p class="input-field-validation-alert">Please enter a valid
					Business name</p>
			</div>
		</div>
	</div>
	<div class="field-container">
		<div class="input-field" data-type="text">
			<div class="col-xs-4">
				<label class="input-field-label" for="text">
					<p>
						<strong>Location*</strong>
					</p>
				</label>
			</div>
			<div class="col-xs-8">
				<input class="input-field-input" name="location" id="location" type="text"
					placeholder="E.g. Sydney"> <span
					class="input-field-validation-icon"></span>
			</div>
			<div class="col-xs-12">
				<p class="input-field-validation-alert">Please enter a valid
					location</p>
			</div>
		</div>
	</div>
	<div class="field-container">
		<div class="input-field input-field-select" data-type="select">
			<select class="input-select" name="selectTerritory" id="selectTerritory">
				<option selected="selected" disabled="disabled">Select a
					state or territory*</option>
				<option value="nsw">NSW</option>
				<option value="southernaustralia">Southern Australia</option>
				<option value="victoria">Victoria</option>
			</select> <span class="input-field-validation-icon"></span>
			<div class="col-xs-12">
				<p class="input-field-validation-alert">Please enter a valid
					state or territory</p>
			</div>
		</div>
	</div>
	<div class="field-container">
		<div class="input-field" data-type="mail">
			<div class="col-xs-4">
				<label class="input-field-label" for="text">
					<p>
						<strong>Email address*</strong>
					</p>
				</label>
			</div>
			<div class="col-xs-8">
				<input id="mail" class="input-field-input" name="mail" type="text"
					placeholder="E.g. john.smith@email.com"> <span
					class="input-field-validation-icon"></span>
			</div>
			<div class="col-xs-12">
				<p class="input-field-validation-alert">Please enter a valid
					email address</p>
			</div>
		</div>
	</div>
	<div class="field-container">
		<div class="input-field" data-type="verify-mail">
			<div class="col-xs-4">
				<label class="input-field-label" for="text">
					<p>
						<strong>Verify email*</strong>
					</p>
				</label>
			</div>
			<div class="col-xs-8">
				<input id="verifymail" name="verifymail" class="input-field-input" type="text"
					placeholder="E.g. john.smith@email.com"> <span
					class="input-field-validation-icon"></span>
			</div>
			<div class="col-xs-12">
				<p class="input-field-validation-alert">Please enter the right
					verify email</p>
			</div>
		</div>
	</div>
	<div class="field-container">
		<div class="input-field" data-type="text">
			<div class="col-xs-4">
				<label class="input-field-label" for="text">
					<p>
						<strong>Business Website*</strong>
					</p>
				</label>
			</div>
			<div class="col-xs-8">
				<input class="input-field-input" name="businessWebsite" id="businessWebsite" type="text"
					placeholder="E.g. www.business.com.au"> <span
					class="input-field-validation-icon"></span>
			</div>
			<div class="col-xs-12">
				<p class="input-field-validation-alert">Please enter a valid
					Business Website</p>
			</div>
		</div>
	</div>
	<div class="field-container">
		<div class="description-box">
			<h4 class="description-box-headline">Description</h4>
			<p class="description-box-copy">
				<em>Write a short description of what your business does best</em>
			</p>
			<textarea class="description-box-input-field"  name="businessDescription" id="businessDescription" rows="4"
				placeholder="..."></textarea>
		</div>
	</div>
	<div class="field-container">
		<div class="description-box description-box-outer">
			<h4 class="description-box-headline">Photos</h4>
			<p class="description-box-copy">
				<em>Jpeg, Gif or PNG - 5mb file limit. Your image should be at
					least 600 x 600px</em>
			</p>
			<div class="image-uploader">
				<div class="image-uploader-holder">
					<img class="image-uploader-sample"
						src="imgs/base/image-upload-icon.png" alt="">
				</div>

				<p>
					<strong>Drag &amp; drop to upload <br>
					</strong> or <a href="" target="_self"><strong>select files</strong></a>
				</p>
				<progress class="image-upload-progressbar" min="0" max="100"
					value="0">0</progress>
				<p class="image-uploader-upload hidden">Drag &amp; drop not
					supported, but you can still upload via the upload link</p>
				<p class="hidden">File API &amp; FileReader API not supported</p>
				<p class="hidden">XHR2's FormData is not supported</p>
				<p class="hidden">XHR2's upload progress isn't supported</p>
			</div>

			<div class="description-box">
				<h4 class="description-box-headline">Optional Description</h4>
				<p class="description-box-copy">
					<em>Write a short description about your photo</em>
				</p>
				<textarea class="description-box-input-field" name="photoDescription" id="photoDescription" rows="4"
					placeholder="..."></textarea>
			</div>
		</div>
	</div>
	<div class="field-container">
		<div class="categories-box">
			<h4 class="categories-box-headline">Categories</h4>
			<p class="categories-box-copy">
				<em>Select <strong>one</strong> or <strong>two</strong>
					categories that best reflect your business:
				</em>
			</p>

			<div class="form-category-radios">

				<input type="hidden" name="category-primary" value=""> <span
					id="category-primary" class="form-category-tick checkbox-label">Primary
					category</span> <input type="hidden" name="category-secondary" value="">
				<span id="category-secondary"
					class="form-category-tick checkbox-label">Secondary category</span>

			</div>

			<div class="row categories-row">
				<div class="col-xs-12">

					<input id="category-restaurants" name="category-restaurants" type="checkbox"
						class="category-input"> <label for="category-restaurants">

						<div class="category-item">

							<span class="icon-round icon-font-restaurants"></span> <span
								class="category-title"> Restaurants </span> <span
								class="category-description"> Restaurants, desc... </span>
						</div>
					</label> <input id="category-wine" name="category-wine" type="checkbox" class="category-input">
					<label for="category-wine">

						<div class="category-item">

							<span class="icon-round icon-font-wine-story"></span> <span
								class="category-title"> Wine Story </span> <span
								class="category-description"> Winery, Wine Producers,
								Wine Family, Vinyards </span>
						</div>
					</label> <input id="category-produce" name="category-produce" type="checkbox"
						class="category-input"> <label for="category-produce">

						<div class="category-item">

							<span class="icon-round icon-font-produce"></span> <span
								class="category-title"> Produce </span> <span
								class="category-description"> Produce, desc... </span>
						</div>
					</label> <input id="category-events" name="category-events" type="checkbox" class="category-input">
					<label for="category-events">

						<div class="category-item">

							<span class="icon-round icon-font-events"></span> <span
								class="category-title"> Events </span> <span
								class="category-description"> Events, desc... </span>
						</div>
					</label> <input id="category-people" name="category-people" type="checkbox" class="category-input">
					<label for="category-people">

						<div class="category-item">

							<span class="icon-round icon-font-people"></span> <span
								class="category-title"> People </span> <span
								class="category-description"> People, desc... </span>
						</div>
					</label> <input id="category-experiences" name="category-experiences" type="checkbox"
						class="category-input"> <label for="category-experiences">

						<div class="category-item">
							<span class="icon-round icon-font-experiences"></span> <span
								class="category-title"> Experiences </span> <span
								class="category-description"> Experiences, desc... </span>
						</div>
					</label> <input id="category-seafood" name="category-seafood" type="checkbox"
						class="category-input"> <label for="category-seafood">
						<div class="category-item">
							<span class="icon-round icon-font-seafood"></span> <span
								class="category-title"> Seafood </span> <span
								class="category-description"> Seafood, desc... </span>
						</div>
					</label>
				</div>
			</div>
		</div>
	</div>
	<!--checkbox -->

	

<!--  -->
	<hr class="form-clear">
	<p class="form-submit-button">
		<input type="submit" onclick="validateForm();"
			value="I'm done, submit" class="btn-secondary">
	</p>
</form>