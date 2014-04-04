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
		$.each(socnet_json.shareThis, function(idx, obj) {
			if(obj.country == country)  {
				country_found = true;
				addShareThisButtons(obj, share_url, page_title, page_desc);
				return false;
			}
		});
		// use the default set if country specific is not found
		if (!country_found) {
			addShareThisButtons(socnet_json.defaultConfig, share_url, page_title, page_desc);
		}
	});    	
	
	function addShareThisButtons(obj,url,title,desc) { 
		var socnet1 = obj.socialNetwork1.toString().toLowerCase();
		var socnet2 = obj.socialNetwork2.toString().toLowerCase();
		
		$(".shareicons ul .email-bubble").after("<li class='btn-bubble'>" + 
				"<span class='btn-bubble-button st_" + socnet1 + "_large' displayText='" 
				+ socnet1 + "' st_url='" + url + "' st_title='" + title + "' st_summary='" + desc + "'>" +
				"<img class='btn-bubble-std' src='/etc/designs/tourismaustralia/clientlibs/img/icons/" + socnet1 + "_outline.png' alt=" + obj.socialNetwork1 + ">" +
				"<img class='btn-bubble-active' src='/etc/designs/tourismaustralia/clientlibs/img/icons/" + socnet1 + ".png' alt=" + obj.socialNetwork1 + ">" +
		"</span></li>");

		$(".shareicons ul .sharethis-bubble").before("<li class='btn-bubble'>" + 
				"<span class='btn-bubble-button st_" + socnet2 + "_large' displayText='" 
				+ socnet2 + "' st_url='" + url + "' st_title='" + title + "' st_summary='" + desc + "'>" +
				"<img class='btn-bubble-std' src='/etc/designs/tourismaustralia/clientlibs/img/icons/" + socnet2 + "_outline.png' alt=" + obj.socialNetwork2 + ">" +
				"<img class='btn-bubble-active' src='/etc/designs/tourismaustralia/clientlibs/img/icons/" + socnet2 + ".png' alt=" + obj.socialNetwork2 + ">" +
		"</span></li>");
		
		if (socnet1 == 'twitter' || socnet2 == 'twitter') {
			$(".st_twitter_large").attr('st_via', 'Australia');
		}
	}
	
});

