<%@include file="/apps/foodandwine/components/global.jsp"%>

<%@ page import="com.australia.foodandwine.components.content.form.Form"%>

<c:set var="form" value="<%=new Form(slingRequest) %>" />

<style>
#upload-photo {
	display: none;
}
</style>
<script>
	$(document).ready(function() {
		$(".categories-box").formcategory();

		$("#upload").click(function() {
			$("#upload-photo").trigger('click');
		});
	});
</script>
<div class="row form-container">
	<div class="col-xs-12 col-sm-8 col-sm-offset-2">
		<form action="${form.formPath}" method="post"
			class="form-container-inner add-experience-form" enctype="multipart/form-data">
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
						<input class="input-field-input" name="businessName"
							id="businessName" type="text" placeholder="E.g. Rockpool">
						<span class="input-field-validation-icon"></span>
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
						<input class="input-field-input" name="location" id="location"
							type="text" placeholder="E.g. Sydney"> <span
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
					<select class="input-select" name="selectTerritory"
						id="selectTerritory">
						<option selected="selected" disabled="disabled" value="">Select
							a state*</option>
						<option>Australian Capital Territory</option>
						<option>New South Wales</option>
						<option>Northern Territory</option>
						<option>Queensland</option>
						<option>South Australia</option>
						<option>Tasmania</option>
						<option>Victoria</option>
						<option>Western Australia</option>
					</select> <span class="input-field-validation-icon"></span>
					<div class="col-xs-12">
						<p class="input-field-validation-alert">Please enter a valid
							state or territory</p>
					</div>
				</div>
			</div>
			<div class="field-container">
                <div class="input-field" data-type="text">
                    <div class="col-xs-4">
                        <label class="input-field-label" for="text">
                            <p>
                                <strong>Contact name*</strong>
                            </p></label>
                    </div>
                    <div class="col-xs-8">
                        <input class="input-field-input" type="text" placeholder="E.g. John Smith" id="contact" name="contact">
                        <span class="input-field-validation-icon"></span>
                    </div>
                    <div class="col-xs-12">
                        <p class="input-field-validation-alert">
                            Please enter a valid Contact name
                        </p>
                    </div>
                </div>
            </div>
			<div class="field-container">
				<div class="input-field" data-type="text">
					<div class="col-xs-4">
						<label class="input-field-label" for="text">
							<p>
								<strong>Phone number*</strong>
							</p>
						</label>
					</div>
					<div class="col-xs-8">
						<input class="input-field-input" name="phone-number"
							id="phone-number" type="text" placeholder="E.g. +61 422 942 771">
						<span class="input-field-validation-icon"></span>
					</div>
					<div class="col-xs-12">
						<p class="input-field-validation-alert">Please enter a valid
							phone number</p>
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
						<input id="verifymail" name="verifymail" class="input-field-input"
							type="text" placeholder="E.g. john.smith@email.com"> <span
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
						<input class="input-field-input" name="businessWebsite"
							id="businessWebsite" type="text"
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
					<textarea class="description-box-input-field"
						name="businessDescription" id="businessDescription" rows="4"
						placeholder="..."></textarea>
				</div>
			</div>
			
			<div class="field-container">
                <div class="description-box description-box-outer" data-isvalid="false">
                    <h4 class="description-box-headline"><strong>Upload an Image</strong></h4>
                    <p class="description-box-copy">
                        <em>Jpeg, Gif or PNG - 5mb file limit. Your image should be at least 600 x 600px</em>
                    </p>
					
					<div class="image-uploader">
					    <label class="image-uploader-label" for="imageupload">Upload Image</label>
					    <div class="image-uploader-container btn-primary btn-small">
					        <input type="file" id="imageupload" name="imageupload" class="image-uploader-control" accept="image/*">
					    </div>
					    <span class="image-uploader-filename">No File</span>
					</div>
                    <div class="description-box">
                        <h4 class="description-box-headline"><strong>Image Caption</strong></h4>
                        <p class="description-box-copy">
                            <em>Write a short description about your photo</em>
                        </p>
                        <textarea class="description-box-input-field" rows="4" placeholder="..." name="photoDescription" id="photoDescription"></textarea>
                    </div>
                </div>
            </div>
			
			<div class="field-container">
				<div class="categories-box">
					<h4 class="categories-box-headline">Categories*</h4>
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
							class="form-category-tick checkbox-label">Secondary
							category</span>
					</div>

					<div class="row categories-row">
						<div class="col-xs-12">
						<div class="category-item-container">
							<input id="category-restaurants" type="checkbox"
								class="category-input"> 
							<label for="category-restaurants">
								<div class="category-item">
									<span class="icon-round"> <img
										class='category-image-light'
										src="/etc/designs/foodandwine/clientlibs/imgs/base/categories/category-icon-restaurants-white.png"
										alt="" /> <img class='category-image-dark'
										src="/etc/designs/foodandwine/clientlibs/imgs/base/categories/category-icon-restaurants-dark.png"
										alt="" />
									</span> 
									<span class="category-title"> Restaurants </span> 
									<span class="category-description">${form.restaurantDescription } </span>
								</div>
							</label>
							<input id="category-wine" type="checkbox" class="category-input">
							<label for="category-wine">
								<div class="category-item">
									<span class="icon-round"> <img
										class='category-image-light'
										src="/etc/designs/foodandwine/clientlibs/imgs/base/categories/category-icon-wine-white.png" alt="" />
										<img class='category-image-dark'
										src="/etc/designs/foodandwine/clientlibs/imgs/base/categories/category-icon-wine-dark.png" alt="" />
									</span> <span class="category-title"> Wine </span> <span
										class="category-description"> ${form.wineStoryDescription } </span>
								</div>
							</label> 
							<input id="category-produce" type="checkbox"
								class="category-input"> <label for="category-produce">
								<div class="category-item">
									<span class="icon-round"> <img
										class='category-image-light'
										src="/etc/designs/foodandwine/clientlibs/imgs/base/categories/category-icon-produce-white.png"
										alt="" /> <img class='category-image-dark'
										src="/etc/designs/foodandwine/clientlibs/imgs/base/categories/category-icon-produce-dark.png"
										alt="" />
									</span> <span class="category-title"> Produce </span> <span
										class="category-description"> ${form.produceDescription } </span>
								</div>
							</label> 
							<input id="category-events" type="checkbox"
								class="category-input"> <label for="category-events">
								<div class="category-item">
									<span class="icon-round"> <img
										class='category-image-light'
										src="/etc/designs/foodandwine/clientlibs/imgs/base/categories/category-icon-events-white.png"
										alt="" /> <img class='category-image-dark'
										src="/etc/designs/foodandwine/clientlibs/imgs/base/categories/category-icon-events-dark.png"
										alt="" />
									</span> <span class="category-title"> Festivals </span> <span
										class="category-description"> ${form.eventsDescription }</span>
								</div>
							</label>
							 <input id="category-people" type="checkbox"
								class="category-input"> <label for="category-people">
								<div class="category-item">
									<span class="icon-round"> <img
										class='category-image-light'
										src="/etc/designs/foodandwine/clientlibs/imgs/base/categories/category-icon-people-white.png"
										alt="" /> <img class='category-image-dark'
										src="/etc/designs/foodandwine/clientlibs/imgs/base/categories/category-icon-people-dark.png"
										alt="" />
									</span> <span class="category-title"> People </span> <span
										class="category-description"> ${form.peopleDescription } </span>
								</div>
							</label> 
							<input id="category-experiences" type="checkbox"
								class="category-input"> <label
								for="category-experiences">
								<div class="category-item">
									<span class="icon-round"> <img
										class='category-image-light'
										src="/etc/designs/foodandwine/clientlibs/imgs/base/categories/category-icon-experiences-white.png"
										alt="" /> <img class='category-image-dark'
										src="/etc/designs/foodandwine/clientlibs/imgs/base/categories/category-icon-experiences-dark.png"
										alt="" />
									</span> <span class="category-title"> Experiences </span> <span
										class="category-description"> ${form.experiencesDescription } </span>
								</div>
							</label>
							
							
							 <input id="category-seafood" type="checkbox"
								class="category-input"> <label for="category-seafood">
								<div class="category-item">
									<span class="icon-round"> <img
										class='category-image-light'
										src="/etc/designs/foodandwine/clientlibs/imgs/base/categories/category-icon-seafood-white.png"
										alt="" /> <img class='category-image-dark'
										src="/etc/designs/foodandwine/clientlibs/imgs/base/categories/category-icon-seafood-dark.png"
										alt="" />
									</span> <span class="category-title"> Seafood </span> <span
										class="category-description">${form.seafoodDescription } </span>
								</div>
							</label>
							</div>
						</div>
						<p
							class="input-field-validation-alert categories-box-validation-alert">
							Please select at least one category<span
								class="input-field-validation-icon input-field-validation-icon-false categories-box-validation-icon"></span>
						</p>
					</div>

				</div>
			</div>

			<div class="field-container">
				<div class="input-field" data-type="optional">
					<div class="col-xs-4">
						<label class="input-field-label" for="text">
							<p>
								<strong>Video URL</strong>
							</p>
						</label>
					</div>
					<div class="col-xs-8">
						<input class="input-field-input" type="text" name="videoUrl"
							id="videoUrl" placeholder="E.g. www.youtube.com/myvideo">
					</div>
				</div>
			</div>
			<!--checkbox -->
			<div class="field-container terms-conditions">
				<div class="input-field input-field-checkbox form-agree-container"
					data-type="checkbox">

					<fieldset class="options">
						<input id="checkbox" class="checkbox" type="checkbox"> <label
							for="checkbox" name="demo_lbl_1" class="checkbox-label">I
							agree to Tourism Australia's terms &amp; conditions<sup>*</sup>
						</label>
						<!-- Checkbox powered by CssCheckbox.com -->
						<p class="checkbox-description">
							Tourism Australia may need to contact you to complete or edit
							your listing. By ticking you accept the <a
								href="${form.privacyPolicyLink}" target="_blank">Privacy
								Policy</a> and <a href="${form.termsLink }" target="_blank">Terms
								&amp; Conditions</a>
						</p>
					</fieldset>

					<span class="input-field-validation-icon"></span>
					<div class="col-xs-12">
						<p class="input-field-validation-alert">Please accept the
							terms and conditions</p>
					</div>
				</div>
			</div>

			<!--  -->
			<hr class="form-clear">
			<p class="form-submit-button">
				<input type="submit" value="I'm done, submit" class="btn-secondary">
			</p>
		</form>
	</div>
</div>