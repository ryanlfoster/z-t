
$(document).ready(function(){
	 $(".btn-secondary").hide();
	 $(".mosaicgridchanger").hide();
	var stateTag=$(".icon-map-black-active " ).text();
    var catogoryArray=new Array();
    var source   = $("#stateMosaic").html();
		 $(document).on("click",'.category-input ', function(){
			 $(".mosaic").empty();
             var flag="default";
			 var x=$(this).attr('id');
		     if($(this).is(":checked"))
	         {
	             var checked=$(this).attr('value');//$("label[for='"+x+"']").find(".category-title").text();
	             alert(checked);
	             if($.inArray(checked, catogoryArray)===-1)
	            	catogoryArray.push(checked);
	         }
	         else
	         {
				var uncheked= $(this).attr('value');//$("label[for='"+x+"']").find(".category-title").text()
				if($.inArray(uncheked, catogoryArray)!==-1)
                    catogoryArray = jQuery.grep(catogoryArray, function(value) {
						 return value != uncheked;
					});
	         }
			 $.ajax({
             type : "POST",
			 url : "${resource.path}.ccs.json",
             dataType:"json",
			 data : {
				 stateTag : stateTag,
				 catogoryArray:catogoryArray,
                 flag:flag
			 },
			 success : function(msg) {
				 //alert(msg.length);
				 $(".mosaicgridchanger").show();
        		if(msg.length>=10)
						$(".btn-secondary").show();
        		else
        			$(".btn-secondary").hide();
                var data;
                 var obj;
                data = JSON.stringify(msg);
                data=data.replace("[","");
                data=data.replace("]","");
      			//alert(data);
                data="{test:["+data+"]}";
                //alert(data);
                var obj=eval('('+data+')');
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
					 //alert("template "+template(obj));
				$(".mosaic").append(template(obj));
			}, 
			error : function(xhr) {
				console.log('there is some error');
			}
		});	
     });
     	$(".btn-secondary ").click(function(){
        	
			//$(".mosaic").empty();
        	var flag="showMore";
			$.ajax({
	            type : "POST",
				url : "${resource.path}.ccs.json",
	            dataType:"json",
				data : {
					stateTag : stateTag,
	                catogoryArray:catogoryArray,
	                flag:flag
	
				},
				success : function(msg) {
					
					$(".mosaicgridchanger").show();
					if(msg.length<10)
						$(".btn-secondary").hide();
	                var data;
	                var obj;
	                data = JSON.stringify(msg);
	                //alert(data);
	                data=data.replace("[","");
	                data=data.replace("]","");
	                //alert(data);
	                data="{test:["+data+"]}";
	                //alert(data);
	                var obj=eval('('+data+')');
	                var template = Handlebars.compile(source);
						//alert("template "+template(obj));
	                
					$(".mosaic").append(template(obj));
	            }
        });
    });
});
