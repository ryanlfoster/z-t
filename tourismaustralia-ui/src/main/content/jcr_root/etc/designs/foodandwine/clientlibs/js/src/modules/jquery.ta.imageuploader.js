/*!
 * jQuery lightweight plugin boilerplate
 * Original author: @ajpiano
 * Further changes, comments: @addyosmani
 * Licensed under the MIT license
 *
 * ..............................................................................
 *
 * Image uploader Jquery Plugin
 * based on the example on http://html5demos.com/dnd-upload
 */

;(function($, window, document, undefined) {

	// Create the defaults once
	var pluginName = 'imageuploader', defaults = {
		uploadPath : "/uploader/upload.php",
		imageWidth : 90
	};

	// The actual plugin constructor
	function Plugin(element, options) {
		this.element = element;
		this.options = $.extend({}, defaults, options);
		this._defaults = defaults;
		this._name = pluginName;

		//init plugin
		this.init();
	}


	Plugin.prototype.init = function() {
		var scope = this;

		//scope vars
		scope.holder = $(scope.element).find('.image-uploader-holder')[0];
		scope.reader = {
			filereader : typeof FileReader != 'undefined',
			dnd : 'draggable' in document.createElement('span'),
			formdata : !!window.FormData,
			progress : 'upload' in new XMLHttpRequest()
		};

		//init components
		scope.initComponents(scope);
		//init drag and drop
		scope.initDragEvents(scope);
	};

	Plugin.prototype.initComponents = function(scope) {
		scope.support = {
			filereader : $(scope.element).find('.image-uploader-filereader')[0],
			formdata : $(scope.element).find('.image-uploader-formdata')[0],
			progress : $(scope.element).find('.image-uploader-progress')[0]
		};

		scope.acceptedTypes = {
			'image/png' : true,
			'image/jpeg' : true,
			'image/gif' : true
		};

		scope.progress = $(scope.element).find('.image-upload-progressbar')[0];
		scope.fileupload = $(scope.element).find('.image-uploader-upload')[0];
	};

	Plugin.prototype.initDragEvents = function(scope) {
		"filereader formdata progress".split(' ').forEach(function(api) {
			if (scope.reader[api] === false) {
				scope.support[api].className = 'fail';
			} else {
				scope.support[api].className = 'hidden';
			}
		});

		//add drag and drop evenets
		if (scope.reader.dnd) {
			scope.holder.ondragover = function() {
				this.className = 'image-uploader-holder-hover';
				return false;
			};
			scope.holder.ondragend = function() {
				this.className = '';
				return false;
			};
			scope.holder.ondrop = function(e) {
				this.className = 'image-uploader-holder';
				e.preventDefault();
				scope.readfiles(scope, e.dataTransfer.files);
			};
		} else {
			scope.fileupload.className = 'hidden';
			scope.fileupload.querySelector('input').onchange = function() {
				scope.readfiles(scope, this.files);
			};
		}
	};

	Plugin.prototype.previewfile = function(scope, file) {
		if (scope.uploadAvailable(file)) {
			var reader = new FileReader();
			reader.onload = function(event) {
				scope.addImage(scope, event.target);
			};

			reader.readAsDataURL(file);
		} else {
			scope.holder.innerHTML += '<p>Uploaded: ' + file.name+ '</p>';
		}
	};

	Plugin.prototype.addImage = function(scope, target) {
		var image = new Image();
		image.src = target.result;
		image.width = scope.options.imageWidth;

		scope.holder.appendChild(image);

		//hide sample image
		$(scope.element).find(".image-uploader-sample").css("display", "none");
		//show progress bar
		$(scope.element).find(".image-upload-progressbar").css("display", "block");
	};
	
	Plugin.prototype.uploadAvailable = function(file){
		if(this.reader.filereader === true && this.acceptedTypes[file.type] === true){
			return true;
		}else{
			return false;
		}
	};

	Plugin.prototype.readfiles = function(scope, files) {
		var formData = scope.getFormData(scope);
		var formDataIsValid = scope.reader.formdata;
		
		$(files).each(function(index, element){
			if (formDataIsValid)
			formData.append('file', element);
			
			//preview file
			scope.previewfile(scope, element);
		});
		//post file to server
		scope.postFile(scope);
	};
	
	Plugin.prototype.getFormData = function(scope){
		return scope.reader.formdata ? new FormData() : null;
	};
	
	Plugin.prototype.postFile = function(scope){
		// now post a new XHR request
		if (scope.reader.formdata) {
			var xhr = new XMLHttpRequest();
			xhr.open('POST', scope.options.uploadPath);
			xhr.onload = function() {
				scope.progress.value = scope.progress.innerHTML = 100;
			};

			if (scope.reader.progress) {
				xhr.upload.onprogress = function(event) {
					if (event.lengthComputable) {
						var complete = (event.loaded / event.total * 100 | 0);
						scope.progress.value = scope.progress.innerHTML = complete;
					}
				};
			}

			xhr.send(scope.reader.formdata);
		}
	};

	// A really lightweight plugin wrapper around the constructor,
	// preventing against multiple instantiations
	$.fn[pluginName] = function(options) {
		return this.each(function() {
			if (!$.data(this, 'plugin_' + pluginName)) {
				$.data(this, 'plugin_' + pluginName, new Plugin(this, options));
			}
		});
	};
	//init all carousel objects on page automatically -> TBR
	$(window).load(function() {
		$(".image-uploader").imageuploader();
	});
})(jQuery, window, document);
