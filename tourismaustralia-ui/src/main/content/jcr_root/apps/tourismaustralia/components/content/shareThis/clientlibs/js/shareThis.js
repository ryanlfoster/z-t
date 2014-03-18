CQ_Analytics.ClientContextMgr.addListener("storesinitialize", function (e) {
    var telize = CQ_Analytics.StoreRegistry.getStores().telize;
    var country = "en"; 
    if (telize && telize.data) {
        var data = telize.data;
        country = data.country;
        if (country === "United States") {
            country = "United States Of America";
        }
        var state = data.state;
        var city = data.city;
    }
	$('.shareThisHolder').each(function () { 
		$this = $(this);
		var share_url = $this.attr('data-shareUrl');
		var share_type = $this.attr('data-type');
		var share_key = $this.attr('data-accountId');
		
		if (share_type=='share') {
		    $.getJSON("/bin/favorites/share/guid", function (data) {
		     	$this.attr('data-shareUrl', share_url.replace("{lang}", country).replace("{id}", data.shareId));
		    });
		}
		
		stLight.options({ publisher: share_key });
		var socnet_json = $.parseJSON(sharethis_json);
		
		alert('country' + country);
		
		$.each(socnet_json, function(idx, obj) {
			if (obj.country == 'default') {
				var socnet = obj.types.split(',');
				for(var i = 0; i < socnet.length; i++) { 
					var social_network = socnet[i].toLowerCase();
					$this.append("<span id='st-btn-" + social_network + "'/>");
					stWidget.addEntry({
						"service": social_network,
						"element": document.getElementById('st-btn-' + social_network),
						"url":"http://sharethis.com",
						"title":"sharethis",
						"type":"large",
						"text":"ShareThis" ,
						"image":"http://www.softicons.com/download/internet-icons/social-superheros-icons-by-iconshock/png/256/sharethis_hulk.png", // image TO BE SHARED
						"summary":"this is the share button for " + social_network 
					});		
				}
			}
		});
	});    	
});

