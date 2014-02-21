CQ_Analytics.ClientContextMgr.addListener("storesinitialize", function(e) {
	var telize=CQ_Analytics.StoreRegistry.getStores().telize;

	if(telize && telize.data){
		var data=telize.data;
		var country=data.country;
		if(country === "United States"){
			country="United States Of America";
		}
		var state=data.region;
		var city=data.city;
	}		
	$('.appSearchHolder').each(function(){
		$this=$(this);
		$this.find('input[name="country"]').val(country);
		$this.find('input[name="state"]').val(state);
		$this.find('input[name="city"]').val(city);
		
		$this.find('form').submit(function(e){
			e.preventDefault();
			var data={
					country:$this.find('input[name="country"]').val(),
					state:$this.find('input[name="state"]').val(),
					city:$this.find('input[name="city"]').val()
			}
			
			$.getJSON($(this).attr("action"),data,function(data){
				var results=$this.find(".results");
                results.empty();
                data.forEach(function(spec){
					results.append("<div><h3>"+spec.personName+"</h3><div>"+spec.companyName+"</div><div>"+spec.phone+"</div></div>");
                });
			});
		});

		$this.find('form').submit();
	});
});
