CQ_Analytics.ClientContextMgr.addListener("storesinitialize", function (e) {
    var telize = CQ_Analytics.StoreRegistry.getStores().telize;
    var country = ""; 
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
		
		var socnet_json = $.parseJSON(sharethis_json);
		var country_found = false;

		// try to find a country specific list of social networks
		$.each(socnet_json, function(idx, obj) {
			if(obj.country == country)  {
				country_found = true;
				addShareThisButton(obj, share_url, page_title, page_desc);
				return false;
			}
		});
		// use the default set if country specific is not found
		if (!country_found) {
			$.each(socnet_json, function(idx, obj) {
				if(obj.country == "default")  {
					addShareThisButton(obj, share_url, page_title, page_desc);
					return false;
				}
			});
		}
	});    	
	
	function addShareThisButton(obj,url,title,desc) { 
		var socnet = obj.types.split(',');
		var facebook_like_found = false;
		for(var i = 0; i < socnet.length; i++) { 
			var social_network = socnet[i].toLowerCase();
			if (social_network == 'fblike') {
				facebook_like_found = true;
				continue;
			}
			$(".shareicons ul").append("<li class='btn-bubble'>" + 
				"<span class='btn-bubble-button st_" + social_network + "_large' displayText='" 
					+ social_network + "' st_url='" + url + "' st_title='" + title + "' st_summary='" + desc + "'>" +
	            "<img class='btn-bubble-std' src='/etc/designs/tourismaustralia/clientlibs/img/icons/" + social_network + "_outline.png' alt='ShareThis icon'>" +
	            "<img class='btn-bubble-active' src='/etc/designs/tourismaustralia/clientlibs/img/icons/" + social_network + ".png' alt='ShareThis icon'>" +
				"</span></li>");
		}
		// add the Facebook Like button last as it is rendered differently and on a different row
		if (facebook_like_found) {
			$(".shareicons ul").append("<li class='social-fblike'>" +
				"<span class='st_fblike_large' displayText='Facebook Like' st_url='" + url +"'></span></li>");
		}
	}
	
});

