CQ_Analytics.ClientContextMgr.addListener("storesinitialize", function (e) {

	$('.shareThisFawHolder').each(function () { 
		$this = $(this);
		var share_url = $this.attr('data-shareUrl');
		var share_type = $this.attr('data-type');
		var share_key = $this.attr('data-accountId');
		
		stLight.options({ publisher: share_key });
		// var socnet_json = $.parseJSON(sharethis_json);
		var social_network = 'facebook';
		
		$this.append("<span id='st-btn-" + social_network + "'/>");
		stWidget.addEntry({
			"service": social_network,
			"element": document.getElementById('st-btn-' + social_network),
			"url": share_url,
			"title": "title",
			"type":"large",
			"text":"ShareThis",
			"image":"http://www.softicons.com/download/internet-icons/social-superheros-icons-by-iconshock/png/256/sharethis_hulk.png", // image TO BE SHARED
			"summary": "desc"
		});		
		
		var social_network = 'twitter';
		
		$this.append("<span id='st-btn-" + social_network + "'/>");
		stWidget.addEntry({
			"service": social_network,
			"element": document.getElementById('st-btn-' + social_network),
			"url": share_url,
			"title": "title",
			"type":"large",
			"text":"ShareThis",
			"image":"http://www.softicons.com/download/internet-icons/social-superheros-icons-by-iconshock/png/256/sharethis_hulk.png", // image TO BE SHARED
			"summary": "desc"
		});		

		
	});    	
	
//	function addShareThisButton(obj,url,title,desc) { 
//		var socnet = obj.types.split(',');
//		for(var i = 0; i < socnet.length; i++) { 
//			var social_network = socnet[i].toLowerCase();
//			$this.append("<span id='st-btn-" + social_network + "'/>");
//			stWidget.addEntry({
//				"service": social_network,
//				"element": document.getElementById('st-btn-' + social_network),
//				"url": url,
//				"title": title,
//				"type":"large",
//				"text":"ShareThis" ,
//				"image":"http://www.softicons.com/download/internet-icons/social-superheros-icons-by-iconshock/png/256/sharethis_hulk.png", // image TO BE SHARED
//				"summary": desc
//			});		
//		}
//	}
	
	
});

