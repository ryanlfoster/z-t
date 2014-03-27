

	$('.shareThisFawHolder').each(function () { 
		$this = $(this);
		var share_url = $this.attr('data-shareUrl');
		var share_type = $this.attr('data-type');
		var share_key = $this.attr('data-accountId');
		
		stLight.options({ publisher: share_key });
		var socnet_json = $.parseJSON(sharethis_json);

		$.each(socnet_json, function(idx, obj) {
			addShareThisButton(obj, share_url, page_title, page_desc);
		});

		var is_firefox = navigator.userAgent.toLowerCase().indexOf('firefox') > -1;
		var is_chrome = navigator.userAgent.toLowerCase().indexOf('chrome') > -1;
		if (is_firefox || is_chrome) {
			$(".faw-article-divider").hide();
			$(".faw-bookmark-icon").hide();
		}
	});    	
	
	$('.faw-bookmark-icon').click(function(e) {
		    e.preventDefault(); 
		    var bookmarkUrl = this.href;
		    var bookmarkTitle = this.title;

		    if (window.sidebar) { // For Mozilla Firefox Bookmark
		        window.sidebar.addPanel(bookmarkTitle, bookmarkUrl,"");
		    } else if( window.external || document.all) { // For IE Favorite
		        window.external.AddFavorite( bookmarkUrl, bookmarkTitle);
		    } else if(window.opera) { // For Opera Browsers
		        $("a.jQueryBookmark").attr("href",bookmarkUrl);
		        $("a.jQueryBookmark").attr("title",bookmarkTitle);
		        $("a.jQueryBookmark").attr("rel","sidebar");
		    } else { // for other browsers which does not support
		         alert('Your browser does not support this bookmark action');
		         return false;
		    }
	});	
	
	function addShareThisButton(obj,url,title,desc) { 
		var socnet = obj.types.split(',');
		for(var i = 0; i < socnet.length; i++) { 
			var social_network = socnet[i].toLowerCase();
			$("<span class='st_" + social_network + "_large'/>").insertBefore('.faw-article-divider');
			stWidget.addEntry({
				"service": social_network,
				"element": $('.st_' + social_network + '_large').get(1),
				"url": url,
				"title": title,
				"type":"large",
				"text":"ShareThis" ,
				"image":"http://www.softicons.com/download/internet-icons/social-superheros-icons-by-iconshock/png/256/sharethis_hulk.png", // image TO BE SHARED
				"summary": desc
			});		
		}
	}


