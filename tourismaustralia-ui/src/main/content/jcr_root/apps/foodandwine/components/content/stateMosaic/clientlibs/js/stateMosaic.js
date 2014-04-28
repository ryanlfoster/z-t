$(document).ready(function() {
	$('.stateMosaic').each(function() {
		$this = $(this);
		$this.find(".btn-secondary").hide();
		$this.find(".mosaicgridchanger").hide();
		var stateTag = $this.find(".icon-map-black-active ").text();
		var catogoryArray = new Array();
		var source = $("#stateMosaic").html();
		var register = $this.find(".register").html();
		var resourcePath = $this.find(".resourcePath").val();
		var pageTemplate = $this.find(".page").attr('name');
		var type="grid";
		$(this).find('.mosaicgridchanger-grid-button').click(function(){
			type="grid";
		});
		$(this).find('.mosaicgridchanger-list-button').click(function(){
			type="list";
		});
		$(document).on("click", '.category-input ', function() {
			$this.find(".mosaic").empty();
			$this.find(".btn-secondary").hide();
			$this.find(".mosaicgridchanger").hide();
			var flag = "default";
			var x = $(this).attr('id');
			if ($(this).is(":checked")) {
				var checked = $(this).attr('value');
				if ($.inArray(checked, catogoryArray) === -1)
					catogoryArray.push(checked);
			} else {
				var uncheked = $(this).attr('value');
				if ($.inArray(uncheked, catogoryArray) !== -1)
					catogoryArray = jQuery.grep(catogoryArray, function(value) {
						return value != uncheked;
					});
			}
			$.ajax({
				type : "GET",
				url : resourcePath + ".ccs.json",
				dataType : "json",
				data : {
					stateTag : stateTag,
					catogoryArray : catogoryArray,
					flag : flag,
					register : register,
					pageTemplate : pageTemplate

				},
				success : function(msg) {
					var text = msg.length;
					if (msg.length === 0)
						$this.find(".mosaic").append("<h3 class='faw-article-healdine'>There are no articles for selected tag(s)</h3>");
					$(".mosaicgridchanger").show();
					if (msg[0].totalResults > 10)
						$this.find(".btn-secondary").show();
					else
						$this.find(".btn-secondary").hide();

					var data = JSON.stringify(msg);
					data = data.replace("[", "");
					data = data.replace("]", "");
					data = "{test:[" + data + "]}";
					var obj = eval('(' + data + ')');
					obj.type= type;
					obj.isGrid=type == 'grid' ? true : false;
					Handlebars.registerHelper('compare', function(lvalue, rvalue, options) {
						if (arguments.length < 3)
							throw new Error("Handlerbars Helper 'compare' needs 2 parameters");
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
						if (!operators[operator])
							throw new Error("Handlerbars Helper 'compare' doesn't know the operator " + operator);
						var result = operators[operator](lvalue, rvalue);
						if (result) {
							return options.fn(this);
						} else {
							return options.inverse(this);
						}
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
		$.ajax({
			type : "GET",
			url : resourcePath + ".ccs.json",
			dataType : "json",
			data : {
				stateTag : stateTag,
				catogoryArray : catogoryArray,
				flag : flag,
				register : register,
				pageTemplate : pageTemplate

			},
			success : function(msg) {
				var text = msg.length;
				if (msg.length === 0)
					$this.find(".mosaic").append("<h3 class='faw-article-healdine'>There are no articles for selected tag(s)</h3>");
				$(".mosaicgridchanger").show();
				if (msg[0].totalResults > 10)
					$this.find(".btn-secondary").show();
				else
					$this.find(".btn-secondary").hide();

				var data = JSON.stringify(msg);
				data = data.replace("[", "");
				data = data.replace("]", "");
				data = "{test:[" + data + "]}";
				var obj = eval('(' + data + ')');
				obj.type= type;
				obj.isGrid=type == 'grid' ? true : false;
				Handlebars.registerHelper('compare', function(lvalue, rvalue, options) {
					if (arguments.length < 3)
						throw new Error("Handlerbars Helper 'compare' needs 2 parameters");
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
					if (!operators[operator])
						throw new Error("Handlerbars Helper 'compare' doesn't know the operator " + operator);
					var result = operators[operator](lvalue, rvalue);
					if (result) {
						return options.fn(this);
					} else {
						return options.inverse(this);
					}
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
			$.ajax({
				type : "GET",
				url : resourcePath+".ccs.json",
				dataType : "json",
				data : {
					stateTag : stateTag,
					catogoryArray : catogoryArray,
					flag : flag
				},
				success : function(msg) {
					$(".mosaicgridchanger").show();
					if (msg[0].totalResults <= 10)
						$(".btn-secondary").hide();
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