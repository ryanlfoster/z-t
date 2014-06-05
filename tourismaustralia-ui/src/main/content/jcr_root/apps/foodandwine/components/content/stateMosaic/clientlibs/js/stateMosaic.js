$(document).ready(function() {
	
	$('.stateMosaic').each(function() {
		var currentXhr;
		var count=0;
		$this = $(this);
		$this.find(".btn-secondary").hide();
		$this.find(".mosaicgridchanger").hide();
		var stateTag = "";
		var catogoryArray = new Array();
		var source = $("#stateMosaic").html();
		var resourcePath = "/bin/fw/statemosaic.json";
		var pageTemplate = $this.find(".page").attr('name');
		if(pageTemplate!="homepage") {
			stateTag=$this.find('input[name="currentPage"]').val();
		}
		var messageText=$this.find(".message").val();
		var type="grid";
		$(this).find('.mosaicgridchanger-grid-button').click(function() {
			type="grid";
		});
		$(this).find('.mosaicgridchanger-list-button').click(function() {
			type="list";
		});
		
		$('.category-input-small').on('change', function(e) {
			count=0;
			$this.find(".mosaic").empty();
			$this.find(".btn-secondary").hide();
			$this.find(".mosaicgridchanger").hide();
			e.preventDefault();
			var category = $(this).val();
			var flag = "default";
			catogoryArray.length = 0;
			catogoryArray.push(category);
			if(currentXhr) {
				currentXhr.abort();
			}
			currentXhr=$.ajax({
				type : "GET",
				url : resourcePath,
				dataType : "json",
				data : {
					stateTag : stateTag,
					catogoryArray : catogoryArray,
					flag : flag,
					pageTemplate : pageTemplate
				},
				success : function(msg) {
					count+=msg.length;
					var text = msg.length;
					if (msg.length === 0) {
						$this.find(".mosaic").append("<br/><h4 class='faw-article-healdine'>"+messageText+"</h4>");
						$(".mosaicgridchanger").hide();
					}
					if(msg.length!=0) {
						if (msg[0].totalResults > count) {
							$this.find(".btn-secondary").show();
						} else {
							$this.find(".btn-secondary").hide();
						}
					}
					var data = JSON.stringify(msg);
					data = data.replace("[", "");
					data = data.replace("]", "");
					data = "{test:[" + data + "]}";
					var obj = eval('(' + data + ')');
					obj.type= type;
					obj.isGrid=type == 'grid' ? true : false;
					Handlebars.registerHelper('compare', function(lvalue, rvalue, options) {
						if (arguments.length < 3) {
							throw new Error("Handlerbars Helper 'compare' needs 2 parameters");
						}
						operator = options.hash.operator || "==";
						var operators = {
							'==' : function(l, r) {
								return l == r;
							},
							'===' : function(l, r) {
								return l === r;
							},
							'!=' : function(l, r) {
								return l != r;
							},
							'<' : function(l, r) {
								return l < r;
							},
							'>' : function(l, r) {
								return l > r;
							},
							'<=' : function(l, r) {
								return l <= r;
							},
							'>=' : function(l, r) {
								return l >= r;
							},
							'typeof' : function(l, r) {
								return typeof l == r;
							}
						}

						if (!operators[operator]) {
							throw new Error("Handlerbars Helper 'compare' doesn't know the operator " + operator);
						}
						var result = operators[operator](lvalue, rvalue);
						if (result) {
							return options.fn(this);
						} else {
							return options.inverse(this);
						}
					});

					Handlebars.registerHelper('showOverlay', function(templateName, hasDefaultImage, options) {
						return !(templateName == "twitter" && hasDefaultImage) ? options.fn(this) : options.inverse(this);
					});

					var template = Handlebars.compile(source);
					$this.find(".mosaic").append(template(obj));
				},
				error : function(xhr) {
					console.log('Error in stateMosaic category-input-small onChange event');
				}
			});
		});
		
		$(document).on("click", '.category-input ', function() {
			count=0;
			$this.find(".mosaic").empty();
			$this.find(".btn-secondary").hide();
			$this.find(".mosaicgridchanger").hide();
			var flag = "default";
			var x = $(this).attr('id');
			if ($(this).is(":checked")) {
				var checked = $(this).attr('value');
				if ($.inArray(checked, catogoryArray) === -1) {
					catogoryArray.push(checked);
				}
			} else {
				var uncheked = $(this).attr('value');
				if ($.inArray(uncheked, catogoryArray) !== -1)
					catogoryArray = jQuery.grep(catogoryArray, function(value) {
						return value != uncheked;
					});
			}
			if(currentXhr){
				currentXhr.abort();
			}
			currentXhr=$.ajax({
				type : "GET",
				url : resourcePath,
				dataType : "json",
				data : {
					stateTag : stateTag,
					catogoryArray : catogoryArray,
					flag : flag,
					pageTemplate : pageTemplate

				},
				success : function(msg) {
					count+=msg.length;
					var text = msg.length;
					$(".mosaicgridchanger").show();
					if (msg.length === 0){
						$this.find(".mosaic").append("<h3 class='faw-article-healdine'>"+messageText+"</h3>");
						$(".mosaicgridchanger").hide();
					}
					if(msg.length!=0){
						if (msg[0].totalResults > count)
							$this.find(".btn-secondary").show();
						else
							$this.find(".btn-secondary").hide();
					}
					var data = JSON.stringify(msg);
					data = data.replace("[", "");
					data = data.replace("]", "");
					data = "{test:[" + data + "]}";
					var obj = eval('(' + data + ')');
					obj.type= type;
					obj.isGrid=type == 'grid' ? true : false;
					Handlebars.registerHelper('compare', function(lvalue, rvalue, options) {
						if (arguments.length < 3){
							throw new Error("Handlerbars Helper 'compare' needs 2 parameters");
						}
						operator = options.hash.operator || "==";
						var operators = {
							'==' : function(l, r) {
								return l == r;
							},
							'===' : function(l, r) {
								return l === r;
							},
							'!=' : function(l, r) {
								return l != r;
							},
							'<' : function(l, r) {
								return l < r;
							},
							'>' : function(l, r) {
								return l > r;
							},
							'<=' : function(l, r) {
								return l <= r;
							},
							'>=' : function(l, r) {
								return l >= r;
							},
							'typeof' : function(l, r) {
								return typeof l == r;
							}
						}
						if (!operators[operator]){
							throw new Error("Handlerbars Helper 'compare' doesn't know the operator " + operator);
						}
						var result = operators[operator](lvalue, rvalue);
						if (result) {
							return options.fn(this);
						} else {
							return options.inverse(this);
						}
					});
					Handlebars.registerHelper('showOverlay', function(templateName, hasDefaultImage, options) {
						return !(templateName == "twitter" && hasDefaultImage) ? options.fn(this) : options.inverse(this);
					});
					var template = Handlebars.compile(source);
					$this.find(".mosaic").append(template(obj));
				},
				error : function(xhr) {
					console.log('there is some error');
				}
			});
		});
		var flag = "default";
		if(currentXhr){
			currentXhr.abort();
		}
		count=0;
		currentXhr=$.ajax({
			type : "GET",
			url : resourcePath,
			dataType : "json",
			data : {
				stateTag : stateTag,
				catogoryArray : catogoryArray,
				flag : flag,
				pageTemplate : pageTemplate

			},
			success : function(msg) {
				count+=msg.length;
				$(".mosaicgridchanger").show();
				var text = msg.length;
				if (msg.length === 0){
					$this.find(".mosaic").append("<h3 class='faw-article-healdine'>"+messageText+"</h3>");
					$(".mosaicgridchanger").hide();
				}
				
				if(msg.length!=0){
					if (msg[0].totalResults > count){
						$this.find(".btn-secondary").show();
						
					}
					else{
						$this.find(".btn-secondary").hide();
					}
				}	
				var data = JSON.stringify(msg);
				data = data.replace("[", "");
				data = data.replace("]", "");
				data = "{test:[" + data + "]}";
				var obj = eval('(' + data + ')');
				obj.type= type;
				obj.isGrid=type == 'grid' ? true : false;
				Handlebars.registerHelper('compare', function(lvalue, rvalue, options) {
					if (arguments.length < 3){
						throw new Error("Handlerbars Helper 'compare' needs 2 parameters");
					}
					operator = options.hash.operator || "==";
					var operators = {
						'==' : function(l, r) {
							return l == r;
						},
						'===' : function(l, r) {
							return l === r;
						},
						'!=' : function(l, r) {
							return l != r;
						},
						'<' : function(l, r) {
							return l < r;
						},
						'>' : function(l, r) {
							return l > r;
						},
						'<=' : function(l, r) {
							return l <= r;
						},
						'>=' : function(l, r) {
							return l >= r;
						},
						'typeof' : function(l, r) {
							return typeof l == r;
						}
					}
					if (!operators[operator]){
						throw new Error("Handlerbars Helper 'compare' doesn't know the operator " + operator);
					}
					var result = operators[operator](lvalue, rvalue);
					if (result) {
						return options.fn(this);
					} else {
						return options.inverse(this);
					}
				});
				Handlebars.registerHelper('showOverlay', function(templateName, hasDefaultImage, options) {
					return !(templateName == "twitter" && hasDefaultImage) ? options.fn(this) : options.inverse(this);
				});
				var template = Handlebars.compile(source);
				$this.find(".mosaic").append(template(obj));
			},
			error : function(xhr) {
				console.log('there is some error');
			}
		});

		$this.find(".btn-secondary ").click(function() {
			var flag = "showMore";
			if(currentXhr){
				currentXhr.abort();
			}
			$(".btn-secondary").hide();
			currentXhr=$.ajax({
				type : "GET",
				url : resourcePath,
				dataType : "json",
				data : {
					stateTag : stateTag,
					catogoryArray : catogoryArray,
					start : count,
				},
				success : function(msg) {
					count+=msg.length;
					$(".mosaicgridchanger").show();
					if (msg[0].totalResults > count){
						$(".btn-secondary").show();
					}
					var data = JSON.stringify(msg);
					data = data.replace("[", "");
					data = data.replace("]", "");
					data = "{test:[" + data + "]}";
					var obj = eval('(' + data + ')');
					obj.type= type;
					obj.isGrid= type == 'grid' ? true : false;
					var template = Handlebars.compile(source);
					$("#statemosaic").append(template(obj));
				}
			});
		});
	});
});