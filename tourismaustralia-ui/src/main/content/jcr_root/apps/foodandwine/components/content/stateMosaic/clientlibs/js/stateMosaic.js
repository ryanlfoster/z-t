

	$(document).ready(function(){
		var stateTag=$(".icon-map-black-active " ).text();
	    var catogoryArray=new Array();
	    var source   = $("#sample").html();
		     //alert(source);
			 $(document).on("click",'.category-input ', function(){
					var x=$(this).attr('id');
			        if($(this).is(":checked"))
			        {
			             var checked= $("label[for='"+x+"']").find(".category-title").text();
			            if($.inArray(checked, catogoryArray)===-1)
			            	catogoryArray.push(checked);
			        }
			        else
			        {
						var uncheked= $("label[for='"+x+"']").find(".category-title").text()
							catogoryArray.pop(uncheked);
			        }

			$.ajax({
				type : "POST",
				url : "${resource.path}.ccs.json",
				data : {
					stateTag : stateTag,
					catogoryArray:catogoryArray

				},
				success : function(msg) {
					var data;
					 data = JSON.stringify(msg);
					data=data.replace("[","");
					 data=data.replace("]","");
	               	 var obj=JSON.parse(data);

	               //var data={"title":"test","desc":"/testing/test"};
						alert("data "+data);
						 var template = Handlebars.compile(source);
						 //alert("template "+template(obj));
						 $(".mosaic").append(template(obj));
				}, 
				error : function(xhr) {
					console.log('there is some error');
				}
			});	


	     });	
			 
	});

