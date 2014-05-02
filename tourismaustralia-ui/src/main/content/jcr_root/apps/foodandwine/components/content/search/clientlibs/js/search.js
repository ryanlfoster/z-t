var counter = 1;
$(function() {
	var type = "grid";
	$(this).find('.mosaicgridchanger-grid-button').click(function() {
		type = "grid";
	});
	$(this).find('.mosaicgridchanger-list-button').click(function() {
		type = "list";
	});
	$(".type-spacing-120 .btn-secondary").hide();
	var queryParameter = getParameterByName("q");
	if (queryParameter != null) {
		interestedSearch(queryParameter);
	}
	$(".faw-hero-home-container .btn-secondary").click(function(e) {
		e.preventDefault();
		$(".mosaic").empty();
		var searchParameter = $(".input-field-blank").val();
		var source = $("#searchMosaic").html();
		$('#categoryDropdown').val("");
		$('#stateDropdown').val("");
		counter = 1;
		$.ajax({
			type : "GET",
			url : "/bin/fw/search",
			data : {
				searchParameter : searchParameter,
				counter : counter
			},
			success : function(msg) {
				var articleCount;
				for (var i = 0; i < msg.length; i++) {
					articleCount = msg[i].totalSearchCount;
				}

				var data;
				var obj;
				data = JSON.stringify(msg);
				data = data.replace(/\[/g, "");
				data = data.replace(/\]/g, "");
				data = "{searchResults:[" + data + "]}";
				obj = eval('(' + data + ')');
				obj.type = type;
				obj.isGrid = type == 'grid' ? true : false;
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
				$(".mosaic").empty();
				$(".mosaic").append(template(obj));
				if (articleCount === undefined) {
					articleCount = 0;
				}
				$(".faw-hero-home-container .form-h3").html("" + articleCount + " Search results for: <strong>" + searchParameter + "</strong>");

				if (articleCount <= 10) {
					$(".type-spacing-120 .btn-secondary").hide();
				} else {
					if (msg.length < 10) {
						// on final page of results
						$(".type-spacing-120 .btn-secondary").hide();
					} else {
						$(".type-spacing-120 .btn-secondary").show();
					}
				}
			},
			error : function(xhr) {
				console.log("in error");
			}
		});
	});
});

$(function() {
	var type = "grid";
	$(this).find('.mosaicgridchanger-grid-button').click(function() {
		type = "grid";
	});
	$(this).find('.mosaicgridchanger-list-button').click(function() {
		type = "list";
	});
	$(".type-spacing-120 .btn-secondary").click(function(e) {
		e.preventDefault();
		$(".mosaic").empty();
		var searchParameter = $(".input-field-blank").val();
		var category = $('#categoryDropdown').find('option:selected').val();
		var location = $('#stateDropdown').find('option:selected').val();
		counter = parseInt(counter) + 1;
		var source = $("#searchMosaic").html();
		$.ajax({
			type : "GET",
			url : "/bin/fw/search",
			data : {
				searchParameter : searchParameter,
				category : category,
				location : location,
				counter : counter
			},
			success : function(msg) {
				var data;
				var obj;
				var articleCount;
				for (var i = 0; i < msg.length; i++) {
					articleCount = msg[i].totalSearchCount;
				}
				data = JSON.stringify(msg);
				data = data.replace(/\[/g, "");
				data = data.replace(/\]/g, "");
				data = "{searchResults:[" + data + "]}";
				obj = eval('(' + data + ')');
				obj.type = type;
				obj.isGrid = type == 'grid' ? true : false;
				var template = Handlebars.compile(source);
				$(".mosaic").append(template(obj));
				if (articleCount === undefined) {
					articleCount = 0;
				}
				if (articleCount <= 10) {
					$(".type-spacing-120 .btn-secondary").hide();
				} else {
					if (msg.length < 10) {
						// on final page of results
						$(".type-spacing-120 .btn-secondary").hide();
					} else {
						$(".type-spacing-120 .btn-secondary").show();
					}
				}
			},
			error : function(xhr) {
				console.log("in error");
			}
		});
	});

	$("#categoryDropdown,#stateDropdown").change(function(e) {
		e.preventDefault();
		$(".mosaic").empty();
		var searchParameter = $(".input-field-blank").val();
		var category = $('#categoryDropdown').find('option:selected').val();
		var location = $('#stateDropdown').find('option:selected').val();
		counter = 1;
		var source = $("#searchMosaic").html();
		$.ajax({
			type : "GET",
			url : "/bin/fw/search",
			data : {
				searchParameter : searchParameter,
				category : category,
				location : location,
				counter : counter
			},
			success : function(msg) {
				var data;
				var obj;
				var articleCount;
				for (var i = 0; i < msg.length; i++) {
					articleCount = msg[i].totalSearchCount;
				}
				data = JSON.stringify(msg);
				data = data.replace(/\[/g, "");
				data = data.replace(/\]/g, "");
				data = "{searchResults:[" + data + "]}";
				obj = eval('(' + data + ')');
				obj.type = type;
				obj.isGrid = type == 'grid' ? true : false;
				var template = Handlebars.compile(source);
				$(".mosaic").append(template(obj));
				if (articleCount === undefined) {
					articleCount = 0;
				}
				if (articleCount <= 10) {
					$(".type-spacing-120 .btn-secondary").hide();
				} else {
					if (msg.length < 10) {
						// on final page of results
						$(".type-spacing-120 .btn-secondary").hide();
					} else {
						$(".type-spacing-120 .btn-secondary").show();
					}
				}
			},
			error : function(xhr) {
				console.log("in error");
			}
		});
	})
});

function getParameterByName(name) {
	name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
	var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"), results = regex.exec(location.search);
	return results == null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
}

function interestedSearch(listItem) {
	$(".faw-hero-home-container .input-field-blank").val(listItem);
	$(".faw-hero-home-container .btn-secondary").trigger('click');
}

$(document).ready(function() {
	var queryParameter = getParameterByName("q");
	if (queryParameter != null && queryParameter != "") {
		interestedSearch(queryParameter);
	}
});
