var counter = 1;
$(function() {
$(".type-spacing-120 .btn-secondary").hide();
$(".faw-hero-home-container .btn-secondary").click(function(){ 
var searchParameter = $(".input-field-blank").val();
var source = $("#searchMosaic").html();
var category = $('#categoryDropdown').find('option:selected').val();
var location = $('#stateDropdown').find('option:selected').val();
        counter = 1;
		$.ajax({
        type : "POST",
        url : "/bin/searchservlet/posteddata",
        data : {
        	searchParameter : searchParameter,
        	category : category,
        	location : location,
        	counter : counter
        },
        success : function(msg) {
            var articleCount = msg.length;
           var data;
           var obj;
           data = JSON.stringify(msg);
           data=data.replace(/\[/g,"");
           data=data.replace(/\]/g,"");
           data="{searchResults:["+data+"]}";
           obj=eval('('+data+')');
			Handlebars.registerHelper('compare', function(lvalue, rvalue, options) {
			    if (arguments.length < 3)
       			throw new Error("Handlerbars Helper 'compare' needs 2 parameters");
   			operator = options.hash.operator || "==";
			    var operators = {
			        '==':       function(l,r) { return l == r; },
			        '===':      function(l,r) { return l === r; },
			        '!=':       function(l,r) { return l != r; },
			        '<':        function(l,r) { return l < r; },
			        '>':        function(l,r) { return l > r; },
			        '<=':       function(l,r) { return l <= r; },
			        '>=':       function(l,r) { return l >= r; },
			        'typeof':   function(l,r) { return typeof l == r; }
			    }
			    if (!operators[operator])
			        throw new Error("Handlerbars Helper 'compare' doesn't know the operator "+operator);
   			var result = operators[operator](lvalue,rvalue);
   			if( result ) {
       			return options.fn(this);
			    } else {
			        return options.inverse(this);
			    }
			});   
			var template = Handlebars.compile(source);
			$(".mosaic").empty();
            $(".mosaic").append(template(obj));
            $(".faw-hero-home-container .form-h3").html(""+articleCount+" Search results for: <strong>"+searchParameter+"</strong>");

            if(articleCount >10){
            	$(".type-spacing-120 .btn-secondary").show();
            }
        },
        error : function(xhr) {
            console.log("in error");
        }
    });
	});
});


$(function() {

$(".type-spacing-120 .btn-secondary").click(function(){ 
var searchParameter = $(".input-field-blank").val();
var category = $('#categoryDropdown').find('option:selected').val();
var location = $('#stateDropdown').find('option:selected').val();
counter = parseInt(counter) + 1;
var source = $("#searchMosaic").html();
		$.ajax({
        type : "POST",
        url : "/bin/searchservlet/posteddata",
        data : {
        	searchParameter : searchParameter,
        	category : category,
        	location : location,
        	counter : counter
        },
        success : function(msg) {
        	 var data;
             var obj;
            var articleCount = msg.length;
             data = JSON.stringify(msg);
             data=data.replace(/\[/g,"");
           	 data=data.replace(/\]/g,"");
             data="{searchResults:["+data+"]}";
             obj=eval('('+data+')');
             var template = Handlebars.compile(source);
             $(".mosaic").append(template(obj));
            $(".faw-hero-home-container .form-h3").html(""+articleCount+" Search results for: <strong>"+searchParameter+"</strong>");
        },
        error : function(xhr) {
            console.log("in error");
        }
    });
	});
});





